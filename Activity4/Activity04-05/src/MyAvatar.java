import javax.swing.JFrame;
import javax.swing.JPanel;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Color;
import java.awt.Point;
/**
 * Lesson 4: Activity - Using Classes and Objects
 * 
 * Uses the MiniFig class to draw a custom avatar.
 * 
 * @author CS121 instructors
 * @author <you>
 */
@SuppressWarnings("serial")
public class MyAvatar extends JPanel
{
	public final int INITIAL_WIDTH = 1000;
	public final int INITIAL_HEIGHT = 1000;
	
	/**
	 * Draws the picture in the panel. This is where all of your
	 * code will go.
	 * @param canvas The drawing area of the window.
	 */
	public void paintComponent (Graphics g)
	{
		/* Store the height and width of the panel at the time
		 * the paintComponent() method is called.
		 */
		int currentHeight = getHeight();
		int currentWidth = getWidth();
		
		/* This is the anchor point for the MiniFig (x,y) -> (mid,top) */
		int mid = currentWidth / 2;
		int top = 50;
		
		/* This is the scaler that is used to calculate the dimensions (height / width) 
		 * of each of the MiniFig components. It uses the Math.min() function to select
		 * the smaller of currentWidth/INITIAL_WIDTH and currentHeight/INITIAL_HEIGHT.
		 * This way all the components are scaled to fit within the smaller of the two 
		 * panel dimensions.
		 */
		double scaleFactor = Math.min(currentWidth/(double)INITIAL_WIDTH,currentHeight/(double)INITIAL_HEIGHT );

		// TODO: 1. Instantiate a new Point object called "anchor". Use "mid" as your x value and
		//       "top" as your y value.
		Point anchor = new Point(mid, top);
		MiniFig jim = new MiniFig(g, scaleFactor*2, anchor);
		Color red = new Color(125, 0, 0);
		Color brown = new Color(131, 105, 83);
		Color blue = new Color(0,0,125);
		jim.setTorsoColor(red);
		jim.setArmColor(red);
		jim.setBeltColor(brown);
		jim.setLegColor(blue);
//		jim.draw();
		MiniFig matthew = jim;
		matthew.setTorsoColor(Color.white);
		
		matthew.draw();
		g.fillRect(jim.getCapPoint().x, 80, jim.getFaceWidth()+20, jim.getFaceHeight()-100);
		g.fillRect(jim.getCapPoint().x - ((jim.getFaceWidth()/2)+20), 30, jim.getFaceWidth(), jim.getFaceHeight()-50);
		
		g.setColor(Color.yellow);
		g.fillRect(jim.getLeftHandCenterPoint().x, jim.getLeftHandCenterPoint().y, 100, 20);
		g.setColor(Color.pink);
		g.fillRect(jim.getLeftHandCenterPoint().x, jim.getLeftHandCenterPoint().y, 20, 20);
		g.setColor(brown);
		g.fillRect(jim.getLeftHandCenterPoint().x+80, jim.getLeftHandCenterPoint().y, 20, 20);
		g.setColor(brown);
		g.fillRect(jim.getLeftHandCenterPoint().x+80, jim.getLeftHandCenterPoint().y, 20, 20);
		g.setColor(Color.black);
		g.fillRect(jim.getLeftHandCenterPoint().x+100, jim.getLeftHandCenterPoint().y+5, 10, 10);
		g.setColor(Color.orange);
		g.fillOval(0, 0, 150, 150);
		g.drawOval(0, 0, 150, 150);
		g.drawRect(250, 0, 100, 100);
		
		//jim.draw();
		
		
		// TODO: 2. Instantiate a new MiniFig object and give the reference variable a name of a person, 
		//       such as "bob". Use the MiniFig constructor with the following
		//       parameters: MiniFig(g, scaleFactor, anchor)
		
		// TODO: 3. Create a new custom Color object. An example is shown below.
		
		// TODO: 4. Invoke the setTorsoColor(Color color) method on your MiniFig instance.
		//       Use your color object as a parameter to change the shirt color.
		//       This lets you change the color of "bob's" shirt. :)
		
		// TODO: 5. Invoke the draw() method on your MiniFig instance. This is where "bob" is displayed on the screen.
		
		// TODO: 6. Adjust the size of your Avatar's window. Notice how the avatar does not stay grounded
		//       on the grass. To fix this, use the getBaseMidPoint() method to find the the base mid point of your
		//       MiniFig. This method returns a Point object that represents the x,y coordinates at the
		//       base of the MiniFig, right between its feet. 
		//       Replace the hard-coded value of grassYOffset with the y value 
		//       of the returned point.
		int grassYOffset = 750;
		
		Color grassGreen = new Color (60,80,38);
		g.setColor(grassGreen);
		g.fillRect(0, grassYOffset, currentWidth, currentHeight - grassYOffset);

		// TODO: 7. Create an Alias of for your MiniFig object and change the torso color of the alias.
		//       If in step 2 you used the variable name "bob", you can create an alias named "robert"
		//       using the following:
		//       MiniFig robert = bob;
		//       robert.setTorsoColor(Color.RED);

		
	        // TODO: 8. Comment out the draw statement under TODO item 5 and then draw the original MiniFig 
		//       below. If you used the variable name "bob" is would simply be the following:
		//       bob.draw();
		//       What color is Bob's Shirt?  Why?
		
		//		Bob's shirt is the same color as the alias because non primitive objects in java merely point to the memory space rather than makign a copy.
	}


	/**
	 * Constructor (panel initialization)
	 */
	public MyAvatar()
	{
		this.setBackground(Color.white);
		this.setPreferredSize(new Dimension(INITIAL_WIDTH, INITIAL_HEIGHT));
	}

	/**
	 * Sets up a JFrame and the MiniFigDriver panel.
	 * @param args unused
	 */
	public static void main(String[] args)
	{
		JFrame frame = new JFrame("MyAvatar");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new MyAvatar());
		frame.pack();
		frame.setVisible(true);
	}
}
