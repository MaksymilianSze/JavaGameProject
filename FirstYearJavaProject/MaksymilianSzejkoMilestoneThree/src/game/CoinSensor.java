package game;


import city.cs.engine.SensorEvent;
import city.cs.engine.SensorListener;

public class CoinSensor implements SensorListener {


    private Truck truck;
    private Coin coin;



    public CoinSensor(Truck truck, Coin coin) {
        this.truck = truck;
        this.coin = coin;
    }



    @Override
    public void beginContact(SensorEvent sensorEvent) {
        System.out.println("test");
        if (sensorEvent.getContactBody() instanceof Truck) {
            coin.destroy();
            truck.setPoints( truck.getPoints()+1 );
            System.out.println("Coin collected");
            System.out.println("You now have: " + truck.getPoints() + " points");

        }
    }

    @Override
    public void endContact(SensorEvent sensorEvent) {

    }
}
