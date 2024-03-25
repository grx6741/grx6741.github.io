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
