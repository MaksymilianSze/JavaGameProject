package game;

import city.cs.engine.*;

public class Fire extends StaticBody {

    private static final Shape fireShape = new PolygonShape(-9f,-4f, 9f,-4f, 9f,-4.1f, -9f,-4.1f);
    Sensor fireSensor = new Sensor(this, fireShape, 20);
    //GhostlyFixture fire = new GhostlyFixture(this, fireShape);


    public Sensor getFireSensor() {
        return fireSensor;
    }

    private static final BodyImage image =
            new BodyImage("data/fire.gif", 10f); // set image for the rock


    public Fire(World world) {
        super(world);
        addImage(image);

    }

}
