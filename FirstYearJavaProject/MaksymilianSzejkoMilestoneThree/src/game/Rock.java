package game;

import city.cs.engine.*;

public class Rock extends StaticBody {

    private static final Shape rockShape = new PolygonShape(0.95f/2.5f,4.96f/2.5f, -5.24f/2.5f,0.69f/2.5f, -4.6f/2.5f,-4.46f/2.5f, 1.46f/2.5f,-4.75f/2.5f, 5.39f/2.5f,-1.77f/2.5f, 4.67f/2.5f,2.9f/2.5f);

    private static final BodyImage image =
            new BodyImage("data/rock.png", 4f); // set image for the rock


    public Rock(World world) {
        super(world, rockShape);
        addImage(image);

    }

}

