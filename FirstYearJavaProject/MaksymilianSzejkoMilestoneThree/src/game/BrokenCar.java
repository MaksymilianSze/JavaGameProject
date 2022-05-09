package game;

import city.cs.engine.*;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;

public class BrokenCar extends DynamicBody {

    private static final Shape brokencarShape = new PolygonShape(-10.32f/2f,-4.52f/2f, 10.1f/2f,-4.43f/2f, 10.23f/2f,-0.54f/2f, 6.66f/2f,2.41f/2f, -2.82f/2f,2.45f/2f, -8.94f/2f,-0.18f/2f);
    private SolidFixture carFixture = new SolidFixture(this, brokencarShape, 50);

    private static final BodyImage image = new BodyImage("data/brokencar.png", 6f);

    private static SoundClip crushSound1;
    private static SoundClip crushSound2;

    public static SoundClip getCrushSound1() {
        return crushSound1;
    }

    public static SoundClip getCrushSound2() {
        return crushSound2;
    }

    static {
        try {
            crushSound1 = new SoundClip("data/carcrush1.wav");
            System.out.println("Loading carcrush1 sound");
            crushSound2 = new SoundClip("data/carcrush2.wav");
            System.out.println("Loading carcrush2 sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    public BrokenCar(World world) {
        super(world,brokencarShape);
        addImage(image);
    }
}
