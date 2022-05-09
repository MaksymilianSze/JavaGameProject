package game;

import city.cs.engine.StepEvent;
import city.cs.engine.StepListener;
import org.jbox2d.common.Vec2;

public class Tracker implements StepListener {
    private MyView view;
    private Hay hay;
    private Truck truck;
    private BrokenCar brokenCar;
    public Tracker(MyView view, Hay hay, Truck truck, BrokenCar brokenCar) {
        this.view = view;
        this.hay = hay;
        this.truck = truck;
        this.brokenCar = brokenCar;
    }
    public void preStep(StepEvent e) {}
    public void postStep(StepEvent e) {
        view.setCentre(new Vec2(truck.getPosition().x, truck.getPosition().y + 8 ));
        //brokenCar.applyImpulse(new Vec2(0,-1000));


    }
}