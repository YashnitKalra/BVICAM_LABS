#! /usr/bin/bash

s=0
for i in $@
do
    s=$(( s + i ))
done
echo "Sum is $s";