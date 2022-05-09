package game;


import city.cs.engine.SensorEvent;
import city.cs.engine.SensorListener;

public class EndFlagSensor implements SensorListener {


    private Game game;



    public EndFlagSensor(Game game) {
        this.game = game;

    }



    @Override
    public void beginContact(SensorEvent sensorEvent) {

        if (sensorEvent.getContactBody() instanceof Truck) {
            game.goToNextLevel();

        }
    }

    @Override
    public void endContact(SensorEvent sensorEvent) {

    }
}
