//this class is the fourth page in the binary to decimal tutorial

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
	Controller controller;

	JButton tutorialButton;
	JButton submitButton;
	Image titleImage;
	
	final String text1 = "13 in decimal is equivalent to 1101 in binary!";
	final String text2 = "Congratulations on making it through this tutorial. ";
	final String text3 = "Now you can complete some practice problems or ";
	final String text4 = "click tutorial to return to the tutorial menu screen.";
	
	final int submitButtonX = 260;
	final int submitButtonY = 220;
	final int tutorialButtonX = 260;
	final int tutorialButtonY = 260;

	final int startTextX = 150;
	final int startTextY = 70;
	final int textYInc = 30;
	
	final int headerX = 200;
	final int headerY = 20;
	
    //constructor, param is the applet		
    public BinaryDecimalFour(Controller welcome)
    {
    	setBackground(Controller.backgroundColor);
		controller = welcome;
		
		initComponents();
		addComponentsToPanel();
		formatComponents();
    	setVisible(true);
    }
    
    
	//init swing components
	public void initComponents(){
		initButtons();	
	}
    
	//this method adds the components to the panel
	public void addComponentsToPanel() {
		setLayout(null);
		add(submitButton);
		add(tutorialButton);
	}
	
	
	//this method defines the formatting of the components on the panel
	public void formatComponents(){
		Insets insets = getInsets();

		Dimension buttonSize = submitButton.getPreferredSize();
		submitButton.setBounds(submitButtonX + insets.left, submitButtonY + insets.top,
				2* buttonSize.width, buttonSize.height);
		
		buttonSize = tutorialButton.getPreferredSize();
		tutorialButton.setBounds(tutorialButtonX + insets.left, tutorialButtonY + insets.top,
				2* buttonSize.width, buttonSize.height);
	}
	
	//action listener for tutorial button
    class tutorialButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent le) {
			controller.setCompletedBinDec();
			controller.loadCard("FOURTH");
		} 
	}

  //action listener for submit button
	class submitButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent le) {  
			controller.loadCard("BIN DEC PAGE 5");
			controller.setCompletedBinDec();
		} 
	}
	
	//initializes buttons
	public void initButtons(){
		submitButton = new JButton("Practice Problems"); 
		submitButton.addActionListener(new submitButtonListener());
		tutorialButton = new JButton("Return to Tutorials"); 
		tutorialButton.addActionListener(new tutorialButtonListener());
	}
    
	//overrides paint method
    public void paint(Graphics g)
    {
    	super.paint(g);
    	
    	//headline
    	g.drawImage(controller.tutorialCompleteImg, headerX, headerY, this);
		
		//text
		g.setFont(new Font("Geneva", Font.BOLD, 20));
		g.setColor(Controller.textColor);
		g.drawString(text1, startTextX+30, startTextY+textYInc);
		g.drawString(text2, startTextX, startTextY+2*textYInc);
		g.drawString(text3, startTextX, startTextY+3*textYInc);
		g.drawString(text4, startTextX, startTextY+4*textYInc);

    
    }
    
		
	
	
	
	
} //end class thirdpage


