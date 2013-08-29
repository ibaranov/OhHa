package doodlejump.gui;

import doodlejump.gui.DoodleKeyListener;
import doodlejump.game.Game;
import java.awt.Container;
import java.awt.Dimension;
import javax.swing.*;
/**
 * Controls the GUI of the game.
 * @author Ivan
 */
public class Interface implements Runnable {

    private JFrame frame;
    private CanvasDrawer drawingboard;
    private Game game;
    private int windowWidth;
    private int windowHeight;
    
    /**
     * The constructor also sets the game window height and width
     * @param game the game that will be controlled by this GUI
     */
    public Interface(Game game) {
        this.game = game;
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
        createComponents(frame.getContentPane());
        
        
        frame.pack();
        frame.setVisible(true);
    }

    /**
     * Method that creates all GUI components, the new CanvasDrawer 
     * {@link CanvasDrawer} and add a new Key- and MouseListener {@link Nappaimistonkuuntelija}
     * Gui components:
     *  Splash screen
     *  Main menu screen
     *  Highscore screen
     *  Gameover screen
     * 
     * @param container 
     */
    private void createComponents(Container container) {
        Splash splash = new Splash();
        Mainmenu main = new Mainmenu();
        Highscore highscore = new Highscore();
        Gameover gameover = new Gameover(highscore);
                
        
        // Create text field for gameover screen
       
        // create drawingboard
        drawingboard = new CanvasDrawer(game.getPlayer(), game.getPlatformContainer(), splash, main, gameover, highscore);
        
        container.add(drawingboard);
        
        DoodleKeyListener nk = new DoodleKeyListener(drawingboard, game.getPlayer(), game, gameover);
        frame.addKeyListener(nk);
        frame.addMouseListener(nk);
        
    }

   
    
    public JFrame getFrame() {
        return frame;
    }
    
    /**
     * 
     * @return CanvasDrawer 
     */
    public Updateable getUpdateable(){
        return drawingboard;
    }
 
}
