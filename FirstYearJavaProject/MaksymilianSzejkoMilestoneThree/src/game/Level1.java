package game;


import city.cs.engine.SoundClip;
import org.jbox2d.common.Vec2;

import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;

public class Level1 extends GameLevel implements ActionListener {
    private Truck truck;
    private Hay hay;
    private Rock rock;
    private Coin coin;
    private Coin coin2;
    private EndFlag endFlag;
    private BrokenCar brokenCar;
    private Tree tree;
    private SoundClip gameMusic;


    private MyView view;
    private TruckController controller;



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
    public Coin getCoin() {
        return coin;
    }

    @Override
    public BrokenCar getBrokenCar() {
        return brokenCar;
    }

    @Override
    public boolean isComplete() {
        if (truck.getPoints() > 1) {
            return true;
        }
        else {
            return false;
        }
    }

    @Override
    public String getLevelName() {
        return "Level1";
    }


    @Override
    public void actionPerformed(ActionEvent e) {
        System.out.println("Action event!");
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

        //make the coins
        coin = new Coin(this);
        coin.setPosition(new Vec2(24,-2));
        CoinSensor pickup = new CoinSensor(truck, coin); //attach sensors
        coin.getCoin().addSensorListener(pickup);

        coin2 = new Coin(this);
        coin2.setPosition(new Vec2(4,-8));
        CoinSensor pickup2 = new CoinSensor(truck, coin2); //attach sensors
        coin2.getCoin().addSensorListener(pickup2);

        //make broken cars
        for (int i = 1; i < 15; i += 5) {
            brokenCar = new BrokenCar(this);
            brokenCar.setPosition(new Vec2(-15+i*2,-12));
            BrokenCarCollision destruction = new BrokenCarCollision(BrokenCar.getCrushSound1(), BrokenCar.getCrushSound2());
            brokenCar.addCollisionListener(destruction);
        }

        // set truck position
        truck.setPosition(new Vec2(-30,-8));
        truck.setGravityScale(1.2f);



    }

    @Override
    public MyView getView() {
        return view;
    }

    public Level1(Game game){

        super(game);



        populate(game);

        tree = new Tree(this);
        tree.setPosition(new Vec2 (-65,-3));

        tree = new Tree(this);
        tree.setPosition(new Vec2 (70,-3));


        //make end flag
        endFlag = new EndFlag(this);
        endFlag.setPosition(new Vec2(50,-8.5f));
        EndFlagSensor flag = new EndFlagSensor(game);
        endFlag.getEndSensor().addSensorListener(flag);


        // loop for making some rock obstacles
        for (int i = 0; i < 3; i++) {
            Rock rock = new Rock(this);
            rock.setPosition(new Vec2(25-i*5,-10));
        }

        for (int i = 0; i < 1; i++) {
            Rock rock = new Rock(this);
            rock.setPosition(new Vec2(25-i*5,-6));
        }


        // make the ground
        for (int i = 1; i < 200; i += 50) {
            Ground ground = new Ground(this);
            ground.setPosition(new Vec2(-50+i, -13f));
        }

        //check if the view has been filled yet, this needs to be done because if you load any level from outside one of the other levels then the view will be null
        if (game.getView() == null) {
            view = new MyView(this, 1200,700);
        }
        //add the mouse listener, key listener, set the new truck, add the step listener
        view.setWorld(this);
        view.setBackground(new ImageIcon("data/background1.png").getImage());
        view.addMouseListener(new GiveFocus(view));
        controller = new TruckController( this.getTruck() );
        view.addKeyListener(controller);
        view.setTruck(this.getTruck());
        this.addStepListener(new Tracker(view, this.getHay(), this.getTruck(), this.getBrokenCar() ));

        try {
            gameMusic = new SoundClip("data/Level1Music.wav");   // Open an audio input stream
            gameMusic.loop();  // Set it to continuous playback (looping)
            gameMusic.setVolume(0.2);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            System.out.println(e);
        }

    }

}
