package game;

import city.cs.engine.*;

public class Tree extends StaticBody {

    private static final Shape treeShape = new PolygonShape(-4.86f*2f,1.16f*2f, -0.78f*2f,-4.82f*2f, 0.84f*2f,-4.72f*2f, 4.82f*2f,1.54f*2f, -0.14f*2f,5.0f*2f);

    private static final BodyImage image =
            new BodyImage("data/tree.png", 20f); // set image for the rock


    public Tree(World world) {
        super(world, treeShape);
        addImage(image);

    }

}

