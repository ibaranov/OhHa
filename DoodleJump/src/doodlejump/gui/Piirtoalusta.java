package doodlejump.gui; 

import doodlejump.domain.Gamestate;
import static doodlejump.domain.Gamestate.GAMEOVER;
import static doodlejump.domain.Gamestate.MAINMENU;
import doodlejump.peli.Platform;
import doodlejump.peli.Player;
import java.util.*;
import javax.swing.JPanel;
import java.awt.Color;
import java.awt.Container;
import java.awt.Graphics;
import javax.swing.JPanel;
import javax.swing.JTextArea;
/**
 * A Class that is responsible for drawing everything on the screen
 * @author Ivan
 */
public class Piirtoalusta extends JPanel implements Paivitettava{

    private Player player;
    private List<Platform> plats;
    private Gamestate gamestate;
    private Splash splash;
    private Mainmenu mainmenu;
    private Gameover gameover;
    private Highscore highscore;
    
    /**
     * Constructor that sets up the background of the screen and takes the 
     * different screens of the game as parameters.
     * 
     * @param player The player
     * @param plats The platforms
     * @param splash Splash-screen
     * @param mainmenu Main menu screen
     * @param gameover Game over screen
     * @param highscore High score screen
     */
    
    public Piirtoalusta(Player player, List<Platform> plats, Splash splash, Mainmenu mainmenu, Gameover gameover, Highscore highscore) {
        this.player = player;
        this.plats = plats;
        super.setBackground(Color.WHITE);
        this.splash = splash;
        this.mainmenu = mainmenu;
        this.gamestate = Gamestate.SPLASH;
        this.gameover = gameover;
        this.highscore = highscore;
      
    }

    
    /**
     * Sets the state of the game
     * @param gamestate 
     */
    public void setGamestate(Gamestate gamestate) {
        this.gamestate = gamestate;
    }
    
    /**
     * Sets a new player
     * @param player 
     */
    public void setPlayer(Player player) {
        this.player = player;
    }

    /**
     * Sets a new list of platforms to draw
     * @param plats 
     */
    public void setPlats(List<Platform> plats) {
        this.plats = plats;
    }

    
    /**
     * Method that calls all components paint themselves on the screen.
     * This methods also includes a Switch case structure to switch between
     * different gamestates, so that only the current gamestate is drawn on
     * the screen.
     * @param graphics 
     */
    @Override
    protected void paintComponent(Graphics graphics) {
        super.paintComponent(graphics);
        
        
        switch (gamestate) {
        
            case SPLASH: 
                        splash.piirra(graphics);
                        break;
                
            case GAME: 
                        
                        // Piirra alustat
                        if(plats.size() > 0){
                            for(Platform p : plats){
                                p.piirra(graphics);
                            }
                        }
                        // Piirra pelaaja
                        player.piirra(graphics);
                        break;
            
            case MAINMENU: 
                        mainmenu.piirra(graphics);
                        break;
            
            case GAMEOVER:
                        gameover.setGraphics(graphics);
                        gameover.setScore(player.getScore());
                        gameover.piirra(graphics);
                        break;
            
            case HIGHSCORES:
                        gameover.reset();
                        highscore.piirra(graphics);
                        break;
        }
        
    }

    @Override
    public void paivita() {
        this.repaint();
    }
}