package game;

import java.awt.Graphics;

public class Asteroid extends Polygon {

	  public Asteroid(Point[] shape, Point position, double rotation) {
	        super(shape, position, rotation);
	    }

	    public void paint(Graphics brush) {

	        Point[] asteroidPoints = this.getPoints();
	        int[] x = new int[asteroidPoints.length];
	        int[] y = new int[asteroidPoints.length];

	        for(int i=0 ;i< asteroidPoints.length; i++)
	        {
	           // x[i] = (int)asteroidPoints[i];
	          //  y[i] = (int)asteroidPoints[i];
	        }

	        brush.fillPolygon(x,y,asteroidPoints.length);

	    }
}
