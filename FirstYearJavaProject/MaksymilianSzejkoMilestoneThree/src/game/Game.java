package game;

import city.cs.engine.SoundClip;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;


/**
 * Where the game is created
 * @author      Maksymilian Szejko, Maksymilian.Szejko@city.ac.uk
 * @version     3.0
 */


public class Game {

    /** The World in which the bodies move and interact. */
    private GameLevel level;

    /** A graphical display of the world (a specialised JPanel). */
    private MyView view;

    /**
     * The controller that is used to move the truck
     */
    private TruckController controller;

    /**
     * Has the music for the level
     */
    private SoundClip gameMusic;

    private JFrame frame;

    private StateController stateController;

    public Gui getGui() {
        return gui;
    }

    public void setGui(Gui gui) {
        this.gui = gui;
    }

    private Gui gui;

    /**
     * A graphical display for the main menu.
     */
    private Menu menu;

    private HighScoreWriter saveScore;

    private String playerName = "Player1";

    public String getPlayerName() {
        return playerName;
    }

    public void setPlayerName(String playerName) {
        this.playerName = playerName;
    }

    public GameLevel getLevel() {
        return level;
    }

    public SoundClip getGameMusic() {
        return gameMusic;
    }

    public MyView getView() {
        return view;
    }

    public JFrame getFrame() {
        return frame;
    }

    /**
     * This is where the game is created
     * <p>
     * This is where the game is created. The main menu frame is created here to start the game and from here
     * the levels can be started.
     */

    public Game() {


        frame = new JFrame("Monster Trucker");


        menu = new Menu(this, frame, view);
        frame.add( menu.getMainMenu(), BorderLayout.CENTER );

        // enable the frame to quit the application
        // when the x button is pressed
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLocationByPlatform(true);
        // don't let the frame be resized
        frame.setResizable(false);
        // size the frame to fit the world view
        frame.setSize(1200,700);
        // finally, make the frame visible
        frame.setVisible(true);



    }
    /**
     * The method for starting game from a save file.
     * <p>
     * The method for starting game from a save file. A level object with the right level details is passed in here and
     * depending on the level we load the right backgrounds and music etc..
     *
     * @param  level Level object that was created from reading from the save file.
     * @return no return type
     *
     */
    public void startLevelFromSave(GameLevel level) {
        if (view == null) {
            view = new MyView(level, 1200,700);
        }
        view.setWorld(level);
        this.level = level;


        if (Level1.class.equals(level.getClass())) {
            view.setBackground(new ImageIcon("data/background1.png").getImage());
            try {
                gameMusic = new SoundClip("data/Level1Music.wav");   // Open an audio input stream
                gameMusic.loop();  // Set it to continuous playback (looping)
                gameMusic.setVolume(0.2);
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }


        } else if (Level2.class.equals(level.getClass())) {
            view.setBackground(new ImageIcon("data/background2.jpg").getImage());
            try {
                gameMusic = new SoundClip("data/Level2Music.wav"); // Open an audio input stream
                gameMusic.loop();  // Set it to continuous playback (looping)
                gameMusic.setVolume(0.2);
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }
        } else if (Level3.class.equals(level.getClass())) {
            view.setBackground(new ImageIcon("data/background3.jpg").getImage());
            try {
                gameMusic = new SoundClip("data/Level3Music.wav"); // Open an audio input stream
                gameMusic.loop();  // Set it to continuous playback (looping)
                gameMusic.setVolume(0.2);
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }
        } else if (Level4.class.equals(level.getClass())) {
            view.setBackground(new ImageIcon("data/background4.jpg").getImage());
            try {
                gameMusic = new SoundClip("data/Level4Music.wav"); // Open an audio input stream
                gameMusic.loop();  // Set it to continuous playback (looping)
                gameMusic.setVolume(0.2);
            } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
                System.out.println(e);
            }
        }
        //add the mouse listener, key listener, set the new truck, add the step listener
        view.addMouseListener(new GiveFocus(view));
        controller = new TruckController( level.getTruck() );
        view.addKeyListener(controller);
        view.setTruck(level.getTruck());
        level.addStepListener(new Tracker(view, level.getHay(), level.getTruck(), level.getBrokenCar() ));

        guiStartUp();

