#!/bin/sh
# Define some constants
BIN_PATH=./bin/java
SRC_PATH=./src/java

# First remove the sources.list file if it exists and then create the sources file of the project
rm -f $SRC_PATH/sources.list
find $SRC_PATH -name \*.java > $SRC_PATH/sources.list

rm -rf $BIN_PATH
mkdir -p $BIN_PATH

# Compile the project
javac -d $BIN_PATH  @$SRC_PATH/sources.list
