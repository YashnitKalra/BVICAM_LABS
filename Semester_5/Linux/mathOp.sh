#! /usr/bin/bash

echo -n "Enter 1st number: ";
read num1;

echo -n "Enter 2nd number: ";
read num2;

echo -n "Enter operation (+, -, *, /): ";
read op;

case $op in
"+") echo $((num1 + $num2));;
"-") echo $((num1 - $num2));;
"*") echo $((num1 * $num2));;
"/") echo $((num1 / $num2));;
esac