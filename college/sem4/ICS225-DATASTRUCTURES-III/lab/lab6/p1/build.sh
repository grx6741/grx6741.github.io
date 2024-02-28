#!/bin/sh

mkdir -p bin
g++ -o bin/main main.cpp

echo inputs.txt | ./bin/main
