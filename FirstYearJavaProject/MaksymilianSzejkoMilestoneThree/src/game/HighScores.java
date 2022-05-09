package game;

import javax.swing.*;
import javax.swing.table.DefaultTableModel;
import java.io.IOException;
import java.util.ArrayList;

public class HighScores {
    private JButton backButton;
    private JPanel mainScores;
    private JTable highScoreTable;
    private HighScoreReader reader;
    private Game game;
    private ArrayList<ArrayList<String>> highScores;


    public JPanel getMainScores(GameLevel level, Game game) {
        return mainScores;
    }




    public HighScores(Game game, JFrame frame, MyView view) {
        this.game = game;
        backButton.addActionListener(new MainMenuAction(game, frame, view));

        reader = new HighScoreReader("data/highScore.txt");


        try {
            highScores = reader.readScores();
        } catch (IOException ioException) {
            ioException.printStackTrace();
        }

        Object[][] highScoresObjects = new Object[highScores.size()][];
        for (int i = 0; i < highScores.size(); i++) {
            ArrayList<String> row = highScores.get(i);
            highScoresObjects[i] = row.toArray(new String[0]);
        }


        highScoreTable.setModel(new DefaultTableModel(highScoresObjects, new String[]{"Player Name", "Level","Score"}));





    }






}
