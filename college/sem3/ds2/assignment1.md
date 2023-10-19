# Assignment 

## Gowrish I (2022BCS0155)

### Write a program to encrypt and decrypt the text ‘DOG’ using Hill cipher.

```cpp
#include <iostream>
using namespace std;

void getKeyMatrix(string key, int keyMatrix[][3]) {
	int k = 0;
	for (int i = 0; i < 3; i++) {
		for (int j = 0; j < 3; j++) {
			keyMatrix[i][j] = (key[k]) % 65;
			k++;
		}
	}
}

void encrypt(int cipherMatrix[][1], int keyMatrix[][3], int messageVector[][1]) {
	int x, i, j;
	for (i = 0; i < 3; i++) {
		for (j = 0; j < 1; j++) {
			cipherMatrix[i][j] = 0;
			for (x = 0; x < 3; x++) {
				cipherMatrix[i][j] += keyMatrix[i][x] * messageVector[x][j];
			}
			cipherMatrix[i][j] = cipherMatrix[i][j] % 26;
		}
	}
}

void HillCipher(string message, string key) {
	int keyMatrix[3][3];
	getKeyMatrix(key, keyMatrix);
	int messageVector[3][1];
	for (int i = 0; i < 3; i++)
		messageVector[i][0] = (message[i]) % 65;

	int cipherMatrix[3][1];
	encrypt(cipherMatrix, keyMatrix, messageVector);

	string CipherText;
	for (int i = 0; i < 3; i++)
		CipherText += cipherMatrix[i][0] + 65;

	cout << " Encoded Message: " << CipherText << endl;
}

int main() {
	string message = "DOG";

	string key = "GYBNQKURP";
    cout << "Message: " << message << endl;
	HillCipher(message, key);
	return 0;
}
```

```text
> Message : DOG
  Encoded Message: WLY
```

### Write a program to check the divisibility by 3 using bitwise operator.

```cpp
#include <iostream>
using namespace std;

bool isDivisibleBy3(int num) {
    if (num < 0) {
        num = -num;
    }

    if (num == 0) {
        return true;
    }
    if (num == 1) {
        return false;
    }

    int even_bit_count = 0;
    int odd_bit_count = 0;

    while (num) {
        if (num & 1) {
            odd_bit_count++;
        }
        num >>= 1;

        if (num & 1) {
            even_bit_count++;
        }
        num >>= 1;
    }

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
```

```text
> Enter a number: 992
  992 is not divisible by 3.

> Enter a number: 993
  993 is not divisible by 3.
```
