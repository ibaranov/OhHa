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
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;
import java.util.*;
import javax.swing.ImageIcon;
    
/**
 * Instance of the Highscore game state.
 * @author Ivan
 */
public class Highscore { 
  
    final String FILE_NAME = "C:\\Users\\Ivan\\Documents\\GitHub\\OhHa\\DoodleJump\\src\\txtresources\\highscores.txt";
    private List<String> names;
    private List<Integer> scores;
    private Image img;
    private String bgImageName;
    
    /**
     * Constructor sets up a new Highscore screen with the given image.
     * Names-variable contain the high scorers names in a List
     * Scores-variable contains the high scores in a list
     */
    public Highscore() {
        this.names = new ArrayList<String>();
        this.scores = new ArrayList<Integer>();
        bgImageName = "C:\\Users\\Ivan\\Documents\\GitHub\\OhHa\\DoodleJump\\src\\doodlejump\\gui\\images\\highscore.png";
        
        ImageIcon ii = new ImageIcon(bgImageName);
        this.img = ii.getImage();
        
        this.readFile();
    }
    
    /**
     * Reads the text file that contains the save high scores.
     */
    public void readFile() {
        File file = new File(FILE_NAME);
        Scanner reader = null;

        try {
            reader = new Scanner(file);
        } catch (Exception e) {
            System.out.println("Reading the file failed: " + e.getMessage());
            return;
        }

        while (reader.hasNextLine()) {
            String line = reader.nextLine();
            String[] split = line.split(" ");
            names.add(split[0]);
            scores.add(Integer.parseInt(split[1]));
        }

        reader.close();
    }
    
    /**
     * Writes to the text file that contains the high scores.
     */
    public void writeToFile(){
        File file = new File(FILE_NAME);
        String highscores = "";
        
        // put name + highscore to string
        for(int i = 0; i < 10; i++){
            highscores += names.get(i) + " " + scores.get(i) + "\n";
        }
        
        //remove last linebreak
        highscores = highscores.substring(0, highscores.length()-1);
        
        // try writing to file
        try {			
            FileWriter fw = new FileWriter(file.getAbsoluteFile());
	    BufferedWriter bw = new BufferedWriter(fw);
            
            bw.write(highscores);
            bw.close();
 
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
    
    /**
     * Method that tells whether the player made it to the high score list
     * 
     * @param playerscore is the score of the player in the latest game.
     * @return a boolean that shows whether the player made it to the 
     * high score list
     */
    public boolean isScoreInTopTen(int playerscore){
        if(playerscore > scores.get(9)){
            return true;
        }
        return false;
    }
    
    /**
     * Method adds the player and his score to the list and writes it to the
     * high scores file.
     * 
     * @param playerscore score of the player to add to the list
     * @param playername name of the player to add to the list
     */
    public void addScoreToTopTen(int playerscore, String playername){
        for(int i = 0; i < 10; i++){
            if(playerscore > scores.get(i)){
                scores.add(i, playerscore);
                names.add(i, playername);
                scores.remove(10);
                names.remove(10);
                break;
            }
        }
        this.writeToFile();
        this.readFile();
    }
    
    
    /**
     * Draws the High score image and all the names and high scores 
     * on the screen.
     * 
     * @param graphics 
     */
    public void piirra(Graphics graphics){
        graphics.drawImage(img, 0, 0, null);
        int ypos = 150;
        
        graphics.setFont(new Font("Serif", Font.BOLD, 25));
        graphics.drawString("HIGHSCORES" , 120, 50);
        for(int i = 0; i < 10; i++){
            String name = names.get(i);
            String score = "";
            score += scores.get(i);
            graphics.drawString(name , 100, ypos+(i*30));
            graphics.drawString(score , 250, ypos+(i*30));
        }
    }


}
