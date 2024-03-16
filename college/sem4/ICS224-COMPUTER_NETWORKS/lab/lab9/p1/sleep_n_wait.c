#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <pthread.h>
#include <unistd.h>

#define RTT 0

#define LOG(x) printf("%s\n", (x))

typedef enum {
	INITIAL_STATE = 0,
	MESSAGE_SENT,
	ACK_SENT,
	FRAME_LOST
} status;

status STATUS = INITIAL_STATE;
char DATA = 0;

void* sender(void* ptr) {
	char* msg = (char*)ptr;
	int msg_len = strlen(msg);
	int i = 0;

	// FIRST MSG
	DATA = msg[i];
	STATUS = MESSAGE_SENT;
	printf("[SERVER] Sent MESSAGE[%d] %c\n", i, DATA);

	while (i < msg_len) {
	 	LOG("[SERVER] Waiting for Acknowledgement...\n");
	 	while (STATUS == MESSAGE_SENT);
		sleep(RTT);
	 	if (STATUS == ACK_SENT) {
	 		LOG("[SERVER] Acknowledgement Recieved\n");
	 		i++;
	 	} else if (STATUS == FRAME_LOST) {
	 		LOG("[SERVER] Acknowledgement Not Recieved\n");
	 	}

	 	DATA = msg[i];
	 	STATUS = MESSAGE_SENT;
	 	printf("[SERVER] Sent MESSAGE[%d] %c\n", i, DATA);
	}
}

void* reciever(void* ptr) {
	int msg_len = *(int*)ptr;
	int i = 0; // Number of bits
	int j = 0; // number of iterations
	char message[msg_len];
	while (i < msg_len + 1) {
		while (STATUS != MESSAGE_SENT);
		sleep(RTT);
		if ((j+1) % 4 != 0) {
			STATUS = ACK_SENT;
			printf("[RECIEVER] Recieved MESSAGE[%d] %c\n", i, DATA);
			message[i] = DATA;
			i++;
		} else {
			STATUS = FRAME_LOST;
			printf("[RECIEVER] Frame[%d] Lost \n", i);
		}
		j++;
	}
	printf("[RECIEVER] Final Message Recieved: %s\n", message);
}

int main() {
	const char* msg = "1101110100";
	int msg_len = strlen(msg);

	pthread_t t1, t2;

	int ret1 = pthread_create(&t1, NULL, sender, (void*) msg);
	int ret2 = pthread_create(&t2, NULL, reciever, (void*) &msg_len);

	pthread_join(t1, NULL);
	pthread_join(t2, NULL);
}
