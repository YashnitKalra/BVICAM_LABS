#! /usr/bin/bash

function fac(){
    if (( $n > 0 ))
    then
        m=$(( m * n ))
        (( n-- ))
        fac m n;
    fi
}

read -p "Find Factorial of: " n;
m=1
fac m n;
echo $m;