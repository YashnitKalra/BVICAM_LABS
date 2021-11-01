#! /usr/bin/bash

read -p "Enter filename: " file

if [ -w $file ]
then
    echo "Hello World" >> $file;
else
    echo "No write permission to the file: $file"
fi