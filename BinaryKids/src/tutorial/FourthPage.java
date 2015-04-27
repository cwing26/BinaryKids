package tutorial;


import java.awt.Graphics;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;

import java.awt.*; 


@SuppressWarnings("serial")
public class FourthPage extends JPanel
{	
	WelcomePage welcomePage;
	
	JButton backgroundButton;
	JButton decBinButton;
	JButton binDecButton;
    
    public FourthPage(WelcomePage welcome)
    {
    	welcomePage = welcome;
    	setBackground(WelcomePage.backgroundColor);
    	setLayout(null);
		Insets insets = getInsets();

    	backgroundButton = new JButton("Background");
    	decBinButton = new JButton("Decimal to Binary");
    	binDecButton = new JButton("Binary to Decimal");
    	decBinButton.addActionListener(new tutorialButtonListener());
    	binDecButton.addActionListener(new tutorialButtonListener());
    	backgroundButton.addActionListener(new tutorialButtonListener());
    	add(decBinButton);
    	add(binDecButton);
    	add(backgroundButton);
    	
    	Dimension buttonSize = decBinButton.getPreferredSize();
    	decBinButton.setBounds(250 + insets.left, 250 + insets.top,
				buttonSize.width, buttonSize.height);
    	binDecButton.setBounds(250 + insets.left, 300 + insets.top,
				buttonSize.width, buttonSize.height);
    	backgroundButton.setBounds(250 + insets.left, 200 + insets.top,
				buttonSize.width, buttonSize.height);
    	
    	
    	setVisible(true);

    }
    public void paint(Graphics g) 
    { 
    	super.paint(g);
    	g.drawImage(welcomePage.tutorialHeadline, 260, 50, this);
    }
    
    
	class tutorialButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			//welcome.tutorialFlag = 1-4;
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

} //end class thirdpage



