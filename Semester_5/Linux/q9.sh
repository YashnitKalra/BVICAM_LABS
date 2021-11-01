#! /usr/bin/bash

echo -n "Enter number: ";
read n;

s=0
while (( n>0 ))
do
    s=$(( s + n % 10 ))
    n=$(( n / 10 ))
done

echo "Sum of digits = $s";