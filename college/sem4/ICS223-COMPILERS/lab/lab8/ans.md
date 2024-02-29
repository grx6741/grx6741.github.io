# ICS 223 

## LAB 8 2022BCS0155 Gowrish I

### Make Antlr Expression Files for the following cases

1. Arithmetic Expressions

```g
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

```

```console
int a = 2 + 2 * 3;
float k = 420.69 + 3 + 12;
a = true;
```

2. Boolean Expressions 

```g
```

```console
k = a >= 10;
a = ~50;
b = (a >> 1) & (b << 25);
x = y | (a & b);

```

3. While and if statements

```g
grammar Expr;

start : code_block EOF
      ;

code_block : statements
           ;

statements : (line | if_stat | while_stat)*
           ;

while_stat : WHILE condition conditional_block
           ;

if_stat : IF condition conditional_block (ELSE IF condition conditional_block )* (ELSE conditional_block)?
        ;

conditional_block : OFLOWER code_block CFLOWER
         ;

condition : OPAREN bool_expr CPAREN
          ;

bool_expr : OPAREN bool_expr CPAREN
          | NOT bool_expr
          | bool_expr (AND | OR | XOR | GT | GTE | LT | LTE | EQ | NEQ) bool_expr
          | (IDEN | INT | FLOAT | BOOl)
          ;

line : (((VAR_TYPE)? IDEN ASSIGN ( INT | FLOAT | IDEN | BOOl))? SEMICOLON)+
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
```

```console
while (1 > 2) {
    int a = 2;
}

if ( a > b ) {
    int c = 10;
    int q = 10;
} else if (10 == 20) {
    int hello = 69;
    while (true) {
        int k = 10;
    }
} else if (20) {
    float k = 420.69;
} else {
    bool a = true;
}
```
