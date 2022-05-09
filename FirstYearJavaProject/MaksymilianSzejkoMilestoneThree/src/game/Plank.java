package game;

import city.cs.engine.*;

public class Plank extends DynamicBody {

    private static final Shape plankShape = new PolygonShape(-42f*1f,3f*1f, 42f*1f,3.3f*1f, 42f*1f,-3f*1f, -42f*1f,-3f*1f);
    SolidFixture plankFixture = new SolidFixture(this, plankShape, 20);

    private static final BodyImage image = new BodyImage("data/plank.png", 10f);



    public Plank(World world) {
        super(world,plankShape);
        addImage(image);
    }
}
