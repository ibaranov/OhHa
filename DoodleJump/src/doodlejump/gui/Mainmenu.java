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
import java.util.*;
import javax.swing.ImageIcon;

public class Mainmenu {
    
    
    private Image img;
    private String bgImageName;

    public Mainmenu() {
    
        bgImageName = "C:\\Users\\Ivan\\Documents\\GitHub\\OhHa\\DoodleJump\\src\\doodlejump\\gui\\images\\bgimage.png";
        ImageIcon ii = new ImageIcon(bgImageName);
        this.img = ii.getImage();
        
    }
    
    

    public void piirra(Graphics graphics){
        graphics.drawImage(img, 0, 0, null);
    }
}
