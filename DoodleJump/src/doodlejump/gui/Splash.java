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
import java.util.*;
import javax.swing.ImageIcon;
/**
 * Class representation for the game splash screen.
 * @author Ivan
 */
public class Splash { 
  
    
    private Image img;
    private String bgImageName;
    /**
     * Sets up a new Splash screen with the given image.
     */
    public Splash() {
    
        bgImageName = "C:\\Users\\Ivan\\Documents\\GitHub\\OhHa\\DoodleJump\\src\\doodlejump\\gui\\images\\splash.png";
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
