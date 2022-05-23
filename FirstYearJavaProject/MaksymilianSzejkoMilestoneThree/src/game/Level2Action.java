package game;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class Level2Action implements ActionListener {

    private GameLevel level;
    private Game game;
    private StateController stateController;

    public Level2Action(Game game, GameLevel level) {
        this.level = level;
        this.game = game;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        game.getLevel().stop();
        game.getGameMusic().stop();

        game.startLevel2();
    }
}
