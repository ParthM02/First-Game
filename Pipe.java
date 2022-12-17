//Name - Parth Mehta

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import java.net.URL;

import javax.imageio.ImageIO;
//This is the class for all the individual pipes.
public class Pipe extends MovingThing {
	//This is responsible for how fast the pipes move.
	private int speed;
	//This is the special color for the pipe.
	public static final Color Dark_Green = new Color(0,100,0);
	//This is the variable for the image.
	private Image image;
	//The next three methods are constructors for the pipes.
	public Pipe(){
		this(0,0,0,0,0);
	}

	public Pipe(int x, int y){
      this(x,y,10,10,0);
	}

	public Pipe(int x, int y, int w, int h, int s){
		super(x, y, w, h);
		speed=s;
		try
		{
			URL url = getClass().getResource("newPipe.png");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			//feel free to do something here
         
		}
	}
	//This sets the speed of the pipes.
	public void setSpeed(int s){
      speed = s;
	}
	//This returns the speed of the pipes.
	public int getSpeed(){
	   return speed;
	}
	//This draws the pipes.
	public void draw( Graphics window ){
		
		window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
      
	}
	
	//This actually moves the pipes across the screen.
	public void move( String direction ){
      if (direction.equals("LEFT")) {
         setX(getX() - getSpeed());
      }
      
	}
	//This is the ToString method.
	public String toString(){
		return super.toString() + getSpeed();
	}
}
