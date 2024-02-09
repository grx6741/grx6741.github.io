#include <iostream>
#include <cstdint>
#include <vector>
#include <utility>

namespace binary {
    char* to_binary(uint8_t num) {
        uint8_t num_of_bits = 8 * sizeof(num);
        char* bin_num = (char*)malloc(num_of_bits + 1);
        for (int i = 0; i < num_of_bits; i++) {
            //printf("%d", i);
            bin_num[num_of_bits - i - 1] = '0' + (num % 2);
            num /= 2;
        }
        bin_num[num_of_bits] = '\0';
        return bin_num;
    }

    void print_as_binary(uint8_t num) {
        char* bin = to_binary(num);
        std::cout << bin << std::endl;
    }

    uint8_t add(uint8_t num1, uint8_t num2) {
        uint8_t res = num1 + num2;
        if (res < num1 || res < num2) { // Overflow occurred
            res++;
        }
        return res;
    }

    uint8_t invert(uint8_t num) {
        int n = 8 * sizeof(num);
        for (int i = 0; i < n; i++)
            num = num ^ (1 << i);
        return num;
    }
}

class Packet {
public:
    std::vector<uint8_t> messages;
    void addMessage(uint8_t msg) {
        this->messages.push_back(msg);
    }

    void print(int index) {
        std::cout << "[Packet" << index << "]" << std::endl;
        for (int i = 0; i < this->messages.size(); i++) {
            char* bin = binary::to_binary(this->messages[i]);
            printf("[Message %d]:\t %d\t\t %s\n", i, (int)this->messages[i], bin);
        }
        std::cout << std::endl;
    }

    uint8_t calculate_check_sum() {
        uint8_t sum = 0;
        for (auto msg : this->messages) {
            sum = binary::add(sum, msg);
            //binary::print_as_binary(sum);
        }
        return binary::invert(sum);
    }

    void validate() {
        if (this->calculate_check_sum() == 0)
            std::cout << "Message is Correct" << std::endl;
        else
            std::cout << "Message is Corrupted" << std::endl;
    }
};

int main() {
    // Server side
    Packet p1, p2;
    uint8_t numbers[] = {153, 226, 36, 132};
    for (uint8_t num : numbers) {
        p1.addMessage(num);
        p2.addMessage(num);
    }
    p1.addMessage(p1.calculate_check_sum()); // 0b11011010
    p2.addMessage(0b11011011);

    p1.print(1);
    p2.print(2);

    p1.validate();
    p2.validate();
}
