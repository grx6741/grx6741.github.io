# ICS 223 COMPILER DESIGN

## Lab 3

### Gowrish 2022BCS0155

Write a LEX program to recognize the following tokens over the alphabets {0,1,..,9}

- The set of all string ending in 00. 
```c
%{
    #include<stdio.h>
    int k=0;
%}

check .*00$

%%

{check} {
    k=1;
    printf("");
}
. {
    printf("");
}

%%
int yywrap() { return 1; }

int main() {
    printf("Enter the statement:");
    yylex();
    if (k==1) {
        printf("The string ends with 00");
    } else {
        printf("The string does not end with 00");
    }
    return 0;
}

``` 
- The set of all strings with three consecutive 222’s. 
```lex

``` 
 
- The set of all string such that every block of five consecutive symbols contains at least two 5’s. 
```lex

``` 
 
- The set of all strings beginning with a 1 which, interpreted as the binary representation of an integer, is congruent to zero modulo 5. 
```lex

``` 
 
- The set of all strings such that the 10th symbol from the right end is 1. 
```lex

``` 
 
- The set of all four digits numbers whose sum is 9 
```lex

``` 
 
- The set of all four digital numbers, whose individual digits are in ascending order from left to right.
```lex

``` 
