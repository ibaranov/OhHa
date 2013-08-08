/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doodlejump.peli;

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
        platformcontainer = new PlatformContainer(400, 600);
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
        
        
    }

    /**
     * Test of getPlatforms method, of class PlatformContainer.
     */
    @Test
    public void testGetPlatforms() {
        System.out.println("getPlatforms");
        
        List expResult = null;
        List result = platformcontainer.getPlatforms();
        assertEquals(expResult, result);
        
    }

    /**
     * Test of getPlatformTypes method, of class PlatformContainer.
     */
    @Test
    public void testGetPlatformTypes() {
        System.out.println("getPlatformTypes");
        
        List expResult = null;
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
        int difficultyLevel = 0;
        
        platformcontainer.setDifficultyLevel(difficultyLevel);
        
    }

    /**
     * Test of generatePlatforms method, of class PlatformContainer.
     */
    @Test
    public void testGeneratePlatforms() {
        System.out.println("generatePlatforms");
        
        platformcontainer.generatePlatforms();
        
    }
}