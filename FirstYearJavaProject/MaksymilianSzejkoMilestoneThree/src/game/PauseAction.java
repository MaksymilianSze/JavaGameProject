package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class PauseAction implements ActionListener {

    private GameLevel level;
    private Game game;
    private JFrame frame;

    private Gui gui;

    public PauseAction(GameLevel level, Game game, JFrame frame, Gui gui) {
        this.level = level;
        this.game = game;
        this.frame = frame;
        this.gui = gui;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (game.getLevel().isRunning()) {
            game.getGameMusic().pause();
            GameLevel.getEngineIdle().pause();
            game.getLevel().stop();
            gui.getMainPanel().setVisible(true);
            frame.revalidate();
            frame.repaint();

        }
        else {
            gui.getMainPanel().setVisible(false);
            game.getGameMusic().resume();
            GameLevel.getEngineIdle().resume();
            game.getLevel().start();

        }
    }
}
