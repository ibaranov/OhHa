package doodlejump.gui;

import doodlejump.gui.NappaimistonKuuntelija;
import doodlejump.peli.Platform;
import doodlejump.peli.Peli;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.*;
/**
 * GUi of the game.
 * @author Ivan
 */
public class Kayttoliittyma implements Runnable {

    private JFrame frame;
    private Piirtoalusta piirtoalusta;
    private Peli peli;
    private int windowWidth;
    private int windowHeight;
    
    /**
     * The constructor also sets the game window height and width
     * @param peli the game that will be controlled by this GUI
     */
    public Kayttoliittyma(Peli peli) {
        this.peli = peli;
        this.windowHeight = 600;
        this.windowWidth = 400; 
    }
    
    
    @Override
    public void run() {
        frame = new JFrame();
        frame.setPreferredSize(new Dimension(windowWidth, windowHeight));
        
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        //frame.setResizable(true);
        frame.setTitle("Jumper");
        luoKomponentit(frame.getContentPane());
        
        
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Method that creates all GUI components, the new Piirtoalusta 
     * {@link Piirtoalusta} and add a new Key- and MouseListener {@link Nappaimistonkuuntelija}
     * Gui components:
     *  Splash screen
     *  Main menu screen
     *  Highscore screen
     *  Gameover screen
     * 
     * @param container 
     */
    private void luoKomponentit(Container container) {
        Splash splash = new Splash();
        Mainmenu main = new Mainmenu();
        Highscore highscore = new Highscore();
        Gameover gameover = new Gameover(highscore);
                
        
        // Create text field for gameover screen
       
        // create piirtoalusta
        piirtoalusta = new Piirtoalusta(peli.getPlayer(), peli.getPlatforms(), splash, main, gameover, highscore);
        
        container.add(piirtoalusta);
        
        NappaimistonKuuntelija nk = new NappaimistonKuuntelija(piirtoalusta, peli.getPlayer(), peli, gameover);
        frame.addKeyListener(nk);
        frame.addMouseListener(nk);
        
    }

   
    
    public JFrame getFrame() {
        return frame;
    }
    
    /**
     * 
     * @return Piirtoalusta 
     */
    public Paivitettava getPaivitettava(){
        return piirtoalusta;
    }
 
}
