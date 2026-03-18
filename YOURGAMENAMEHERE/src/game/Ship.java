package game;

import java.awt.*;


public class Ship extends Polygon {

    public Ship(Point position) {
        super(
            new Point[]{
                new Point(0,  -20),  
                new Point(-12, 15),  
                new Point(0,   8),   
                new Point(12,  15)   
            },
            position, 270  // 270 degrees = pointing up in screen coordinates
        );
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
    
    
    
    
}
