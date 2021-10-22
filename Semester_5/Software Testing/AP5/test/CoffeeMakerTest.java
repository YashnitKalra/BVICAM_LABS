/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author yashnit
 */
public class CoffeeMakerTest {
    
    public CoffeeMakerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
    }
    
    @After
    public void tearDown() {
    }

    /**
     * Test of isCoffeeMakerWorking method, of class CoffeeMaker.
     */
    @Test
    public void testIsCoffeeMakerWorking() {
        System.out.println("isCoffeeMakerWorking");
        CoffeeMaker instance = new CoffeeMaker(600, 15, 700);
        boolean expResult = true;
        boolean result = instance.isCoffeeMakerWorking();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
