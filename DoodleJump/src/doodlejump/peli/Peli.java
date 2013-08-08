package doodlejump.peli; 
import doodlejump.domain.Gamestate;
import doodlejump.gui.Paivitettava;
import doodlejump.peli.Player;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.*;
import javax.swing.Timer;

public class Peli { 
  
    
    private int width;
    private int height;
    private Player player;
    private boolean gameRunning;
    private boolean gamePaused;
    private Paivitettava paivitettava;
    private PlatformContainer platformContainer;
    private Gamestate gamestate;
    private boolean doodleDead;
    

    public Peli(int width, int height) {
        
        
        this.width = width;
        this.height = height;
        this.player = new Player(width, 250, Direction.INPLACE);
        this.gameRunning = true;
        this.platformContainer = new PlatformContainer(width, height);
        this.gamestate = Gamestate.SPLASH;
        this.doodleDead = false;
    }

    public Player getPlayer() {
        return player;
    }
    
    public void pauseGame(){
        if(gamePaused){
            gamePaused = false;
        } else {
            gamePaused = true;
        }
    }

    public void setDoodleDead(boolean doodleDead) {
        this.doodleDead = doodleDead;
    }
    
    
    public void restart(){
        
        this.setGamestate(Gamestate.PAUSE);
        paivitettava.setGamestate(gamestate);
        
        this.setDoodleDead(false);
        this.player.reset();
        this.platformContainer.reset();
        
        this.setGamestate(Gamestate.GAME);
        paivitettava.setGamestate(gamestate);       
    }
    
    public void setPaivitettava(Paivitettava paivitettava) {
        this.paivitettava = paivitettava;
    }
    
    
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
                paivitettava.paivita();
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
    
    
    
    private void doGameUpdates(double delta){
        boolean addToScore = false;
        
        // Check collision with platforms
        for(Platform p : platformContainer.getPlatforms()){
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
        
        // Move platforms down and Create new platforms
        
        for(int i = 0; i < platformContainer.getPlatforms().size(); i++){
            if(player.getyVelocity() < 0 && player.getY() <= 251){
                platformContainer.getPlatforms().get(i).addToY(-player.getyVelocity());
                addToScore = true;
            }
            
            if(platformContainer.getPlatforms().get(i).getY() > height - 50){
                
                Random random = new Random();
                int platformType = 1 + random.nextInt((3+1)-1);
                if(platformType == 1){
                    platformContainer.getPlatforms().set(i, new Platform(width , 0));
                } else if (platformType == 2){
                    platformContainer.getPlatforms().set(i, new PlatformMoving(width , 0));
                } else if(platformType == 3){
                    platformContainer.getPlatforms().set(i, new PlatformDissapearing(width , 0));
                }
                
            }
        }
        
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
                    paivitettava.setGamestate(gamestate);
                }
        }
        
        
        if(addToScore){
            player.addToScore(-player.getyVelocity());
        }
        
        player.Move(delta);
    }

    public List<Platform> getPlatforms() {
        return platformContainer.getPlatforms();
    }
    

}
