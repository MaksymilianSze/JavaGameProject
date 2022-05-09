package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PauseAction implements ActionListener {

    private GameLevel level;
    private Game game;

    public PauseAction(GameLevel level, Game game) {
        this.level = level;
        this.game = game;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (game.getLevel().isRunning()) {
            game.getGameMusic().pause();
            GameLevel.getEngineIdle().pause();
            game.getLevel().stop();
        }
        else {
            game.getGameMusic().resume();
            GameLevel.getEngineIdle().resume();
            game.getLevel().start();
        }
    }
}
