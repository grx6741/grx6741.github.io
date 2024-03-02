#include <iostream>
#include <cstdint>
#include <cstring>
#include <cmath>
#include <vector>

#define LOG_BIN(x) printf("%s\n", bin_to_str((x)))
#define LOG_BIN_STR(x) printf("%s\n", (x))
#define LOG_NUM(x, text) printf("%s : %d\n", (text), (x))
#define USIZE (8 * sizeof(uint16_t))

char* bin_to_str(uint16_t num) {
	uint16_t n = num;
	int size = USIZE;
	char* bin_str = (char*)malloc(size + 1);
	for (int i = 0; i < size; i++) {
		bin_str[size - i - 1] = '0' + (n % 2);
		n /= 2;
	}
	bin_str[size] = '\0';
	return bin_str;
}

uint16_t str_to_bin(const char* bin_str) {
	uint16_t num = 0;
	int n = strlen(bin_str);
	for (int i = 0; i < n; i++) {
		num += (bin_str[n - i - 1] - '0') * pow(2, i);
	}
	return num;
}

int get_first_1(uint16_t num) {
	int j = USIZE;
	while ((num & (int)pow(2, j-1)) == 0) {
		j--;
	}
	//printf("%d\n", j);
	return j;
}

std::vector<int> get_input() {
	std::vector<int> vec = {1, 0, 0, 1, 1, 0, 1, 1, 1, 0};
	return vec;
}

void construct(std::vector<int>& data) {
	int i = 0;
	while (i < data.size()) {
		if (i == 0 || ceil(log2(i)) == floor(log2(i))) {
			data.insert(data.begin() + i, 0);
		}
		i++;
	}
}

void compute_hamming_parities(std::vector<int>& data) {
	for (int i = 1; i < data.size(); i *= 2) {
		int n = floor(log2(i));
		for (int j = 1; j < data.size(); j++) {
			if ((1 << n) & j) data[i] ^= data[j];
		}
	}
	// Extended Hamming Code parity bit in 0th index
	for (int i = 1; i < data.size(); i++) {
		data[0] ^= data[i];
	}
}

int check_hamming_data(std::vector<int> data) {
	int error_index = 0;
	for (int i = 0; i < data.size(); i++) {
		if (data[i] == 1) error_index ^= i;
		i++;
	}
	return error_index;
}

template<typename T>
void print_vector(std::vector<T> vec, const char* LOG) {
	std::cout << "[" << LOG << "]: ";
	for (T a : vec) {
		std::cout << a;
	}
	std::cout << std::endl;
}

int main() {
	std::vector<int> input = get_input();
	print_vector(input, "Before Processing");
	construct(input);
	compute_hamming_parities(input);
	print_vector(input, "Computed Parities");

	// At reciever side;
	std::vector<int> rec = input;
	std::cout << check_hamming_data(input);
}
