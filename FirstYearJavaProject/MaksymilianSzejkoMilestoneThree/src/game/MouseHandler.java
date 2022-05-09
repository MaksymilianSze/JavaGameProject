//package game;
//
//import city.cs.engine.*;
//
//import java.awt.event.MouseAdapter;
//import java.awt.event.MouseEvent;
//
//public class MouseHandler extends MouseAdapter {
//
//    private static final float RADIUS = 1f;
//
//    private static final Shape ballShape
//            = new CircleShape(RADIUS);
//
//    private static final BodyImage ballImage
//            = new BodyImage("data/books.png", 2*RADIUS);
//
//    private WorldView view;
//
//    public MouseHandler(WorldView view) {
//        this.view = view;
//    }
//
//    /**
//     * Create a bowling ball at the current mouse position.
//     * @param e event object containing the mouse position
//     */
//    public void mousePressed(MouseEvent e) {
//        DynamicBody ball = new DynamicBody(view.getWorld(), ballShape);
//        ball.setPosition(view.viewToWorld(e.getPoint()));
//        ball.addImage(ballImage);
//    }
//}
