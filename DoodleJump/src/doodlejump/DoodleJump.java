package doodlejump;
import doodlejump.gui.Kayttoliittyma;
import doodlejump.peli.Peli;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

public class DoodleJump {

    public static void main(String[] args) {
        
        // Sets up a new game
        final Peli peli = new Peli(400, 600);
        // Sets up a new GUI
        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(peli);
        SwingUtilities.invokeLater(kayttoliittyma);
    
        while (kayttoliittyma.getPaivitettava() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Piirtoalustaa ei ole vielä luotu.");
            }
        }
        
        // Sets a new Paivitettava class for Peli
        peli.setPaivitettava(kayttoliittyma.getPaivitettava());
        
        // Try to run the game
        try {
            peli.run();
        } catch (InterruptedException ex) {
            Logger.getLogger(DoodleJump.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
}