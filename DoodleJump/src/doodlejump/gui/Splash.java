/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package doodlejump.gui; 

/** 
 * 
 * @author Ivan 
 */ 

import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
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
    
        bgImageName = this.getClass().getResource("./images/splash.png");
        
        ImageIcon ii = new ImageIcon(bgImageName);
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
