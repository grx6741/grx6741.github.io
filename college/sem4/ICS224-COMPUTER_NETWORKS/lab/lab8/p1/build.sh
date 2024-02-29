#!/bin/sh

set -xe

mkdir -p bin
gcc -o bin/main main.c -lm

./bin/main
