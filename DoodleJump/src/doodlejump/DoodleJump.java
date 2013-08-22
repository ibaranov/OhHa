package doodlejump;
import doodlejump.gui.Interface;
import doodlejump.peli.Game;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

public class DoodleJump {

    public static void main(String[] args) {
        
        // Sets up a new game
        final Game peli = new Game(400, 600);
        // Sets up a new GUI
        Interface kayttoliittyma = new Interface(peli);
        SwingUtilities.invokeLater(kayttoliittyma);
    
        while (kayttoliittyma.getPaivitettava() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Piirtoalustaa ei ole vielä luotu.");
            }
        }
        
        // Sets a new Updateable class for Game
        peli.setUpdateable(kayttoliittyma.getPaivitettava());
        
        // Try to run the game
        try {
            peli.run();
        } catch (InterruptedException ex) {
            Logger.getLogger(DoodleJump.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
}