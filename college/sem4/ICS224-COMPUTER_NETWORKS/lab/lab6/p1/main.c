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
