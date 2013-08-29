/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doodlejump.game;

import doodlejump.game.Game;
import doodlejump.game.Direction;
import doodlejump.domain.Gamestate;
import doodlejump.gui.CanvasDrawer;
import doodlejump.gui.Interface;
import doodlejump.gui.Updateable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import javax.swing.SwingUtilities;
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
    
    private Game peli;
    private Interface kayttoliittyma;
    
    public GameTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Set up class");
    }
    
    @AfterClass
    public static void tearDownClass() {
    }
    
    @Before
    public void setUp() {
        System.out.println("Setup the Game");
        
        this.peli = new Game(400, 600);
        this.kayttoliittyma = new Interface(peli);
        this.kayttoliittyma.run();
        peli.setUpdateable(kayttoliittyma.getUpdateable());
        
    }
    
    @After
    public void tearDown() {
        System.out.println(" = Teardown");
        peli = null;
        kayttoliittyma = null;
    }

    

    /**
     * Test of pauseGame method, of class Game.
     */
    @Test
    public void testPauseGame() {
        System.out.println("pauseGame");
        boolean expResult = false;
        
        if(peli.isGamePaused()){
            expResult = false;
            peli.pauseGame();
            assertEquals(expResult, peli.isGamePaused());
        } else{
            expResult = true;
            peli.pauseGame();
            assertEquals(expResult, peli.isGamePaused());
        }
    }

    

    /**
     * Test of restart method, of class Game.
     */
    @Test
    public void testRestart() {
        System.out.println("restart");
        boolean expResult = false;
        peli.restart();
        
        // test isDoodleDead reset
        assertEquals(expResult, peli.isDoodleDead());
        
        // test score reset
        assertEquals(0, peli.getPlayer().getScore());
        
        // test player positioning
        assertEquals(Direction.INPLACE, peli.getPlayer().getDirection());
        assertEquals(0, peli.getPlayer().getxVelocity());
        assertEquals(0, peli.getPlayer().getyVelocity(), 0.0001);
        assertEquals(250, peli.getPlayer().getY(), 0.0001);
        
        // test platformcontainer reset
        assertEquals(0, peli.getPlatformContainer().getDifficultyLevel());
        
        // test resetting of platforms
        List<Integer> pTypes = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
        assertEquals(pTypes, peli.getPlatformContainer().getPlatformTypes());
        
    }

    

    /**
     * Test of run method, of class Game.
     */
    @Test
    public void testRun() throws Exception {
        System.out.println("run");
        System.out.println("Simple game loop. difficult to come up with any rational tests");
    }

    @Test
    public void testdoGameUpdates() throws Exception {
        System.out.println("doGameUpdates");
        peli.setGamestate(Gamestate.GAME);
        
        // test doodle falling
        
        peli.getPlayer().setY(601);
        peli.setDoodleDead(false);
        peli.doGameUpdates(1);
        
        assertEquals(true, peli.isDoodleDead());
        // test if gamestate moved to gameover
        assertEquals(Gamestate.GAMEOVER, peli.getGamestate());
        
        System.out.println("Everything else was already covered in PlatformContainer tests");
    }

    
}