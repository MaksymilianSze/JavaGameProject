package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MainMenuAction implements ActionListener {


    private Game game;
    private MyView view;
    private JFrame frame;






    public MainMenuAction(Game game, JFrame frame, MyView view) {
        this.game = game;
        this.frame = frame;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        if (game.getLevel() != null) {
            game.getLevel().stop();
            game.getGameMusic().stop();
            GameLevel.getEngineIdle().stop();
        }

        frame.getContentPane().removeAll();
        frame.revalidate();
        frame.repaint();

        Menu menu = new Menu(game, frame, view);
        frame.add( menu.getMainMenu(), BorderLayout.CENTER);

        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.setSize(1200,700);
        // finally, make the frame visible
        frame.setVisible(true);

    }
}
