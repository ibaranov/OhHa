/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doodlejump.game;

import doodlejump.game.Direction;
import doodlejump.game.Platform;
import doodlejump.game.Player;
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
public class PlayerTest {
    
    private Player player;
    
    public PlayerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Set up class");
    }
    
    
    @Before
    public void setUp() {
        System.out.println("Setup a Player");
        player = new Player(400, 200, Direction.INPLACE);
    }
    
    @After
    public void tearDown() {
        System.out.println(" = Teardown");
        player = null;
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Tear down class");
    }
    
   

    /**
     * Test of addToScore method, of class Player.
     */
    @Test
    public void testAddToScore() {
        System.out.println("addToScore");
        double yVel = 10.0;
        
        player.addToScore(yVel);
        
        assertEquals(player.getScore(), 10, 0.0001);
    }

    /**
     * Test of getX method, of class Player.
     */
    @Test
    public void testGetX() {
        System.out.println("getX");
        double expResult = 200;
        double result = player.getX();
        assertEquals(expResult, result, 0.0001);
        
    }

    /**
     * Test of getY method, of class Player.
     */
    @Test
    public void testGetY() {
        System.out.println("getY");
        
        double expResult = 200;
        double result = player.getY();
        assertEquals(expResult, result, 0.0);
        
    }

    /**
     * Test of jump method, of class Player.
     */
    @Test
    public void testJump() {
        System.out.println("jump");
        double delta = 1;
        player.jump(delta);
        assertEquals(player.getyVelocity(), -16, 0.0);
    }

    /**
     * Test of move method, of class Player.
     */
    @Test
    public void testmove() {
        System.out.println("move");
        double delta = 1;
        // Test movement along the x-axis and y-axis
        player.setDirection(Direction.RIGHT);
        player.move(delta);
        assertEquals(player.getY(), 250, 0.0001);
        assertEquals(player.getX(), 200+2, 0.0);
        player.setDirection(Direction.LEFT);
        player.move(delta);
        player.move(delta);
        double yVelocityAfterThreemoves = 0.5 + 0.75; 
        assertEquals(player.getX(), 200-2, 0.0);
        assertEquals(player.getY(), 250 + yVelocityAfterThreemoves, 0.0001);
        
        // test x-axis acceleration limits
        player.setAcceleration(40);
        player.move(delta);
        assertEquals(player.getxVelocity(), 20, 0.0);
        player.setAcceleration(-40);
        player.move(delta);
        assertEquals(player.getxVelocity(), -20, 0.0);
        
        // Test reappearing on other side of screen
        player.reset();
        player.setX(385);
        player.move(delta);
        assertEquals(player.getX(), -36/2, 0.0);
        
        player.reset();
        player.setX(-25);
        player.move(delta);
        assertEquals(player.getX(), 400-36/2, 0.0);
        
    }

    /**
     * Test of getyVelocity method, of class Player.
     */
    @Test
    public void testGetyVelocity() {
        System.out.println("getyVelocity");
        
        double expResult = 0.0;
        double result = player.getyVelocity();
        assertEquals(expResult, result, 0.0);
        double delta = 1;
        player.jump(delta);
        expResult = -16;
        assertEquals(player.getyVelocity(), expResult, 0.0);
        
    }

    /**
     * Test of getIfJumping method, of class Player.
     */
    @Test
    public void testGetIfJumping() {
        System.out.println("getIfJumping");
        
        boolean expResult = true;
        boolean result = player.getIfJumping();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of reset method, of class Player.
     */
    @Test
    public void testReset() {
        System.out.println("reset");
        player.reset();
        assertEquals(player.getX(), 200, 0.0);
        assertEquals(player.getY(), 250, 0.0);
        assertEquals(player.getDirection(), Direction.INPLACE);
        assertEquals(player.getScore(), 0, 0.0);
        assertEquals(player.getyVelocity(), 0, 0.0);
        assertEquals(player.getxVelocity(), 0);
    }

    /**
     * Test of collidesWithPlatform method, of class Player.
     */
    @Test
    public void testCollidesWithPlatform() {
        System.out.println("collidesWithPlatform");
        Platform platform = new Platform(400, 100);
        int platformx = platform.getX();
        int platformy = platform.getY();
        int playerMustmoveX = (int) ((platformx - player.getX()));
        int playerMustmoveY = (int) ((platformy - player.getY())) - player.getHeight();
        
        player.moveByXandY(playerMustmoveX, playerMustmoveY);
       
        boolean expResult = true;
        boolean result = player.collidesWithPlatform(platform);
        assertEquals(expResult, result);
        
    }

    /**
     * Test of setAcceleration method, of class Player.
     */
    @Test
    public void testSetAcceleration() {
        System.out.println("setAcceleration");
        int increase = 10;
        player.setAcceleration(increase);
        assertEquals(player.getxVelocity(), 10, 0.0);
    }

    /**
     * Test of zeroAcceleration method, of class Player.
     */
    @Test
    public void testZeroXAcceleration() {
        System.out.println("zeroXAcceleration");
        
        player.zeroXAcceleration();
        assertEquals(player.getyVelocity(), 0, 0.0);
    }

    /**
     * Test of getDirection method, of class Player.
     */
    @Test
    public void testGetDirection() {
        System.out.println("getDirection");
        
        Direction expResult = Direction.INPLACE;
        Direction result = player.getDirection();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDirection method, of class Player.
     */
    @Test
    public void testSetDirection() {
        System.out.println("setDirection");
        Direction direction = Direction.INPLACE;
        player.setDirection(direction);
        assertEquals(player.getDirection(), Direction.INPLACE);
        direction = Direction.DOWN;
        player.setDirection(direction);
        assertEquals(player.getDirection(), Direction.DOWN);
        direction = Direction.LEFT;
        player.setDirection(direction);
        assertEquals(player.getDirection(), Direction.LEFT);
        direction = Direction.RIGHT;
        player.setDirection(direction);
        assertEquals(player.getDirection(), Direction.RIGHT);
    }

    
    /**
     * Test of getWidth method, of class Player.
     */
    @Test
    public void testGetWidth() {
        System.out.println("getWidth");
        ;
        int expResult = 36;
        int result = player.getWidth();
        assertEquals(expResult, result);
    }

    

    /**
     * Test of getScore method, of class Player.
     */
    @Test
    public void testGetScore() {
        System.out.println("getScore");
        int expResult = 0;
        int result = player.getScore();
        assertEquals(expResult, result);
        
    }
}