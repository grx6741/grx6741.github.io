# ICS 223 COMPILER DESIGN LAB 11

## Gowrish I 2022BCS0155

### Write YACC program for the following grammar  

```
S-->SS+ | SS* | a
```

```lex
%{

#include<stdio.h>
#include "main.tab.h"

extern int yylval;
%}

%%

[a] {
    return ID;
}

[\t] { }

[ ] { }

[\n] {
return 0;
}

. {
    return yytext[0];
}

%%

int yywrap() { return 1; }
```

```yacc
%{
#include<stdio.h>
#include<stdlib.h>
int yylex();
void yyerror();
%}
%token ID

%%
exp: exp exp '*'
   exp: exp exp '+'
exp: ID
   ;
%%

int main() {
   printf("enter the expression for the grammar S-->SS+ | SS* | a\n");
   yyparse();
   printf("valid experession\n");
}
void yyerror() {
    printf("\n syntax error!");
    exit(0);
}
```

```console
enter the expression for the grammar S-->SS+ | SS* | a
aa+
valid experession

enter the expression for the grammar S-->SS+ | SS* | a
a a *
valid experession

enter the expression for the grammar S-->SS+ | SS* | a
a * a
syntax error!
```

### Write Yacc programs for the following grammar. Form valid and invalid input strings manually and give them as input for your executable code of yacc program and validate the input strings.

```console
S->L=R | R
L-> *R | id
R->L
```

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

```yacc
%{
#include<stdio.h>
#include<stdlib.h>
int flag=0;
int yylex();
void yyerror();
%}

%token ID

%%
S: S'='L|R {flag++;}
L:'*' R| ID
R:L
;
%%
int main() {
    printf("enter the expression for the grammar \n S->S-LIR \n L->R | ID \n R->L\n");
    yyparse();

    if (flag) 
        printf("valid experession\n");
    else 
        yyerror();
}

void yyerror() { 
    printf("Invalid expression\n"); exit(1);
}
```

```console
enter the expression for the grammar
 S->S-LIR
 L->R | ID
 R->L
abc = xyz
valid experession

enter the expression for the grammar
 S->S-LIR
 L->R | ID
 R->L
+
+Invalid expression
```
