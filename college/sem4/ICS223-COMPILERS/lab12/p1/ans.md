# ICS 223 COMPILER DESIGNS Lab 12

## Gowrish I 2022BCS0155

- Write a YACC program to identify valid expression

```lex
%{

#include<stdio.h>
#include"main.tab.h"
extern int yylval;

%}

%%

[a-zA-Z][a-zA-Z0-9]* {return ID;}
[\t] {return yytext[0];}
[\n] {return 0;}
[ ] {return 0;}

%%

int yywrap()
{ 
return 1;
}
```

```
%{
#include<stdio.h>
#include<stdlib.h>
int yylex();
void yyerror();
%}

%token ID

%%

start:  E '\n'
     ;

E:  ID           { printf("ID\n"); }
 |  E '+' E
 |  E '-' E
 | '(' E ')'
 ;

%%

```

```console
~>> ./main
a + a
~>> ./main
a -- a
syntax error
```

- Write a YACC program to identify valid expression

```
%{

#include<stdio.h>
#include"main.tab.h"
extern int yylval;

%}

%%

[a-zA-Z][a-zA-Z0-9]* {return ID;}
[\n] {return 0;}

%%

int yywrap()
{ 
return 1;
}
```

```
%{
#include<stdio.h>
#include<stdlib.h>
int yylex();
void yyerror();
%}

%token ID

%%

start:  ID '\n'
     ;

%%

```

```console
~>> ./main
abc123
~>> ./main
123abc
syntax error
```