#! /usr/bin/bash

echo "Enter Filename: "
read name;

echo "Using wc";
wc -l $name;

echo "Using grep";
grep -c ".*" $name;