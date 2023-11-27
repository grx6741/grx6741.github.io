#!/bin/sh

mkdir -p bin
gcc -o bin/main main.c
echo "18" | ./bin/main
