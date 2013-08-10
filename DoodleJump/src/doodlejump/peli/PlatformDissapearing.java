/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package doodlejump.peli; 

/** 
 * 
 * @author Ivan 
 */ 

import java.awt.Graphics;
import javax.swing.ImageIcon;
/**
 * Class represents a Disappearing platform.
 * @author Ivan
 */
public class PlatformDissapearing extends Platform{ 

    /**
     * 
     * @param screenWidth of the screen
     * @param y 
     */
    public PlatformDissapearing(int screenWidth, int y) {
        super(screenWidth, y);
        super.setPlatName("C:\\Users\\Ivan\\Documents\\GitHub\\OhHa\\DoodleJump\\src\\doodlejump\\peli\\images\\platformDissapearing.png");
        super.setType(3);
        
        ImageIcon ii = new ImageIcon(super.getPlatName());
        super.setImg(ii.getImage());
    }
  
    /**
     * sets the bouncedOn boolean true, which in turn causes the platform to
     * disappear in the piirra-method
     */
    public void dissapear(){
        super.setBouncedOn(true);
    }
    /**
     * Draws the platform on the screen unless it has disappeared
     * @param graphics 
     */
    public void piirra(Graphics graphics){
        if(!super.getBouncedOn()){
            graphics.drawImage(super.getImg(), super.getX(), super.getY(), null);
        }
        
    }

   
    
    
    
    
  


}
