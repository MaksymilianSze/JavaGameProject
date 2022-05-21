package game;

import javax.swing.*;

public class PauseMenu {
    private JPanel mainPauseMenu;
    private JButton restartButton;
    private JButton quitButton;
    private JButton saveButton;
    private JButton mainMenuButton;
    private GameLevel level;
    private Game game;

    public JPanel getMainPauseMenu() {
        return mainPauseMenu;
    }

    public PauseMenu(GameLevel level, Game game, JFrame frame) {
        this.level = level;
        this.game = game;
        restartButton.addActionListener(new RestartAction(game,level));
        quitButton.addActionListener(new QuitAction());
        saveButton.addActionListener(new SaveAction(level, game));
        mainMenuButton.addActionListener(new MainMenuAction(game, frame, game.getView()));
    }
}
