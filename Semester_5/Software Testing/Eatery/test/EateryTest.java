/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

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
public class EateryTest {
    
    private int billAmount;
    private boolean isPickedUp;
    private int expectedResult;

    public EateryTest(int billAmount, boolean isPickedUp, int expectedResult) {
        this.billAmount = billAmount;
        this.isPickedUp = isPickedUp;
        this.expectedResult = expectedResult;
    }
    
    @Parameters
    public static Collection<Object[]> billCheck(){
        Object[][] data = new Object[][]{{100, true, 100}, {270, false, 280}, {500, false, 510}, {315, true, 315}, {405, false, 415}};
        return Arrays.asList(data);
    }
    
    @Test
    public void testCheck(){
        System.out.println("Bill Amount: " + billAmount +", Order Picked Up: " + isPickedUp);
        Eatery instance = new Eatery();
        assertEquals(expectedResult, instance.calculateBill(billAmount, isPickedUp));
    }
    
}
