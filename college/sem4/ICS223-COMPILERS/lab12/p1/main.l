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

