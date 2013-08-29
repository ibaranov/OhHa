
package doodlejump.gui; 
import doodlejump.game.Direction;
import doodlejump.domain.Gamestate;
import doodlejump.game.Player;
import doodlejump.game.Game;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import javax.swing.event.MouseInputAdapter;
/**
 * Listens to user key input to control the game  
 * @author Ivan
 */
public class DoodleKeyListener extends MouseInputAdapter implements KeyListener {

    
    private Player player;
    private CanvasDrawer drawingboard;
    private Game game;
    private Gameover gameover;
   
    /**
     * KeyListener so that the game will respond to user input.
     * 
     * @param drawingboard Instance of CanvasDrawer
     * @param player Player in the game
     * @param game Instance of the game
     * @param gameover Gameover screen so that a high score can be saved.
     */
    public DoodleKeyListener(CanvasDrawer drawingboard, Player player, Game game, Gameover gameover) {
        this.player = player;
        this.drawingboard = drawingboard;
        this.game = game;
        this.gameover = gameover;
    }
    
    /**
     * MouseListener for the Splash and Main menu screens.
     * @param e MouseEvent
     */
    @Override
    public void mousePressed(MouseEvent e) {
       // Main menu buttons
       if(game.getGamestate() == Gamestate.MAINMENU && e.getButton()==1 && e.getX() >= 110 && e.getX() <= 290){
           if(e.getY() >= 215 && e.getY() <= 290){
                game.setGamestate(Gamestate.GAME);
                drawingboard.setGamestate(Gamestate.GAME);
           } else if(e.getY() >= 300 && e.getY() <= 375){
               game.setGamestate(Gamestate.HIGHSCORES);
               drawingboard.setGamestate(Gamestate.HIGHSCORES);
           } else if(e.getY() >= 390 && e.getY() <= 465){
               game.setGamestate(Gamestate.EXIT);
               drawingboard.setGamestate(Gamestate.EXIT);
               System.exit(0);
           }
       }
       
       // Move from Splash screen
       if (game.getGamestate() == Gamestate.SPLASH && e.getButton() == 1) {
            game.setGamestate(Gamestate.MAINMENU);
            drawingboard.setGamestate(Gamestate.MAINMENU);
        }
       
        
    }
    /**
     * Method that listens to user input and decides what to do with it.
     * 
     * @param e KeyEvent
     */
    @Override
    public void keyPressed(KeyEvent e) {
        if(game.getGamestate() == Gamestate.GAME){
            this.controlPlayer(e);
        }
        
        if (e.getKeyCode() == KeyEvent.VK_P) {
            this.pauseGame();
        }
        
        // Restart the game
        if ( e.getKeyCode() == KeyEvent.VK_R && ( game.getGamestate() == Gamestate.GAME || game.getGamestate() == Gamestate.PAUSE || 
                game.getGamestate() == Gamestate.GAMEOVER ) && !gameover.setNewHighscore()) {
            game.restart();
        }
        
        
        if (game.getGamestate() == Gamestate.SPLASH && e.getKeyCode() == KeyEvent.VK_ENTER) {
            game.setGamestate(Gamestate.MAINMENU);
            drawingboard.setGamestate(Gamestate.MAINMENU);
        }
        
        // Move to main menu from Highscores screen
        if (game.getGamestate() == Gamestate.HIGHSCORES && e.getKeyCode() == KeyEvent.VK_ENTER || e.getKeyCode() == KeyEvent.VK_ESCAPE) {
            game.restart();
            game.setGamestate(Gamestate.MAINMENU);
            drawingboard.setGamestate(Gamestate.MAINMENU);
        }
        
        if (game.getGamestate() == Gamestate.GAMEOVER && gameover.setNewHighscore() ) {
            this.writeNameToHighscores(e);
        }
        
        drawingboard.paivita();
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
        if(game.getGamestate() == Gamestate.GAME){
            game.setGamestate(Gamestate.PAUSE);
        } else if(game.getGamestate() == Gamestate.PAUSE){
            game.setGamestate(Gamestate.GAME);
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
            game.setGamestate(Gamestate.HIGHSCORES);
            drawingboard.setGamestate(Gamestate.HIGHSCORES);
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
