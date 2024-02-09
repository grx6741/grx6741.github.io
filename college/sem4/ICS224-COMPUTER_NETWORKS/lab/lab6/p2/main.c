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
