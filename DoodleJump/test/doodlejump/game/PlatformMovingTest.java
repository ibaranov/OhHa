/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doodlejump.game;

import doodlejump.game.Direction;
import doodlejump.game.PlatformMoving;
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
    private PlatformMoving platform;
    
    public PlatformMovingTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Set up class");
    }
    
   
    
    @Before
    public void setUp() {
        System.out.println("Setup a Platform");
        platform = new PlatformMoving(400, 100);
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
     * Test of addToX method, of class PlatformMoving.
     */
    @Test
    public void testAddToX() {
        System.out.println("addToX");
        double xVel = 12;
        int oldX = platform.getX();
        platform.increaseX(xVel);
        assertEquals(platform.getX(), 12+oldX);
        
        
    }

    

    /**
     * Test of move method, of class PlatformMoving.
     */
    @Test
    public void testMove() {
        System.out.println("move");
        
        int xVel = platform.getxVelocity();
        int oldX = platform.getX();
        // test moving left
        platform.move();
        assertEquals(platform.getX(), oldX-xVel);
        
        // test changing direction to right 
        platform.setX(-1);
        platform.move();
        assertEquals(platform.getDirection(), Direction.RIGHT);
        
        // test changing direction to left
        platform.setX(380);
        platform.move();
        // test moving right
        assertEquals(platform.getX(), 380+xVel);
        
        assertEquals(platform.getDirection(), Direction.LEFT);
    }
}