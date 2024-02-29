grammar Expr;

start : code_block EOF
      ;

code_block : statements
           ;

statements : (line)*
           ;

bool_expr : OPAREN bool_expr CPAREN
          | NOT bool_expr
          | bool_expr (AND | OR | XOR | GT | GTE | LT | LTE | EQ | NEQ | RSHIFT | LSHIFT) bool_expr
          | (IDEN | INT | FLOAT | BOOl)
          ;

line : (((VAR_TYPE)? IDEN ASSIGN (( INT | FLOAT | IDEN | BOOl) | bool_expr))? SEMICOLON)+
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
LSHIFT    : '<<';
RSHIFT    : '>>';
NEQ       : '!=';
ASSIGN    : '=';
SEMICOLON : ';';
PLUS : '+';
MINUS : '-';
MULT : '*';
DIV : '/';
SPACE     : [ \n\t\r] -> skip;
