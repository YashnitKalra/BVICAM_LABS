#! /usr/bin/bash

echo "Enter String: ";
read name;

if [[ -d $name ]]
then
    ls $name;
elif [[ -f $name ]]
then
    cat $name;
else
    echo "Error: Neither file nor directory name";
fi