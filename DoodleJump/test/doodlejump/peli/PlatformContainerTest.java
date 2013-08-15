/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doodlejump.peli;

import java.util.ArrayList;
import java.util.Arrays;
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
public class PlatformContainerTest {
    
    private PlatformContainer platformcontainer;
    
    public PlatformContainerTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Set up class");
    }
    
    
    @Before
    public void setUp() {
        System.out.println("Setup a Platformcontainer");
        Player player = new Player(400, 200, Direction.INPLACE);
        platformcontainer = new PlatformContainer(400, 600, player);
    }
    
    @After
    public void tearDown() {
        System.out.println(" = Teardown");
        platformcontainer = null;
    }

    @AfterClass
    public static void tearDownClass() {
        System.out.println("Tear down class");
    }

    /**
     * Test of reset method, of class PlatformContainer.
     */
    @Test
    public void testReset() {
        System.out.println("reset");       
        platformcontainer.reset();
        System.out.println("same as generateplatforms()");
    }

    /**
     * Test of getPlatforms method, of class PlatformContainer.
     */
    @Test
    public void testGetPlatforms() {
        System.out.println("getPlatforms");
        System.out.println("simple getter");
    }

    /**
     * Test of getPlatformTypes method, of class PliatformContainer.
     */
    @Test
    public void testGetPlatformTypes() {
        System.out.println("getPlatformTypes");
        List expResult = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1)); 
        List result = platformcontainer.getPlatformTypes();
        assertEquals(expResult, result);
    }

    /**
     * Test of getDifficultyLevel method, of class PlatformContainer.
     */
    @Test
    public void testGetDifficultyLevel() {
        System.out.println("getDifficultyLevel");
        int expResult = 0;
        int result = platformcontainer.getDifficultyLevel();
        assertEquals(expResult, result);
    }

    /**
     * Test of setDifficultyLevel method, of class PlatformContainer.
     */
    @Test
    public void testSetDifficultyLevel() {
        System.out.println("setDifficultyLevel");
        int difficultyLevel = 5;
        
        platformcontainer.setDifficultyLevel(difficultyLevel);
        assertEquals(difficultyLevel, platformcontainer.getDifficultyLevel());
    }

    /**
     * Test of generatePlatforms method, of class PlatformContainer.
     */
    @Test
    public void testGeneratePlatforms() {
        System.out.println("generatePlatforms");
        List result = platformcontainer.getPlatforms();
        List types = platformcontainer.getPlatformTypes();
        Platform testplat = new Platform(400, 100);
        
        int numberOfPlatforms = 8;
        for(int i = 0; i < numberOfPlatforms; i++){
            assertEquals(result.get(i).getClass(), testplat.getClass());
        }
    }
    
    @Test
    public void checkCollisionWithPlatforms() {
        System.out.println("checkCollisionWithPlatforms");
        List result = platformcontainer.getPlatforms();
        
        
    }
    
    
    @Test
    public void moveAndCreatePlatforms(){
        
    }
}