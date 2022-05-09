package game;

import city.cs.engine.BoxShape;
import city.cs.engine.DynamicBody;
import city.cs.engine.StaticBody;
import org.jbox2d.common.Vec2;

import java.util.ArrayList;

public class Level4 extends GameLevel{
    private Truck truck;
    private Hay hay;
    private EndFlag endFlag;
    private Ramp ramp;
    private Coin coin;
    private Coin coin2;
    private Tree tree;
    private Water water;
    private Plank plank;
    private BoxShape platform;
    private ExplosiveBarrel explosiveBarrel;
    private ArrayList<DynamicBody> bodies;


    @Override
    public Truck getTruck() {
        return truck;
    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }

    @Override
    public Hay getHay() {
        return hay;
    }

    public void setHay(Hay hay) {
        this.hay = hay;
    }


    @Override
    public boolean isComplete() {
        if (truck.getPoints() > 0) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String getLevelName() {
        return "Level4";
    }

    @Override
    public void populate(Game game) {
        //make the truck
        truck = new Truck(this);
        //make sensor for taking damage if turned upside down
        TruckSensor damageTop = new TruckSensor(truck, this, game);
        truck.getTruckTop().addSensorListener(damageTop);
        //make sensor to check right wheel is in contact with a body
        TruckRightWheelSensor detectGroundRight = new TruckRightWheelSensor(truck);
        truck.getRightWheelSensor().addSensorListener(detectGroundRight);
        //make a sensor to check if the left wheel is in contact with a body
        TruckLeftWheelSensor detectGroundLeft = new TruckLeftWheelSensor(truck);
        truck.getLeftWheelSensor().addSensorListener(detectGroundLeft);

        plank = new Plank(this);
        plank.setPosition(new Vec2(20,20));
        plank.rotateDegrees(90);
        plank.setAlwaysOutline(true);

        bodies = new ArrayList<DynamicBody>();
        bodies.add(truck);
        bodies.add(plank);

        explosiveBarrel = new ExplosiveBarrel(this);
        explosiveBarrel.setPosition(new Vec2(11,5));
        ExplosiveBarrelCollision barrel = new ExplosiveBarrelCollision(explosiveBarrel, bodies, this, game);
        explosiveBarrel.addCollisionListener(barrel);
        explosiveBarrel.setAlwaysOutline(true);

        //make coins
        coin = new Coin(this);
        coin.setPosition(new Vec2(2,4));
        CoinSensor pickup = new CoinSensor(truck, coin);
        coin.getCoin().addSensorListener(pickup);

        coin2 = new Coin(this);
        coin2.setPosition(new Vec2(50,-4));
        CoinSensor pickup2 = new CoinSensor(truck, coin2);
        coin2.getCoin().addSensorListener(pickup2);

        // make the truck
        truck.setPosition(new Vec2(-60,-8));
        truck.setGravityScale(1.2f);
        truck.setAlwaysOutline(true);

    }

    public Level4(Game game){
        super(game);




        water = new Water(this);
        water.setPosition(new Vec2(66.1f,-7f));
        water.setAlwaysOutline(true);

        populate(game);


        tree = new Tree(this);
        tree.setPosition(new Vec2 (-100,-3));
        tree.setAlwaysOutline(true);

        tree = new Tree(this);
        tree.setPosition(new Vec2 (200,-3));
        tree.setAlwaysOutline(true);

        //make ramp
        ramp = new Ramp(this);
        ramp.setPosition(new Vec2(-25,-8));
        ramp.setAlwaysOutline(true);

        platform = new BoxShape(5,0.5f);
        StaticBody bombHolder = new StaticBody(this, platform);
        bombHolder.setPosition(new Vec2(10, 2));




        //make end flag
        endFlag = new EndFlag(this);
        endFlag.setPosition(new Vec2(160,-8.5f));
        EndFlagSensor flag = new EndFlagSensor(game);
        endFlag.getEndSensor().addSensorListener(flag);
        endFlag.setAlwaysOutline(true);




        // make the ground
        for (int i = 1; i < 100; i += 50) {
            Ground ground = new Ground(this);
            ground.setPosition(new Vec2(-70+i, -13f));
            ground.setAlwaysOutline(true);
        }

        for (int i = 1; i < 100; i += 50) {
            Ground ground = new Ground(this);
            ground.setPosition(new Vec2(30+i, -16f));
            ground.setAlwaysOutline(true);
        }

        for (int i = 1; i < 100; i += 50) {
            Ground ground = new Ground(this);
            ground.setPosition(new Vec2(150+i, -13f));
            ground.setAlwaysOutline(true);
        }




    }

}
