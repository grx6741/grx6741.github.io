# LAB 10

## Gowrish I 2022BCS0155

Simple Desktop Calculator

- Lex file
```l
%{
#include "main.tab.h"
extern int yylval;
%}

int [0-9]+
float [0-9]*[.][0-9]+

%%

{float}    {
                yylval = atof(yytext);
                return FLOAT;
        }

{int}    {
                yylval = atoi(yytext);
                return INTEGER;
        }

[-+/*)(\n]        return *yytext;

%%

int yywrap() { return 0; }
```

- YACC file
```y
%{
#include <stdio.h>
int yylex();
int yyerror();
%}

%token INTEGER
%token FLOAT
%left '+' '-'
%left '*' '/'

%%

E_DASH:
       E_DASH E '\n'                   { printf("%d\n", $2); } | ;

E:
                FLOAT
|               INTEGER
|               E '+' E       { $$ = $1 + $3; }
|               E '-' E       { $$ = $1 - $3; }
|               E '*' E       { $$ = $1 * $3; }
|               E '/' E       { $$ = $1 / $3; }
|               '(' E ')'              { $$ = $2; }
;
```

- Compilation Steps
```console
bison -d main.y
flex main.l

gcc -o main lex.yy.c main.tab.c -ly
./main
```

- Output
```console
(1+2) + (2 * 3 * (6))
39
```
