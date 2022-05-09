package game;


import city.cs.engine.Body;
import city.cs.engine.SensorEvent;
import city.cs.engine.SensorListener;

public class TruckSensor implements SensorListener {

    private Truck truck;
    private GameLevel level;
    private Game game;




    public TruckSensor(Truck truck, GameLevel level, Game game) {
        this.truck = truck;
        this.level = level;
        this.game = game;
    }



    @Override
    public void beginContact(SensorEvent sensorEvent) {
        if (sensorEvent.getContactBody() instanceof Body) {
            truck.setCurrentHealth( truck.getCurrentHealth()-5 );

            if (truck.getCurrentHealth() <= 0) {
                System.out.println("You died!");
                if (game.getLevel().getClass() == Level1.class) {
                    game.getLevel().stop();
                    game.getGameMusic().stop();
                    game.startLevel1();
                }
                else if (game.getLevel().getClass() == Level2.class ) {
                    game.getLevel().stop();
                    game.getGameMusic().stop();
                    game.startLevel2();
                }
                else if (game.getLevel().getClass() == Level3.class) {
                    game.getLevel().stop();
                    game.getGameMusic().stop();
                    game.startLevel3();
                }
            }

            System.out.println(truck.getCurrentHealth());
        }
    }

    @Override
    public void endContact(SensorEvent sensorEvent) {

    }
}
