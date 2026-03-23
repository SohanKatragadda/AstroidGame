package game;

import java.awt.*;
import java.awt.event.*;

public class Ship extends Polygon implements KeyListener {

    private boolean forward;
    private boolean left;
    private boolean right;

    private double speed = 4;

    public Ship(Point position) {
        super(
            new Point[]{
                new Point(0,  -20),
                new Point(-12, 15),
                new Point(0,   8),
                new Point(12,  15)
            },
            position,
            270 // facing up
        );
    }

    public void move() {
        if (left)  rotation -= 5;
        if (right) rotation += 5;
        if (forward) {
            position.x += speed * Math.cos(Math.toRadians(rotation));
            position.y += speed * Math.sin(Math.toRadians(rotation));
        }
        if (position.x < 0) position.x = 800;
        if (position.x > 800) position.x = 0;
        if (position.y < 0) position.y = 600;
        if (position.y > 600) position.y = 0;
    
    
    }


    public void paint(Graphics brush) {

        Point[] points = this.getPoints();
        int[] xCoords = new int[points.length];
        int[] yCoords = new int[points.length];

        for (int i = 0; i < points.length; i++) {
            xCoords[i] = (int) points[i].x;
            yCoords[i] = (int) points[i].y;
        }

        brush.setColor(Color.WHITE);
        brush.drawPolygon(xCoords, yCoords, points.length);
    }

    public boolean collides(Polygon other) {
        for (Point p : other.getPoints()) {
            if (this.contains(p)) return true;
        }
        return false;
        
        
    }

    public void keyPressed(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) forward = true;
        if (e.getKeyCode() == KeyEvent.VK_A) left = true;
        
        if (e.getKeyCode() == KeyEvent.VK_D) right = true;
        
        
        
    }

    public void keyReleased(KeyEvent e) {
        if (e.getKeyCode() == KeyEvent.VK_W) forward = false;
        if (e.getKeyCode() == KeyEvent.VK_A) left = false;
        if (e.getKeyCode() == KeyEvent.VK_D) right = false;
        
        
    }

    public void keyTyped(KeyEvent e) {
    	
    }
}