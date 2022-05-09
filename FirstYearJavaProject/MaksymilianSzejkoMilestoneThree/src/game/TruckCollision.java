package game;


import city.cs.engine.Body;
import city.cs.engine.CollisionEvent;
import city.cs.engine.CollisionListener;

public class TruckCollision implements CollisionListener {

    private Truck truck;



    public TruckCollision(Truck truck) {
        this.truck = truck;
    }

    @Override
    public void collide(CollisionEvent collisionEvent) {
        if (collisionEvent.getOtherBody() instanceof Body) {
            truck.setCurrentHealth( truck.getCurrentHealth()-5 );

        }
    }
}
