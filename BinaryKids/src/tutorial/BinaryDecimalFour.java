package tutorial;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import java.awt.*; 


@SuppressWarnings("serial")
public class BinaryDecimalFour extends JPanel
{	
	WelcomePage welcomePage;

	JButton submitButton;
	Image titleImage;
	
	String explanation = "We learned to convert from binary to decimal!";
    String answer = "1101 in binary = 13 in decimal!";
    		
    public BinaryDecimalFour(WelcomePage welcome)
    {
    	welcomePage = welcome;
    	setBackground(WelcomePage.backgroundColor);
    	
    	initComponents();
    	loadImages();
    	
    	setLayout(null);
    	add(submitButton);
    	
    	Insets insets = getInsets();
		Dimension buttonSize = submitButton.getPreferredSize();
		submitButton.setBounds(270 + insets.left, 290 + insets.top, buttonSize.width, buttonSize.height);

    	setVisible(true);

    }
    
    public void initComponents()
    {
    	submitButton = new JButton("Do Some practice problems!");

    	submitButton.addActionListener(new submitButtonListener());
    }
    
    public void loadImages()
    {
    	titleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.puttingTogetherPath)); 
		titleImage = titleImage.getScaledInstance(680, 60, Image.SCALE_SMOOTH);

    }
    
    public void paint(Graphics g)
    {
    	super.paint(g);
    	
    	g.drawImage(titleImage, 50, 15, this);
    	
    	//strings and explanations
    	g.setColor(Color.black);
    	g.setFont(new Font("Geneva", 1, 30));
    	g.drawString(explanation, 50, 200);
    	g.drawString(answer, 150, 250);

    
    }
    
	class submitButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			//welcomePage.loadBinDecPracticeProblems();
			
		} //end action performed
		
		
	} //end button listener
	
	
	
	
} //end class thirdpage


