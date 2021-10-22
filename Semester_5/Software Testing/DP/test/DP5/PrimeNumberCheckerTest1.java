/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP5;

import java.util.Arrays;
import java.util.Collection;
import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

/**
 *
 * @author yashnit
 */
@RunWith(Parameterized.class)
public class PrimeNumberCheckerTest1 {
    
    private int num;
    private boolean expectedResult;
    
    public PrimeNumberCheckerTest1(int num, boolean expectedResult){
        this.num = num;
        this.expectedResult = expectedResult;
    }
    
    @Parameterized.Parameters
    public static Collection<Object[]> primeCheck(){
        Object[][] data = new Object[][]{{5, true}, {27, false}, {100, false}, {23, true}, {79, true}};
        return Arrays.asList(data);
    }
    
    @Test(expected=NullPointerException.class)
    public void testCheck(){
        System.out.println("Check for number: " + num);
        PrimeNumberChecker instance = null;
        assertEquals(expectedResult, instance.isPrime(num));
    }
}