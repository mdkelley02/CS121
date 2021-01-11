import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.Toolkit;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * CS 121 Project 1: Traffic Animation
 *
 * Animates a [put your description here]
 *
 * @author BSU CS 121 Instructors
 * @author [Matthew Kelley]
 */
@SuppressWarnings("serial")
public class TrafficAnimation extends JPanel
{
	// This is where you declare constants and variables that need to keep their
	// values between calls	to paintComponent(). Any other variables should be
	// declared locally, in the method where they are used.

	/**
	 * A constant to regulate the frequency of Timer events.
	 * Note: 100ms is 10 frames per second - you should not need
	 * a faster refresh rate than this
	 */
	private final int DELAY = 100; //milliseconds

	/**
	 * The anchor coordinate for drawing / animating. All of your vehicle's
	 * coordinates should be relative to this offset value.
	 */
	private int xOffset = 0;

	/**
	 * The number of pixels added to xOffset each time paintComponent() is called.
	 */
	private int stepSize = 10;

	private final Color BACKGROUND_COLOR = Color.black;

	/* This method draws on the panel's Graphics context.
	 * This is where the majority of your work will be.
	 *
	 * (non-Javadoc)
	 * @see java.awt.Container#paint(java.awt.Graphics)
	 */
	public void paintComponent(Graphics g)
	{
		// Get the current width and height of the window.
		int width = getWidth(); // panel width
		int height = getHeight(); // panel height

		// Fill the graphics page with the background color.
		g.setColor(BACKGROUND_COLOR);
		g.fillRect(0, 0, width, height);

		// Calculate the new xOffset position of the moving object.
		xOffset  = (xOffset + stepSize) % width;

		// TODO: Use width, height, and xOffset to draw your scalable objects
		// at their new positions on the screen

		// This draws a green square. Replace it with your own object.
		int squareSide = height / 5;
		int squareY = height / 2 - squareSide / 2;
		//drawing car
		g.setColor(Color.white);
		g.fillRect(xOffset, squareY, squareSide, squareSide);
		g.fillRect(xOffset+squareSide, squareY+squareSide-35, 50, 35);
		g.fillRect(xOffset-squareSide+50, squareY+squareSide-35, 50, 35);
		g.setColor(Color.GRAY);
		g.fillOval(xOffset-squareSide+50, squareY+squareSide-10, 40, 40);
		g.fillOval(xOffset-squareSide+175, squareY+squareSide-10, 40, 40);
		g.setColor(Color.blue);
		g.fillRect(xOffset+5, squareY+5, squareSide-5, squareSide-40);
		
		
		//top part of grass
		g.setColor(Color.green);
		g.drawRect(0, 0, width, height/4);
		g.fillRect(0, 0, width, height/4);
		
		g.setColor(Color.gray);
		g.drawRect(0, (height/10)-20, width, height/8);
		g.fillRect(0, (height/10)-20, width, height/8);
		//bottom part of grass
		g.setColor(Color.green);
		g.drawRect(0, height-height/4, width, height/4);
		g.fillRect(0, height-height/4, width, height/4);
		
		//avatar on the grass
		g.setColor(Color.white);
		g.drawOval((width/2)-8, height-height/4, 20, 20);
		g.fillOval((width/2)-8, height-height/4, 20, 20);
		
		g.setColor(Color.white);
		g.drawRect((width/2), height-height/4, 5, 50);
		g.fillRect((width/2), height-height/4, 5, 50);
		
		g.setColor(Color.white);
		g.drawRect((width/2)-22, (height-height/4)+25, 50, 3);
		g.fillRect((width/2)-22, (height-height/4)+25, 50, 3);
		
		g.setColor(Color.white);
		g.drawRect((width/2)-3, (height-height/4)+50, 3, 30);
		g.fillRect((width/2)-3, (height-height/4)+50, 3, 30);
		
		g.setColor(Color.white);
		g.drawRect((width/2)+5, (height-height/4)+50, 3, 30);
		g.fillRect((width/2)+5, (height-height/4)+50, 3, 30);

//		g.drawLine(width/2, (height-height/4)+50, width-150, height);
//		g.drawLine(width/2, (height-height/4)+50, -width+150, height);
		
		
		
		
		
		// Put your code above this line. This makes the drawing smoother.
		Toolkit.getDefaultToolkit().sync();
	}


	//==============================================================
	// You don't need to modify anything beyond this point.
	//==============================================================


	/**
	 * Starting point for this program. Your code will not go in the
	 * main method for this program. It will go in the paintComponent
	 * method above.
	 *
	 * DO NOT MODIFY this method!
	 *
	 * @param args unused
	 */
	public static void main (String[] args)
	{
		// DO NOT MODIFY THIS CODE.
		JFrame frame = new JFrame ("Traffic Animation");
		frame.setDefaultCloseOperation (JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().add(new TrafficAnimation());
		frame.pack();
		frame.setVisible(true);
	}

	/**
	 * Constructor for the display panel initializes necessary variables.
	 * Only called once, when the program first begins. This method also
	 * sets up a Timer that will call paint() with frequency specified by
	 * the DELAY constant.
	 */
	public TrafficAnimation()
	{
		// Do not initialize larger than 800x600. I won't be able to
		// grade your project if you do.
		int initWidth = 600;
		int initHeight = 400;
		setPreferredSize(new Dimension(initWidth, initHeight));
		this.setDoubleBuffered(true);

		//Start the animation - DO NOT REMOVE
		startAnimation();
	}

	/**
	 * Create an animation thread that runs periodically.
	 * DO NOT MODIFY this method!
	 */
	private void startAnimation()
	{
		ActionListener timerListener = new TimerListener();
		Timer timer = new Timer(DELAY, timerListener);
		timer.start();
	}

	/**
	 * Repaints the graphics panel every time the timer fires.
	 * DO NOT MODIFY this class!
	 */
	private class TimerListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) {
			repaint();
		}
	}
}
