package game;

import org.jbox2d.common.Vec2;

public class Level3  extends GameLevel{
    private Truck truck;
    private Hay hay;
    private Rock rock;
    private EndFlag endFlag;
    private BrokenCar brokenCar;
    private Ramp ramp;
    private Fire fire;
    private Coin coin;
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
    public Rock getRock() {
        return rock;
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
        return "Level3";
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

        //make coins
        coin = new Coin(this);
        coin.setPosition(new Vec2(140,-5));
        CoinSensor pickup = new CoinSensor(truck, coin);
        coin.getCoin().addSensorListener(pickup);
        coin.setAlwaysOutline(true);

        //loops for making obstacles
        for (int i = 1; i < 30; i += 5) {
            brokenCar = new BrokenCar(this);
            brokenCar.setPosition(new Vec2(-10+i*2,-12));
            BrokenCarCollision destruction = new BrokenCarCollision(BrokenCar.getCrushSound1(), BrokenCar.getCrushSound2());
            brokenCar.addCollisionListener(destruction);
            brokenCar.setAlwaysOutline(true);
        }

        for (int i = 1; i < 30; i += 5) {
            brokenCar = new BrokenCar(this);
            brokenCar.setPosition(new Vec2(-10+i*2,-6));
            BrokenCarCollision destruction = new BrokenCarCollision(BrokenCar.getCrushSound1(), BrokenCar.getCrushSound2());
            brokenCar.addCollisionListener(destruction);
            brokenCar.setAlwaysOutline(true);
        }

        // make the truck
        truck.setPosition(new Vec2(-60,-8));
        truck.setGravityScale(1.2f);
        truck.setAlwaysOutline(true);
    }

    public Level3(Game game){
        super(game);


        populate(game);

        tree = new Tree(this);
        tree.setPosition(new Vec2 (-88,-3));
        tree.setAlwaysOutline(true);

        tree = new Tree(this);
        tree.setPosition(new Vec2 (180,-3));
        tree.setAlwaysOutline(true);


        //make end flag
        endFlag = new EndFlag(this);
        endFlag.setPosition(new Vec2(150,-8.5f));
        EndFlagSensor flag = new EndFlagSensor(game);
        endFlag.getEndSensor().addSensorListener(flag);
        endFlag.setAlwaysOutline(true);

        //make ramp
        ramp = new Ramp(this);
        ramp.setPosition(new Vec2(-40,-8));
        ramp.setAlwaysOutline(true);

        //loop for making fire
        for (int i = 0; i < 45; i += 15) {
            fire = new Fire(this);
            FireSensor damage = new FireSensor(truck, fire);
            fire.getFireSensor().addSensorListener(damage);
            fire.setPosition(new Vec2(0+i,-1));
            fire.setAlwaysOutline(true);
        }


        // make the ground
        for (int i = 1; i < 300; i += 50) {
            Ground ground = new Ground(this);
            ground.setPosition(new Vec2(-70+i, -13f));
            ground.setAlwaysOutline(true);
        }




    }

}
