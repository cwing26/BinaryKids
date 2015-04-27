package tutorial;

import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.*; 


@SuppressWarnings("serial")
public class BinaryDecimalFour extends JPanel
{	
	WelcomePage welcomePage;

	JButton tutorialButton;
	JButton submitButton;
	Image titleImage;
	
	String text1 = "13 in decimal is equivalent to 1101 in binary!";
	String text2 = "Congratulations on making it through this tutorial. ";
	String text3 = "Now you can complete some practice problems or ";
	String text4 = "click tutorial to return to the tutorial menu screen.";

    		
    public BinaryDecimalFour(WelcomePage welcome)
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

    	setVisible(true);

    }
    
    class tutorialButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent le) {
			welcomePage.setCompletedBinDec();
			welcomePage.loadFourth();
		} 
	}

	class submitButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent le) {  
			welcomePage.loadBinDecPracticeProblems();
			welcomePage.setCompletedBinDec();
		} 
	}
	public void initButtons(){
		submitButton = new JButton("Practice Problems"); 
		submitButton.addActionListener(new submitButtonListener());
		tutorialButton = new JButton("Return to Tutorials"); 
		tutorialButton.addActionListener(new tutorialButtonListener());
	}
    
    public void paint(Graphics g)
    {
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
    
		
	
	
	
	
} //end class thirdpage


