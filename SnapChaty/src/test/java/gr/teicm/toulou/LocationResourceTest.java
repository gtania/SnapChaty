/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package gr.teicm.toulou;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Τάνια
 */
public class LocationResourceTest {
    
    public LocationResourceTest() {
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
     * Test of postLocation method, of class LocationResource.
     */
    @Test
    public void testPostLocation() {
        System.out.println("postLocation");
        String location = "{latitude:\"32\",longtitude:\"32\",username:\"TaniaG\"}";
        LocationResource instance = new LocationResource();
        String expResult = "Got Location";
        String result = instance.postLocation(location);
        assertEquals(expResult, result);
        
    }
    
}
