#! /usr/bin/bash

if [[ -f $1 && -f $2 ]]
then
    cp $1 temp
    cp $2 $1
    cp temp $2
    rm temp
else
    echo "Error invalid file name(s)."
fi