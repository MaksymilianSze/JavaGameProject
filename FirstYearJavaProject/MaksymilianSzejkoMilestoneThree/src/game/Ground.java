package game;

import city.cs.engine.*;

public class Ground extends StaticBody {


    private static final BodyImage image =
            new BodyImage("data/ground.png", 12f);

    private static final Shape groundShape = new PolygonShape(-30f*1.19f,0f*1.19f, -30f*1.19f,-5f*1.19f, 30f*1.19f,-5f*1.19f, 30f*1.19f,0f*1.19f);


    public Ground(World world) {
        super(world,groundShape);
        addImage(image);
    }
}
