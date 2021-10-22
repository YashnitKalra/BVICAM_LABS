#! /usr/bin/bash

echo "Enter Number 1: ";
read a;
echo "Enter Number 2: ";
read b;
echo "Enter Number 3: ";
read c;

if(($a>=$b && $a>=$c))
then
	echo "MAX is $a";
elif (($b>=$a && $b>=$c))
then
	echo "MAX is $b";
else
	echo "MAX is $c";
fi
