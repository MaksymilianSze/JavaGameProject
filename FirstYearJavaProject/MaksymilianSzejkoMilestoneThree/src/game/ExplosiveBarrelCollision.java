package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;
import city.cs.engine.DynamicBody;

import java.util.ArrayList;
import java.util.List;

/**
 * The explosive barrel collision class.
 * @author      Maksymilian Szejko, Maksymilian.Szejko@city.ac.uk
 * @version     1.0
 */
public class ExplosiveBarrelCollision implements CollisionListener {

    private ExplosiveBarrel explosiveBarrel;

    /**
     * Holds all the bodies that will be used for collision.
     */
    private List collisionBodies;


    public ExplosiveBarrelCollision(ExplosiveBarrel explosiveBarrel, List<DynamicBody> bodies, GameLevel level, Game game) {
        this.explosiveBarrel = explosiveBarrel;
        this.collisionBodies = bodies;
    }


    /**
     * Detects a collision event and calls the the explosion method.
     * <p>
     * Detects a collision event and calls the the explosion method. This will get the x position of the barrel and pass
     * it into the apply explosion method. It is used for when a dynamic body touches the barrel so that a realistic
     * explosion can be made.
     *
     * @param  collisionEvent The collision event
     */
    @Override
    public void collide(CollisionEvent collisionEvent) {

        if (collisionEvent.getOtherBody() instanceof DynamicBody) {
            // if the body that is in contact with the barrel is a dynamic body then apply the explosion and destroy the barrel
            explosiveBarrel.applyExplosion(collisionBodies, explosiveBarrel.getPosition().x);
            explosiveBarrel.destroy();
        }

    }
}
