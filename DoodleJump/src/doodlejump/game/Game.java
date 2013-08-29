package doodlejump.game; 
import doodlejump.domain.Gamestate;
import doodlejump.gui.Updateable;
import doodlejump.game.Player;
import java.util.*;
/**
 * This class runs the game logic of the program.
 * @author Ivan
 */
public class Game {  
    
    private int width;
    private int height;
    private Player player;
    private boolean gameRunning;
    private boolean gamePaused;
    private Updateable updateable;
    private PlatformContainer platformContainer;
    private Gamestate gamestate;
    private boolean doodleDead;
    
    /**
     * Sets up a new game
     * @param width is the width of the game window
     * @param height is the height of the game window
     * 
     */
    public Game(int width, int height) {
        this.width = width;
        this.height = height;
        this.player = new Player(width, 250, Direction.INPLACE);
        this.gameRunning = true;
        this.platformContainer = new PlatformContainer(width, height, player);
        this.gamestate = Gamestate.SPLASH;
        this.doodleDead = false;
    }

    public Player getPlayer() {
        return player;
    }
    
    /**
     * Sets gamePaused to true/false
     */
    public void pauseGame(){
        if(gamePaused){
            gamePaused = false;
        } else {
            gamePaused = true;
        }
    }

    
    /**
     * Sets the boolean doodleDead so that program knows when player is dead
     * and acts accordingly
     * @param doodleDead 
     */
    public void setDoodleDead(boolean doodleDead) {
        this.doodleDead = doodleDead;
    }
    
    /**
     * Restarts the game. Player is set to original position, score is reset
     * and new platforms are generated.
     * 
     */
    public void restart(){
        
        this.setDoodleDead(false);
        this.player.reset();
        this.platformContainer.reset();
        
    }
    
    
    public void setUpdateable(Updateable updateable) {
        this.updateable = updateable;
    }
    
    
    /**
     * Main game run method with a variable time loop.
     * This is used so that game speed tries to stick to the 60 FPS
     * on fast and slow machines.
     * 
     * @throws InterruptedException 
     */
    public void run() throws InterruptedException{
        
        long lastLoopTime = System.nanoTime();
        final int TARGET_FPS = 60;
        final long OPTIMAL_TIME = 1000000000 / TARGET_FPS;      
        
        while (gameRunning)
        {
            long now = System.nanoTime();
            long updateLength = now - lastLoopTime;
            lastLoopTime = now;
            double delta = updateLength / ((double)OPTIMAL_TIME);
            
            if(gamestate == Gamestate.GAME){
                doGameUpdates(delta);
            }
            
            if(gamestate != Gamestate.PAUSE){
                updateable.paivita();
            } 
            
            try{
                Thread.sleep( 10 );
              } catch (InterruptedException e) {
                      e.printStackTrace();
              }
        }
    }

    
    public Gamestate getGamestate() {
        return gamestate;
    }
    
    
    public void setGamestate(Gamestate gamestate) {
        this.gamestate = gamestate;
    }
    
    
    /**
     * Does the following game updates:
     *  Collision checking
     *  Moving platforms
     *  Creating new platforms
     *  Checks if player dies and changes game-states
     *  Makes addition to the score when platforms move down
     *  Calls the Player move method
     *  
     * @param delta to adjust updates for variable time
     */
    public void doGameUpdates(double delta){
        boolean addToScore = false;
        
        // Check collision with platforms
        platformContainer.checkCollisionWithPlatforms(player, delta);
        
        // Move platforms down and Create new platforms to replace the old ones. 
        //If platforms are moved down, addToScore = true;
        addToScore = platformContainer.moveAndCreatePlatforms(addToScore, player, width, height);
        
        // If doodle falls, then show ending
        if( ( player.getY() + player.getHeight() ) > (height - 40) && !doodleDead ){
            doodleDead = true;
            player.jump(delta);
        }
        
        if(doodleDead){
                //Move platforms up
                for(int i = 0; i < platformContainer.getPlatforms().size(); i++){
                    platformContainer.getPlatforms().get(i).addToY(-16*delta);
                }
                
                // When doodle finally falls below the screen, show gameover screen.
                if(player.getY() > 600){
                    gamestate = Gamestate.GAMEOVER;
                    updateable.setGamestate(gamestate);
                }
        }
        
        if(addToScore){
            player.addToScore(-player.getyVelocity());
        }
        
        player.move(delta);
    }
    
    /**
     * Returns the list of platforms
     * @return list of platforms
     */
    public List<Platform> getPlatforms() {
        return platformContainer.getPlatforms();
    }

    public boolean isGamePaused() {
        return gamePaused;
    }

    public boolean isDoodleDead() {
        return doodleDead;
    }

    public PlatformContainer getPlatformContainer() {
        return platformContainer;
    }

    
    
}
