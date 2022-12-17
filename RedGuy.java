import java.io.File;
import java.net.URL;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import javax.imageio.ImageIO;
//Class for the Red Guy in Mashing Battle
public class RedGuy extends MovingThing{
	//Speed at which the picture moves.
	private int speed;
	//This is the image variable.
	private Image image;
	//Used to make image move up and down.
	private int mode = 1;
	//The next four methods are constructors for the image and stuff.
	public RedGuy()
	{
		this(10,10,10,10,10);
	}
	public RedGuy(int x, int y)
	{
      this(x,y,50,50,0);
	}
	public RedGuy(int x, int y, int s){
      this(x,y,50,50,s);
	}
	public RedGuy(int x, int y, int w, int h, int s){
		super(x, y, w, h);
		speed=s;
		try
		{
			URL url = getClass().getResource("RedGuy.png");
			image = ImageIO.read(url);
		}
		catch(Exception e)
		{
			//feel free to do something here
         
		}
	}
//Used to set speed of Image.
	public void setSpeed(int s){
      speed = s;
	}
//returns the speed of the image.
	public int getSpeed(){
	   return speed;
	}
//Method used to move the image.
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
//Method to draw the Image
	public void draw( Graphics window )
	{
   	window.drawImage(image,getX(),getY(),getWidth(),getHeight(),null);
	}
//Basic ToString method
	public String toString()
	{
		return super.toString() + getSpeed();
	}
}
