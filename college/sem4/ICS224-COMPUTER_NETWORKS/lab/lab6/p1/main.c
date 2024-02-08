#include <stdio.h>
#include <math.h>
#include <stdint.h>
#include <inttypes.h>

#define EVEN_PARITY

typedef struct {
	int32_t msg;
	int parity;
} sMessage;

int process_parity(sMessage message) {
	int n = sizeof(message.msg);
#ifdef EVEN_PARITY
	int xor = 0;
#else
	int xor = 1;
#endif
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
