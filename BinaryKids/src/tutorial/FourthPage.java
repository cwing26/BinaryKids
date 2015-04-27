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
	WelcomePage welcomePage;

	JButton backgroundButton;
	JButton decBinButton;
	JButton binDecButton;
	JButton gameButton;
	boolean completedDecBin = false;
	boolean completedBinDec = false;

	//constructor, param is the applet
	public FourthPage(WelcomePage welcome)
	{
		welcomePage = welcome;
		setBackground(WelcomePage.backgroundColor);
		
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
		decBinButton.setBounds(300 + insets.left, 250 + insets.top,
				buttonSize.width, buttonSize.height);
		binDecButton.setBounds(300 + insets.left, 300 + insets.top,
				buttonSize.width, buttonSize.height);
		backgroundButton.setBounds(300 + insets.left, 200 + insets.top,
				buttonSize.width, buttonSize.height);
		gameButton.setBounds(330 + insets.left, 350 + insets.top,
				buttonSize.width, buttonSize.height);
		gameButton.setVisible(false);
	}
	
	//this method overrides the paint method
	public void paint(Graphics g) 
	{ 
		super.paint(g);
		g.drawImage(welcomePage.tutorialHeadline, 260, 50, this);
		g.drawImage(welcomePage.checkmarkImg, 450, 190, this);
		if (completedDecBin)
			g.drawImage(welcomePage.checkmarkImg, 450, 240, this);
		if (completedBinDec)
			g.drawImage(welcomePage.checkmarkImg, 450, 290, this);
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
			welcomePage.loadGame();
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
				welcomePage.decToBinTutorial();
			}
			else if(e.getSource() == binDecButton)
			{
				welcomePage.binToDecTutorial();

			}
			else if (e.getSource() == backgroundButton){
				welcomePage.background();
			}
			else
			{
				welcomePage.gameOver();
			}


		} //end action performed
	} //end button listener

} //end class fourthpage



