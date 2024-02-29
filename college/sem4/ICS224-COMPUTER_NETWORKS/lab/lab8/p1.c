#include <stdio.h>
#include <stdlib.h>
#include <stdint.h>
#include <string.h>
#include <math.h>

#define LOG_BIN(x) printf("%s\n", bin_to_str((x)))

char* bin_to_str(uint16_t num) {
	uint16_t n = num;
	int size = 8 * sizeof(uint16_t);
	char* bin_str = (char*)malloc(size + 1);
	for (int i = 0; i < size; i++) {
		bin_str[size - i - 1] = '0' + (n % 2);
		n /= 2;
	}
	bin_str[size] = '\0';
	return bin_str;
}

int str_to_bin(char* bin_str) {
	int num = 0;
	int n = strlen(bin_str);
	for (int i = 0; i < n; i++) {
		num += (bin_str[n - i - 1] - '0') * pow(2, i);
	}
	return num;
}

uint16_t get_divisor() {
	return str_to_bin("1101");
}

uint16_t get_dividend() {
	return str_to_bin("1100110");
}

int get_first_1(uint16_t num) {
	int j = 8 * sizeof(uint16_t);
	while ((num & (int)pow(2, j-1)) == 0) {
		j--;
	}
	//printf("%d\n", j);
	return j;
}

uint16_t CRC_reminder(uint16_t dividend, uint16_t divisor) {
	uint16_t mask_size = log2(divisor) + 1; // bits in 10011
	int initial_dividend_size = (int)log2(dividend);

	uint16_t mask = pow(2, mask_size) - 1;
	//mask <<= (8 * sizeof(uint16_t) - mask_size);
	//dividend <<= (8 * sizeof(uint16_t) - (initial_dividend_size + 1));
	//divisor <<= (8 * sizeof(uint16_t) - mask_size);
	dividend <<= (mask_size - 1);
	mask <<= (int)(log2(dividend) - log2(divisor)) + 1;
	divisor <<= (int)(log2(dividend) - log2(divisor)) + 1;


	// LOG_BIN(dividend);
	// LOG_BIN(divisor);
	// LOG_BIN(mask);

	uint16_t MASK = mask;
	uint16_t DIV = divisor;

	uint16_t rem;
	// for (int i = 0; i < (int)log2(dividend) + mask_size - 1; i++) {
	while (log2(dividend) + 1 > 4) {
		// printf("Iter: %d\n", i);
		rem = ((dividend & mask) ^ divisor) | (~mask & dividend);
		// LOG_BIN(rem);
		int first_rem = get_first_1(rem);
		int first_mask = get_first_1(mask);

		mask >>= first_mask - first_rem;
		divisor >>= abs(first_mask - first_rem);

		// LOG_BIN(mask);
		// LOG_BIN(divisor);

		dividend = rem;
		//printf("----------\n");
	}
	// LOG_BIN(rem);
	return rem;
}

int main() {
	uint16_t data = get_dividend();
	uint16_t divisor = get_divisor();

	uint16_t reminder = CRC_reminder(data , divisor);
	LOG_BIN(reminder);

	// Adding reminder to data
	LOG_BIN(data);
	uint16_t data_sent = (data << (int)(log2(divisor) + 1)) | (int)remainder;
	LOG_BIN(data_sent);
}
