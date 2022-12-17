//Name - Parth Mehta

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.io.File;
import javax.imageio.ImageIO;
import java.util.ArrayList;
import java.util.List;
//Method used to create the pipes for Flappy Bird.
public class ManyPipes {
	//This is the array that contains all the pipes.
	private List<Pipe> pipes;
	//Constructor that defines the pipes array.
	public ManyPipes()
	{
      pipes = new ArrayList<Pipe>();
      
	}
	//This method adds more pipes to the array.
	public void add(Pipe al)
	{
      pipes.add(al);
	}

	//This draws all the pipes.
	public void drawEmAll( Graphics window )
	{
      for(Pipe a : pipes) {
         a.draw(window);
      }
	}
//This method moves the pipes across the screen.
	public void moveEmAll()
	{
      for(Pipe al : pipes) {
         al.move("LEFT");
      }
	}
//This deletes the pipes when then reach a certain X value.
	public void cleanEmUp()
	{
      for( int i = 0; i < pipes.size(); i++) {
         if ( pipes.get(i).getX() < 0) {
            pipes.remove(i);
         }
      }
	}
	//This clears all the pipes off the screen.
	public void removeEmAll() {
		for( int i = 0; i < pipes.size(); i++) {
	       pipes.remove(i);
	      }
	}
//This returns the list of pipes.
	public List<Pipe> getList()
	{
		return pipes;
	}
	//Basic ToString method.
	public String toString()
	{
		return "" + pipes;
	}
}
