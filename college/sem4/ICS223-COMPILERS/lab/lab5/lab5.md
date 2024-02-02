# ICS 223 COMPILER DESIGN

## LAB 4 Gowrish I 2022BCS0155

### Write a LEX program to recognize the following tokens over the alphabets {0,1,..,9} 

- The set of all string ending in 00. 
```c
%{
#include<stdio.h>
int k=0;
%}
check .*00$
%%
{check} {k=1;printf("");}
. {printf("");}
%%
int yywrap()
{
 return 1;
}
int main()
{
 printf("Enter the statement:");
 yylex();
 if (k==1)
 {
 printf("The string ends with 00");
 }
 else
 printf("The string does not end with 00");
 return 0;
} 
```
```console
PS C:\Users\harsh\OneDrive\Desktop\Compiler Course> ./a
Enter the statement:3546500234

^Z
The string does not end with 00
PS C:\Users\harsh\OneDrive\Desktop\Compiler Course> ./a
Enter the statement:234300

^Z
The string ends with 00
```
- The set of all strings with three consecutive 222’s. 
```c
%{
#include<stdio.h>
FILE *f;
%}
consecutive [0-9]*222[0-9]*
other [0-9]+
%%
{consecutive} {printf("%s The string has consecutive 2s",yytext);}
{other} {printf("%s The string does not have consecutive 2s",yytext);}
%%
int yywrap()
{
 return 1;
}
int main(int argc,char *argv[])
{
 f=fopen(argv[1],"r");
 yyin=f;
 yylex();
 return 0;
} 
```
```
125345202
234322240
654342539
234232223
```
```console
PS C:\Users\harsh\OneDrive\Desktop\Compiler Course> ./a file.txt
125345202 The string does not have consecutive 2s
234322240 The string has consecutive 2s
654342539 The string does not have consecutive 2s
234232223 The string has consecutive 2s
```

- The set of all string such that every block of five consecutive symbols contains at least two 5’s.
```c
%{
#include<stdio.h>
#include<string.h>
FILE *f;
%}
other [0-9]+
%%
{other} {
 for (int i = 0; i <yyleng; i += 5) {
 int c = 0;
 for (int j = 0; j < 5; j++) {
 if (yytext[i + j] == '5') {
 c += 1;
 }
 }
 if (c>=2) {
 printf("%s Every block of five consecutive symbols contains at least two 5's\n", yytext + i);
 } 
 else {
 printf("%s Not satisfied\n", yytext + i);
 }
 }
}
%%
int yywrap()
{
 return 1;
}
int main(int argc,char *argv[])
{
 f=fopen(argv[1],"r");
 yyin=f;
 yylex(); 
 return 0;
}
```
```
2325523445
2345624524
3454453452
```
```console
2325523445 Every block of five consecutive symbols contains at least two 5's
23445 Not satisfied

2345624524 Not satisfied
24524 Not satisfied

3454453452 Not satisfied
53452 Every block of five consecutive symbols contains at least two 5's
PS C:\Users\harsh\OneDrive\Desktop\Compiler Course> 
```

- The set of all strings beginning with a 1 which, interpreted as the binary representation of an integer, is congruent to zero modulo 5.
```c
%{
#include<stdio.h>
#include<math.h>
FILE *f;
%}
bin ^1[01]*
other [01]+
%%
{bin} {
 int length = yyleng;
 int decimal = 0;
 for (int i = 0; i < length; i++) {
 if (yytext[i] == '1') {
 decimal+=pow(2, length-i-1);
 }
 }
 if (decimal%5==0) {  printf("%s is Congruent to zero modulo 5\n", yytext);
 } else {
 printf("%s is Not congruent to zero modulo 5\n", yytext);
 }
}
{other} {printf("%s Not start with 1\n",yytext);}
%%
int yywrap()
{
 return 1;
}
int main(int argc,char *argv[])
{
 f=fopen(argv[1],"r");
 yyin=f;
 yylex();
 return 0;
}
```
```
10100
101
111
0110
```
```console
PS C:\Users\harsh\OneDrive\Desktop\Compiler Course> ./a file.txt
10100 is Congruent to zero modulo 5

101 is Congruent to zero modulo 5

111 is Not congruent to zero modulo 5

0110 Not start with 1
```

