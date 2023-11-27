#include <stdio.h>
#include <stdint.h>

void mylog(int a) {
    printf("%d\n", a);
}

uint8_t right_most_bit(uint32_t num) {
    uint8_t i = 0;
    uint32_t dummy = 1;
    if (num != 0) {
        while (1) {
            i++;
            dummy <<= i;
            // mylog(dummy);
            if (dummy & num) break;
        }
    }
    return i;
}

int main() {
    uint32_t a;
    scanf("%d", &a);

    uint8_t i = right_most_bit(a);
    printf("%d \n", i);
}
