package game;

import city.cs.engine.DynamicBody;
import city.cs.engine.SoundClip;
import city.cs.engine.World;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.List;

public abstract class GameLevel extends World {
    private Truck truck;
    private Hay hay;
    private Rock rock;
    private Coin coin;
    private BrokenCar brokenCar;
    private static SoundClip engineIdle;

    public GameLevel(Game game){


        try {
            engineIdle = new SoundClip("data/truckidle.wav");   // Open an audio input stream
            engineIdle.loop();  // Set it to continous playback (looping)
            engineIdle.setVolume(0.1);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }



    }




    public static SoundClip getEngineIdle() {
        return engineIdle;
    }

    public Truck getTruck() {
        return truck;
    }

    public Hay getHay() {
        return hay;
    }

    public Rock getRock() {
        return rock;
    }

    public Coin getCoin() {
        return coin;
    }

    public BrokenCar getBrokenCar() {
        return brokenCar;
    }

    public abstract boolean isComplete();

    public abstract String getLevelName();

    public abstract void populate(Game game);

//    public static List<DynamicBody> getAllDynamicBodies(GameLevel level) {
//        return ;
//    }
}


