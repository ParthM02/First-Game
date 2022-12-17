//Name - Parth Mehta
import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
//This is the class used for the Bird.
public class Bird extends MovingThing{
	//Used for the speed of the Bird.
	private int speed;
	//Used to store the Image of the Bird.
	private Image image;
	//The next four methods are constructors for the Bird.
	public Bird()
	{
		this(10,10,10,10,10);
	}
	
	public Bird(int x, int y)
	{
      this(x,y,50,50,0);
	}
	
	public Bird(int x, int y, int s){
      this(x,y,50,50,s);
	}

	public Bird(int x, int y, int w, int h, int s){
		super(x, y, w, h);
		speed=s;
		try
		{
			URL url = getClass().getResource("Bird.png");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			//feel free to do something here
         
		}
	}

	//Used to set the speed of Bird.
	public void setSpeed(int s){
      speed = s;
	}
	//Returns the speed of the Bird.
	public int getSpeed(){
	   return speed;
	}
	//Used to move the Bird up and down.
	public void move(String direction)
	{
      if (direction.equals("UP")) {
          if (getY() >= 0) {
        	  setY(getY() - getSpeed());
          }
          
      }
      if (direction.equals("Down")) {
          if(getY() < 727) {
        	  setY(getY() + 4);
          }
       }
	}
	//This draws the image of the Bird.
	public void draw( Graphics window )
	{
   	window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}
	//Regular ToString method
	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
