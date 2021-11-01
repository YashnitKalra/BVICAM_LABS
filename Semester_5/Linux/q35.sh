#! /usr/bin/bash

read -p "Enter file 1 name: " file1
read -p "Enter file 2 name: " file2

t1=`stat --format="%Y" $file1`;
t2=`stat --format="%Y" $file2`;

f=$file2;

if (( $t1 < $t2 ))
then
    f=$file1;
fi

echo "File $f is older.";
echo "File Permissions for $f: `stat --format="%A" $f` (`stat --format="%a" $f`)";