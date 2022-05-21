package game;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class LoadSaveAction implements ActionListener {


    private Game game;
    private MyView view;
    private JFrame frame;
    private GameLevel level;
    private StateController stateController;


    public LoadSaveAction(Game game, JFrame frame, MyView view) {
        this.game = game;
        this.frame = frame;
        this.view = view;
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        try {
            level = GameSaverLoader.load("data/gameSave.txt", game);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

//        frame.dispose();
//        frame = new JFrame("Monster Trucker");

        frame.getContentPane().removeAll();
        frame.repaint();

        game.startLevelFromSave(level);

        frame.add(game.getView());
        Gui gui = new Gui(game.getLevel(), game, frame, view);
        frame.add(gui.getMainPanel(), BorderLayout.WEST);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        //frame.setLocationByPlatform(true);
        frame.setResizable(false);
        frame.pack();
        frame.setVisible(true);

        stateController = new StateController(game.getLevel(),game, frame);
        view = game.getView();
        view.addKeyListener(stateController);


    }
}
