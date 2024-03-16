#!/bin/sh

set -xe

mkdir -p bin
g++ -o bin/main main.cpp -lpthread

./bin/main
