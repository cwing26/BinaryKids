package tutorial;
import java.awt.Button;
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
	Button submitButton;
	TextField nameField;
	JPanel titlePanel;
	JLabel titleLabel;
	boolean nameEntered = false;

	
	
	private WelcomePage welcomePage; //to connect welcome page to individual pages 
    
    public StartPage(WelcomePage welcome)
    {
    	welcomePage = welcome;
    	
    	setBackground(WelcomePage.backgroundColor);
    	//ImageIcon icon = new ImageIcon(welcomePage.titleTextImg);
    	//ImageIcon icon = new ImageIcon("images/titleTextImg");
    	
    	
    	titleLabel = new JLabel("Welcome to BinaryKids!");
    	titleLabel.setFont(new Font("Verdana",1,20));
    	
    	//titlePanel.setBorder(new LineBorder(Color.BLACK)); 
    	
    	submitButton = new Button("Submit");
    	submitButton.addActionListener(new nameButtonListener());
    	nameField = new TextField("Enter your name here");
    	nameField.setColumns(20);
    	
    	
    	JLabel directionsLabel = new JLabel("This applet will teach you how to use binary. ");
    	directionsLabel.setFont(new Font("Verdana", 1, 14));
    	
    	JLabel directionsLabel2 = new JLabel("Then you can play a fun game with the skills you've learned!!");
    	directionsLabel2.setFont(new Font("Verdana", 1, 14));
    	
    	titlePanel = new JPanel();
    	titlePanel.setLayout(new GridBagLayout());
    	titlePanel.setBackground(WelcomePage.backgroundColor);
    	GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.CENTER;
		c.gridx = 0;
		c.gridy = 0;
		c.ipady = 50;
    	titlePanel.add(titleLabel, c);
    	c.ipady = 0;
    	c.gridx = 0;
		c.gridy = 1;
		//c.insets = new Insets (0,50,0,50);
    	titlePanel.add(nameField, c);
    	c.gridx = 1;
		c.gridy = 1;
    	titlePanel.add(submitButton, c);
    	c.gridx = 0;
		c.gridy = 2;
		c.anchor = GridBagConstraints.CENTER;
		titlePanel.add(directionsLabel, c);
    	c.gridx = 0;
		c.gridy = 3;
    	titlePanel.add(directionsLabel2, c);
    	add(titlePanel);
    	
    	
    	//add(nameField);
    	//add(submitButton);
    	
    	
    }
    
    public void paint(Graphics g) 
    { 
    	super.paint(g);

    	g.setColor(Color.blue);
    	String nameString = "Welcome!!!!!";
    	if(nameEntered)
    		nameString = "Welcome, " + nameField.getText() + "!";

    	g.setFont(new Font("Verdana", 1, 20));
    	g.drawString(nameString, 280,200);
    	g.drawImage(welcomePage.titleTextImg, 0 , 0, this);
    	g.drawImage(welcomePage.titleImg, 200, 300, this);

    }
    
	class nameButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			welcomePage.setUserName(nameField.getText());
			nameEntered = true;
			welcomePage.loadFirstPage();
			repaint();
			
		}
	}
	


}
