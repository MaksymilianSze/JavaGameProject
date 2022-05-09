package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class RestartAction implements ActionListener {

    private GameLevel level;
    private Game game;

    public RestartAction(Game game, GameLevel level) {
        this.game = game;
        this.level = level;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (game.getLevel().getClass() == Level1.class) {
            game.getLevel().stop();
            game.getGameMusic().stop();
            game.startLevel1();
        }
        else if (game.getLevel().getClass() == Level2.class ) {
            game.getLevel().stop();
            game.getGameMusic().stop();
            game.startLevel2();
        }
        else if (game.getLevel().getClass() == Level3.class) {
            game.getLevel().stop();
            game.getGameMusic().stop();
            game.startLevel3();
        }
        else if (game.getLevel().getClass() == Level4.class) {
            game.getLevel().stop();
            game.getGameMusic().stop();
            game.startLevel4();
        }

    }
}
