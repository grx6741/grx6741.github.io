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
       E_DASH E '\n'                   { printf("%d\n", $2); }
|;

E:
                FLOAT
|               INTEGER
|               E '+' E       { $$ = $1 + $3; }
|               E '-' E       { $$ = $1 - $3; }
|               E '*' E       { $$ = $1 * $3; }
|               E '/' E       { $$ = $1 / $3; }
|               '(' E ')'              { $$ = $2; }
;
