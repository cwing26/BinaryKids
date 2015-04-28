package tutorial;


import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.*; 

//this class defines the tutorial menu select screen
@SuppressWarnings("serial")
public class FourthPage extends JPanel
{	
	Controller controller;

	private JButton backgroundButton;
	private JButton decBinButton;
	private JButton binDecButton;
	private JButton gameButton;
	boolean completedDecBin = false;
	boolean completedBinDec = false;
	
	private final int decBinButtonX = 300;
	private final int decBinButtonY = 250;
	
	private final int binDecButtonX = 300;
	private final int binDecButtonY = 300;
	
	private final int backgroundButtonX = 300;
	private final int backgroundButtonY = 200;

	private final int gameButtonX = 330;
	private final int gameButtonY = 350;

	private final int checkmarkX = 450;
	private final int checkmarkY1 = 190;
	private final int checkmarkY2 = 240;
	private final int checkmarkY3 = 290;
	
	private final int headlineX = 260;
	private final int headlineY = 50;
	
	//constructor, param is the applet
	public FourthPage(Controller welcome)
	{
		controller = welcome;
		setBackground(Controller.backgroundColor);
		
		initComponents();		
		addComponentsToPanel();
		formatComponents();

		setVisible(true);

	}
	
	//this method adds the components to the panel
	public void addComponentsToPanel() {
		setLayout(null);
		add(decBinButton);
		add(binDecButton);
		add(backgroundButton);
		add(gameButton);
		
	}

	//this method initializes all swing components and adds listeners
	public void initComponents(){
		backgroundButton = new JButton("Background");
		decBinButton = new JButton("Decimal to Binary");
		binDecButton = new JButton("Binary to Decimal");
		gameButton = new JButton("Play Game!");
		decBinButton.addActionListener(new tutorialButtonListener());
		binDecButton.addActionListener(new tutorialButtonListener());
		backgroundButton.addActionListener(new tutorialButtonListener());
		gameButton.addActionListener(new gameButtonListener());
	}
	
	//this method defines the formatting of the components on the panel
	public void formatComponents(){
		Insets insets = getInsets();
		
		Dimension buttonSize = decBinButton.getPreferredSize();
		decBinButton.setBounds(decBinButtonX + insets.left, decBinButtonY + insets.top,
				buttonSize.width, buttonSize.height);
		binDecButton.setBounds(binDecButtonX + insets.left, binDecButtonY + insets.top,
				buttonSize.width, buttonSize.height);
		backgroundButton.setBounds(backgroundButtonX + insets.left, backgroundButtonY + insets.top,
				buttonSize.width, buttonSize.height);
		gameButton.setBounds(gameButtonX + insets.left, gameButtonY + insets.top,
				buttonSize.width, buttonSize.height);
		gameButton.setVisible(true); //here
	}
	
	//this method overrides the paint method
	public void paint(Graphics g) 
	{ 

		
		super.paint(g);
		
		g.drawImage(controller.tutorialHeadline, headlineX, headlineY, this);
		
		g.drawImage(controller.checkmarkImg, checkmarkX, checkmarkY1, this);
		if (completedDecBin)
			g.drawImage(controller.checkmarkImg, checkmarkX, checkmarkY2, this);
		if (completedBinDec)
			g.drawImage(controller.checkmarkImg, checkmarkX, checkmarkY3, this);
		if (completedBinDec && completedDecBin){
			gameButton.setVisible(true);
		}
	}

	//this class defines an action listener for the game button
	class gameButtonListener implements ActionListener 
	{
		//method called when the game button is clicked
		public void actionPerformed(ActionEvent e) 
		{
			controller.loadCard("GAME WELCOME");
		}
	}
	
	//this class defines an action listener for the tutorial buttons
	class tutorialButtonListener implements ActionListener 
	{
		//handles when the tutorial method are clicked to load appropriate tutorial
		public void actionPerformed(ActionEvent e) 
		{
			if(e.getSource() == decBinButton)
			{
				controller.loadCard("DEC BIN PAGE 1");
			}
			else if(e.getSource() == binDecButton)
			{
				controller.loadCard("BIN DEC PAGE 1");

			}
			else if (e.getSource() == backgroundButton){
				controller.background();
			}
			else
			{
				controller.gameOver();
			}


		} //end action performed
	} //end button listener

} //end class fourthpage



