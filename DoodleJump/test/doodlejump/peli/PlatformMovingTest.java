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
public class PlatformMovingTest {
    
    public PlatformMovingTest() {
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
     * Test of addToX method, of class PlatformMoving.
     */
    @Test
    public void testAddToX() {
        System.out.println("addToX");
        double xVel = 0.0;
        PlatformMoving instance = null;
        instance.addToX(xVel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of piirra method, of class PlatformMoving.
     */
    @Test
    public void testPiirra() {
        System.out.println("piirra");
        Graphics graphics = null;
        PlatformMoving instance = null;
        instance.piirra(graphics);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of move method, of class PlatformMoving.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        PlatformMoving instance = null;
        instance.move();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}