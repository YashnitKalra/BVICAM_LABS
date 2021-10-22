/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Delhi_University;

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
public class UGCourseTest {
    
    public UGCourseTest() {
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
     * Test of checkMath method, of class UGCourse.
     */
    @Test
    public void testCheckMath() {
        System.out.println("checkMath");
        UGCourse instance = new UGCourse(80, 70, 75, 50, 60);
        boolean expResult = true;
        boolean result = instance.checkMath();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of checkChemistry method, of class UGCourse.
     */
    @Test
    public void testCheckChemistry() {
        System.out.println("checkChemistry");
        UGCourse instance = new UGCourse(80, 70, 75, 50, 60);
        boolean expResult = true;
        boolean result = instance.checkChemistry();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of checkPhysics method, of class UGCourse.
     */
    @Test
    public void testCheckPhysics() {
        System.out.println("checkPhysics");
        UGCourse instance = new UGCourse(80, 70, 75, 50, 60);
        boolean expResult = true;
        boolean result = instance.checkPhysics();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of checkEligibility method, of class UGCourse.
     */
    @Test
    public void testCheckEligibility() {
        System.out.println("checkEligibility");
        UGCourse instance = new UGCourse(80, 70, 75, 50, 60);
        boolean expResult = true;
        boolean result = instance.checkEligibility();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of checkHonorsEligibility method, of class UGCourse.
     */
    @Test
    public void testCheckHonorsEligibility() {
        System.out.println("checkHonorsEligibility");
        UGCourse instance = new UGCourse(80, 70, 75, 50, 60);
        boolean expResult = true;
        boolean result = instance.checkHonorsEligibility();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
