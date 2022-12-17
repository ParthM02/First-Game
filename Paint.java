//Name - Parth Mehta
import java.awt.Color;
import java.awt.Graphics;
//This is the class for the paint.
public class Paint extends MovingThing{
	//This just makes sure the paint stays still.
	private int speed;
	//This is for changing the color of the paint.
	private int colorNum = 1;
	//The next four methods are constructors for the paint.
	public Paint()
	{
		this(0,0,0,0,0);
	}
	public Paint(int x, int y)
	{
      this(x,y,10,10,0);
	}
	public Paint(int x, int y, int w, int h, int s)
	{
      super(x, y, w, h);
      speed = s;
	}
	public Paint(int x, int y, int w, int h, int s, int c)
	{
      super(x, y, w, h);
      speed = s;
      colorNum = c;
	}
	//This method makes sure the paint stays still.
	public void setSpeed(int s)
	{
      speed = s;
	}
	//This method is also used to make the paint stays still.
	public int getSpeed()
	{
	   return speed;
	}
	//This method is used to draw the paint.
	public void draw( Graphics window )
	{
		if (colorNum < 5) {
  			if( colorNum == 1) {
  				window.setColor(Color.YELLOW);
  				window.fillOval(getX(), getY(), getWidth(), getHeight());	
  			}else if(colorNum == 2) {
  				window.setColor(Color.BLUE);
  				window.fillOval(getX(), getY(), getWidth(), getHeight());
  			}else if(colorNum == 3) {
  				window.setColor(Color.GREEN);
  				window.fillOval(getX(), getY(), getWidth(), getHeight());
  			}else if (colorNum == 4) {
  				window.setColor(Color.RED);
  				window.fillOval(getX(), getY(), getWidth(), getHeight());
  			}
  		}else {
  			colorNum = 1;
  			window.setColor(Color.YELLOW);
  			window.fillOval(getX(), getY(), getWidth(), getHeight());
  		}
	}
	//only here for the sake of it extending MovingThing
	public void move( String direction )
	{
	//Nothing  
	}
	//ToString Method
	public String toString()
	{
		return super.toString() + getSpeed();
	}

}
