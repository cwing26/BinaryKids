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


public class BinaryAddOne extends JPanel
{	
	WelcomePage welcomePage;
	
	BinaryDecimalTwo bdTwo;
	
	JButton submitButton;
	TextField answerField;

	final int correctAnswer = 13;
	int inputAnswer = 0;
	
	// Assign values to the rectanagle coordinates. 
	int rect1xco = 20; 
	int rect1yco = 200; 
	int rect1width = 25; 
	int rect1height = 25;
	
	FourthPage fourthPage;
    
    public BinaryAddOne(WelcomePage welcome)
    {
    	welcomePage = welcome;
    	fourthPage = new FourthPage(welcome);
    	bdTwo = new BinaryDecimalTwo(welcome);
    	
    	JPanel titlePanel = new JPanel();
    	JLabel titleLabel = new JLabel("BinaryKids");
    	titleLabel.setFont(new Font("Verdana",1,20));
    	titlePanel.add(titleLabel);
    	titlePanel.setBorder(new LineBorder(Color.BLACK));     	
    	
    	JLabel descriptionLabel = new JLabel("What is 2+2?");
    	descriptionLabel.setFont(new Font("Verdana",1,80));
    	
    	
    	
    	submitButton = new JButton("Submit Answer");
    	answerField = new TextField("Type your answer here");
    	answerField.setSize(200, 200);
    	
    	
    	submitButton.addActionListener(new submitButtonListener());
    	
    	add(titlePanel);
    	add(descriptionLabel);
    	add(answerField);
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
			/*
			welcomePage.getContentPane().remove(welcomePage.bdOne);
			welcomePage.getContentPane().add(bdTwo, BorderLayout.CENTER);
			
			welcomePage.validate();
	        welcomePage.setVisible(true);
	        welcomePage.repaint();
			*/
			
			String input =  answerField.getText();
			inputAnswer = Integer.parseInt(input);
			

			if(inputAnswer == correctAnswer)
			{
				welcomePage.getContentPane().remove(welcomePage.bdOne);
				welcomePage.getContentPane().add(bdTwo, BorderLayout.CENTER);
				
				welcomePage.validate();
		        welcomePage.setVisible(true);
		        welcomePage.repaint();
			}
			else
			{
				//dialog box welcomes user to game and gives them brief instructions
		    	String errorMessage = "Wrong answer, try again!";
		    	JOptionPane.showMessageDialog(welcomePage, errorMessage, "wrong answer", JOptionPane.YES_NO_OPTION);
				
		    	answerField.setText("");
			}
			
			
			//check if answer is right before allowing to proceed to next page
			//if not, then reset text of textfield and say try again, maybe display diaglog box 
			
		} //end action performed
		
		
	} //end button listener

} //end class thirdpage



