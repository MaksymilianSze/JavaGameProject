package game;

import city.cs.engine.*;

public class EndFlag extends StaticBody {


    private static final Shape flagShape = new PolygonShape(-3.22f,3.46f, 2.98f,3.42f, 3.0f,-0.38f, -2.8f,-4.3f, -3.2f,-4.3f);
    Sensor endSensor = new Sensor(this, flagShape,20);

    public Sensor getEndSensor() {
        return endSensor;
    }

    private static final BodyImage image =
            new BodyImage("data/endflag.png", 10f);

    public EndFlag(World world) {
        super(world);
        addImage(image);

    }
}
