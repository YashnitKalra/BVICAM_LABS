#! /usr/bin/bash

read -p "Enter n: " n;
a=0
b=1

if (( $n == 1 ))
then
    echo "$a";
else
    echo -n "$a $b";
    n=$(( $n - 2 ))
    while (( $n > 0 ))
    do
        c=$(( $a + $b ))
        a=$b
        b=$c
        echo -n " $c"
        (( n-- ))
    done
fi
echo ""