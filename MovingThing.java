//Name - Parth Mehta
import java.awt.Graphics;
//Used to create objects and manipulate its dimensions.
public abstract class MovingThing implements Moveable {
	//Variables for x, y, width, and height values.
	private int xPos;
	private int yPos;
	private int width;
	private int height;
	//The next three methods are constructors for the MovingThing class.
	public MovingThing(){
		xPos = 10;
		yPos = 10;
		width = 10;
		height = 10;
	}
	public MovingThing(int x, int y){
		xPos = x;
		yPos = y;
		width = 10;
		height = 10;
	}
	public MovingThing(int x, int y, int w, int h){
      xPos = x;
      yPos = y;
      width = w;
      height = h;
	}
	//Used to set object positions.
	public void setPos( int x, int y){
      xPos = x;
      yPos = y;
	}
	//Used to set X Position.
	public void setX(int x){
      xPos = x;
	}
	//Used to set Y Position.
	public void setY(int y){
      yPos = y;
	}
	//Returns X Position.
	public int getX(){
		return xPos;
	}
	//Returns Y Position.
	public int getY(){
		return yPos;
	}
	//Sets width.
	public void setWidth(int w){
      width = w;
	}
	//Sets height.
	public void setHeight(int h){
      height = h;
	}
	//Returns Weight.
	public int getWidth(){
		return width;
	}
	//Returns Height.
	public int getHeight(){
		return height;
	}
	// Used to declare graphics and movement methods.
	public abstract void move(String direction);
	public abstract void draw(Graphics window);
	//Basic ToString method.
	public String toString(){
		return getX() + " " + getY() + " " + getWidth() + " " + getHeight();
	}
}
