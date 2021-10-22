/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Square;

import java.util.Arrays;
import java.util.Collection;
import static org.junit.Assert.assertEquals;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;
import org.junit.runners.Parameterized.Parameters;

/**
 *
 * @author yashnit
 */
@RunWith(Parameterized.class)
public class SqaureCheckerTest {
    
    private int num, expectedResult;
    
    public SqaureCheckerTest(int num, int expectedResult){
        this.num = num;
        this.expectedResult = expectedResult;
    }
    
    @Parameters
    public static Collection<Integer[]> sqaureCheck(){
        Integer[][] data = new Integer[][]{{100, 10000}, {200, 40000}, {333, 110889}, {413, 170569}, {500, 250000}};
        return Arrays.asList(data);
    }  
    
    @Test
    public void testSquare() {
        System.out.println("Square of: " + num);
        SqaureChecker instance = new SqaureChecker();
        assertEquals(expectedResult, instance.square(num));
    }
    
}
