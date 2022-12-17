//Name - Parth Mehta
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Canvas;
import java.awt.event.ActionEvent;
import java.awt.event.KeyListener;
import java.awt.event.KeyEvent;
import static java.lang.Character.*;
import java.awt.image.BufferedImage;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.Font;
import java.util.concurrent.TimeUnit;
//This is the main class that basically does all the behind the scenes work for the games including the menu.
public class GameBrain extends Canvas implements KeyListener, Runnable{
	//Array that contains all the key bindings.
	private boolean[] keys;
	//Variable used for graphics.
	private BufferedImage back;
	//Variable that is used to change games and show menu.
	private int game = 0;
	//Used to count pipes in Flappy Bird
	private int counter = 0;
	//Variable that stores information about whether the bird should be alive or not.
	private boolean good = true;
	//This is the object bird that is created.
	private Bird bird;
	//This is used to display the cartoon background image.
	private Background background;
	//This is the pipes object used to make the pipes.
	private ManyPipes pipes;
	//Boolean used to see whether to show the regular score or not.
	private boolean showRegScore = true;
	//Boolean used to see whether to show the pipes or not.
	private boolean makePipes = true;
	//This is the painter object.
	private Painter painter;
	//This is the paint that put on the screen.
	private Paints dots;
	//This is the object used create the prompt and answers.
	private Prompt prompt;
	//Variable to change color of paint and painter.
	private int color = 1;
	//Variable on whether to show the prompt or not.
	private boolean showPrompt = true;
	//Variable used to see whether to show player two or not.
	private boolean showPlayer2 = false;
	//Variable used to see if the came ended or not.
	private boolean finale = false;
	//Used to see if the players won or not.
	private boolean win = false;
	//Array that contains all the answer choices.
	private String[] choices;
	//This is the rectangle object used in Mashing Battle.
	private MasherThingy rect;
	//This is the cartoon red guy object.
	private RedGuy redMan;
	//This is the cartoon blue guy object.
	private BlueGuy blueMan;
	//Used to move the red guy.
	private int redCount = 1;
	//Used to move the blue guy.
	private int blueCount = 1;
	//Used to see who is the winner of the game.
	private int winner = 0;
	//Method for defining objects and its parameters.
	public GameBrain() {
		setBackground(Color.black);
		keys = new boolean[21];
		bird = new Bird(310,450,60,50,17);
		background = new Background(0,0,800,800,0);
		pipes = new ManyPipes();
		
		painter = new Painter(10,10,1);
		dots = new Paints();
		prompt = new Prompt();
		prompt.setPrompt();
		choices = prompt.getChoices();
		
		rect = new MasherThingy(100,400,300,75,10);
		redMan = new RedGuy(80,300,120,100,10);
		blueMan = new BlueGuy(600,300,120,100,10);
		
		this.addKeyListener(this);
		new Thread(this).start();
		
		setVisible(true);
	}
	//Method used to paint window.
	public void update(Graphics window) {
		paint(window);
	}
	//Main method that handles all graphics and paints everything and calls other methods and classes.
	public void paint(Graphics window) {
		Graphics2D twoDGraph = (Graphics2D)window;
		
		if (back == null) {
			back = (BufferedImage)(createImage(getWidth(),getHeight()));
		}
		
		Graphics graphToBack = back.createGraphics();
		
		background.draw(graphToBack);
		//This is the menu code.
		if (game == 0) {
			graphToBack.setColor(Color.BLACK);
			graphToBack.fillRect(0,0,800,800);
			graphToBack.setColor(Color.white);
			Font font = new Font("Arial", Font.PLAIN, 20);            
		    graphToBack.setFont(font);
			graphToBack.drawString("Please select a game or press 'Q' to quit.", 20, 20);
			
			graphToBack.drawRect(10, 300, 250, 200);
			graphToBack.drawString("1.", 15, 320);
	    	graphToBack.drawString("Pictionary", 90, 400);
	    	graphToBack.drawRect(270, 300, 250, 200);
	    	graphToBack.drawString("2.", 275, 320);
	    	graphToBack.drawString("Flappy Brird", 340, 400);
	    	graphToBack.drawRect(530, 300, 250, 200);
	    	graphToBack.drawString("3.", 535, 320);
	    	graphToBack.drawString("Mashing Battle", 590, 400);
	    	
	    	if(keys[18] == true) {
				System.exit(0);
				
			}
	    	if(keys[6] == true) {
				game = 1;
				prompt.setPrompt();
	    		showPrompt = true;
	    		finale = false;
				
			}
	    	if(keys[7] == true) {
				game = 2;
				makePipes = true;
				showRegScore = true;
				counter = 0;
				pipes.removeEmAll();
				
			}
	    	if(keys[8] == true) {
				game = 3;
				rect.setWidth(300);
				winner = 0;
				
			}
		}
		
		//Code for Flappy Bird.
		if (game == 2) {	
			if(keys[4] == true) {
				bird.move("UP");
				
			}
			if(keys[10] == true) {
				//System.exit(0);
				game = 0;
				
			}
			if(keys[17] == true) {
				makePipes = true;
				showRegScore = true;
				counter = 0;
				pipes.removeEmAll();
			}
			
			
			bird.move("Down");
			
			if (makePipes == true) {
				if(pipes.getList().size() < 1) {
					int rand = (int)(Math.random() * 450 + 550);
					int yVal = 400 - rand;
					pipes.add(new Pipe(700,yVal, 150,1500,3));
					
				}
				if(pipes.getList().get(0).getX() == bird.getX()) {
					int rand = (int)(Math.random() * 450 + 550);
					int yVal = 400 - rand;
					pipes.add(new Pipe(700,yVal, 150,1500,3));
					counter++;
				}
				if (pipes.getList().get(0).getX() <= bird.getX() && pipes.getList().get(0).getX() + 70 >= bird.getX() && pipes.getList().get(0).getY() + 650 <= bird.getY() && pipes.getList().get(0).getY() + 795 >= bird.getY()) {
					good = true;
					
				}else {
					good = false;
					
				}
				
				
				if (pipes.getList().get(0).getX() <= bird.getX() && pipes.getList().get(0).getX() + 70 >= bird.getX()) {
					if (good == false) {
						makePipes = false;
						showRegScore = false;
					}
				}
			}
			
			if (makePipes == true) {
				pipes.drawEmAll(graphToBack);
			}
			
			
			pipes.moveEmAll();
			pipes.cleanEmUp();
			
			bird.draw(graphToBack);
			graphToBack.setColor(Color.yellow);
			Font font = new Font("Arial", Font.PLAIN, 20);            
		    graphToBack.setFont(font);
			graphToBack.drawString("Press \"D\" when Done", 600, 30);
			graphToBack.drawString("Press \"R\" to Restart", 600, 55);
			
			
			if ( showRegScore == true) {
				graphToBack.setColor(Color.yellow);
				font = new Font("Arial", Font.PLAIN, 20);            
			    graphToBack.setFont(font);
				graphToBack.drawString("Pipes Passed: " + counter, 20, 20);
			}
			
			if (showRegScore == false) {
				graphToBack.setColor(Color.yellow);
				font = new Font("Arial", Font.BOLD, 50);            
			    graphToBack.setFont(font);
			    graphToBack.drawString("GAME OVER", 250, 300);
				graphToBack.drawString("Pipes Passed: " + (counter - 1), 220, 400);
			}
		}
		//Code for Guessing Game
		if (game == 1) {
			graphToBack.setColor(Color.BLACK);
			graphToBack.fillRect(0,0,800,800);
			Font font = new Font("Arial", Font.PLAIN, 20);            
		    graphToBack.setFont(font);
		    graphToBack.setColor(Color.YELLOW);
		    graphToBack.fillRect(0,680,800,10);
		    graphToBack.drawString("Press \"h\" for help", 600, 30);
		    if (showPrompt == true) {
		    graphToBack.drawString("Player1: Your prompt is: " + prompt.getPrompt(), 10, 30);
		    }
		    if(keys[14] == true) {
		    	font = new Font("Arial", Font.PLAIN, 15);            
			    graphToBack.setFont(font);
			    graphToBack.drawString("Use Arrow Keys to move", 550, 60);
			    graphToBack.drawString("Press \"Space\" to Draw", 550, 80);
			    graphToBack.drawString("Press \"1\" to change color to Yellow", 550, 100);
		    	graphToBack.drawString("Press \"2\" to change color to Blue", 550, 120);
		    	graphToBack.drawString("Press \"3\" to change color to Green", 550, 140);
		    	graphToBack.drawString("Press \"4\" to change color to RED", 550, 160);
		    	graphToBack.drawString("Press \"5\" to clear drawing", 550, 180);
		    	graphToBack.drawString("Press \"D\" when done", 550, 200);
		    }
		    if(keys[10] == true ) {
		    	showPrompt = false;
	        	showPlayer2 = true;	
	        }
		    if (showPlayer2 == true) {
		    	graphToBack.drawString("Now Player2 try and guess the shape from the answer choices", 10, 30);
		    	graphToBack.setColor(Color.BLUE);
		    	graphToBack.drawRect(10, 700, 250, 60);
		    	graphToBack.drawString("A.", 15, 720);
		    	graphToBack.drawString(choices[0], 30, 740);
		    	graphToBack.drawRect(270, 700, 250, 60);
		    	graphToBack.drawString("B.", 275, 720);
		    	graphToBack.drawString(choices[1], 290, 740);
		    	graphToBack.drawRect(530, 700, 250, 60);
		    	graphToBack.drawString("C.", 535, 720);
		    	graphToBack.drawString(choices[2], 550, 740);
		    }
		    if (finale == true) {
		    	if(win == true) {
		    		dots.cleanEmUp();
		    		graphToBack.drawString("CORRECT,YOU GUYS WIN!!!", 10, 30);
		    	}else if (win == false) {
		    		dots.cleanEmUp();
		    		graphToBack.drawString("WRONG,YOU GUYS LOSE!!!", 10, 30);
		    	}
		    	graphToBack.drawString("Do you want to play again? Y or N", 250, 350);
		    	if(keys[15] == true) {
		    		prompt.setPrompt();
		    		showPrompt = true;
		    		finale = false;
		    	}else if(keys[16] == true) {
		    		game = 0;
		    	}
		    }
		    if (keys[11] == true && choices[0].equals(prompt.getPrompt())) {
		    	showPlayer2 = false;
		    	win = true;
		    	finale = true;
		    }else if (keys[11] == true && !choices[0].equals(prompt.getPrompt())) {
		    	showPlayer2 = false;
		    	win = false;
		    	finale = true;
		    }
		    if (keys[12] == true && choices[1].equals(prompt.getPrompt())) {
		    	showPlayer2 = false;
		    	win = true;
		    	finale = true;
		    }else if (keys[12] == true && !choices[1].equals(prompt.getPrompt())) {
		    	showPlayer2 = false;
		    	win = false;
		    	finale = true;
		    }
		    if (keys[13] == true && choices[2].equals(prompt.getPrompt())) {
		    	showPlayer2 = false;
		    	win = true;
		    	finale = true;
		    }else if (keys[13] == true && !choices[2].equals(prompt.getPrompt())) {
		    	showPlayer2 = false;
		    	win = false;
		    	finale = true;
		    }
			painter.draw(graphToBack);
			
			if(keys[0] == true)
			{
				painter.move("LEFT");
			}
	      
	        if(keys[1] == true)
			{
				painter.move("RIGHT");
			}
	      
	        if(keys[2] == true)
			{
				painter.move("UP");
			}
	      
	        if(keys[3] == true)
			{
				painter.move("DOWN");
			}
	        if(keys[4] == true)
			{	
	        	dots.add(new Paint(painter.getX() + painter.getWidth()/2-5, painter.getY(), 10, 10, 0, color));
			}
	        dots.drawEmAll(graphToBack);
	        if(keys[5] == true ) {
	        	dots.cleanEmUp();
	        }
	        if(keys[6] == true ) {
	        	painter.changeColor(1);
	        	color = 1;
	        }
	        if(keys[7] == true ) {
	        	painter.changeColor(2);
	        	color = 2;
	        }
	        if(keys[8] == true ) {
	        	painter.changeColor(3);
	        	color = 3;
	        }
	        if(keys[9] == true ) {
	        	painter.changeColor(4);
	        	color = 4;
	        }
		}
		//Code for Mashing Battle.
		if (game == 3) {
			graphToBack.setColor(Color.black);
			graphToBack.fillRect(0,0,800,800);
			
			graphToBack.setColor(Color.blue);
			graphToBack.fillRect(100,400,600,75);
			
			graphToBack.setColor(Color.white);
			Font font = new Font("Arial", Font.BOLD, 100);            
		    graphToBack.setFont(font);
		    
			
			if (winner == 0) {
				if(keys[19] == true) {
					rect.move("RIGHT");
					redCount++;		
				}
				if(redCount % 5 == 0) {
					redMan.move("UP");
				}
				if(keys[20] == true) {
					rect.move("LEFT");
					blueCount++;
				}
				if (blueCount % 5 == 0) {
					blueMan.move("UP");
				}
				graphToBack.drawString("MASH", 260, 200);
			}
			if(keys[10] == true) {
				game = 0;
				
			}
			
			if (keys[17] == true) {
				winner = 0;
				rect.setWidth(300);
			}
		    
		    if (rect.getWidth() == 0) {
		    	winner = 2;
			}
			if (rect.getWidth() == 600) {
				winner = 1;
			}
			
			if ( winner == 2) {
				graphToBack.drawString("BLUE WINS!!!", 75, 200);
			}
			if (winner == 1) {
				graphToBack.drawString("RED WINS!!!", 100, 200);
			}
			
			graphToBack.setColor(Color.white);
			font = new Font("Arial", Font.PLAIN, 20);            
		    graphToBack.setFont(font);
			graphToBack.drawString("Press \"D\" when Done", 600, 30);
			graphToBack.drawString("Press \"R\" to Restart", 600, 55);
			font = new Font("Arial", Font.PLAIN, 40);            
		    graphToBack.setFont(font);
			graphToBack.drawString("Z", 100, 510);
			graphToBack.drawString("M", 670, 510);
			
			redMan.draw(graphToBack);
			blueMan.draw(graphToBack);
			rect.draw(graphToBack);
		}
		
		twoDGraph.drawImage(back, null, 0, 0);
	}
	//Method to detect if a key is pressed.
	public void keyPressed(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			keys[0] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			keys[1] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			keys[2] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			keys[3] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			keys[4] = true;
		}
		if (e.getKeyCode() == KeyEvent.VK_5) {
			keys[5] = true;
		}
		if ( e.getKeyCode() == KeyEvent.VK_1) {
			keys[6] = true;
		}
		if ( e.getKeyCode() == KeyEvent.VK_2) {
			keys[7] = true;
		}
		if ( e.getKeyCode() == KeyEvent.VK_3) {
			keys[8] = true;
		}
		if ( e.getKeyCode() == KeyEvent.VK_4) {
			keys[9] = true;
		}
		if ( e.getKeyCode() == KeyEvent.VK_D) {
			keys[10] = true;
		}
		if ( e.getKeyCode() == KeyEvent.VK_A) {
			keys[11] = true;
		}
		if ( e.getKeyCode() == KeyEvent.VK_B) {
			keys[12] = true;
		}
		if ( e.getKeyCode() == KeyEvent.VK_C) {
			keys[13] = true;
		}
		if ( e.getKeyCode() == KeyEvent.VK_H) {
			keys[14] = true;
		}
		if ( e.getKeyCode() == KeyEvent.VK_Y) {
			keys[15] = true;
		}
		if ( e.getKeyCode() == KeyEvent.VK_N) {
			keys[16] = true;
		}
		if ( e.getKeyCode() == KeyEvent.VK_R) {
			keys[17] = true;
		}
		if ( e.getKeyCode() == KeyEvent.VK_Q) {
			keys[18] = true;
		}
		if ( e.getKeyCode() == KeyEvent.VK_Z) {
			keys[19] = true;
		}
		if ( e.getKeyCode() == KeyEvent.VK_M) {
			keys[20] = true;
		}
		repaint();
	}
	//Method to detect if a key is released.
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_LEFT) {
			keys[0] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_RIGHT) {
			keys[1] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_UP) {
			keys[2] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_DOWN) {
			keys[3] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_SPACE) {
			keys[4] = false;
		}
		if (e.getKeyCode() == KeyEvent.VK_5) {
			keys[5] = false;
		}
		if ( e.getKeyCode() == KeyEvent.VK_1) {
			keys[6] = false;
		}
		if ( e.getKeyCode() == KeyEvent.VK_2) {
			keys[7] = false;
		}
		if ( e.getKeyCode() == KeyEvent.VK_3) {
			keys[8] = false;
		}
		if ( e.getKeyCode() == KeyEvent.VK_4) {
			keys[9] = false;
		}
		if ( e.getKeyCode() == KeyEvent.VK_D) {
			keys[10] = false;
		}
		if ( e.getKeyCode() == KeyEvent.VK_A) {
			keys[11] = false;
		}
		if ( e.getKeyCode() == KeyEvent.VK_B) {
			keys[12] = false;
		}
		if ( e.getKeyCode() == KeyEvent.VK_C) {
			keys[13] = false;
		}
		if ( e.getKeyCode() == KeyEvent.VK_H) {
			keys[14] = false;
		}
		if ( e.getKeyCode() == KeyEvent.VK_Y) {
			keys[15] = false;
		}
		if ( e.getKeyCode() == KeyEvent.VK_N) {
			keys[16] = false;
		}
		if ( e.getKeyCode() == KeyEvent.VK_R) {
			keys[17] = false;
		}
		if ( e.getKeyCode() == KeyEvent.VK_Q) {
			keys[18] = false;
		}
		if ( e.getKeyCode() == KeyEvent.VK_Z) {
			keys[19] = false;
		}
		if ( e.getKeyCode() == KeyEvent.VK_M) {
			keys[20] = false;
		}
		repaint();
	}
	//Method that doesn't need to be filled but has to be here for the sake of the code running.
	public void keyTyped(KeyEvent e) {
		//no code needed here
	}
	//Basically runs the program.
	public void run() {
	   	try
	   	{
	   		while(true)
	   		{
	   		   Thread.currentThread().sleep(5);
	            repaint();
	         }
	      }catch(Exception e)
	      {
	      }
	  	}
}