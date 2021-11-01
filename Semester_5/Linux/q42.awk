#! /usr/bin/awk -f

BEGIN{
    print "Calculate factorial of: ";
    getline n < "-";
    m = 1;
    while(n > 0){
        m = m*n;
        n--;
    }
    print "Factorial is", m;
}