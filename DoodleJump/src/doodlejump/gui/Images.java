
package doodlejump.gui; 
import java.awt.Image;
import java.util.*;
import javax.swing.*;

public class Images { 
  
    
    private Image bg;
    private Image playerAvatar;
    private Image platformPlain;

    public Images() {
        ImageIcon ii = new ImageIcon(this.getClass().getResource("doodle40.png"));
        this.playerAvatar = ii.getImage();
    
    }

    public Image getBg() {
        return bg;
    }

    public Image getPlayerAvatar() {
        return playerAvatar;
    }

    public Image getPlatformPlain() {
        return platformPlain;
    }
    
    
    

}
