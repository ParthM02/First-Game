//Name - Parth Mehta
import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
//This is the Class for the Cartoon Blue Guy in Mashing Battle.
public class BlueGuy extends MovingThing{
	private int speed;
	private Image image;
	private int mode = 1;
	//The next four methods are constructors for the Blue guy.
	public BlueGuy()
	{
		this(10,10,10,10,10);
	}
	
	public BlueGuy(int x, int y)
	{
      this(x,y,50,50,0);
	}
	
	public BlueGuy(int x, int y, int s){
      this(x,y,50,50,s);
	}

	public BlueGuy(int x, int y, int w, int h, int s){
		super(x, y, w, h);
		speed=s;
		try
		{
			URL url = getClass().getResource("BlueGuy.png");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			//feel free to do something here
         
		}
	}

	//Used to set the speed at which the blue guy jumps.
	public void setSpeed(int s){
      speed = s;
	}
	//Returns speed.
	public int getSpeed(){
	   return speed;
	}
	//Moves the Blue Guy up and down.
	public void move(String direction)
	{
      if (direction.equals("UP")) {
    	  if (mode == 1) {
        	  if (getY() == 300) {
            	  mode = 2;
              }else {
            	  setY(getY() + getSpeed());
              }
          }
          if (mode == 2) {
        	  if (getY() == 290) {
        		 mode = 1; 
        	  }else {
        		  setY(getY() - getSpeed());
        	  }
          } 
          
      }
      
	}
	//This method draws the Blue Guy.
	public void draw( Graphics window )
	{
   	window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}
	//Basic ToString method.
	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
