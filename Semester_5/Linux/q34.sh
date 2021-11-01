#! /usr/bin/bash

read -p "Enter numbers: " -a arr;
l=${arr[0]}

for i in ${arr[@]}
do
    if (( ${i} > ${l} ))
    then
        l=$i
    fi
done

echo "Largest Number Present: $l";