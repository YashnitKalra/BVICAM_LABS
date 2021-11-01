#! /usr/bin/bash

read -p "Enter array elements: " -a arr;
for e in ${arr[@]}
do
    echo "Length of ${e} is ${#e}";
done