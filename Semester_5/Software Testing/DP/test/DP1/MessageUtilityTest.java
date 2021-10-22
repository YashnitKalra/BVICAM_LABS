/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package DP1;

import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yashnit
 */
public class MessageUtilityTest {
     
    @Test
    public void testShowMessage() {
        System.out.println("showMessage");
        MessageUtility instance = new MessageUtility("Hello World!!");
        String expResult = "Hello World!!";
        String result = instance.showMessage();
        assertEquals(expResult, result);
        assertNotNull(instance);
        assertTrue(instance!=null);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
