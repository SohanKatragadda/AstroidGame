package game;

import java.awt.Color;
import java.awt.Graphics;

public class Asteroid extends Polygon {

		private double xcord, ycord;
		private double rotationDouble;
		
	  public Asteroid(Point[] shape, Point position, double rotation) {
	        super(shape, position, rotation);
	        double angle = Math.random() * 90 + 45;
	        double speed = Math.random() * 2 + 1;
	        xcord = speed * Math.cos(Math.toRadians(angle));
	        ycord = speed * Math.sin(Math.toRadians(angle));
	        rotationDouble = Math.random() * 4 -2;
	    }
	  
	  public void move()
	  {
		  position.x += xcord;
		  position.y += ycord;
		  rotation += rotationDouble;
		  if(position.x < 0)
		  {
			  position.x = 800;
		  }
		  if(position.x > 800)
		  {
			  position.x = 0;
		  }
		  if(position.y < 0)
		  {
			  position.y = 600;
		  }
		  if(position.y > 600)
		  {
			  position.y = 0;
		  }
	  }

	    public void paint(Graphics brush) {

	        Point[] asteroidPoints = this.getPoints();
	        int[] x = new int[asteroidPoints.length];
	        int[] y = new int[asteroidPoints.length];

	        for(int i=0 ;i< asteroidPoints.length; i++)
	        {
	            x[i] = (int)asteroidPoints[i].x;
	            y[i] = (int)asteroidPoints[i].y;
	        }

	        brush.setColor(Color.WHITE);
	        brush.drawPolygon(x,y,asteroidPoints.length);

	    }
}
