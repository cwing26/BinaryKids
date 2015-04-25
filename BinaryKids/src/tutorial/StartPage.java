package tutorial;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.TextField;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.border.LineBorder;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.io.File;
import java.io.IOException;
import java.net.URL;


@SuppressWarnings("serial")
public class StartPage extends JPanel
{
	JButton submitButton;
	TextField nameField;
	JPanel titlePanel;
	JLabel titleLabel;
	boolean nameEntered = false;

	
	
	private WelcomePage welcomePage; //to connect welcome page to individual pages 
    
    public StartPage(WelcomePage welcome)
    {
    	welcomePage = welcome;
    	
    	setBackground(WelcomePage.backgroundColor);
    	
    	submitButton = new JButton("Let's Get Started!");
    	submitButton.addActionListener(new submitButtonListener());
    	setLayout(null);
    	add(submitButton);
    	Insets insets = getInsets();
    	Dimension size = submitButton.getPreferredSize();
    	submitButton.setBounds(330-size.width/2 + insets.left, 200 + insets.top,
                2*size.width, size.height);
    	
    	
    }
    
    public void paint(Graphics g) 
    { 
    	super.paint(g);
    	g.drawImage(welcomePage.titleTextImg, 50 , 50, this);
    	g.drawImage(welcomePage.titleImg, 200, 100, this);

    }
    
	class submitButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			//welcomePage.setUserName(nameField.getText());
			//nameEntered = true;
			welcomePage.loadFirstPage();
			repaint();
			
		}
	}
	


}
