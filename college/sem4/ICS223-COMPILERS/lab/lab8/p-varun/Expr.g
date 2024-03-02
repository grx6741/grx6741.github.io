grammar Expr;
start : statement+;

statement : ifexp| whileexp| assignment;

ifexp : 'if' '(' condition ')' '{' statement* '}' ('else' '{' statement* '}')?;
whileexp : 'while' '(' condition ')' '{' statement* '}';
condition : expr;
expr : value| expr op=('*' | '/' | '<' | '>') expr| expr op=('+' | '-') expr| '(' expr ')';
value : INTEGER| ID;
assignment : ID '=' expr ';';
ID : [a-zA-Z]+;
INTEGER : [0-9]+;
WS : [ \t\r\n]+ -> skip;
