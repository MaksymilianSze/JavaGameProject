package game;

import javax.swing.*;

public class Gui {
    private JButton pauseButton;
    private JButton restartButton;
    private JButton quitButton;
    private JPanel mainPanel;
    private JButton level1Button;
    private JButton level3Button;
    private JButton level2Button;
    private JButton saveButton;
    private JButton level4Button;
    private JButton mainMenuButton;
    private GameLevel level;
    private Game game;




    public JPanel getMainPanel() {
        return mainPanel;

    }

    public Gui(GameLevel level, Game game, JFrame frame, MyView view) {
        this.game = game;
        this.level = level;
        quitButton.addActionListener(new QuitAction());
        pauseButton.addActionListener(new PauseAction(level,game, frame));
        saveButton.addActionListener(new SaveAction(level, game));
        restartButton.addActionListener(new RestartAction(game,level));
        level1Button.addActionListener(new Level1Action(game,level));
        level2Button.addActionListener(new Level2Action(game,level));
        level3Button.addActionListener(new Level3Action(game,level));
        level4Button.addActionListener(new Level4Action(game,level));

        mainMenuButton.addActionListener(new MainMenuAction(game, frame, view));

    }
}
