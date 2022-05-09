package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.SoundClip;

public class BrokenCarCollision implements CollisionListener {


    private SoundClip crushSound1;
    private SoundClip crushSound2;




    public BrokenCarCollision(SoundClip crushSound1, SoundClip crushSound2) {

        this.crushSound1 = crushSound1;
        this.crushSound2 = crushSound2;
        crushSound1.setVolume(0.4);
        crushSound2.setVolume(0.4);
    }



    @Override
    public void collide(CollisionEvent collisionEvent) {

        if (collisionEvent.getOtherBody() instanceof Truck) {
            double randomSound = Math.random();
            randomSound = (float) randomSound;
            if (randomSound <= 0.5) {
                crushSound1.play();
            }
            else {
                crushSound2.play();
            }

        }

    }
}
