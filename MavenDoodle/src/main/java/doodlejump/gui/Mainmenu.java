/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package doodlejump.gui; 
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.*;
import javax.swing.ImageIcon;
/**
 * This class represents the Main menu of the game. 
 * Includes buttons PLAY, HIGHSCORE and EXIT.
 * @author Ivan
 */
public class Mainmenu {
    
    
    private Image img;
    private URL bgImageName;
    /**
     * Sets up a new main menu with the given image
     */
    public Mainmenu() {
    
        bgImageName = this.getClass().getResource("./images/bgimage.png");
        ImageIcon ii = new ImageIcon(bgImageName);
        this.img = ii.getImage();
        
    }
    
    
    /**
     * Draws the main menu
     * @param graphics 
     */
    public void piirra(Graphics graphics){
        graphics.drawImage(img, 0, 0, null);
    }
}
