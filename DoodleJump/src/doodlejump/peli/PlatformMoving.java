package doodlejump.peli; 

/** 
 * 
 * @author Ivan 
 */ 

import doodlejump.peli.Direction;
import java.awt.Graphics;
import java.util.*;
import javax.swing.ImageIcon;
/**
 * Class represents a moving platform.
 * @author Ivan
 */
public class PlatformMoving extends Platform{ 

    private Direction direction;
    private int xVelocity;
    
    /**
     * Creates a new moving platform
     * @param screenWidth
     * @param y 
     */
    public PlatformMoving(int screenWidth, int y) {
        super(screenWidth, y);
        this.direction = Direction.LEFT;
        super.setPlatName(this.getClass().getResource("./images/cloud_moving.png"));
        super.setType(2);
        
        Random random = new Random();
        this.xVelocity = 1 + random.nextInt((4+1)-1);
         
        
        ImageIcon ii = new ImageIcon(super.getPlatName());
        super.setImg(ii.getImage());
    }
  
    /**
     * Increases the x-axis velocity of the platform
     * @param xVel 
     */
    public void addToX(double xVel) {
        super.increaseX(xVel);
    }
    /**
     * Draws the platform on the screen
     * @param graphics 
     */
    public void piirra(Graphics graphics){
        this.move();
        graphics.drawImage(super.getImg(), super.getX(), super.getY(), null);
    }
    
    /**
     * Moves the platform from one edge of the screen to another
     */
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

    
    public Direction getDirection() {
        return direction;
    }

    public int getxVelocity() {
        return xVelocity;
    }
    
    


}
