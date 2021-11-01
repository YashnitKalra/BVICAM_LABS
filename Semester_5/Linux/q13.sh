#! /usr/bin/bash

echo -n "Enter Filename: ";
read file

if [[ -f $file ]]
then
    echo `file $file`
else
    echo "File does not exist."
fi