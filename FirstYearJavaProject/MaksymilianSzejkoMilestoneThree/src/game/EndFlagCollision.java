package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class EndFlagCollision implements CollisionListener {

    private Truck truck;
    private GameLevel level;
    private Game game;



    public EndFlagCollision(Truck spawnedTruck, GameLevel level, Game game) {
        this.truck = spawnedTruck;
        this.level = level;
        this.game = game;
    }


    @Override
    public void collide(CollisionEvent collisionEvent) {

        if (collisionEvent.getOtherBody() instanceof Truck) {

            game.goToNextLevel();
        }



    }
}
