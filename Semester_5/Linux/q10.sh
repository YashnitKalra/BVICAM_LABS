#! /usr/bin/bash

echo -n "Enter real number 1: ";
read p;
echo -n "Enter real number 2: ";
read q;
s=`echo $p + $q | bc`
echo "$p + $q = $s";