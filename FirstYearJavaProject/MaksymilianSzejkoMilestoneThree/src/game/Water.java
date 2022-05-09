package game;

import city.cs.engine.*;

public class Water extends StaticBody {

    private static final Shape waterShape = new PolygonShape(-24f*2.1f,-5f*2.1f, 24.f*2.1f,-5f*2.1f, 24f*2.1f,-4f*2.1f, -24f*2.1f,-4f*2.1f);
    SolidFixture waterFixture = new SolidFixture(this, waterShape, 20);
    Sensor waterSensor = new Sensor(this, waterShape, 20);


    public Sensor getWaterSensor() {
        return waterSensor;
    }

    private static final BodyImage image =
            new BodyImage("data/water.gif", 20.3f); // set image for the rock


    public Water(World world) {
        super(world);
        //high friction so the truck moves slowly in the water
        waterFixture.setFriction(5);
        addImage(image);

    }

}
