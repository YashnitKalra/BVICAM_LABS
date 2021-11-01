#! /usr/bin/bash

echo -n "Enter a number: ";
read n
p=0

while (( n > 0 ))
do
    p=$(( p * 10 + n % 10 ))
    n=$(( n / 10 ))
done
echo "Reverse: $p"