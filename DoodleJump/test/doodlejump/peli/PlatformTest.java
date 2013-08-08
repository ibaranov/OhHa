/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doodlejump.peli;

import java.awt.Graphics;
import java.awt.Image;
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
public class PlatformTest {
    
    public PlatformTest() {
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
     * Test of setPlatName method, of class Platform.
     */
    @Test
    public void testSetPlatName() {
        System.out.println("setPlatName");
        String platName = "";
        Platform instance = null;
        instance.setPlatName(platName);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setType method, of class Platform.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        int type = 0;
        Platform instance = null;
        instance.setType(type);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setImg method, of class Platform.
     */
    @Test
    public void testSetImg() {
        System.out.println("setImg");
        Image img = null;
        Platform instance = null;
        instance.setImg(img);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getType method, of class Platform.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        Platform instance = null;
        int expResult = 0;
        int result = instance.getType();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setY method, of class Platform.
     */
    @Test
    public void testSetY() {
        System.out.println("setY");
        int y = 0;
        Platform instance = null;
        instance.setY(y);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getImg method, of class Platform.
     */
    @Test
    public void testGetImg() {
        System.out.println("getImg");
        Platform instance = null;
        Image expResult = null;
        Image result = instance.getImg();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of piirra method, of class Platform.
     */
    @Test
    public void testPiirra() {
        System.out.println("piirra");
        Graphics graphics = null;
        Platform instance = null;
        instance.piirra(graphics);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlatName method, of class Platform.
     */
    @Test
    public void testGetPlatName() {
        System.out.println("getPlatName");
        Platform instance = null;
        String expResult = "";
        String result = instance.getPlatName();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getX method, of class Platform.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        Platform instance = null;
        int expResult = 0;
        int result = instance.getX();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getY method, of class Platform.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        Platform instance = null;
        int expResult = 0;
        int result = instance.getY();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getWidth method, of class Platform.
     */
    @Test
    public void testGetWidth() {
        System.out.println("getWidth");
        Platform instance = null;
        int expResult = 0;
        int result = instance.getWidth();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getHeight method, of class Platform.
     */
    @Test
    public void testGetHeight() {
        System.out.println("getHeight");
        Platform instance = null;
        int expResult = 0;
        int result = instance.getHeight();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addToY method, of class Platform.
     */
    @Test
    public void testAddToY() {
        System.out.println("addToY");
        double yVelocity = 0.0;
        Platform instance = null;
        instance.addToY(yVelocity);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setX method, of class Platform.
     */
    @Test
    public void testSetX() {
        System.out.println("setX");
        int nx = 0;
        Platform instance = null;
        instance.setX(nx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of increaseX method, of class Platform.
     */
    @Test
    public void testIncreaseX() {
        System.out.println("increaseX");
        double xVel = 0.0;
        Platform instance = null;
        instance.increaseX(xVel);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of addToX method, of class Platform.
     */
    @Test
    public void testAddToX() {
        System.out.println("addToX");
        int nx = 0;
        Platform instance = null;
        instance.addToX(nx);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of dissapear method, of class Platform.
     */
    @Test
    public void testDissapear() {
        System.out.println("dissapear");
        Platform instance = null;
        instance.dissapear();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getBouncedOn method, of class Platform.
     */
    @Test
    public void testGetBouncedOn() {
        System.out.println("getBouncedOn");
        Platform instance = null;
        boolean expResult = false;
        boolean result = instance.getBouncedOn();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setBouncedOn method, of class Platform.
     */
    @Test
    public void testSetBouncedOn() {
        System.out.println("setBouncedOn");
        boolean bouncedOn = false;
        Platform instance = null;
        instance.setBouncedOn(bouncedOn);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}