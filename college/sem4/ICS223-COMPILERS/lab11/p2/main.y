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
