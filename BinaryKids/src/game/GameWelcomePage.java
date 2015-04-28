package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;




import tutorial.Controller;

@SuppressWarnings("serial")
public class GameWelcomePage extends JPanel {

	//pages
	private Controller controller;
	private GamePage2 gamePage;
	
	Insets insets;
	
	//buttons
	JButton startButton;
	JButton instructButton;
	
	//background color
	public static Color backgroundColor = new Color(255, 255, 204);
	
	//coordinates
	private static int x = 400;
	private static int y = 100;
	
	boolean gameInProgress;
	
	public GameWelcomePage(Controller _controller) {
	
		controller = _controller;

		setLayout(null);

		setBackground(backgroundColor);
		
	
		insets = getInsets();
		
		
		//function to initialize variables
		initVariables();
		
		//set up welcome screen
		initWelcomeScreen();
		
		//add buttons to JPanel
		add(startButton);
		add(instructButton);
			
	}



	/**
	 * set gameInProgress = false when on this page
	 */
	private void initVariables()
	{
		gameInProgress = false;
	}

	 /**
	  * create welcome screen
	  */
	private void initWelcomeScreen() {
		
		//create start button
		startButton = new JButton("Play!");
		//add image to start button
		startButton.setIcon(new ImageIcon(controller.playButtonImage));
		
		//re-format button so only image is visible
		hideButton(startButton);
		
		//create new dimension from constants
		Dimension size = new Dimension(x, y);
		
		//add start button to panel at specified location
		startButton.setBounds(x-size.width/2 + insets.left, (y*2) + insets.top, size.width, size.height);
		
		//add listener for start button
		startButton.addActionListener(new startButtonListener());		
		
		//create instructions button
		instructButton = new JButton("How to play");
		//set image for instructions button
		instructButton.setIcon(new ImageIcon(controller.gameInstructionsButtonImage));
		//add instructions button to jpanel at specified location
		instructButton.setBounds(x-size.width/2 + insets.left, (y*4)+ insets.top, size.width, size.height);
		//add listener for instructions button
		instructButton.addActionListener(new instructButtonListener());
		
		//re-format button so only image is visible
		hideButton(instructButton);
	}
	
	/**
	 * reformat button so only image is visible
	 * @param button
	 */
	private void hideButton(JButton button)
	{
		button.setBorderPainted(false);;
		button.setContentAreaFilled(false);;
		button.setFocusPainted(false);;
		button.setOpaque(false);;
	}
	
	/**
	 * paint function
	 */
	public void paint(Graphics g)
	{
		super.paint(g);
		
		//draw top banner (two images) to jpanel
		g.drawImage(controller.binaryBlastImage, 50, 50, this);
		g.drawImage(controller.rocketshipImage, 550, 50, this);
	}
	
	
	class startButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			//if start button is clicked, start the game
			controller.loadCard("GAME");
		}
	}


	class instructButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//if instructions button is clicked, display instructions class
			//welcomePage.loadGameInstructions();
		}
	}

}
