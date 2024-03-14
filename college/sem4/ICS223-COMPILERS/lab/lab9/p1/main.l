%{
#include <stdio.h>
%}

int [-+]?[0-9]+
float [+-]?[0-9]*[.][0-9]+
identifier [_a-zA-Z]+[_a-zA-Z0-9]*

literal ({int}|{float}|{identifier})
operator [+-/*]
parenthesis [()]

%%

{literal} {
    printf("| %s: Literal", yytext);
}

{operator} {
    printf("| %s: Operator", yytext);
}

{parenthesis} {
    printf("| %s: Parenthesis", yytext);
}


%%

int yywrap() {}

int main() {
    yylex();
}
