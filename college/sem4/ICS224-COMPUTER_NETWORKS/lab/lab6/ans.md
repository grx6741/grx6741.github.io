# ICS224 COMPUTER NETWORKS LAB 6

## Gowrish I 2022BCS0155

```c
#include <stdio.h>
#include <math.h>
#include <stdint.h>
#include <stdlib.h>

typedef struct {
	uint32_t msg;
	int parity;
} sMessage;

typedef struct {
	sMessage* messages;
	uint32_t count;
	uint32_t parity;
} sMessageBlock;

#ifdef MESSAGE_IMPLEMENTATION
char* to_binary(uint32_t num) {
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

void print_message(sMessage smsg, int index) {
	uint16_t msg = smsg.msg;
	char* bin_num = to_binary(msg);
	printf("[Message %d]:\t%s\t[Parity]:\t%d\n", index, bin_num, smsg.parity);
}

void print_message_block(sMessageBlock msg_blk) {
	int n = msg_blk.count;
	for (int i = 0; i < n; i++) {
		print_message(msg_blk.messages[i], i);
		//printf("%d\n", msg_blk.messages[i].parity);
	}
	char* bin_num = to_binary(msg_blk.parity);
	printf("[Parity]: \t%s\n", bin_num);
	printf("-------------------------\n");
}

uint32_t process_block_parity(sMessageBlock msg_blk) {
	uint32_t parity = 0;
	int cols = 8 * sizeof(msg_blk.messages[0].msg);
	int rows = msg_blk.count;
	//printf("%dx%d---\n", rows, cols);
	for (int j = 0; j < cols + 1; j++) {
#ifdef EVEN_PARITY
		int xor_var = 0;
#else
		int xor_var = 1;
#endif
		for (int i = 0; i < rows; i++) {
			uint32_t msg_cpy = msg_blk.messages[i].msg;
			msg_cpy >>= cols - j;
			xor_var ^= (msg_cpy & 1);
			//printf("%d^", msg_cpy & 1);
		}
		//printf("=%d\n", xor_var);
		parity += pow(2, cols - j) * xor_var;
	}
	return parity;
}

int process_parity(sMessage message) {
	int n = sizeof(message.msg);
	int xor = 0;
	int msg_cpy = message.msg;

	while (msg_cpy > 0) {
		xor = xor ^ (msg_cpy & 1);
		msg_cpy >>= 1;
	}
	return xor;
}

void process_recieved_message_block(sMessageBlock msg_blk) {
	int parity = process_block_parity(msg_blk);
	if (parity == msg_blk.parity) {
		printf("Message Is Correct\n");
	} else {
		printf("Message Is Corrupted\n");
	}
}

void process_recieved_message(sMessage message) {
	int parity = process_parity(message);
	if (parity == message.parity) {
		printf("Message Is Correct\n");
	} else {
		printf("Message Is Corrupted\n");
	}
}
#endif
```

1. Write the C/C++ Program to implement simple parity check code to detect single bit error during the message transmission from sender to receiver.

```c
#include <stdio.h>

#define MESSAGE_IMPLEMENTATION
#include "message.h"

#define EVEN_PARITY

int main() {
	sMessage serverMsg1 = {
		.msg = 0b1000001010
	};
	serverMsg1.parity = process_parity(serverMsg1);
	sMessage serverMsg2 = {
		.msg = 0b1000001010,
		.parity = 0
	};

	process_recieved_message(serverMsg1);
	process_recieved_message(serverMsg2);
}
```

```console
Message Is Correct
Message Is Corrupted
```

2. Write the C/C++ Program to implement Two-dimensional parity check code to detect two or more-bit error during the message transmission from sender to receiver.

```c
#define MESSAGE_IMPLEMENTATION
#include "message.h"

#include <stdio.h>

#define EVEN_PARITY
#define LEN(x) sizeof(x) / sizeof(x[0])

int main() {
	// Server side
	uint32_t bit_messages[] = {
		0b1000001010,
		0b0001000000,
		0b1000000100,
		0b1010010010,
		0b1011100010,
		0b1001111010,
		0b1010001110,
	};

	sMessageBlock msg_blk1;
	msg_blk1.count = LEN(bit_messages);

	msg_blk1.messages = (sMessage*)malloc(sizeof(sMessage) * msg_blk1.count);
	for (int i = 0; i < msg_blk1.count; i++) {
		msg_blk1.messages[i].msg = bit_messages[i];
		msg_blk1.messages[i].parity = process_parity(msg_blk1.messages[i]);
	}
	msg_blk1.parity = process_block_parity(msg_blk1);

	sMessageBlock msg_blk2;
	msg_blk2.count = LEN(bit_messages);
	msg_blk2.messages = (sMessage*)malloc(sizeof(sMessage) * msg_blk2.count);
	for (int i = 0; i < msg_blk2.count; i++) {
		msg_blk2.messages[i].msg = bit_messages[i];
		msg_blk2.messages[i].parity = process_parity(msg_blk2.messages[i]);
	}
	//msg_blk2.parity = process_block_parity(msg_blk2); // Instead of calculating, im giving a wrong parity to simulate an error while message travelling
	msg_blk2.parity = 0b111110010101010;

	print_message_block(msg_blk1);
	print_message_block(msg_blk2);

	// Client Side
	process_recieved_message_block(msg_blk1);
	process_recieved_message_block(msg_blk2);

	free(msg_blk1.messages);

 }
```

```console
[Message 0]:    00000000000000000000001000001010        [Parity]:       1
[Message 1]:    00000000000000000000000001000000        [Parity]:       1
[Message 2]:    00000000000000000000001000000100        [Parity]:       0
[Message 3]:    00000000000000000000001010010010        [Parity]:       0
[Message 4]:    00000000000000000000001011100010        [Parity]:       1
[Message 5]:    00000000000000000000001001111010        [Parity]:       0
[Message 6]:    00000000000000000000001010001110        [Parity]:       1
[Parity]:       11111111111111111111111100110101
-------------------------
[Message 0]:    00000000000000000000001000001010        [Parity]:       1
[Message 1]:    00000000000000000000000001000000        [Parity]:       1
[Message 2]:    00000000000000000000001000000100        [Parity]:       0
[Message 3]:    00000000000000000000001010010010        [Parity]:       0
[Message 4]:    00000000000000000000001011100010        [Parity]:       1
[Message 5]:    00000000000000000000001001111010        [Parity]:       0
[Message 6]:    00000000000000000000001010001110        [Parity]:       1
[Parity]:       00000000000000000111110010101010
-------------------------
Message Is Correct
Message Is Corrupted
```

3. Write the C/C++ Program to implement Checksum technique to detect error during the message transmission from sender to receiver.

```c++
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
```

```console
[Packet1]
[Message 0]:	 153		 10011001
[Message 1]:	 226		 11100010
[Message 2]:	 36			 00100100
[Message 3]:	 132		 10000100
[Message 4]:	 218		 11011010

[Packet2]
[Message 0]:	 153		 10011001
[Message 1]:	 226		 11100010
[Message 2]:	 36			 00100100
[Message 3]:	 132		 10000100
[Message 4]:	 219		 11011011

Message is Correct
Message is Corrupted
```
