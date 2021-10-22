/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP2;

import org.junit.Test;
import static org.junit.Assert.*;
import org.junit.Ignore;

/**
 *
 * @author yashnit
 */
public class MessageUtilityTest {
    
//    @Test(timeout=1000)
//    @Test(expected=ArithmeticException.class)
    @Ignore
    public void testShowMessage() {
        System.out.println("showMessage");
        MessageUtility instance = new MessageUtility("Hello World!!");
        String expResult = "Hello World!!";
        String result = instance.showMessage();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
