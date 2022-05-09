package game;


import city.cs.engine.SensorEvent;
import city.cs.engine.SensorListener;

public class TruckLeftWheelSensor implements SensorListener {

    private Truck truck;





    public TruckLeftWheelSensor(Truck truck) {
        this.truck = truck;

    }



    @Override
    public void beginContact(SensorEvent sensorEvent) {
        if (sensorEvent.getContactBody() != null) {
            truck.setLeftWheelInContact(true);
        }
    }

    @Override
    public void endContact(SensorEvent sensorEvent) {
        truck.setLeftWheelInContact(false);
    }
}
