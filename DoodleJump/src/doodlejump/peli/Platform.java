package doodlejump.peli;
import java.awt.Graphics;
import java.awt.Image;
import java.util.*;
import javax.swing.ImageIcon;

public class Platform { 
  
    private int x;
    private int y;
    private int platformWidth;
    private Image img;
    private String platName;
    private int type;
    private boolean bouncedOn;

    public Platform(int width, int y) {
        Random random = new Random();
        this.platformWidth = 50;
        this.x = random.nextInt(width - platformWidth - 15);
        this.y = y;
        this.platName = "C:\\Users\\Ivan\\Documents\\GitHub\\OhHa\\DoodleJump\\src\\doodlejump\\peli\\images\\platform1.png";
        this.type = 1;
        this.bouncedOn = false;
        
        ImageIcon ii = new ImageIcon(platName);
        this.img = ii.getImage();    
    }

    public void setPlatName(String platName) {
        this.platName = platName;
    }

    public void setType(int type) {
        this.type = type;
    }

    public void setImg(Image img) {
        this.img = img;
    }

    public int getType() {
        return type;
    }

    public void setY(int y) {
        this.y += y;
    }

    public Image getImg() {
        return img;
    }  
    
    public void piirra(Graphics graphics){
        graphics.drawImage(img, x, y, null);
    }

    public String getPlatName() {
        return platName;
    }

    public int getX() {
        return x;
    }

    public int getY() {
        return y;
    }
    
    public int getWidth(){
        return img.getWidth(null);
    }
    
    public int getHeight(){
        return img.getHeight(null);
    }

    public void addToY(double yVelocity) {
        y += yVelocity;
    }

    public void setX(int nx) {
        this.x = nx;
    }

    public void increaseX(double xVel) {
        x += xVel;
    }
    
    public void addToX(int nx){
        x += nx;
    }

    public void dissapear() {
        
    }
    
    public boolean getBouncedOn() {
        return bouncedOn;
    }

    public void setBouncedOn(boolean bouncedOn) {
        this.bouncedOn = bouncedOn;
    }
    
    
    

}
