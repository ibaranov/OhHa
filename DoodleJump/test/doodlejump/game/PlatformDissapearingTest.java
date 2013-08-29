/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doodlejump.game;

import doodlejump.game.PlatformDissapearing;
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
    private PlatformDissapearing platform;
    
    public PlatformDissapearingTest() {
    }
    
    @BeforeClass
    public static void setUpClass() {
        System.out.println("Set up class");
    }
    
   
    
    @Before
    public void setUp() {
        System.out.println("Setup a Platform");
        platform = new PlatformDissapearing(400, 100);
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
     * Test of dissapear method, of class PlatformDissapearing.
     */
    @Test
    public void testDissapear() {
        System.out.println("dissapear");
        platform.dissapear();
        // nothing really to test
        
    }

    
}