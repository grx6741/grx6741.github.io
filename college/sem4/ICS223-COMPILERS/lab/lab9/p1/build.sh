#!/bin/sh

lex main.l
gcc -o main lex.yy.c

cat inputs.txt | ./main
