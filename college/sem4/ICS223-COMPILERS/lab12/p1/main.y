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
