package doodlejump.peli; 
import doodlejump.peli.Direction;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.*;
import javax.swing.ImageIcon;
/**
 * This class represents a Player in the game.
 * @author Ivan
 */
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
    String playerImageName;
    
    
    /**
     * Sets up a new Player
     * 
     * @param width is the width of the game window used in player tracking
     * @param y is y-axis starting location of the player
     * @param direction is the direction Enum to control the direction of the player
     */
    public Player(int width, double y, Direction direction){
        this.x = width/2;
        this.y = y;
        this.direction = direction;
        this.xVelocity = 0;
        this.yVelocity = 0;
        this.score = 0;
        this.width = width;
        this.playerImageName = "C:\\Users\\Ivan\\Documents\\GitHub\\OhHa\\DoodleJump\\src\\doodlejump\\peli\\images\\frog.png";
        
        
        ImageIcon ii = new ImageIcon(this.playerImageName);
        this.img = ii.getImage();
        
        
    }

    public double getGravity() {
        return gravity;
    }
    
    
    /**
     * When player reaches the center of the screen, he doesn't move any higher,
     * but the platforms move lower the distance that the player should've moved
     * up. This distance is also added to the score and this is how score is 
     * calculated
     * @param yVelocity is the yVelocity added to the score
     */
    public void addToScore(double yVelocity){
        score += yVelocity;
    }

    public double getX() {
        return x;
    }

    public double getY() {
        return y;
    }
    
    /**
     * Make the player jump by setting the yVelocity to -16
     * @param delta is the variable time adjustment parameter
     */
    public void jump(double delta){
        jumping = true;
        yVelocity = -16*delta;
    }
    
    /**
     * 
     * @param delta 
     */
    public void move(double delta) {
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
    
    
    /*
     * returns the boolean that tells whether the player is currently jumping
     * up or falling down.
     */
    public boolean getIfJumping(){
        return jumping;
    }
    
    /**
     * Resets the players position, direction, velocity and also the score
     */
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
    
    
    /**
     * Collision test whether the player collides with a platform
     * @param platform is the platform that collision test is made with
     * @return true if there is a collision or false otherwise
     */
    public boolean collidesWithPlatform(Platform platform){
        if( ((int)this.getY() + this.getHeight()) <= (platform.getY() + 10)
                && ((int)this.getY() + this.getHeight()) >= (platform.getY()-2)
                && (int)this.getX() + this.getWidth() >= platform.getX() 
                && (int)this.getX() <= (platform.getX() + platform.getWidth()) ){
            return true;
        }
        return false;
    }
    
    /**
     * Increases the acceleration along the x-axis by the parameter "increase"
     * @param increase increases the acceleration along the x-axis 
     */
    public void setAcceleration(int increase) {
        xVelocity += increase;
    }
    /**
     * sets the x-axis acceleration to zero
     */
    public void zeroXAcceleration() {
        xVelocity = 0;
    }
    
    public Direction getDirection() {
        return direction;
    }

    public void setDirection(Direction direction) {
        this.direction = direction;
    }
    /**
     * Draws the player-image on the screen
     * @param graphics 
     */
    public void piirra(Graphics graphics){
        graphics.drawImage(img, (int)x, (int)y, null);
        
        graphics.setFont(new Font("Serif", Font.BOLD, 25));
        String ScoreString = "";
        ScoreString += score;
        graphics.drawString(ScoreString , 7, 22);
    }
    
    /**
     * Returns player image width
     * @return 
     */
    public int getWidth(){
        return img.getWidth(null);
    }
    
    /**
     * Returns player image height
     * @return 
     */
    public int getHeight(){
        return img.getHeight(null);
    }

    public int getScore() {
        return score;
    }
    
}
