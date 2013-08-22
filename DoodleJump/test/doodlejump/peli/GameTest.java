/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doodlejump.peli;

import doodlejump.domain.Gamestate;
import doodlejump.gui.Updateable;
import java.util.List;
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
public class GameTest {
    
    public GameTest() {
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
     * Test of getPlayer method, of class Game.
     */
    @Test
    public void testGetPlayer() {
        System.out.println("getPlayer");
        Game instance = null;
        Player expResult = null;
        Player result = instance.getPlayer();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of pauseGame method, of class Game.
     */
    @Test
    public void testPauseGame() {
        System.out.println("pauseGame");
        Game instance = null;
        instance.pauseGame();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setDoodleDead method, of class Game.
     */
    @Test
    public void testSetDoodleDead() {
        System.out.println("setDoodleDead");
        boolean doodleDead = false;
        Game instance = null;
        instance.setDoodleDead(doodleDead);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of restart method, of class Game.
     */
    @Test
    public void testRestart() {
        System.out.println("restart");
        Game instance = null;
        instance.restart();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setUpdateable method, of class Game.
     */
    @Test
    public void testSetUpdateable() {
        System.out.println("setUpdateable");
        Updateable paivitettava = null;
        Game instance = null;
        instance.setUpdateable(paivitettava);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of run method, of class Game.
     */
    @Test
    public void testRun() throws Exception {
        System.out.println("run");
        Game instance = null;
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getGamestate method, of class Game.
     */
    @Test
    public void testGetGamestate() {
        System.out.println("getGamestate");
        Game instance = null;
        Gamestate expResult = null;
        Gamestate result = instance.getGamestate();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of setGamestate method, of class Game.
     */
    @Test
    public void testSetGamestate() {
        System.out.println("setGamestate");
        Gamestate gamestate = null;
        Game instance = null;
        instance.setGamestate(gamestate);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPlatforms method, of class Game.
     */
    @Test
    public void testGetPlatforms() {
        System.out.println("getPlatforms");
        Game instance = null;
        List expResult = null;
        List result = instance.getPlatforms();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}