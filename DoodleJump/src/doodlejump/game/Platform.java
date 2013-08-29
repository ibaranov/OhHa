package doodlejump.game;
import java.awt.Graphics;
import java.awt.Image;
import java.net.URL;
import java.util.*;
import javax.swing.ImageIcon;
/**
 * Represents a platform in the game.
 * @author Ivan
 */
public class Platform { 
  
    private int x;
    private int y;
    private int platformWidth;
    private Image img;
    private URL platName;
    private int type;
    private boolean bouncedOn;

    /**
     * 
     * @param width is the width of the Screen
     * @param y is the y-axis position of the platform
     */
    public Platform(int screenWidth, int y) {
        Random random = new Random();
        this.platformWidth = 50;
        this.x = random.nextInt(screenWidth - platformWidth - 15);
        this.y = y;
        this.platName = this.getClass().getResource("./images/cloud_basic.png");
        this.type = 1;
        this.bouncedOn = false;
        
        ImageIcon ii = new ImageIcon(platName);
        this.img = ii.getImage();    
    }
    /**
     * Sets the platform name
     * @param platName 
     */
    public void setPlatName(URL platName) {
        this.platName = platName;
    }

    /**
     * set Y
     * @param y 
     */
    public void setY(int y) {
        this.y = y;
    }
    
    
    /**
     * Sets the platform type
     * @param type 
     */
    public void setType(int type) {
        this.type = type;
    }
    /**
     * Sets the platform image
     * @param img 
     */
    public void setImg(Image img) {
        this.img = img;
    }
    
    public int getType() {
        return type;
    }
    
    /**
     * Increase y-parameter of the platform
     * @param y 
     */
    public void increaseY(int y) {
        this.y += y;
    }
    
    public Image getImg() {
        return img;
    }  
    /**
     * Draws the platform on screen
     * @param graphics 
     */
    public void piirra(Graphics graphics){
        graphics.drawImage(img, x, y, null);
    }
    /**
     * 
     * @return platform name
     */
    public URL getPlatName() {
        return platName;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    /**
     * 
     * @return image width 
     */
    public int getWidth(){
        return img.getWidth(null);
    }
    /**
     * 
     * @return image height
     */
    public int getHeight(){
        return img.getHeight(null);
    }
    /**
     * Increases y Velocity of the platform
     * @param yVelocity 
     */
    public void addToY(double yVelocity) {
        y += yVelocity;
    }
    
    public void setX(int nx) {
        this.x = nx;
    }
    /**
     * Increases x by the Velocity of the platform
     * @param xVel 
     */
    public void increaseX(double xVel) {
        x += xVel;
    }
    /**
     * Increases the x-position of the platform
     * @param nx addition to x-coordinate
     */
    public void addToX(int nx){
        x += nx;
    }
    
    /**
     * Disappear method for the dissapearingPlatform class so that later
     * I can just use the Platform instead of calling each one separately
     */
    public void dissapear() {    
    }
    /**
     * This method is made for the disappearing platform so it disappears
     * when it gets bounced on/
     * @return true if the platform is bounced on
     */
    public boolean getBouncedOn() {
        return bouncedOn;
    }

    /**
     * Setter for bouncedOn boolean
     * @param bouncedOn 
     */
    public void setBouncedOn(boolean bouncedOn) {
        this.bouncedOn = bouncedOn;
    }
}
