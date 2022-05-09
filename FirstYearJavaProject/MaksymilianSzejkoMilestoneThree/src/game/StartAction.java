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






    public StartAction(Game game, JFrame frame, MyView view, Menu menu) {
        this.game = game;
        this.frame = frame;
        this.view = view;
        this.menu = menu;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        game.setPlayerName(menu.getPlayerName());
        frame.dispose();
        frame = new JFrame("Monster Trucker");
        game.startLevel1();
        frame.add(game.getView());
        Gui gui = new Gui(game.getLevel(), game, frame, view);
        frame.add(gui.getMainPanel(), BorderLayout.WEST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);






    }
}