- The set of all strings such that the 10th symbol from the right end is 1. 
```c
%{
#include<stdio.h>
FILE *f;
%}
tenth [0-9]*1[0-9]{9}
other [0-9]+
%%
{tenth} {printf("%s tenth character from right is 1",yytext);}
{other} {printf("%s Not satisfied\n",yytext);}
%%
int yywrap()
{
 return 1;
}
int main(int argc,char *argv[])
{
 f=fopen(argv[1],"r");
 yyin=f;
 yylex();
 return 0;
} 

```
```
123567890
2123493401
34321940200211
```
```console
PS C:\Users\harsh\OneDrive\Desktop\Compiler Course> ./a file.txt
123567890 Not satisfied

2123493401 Not satisfied

34321940200211 tenth character from right is 1
```

- The set of all four digits numbers whose sum is 9
```c
%{
#include<stdio.h>
FILE *f;
%}
sum [1-9][0-9]{3}
other [0-9]+
%%
{sum} {
 int c=0;
 for(int i=0;i<yyleng;i++)
 {
 c+=(int)(yytext[i])-(int)('0');
 }
 if(c==9)
 {
 printf("%s Sum is 9",yytext);
 }
 else{
 printf("%s Sum is not 9",yytext);
 }
 }
{other} {printf("%s Not 4 digit number",yytext);}
%%
int yywrap()
{
 return 1;
}
int main(int argc,char *argv[])
{
 f=fopen(argv[1],"r");
 yyin=f;
 yylex();
 return 0;
}
```
```
123234
9000
1512
0000
```
```console
PS C:\Users\harsh\OneDrive\Desktop\Compiler Course> ./a file.txt
123234 Not 4 digit number
9000 Sum is 9
1512 Sum is 9
0000 Not 4 digit number
```

- The set of all four digital numbers, whose individual digits are in ascending order from left to right. 
```c
%{
#include<stdio.h>
FILE *f;
%}
ascending 0*1*2*3*4*5*6*7*8*9*
other [0-9]+
%%
{ascending} {
 if(yyleng==4)
 printf("%s is in ascending order",yytext);
 else
 printf("%s is not 4 digit number",yytext);
}
{other} {printf("%s Not in ascending order",yytext);}
%%
int yywrap()
{
 return 1;
}
int main(int argc,char *argv[])
{
 f=fopen(argv[1],"r");
 yyin=f;
 yylex();
 return 0;
} 
```
```
123456789
54367892
5678
3456
6543
```
```console
PS C:\Users\harsh\OneDrive\Desktop\Compiler Course> ./a file.txt
123456789 is not 4 digit number
54367892 Not in ascending order
5678 is in ascending order
3456 is in ascending order
6543 Not in ascending order
```

- Write a lex program to count the number of comment lines in a given c program 
```c
%{
#include<stdio.h>
FILE *f;
int s=0;
int m=0;
%}
single .*\/\/
multiple .*\/\*
%%
{single} {s++;printf("");}
{multiple} {m++;printf("");}
. {printf("");}
%%
int yywrap()
{
 return 1;
}
int main(int argc,char *argv[])
{
 f=fopen(argv[1],"r");
 yyin=f;
 yylex();
 printf("Number of single line comments :%d\n",s);
 printf("Number of multiple line comments :%d",m);
 return 0;
}
```
```
// this is header file 
#include<stdio.h>
int main()
{
    int a = 0; // this is integer variable initialization
    int b; // initialization w/o value
    b=1; // assigning value
    printf("%d", a+b); // print statement
    // returning main function with value '0'
    return 0;
}
```
```console
PS C:\Users\harsh\OneDrive\Desktop\Compiler Course> ./a file.c    

Number of single line comments :6
Number of multiple line comments :0
```
