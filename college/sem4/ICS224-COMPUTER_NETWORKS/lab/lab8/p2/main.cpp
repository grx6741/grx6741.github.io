#include <iostream>
#include <cstdint>
#include <cstring>
#include <cmath>
#include <vector>

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
		num += (bin_str[n - i - 1] - '0') * std::pow(2, i);
	}
	return num;
}

int get_first_1(uint16_t num) {
	int j = 8 * sizeof(uint16_t);
	while ((num & (int)std::pow(2, j-1)) == 0) {
		j--;
	}
	//printf("%d\n", j);
	return j;
}

std::vector<char> get_input() {
	return {1,0,0,1,1,0,1,1,1,0,0};
}

std::vector<char> construct(std::vector<char> input) {
	std::vector<char> ret(input.size() + (int)std::log2(input.size()));
	int j = 0;
	int i = 0;
	while (j < input.size()) {
		if (i == 0) continue;
		if (std::ceil(std::log2(i)) == std::floor(std::log2(i))) {
			ret[i] = 0;
			continue;
		}
		ret[i++] = input[j++];
	}
	return ret;
}

template<typename T>
void print(std::vector<T> vec) {
	for (T a : vec) std::cout << (int)a << " ";
	std::cout << std::endl;
}

int main() {
	std::vector<char> input = get_input();
	std::vector<char> constructed = construct(input);
	print(input);
	print(constructed);
}
