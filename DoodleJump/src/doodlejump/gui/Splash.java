/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package doodlejump.gui; 

/** 
 * 
 * @author Ivan 
 */ 

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.*;
import javax.swing.ImageIcon;
/**
 * Class representation for the game splash screen. SHows the splash screen.
 * @author Ivan
 */
public class Splash { 
  
    
    private Image img;
    private URL bgImageName;
    /**
     * Sets up a new Splash screen with the given image.
     */
    public Splash() {
    
<<<<<<< HEAD
        bgImageName = this.getClass().getResource("./images/splash.png");
        
        ImageIcon ii = new ImageIcon(bgImageName);
=======
        bgImageName = "C:\\Users\\Ivan\\Documents\\GitHub\\OhHa\\DoodleJump\\src\\doodlejump\\gui\\images\\splash.png";
        URL url = this.getClass().getResource("./images/splash.png");
        //System.out.println("url  " + url);
        
        ImageIcon ii = new ImageIcon(url);
>>>>>>> b4b0c93f03bde6393d2ce591f3dfa958156758ef
        this.img = ii.getImage();
        
    }
    
    /**
     * Draws the Splash screen image to the given position.
     * @param graphics 
     */
    public void piirra(Graphics graphics){
        graphics.drawImage(img, 0, 0, null);
    }


}
