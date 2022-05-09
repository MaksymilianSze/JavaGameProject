package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class HayCollision implements CollisionListener {

    private Hay hay;
    private Truck truck;
    private GameLevel level;
    private Game game;


    public HayCollision(Hay spawnedHay, Truck spawnedTruck, GameLevel level, Game game) {
        this.hay = spawnedHay;
        this.truck = spawnedTruck;
        this.level = level;
        this.game = game;
    }


    @Override
    public void collide(CollisionEvent collisionEvent) {

        if (collisionEvent.getOtherBody() instanceof Ground) {

        }

    }
}
