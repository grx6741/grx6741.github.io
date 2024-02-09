#!/bin/sh

mkdir -p bin

gcc -o bin/main main.c -lm
./bin/main
