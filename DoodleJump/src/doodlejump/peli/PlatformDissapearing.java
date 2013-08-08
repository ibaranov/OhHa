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

public class PlatformDissapearing extends Platform{ 

    
    public PlatformDissapearing(int width, int y) {
        super(width, y);
        super.setPlatName("C:\\Users\\Ivan\\Documents\\GitHub\\OhHa\\DoodleJump\\src\\doodlejump\\peli\\images\\platformDissapearing.png");
        super.setType(3);
        
        ImageIcon ii = new ImageIcon(super.getPlatName());
        super.setImg(ii.getImage());
    }
  
    public void dissapear(){
        super.setBouncedOn(true);
    }
    
    public void piirra(Graphics graphics){
        if(!super.getBouncedOn()){
            graphics.drawImage(super.getImg(), super.getX(), super.getY(), null);
        }
        
    }

   
    
    
    
    
  


}
