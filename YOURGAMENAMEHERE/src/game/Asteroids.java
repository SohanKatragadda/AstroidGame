package game;

/*
CLASS: YourGameNameoids
DESCRIPTION: Extending Game, Asteroids is all in the paint method.
NOTE: This class is the metaphorical "main method" of your program,
      it is your control center.

*/
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

class Asteroids extends Game {
	static int counter = 0;


    private Ship ship;
    private AsteroidField field;
    private ScoreBoard score;
    private ArrayList<Projectile> p = new ArrayList<>();
     private boolean gameOver = false;
     
     private class ScoreBoard
     {
    	 int score = 0;
    	 int lives = 3;
    	 void addPoints(int p)
    	 {
    		 score += p;
    	 }
    	 void loseLife()
    	 {
    		 lives--;
    	 }
    	 boolean isGameOver()
    	 {
    		 return lives <=0;
    	 }
    	 void Paint(Graphics brush)
    	 {
    		 brush.setColor(Color.WHITE);
    		 brush.setFont(new Font("Arial",Font.BOLD,16));
    		 brush.drawString("Score: "+score,10,20);
    		 brush.drawString("Lives: "+lives,10,40);
    	 }
     }
     
     private class AsteroidField
     {
    	 Asteroid[] a;
    	 AsteroidField(int count)
    	 {
    		 a = new Asteroid[count];
    		 for(int i=0;i<count;i++)
    		 {
    			 Point[] s = {
    					
    					 new Point(0,20), new Point(10,35),
    					 new Point(30,40), new Point(40,25),
    					 new Point(35,5),  new Point(20,0)
    				 };
    			 a[i] = new Asteroid(s, new Point(Math.random()*700+50, Math.random()*500+50),Math.random()*360);
    		 }
    	 }
    	 
    	 public boolean destroy()
    	 {
    		 for(Asteroid i : a)
    		 {
    			 if(i != null)
    			 {
    				 return false;
    			 }
    		 }
    		 return true;
    	 }
     }
  public Asteroids() {
    super("Asteroids!",800,600);
    ship = new Ship(new Point(400,300));
    field = new AsteroidField(6);
    score = new ScoreBoard();
    this.addKeyListener((KeyListener) ship);
    this.setFocusable(true);
	this.requestFocus();
  }
  
	public void paint(Graphics brush) {
    	brush.setColor(Color.black);
    	brush.fillRect(0,0,width,height);
    	
    	// sample code for printing message for debugging
    	// counter is incremented and this message printed
    	// each time the canvas is repainted
    	
    	
    	if(gameOver)
    	{
    		brush.setColor(Color.CYAN);
    		brush.setFont(new Font("Arial",Font.BOLD,32));
    		brush.drawString("GAME OVER",310, 280);
    		brush.drawString("Score : "+ score.score,320, 320);
    		return;
    	}
    	
    	 for (Projectile proj : p) {
    	        if (!proj.show) 
    	        {	
    	        	continue;
    	        }
    	        proj.move();
    	        proj.paint(brush);
    	        for (int i = 0; i < field.a.length; i++) {
    	            if (field.a[i] != null && proj.collides(field.a[i])) 
    	            {
    	                field.a[i] = null;
    	                proj.show = false;
    	                score.addPoints(100);
    	            }
    	        }
    	    }
    	 
    	 p.removeIf(proj -> !proj.show);
    	 
    	 for(Asteroid a : field.a)
    	 {
    		 if (a != null) {
    	            a.move();
    	            a.paint(brush);
    	            if (ship.collides(a)) {
    	                score.loseLife();
    	                if (score.isGameOver()) gameOver = true;
    	            }
    	        } 
    	 }
    	 
    	 score.Paint(brush);
    	 
    	 if(field.destroy())
    	 {
    		 brush.setColor(Color.BLUE);
    		 brush.setFont(new Font("Arial",Font.BOLD,32));
    		 brush.drawString("YOU WON", 330, 280);
    	 }
  }
  
	public static void main (String[] args) {
   		Asteroids a = new Asteroids();
		a.repaint();
  }
}