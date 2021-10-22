/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author yashnit
 */
import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

@RunWith(Parameterized.class)
public class PrimeNumberCheckerTest {
    
    private int num;
    private boolean expectedResult;
    
    public PrimeNumberCheckerTest(int num, boolean expectedResult){
        this.num = num;
        this.expectedResult = expectedResult;
    }
    
    @Parameters
    public static Collection<Object[]> primeCheck(){
        Object[][] data = new Object[][]{{5, true}, {27, false}, {100, false}, {23, true}, {79, true}};
        return Arrays.asList(data);
    }
    
    @Test
    public void testCheck(){
        System.out.println("Check for number: " + num);
        PrimeNumberChecker instance = new PrimeNumberChecker();
        assertEquals(expectedResult, instance.isPrime(num));
    }
}