        level.start();


    }
    /**
     * The method for starting level 1.
     * <p>
     * The method for starting level 1. This method loads the correct image and music for level 1.
     *
     *
     *
     *
     */
    public void startLevel1() {

        level = new Level1(this);
        //check if the view has been filled yet, this needs to be done because if you load any level from outside one of the other levels then the view will be null
        if (view == null) {
            view = new MyView(level, 1200,700);
        }
        //add the mouse listener, key listener, set the new truck, add the step listener
        view.setWorld(level);
        view.setBackground(new ImageIcon("data/background1.png").getImage());
        view.addMouseListener(new GiveFocus(view));
        controller = new TruckController( level.getTruck() );
        view.addKeyListener(controller);
        view.setTruck(level.getTruck());
        level.addStepListener(new Tracker(view, level.getHay(), level.getTruck(), level.getBrokenCar() ));

        guiStartUp();

        level.start();

        try {
            gameMusic = new SoundClip("data/Level1Music.wav");   // Open an audio input stream
            gameMusic.loop();  // Set it to continuous playback (looping)
            gameMusic.setVolume(0.2);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    /**
     * The method for starting level 2.
     * <p>
     * The method for starting level 2. This method loads the correct image and music for level 2.
     *
     *
     *
     *
     */
    public void startLevel2() {
        level = new Level2(this);
        //check if the view has been filled yet, this needs to be done because if you load any level from outside one of the other levels then the view will be null
        if (view == null) {
            view = new MyView(level, 1200,700);
        }
        //add the mouse listener, key listener, set the new truck, add the step listener
        view.setWorld(level);
        view.setBackground(new ImageIcon("data/background2.jpg").getImage());
        view.setTruck(level.getTruck());
        view.addMouseListener(new GiveFocus(view));
        controller.setTruck(level.getTruck());
        level.addStepListener(new Tracker(view, level.getHay(), level.getTruck(), level.getBrokenCar()));

        guiStartUp();

        level.start();
        try {
            gameMusic = new SoundClip("data/Level2Music.wav");
            gameMusic.loop();  // Set it to continuous playback (looping)
            gameMusic.setVolume(0.2);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }
    /**
     * The method for starting level 3.
     * <p>
     * The method for starting level 3. This method loads the correct image and music for level 3.
     *
     *
     *
     *
     */
    public void startLevel3() {
        level = new Level3(this);
        //check if the view has been filled yet, this needs to be done because if you load any level from outside one of the other levels then the view will be null
        if (view == null) {
            view = new MyView(level, 1200,700);
        }
        //add the mouse listener, key listener, set the new truck, add the step listener
        view.setWorld(level);
        view.setBackground(new ImageIcon("data/background3.jpg").getImage());
        view.setTruck(level.getTruck());
        view.addMouseListener(new GiveFocus(view));
        controller.setTruck(level.getTruck());
        level.addStepListener(new Tracker(view, level.getHay(), level.getTruck(), level.getBrokenCar()));

        guiStartUp();

        level.start();

        try {
            gameMusic = new SoundClip("data/Level3Music.wav");
            gameMusic.loop();  // Set it to continuous playback (looping)
            gameMusic.setVolume(0.2);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     * The method for starting level 4.
     * <p>
     * The method for starting level 4. This method loads the correct image and music for level 4.
     *
     *
     *
     *
     */
    public void startLevel4() {
        level = new Level4(this);
        //check if the view has been filled yet, this needs to be done because if you load any level from outside one of the other levels then the view will be null
        if (view == null) {
            view = new MyView(level, 1200,700);
        }
        //add the mouse listener, key listener, set the new truck, add the step listener
        view.setWorld(level);
        view.setBackground(new ImageIcon("data/background4.jpg").getImage());
        view.setTruck(level.getTruck());
        controller.setTruck(level.getTruck());
        level.addStepListener(new Tracker(view, level.getHay(), level.getTruck(), level.getBrokenCar()));

        guiStartUp();

        level.start();

        try {
            gameMusic = new SoundClip("data/Level4Music.wav");
            gameMusic.loop();  // Set it to continuous playback (looping)
            gameMusic.setVolume(0.2);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    /**
     * Method for progressing from one level to the next.
     * <p>
     * Method for progressing from one level to the next. Also the score for the finished level is recorded for the high
     * score leaderboards section.
     *
     *
     *
     *
     */
    public void goToNextLevel(){
        //check that the level complete requirements have been met
        if (level.isComplete()) {
            //if the level is complete then save the score for high scores
            saveScore = new HighScoreWriter("data/highScore.txt");
            try {
                saveScore.writeHighScore(this.getPlayerName(),level.getTruck().getPoints(), level.getClass().getName());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
            //depending on which level you are currently at then load the next level accordingly
            if (level instanceof Level1){
                level.getTruck().setPoints(0); //reset the score
                level.stop(); //stop the level
                gameMusic.stop(); //stop the music
                startLevel2(); //start the next level
            }
            else if (level instanceof Level2) {
                level.getTruck().setPoints(0); //reset the score
                level.stop(); //stop the level
                gameMusic.stop(); //stop the music
                startLevel3(); //start the next level
            }
            else if (level instanceof Level3){
                level.getTruck().setPoints(0); //reset the score
                level.stop(); //stop the level
                gameMusic.stop(); //stop the music
                startLevel4(); //start the next level
            }
            else if (level instanceof Level4){
                System.out.println("Well done! Game complete.");
                System.exit(0); //exit when the game is complete
            }
        }

    }

    private void guiStartUp() {
        // create the gui and add it to the frame but set it invisible because it should only display when paused
        if (stateController != null) {
            view.removeKeyListener(stateController); //remove the key listener from the previous state
        }
        if (gui != null) {
            this.getFrame().remove(gui.getMainPanel()); //remove the old gui
        }

        gui = new Gui(level, this, this.getFrame(), this.getView());
        this.getFrame().add(gui.getMainPanel(), BorderLayout.WEST);
        stateController = new StateController(level,this, this.getFrame(), gui);
        view.addKeyListener(stateController);
        gui.getMainPanel().setVisible(false);
    }

    /** Run the game. */
    public static void main(String[] args) {

        new Game();
    }
}
