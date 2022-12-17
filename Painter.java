//Name - Parth Mehta
import java.awt.Color;
import java.awt.Graphics;
//This is the cursor used for painting.
public class Painter extends MovingThing{
	//Used to control speed of the cursor.
	private int speed;
	//Used to change the color of the cursor.
	private int colorNum = 1;
	//The next four methods are constructors for the class.
	public Painter() {
		this(10,10,10,10,10);
	}
	public Painter( int x, int y) {
		this(x,y,15,15, 0);
	}
	public Painter(int x, int y, int s) {
		this( x,y,15,15,s);
	}
	public Painter(int x, int y, int h, int w, int s) {
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
	//This controls the movement of the cursor.
	public void move(String direction) {
      if ( direction.equals("LEFT")) {
         setX(getX() - getSpeed());
      }else if ( direction.equals("RIGHT")) {
         setX(getX() + getSpeed());
      }else if (direction.equals("UP")) {
         setY(getY() - getSpeed());
      }else if (direction.equals("DOWN")) {
         setY(getY() + getSpeed());
      }
	}
	//This controls how the cursor looks.
	public void draw(Graphics window) {
		if (colorNum < 5) {
			if( colorNum == 1) {
				window.setColor(Color.YELLOW);
			}else if(colorNum == 2) {
				window.setColor(Color.BLUE);
			}else if(colorNum == 3) {
				window.setColor(Color.GREEN);
			}else if (colorNum == 4) {
				window.setColor(Color.RED);
			}
		}else {
			colorNum = 1;
			window.setColor(Color.YELLOW);
		}
		window.fillOval(getX(), getY(), getWidth(), getHeight());
	}
	//This changes the color of cursor.
	public void changeColor(int n) {
		colorNum = n;
	}
	//This is the toString Method
	public String toString() {
		return super.toString() + getSpeed();
	}
}
