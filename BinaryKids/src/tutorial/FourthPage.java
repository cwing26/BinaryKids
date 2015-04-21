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

    	JPanel titlePanel = new JPanel();
    	JLabel titleLabel = new JLabel("What would you like to learn first??");
    	titleLabel.setFont(new Font("Verdana",1,20));
    	titlePanel.add(titleLabel);
    	titlePanel.setBorder(new LineBorder(Color.BLACK));     	
    	add(titlePanel);

    	decBinButton = new JButton("Decimal to Binary");
    	binDecButton = new JButton("Binary to Decimal");
    	binAddButton = new JButton("Binary Addition");
    	binSubButton = new JButton("Binary Subtraction");
    	
    	decBinButton.addActionListener(new tutorialButtonListener());
    	binDecButton.addActionListener(new tutorialButtonListener());
    	binAddButton.addActionListener(new tutorialButtonListener());
    	binSubButton.addActionListener(new tutorialButtonListener());
    	
    	add(decBinButton);
    	add(binDecButton);
    	add(binAddButton);
    	add(binSubButton);
    	
    	setVisible(true);

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
			else if(e.getSource() == binAddButton)
			{
				welcomePage.tutorialFlag = 3;
			}
			else if(e.getSource() == binSubButton)
			{
				welcomePage.tutorialFlag = 4;
			}
			else
			{
				welcomePage.tutorialFlag = 0;
			}
			
				
		} //end action performed
	} //end button listener

} //end class thirdpage



