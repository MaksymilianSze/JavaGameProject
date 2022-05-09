package game;

import city.cs.engine.*;

public class Ramp extends StaticBody {

    private static final Shape rampShape = new PolygonShape(-11f,-5f, 8.5f,5f, 11f,-5f);

    private static final BodyImage image =
            new BodyImage("data/ramp.png", 10f); // set image for the rock


    public Ramp(World world) {
        super(world, rampShape);
        addImage(image);

    }

}

