package game;

import java.awt.Color;
import java.awt.Graphics;

public class Projectile extends Polygon{

	public boolean show = true;
	private double xcord, ycord;
	private static final int Speed = 10;
	
	public Projectile(Point position, double aim)
	{
		super(new Point[] {new Point(0,0), new Point(3,0), new Point(3,6), new Point(0,6)}, new Point(position.x,position.y), aim);
		  xcord = Speed * Math.cos(Math.toRadians(aim));
	      ycord = Speed * Math.sin(Math.toRadians(aim));
	}
	
	public void move()
	{
		position.x += xcord;
		position.y += ycord;
		
		if(position.x < 0 || position.x > 800 || position.y < 0 || position.y > 600)
		{
			show = false;
		}
	}
	

    public void paint(Graphics brush) {

    	brush.setColor(Color.YELLOW);
        Point[] asteroidPoints = this.getPoints();
        int[] x = new int[asteroidPoints.length];
        int[] y = new int[asteroidPoints.length];

        for(int i=0 ;i< asteroidPoints.length; i++)
        {
            x[i] = (int)asteroidPoints[i].x;
            y[i] = (int)asteroidPoints[i].y;
        }
        
        brush.fillPolygon(x,y,asteroidPoints.length);
    }

}
