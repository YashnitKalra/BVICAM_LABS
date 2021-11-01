#! /usr/bin/bash

echo "Enter array elements: ";
read -a arr;

n=${#arr[@]};
for (( i=n-1; i >= 0; i-- ))
do
    echo -n "${arr[$i]} "
done
echo "";