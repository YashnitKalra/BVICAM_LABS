/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Addition;

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
public class AdditionTest {
    
    private int num1, num2, expectedResult;
    
    public AdditionTest(int num1, int num2, int expectedResult){
        this.num1 = num1;
        this.num2 = num2;
        this.expectedResult = expectedResult;
    }
    
    @Parameterized.Parameters
    public static Collection<Integer[]> sqaureCheck(){
        Integer[][] data = new Integer[][]{{1, 20, 21}, {10, 20, 30}, {10, 11, 21}, {1, 11, 12}, {8, 14, 22}};
        return Arrays.asList(data);
    }  
    
    @Test
    public void testSquare() {
        System.out.println("Addition of: " + num1 + " and " + num2);
        Addition instance = new Addition();
        assertEquals(expectedResult, instance.add(num1, num2));
    }
    
}
