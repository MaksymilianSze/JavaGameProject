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

        g.setFont(new Font("TimesRoman", Font.BOLD, 22));
        g.drawString("Score: " + truck.getPoints(), 10, 22); // draw the score

        g.setColor(Color.RED);
        g.fillRect(110, 4, truck.getMaxHealth() * 2, 20); // draw the total health bar outline in red
        g.setColor(Color.GREEN);
        g.fillRect(110, 4, truck.getCurrentHealth() * 2, 20); // draw the health bar
        g.setColor(Color.BLACK);
        g.drawString("Health: " + truck.getCurrentHealth(), 110, 22); // also draw the health bar text



    }




}
