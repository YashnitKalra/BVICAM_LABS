#! /usr/bin/bash

function fun(){
    local a
    echo "Local: a = $a, b = $b"
}

a=5
b=7
echo "Global: a = $a, b = $b";
fun $a $b