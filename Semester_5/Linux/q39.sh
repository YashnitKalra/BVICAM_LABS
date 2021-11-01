#! /usr/bin/bash

read -p "Enter marks of 5 subjects (out of 100): " -a arr;
s=0
for m in ${arr[@]}
do
    s=$(( s + m ))
done
s=$(( s / 5 ))
echo "Average Marks = $s";

if (( $s >= 60 ))
then
    echo "First Division"
elif (( $s >= 50 ))
then
    echo "Second Division"
elif (( $s >= 40 ))
then
    echo "Third Division"
else
    echo "Fail"
fi