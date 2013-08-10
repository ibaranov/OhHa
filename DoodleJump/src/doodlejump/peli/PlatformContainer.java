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

  /**
   * Creates a new container to create and hold the platforms that are then drawn
   * on the screen
   * @param windowWidth
   * @param windowHeight 
   */
    public PlatformContainer(int windowWidth, int windowHeight) {
        this.platforms = new ArrayList<Platform>();
        this.difficultyLevel = 0;
        this.platformTypes = new ArrayList<>(Arrays.asList(1, 1, 1, 1, 1, 1, 1, 1)); 
        this.windowHeight = windowHeight;
        this.windowWidth = windowWidth;
        
        this.generatePlatforms();
    }
    
    /**
     * Generate new platforms from the initial array of platform types
     */
    public void reset(){
        generatePlatforms();
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

    public void setDifficultyLevel(int difficultyLevel) {
        this.difficultyLevel = difficultyLevel;
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
        
        int numberOfPlatforms = platformTypes.size();
        int platformHeight = windowHeight / numberOfPlatforms;
        
        for(int i = 0; i < numberOfPlatforms; i++){
            if(platformTypes.get(i) == 1){
                platforms.add(new Platform(windowWidth, (i)*platformHeight));
            } else if(platformTypes.get(i) == 2) {
                platforms.add(new PlatformMoving(windowWidth, (i)*platformHeight));
            } else if(platformTypes.get(i) == 3) {
                platforms.add(new PlatformDissapearing(windowWidth, (i)*platformHeight));
            }
        }
        
        // Put the lowest platform under Doodle so that it won't fall immediately at start
        platforms.get(7).setX(187);
    }
}
