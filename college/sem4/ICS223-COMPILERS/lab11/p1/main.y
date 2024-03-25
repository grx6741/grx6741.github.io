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
