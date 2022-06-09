package game;

import city.cs.engine.DynamicBody;
import org.jbox2d.common.Vec2;

import java.util.ArrayList;
import java.util.List;

public class Level2  extends GameLevel{
    private Truck truck;
    private Hay hay;
    private Coin coin;
    private Coin coin2;
    private BrokenCar brokenCar;
    private EndFlag endFlag;
    private ExplosiveBarrel explosiveBarrel;
    private List<DynamicBody> bodies;
    private Tree tree;

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
        System.out.println(truck.getPoints());
        if (truck.getPoints() > 0) {
            return true;
        }
        else {
            return false;
        }
    }
    @Override
    public String getLevelName() {
        return "Level2";
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

        explosiveBarrel = new ExplosiveBarrel(this);

        //make coins
        coin = new Coin(this);
        coin.setPosition(new Vec2(24,4));
        CoinSensor pickup = new CoinSensor(truck, coin);
        coin.getCoin().addSensorListener(pickup);


        coin2 = new Coin(this);
        coin2.setPosition(new Vec2(4,-4));
        CoinSensor pickup2 = new CoinSensor(truck, coin2);
        coin2.getCoin().addSensorListener(pickup2);


        //loops for some obstacles
        for (int i = 1; i < 15; i += 5) {
            brokenCar = new BrokenCar(this);
            brokenCar.setPosition(new Vec2(-10+i*2,-12));
            BrokenCarCollision destruction = new BrokenCarCollision(BrokenCar.getCrushSound1(), BrokenCar.getCrushSound2());
            brokenCar.addCollisionListener(destruction);
        }

        for (int i = 1; i < 15; i += 5) {
            brokenCar = new BrokenCar(this);
            brokenCar.setPosition(new Vec2(-10+i*2,-6));
            BrokenCarCollision destruction = new BrokenCarCollision(BrokenCar.getCrushSound1(), BrokenCar.getCrushSound2());
            brokenCar.addCollisionListener(destruction);
        }


        for (int i = 0; i < 3; i++) {
            hay = new Hay(this);
            hay.setPosition(new Vec2(-30+i,-8));
        }

        for (int i = 0; i < 3; i++) {
            hay = new Hay(this);
            hay.setPosition(new Vec2(-30+i,-4));
        }

        // set truck position
        truck.setPosition(new Vec2(-55,-8));
        truck.setGravityScale(1.2f);



        // make a collection for the explosion mechanics
        bodies = this.getDynamicBodies();

        //make explosive barrel
        explosiveBarrel.setPosition(new Vec2(-20,-8));
        ExplosiveBarrelCollision barrel = new ExplosiveBarrelCollision(explosiveBarrel, bodies, this, game);
        explosiveBarrel.addCollisionListener(barrel);
    }

    public Level2(Game game){
        super(game);

        populate(game);

        tree = new Tree(this);
        tree.setPosition(new Vec2 (-88,-3));

        tree = new Tree(this);
        tree.setPosition(new Vec2 (80,-3));


        //make end flag
        endFlag = new EndFlag(this);
        endFlag.setPosition(new Vec2(40,-8.5f));
        EndFlagSensor flag = new EndFlagSensor(game);
        endFlag.getEndSensor().addSensorListener(flag);



        // make the ground
        for (int i = 1; i < 200; i += 50) {
            Ground ground = new Ground(this);
            ground.setPosition(new Vec2(-70+i, -13f));
        }



    }

}
