package game;

import city.cs.engine.DynamicBody;
import city.cs.engine.SoundClip;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.io.IOException;
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
    private MyView view;
    private TruckController controller;
    private SoundClip gameMusic;

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

    @Override
    public MyView getView() {
        return view;
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

        //check if the view has been filled yet, this needs to be done because if you load any level from outside one of the other levels then the view will be null
        if (game.getView() == null) {
            view = new MyView(this, 1200,700);
        }
        //add the mouse listener, key listener, set the new truck, add the step listener
        view.setWorld(this);
        view.setBackground(new ImageIcon("data/background2.png").getImage());
        view.addMouseListener(new GiveFocus(view));
        controller = new TruckController( this.getTruck() );
        view.addKeyListener(controller);
        view.setTruck(this.getTruck());
        this.addStepListener(new Tracker(view, this.getHay(), this.getTruck(), this.getBrokenCar() ));

        try {
            gameMusic = new SoundClip("data/Level2Music.wav");   // Open an audio input stream
            gameMusic.loop();  // Set it to continuous playback (looping)
            gameMusic.setVolume(0.2);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

    }

}
