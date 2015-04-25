package tutorial;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import java.awt.*; 
import java.applet.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Image;
import java.awt.TextField;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;
import java.net.URL;


public class StartPage extends JPanel
{
	//gui components
	JButton submitButton;
	JTextField nameField;
	
	//page directions
	String directions = "This applet will teach you about binary numbers.";
	String directions2 = "Then you can play a fun game with the skills you've learned!";
	
	
	private WelcomePage welcomePage; //to connect welcome page to individual pages 
    
	//initializes all gui components on the page
	public void initComponents()
	{
    	submitButton = new JButton("Submit");
    	submitButton.addActionListener(new nameButtonListener());
    	
    	nameField = new JTextField("Enter your name");
    	nameField.setColumns(15);
    	nameField.setFont(new Font("Geneva", 1 , 18));
    	
	}
	
	
    public StartPage(WelcomePage welcome)
    {
    	welcomePage = welcome;

    	setBackground(WelcomePage.backgroundColor);
    	
    	initComponents();
		
    	setLayout(null);
    	add(nameField);
    	add(submitButton);
    	
    	
    	Insets insets = getInsets();
		Dimension textFieldSize = nameField.getPreferredSize();
		nameField.setBounds(80 + insets.left, 150 + insets.top,
	            textFieldSize.width, textFieldSize.height);
		
		Dimension buttonSize = submitButton.getPreferredSize();
		submitButton.setBounds(80 + insets.left, 190 + insets.top, buttonSize.width, buttonSize.height);
		

    	
    	
    }
    
    public void paint(Graphics g) 
    { 
    	super.paint(g);
    	g.drawImage(welcomePage.titleHeadline, 100, 10, this);
    	
    	//directions 
    	g.setFont(new Font("Geneva", 1 , 20));
    	g.drawString(directions, 50, 100);
    	g.drawString(directions2, 50, 125);
    	
    	g.drawImage(welcomePage.binaryGraphic, 1, 400, this);
    	g.drawImage(welcomePage.binaryGraphic, 201, 400, this);
    	g.drawImage(welcomePage.binaryGraphic, 401, 400, this);
    	g.drawImage(welcomePage.binaryGraphic, 601, 400, this);
    	

    }
    
	class nameButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			welcomePage.setUserName(nameField.getText());
			welcomePage.loadFirstPage();
			repaint();
			
		}
	}
	


}
