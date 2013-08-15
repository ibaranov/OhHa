/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doodlejump.peli;

import java.awt.Graphics;
import java.awt.Image;
import javax.swing.ImageIcon;
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
    
    private Platform platform;
    
    public PlatformTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Set up class");
    }
    
   
    
    @Before
    public void setUp() {
        System.out.println("Setup a Platform");
        platform = new Platform(400, 100);
    }
    
    @After
    public void tearDown() {
        System.out.println(" = Teardown");
        platform = null;
    }
    
     @AfterClass
    public static void tearDownClass() {
        System.out.println("Tear down class");
    }

    /**
     * Test of setPlatName method, of class Platform.
     */
    @Test
    public void testSetPlatName() {
        System.out.println("setPlatName");
        String platName = "C:\\Users\\Ivan\\Documents\\GitHub\\OhHa\\DoodleJump\\src\\doodlejump\\peli\\images\\cloud_basic.png";
        platform.setPlatName(platName);
        assertEquals(platform.getPlatName(), platName);
    }

    /**
     * Test of setType method, of class Platform.
     */
    @Test
    public void testSetType() {
        System.out.println("setType");
        int type = 3;
        platform.setType(type);
        assertEquals(platform.getType(), type);
    }

    /**
     * Test of setImg method, of class Platform.
     */
    @Test
    public void testSetImg() {
        System.out.println("setImg");
        Image img = null;
        String platName = "C:\\Users\\Ivan\\Documents\\GitHub\\OhHa\\DoodleJump\\src\\doodlejump\\peli\\images\\cloud_basic.png";
        ImageIcon ii = new ImageIcon(platName);
        img = ii.getImage();
        
        platform.setImg(img);
        assertEquals(platform.getImg(), img);
        
    }

    /**
     * Test of getType method, of class Platform.
     */
    @Test
    public void testGetType() {
        System.out.println("getType");
        
        int type = 3;
        platform.setType(type);
        assertEquals(platform.getType(), type);
    }

    

    /**
     * Test of getImg method, of class Platform.
     */
    @Test
    public void testGetImg() {
        System.out.println("getImg");
        System.out.println("Already tested in setImg");
    }

    

    
    /**
     * Test of addToY method, of class Platform.
     */
    @Test
    public void testAddToY() {
        System.out.println("addToY");
        double yVelocity = 2;
        platform.addToY(yVelocity);
        assertEquals(platform.getY(), 102);
        
    }

   
    /**
     * Test of increaseX method, of class Platform.
     */
    @Test
    public void testIncreaseX() {
        System.out.println("increaseX");
        double xVel = 12;
        int oldX = platform.getX();
        platform.increaseX(xVel);
        assertEquals(platform.getX(), 12+oldX);
        
    }

    /**
     * Test of addToX method, of class Platform.
     */
    @Test
    public void testAddToX() {
        System.out.println("addToX");
        int nx = 12;
        int oldX = platform.getX();
        platform.addToX(nx);
        assertEquals(platform.getX(), oldX+nx);
        
    }

    /**
     * Test of disappear method, of class Platform.
     */
    @Test
    public void testDissapear() {
        System.out.println("dissapear");
        platform.dissapear();
    }

    /**
     * Test of getBouncedOn method, of class Platform.
     */
    @Test
    public void testGetBouncedOn() {
        System.out.println("getBouncedOn");
        boolean expResult = false;
        boolean result = platform.getBouncedOn();
        assertEquals(expResult, result);
    }

    /**
     * Test of setBouncedOn method, of class Platform.
     */
    @Test
    public void testSetBouncedOn() {
        System.out.println("setBouncedOn");
        boolean bouncedOn = true;
        platform.setBouncedOn(bouncedOn);
        assertEquals(bouncedOn, platform.getBouncedOn());
    }
}