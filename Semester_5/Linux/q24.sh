#! /usr/bin/bash

read -p "Enter numbers in array: " -a arr
s=0
for e in ${arr[@]}
do
    s=$(( s + e ))
done
echo "Sum of numbers = $s";