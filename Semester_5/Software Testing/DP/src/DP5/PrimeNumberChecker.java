/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP5;

/**
 *
 * @author yashnit
 */
public class PrimeNumberChecker {
    public boolean isPrime(int n){
        for(int i=2; i*i<=n; i++)
            if(n%i==0)
                return false;
        return true;
    }
}
