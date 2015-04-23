package tutorial;

import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;
import java.awt.*; 
import java.awt.Color;


@SuppressWarnings("serial")
public class BinaryDecimalFour extends JPanel
{	
	WelcomePage welcomePage;

	
	JButton submitButton;
	
    
    public BinaryDecimalFour(WelcomePage welcome)
    {
    	welcomePage = welcome;
    	setBackground(WelcomePage.backgroundColor);
    	
    	JPanel titlePanel = new JPanel();
    	JLabel titleLabel = new JLabel("BinaryKids (Page 4 Bin to Dec)");
    	titleLabel.setFont(new Font("Verdana",1,20));
    	titlePanel.add(titleLabel);
    	titlePanel.setBorder(new LineBorder(Color.BLACK));     	
    	
    	JLabel descriptionLabel = new JLabel("We learned to convert from binary to decimal! (4)");
    	descriptionLabel.setFont(new Font("Verdana",1,20));

    	
    	JPanel tablePanel = new JPanel();
    	JLabel tableLabel = new JLabel("1101 in binary =13 in decimal !!");
    	tableLabel.setFont(new Font("Verdana",1,15));
    	tablePanel.add(tableLabel);
    	tablePanel.setBorder(new LineBorder(Color.BLACK)); 
    	
    	submitButton = new JButton("Do Some practice problems!");

    	
    	submitButton.addActionListener(new submitButtonListener());
    	
    	add(titlePanel);
    	add(descriptionLabel);

    	add(tablePanel);


    	add(submitButton);

    	
    	setVisible(true);

    }
    
    public void paint(Graphics g)
    {
    	super.paint(g);

    
    }
    
	class submitButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			
			
		} //end action performed
		
		
	} //end button listener
	
	
	
	
} //end class thirdpage


