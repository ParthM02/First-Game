//Name - Parth Mehta
import java.awt.Color;
import java.awt.Graphics;
//This is the class for the Rectangle in Mashing Battle.
public class MasherThingy extends MovingThing{
	//Used to control speed of the rectangle.
		private int speed;
		//The next four methods are constructors for the class.
		public MasherThingy() {
			this(10,10,10,10,10);
		}
		public MasherThingy( int x, int y) {
			this(x,y,15,15, 0);
		}
		public MasherThingy(int x, int y, int s) {
			this( x,y,15,15,s);
		}
		public MasherThingy(int x, int y, int h, int w, int s) {
			super(x,y,h,w);
			speed = s;
		}
		//This method sets the speed.
		public void setSpeed(int s) {
			speed = s;
		}
		//This returns the speed.
		public int getSpeed() {
			return speed;
		}
		//This controls the movement of the rectangle.
		public void move(String direction) {
	      if ( direction.equals("LEFT")) {
	    	  if(getWidth() > 0) {
	    		  setWidth(getWidth() - getSpeed());
	    	  }
	      }else if ( direction.equals("RIGHT")) {
	         if(getWidth() < 600) {
	        	 setWidth(getWidth() + getSpeed());
	         }
	      }
		}
		
		//This controls how the rectangle looks.
		public void draw(Graphics window) {
			window.setColor(Color.RED);
			window.fillRect(getX(),getY(),getWidth(),getHeight());
		}
		
		//This is the toString Method
		public String toString() {
			return super.toString() + getSpeed();
		}
}
