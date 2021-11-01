#! /usr/bin/bash

echo -n "Enter 1st string: ";
read str1;
echo -n "Enter 2nd string: ";
read str2;

if [[ $str1 < $str2 ]]
then
    echo "Larger String is $str2";
else
    echo "Larger String is $str1";
fi