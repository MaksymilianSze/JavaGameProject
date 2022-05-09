package game;

import javax.swing.*;

public class LoadSaveSelection {
    private JButton backButton;
    private JPanel SaveSelectionPanel;
    private Game game;

    public JPanel getSaveSelectionPanel(GameLevel level, Game game) {
        return SaveSelectionPanel;
    }

    public LoadSaveSelection(Game game, JFrame frame, MyView view) {
        this.game = game;
        backButton.addActionListener(new MainMenuAction(game, frame, view));
    }
}
