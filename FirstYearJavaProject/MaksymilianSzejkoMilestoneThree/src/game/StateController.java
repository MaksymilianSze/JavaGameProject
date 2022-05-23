package game;

import javax.swing.*;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

public class StateController implements KeyListener {

    private PauseAction pause;

    public StateController(GameLevel level, Game game, JFrame frame, Gui gui) {
        this.pause = new PauseAction(level, game, frame, gui);
    }

    @Override
    public void keyTyped(KeyEvent e) {

    }

    @Override
    public void keyPressed(KeyEvent e) {
        if (e.getKeyChar() == KeyEvent.VK_ESCAPE) {
            pause.actionPerformed(null);
        }
    }

    @Override
    public void keyReleased(KeyEvent e) {

    }
}
