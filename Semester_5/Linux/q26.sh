#! /usr/bin/bash

echo -n "Larger number is ";
if (( $1 > $2 ))
then
    echo $1;
else
    echo $2;
fi