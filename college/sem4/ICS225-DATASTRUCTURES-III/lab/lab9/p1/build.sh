#!/bin/sh

set -xe

mkdir -p bin
g++ -o bin/main main.cpp

./bin/main
