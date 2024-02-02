# Lab 4

# Gowrish I 2022BCS0144

- Write a lex program to check whether given person is belong to IIIT Kottayam
  ```c
  %{
  #include <stdio.h>
  %}

  id (20)((1[89])|(2[0-3]))((BC[SDY])|(BEC))([0][0-9]{3})

  %%
  {id} {
  if (yytext[yyleng-1]=='0' && yytext[yyleng-2]=='0' && yytext[yyleng-3]=='0') {
    printf("Invalid");
  } else {
    printf("Valid");
  }
  }
  %%

  int yywrap() {return 1;}
  int main() {yylex();}
  ```

  ```console
  2022BCS0020
  Valid
  2022BCS0000
  Invalid
  ```
- Valid Phone Number
  ```c
  %{#include <sdtio.h>%}
  num ^(\91|0)[ ]*[6-9][0-9]{9}

  %%
  {num} {printf("Valid");}
  .* {printf("Not Valid");}

  int yywrap() {return 1;}
  int main() { yylex(); }
  %%
  ```

  ```console
  +919288892212
  Valid
  +91+0 127631
  Invalid
  ```
