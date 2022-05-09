package game;

import java.io.FileWriter;
import java.io.IOException;

/**
 * Writer for writing high scores to a save file
 * @author      Maksymilian Szejko, Maksymilian.Szejko@city.ac.uk
 * @version     1.0
 */
public class HighScoreWriter {
    private String fileName;

    public HighScoreWriter(String fileName) {
        this.fileName = fileName;
    }

    /**
     * Writes high scores from a save file.
     * <p>
     * Writes high scores from a save file.
     *
     * @param name The name of the player
     * @param score The score the player has achieved in the level
     * @param level The level the player has achieved this score in
     */
    public void writeHighScore(String name, int score, String level) throws IOException {
        boolean append = true;
        FileWriter writer = null;
        try {
            writer = new FileWriter(fileName, append); //open the file in append mode
            writer.write(name + "," + score + "," + level + "\n"); //write the name, score and level with commas separating each value
        } finally {
            if (writer != null) {
                writer.close(); //close the writer when it reaches the end of what it needs to write
            }
        }
    }


}
