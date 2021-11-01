#! /usr/bin/bash

read -p "Enter array elements: " -a arr;
read -p "Enter element to search: " e;
found=0

for i in ${arr[@]}
do
    if (( $i == $e ))
    then
        found=1
        break
    fi
done
if (( $found == 1 ))
then
    echo "Element found";
else
    echo "Element not found";
fi