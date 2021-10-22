#! /usr/bin/bash

echo "Enter Number: ";
read n;

fac=1;
i=1

while (( $i <= $n ))
do
    fac=$(( fac * i ));
    (( i++ ));
done
echo $fac;