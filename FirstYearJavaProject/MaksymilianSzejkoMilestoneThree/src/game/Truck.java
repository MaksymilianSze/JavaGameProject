package game;

import city.cs.engine.*;
/**
 * The truck and all of it's components.
 * @author      Maksymilian Szejko, Maksymilian.Szejko@city.ac.uk
 * @version     3.0
 */
public class Truck extends DynamicBody {

    // because the truck is a concave shape we need to make many convex shapes and combine them together


    private static final Shape truckLeftWheel = new CircleShape(3f, -5.8f,-2);
    SolidFixture leftWheel = new SolidFixture(this, truckLeftWheel, 20);
    /**
     * Make the sensor for the left wheel for detecting whether it is touching something
     */
    Sensor leftWheelSensor = new Sensor(this, truckLeftWheel, 30);

    private static final Shape truckRightWheel = new CircleShape(3f, 6.8f,-2);
    SolidFixture rightWheel = new SolidFixture(this, truckRightWheel, 20);
    /**
     * Make the sensor for the right wheel for detecting whether it is touching something
     */
    Sensor rightWheelSensor = new Sensor(this, truckRightWheel, 30);

    private static final Shape truckHull = new PolygonShape(-7.05f*1.4f,2.83f*1.4f, -6.74f*1.4f,0.81f*1.4f, 6.83f*1.4f,0.72f*1.4f, 5.79f*1.4f,2.89f*1.4f);
    SolidFixture hull = new SolidFixture(this, truckHull, 5);

    private static final Shape truckTop = new PolygonShape(-3.68f*1.4f,2.89f*1.4f, -1.35f*1.4f,4.34f*1.4f, 1.23f*1.4f,4.31f*1.4f, 3.4f*1.4f,2.86f*1.4f);
    SolidFixture topSolid = new SolidFixture(this, truckTop, 5);
    Sensor topSensor = new Sensor(this, truckTop, 20);


    private static final BodyImage image = new BodyImage("data/truck.png", 14f); // set the image for the truck


    private int points;

    private int currentHealth;

    private final int maxHealth;

    private boolean isRightWheelInContact = true;
    private boolean isLeftWheelInContact = true;

    public int getCurrentHealth() {
        return this.currentHealth;
    }

    public int getMaxHealth() {
        return maxHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    public boolean getIsRightWheelInContact() {
        return isRightWheelInContact;
    }

    public void setRightWheelInContact(boolean wheelInContact) {
        isRightWheelInContact = wheelInContact;
    }

    public boolean getIsLeftWheelInContact() {
        return isLeftWheelInContact;
    }

    public void setLeftWheelInContact(boolean wheelInContact) {
        isLeftWheelInContact = wheelInContact;
    }

    public void takeDamage() {
        currentHealth -= 10;
    }

    public int getPoints() {
        return points;
    }

    public void setPoints(int points) {
        this.points = points;
    }

    public Sensor getTruckTop() {
        return topSensor;
    }

    public Sensor getLeftWheelSensor() {
        return leftWheelSensor;
    }

    public Sensor getRightWheelSensor() {
        return rightWheelSensor;
    }


    /**
     * Create the truck.
     * <p>
     * Create the truck's fixtures, add the sensors and hitbox.
     * @param world The place where you want to spawn the truck.
     */
    public Truck(World world) {
        super(world);
        addImage(image);
        maxHealth = 100;
        currentHealth = 100;
    }
}


