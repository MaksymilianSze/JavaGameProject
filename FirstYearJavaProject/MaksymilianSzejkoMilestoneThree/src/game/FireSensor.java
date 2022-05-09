package game;


import city.cs.engine.SensorEvent;
import city.cs.engine.SensorListener;

public class FireSensor implements SensorListener {

    private Fire fire;
    private Truck truck;



    public FireSensor(Truck truck,Fire fire) {
        this.truck = truck;
        this.fire = fire;
    }



    @Override
    public void beginContact(SensorEvent sensorEvent) {
        if (sensorEvent.getContactBody() instanceof Truck) {
            truck.setCurrentHealth( truck.getCurrentHealth()-5 );

            System.out.println(truck.getCurrentHealth());
        }
    }

    @Override
    public void endContact(SensorEvent sensorEvent) {

    }
}
