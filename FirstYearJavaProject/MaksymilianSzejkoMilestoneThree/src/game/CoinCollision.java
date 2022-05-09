package game;

import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class CoinCollision implements CollisionListener {

    private Truck truck;
    private GameLevel level;
    private Game game;
    private Coin coin;



    public CoinCollision(Truck spawnedTruck, Coin coin, GameLevel level, Game game) {
        this.truck = spawnedTruck;
        this.level = level;
        this.game = game;
        this.coin = coin;
    }


    // collision for the hay, when the hay touches the ground the player loses a point and the hay is destroyed
    @Override
    public void collide(CollisionEvent collisionEvent) {

        if (collisionEvent.getOtherBody() instanceof Truck) {
            coin.destroy();
            truck.setPoints( truck.getPoints()+1 );
            System.out.println("Coin collected");
            System.out.println("You now have: " + truck.getPoints() + " points");

        }

    }
}
