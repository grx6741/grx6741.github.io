#include <iostream>
using namespace std;

bool isDivisibleBy3(int num) {
    // Handle negative numbers
    if (num < 0) {
        num = -num;
    }

    // Base case
    if (num == 0) {
        return true;
    }
    if (num == 1) {
        return false;
    }

    int even_bit_count = 0;  // Count of even bits
    int odd_bit_count = 0;   // Count of odd bits

    while (num) {
        // If the least significant bit is set (odd bit)
        if (num & 1) {
            odd_bit_count++;
        }
        // Move to the next bit
        num >>= 1;

        // If the least significant bit is set (even bit)
        if (num & 1) {
            even_bit_count++;
        }
        // Move to the next bit
        num >>= 1;
    }

    // Check if the difference between even and odd bit counts is divisible by 3
    return isDivisibleBy3(abs(even_bit_count - odd_bit_count));
}

int main() {
    int num;
    cout << "Enter a number: ";
    cin >> num;

    if (isDivisibleBy3(num)) {
        cout << num << " is divisible by 3." << endl;
    } else {
        cout << num << " is not divisible by 3." << endl;
    }

    return 0;
}
