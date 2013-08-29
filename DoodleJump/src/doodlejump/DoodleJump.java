package doodlejump;
import doodlejump.gui.Interface;
import doodlejump.game.Game;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.swing.SwingUtilities;

public class DoodleJump {

    public static void main(String[] args) {
        
        // Sets up a new game
        final Game game = new Game(400, 600);
        // Sets up a new GUI
        Interface iface = new Interface(game);
        SwingUtilities.invokeLater(iface);
    
        while (iface.getUpdateable() == null) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException ex) {
                System.out.println("CanvasDrawer has not been created yet");
            }
        }
        
        // Sets a new Updateable class for Game
        game.setUpdateable(iface.getUpdateable());
        
        // Try to run the game
        try {
            game.run();
        } catch (InterruptedException ex) {
            Logger.getLogger(DoodleJump.class.getName()).log(Level.SEVERE, null, ex);
        }
    
}
}