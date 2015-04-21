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
import java.awt.event.MouseEvent;

import javax.swing.JPanel;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
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
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Image;
import java.awt.TextField;
import java.awt.Toolkit;


public class BinaryDecimalFour extends JPanel
{	
	WelcomePage welcomePage;

	
	JButton submitButton;
	
    
    public BinaryDecimalFour(WelcomePage welcome)
    {
    	welcomePage = welcome;

    	
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


