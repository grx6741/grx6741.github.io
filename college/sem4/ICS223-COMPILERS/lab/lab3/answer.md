#ICS 223

## Lab 3

### Gowrish I 2022BCS0155

- Write a lex program to count number of vowels and consonants in c file.

```c
%{

#include <stdio.h>
int c = 0;
int v = 0;

%}

vowel [aeiouAEIOU]
consonant [a-zA-Z]

%%

{vowel} {
    v++;
}

{consonant} {
    c++;
}

%%

int yywrap(void) { }

int main() {
    yylex();
    printf("Vowel Count %d, Consonant Count %d\n", v, c);
}
```

```console
a
e
B
d
I
Vowel : a
Vowel : e
Consonant : B
Consonant : d
Vowel : I
Vowel Count 3, Consonant Count 2
```

- Write lex program to print number and string from the given sequence.

```c
%{

#include <stdio.h>

%}

digit [0-9]
string [a-zA-Z]

%%

{digit}+ {
    printf("Digit : %s\n", yytext);
}

{string}+ {
    printf("String : %s\n", yytext);
}

%%

int yywrap(void) { }

int main() {
    yylex();
}
```

```console
abc
123
abc123

String : abc
Digit : 123
String : abc
Digit : 123
```

- Write a lex program to Identify  Numbers

```c
%{

#include <stdio.h>
#include <assert.h>

%}

%%

0b[01]+ {
    printf("%s : Binary number\n", yytext);
}

0o[0-7]+ {
    printf("%s : Octal number\n", yytext);
}

0x[0-9a-f]+ {
    printf("%s : Hexadecimal number\n", yytext);
}

[+-]?[0-9]+ {
    printf("%s : Integers\n", yytext);
}

[+-]?[0-9]+(\.[0-9]+)? {
    printf("%s : Float\n", yytext);
}

[+-]?[0-9]+(\.[0-9]+)?([eE][+-]?[0-9]+)? {
    printf("%s : Exponential numbers\n", yytext);
}

%%

int yywrap(void) {
    return 0;
}

int main() {
    yylex();
    return 0;
}
```

```console
0b10110001
0o3546170
0x45afbcd
045631
-1247
+210.68
-193.12
129.31E-12

0b10110001 : Binary number
0o3546170 : Octal number
0x45afbcd : Hexadecimal number
045631 : Integers
-1247 : Integers
+210.68 : Float
-193.12 : Float
129.31E-12 : Exponential numbers
```

- Write a lex program to find count of number of positive and negative integers and fractions.

```c
%{

#include <stdio.h>

int positive = 0;
int negative = 0;
int positiveFraction = 0;
int negativeFraction = 0;
int zeroes = 0;

%}

%%

[0]+ {
    zeroes++;
    printf("zeroes detected: %s", yytext);
}

\+?[0-9]+ {
    positive++;
    printf("+ve detected: %s", yytext);
}

-[0-9]+ {
    negative++;
    printf("-ve detected: %s", yytext);
}

\+?[0-9]*[\.][0-9]+ {
    positiveFraction++;
    printf("+ve fraction detected: %s", yytext);
}

-[0-9]*\.[0-9]+ {
    negativeFraction++;
    printf("-ve fraction detected: %s", yytext);
}

%%

int yywrap(void) { }

int main(void) {
    yylex();
    printf("+ve count = %d, -ve count = %d, zeroes count = %d\n", positive, negative, zeroes);
    printf("+ve fraction count = %d, -ve fraction count = %d\n", positiveFraction, negativeFraction);
}
```

```console
000
0
00000
+12
678
-567
+356.1
1637.467
-56.567

zeroes detected: 000
zeroes detected: 0
zeroes detected: 00000
+ve detected: +12
+ve detected: 678
-ve detected: -567
+ve fraction detected: +356.1
+ve fraction detected: 1637.467
-ve fraction detected: -56.567
+ve count = 2, -ve count = 1, zeroes count = 3
+ve fraction count = 2, -ve fraction count = 1
```

- Write a Lex Program to recognize and display keywords, numbers, and words in a given statement

```c
%{

#include <stdio.h>

%}

keywords (auto|break|case|char|const|continue|default|do|double|else|enum|extern|float|for|goto|if|int|long|register|return|short|signed|sizeof|static|struct|switch|typedef|union|unsigned|void|volatile|while)
numbers [+-]?([0-9](\.[0-9]+)?)+
words [a-zA-Z]+

%%

{keywords} {
    printf("Keyword detected: %s", yytext);
}

{numbers} {
    printf("numbers detected: %s", yytext);
}

{words} {
    printf("Word detected: %s", yytext);
}

%%

int yywrap(void) { }

int main() {
    yylex();
}
```

```console
if
else
while
int
12
-12
+6789.21
-4678.12
hello
world

Keyword detected: if
Keyword detected: else
Keyword detected: while
Keyword detected: int
numbers detected: 12
numbers detected: -12
numbers detected: +6789.21
numbers detected: -4678.12
Word detected: hello
Word detected: world
```

- Lex program to identify the capital words from the given input string

```c
%{

#include<stdio.h>
int c=0;

%}

%%

if|else|while|do|and|but|then {c=1;}
. ;
\n {return 0;}

%%
int yywrap()
{
    return 1;
}

int main()
{
    printf("Enter the statement:\n");
    yylex();
    if(c==0)
        printf("Simple sentence");
    else
        printf("Compound sentence");
    return 0;
}
```

```console
ABCDE
abdCE
abcde

Capital word detected: ABCDE
Lower word detected: abd
Capital word detected: CE
Lower word detected: abcde
```

- How to write Lex Program to recognize given statement is Simple or Compound

```c
%{

#include<stdio.h>
int c=0;

%}

%%

if|else|while|do|and|but|then {c=1;}
. ;
\n {return 0;}

%%
int yywrap()
{
    return 1;
}

int main()
{
    printf("Enter the statement:\n");
    yylex();
    if(c==0)
        printf("Simple sentence");
    else
        printf("Compound sentence");
    return 0;
}
```

```console
Enter the statement:
Although it was raining, she went for a run.
Simple sentence
I am a boy and she is a girl
Compound sentence
```

