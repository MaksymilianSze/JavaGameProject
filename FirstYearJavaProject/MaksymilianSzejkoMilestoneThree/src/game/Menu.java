package game;

import javax.swing.*;

public class Menu {
    private JButton playButton;
    private JButton quitButton;
    private JButton loadGameButton;
    private JButton highScoresButton;
    private JPanel mainMenu;
    private JTextField nameInputField;
    private JLabel nameInputLabel;
    private GameLevel level;
    private Game game;

    public String getPlayerName() {
        return nameInputField.getText();
    }



    public JPanel getMainMenu(GameLevel level, Game game) {
        return mainMenu;
    }

    public Menu(Game game, JFrame frame, MyView view) {
        this.game = game;
        playButton.addActionListener(new StartAction(game, frame, view, this));
        quitButton.addActionListener(new QuitAction());
        highScoresButton.addActionListener(new HighScoreAction(game, frame, view));
        loadGameButton.addActionListener(new LoadSaveAction(game, frame, view));
    }
}


