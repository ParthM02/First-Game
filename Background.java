	//Name - Parth Mehta
	import java.io.File;
	import java.net.URL;
	import java.awt.Color;
	import java.awt.Graphics;
	import java.awt.Image;
	import javax.imageio.ImageIO;
//Method for the Cartoon Background in Flappy Bird.
public class Background extends MovingThing{
		//Isn't really needed but it helps satisfy the MovingThing class.
		private int speed;
		//Variable used to store the image.
		private Image image;
		//The next four methods are constructors for the Background.
		public Background()
		{
			this(10,10,10,10,10);
		}
		
		public Background(int x, int y)
		{
	      this(x,y,50,50,0);
		}
		
		public Background(int x, int y, int s){
	      this(x,y,50,50,s);
		}

		public Background(int x, int y, int w, int h, int s){
			super(x, y, w, h);
			speed=s;
			try
			{
				URL url = getClass().getResource("background.png");
				image = ImageIO.read(url);
			}
			catch(Exception e)
			{
				//feel free to do something here
	         
			}
		}

		//Not needed but it sets the speed.
		public void setSpeed(int s){
	      speed = s;
		}
		//Not needed but it returns the speed.
		public int getSpeed(){
		   return speed;
		}
		//Only needed to satisfy MovingThing.
		public void move(String direction)
		{
	      //keep empty
		}
		//Used to draw the Cartoon background.
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
