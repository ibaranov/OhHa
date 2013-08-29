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
import java.awt.Image;
import java.util.*;
import javax.swing.ImageIcon;

    


public class Enemy { 
  
    
    private int x;
    private int y;
    private Image img;
    private String enemyName;
    private int type;
    private int enemyWidth, enemyHeight;
    private int windowWidth;
    

    public Enemy(int windowWidth, int y) {
        this.enemyName = "C:\\Users\\Ivan\\Documents\\GitHub\\OhHa\\DoodleJump\\src\\doodlejump\\peli\\images\\Smosquito.png";
        
        ImageIcon ii = new ImageIcon(this.getClass().getResource(enemyName));
        this.img = ii.getImage();
        
        this.enemyWidth = img.getWidth(null);
        this.enemyHeight = img.getHeight(null);
        Random random = new Random();
        this.x = random.nextInt(windowWidth - enemyWidth - 15);
        this.y = y;
        this.enemyWidth = 50;
    }
    
    
    
    
    
     public void piirra(Graphics graphics){
        graphics.drawImage(this.img, x, y, null);
    }
     
     

    


}
