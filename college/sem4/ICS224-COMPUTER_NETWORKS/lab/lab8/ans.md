# ICS 224 COMPUTER NETWORKS

## Gowrish I 2022BCS0155

1. Write the C/C++ Program to implement Cyclic Redundancy Check (CRC) technique to detect error during the message transmission from sender to receiver.

```c
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
	int i = 0;
	while (log2(dividend) + 1 > 4) {
		//printf("Iter: %d\n", i++);
		rem = ((dividend & mask) ^ divisor) | (~mask & dividend);
		if (!rem) break;
		//LOG_BIN(rem);
		int first_rem = get_first_1(rem);
		int first_mask = get_first_1(mask);

		mask >>= first_mask - first_rem;
		divisor >>= abs(first_mask - first_rem);

		//LOG_BIN(mask);
		//LOG_BIN(divisor);

		dividend = rem;
		//printf("----------\n");
	}
	// LOG_BIN(rem);
	return rem;
}

int main() {
	uint16_t data = get_dividend();
	uint16_t divisor = get_divisor();

	printf("Data: \t\t\t\t\t\t");
	LOG_BIN(data);
	printf("Divisor: \t\t\t\t\t");
	LOG_BIN(divisor);

	uint16_t reminder = CRC_reminder(data , divisor);
	printf("Remainder: \t\t\t\t\t");
	LOG_BIN(reminder);

	// Adding reminder to data
	uint16_t data_sent = (data << (int)(log2(divisor))) | (int)reminder;
	printf("At reciever side, recieved data: \t\t");
	LOG_BIN(data_sent);

	// At reciever side
	uint16_t recieved_data = data_sent;
	reminder = CRC_reminder(recieved_data, divisor);
	printf("Reminder calculated at reciever side: \t\t");
	LOG_BIN(reminder);

	if (reminder == 0)
		printf("Message is not Corrupted\n\t\t");
	else
		printf("Message is Corrupted\n\t\t");
}

```

```console
Data: 						                0000000001100110
Divisor: 					                0000000000001101
Remainder: 					                0000000000000010
At reciever side, recieved data: 		    0000001100110010
Reminder calculated at reciever side: 		0000000000000000
Message is not Corrupted
------------------------------------------------------------
Data: 						                0000000001100110
Divisor: 					                0000000000001101
Remainder: 					                0000000000000010
At reciever side, recieved data: 		    0000001110110010
Reminder calculated at reciever side: 		0000000000001000
Message is Corrupted
```

2. Write the C/C++ Program to implement Hamming code algorithm to detect and correct the error in the transmitted data.

```cpp
#include <iostream>
#include <vector>
#include <cmath>

int main() {
    std::vector<int> data = {1, 0, 0, 1, 1, 0, 1, 1, 1, 0, 0};
    std::vector<int> powers_of_2;
    for (int i = 0; i < 10; ++i) {
        powers_of_2.push_back(pow(2, i));
    }

    for (int i = 0; i < data.size(); ++i) {
        if (std::find(powers_of_2.begin(), powers_of_2.end(), i) != powers_of_2.end() || i == 0) {
            data.insert(data.begin() + i, 0);
        }
    }

    int i = 1;
    while (i < data.size()) {
        int n = static_cast<int>(floor(log2(i)));
        for (int j = 0; j < data.size(); ++j) {
            if ((j >> n) & 1) {
                data[i] ^= data[j];
            }
        }
        i *= 2;
    }

	// Extended Hamming Code
	for (int i = 0; i < data.size(); i++) {
		data[0] ^= data[i];
	}

    int error = 0;
    for (int num : data) {
        if (num == 1) {
            error ^= num;
        }
    }

    if (data.size() % 2 == 0 && error != 0) {
        std::cout << "2 bit error" << std::endl;
    } else if (data.size() % 2 != 0) {
        std::cout << "Error @ " << error << std::endl;
        data[error] = !data[error];
        std::cout << "Corrected: \t";
        for (int num : data) {
            std::cout << num << " ";
        }
        std::cout << std::endl;
    }

    return 0;
}
```

```console
Test case 1: 
No Error Detected

Test case 1: 
Error @ 4
Corrected: 1111100101011100

Test case 3: 
2 bit error
```
