package doodlejump.peli; 

/** 
 * 
 * @author Ivan 
 */ 

import doodlejump.peli.Direction;
import java.awt.Graphics;
import java.util.*;
import javax.swing.ImageIcon;

public class PlatformMoving extends Platform{ 

    private Direction direction;
    private int xVelocity;
    
    public PlatformMoving(int width, int y) {
        super(width, y);
        this.direction = Direction.LEFT;
        super.setPlatName("platformMoving.png");
        super.setType(2);
        
        Random random = new Random();
        this.xVelocity = 1 + random.nextInt((4+1)-1);
         
        
        ImageIcon ii = new ImageIcon(this.getClass().getResource(super.getPlatName()));
        super.setImg(ii.getImage());
    }
  
    public void addToX(double xVel) {
        super.increaseX(xVel);
    }
    
    public void piirra(Graphics graphics){
        this.move();
        graphics.drawImage(super.getImg(), super.getX(), super.getY(), null);
    }
    
    public void move(){
     
        if(direction == Direction.LEFT){
            super.addToX(-xVelocity);
            if(super.getX() <= 0 ){
                direction = Direction.RIGHT;
            }
        } else if(direction == Direction.RIGHT){
            super.addToX(xVelocity);
            if(super.getX() + super.getWidth() + 15 >= 400 ){
                direction = Direction.LEFT;
            }
        }
    }


}
