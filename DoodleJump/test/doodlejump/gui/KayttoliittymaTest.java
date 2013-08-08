/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package doodlejump.gui;

import javax.swing.JFrame;
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
public class KayttoliittymaTest {
    
    public KayttoliittymaTest() {
    }
    
    /**
     * Test of run method, of class Kayttoliittyma.
     */
    @Test
    public void testRun() {
        System.out.println("run");
        Kayttoliittyma instance = null;
        instance.run();
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getFrame method, of class Kayttoliittyma.
     */
    @Test
    public void testGetFrame() {
        System.out.println("getFrame");
        Kayttoliittyma instance = null;
        JFrame expResult = null;
        JFrame result = instance.getFrame();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }

    /**
     * Test of getPaivitettava method, of class Kayttoliittyma.
     */
    @Test
    public void testGetPaivitettava() {
        System.out.println("getPaivitettava");
        Kayttoliittyma instance = null;
        Paivitettava expResult = null;
        Paivitettava result = instance.getPaivitettava();
        assertEquals(expResult, result);
        // TODO review the generated test code and remove the default call to fail.
        fail("The test case is a prototype.");
    }
}