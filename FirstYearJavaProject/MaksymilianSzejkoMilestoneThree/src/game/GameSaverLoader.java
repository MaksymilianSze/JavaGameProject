package game;

import java.io.*;

/**
 * Saver and loader for mid game sessions.
 * @author      Maksymilian Szejko, Maksymilian.Szejko@city.ac.uk
 * @version     1.0
 */
public class GameSaverLoader {

    /**
     * Saves the current game state.
     * <p>
     * Saves the current game state.
     *
     * @param fileName The path of the location to save the game state.
     * @param game The game object so that the object within the game can be accessed and saved.
     *
     */
    public static void save(String fileName, Game game) throws IOException {
        boolean append = false;
        FileWriter writer = null;
        // open the writer in not in append mode so it will overwrite any previous save information
        try {
            writer = new FileWriter(fileName, append);
            writer.write(game.getLevel().getLevelName() + "," + game.getLevel().getTruck().getPoints() + "," + game.getLevel().getTruck().getCurrentHealth() + "," + game.getPlayerName() + "\n"); // write the level, points, truck health and the player name
        } finally {
            if (writer != null) {
                writer.close(); //close the writer when it is done writing everything
            }
        }
    }
    /**
     * Loads the game state from a save file.
     * <p>
     * Loads the game state from a save file. This is used to load a previously saved game from the main menu.
     *
     * @param fileName The path of the location to save the game state.
     * @param game The game object so that the object within the game can be accessed and saved.
     *
     */
    public static GameLevel load(String fileName, Game game) throws IOException {
        FileReader fr = null;
        BufferedReader reader = null;
        String level;
        try {
            fr = new FileReader(fileName);
            reader = new BufferedReader(fr);
            String line = reader.readLine();
            while (line != null) {
                String[] tokens = line.split(","); // split each value to read by a comma
                level = tokens[0]; //first value will be the level
                int score = Integer.parseInt(tokens[1]); //second value will be the score
                int health = Integer.parseInt(tokens[2]); //third value will the the health
                String name = tokens[3]; //fourth value will be the player name
                line = reader.readLine();
                game.setPlayerName(name); //set the player name

                switch (level) {
                    // depending on which level is read, create a new level object of that said level and set the score and health of that level object
                    case "Level1" -> {
                        GameLevel saveLevel = new Level1(game);
                        saveLevel.getTruck().setPoints(score);
                        saveLevel.getTruck().setCurrentHealth(health);
                        return saveLevel;
                    }
                    case "Level2" -> {
                        GameLevel saveLevel = new Level2(game);
                        saveLevel.getTruck().setPoints(score);
                        saveLevel.getTruck().setCurrentHealth(health);
                        return saveLevel;
                    }
                    case "Level3" -> {
                        GameLevel saveLevel = new Level3(game);
                        saveLevel.getTruck().setPoints(score);
                        saveLevel.getTruck().setCurrentHealth(health);
                        return saveLevel;
                    }
                    case "Level4" -> {
                        GameLevel saveLevel = new Level4(game);
                        saveLevel.getTruck().setPoints(score);
                        saveLevel.getTruck().setCurrentHealth(health);
                        return saveLevel;
                    }
                }
            }
        } finally {
            if (reader != null) {
                reader.close(); // close the reader when it is done reading
            }
            if (fr != null) {
                fr.close();
            }
        }

        return null;
    }
}
