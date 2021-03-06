package doodlejump.gui;

import doodlejump.domain.Gamestate;
import doodlejump.game.Platform;
import doodlejump.game.Player;
import java.util.List;
/**
 * An interface for classes that draw images on the screen.
 * @author Ivan
 */
public interface Updateable {
    void paivita();
    public void setGamestate(Gamestate gamestate);
    public void setPlayer(Player player);
    public void setPlats(List<Platform> plats);
}
