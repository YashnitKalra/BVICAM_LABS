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
public class ArithmeticTest {
    
    public ArithmeticTest() {
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
     * Test of add method, of class Arithmetic.
     */
    @Test
    public void testAdd() {
        System.out.println("add");
        double a = 4.182;
        double b = 1.818;
        Arithmetic instance = new Arithmetic();
        double expResult = 6.0;
        double result = instance.add(a, b);
        assertEquals(expResult, result, 0.0);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of divide method, of class Arithmetic.
     */
    @Test
    public void testDivide() {
        System.out.println("divide");
        double a = 4.725;
        double b = 2.25;
        Arithmetic instance = new Arithmetic();
        Double expResult = 2.1;
        Double result = instance.divide(a, b);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
