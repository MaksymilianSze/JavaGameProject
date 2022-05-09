package game;

import city.cs.engine.*;

public class Hay extends DynamicBody {

    private static final Shape hayShape = new PolygonShape(-3.81f/2.5f,-3.18f/2.5f, 2.77f/2.5f,-3.44f/2.5f, 2.99f/2.5f,3.56f/2.5f,-3.79f/2.5f,3.8f/2.5f);

    private boolean touchedGround;

    public boolean isTouchedGround() {
        return touchedGround;
    }

    public void setTouchedGround(boolean touchedGround) {

        this.touchedGround = touchedGround;
    }

    private static final BodyImage image =
            new BodyImage("data/hay.png", 4f); // set hay image


    public Hay(World world) {
        super(world, hayShape);
        addImage(image);
        touchedGround = false;
    }

}
