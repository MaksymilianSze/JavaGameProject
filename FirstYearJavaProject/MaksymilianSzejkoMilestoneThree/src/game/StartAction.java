package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class StartAction implements ActionListener {


    private Game game;
    private MyView view;
    private JFrame frame;
    private Menu menu;
    private StateController stateController;
    private Gui gui;


    public StartAction(Game game, JFrame frame, MyView view, Menu menu) {
        this.game = game;
        this.frame = frame;
        this.view = view;
        this.menu = menu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        game.setPlayerName(menu.getPlayerName());

        frame.getContentPane().removeAll();
        frame.repaint();
        frame.revalidate();


        game.startLevel1();
        frame.add(game.getView());


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);

    }

}
