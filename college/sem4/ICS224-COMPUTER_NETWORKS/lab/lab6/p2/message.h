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
