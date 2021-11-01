#! /usr/bin/bash

function display(){
    if (( $n > 0 ))
    then
        echo "Hello World"
        (( n-- ))
        display $n;
    fi
}

read -p "Number of times to print message: " n;
display $n