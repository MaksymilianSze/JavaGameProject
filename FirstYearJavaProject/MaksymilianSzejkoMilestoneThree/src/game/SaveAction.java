package game;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class SaveAction implements ActionListener {

    private GameLevel level;
    private Game game;

    public SaveAction(GameLevel level, Game game) {
        this.level = level;
        this.game = game;
    }

    @Override
    public void actionPerformed(ActionEvent e) {


        try {
            GameSaverLoader.save("data/gameSave.txt", game);
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

    }
}
