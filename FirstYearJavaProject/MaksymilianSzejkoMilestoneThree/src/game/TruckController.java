package game;

import org.jbox2d.common.Vec2;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;


/**
 * The controls for the truck.
 * @author      Maksymilian Szejko, Maksymilian.Szejko@city.ac.uk
 * @version     3.0
 */
public class TruckController implements KeyListener {

    /**
     * Holds the truck object to apply the movement to
     */
    private Truck truck;

    public TruckController(Truck truck) {
        this.truck = truck;


    }


    @Override
    public void keyTyped(KeyEvent e) {

    }

    /**
     * The truck will respond to a key event.
     * <p>
     * The truck will respond to a key event. The truck has wasd controls and will respond to these by either moving
     * backwards or forwards or by leaning to the left or right.
     *
     * @param  e The key that is pressed is passed into this method.
     *
     */
    @Override
    public void keyPressed(KeyEvent e) {
        // the truck should have basic "wasd" controls, "w" and "s" for forwards and backwards, "a" and "d" for leaning backwards and forwards
        int code = e.getKeyCode();
        //check if wheels are touching a body and check if the truck is going a certain speed in order to set a speed limit
        if ( (truck.getLinearVelocity().x <= 30 && truck.getLinearVelocity().x >= -20)  && (truck.getIsRightWheelInContact() || truck.getIsLeftWheelInContact()) ) {

            if (code == KeyEvent.VK_W) {
                truck.applyForce(new Vec2(200000,0)); // apply a force to go forwards


            } else if (code == KeyEvent.VK_S) {
                truck.applyForce(new Vec2(-200000,0)); // apply a force to go backwards

            }
        }
        //check for angular velocity to set a maximum rotation limit
        if (truck.getAngularVelocity() <= 1) {
            if (code == KeyEvent.VK_A) {
                truck.applyTorque(800000); // apply a torque to lean to the right (clockwise)


            } else if (code == KeyEvent.VK_D) {
                truck.applyTorque(-800000); // apply a torque to lean to the left (anticlockwise)

            }
        }



    }

    @Override
    public void keyReleased(KeyEvent e) {

    }

    public void setTruck(Truck truck) {
        this.truck = truck;
    }
}
