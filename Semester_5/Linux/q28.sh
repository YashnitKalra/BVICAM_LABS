#! /usr/bin/bash

s=$1
l=${#1}

for str in $@
do
    if (( ${#str} < l ))
    then
        s=${str}
        l=${#str}
    fi
done
echo "Smallest String: $s";