package tutorial;


import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JButton;
import java.awt.*; 
import java.awt.BorderLayout;
import java.awt.GridBagConstraints;


@SuppressWarnings("serial")
public class FourthPage extends JPanel
{	
	WelcomePage welcomePage;
	
	JButton decBinButton;
	JButton binDecButton;
	JButton binAddButton;
	JButton binSubButton;
    
    public FourthPage(WelcomePage welcome)
    {
    	welcomePage = welcome;
    	setLayout(new BorderLayout());
    	setBackground(WelcomePage.backgroundColor);

    	
    	decBinButton = new JButton("Decimal to Binary");
    	binDecButton = new JButton("Binary to Decimal");
    	decBinButton.addActionListener(new tutorialButtonListener());
    	binDecButton.addActionListener(new tutorialButtonListener());
    	
    	JPanel buttonPanel = new JPanel(new GridBagLayout());
    	buttonPanel.setBackground(WelcomePage.backgroundColor);
    	GridBagConstraints c = new GridBagConstraints();
    	c.anchor = GridBagConstraints.LINE_START;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 20;
		c.gridx = 0;
		c.gridy = 0;
    	buttonPanel.add(decBinButton);
		c.gridy = 1;
    	buttonPanel.add(binDecButton);
    	
    	add(buttonPanel, BorderLayout.CENTER);
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
			else
			{
				welcomePage.gameOver();
			}
			
				
		} //end action performed
	} //end button listener

} //end class thirdpage



