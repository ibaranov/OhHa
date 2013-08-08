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
import java.io.File;
import java.net.URL;
import java.util.*;
import javax.swing.ImageIcon;

public class Highscore { 
  
    final String FILE_NAME = "highscores.txt";
    private List<String> names;
    private List<Integer> scores;
    private Image img;
    private String bgImageName;
    

    public Highscore() {
        this.names = new ArrayList<String>();
        this.scores = new ArrayList<Integer>();
        bgImageName = "highscore.png";
        
        ImageIcon ii = new ImageIcon(this.getClass().getResource(bgImageName));
        this.img = ii.getImage();
        
        this.readFile();
        this.printOutHighscores();
    }
    
    
    
    
    public void readFile() {
        URL url = getClass().getResource(FILE_NAME);
        File file = new File(url.getPath());
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
    
    public void writeFile(){
        // TODO
    }
    
    public boolean isScoreInTopTen(int playerscore){
        if(playerscore > scores.get(9)){
            return true;
        }
        return false;
    }
    
    public void addScoreToTopTen(int playerscore, String playername){
        for(int i = 0; i < scores.size(); i++){
            if(playerscore > scores.get(i)){
                scores.add(i, playerscore);
                names.add(i, playername);
                scores.remove(10);
                names.remove(10);
                break;
            }
        }
    }
    
    public void printOutHighscores(){
        for(int i = 0; i < 10; i++){
            String str = names.get(i) + " " + scores.get(i);
            System.out.println(str);
        }
    }
    
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
