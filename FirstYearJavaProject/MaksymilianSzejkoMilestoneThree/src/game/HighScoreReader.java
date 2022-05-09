package game;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

/**
 * Contains methods for reading scores.
 * @author      Maksymilian Szejko, Maksymilian.Szejko@city.ac.uk
 * @version     1.0
 */
public class HighScoreReader {
    private String fileName;

    public HighScoreReader(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Reads high scores from a save file.
     * <p>
     * Reads high scores from a save file.
     *
     * @return playerScores Returns 2d array list of player scores.
     */
    public ArrayList<ArrayList<String>> readScores() throws IOException {
        FileReader fr = null;
        BufferedReader reader = null;
        ArrayList<ArrayList<String>> playerScores = new ArrayList<>(); //create an empty 2d array list
        try {
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                ArrayList<String> scores = new ArrayList<>();
                // file is assumed to contain one name, score and level per line
                String[] tokens = line.split(",");
                String name = tokens[0];
                int score = Integer.parseInt(tokens[1]);
                String level = tokens[2];
                // add the high score information into the inner array
                scores.add(name);
                String levelName = level.replace("game.", ""); // remove some text to make it look nicer
                scores.add(levelName);
                scores.add(String.valueOf(score));
                // add the array into another array (this will repeat and add a new array into the outer array making an array of arrays)
                playerScores.add(scores);
                line = reader.readLine();
            }
        }catch (IOException ioException) {
            System.out.println("No save files found");
        }

        finally {
            if (reader != null) {
                reader.close();
            }
            if (fr != null) {
                fr.close();
            }
        }
        return playerScores;
    }


}
