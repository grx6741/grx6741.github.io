#include <stdio.h>
#include <math.h>
#include <stdint.h>
#include <stdlib.h>

#define EVEN_PARITY
#define LEN(x) sizeof(x) / sizeof(x[0])

typedef struct {
	uint32_t msg;
	int parity;
} sMessage;

typedef struct {
	sMessage* messages;
	uint32_t count;
	uint32_t parity;
} sMessageBlock;

void print_message_block(sMessageBlock msg_blk) {
	int n = msg_blk.count;
	for (int i = 0; i < n; i++) {
		printf("%d\n", msg_blk.messages[i].parity);
	}
}

uint32_t process_block_parity(sMessageBlock msg_blk) {
	uint32_t parity = 0;
	int cols = 8 * sizeof(msg_blk.messages[0].msg);
	int rows = msg_blk.count;
	printf("%d---\n", rows);
	for (int j = 0; j < cols; j++) {
#ifdef EVEN_PARITY
		int xor = 0;
#else
		int xor = 1;
#endif
		for (int i = 0; i < rows; i++) {
			uint32_t msg_cpy = msg_blk.messages[i].msg;
			msg_cpy >>= cols - j;
			xor ^= (msg_cpy & 1);
			printf("%d^", msg_cpy & 1);
			/*
			if ((msg_blk.messages[i].msg & (1 << (cols - j))))
				xor ^= 1;
			else
				xor ^= 0;
			*/
		}
		printf("=%d\n", xor);
		parity += pow(2, cols - j - 1) * xor;
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

void process_recieved_message(sMessage message) {
	int parity = process_parity(message);
	if (parity == message.parity) {
		printf("Message Is Correct\n");
	} else {
		printf("Message Is Corrupted\n");
	}
}

int main() {
	uint32_t bit_messages[] = {
		0b1000001010,
		0b0001000000,
		0b1000000100,
		0b1010010010,
		0b1011100010,
		0b1001111010,
		0b1010001110,
	};

	sMessageBlock msg_blk;
	msg_blk.count = LEN(bit_messages);

	msg_blk.messages = (sMessage*)malloc(sizeof(sMessage) * msg_blk.count);
	for (int i = 0; i < msg_blk.count; i++) {
		msg_blk.messages[i].msg = bit_messages[i];
		msg_blk.messages[i].parity = process_parity(msg_blk.messages[i]);
	}

	msg_blk.parity = process_block_parity(msg_blk);
	printf("%d\n", msg_blk.parity);
	free(msg_blk.messages);
}
