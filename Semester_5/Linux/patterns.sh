#! /usr/bin/bash

echo -n "Enter Choice (1,2,3,4): ";
read ch;
echo -n "Enter n: ";
read n;

case $ch in
"1")
    i=1;
    while (( $i <= $n ))
    do
        j=1;
        while (( $j <= $i ))
        do
            echo -n "$j";
            (( j++ ))
        done
        echo "";
        (( i++ ))
    done
;;
"2")
    i=1;
    while (( $i <= $n ))
    do
        j=$(( n - i ))
        while (( $j > 0 ))
        do
            echo -n " ";
            (( j-- ))
        done
        j=1;
        while (( $j <= $i ))
        do
            echo -n "$j"
            (( j++ ))
        done
        echo "";
        (( i++ ))
    done
;;
"3")
    for (( i=1; i <= $n; i++ ))
    do
        for (( j=1; j <= $i; j++ ))
        do
            echo -n "#";
        done
        echo "";
    done
    for (( i=$n; i > 0; i-- ))
    do
        for (( j=1; j <= $i; j++ ))
        do
            echo -n "#";
        done
        echo "";
    done
;;
"4")
    for (( i=$n; i > 0; i-- ))
    do
        for (( j=$i; j > 0; j-- ))
        do
            echo -n "$j";
        done
        echo ""
    done
;;esac