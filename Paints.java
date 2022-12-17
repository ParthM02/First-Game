//Name - Parth Mehta
import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;
//This is the actual paint method that connects the paint dots to form actual paint.
public class Paints {
	//This is the visual paint you see later on.
	private List<Paint> paint;
	//Constructor for the paints class.
	public Paints()
	{
      paint = new ArrayList<Paint>();
	}
	//Adds dots to the arrayList to create the visual paint.
	public void add(Paint al )
	{
		paint.add(al);
	}
	//Draws the paint.
	public void drawEmAll( Graphics window )
	{
      for(Paint a : paint) {
    	  a.draw(window); 
      }
	}
	//Deletes all the paint.
	public void cleanEmUp()
	{
      for( int i = 0; i < paint.size(); i++) {
            paint.remove(i);
      }
	}
	//Just returns the paint list.
	public List<Paint> getList()
	{
		return paint;
	}
	//ToString method.
	public String toString()
	{
		return "" + paint;
	}
}
