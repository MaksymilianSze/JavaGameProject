package game;

import city.cs.engine.UserView;
import city.cs.engine.World;

import javax.swing.*;
import java.awt.*;

public class MyView extends UserView {
    private Image background;
    private Truck truck;
    private GameLevel level;

    public void setTruck(Truck truck) {
        this.truck = truck;
    }

    public void setLevel(GameLevel level) {
        this.level = level;
    }

    public void setBackground(Image background) {
        this.background = background;
    }

    public MyView(World w, int width, int height) {
        super(w, width, height);
        background = new ImageIcon("data/background1.png").getImage(); // set the background image



    }

    @Override
    protected void paintBackground(Graphics2D g) {
        g.drawImage(background, 0, 0, this); // draw the background image

    }

    @Override
    protected void paintForeground(Graphics2D g) {


        g.drawString("Score: " + truck.getPoints(), 10, 20);
        g.drawString("Health: " + truck.getCurrentHealth(), 80, 20);

    }




}
