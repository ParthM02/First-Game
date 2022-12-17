//Name - Parth Mehta
import javax.swing.JFrame;
import java.awt.Component;
//Method that serves as the runner.
public class GameRunner extends JFrame{
	//Sets the height of the window.
	public static final int HEIGHT = 800;
	//Sets the width of the window.
	public static final int WIDTH = 800;
	//Constructor for the runner.
	public GameRunner() {
		super("FINALGAME");
		setSize(WIDTH, HEIGHT);
		
		GameBrain theGame = new GameBrain();
		((Component)theGame).setFocusable(true);
		
		getContentPane().add(theGame);
		
		setVisible(true);
	}
	//This is the main runner method.
	public static void main(String[] args) {
		GameRunner run = new GameRunner();
	}

}
