package game;

import city.cs.engine.*;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


/**
 * The explosive barrel class.
 * @author      Maksymilian Szejko, Maksymilian.Szejko@city.ac.uk
 * @version     1.0
 */
public class ExplosiveBarrel extends DynamicBody {

    private static final Shape hayShape = new PolygonShape(-4.25f/2.5f,0.5f/2.5f, -3.63f/2.5f,-2.94f/2.5f, -2.95f/2.5f,-4.1f/2.5f, 3.09f/2.5f,-4.16f/2.5f, 3.53f/2.5f,-2.84f/2.5f, 4.19f/2.5f,0.34f/2.5f, 3.41f/2.5f,4.4f/2.5f, -3.17f/2.5f,4.46f/2.5f);
    private static SoundClip explosionSound;

    static {
        try {
            explosionSound = new SoundClip("data/explosion.wav");
            System.out.println("Loading explosion sound");
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }
    }

    private static final BodyImage image =
            new BodyImage("data/explosivebarrel.png", 4f); // set the image

    /**
     * Create the barrel.
     * <p>
     * Create the barrel and spawn it.
     * @param world The place where you want to spawn the barrel.
     */
    public ExplosiveBarrel(World world) {
        super(world, hayShape);
        addImage(image);

    }

    /**
     * Destroy the barrel.
     * <p>
     * Destroy the barrel and play its destruction sound.
     *
     */
    @Override
    public void destroy() {
        explosionSound.play();
        super.destroy();
    }

    /**
     * Apply the barrel explosion.
     * <p>
     * Apply the barrel explosion. Apply an impulse in a direction depending on whether the dynamic body is to the
     * left or right.
     * @param bodies The array list of the dynamic bodies to apply the impulse to.
     * @param barrelXPos The current x position of the barrel so that we know how to apply the impulse.
     */
    public void applyExplosion(List<DynamicBody> bodies, float barrelXPos) {
        for (DynamicBody body: bodies) {
            // loop over all the bodies
            if (body.getPosition().x < barrelXPos ) { // if the body is to the left then apply an impulse to the left and if it is to the right then apply it to the right
                body.applyImpulse( new Vec2(-100000,0) );
            }
            else {
                body.applyImpulse( new Vec2(100000,0) );
            }

        }

    }

}
