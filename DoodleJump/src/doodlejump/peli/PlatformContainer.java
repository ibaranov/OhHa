/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */

package doodlejump.peli; 

/** 
 * 
 * @author Ivan 
 */ 

import doodlejump.peli.Direction;
import java.util.*;
/**
 * A container and creator for the platforms
 * @author Ivan
 */
public class PlatformContainer { 
  
        
  private List<Platform> platforms;
  private List<Integer> platformTypes;
  private int difficultyLevel;
  private int windowHeight;
  private int windowWidth;
  private boolean gameStart;
  private Player player;

  /**
   * Creates a new container to create and hold the platforms that are then drawn
   * on the screen
   * @param windowWidth
   * @param windowHeight 
   * @param player
   */
    public PlatformContainer(int windowWidth, int windowHeight, Player player) {
        this.platforms = new ArrayList<Platform>();
        this.difficultyLevel = 0;
        this.platformTypes = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1)); 
        this.windowHeight = windowHeight;
        this.windowWidth = windowWidth;
        this.gameStart = true;
        this.player = player;
        this.generatePlatforms();
    }
    
    /**
     * Generate new platforms from the initial array of platform types
     */
    public void reset(){
        this.generatePlatforms();
        this.gameStart = true;
        this.difficultyLevel = 0;
        this.platformTypes = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
    }
    
    public List<Platform> getPlatforms() {
        return platforms;
    }

    public List<Integer> getPlatformTypes() {
        return platformTypes;
    }

    public int getDifficultyLevel() {
        return difficultyLevel;
    }
    
    public void increaseDifficultylevel(){
        this.difficultyLevel = player.getScore()/2000;
        
        if(this.difficultyLevel == 0){
            this.platformTypes = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1, 1, 1));
        } else if(this.difficultyLevel == 1){
            this.platformTypes = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 2, 2, 3)); 
        } else if (this.difficultyLevel == 2){
            this.platformTypes = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 2, 2, 2, 2, 3, 3)); 
        } else if (this.difficultyLevel == 3){
            this.platformTypes = new ArrayList<>(Arrays.asList(1, 1, 2, 2, 2, 2, 3, 3, 3, 3)); 
        } else {
            this.platformTypes = new ArrayList<>(Arrays.asList(2, 2, 2, 2, 2, 2, 2, 2, 2, 2)); 
        }
        
    }

    public void setDifficultyLevel(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
    }
    
    /**
     * Check whether the player collides with any of the platforms.
     * @param player
     * @param delta 
     */
    public void checkCollisionWithPlatforms(Player player, double delta){
        
        for(Platform p : this.getPlatforms()){
            if(player.collidesWithPlatform(p)==true && !player.getIfJumping()){
                if(p.getType() != 3 || !p.getBouncedOn()){
                    player.jump(delta);
                }
                // Collision with dissapearing platforms
                if(p.getType() == 3){
                    p.dissapear();
                }
                break;
            }
        }
        
    }
    
    /**
     * Generates a new set of platforms on the screen according to the initial
     * array of platform types given.
     * Also puts the lowest platform under the Player when the game starts
     */
    public void generatePlatforms(){
        if(platforms != null){
            platforms.clear();
        }
        
        
        int numberOfPlatforms = 8;
        int platformHeight = (windowHeight-60) / numberOfPlatforms;
        
        Random random = new Random();
        int platformType = platformTypes.get(random.nextInt(platformTypes.size()-1));
        
        for(int i = 0; i < numberOfPlatforms; i++){
            if(platformType == 1){
                platforms.add(new Platform(windowWidth, (i)*platformHeight));
            } else if(platformType == 2) {
                platforms.add(new PlatformMoving(windowWidth, (i)*platformHeight));
            } else if(platformType == 3) {
                platforms.add(new PlatformDissapearing(windowWidth, (i)*platformHeight));
            }
        }
        
        // Put the lowest platform under Doodle at reset so that it won't fall immediately at start
        if(gameStart){
            platforms.get(platforms.size()-1).setX(187);
            gameStart = false;
        }
        
    }
    
    /**
     * Move platforms down when player character reaches the half of the screen.
     * Platform are moved downwards a distance that reflects the remaining
     * velocity of the player after he reaches the half of the screen.
     * @param addToScore boolean that tells the program to either increase or not increase the score.
     * @param player
     * @param width is the width of the screen
     * @param height is the height of the screen
     * @return true if platforms are moved downwards and score increases, or
     * false if this does not happen.
     */
    public boolean moveAndCreatePlatforms(boolean addToScore, Player player, int width, int height){
        this.increaseDifficultylevel();
        
        for(int i = 0; i < this.getPlatforms().size(); i++){
            // Increase score
            if(player.getyVelocity() < 0 && player.getY() <= 251){
                this.getPlatforms().get(i).addToY(-player.getyVelocity());
                addToScore = true;
            }
            // generate new platforms
            if(this.getPlatforms().get(i).getY() > height - 50){
                Random random = new Random();
                int platformType = platformTypes.get(random.nextInt(platformTypes.size()-1));
                System.out.println("RAND> " + platformType);
                if(platformType == 1){
                    this.getPlatforms().set(i, new Platform(width , 0));
                } else if (platformType == 2){
                    this.getPlatforms().set(i, new PlatformMoving(width , 0));
                } else if(platformType == 3){
                    this.getPlatforms().set(i, new PlatformDissapearing(width , 0));
                }
            }
        }
        
        return addToScore;
    }
    
    
}
