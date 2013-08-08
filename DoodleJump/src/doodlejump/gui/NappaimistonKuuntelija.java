
package doodlejump.gui; 
import doodlejump.peli.Direction;
import doodlejump.domain.Gamestate;
import doodlejump.peli.Player;
import doodlejump.peli.Peli;
import java.util.*;
import java.awt.Component;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import javax.swing.JFrame;
import javax.swing.event.MouseInputAdapter;

public class NappaimistonKuuntelija extends MouseInputAdapter implements KeyListener {

    
    private Player player;
    private Piirtoalusta piirtoalusta;
    private Peli peli;
    private Gameover gameover;
   
    
    public NappaimistonKuuntelija(Piirtoalusta piirtoalusta, Player player, Peli peli, Gameover gameover) {
        this.player = player;
        this.piirtoalusta = piirtoalusta;
        this.peli = peli;
        this.gameover = gameover;
    }
    
    @Override
    public void mousePressed(MouseEvent e) {
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
       
       if (peli.getGamestate() == Gamestate.SPLASH && e.getButton() == 1) {
            peli.setGamestate(Gamestate.MAINMENU);
            piirtoalusta.setGamestate(Gamestate.MAINMENU);
        }
       
        
    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_LEFT) {
            if(player.getDirection() == Direction.RIGHT){
                player.zeroAcceleration();
            } else {
                player.setAcceleration(-1);
            }
            player.setDirection(Direction.LEFT);
        } else if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
            if(player.getDirection() == Direction.LEFT){
                player.zeroAcceleration();
            } else {
                player.setAcceleration(1);
            }
            player.setDirection(Direction.RIGHT);
        } else if (e.getKeyCode() == KeyEvent.VK_UP) {
            player.zeroAcceleration();
            player.setDirection(Direction.INPLACE);
        } else if (e.getKeyCode() == KeyEvent.VK_P) {
            if(peli.getGamestate() == Gamestate.PAUSE){
                peli.setGamestate(Gamestate.GAME);
            } else if(peli.getGamestate() == Gamestate.GAME)
            peli.setGamestate(Gamestate.PAUSE);
            
        }  
        
        if ( (peli.getGamestate() == Gamestate.GAME || peli.getGamestate() == Gamestate.PAUSE || peli.getGamestate() == Gamestate.GAMEOVER ) && e.getKeyCode() == KeyEvent.VK_R) {
            peli.restart();
        }
        
        if (peli.getGamestate() == Gamestate.SPLASH && e.getKeyCode() == KeyEvent.VK_ENTER) {
            peli.setGamestate(Gamestate.MAINMENU);
            piirtoalusta.setGamestate(Gamestate.MAINMENU);
        }
        
        if (peli.getGamestate() == Gamestate.HIGHSCORES && e.getKeyCode() == KeyEvent.VK_ENTER) {
            peli.restart();
            peli.setGamestate(Gamestate.MAINMENU);
            piirtoalusta.setGamestate(Gamestate.MAINMENU);
        }
        
        if (peli.getGamestate() == Gamestate.GAMEOVER && gameover.setNewHighscore() ) {
            String merkki = e.getKeyChar() + "";
            if (e.getKeyCode() == KeyEvent.VK_ENTER) {
		gameover.sendScoreToHighscore();
                peli.setGamestate(Gamestate.HIGHSCORES);
                piirtoalusta.setGamestate(Gamestate.HIGHSCORES);
            }
            else if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
		gameover.removeCharFromName();
            }
            else if (merkki.matches("\\p{ASCII}|[ŒŠš€…§Ÿ†]")) {
		gameover.writeCharToName(merkki);
            }
        }
        
        piirtoalusta.paivita();
    }

    @Override
    public void keyReleased(KeyEvent e) {
    }

    @Override
    public void keyTyped(KeyEvent ke) {
    }
}
