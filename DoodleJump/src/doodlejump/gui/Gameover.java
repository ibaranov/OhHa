/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package doodlejump.gui; 

/** 
 * 
 * @author Ivan 
 */ 

import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.util.*;
import javax.swing.ImageIcon;
import javax.swing.JTextArea;

public class Gameover { 
  
    private Image img;
    private String gameoverImageName;
    private int score;
    private String playerName;
    private Highscore highscore;
    private Graphics graphics;
    
    public Gameover(Highscore highscore) {
        
        this.playerName = "";
        gameoverImageName = "C:\\Users\\Ivan\\Documents\\GitHub\\OhHa\\DoodleJump\\src\\doodlejump\\gui\\images\\gameover.png";
        ImageIcon ii = new ImageIcon(gameoverImageName);
        this.img = ii.getImage();
        this.highscore = highscore;
    }
    
    public void reset(){
        this.playerName = "";
        
    }

    public void setScore(int score) {
        this.score = score;
    }
    
    public void writeCharToName(String letter){
        if(playerName.length() < 10){
            playerName += letter;
        }    
        this.piirra(graphics);
    }
    
    public void sendScoreToHighscore(){
        highscore.addScoreToTopTen(score, playerName);
    }
    
    public boolean setNewHighscore(){
        return highscore.isScoreInTopTen(score);
    }
    
    public void setGraphics(Graphics g){
        this.graphics = g;
    }
    
    public void piirra(Graphics graphics){
        graphics.drawImage(img, 0, 0, null);
        
        graphics.setFont(new Font("Serif", Font.BOLD, 25));
        String scoreString = "Your Score: ";
        scoreString += score;
        graphics.drawString(scoreString , 100, 300);
        graphics.drawString(this.playerName , 20, 450);
        if(highscore.isScoreInTopTen(score)){
            this.piirraIfHighscore(graphics);
        } else {
            this.piirraIfNotHighscore(graphics);
        }
        
    }
    
    
    public void piirraIfHighscore(Graphics graphics){
        String str = "You Made A New Highscore!";
        graphics.drawString(str , 10, 350);
        String str2 = "Please write your name below:";
        graphics.drawString(str2 , 10, 400);
    }
    
    public void piirraIfNotHighscore(Graphics graphics){
        String restart = "Press 'R' to restart the game";
        graphics.drawString(restart , 40, 400);
        String str = "You did not make a new highscore";
        graphics.drawString(str , 20, 350);
        graphics.drawString(this.playerName , 20, 420);
    }

    public void removeCharFromName() {
        if (playerName.length() > 0) {
            playerName = playerName.substring(0, playerName.length()-1);		
	}
        this.piirra(graphics);
    }

    


}
