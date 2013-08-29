
package doodlejump.gui; 
import doodlejump.peli.Direction;
import doodlejump.domain.Gamestate;
import doodlejump.peli.Player;
import doodlejump.peli.Game;
import java.util.*;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.event.MouseInputAdapter;
/**
 * Listens to user key input to control the game  
 * @author Ivan
 */
public class DoodleKeyListener extends MouseInputAdapter implements KeyListener {

    
    private Player player;
    private CanvasDrawer piirtoalusta;
    private Game peli;
    private Gameover gameover;
   
    /**
     * KeyListener so that the game will respond to user input.
     * 
     * @param piirtoalusta Instance of CanvasDrawer
     * @param player Player in the game
     * @param peli Instance of the game
     * @param gameover Gameover screen so that a high score can be saved.
     */
    public DoodleKeyListener(CanvasDrawer piirtoalusta, Player player, Game peli, Gameover gameover) {
        this.player = player;
        this.piirtoalusta = piirtoalusta;
        this.peli = peli;
        this.gameover = gameover;
    }
    
    /**
     * MouseListener for the Splash and Main menu screens.
     * @param e MouseEvent
     */
    @Override
    public void mousePressed(MouseEvent e) {
       // Main menu buttons
       if(peli.getGamestate() == Gamestate.MAINMENU && e.getButton()==1 && e.getX() >= 110 && e.getX() <= 290){
           if(e.getY() >= 215 && e.getY() <= 290){
                peli.setGamestate(Gamestate.GAME);
                piirtoalusta.setGamestate(Gamestate.GAME);
           } else if(e.getY() >= 300 && e.getY() <= 375){
               peli.setGamestate(Gamestate.HIGHSCORES);
               piirtoalusta.setGamestate(Gamestate.HIGHSCORES);
           } else if(e.getY() >= 390 && e.getY() <= 465){
               peli.setGamestate(Gamestate.EXIT);
               piirtoalusta.setGamestate(Gamestate.EXIT);
               System.exit(0);
           }
       }
       
       // Move from Splash screen
       if (peli.getGamestate() == Gamestate.SPLASH && e.getButton() == 1) {
            peli.setGamestate(Gamestate.MAINMENU);
            piirtoalusta.setGamestate(Gamestate.MAINMENU);
        }
       
        
    }
    /**
     * Method that listens to user input and decides what to do with it.
     * 
     * @param e KeyEvent
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if(peli.getGamestate() == Gamestate.GAME){
            this.controlPlayer(e);
        }
        
        if (e.getKeyCode() == KeyEvent.VK_P) {
            this.pauseGame();
        }
        
        // Restart the game
        if ( e.getKeyCode() == KeyEvent.VK_R && ( peli.getGamestate() == Gamestate.GAME || peli.getGamestate() == Gamestate.PAUSE || 
                peli.getGamestate() == Gamestate.GAMEOVER ) && !gameover.setNewHighscore()) {
            peli.restart();
        }
        
        
        if (peli.getGamestate() == Gamestate.SPLASH && e.getKeyCode() == KeyEvent.VK_ENTER) {
            peli.setGamestate(Gamestate.MAINMENU);
            piirtoalusta.setGamestate(Gamestate.MAINMENU);
        }
        
        // Move to main menu from Highscores screen
        if (peli.getGamestate() == Gamestate.HIGHSCORES && e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            peli.restart();
            peli.setGamestate(Gamestate.MAINMENU);
            piirtoalusta.setGamestate(Gamestate.MAINMENU);
        }
        
        if (peli.getGamestate() == Gamestate.GAMEOVER && gameover.setNewHighscore() ) {
            this.writeNameToHighscores(e);
        }
        
        piirtoalusta.paivita();
    }
    
    /**
     * Method to take user input and control the player.
     * @param e 
     */
    public void controlPlayer(KeyEvent e){
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if(player.getDirection() == Direction.RIGHT){
                player.zeroXAcceleration();
            } else {
                player.setAcceleration(-1);
            }
                player.setDirection(Direction.LEFT);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if(player.getDirection() == Direction.LEFT){
                player.zeroXAcceleration();
            } else {
                player.setAcceleration(1);
            }
                player.setDirection(Direction.RIGHT);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            player.zeroXAcceleration();
            player.setDirection(Direction.INPLACE);
        }
    }
    
    /**
     * Method to pause the game
     */
    public void pauseGame(){
        if(peli.getGamestate() == Gamestate.GAME){
            peli.setGamestate(Gamestate.PAUSE);
        } else if(peli.getGamestate() == Gamestate.PAUSE){
            peli.setGamestate(Gamestate.GAME);
        }
    }
    
    /**
     * Method that allows the player name to be written to the High score list.
     * Enter key is used to confirm the name.
     * Also implements backspace to correct mistakes in written names.
     * @param e KeyEvent
     */
    public void writeNameToHighscores(KeyEvent e){
        String merkki = e.getKeyChar() + "";
        if (e.getKeyCode() == KeyEvent.VK_ENTER) {
            gameover.sendScoreToHighscore();
            peli.setGamestate(Gamestate.HIGHSCORES);
            piirtoalusta.setGamestate(Gamestate.HIGHSCORES);
        } else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
            gameover.removeCharFromName();
        } else if (merkki.matches("\\p{ASCII}|[ŒŠš€…§Ÿ†]")) {
            gameover.writeCharToName(merkki);
        }    
    }
    
    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }
}
