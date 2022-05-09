package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Level3Action implements ActionListener {

    private GameLevel level;
    private Game game;

    public Level3Action(Game game, GameLevel level) {
        this.level = level;
        this.game = game;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        game.getLevel().stop();
        game.getGameMusic().stop();
        game.startLevel3();
    }
}
