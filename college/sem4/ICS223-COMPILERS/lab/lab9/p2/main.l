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
