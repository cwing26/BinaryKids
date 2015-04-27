package tutorial;

import javax.swing.*; 

import java.awt.*; 
import java.awt.event.*; 

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DecToBinPage4 extends JPanel
{

	WelcomePage welcomePage;
	JButton submitButton; 
	JButton tutorialButton;
	
	//Labels
	JLabel DecToBinNumSquaresText;
	JLabel DecToBinNumSquaresText2;
	JLabel DecToBinNumSquaresText3;

	final int startx = 200;
	final int starty = 180;
	int DecToBinNumSquaresInput;
	
	String text1 = "11 in decimal is equivalent to 1011 in binary!";
	String text2 = "Congratulations on making it through this tutorial. ";
	String text3 = "Now you can complete some practice problems or ";
	String text4 = "click tutorial to return to the tutorial menu screen.";


	class tutorialButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent le) {  
			welcomePage.loadFourth();
		} 
	}

	class submitButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent le) {  
			welcomePage.loadDecBinPracticeProblems();
		} 
	}
	public void initButtons(){
		submitButton = new JButton("Practice Problems"); 
		submitButton.addActionListener(new submitButtonListener());
		tutorialButton = new JButton("Return to Tutorials"); 
		tutorialButton.addActionListener(new tutorialButtonListener());
	}

	//constructor, param is the applet
	public DecToBinPage4(WelcomePage welcome)
	{
		setBackground(WelcomePage.backgroundColor);
		welcomePage = welcome;
		Insets insets = getInsets();

		initButtons();	
		
		setLayout(null);
		add(submitButton);
		add(tutorialButton);
		
		Dimension buttonSize = submitButton.getPreferredSize();
		submitButton.setBounds(260 + insets.left, 220 + insets.top,
				2* buttonSize.width, buttonSize.height);
		
		buttonSize = tutorialButton.getPreferredSize();
		tutorialButton.setBounds(260 + insets.left, 260 + insets.top,
				2* buttonSize.width, buttonSize.height);

	}

	public void paint(Graphics g) {
		super.paint(g);
		
		g.drawImage(welcomePage.tutorialCompleteImg, 200, 20, this);
		
		
		g.setFont(new Font("Geneva", Font.BOLD, 20));
		g.setColor(WelcomePage.textColor);
		int startTextX = 150;
		int startTextY = 70;
		int textYInc = 30;
		
		
		g.drawString(text1, startTextX+30, startTextY+textYInc);
		g.drawString(text2, startTextX, startTextY+2*textYInc);
		g.drawString(text3, startTextX, startTextY+3*textYInc);
		g.drawString(text4, startTextX, startTextY+4*textYInc);
	}


} //end class
