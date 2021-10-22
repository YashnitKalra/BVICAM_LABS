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
public class ProductRepositoryTest {
    
    public ProductRepositoryTest() {
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
     * Test of addProduct method, of class ProductRepository.
     */
    @Test
    public void testAddProduct() {
        System.out.println("addProduct");
        Product product = new Product(1, "Soap", 20.0);;
        ProductRepository instance = new ProductRepository();
        boolean expResult = true;
        boolean result = instance.addProduct(product);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of deleteProduct method, of class ProductRepository.
     */
    @Test
    public void testDeleteProduct() {
        System.out.println("deleteProduct");
        int id = 10;
        ProductRepository instance = new ProductRepository();
        boolean expResult = false;
        boolean result = instance.deleteProduct(id);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }

    /**
     * Test of updateProduct method, of class ProductRepository.
     */
    @Test
    public void testUpdateProduct() {
        System.out.println("updateProduct");
        int id = 1;
        Product product = new Product(1, "Trimmer", 800.0);
        ProductRepository instance = new ProductRepository();
        instance.addProduct(new Product(1, "Soap", 20.0));
        boolean expResult = true;
        boolean result = instance.updateProduct(id, product);
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
//        fail("The test case is a prototype.");
    }
    
}
