#! /usr/bin/bash

read -p "Enter Array 1 elements: " -a arr;
read -p "Enter Array 2 elements: " -a brr;
crr=(${arr[@]} ${brr[@]});
echo ${crr[@]};