#include <stdio.h>
#include <stdlib.h>
#include <string.h>
#include <pthread.h>
#include <unistd.h>

#include <queue>

#define RTT 1

#define LOG(x) printf("%s\n", (x))
#define WINDOW_SIZE 4

typedef enum {
	INITIAL_STATE = 0,
	MESSAGE_SENT,
	ACK_SENT,
	FRAME_LOST
} status;

status RECIEVER_STATUS = INITIAL_STATE;

std::queue<char> DATA;

void send_message(const char* msg, int i) {
	DATA.push(msg[i]);
}

void* sender(void* ptr) {
	char* msg = (char*)ptr;
	int msg_len = strlen(msg);

	// FIRST MSG
	// DATA = msg[i];
	// STATUS = MESSAGE_SENT;
	// printf("[SERVER] Sent MESSAGE[%d] %c\n", i, DATA);

	int i = 0;
	int j = 0;
	while (i < msg_len) {
		if (i < WINDOW_SIZE) {
			printf("[SERVER] Sent MESSAGE[%d] %c\n", i, msg[i]);
			DATA.push(msg[i]);
			i++;
		}

		while (DATA.size() >= WINDOW_SIZE);

		switch (RECIEVER_STATUS) {
			case ACK_SENT:
				LOG("[SERVER] Acknowledgement Recieved\n");
				i++;
				j++;
				send_message(msg, i);
				printf("[SERVER] Sent MESSAGE[%d] %c\n", i, msg[i]);
				break;
			case FRAME_LOST:
				LOG("[SERVER] Acknowledgement Not Recieved\n");
				printf("[SERVER] Resent MESSAGE[%d] %c\n", j, msg[j]);
				send_message(msg, j);
				break;
		}

	 	// LOG("[SERVER] Waiting for Acknowledgement...\n");
	 	// while (STATUS == MESSAGE_SENT);
		// sleep(RTT);
	 	// if (STATUS == ACK_SENT) {
	 	// 	LOG("[SERVER] Acknowledgement Recieved\n");
	 	// 	i++;
	 	// } else if (STATUS == FRAME_LOST) {
	 	// 	LOG("[SERVER] Acknowledgement Not Recieved\n");
	 	// }

	 	// DATA = msg[i];
	 	// STATUS = MESSAGE_SENT;
	 	// printf("[SERVER] Sent MESSAGE[%d] %c\n", i, DATA);
	}
	return 0;
}
void* reciever(void* ptr) {
	int msg_len = *(int*)ptr;
	char msg[msg_len];

	int i = 0;
	int j = 0;
	while (i < msg_len + 1) {
		while (DATA.size() < WINDOW_SIZE); // wait
		if ((j+1) % 5 == 0) {
			RECIEVER_STATUS = FRAME_LOST;
	 		printf("[RECIEVER] Frame[%d] Lost \n", i);
		} else {
	 		RECIEVER_STATUS = ACK_SENT;
	 		printf("[RECIEVER] Recieved MESSAGE[%d] %c\n", i, DATA.front());
	 		msg[i] = DATA.front();
	 		i++;
		}
		j++;
		DATA.pop();
	}

	// int i = 0; // Number of bits
	// int j = 0; // number of iterations
	// char message[msg_len];
	// while (i < msg_len + 1) {
	// 	while (STATUS != MESSAGE_SENT);
	// 	sleep(RTT);
	// 	if ((j+1) % 4 != 0) {
	// 		STATUS = ACK_SENT;
	// 		printf("[RECIEVER] Recieved MESSAGE[%d] %c\n", i, DATA);
	// 		message[i] = DATA;
	// 		i++;
	// 	} else {
	// 		STATUS = FRAME_LOST;
	// 		printf("[RECIEVER] Frame[%d] Lost \n", i);
	// 	}
	// 	j++;
	// }
	// printf("[RECIEVER] Final Message Recieved: %s\n", message);
	return 0;
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
