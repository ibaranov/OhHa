/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doodlejump.peli;

import java.awt.Graphics;
import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import static org.junit.Assert.*;

/**
 *
 * @author Ivan
 */
public class PlatformDissapearingTest {
    
    public PlatformDissapearingTest() {
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
     * Test of dissapear method, of class PlatformDissapearing.
     */
    @Test
    public void testDissapear() {
        System.out.println("dissapear");
        PlatformDissapearing instance = null;
        instance.dissapear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of piirra method, of class PlatformDissapearing.
     */
    @Test
    public void testPiirra() {
        System.out.println("piirra");
        Graphics graphics = null;
        PlatformDissapearing instance = null;
        instance.piirra(graphics);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}