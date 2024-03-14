#!/bin/sh

bison -d main.y
flex main.l

gcc -o main lex.yy.c main.tab.c -ly
./main
