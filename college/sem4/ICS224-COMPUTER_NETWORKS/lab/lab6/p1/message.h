#pragma once

#include <stdio.h>
#include <inttypes.h>
#include <stdint.h>

typedef struct {
	int32_t msg;
	int parity;
} sMessage;

#ifdef MESSAGE_IMPLEMENTATION
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
#endif
