#!/bin/bash
mkdir -p bin/cpp
cd src/cpp
make
mv liblda.so ../../bin/cpp/
make clean
cd -
./compile_java.sh
cd ./bin/java
jar -cfv ldawapper.jar edu/
cd -

