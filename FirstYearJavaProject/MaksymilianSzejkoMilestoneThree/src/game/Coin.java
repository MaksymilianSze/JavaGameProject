package game;

import city.cs.engine.*;

public class Coin extends StaticBody {

    private static final Shape coinShape = new PolygonShape(-1.24f/2.5f,3.4f/2.5f, -3.4f/2.5f,1.22f/2.5f, -3.4f/2.5f,-0.88f/2.5f, -1.22f/2.5f,-3.1f/2.5f, 0.92f/2.5f,-3.08f/2.5f, 3.08f/2.5f,-0.88f/2.5f, 3.1f/2.5f,1.26f/2.5f, 0.9f/2.5f,3.44f/2.5f);
    Sensor coinSensor = new Sensor(this, coinShape,20);

    public Sensor getCoin() {
        return coinSensor;
    }

    private static final BodyImage image =
            new BodyImage("data/coin.png", 4f); // set hay image


    public Coin(World world) {
        super(world);
        addImage(image);
    }

}
