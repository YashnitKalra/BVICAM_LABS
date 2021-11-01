#! /usr/bin/bash

read -p "Enter array elements: " -a arr
echo "Array elements are: ${arr[@]}";

unset arr
read -p "Enter new array elements: " -a arr
echo "Array elements are: ${arr[@]}";