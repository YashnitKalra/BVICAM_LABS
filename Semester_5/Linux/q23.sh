#! /usr/bin/bash

read -p "Enter elements of Array 1: " -a arr;
read -p "Enter elements of Array 2: " -a brr;
temp=${arr[@]}
arr=( ${brr[@]} 100 )
brr=( ${temp[@]} 200 )
echo "Array 1 after swapping and appending: ${arr[@]}";
echo "Array 2 after swapping and appending: ${brr[@]}";