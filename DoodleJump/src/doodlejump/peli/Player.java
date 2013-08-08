package doodlejump.peli; 
import doodlejump.peli.Direction;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.*;
import javax.swing.ImageIcon;

public class Player { 
  
    private double x;
    private double y;
    private double yVelocity;
    public final double gravity = 0.25; 
    private Direction direction;
    private Image img;
    private int xVelocity;
    private boolean jumping = true;
    private int score;
    private int width;
    
    
    public Player(int width, double y, Direction direction){
        this.x = width/2;
        this.y = y;
        this.direction = direction;
        this.xVelocity = 0;
        this.yVelocity = 0;
        this.score = 0;
        this.width = width;
        
        ImageIcon ii = new ImageIcon(this.getClass().getResource("doodle40.png"));
        this.img = ii.getImage();
        
        
    }

    public double getGravity() {
        return gravity;
    }
    
    
    
    public void siirra(double dx, double dy){
        x += dx;
        y += dy;
    }
    
    public void addToScore(double yVel){
        score += yVel;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    
    public void jump(double delta){
        jumping = true;
        yVelocity = -16*delta;
    }
    
    public void Move(double delta) {
        if (direction == Direction.RIGHT) {
            x += 2;
        } else if (direction == Direction.LEFT) {
            x -= 2;
        }
        
        x += xVelocity * delta;
        
        // Jumping ************************
        
        yVelocity += gravity * delta;
        y += yVelocity * delta;
        
        if(yVelocity >= 0){
            jumping = false;
        }  
        // stop moving up if at half screen
        if(y < 250){
            y = 250;
        }
        //****************************
        
        //Appear at left side of the screen if exiting from right side
        // and vice versa
        if(x > 380){
            x = -img.getWidth(null)/2;
        } else if (x < -20){
            x = 400-img.getWidth(null)/2;
        }
        // ***********************************************************
        
        //Sideways Acceleration Speed Limit!
        if(xVelocity > 20){
            xVelocity = 20;
        } else if(xVelocity < -20){
            xVelocity = -20;
        }
        //************************
    }

    public void setX(double x) {
        this.x = x;
    }

    
    
    public double getyVelocity() {
        return yVelocity;
    }
    
    
    
    public boolean getIfJumping(){
        return jumping;
    }
    
    public void reset(){
        this.x = width/2;
        this.y = 250;
        this.direction = Direction.INPLACE;
        this.xVelocity = 0;
        this.yVelocity = 0;
        this.score = 0;
    }

    public int getxVelocity() {
        return xVelocity;
    }
    
    
    
    public boolean collidesWithPlatform(Platform platform){
        
        if( ((int)this.getY() + this.getHeight()) <= (platform.getY() + 10)
                && ((int)this.getY() + this.getHeight()) >= (platform.getY()-2)
                && (int)this.getX() + this.getWidth() >= platform.getX() 
                && (int)this.getX() <= (platform.getX() + platform.getWidth()) ){
            return true;
        }
        return false;
    }
    
    public void setAcceleration(int increase) {
        xVelocity += increase;
    }
    
    public void zeroAcceleration() {
        xVelocity = 0;
    }
    
    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    
    public void piirra(Graphics graphics){
        graphics.drawImage(img, (int)x, (int)y, null);
        
        graphics.setFont(new Font("Serif", Font.BOLD, 25));
        String ScoreString = "";
        ScoreString += score;
        graphics.drawString(ScoreString , 7, 22);
    }
    
    public int getWidth(){
        return img.getWidth(null);
    }
    
    public int getHeight(){
        return img.getHeight(null);
    }

    public int getScore() {
        return score;
    }
    
    
    
    
}
