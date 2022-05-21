package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class HighScoreAction implements ActionListener {


    private Game game;
    private MyView view;
    private JFrame frame;






    public HighScoreAction(Game game, JFrame frame, MyView view) {
        this.game = game;
        this.frame = frame;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
//        frame.dispose();
//        frame = new JFrame("High Scores");

        frame.getContentPane().removeAll();
        frame.repaint();


        HighScores scores = new HighScores(game, frame, view);
        frame.add(scores.getMainScores(game.getLevel(), game));


        //frame.add(scores.getMainScores(game.getLevel(), game), BorderLayout.CENTER);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLocationByPlatform(true);
        frame.setResizable(false);
        frame.setSize(1200, 700);
        frame.setVisible(true);

    }
}
