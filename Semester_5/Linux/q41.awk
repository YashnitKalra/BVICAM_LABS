#! /usr/bin/awk -f

BEGIN{
    print "Enter number 1: ";
    getline n1 < "-";
    print "Enter number 2: ";
    getline n2 < "-";
    print "Sum is", (n1 + n2);
}
