#! /usr/bin/bash

for i in $@
do
    a=$1
    echo -n $a ""
    shift
done
echo ""