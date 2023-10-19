# Assignment 

## Gowrish I (2022BCS0155)

### Write a program to encrypt and decrypt the text ‘DOG’ using Hill cipher.

```cpp
#include<iostream>
#include<math.h>

using namespace std;

float en[3][1], de[3][1], a[3][3], b[3][3], msg[3][1], m[3][3];

void getKeyMatrix() {
    int i, j;
    char mes[3];
    cout<<"Enter 3x3 matrix for key (should have inverse):\n";
    for(i = 0; i < 3; i++)
        for(j = 0; j < 3; j++) {
            cin>>a[i][j];
            m[i][j] = a[i][j];
        }
    cout<<"\nEnter a string of 3 letter(use A through Z): ";
    cin>>mes;
    for(i = 0; i < 3; i++)
        msg[i][0] = mes[i] - 65;
}
void encrypt() { //encrypts the message
    int i, j, k;
    for(i = 0; i < 3; i++)
        for(j = 0; j < 1; j++)
            for(k = 0; k < 3; k++)
                en[i][j] = en[i][j] + a[i][k] * msg[k][j];
    cout<<"\nEncrypted string is: ";
    for(i = 0; i < 3; i++)
        cout<<(char)(fmod(en[i][0], 26) + 65); //modulo 26 is taken for each element of the matrix obtained by multiplication
}
void inversematrix() { //find inverse of key matrix
    int i, j, k;
    float p, q;
    for(i = 0; i < 3; i++)
        for(j = 0; j < 3; j++) {
            if(i == j)
                b[i][j]=1;
            else
                b[i][j]=0;
        }
    for(k = 0; k < 3; k++) {
        for(i = 0; i < 3; i++) {
            p = m[i][k];
            q = m[k][k];
            for(j = 0; j < 3; j++) {
                if(i != k) {
                    m[i][j] = m[i][j]*q - p*m[k][j];
                    b[i][j] = b[i][j]*q - p*b[k][j];
                }
            }
        }
    }
    for(i = 0; i < 3; i++)
        for(j = 0; j < 3; j++)
            b[i][j] = b[i][j] / m[i][i];
    cout<<"\n\nInverse Matrix is:\n";
    for(i = 0; i < 3; i++) {
        for(j = 0; j < 3; j++)
            cout<<b[i][j]<<" ";
        cout<<"\n";
    }
}
void decrypt() { //decrypt the message
    int i, j, k;
    inversematrix();
    for(i = 0; i < 3; i++)
        for(j = 0; j < 1; j++)
            for(k = 0; k < 3; k++)
                de[i][j] = de[i][j] + b[i][k] * en[k][j];
    cout<<"\nDecrypted string is: ";
    for(i = 0; i < 3; i++)
        cout<<(char)(fmod(de[i][0], 26) + 65); //modulo 26 is taken to get the original message
    cout<<"\n";
}
int main() {
    getKeyMatrix();
    encrypt();
    decrypt();
}
```

```text
Enter 3x3 matrix for key (should have inverse):
1 0 1
2 4 0
3 5 6

Enter a string of 3 letter(use A through Z): DOG

Encrypted string is: JKL

Inverse Matrix is:
1.09091 0.227273 -0.181818
-0.545455 0.136364 0.0909091
-0.0909091 -0.227273 0.181818

Decrypted string is: DOG
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
