package game;


import city.cs.engine.SensorEvent;
import city.cs.engine.SensorListener;

public class TruckRightWheelSensor implements SensorListener {

    private Truck truck;





    public TruckRightWheelSensor(Truck truck) {
        this.truck = truck;

    }



    @Override
    public void beginContact(SensorEvent sensorEvent) {
        if (sensorEvent.getContactBody() != null) {
            truck.setRightWheelInContact(true);
        }
    }

    @Override
    public void endContact(SensorEvent sensorEvent) {
        truck.setRightWheelInContact(false);
    }
}
