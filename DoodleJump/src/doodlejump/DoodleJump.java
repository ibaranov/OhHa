package doodlejump;
import doodlejump.gui.Kayttoliittyma;
import doodlejump.peli.Peli;
import java.awt.Graphics;
import java.util.logging.Level;
import java.util.logging.Logger;

import javax.swing.ImageIcon;
import javax.swing.SwingUtilities;

public class DoodleJump {

    public static void main(String[] args) {
        
        final Peli peli = new Peli(400, 600);

        Kayttoliittyma kayttoliittyma = new Kayttoliittyma(peli);
        SwingUtilities.invokeLater(kayttoliittyma);
    
        while (kayttoliittyma.getPaivitettava() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("Piirtoalustaa ei ole vielä luotu.");
            }
        }

        peli.setPaivitettava(kayttoliittyma.getPaivitettava());
        
        try {
            peli.run();
        } catch (InterruptedException ex) {
            Logger.getLogger(DoodleJump.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
}