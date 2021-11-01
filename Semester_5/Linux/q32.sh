#! /usr/bin/bash

function sum(){
    if (( $n >= 0 ))
    then
        s=$(( s + ${arr[$n]} ))
        (( n-- ))
        sum $s $n
    fi
}

read -p "Enter numbers: " -a arr;
n=$(( ${#arr[@]} - 1 ));
s=0
sum $s $n
echo $s;