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

    public PauseAction(GameLevel level, Game game, JFrame frame) {
        this.level = level;
        this.game = game;
        this.frame = frame;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (game.getLevel().isRunning()) {
            game.getGameMusic().pause();
            GameLevel.getEngineIdle().pause();
            game.getLevel().stop();
            gui = new Gui(game.getLevel(), game, frame, game.getView());
            frame.add(gui.getMainPanel(), BorderLayout.WEST);
            frame.revalidate();
            frame.repaint();

//            frame.getContentPane().removeAll();
//            frame.repaint();
//            frame.setPreferredSize(new Dimension(1200, 700));
//
//            PauseMenu pauseMenu = new PauseMenu(game.getLevel(), game, frame);
//            frame.add(pauseMenu.getMainPauseMenu(), BorderLayout.CENTER);
//            frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//            frame.setResizable(false);
//            frame.pack();
//            frame.setVisible(true);
        }
        else {
            frame.remove(gui.getMainPanel());
            frame.revalidate();
            frame.repaint();
            game.getGameMusic().resume();
            GameLevel.getEngineIdle().resume();
            game.getLevel().start();

        }
    }
}
