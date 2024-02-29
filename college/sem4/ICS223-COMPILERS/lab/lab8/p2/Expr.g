grammar Expr;

start : code_block EOF
      ;

code_block : statements
           ;

statements : (line)*
           ;

line : (((VAR_TYPE)? IDEN ASSIGN (( INT | FLOAT | IDEN | BOOl) | arithmetic_expr))? SEMICOLON)+
     ;

arithmetic_expr : OPAREN arithmetic_expr CPAREN
                | arithmetic_expr (PLUS | MINUS | MULT | DIV) arithmetic_expr
                | (IDEN | INT | FLOAT )
                ;

IF        : 'if';
ELSE      : 'else';
WHILE     : 'while';
VAR_TYPE  : ( 'int' | 'float' | 'bool' );
IDEN      : [a-zA-Z_][a-zA-Z_0-9]*;
BOOl      : ( 'true' | 'false' );
INT       : [0-9]+;
FLOAT     : [0-9]+ '.' [0-9]*
          | '.' [0-9]+
          ;

OPAREN    : '(';
CPAREN    : ')';
OFLOWER   : '{';
CFLOWER   : '}';
NOT       : '~';
AND       : '&';
OR        : '|';
XOR       : '^';
GT        : '>';
GTE       : '>=';
LT        : '<';
LTE       : '<=';
EQ        : '==';
NEQ       : '!=';
ASSIGN    : '=';
SEMICOLON : ';';
PLUS : '+';
MINUS : '-';
MULT : '*';
DIV : '/';
SPACE     : [ \n\t\r] -> skip;
