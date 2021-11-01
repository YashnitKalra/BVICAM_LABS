#! /usr/bin/bash

echo -n "Enter numbers: ";
read -a arr;

n=${#arr[@]}
for (( i=0; i < n; i++ ))
do
    for (( j=0; j<$(( n - i - 1 )); j++ ))
    do
        if (( ${arr[$j]} > ${arr[$j+1]} ))
        then
            arr[$j]=$(( ${arr[$j]} ^ ${arr[$j+1]} ));
            arr[$j+1]=$(( ${arr[$j]} ^ ${arr[$j+1]} ));
            arr[$j]=$(( ${arr[$j]} ^ ${arr[$j+1]} ));
        fi
    done
done
echo "Sorted Array: ${arr[@]}";