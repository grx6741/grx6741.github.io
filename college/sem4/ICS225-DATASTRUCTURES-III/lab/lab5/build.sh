#!/bin/sh

mkdir -p bin
g++ -o bin/main main.cpp
cat inputs.txt | ./bin/main
