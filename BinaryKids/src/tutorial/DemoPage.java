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

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.Timer;
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

//explains the places/digits with an animation
//decimal numbers can have many digits
//show: 132 (3 different strings)
//1. hundreds place: light up, rectangle around it, label with hundreds place
//2. 100x1 = 100 under hundreds place, 100x1 on side of page


public class DemoPage extends JPanel implements ActionListener
{

    //images
	private Image titleImage;
	
	String explanation1 = "Counting with decimal numbers and binary numbers is the same!";
	String explanation1cont = "Just add the sum of all digits based on what place they are.";
	
	String explanation2 = "Let's do an example where we count to 45 in decimal and binary:";
	
	
	//components of first decimal animation
	String four = "4";
    String five = "5";
    
    String tensPlace = "Tens Place";
    String onesPlace = "Ones Place";
    
    String tensMultiplication = "10 x 4";
    String tensMultiplicationAnswer = "40";
    
    String onesMultiplication = "1 x 5";
    String onesMultiplicationAnswer = "5";
    
    String plusSign = "+";
    String equalSign = "=";
    
	private Timer timer;
	private int DELAY = 3000;
	int countAnimation = 0;
	
    
    private WelcomePage welcomePage;
    
    public DemoPage(WelcomePage welcome)
    {
    	welcomePage = welcome;
    	timer = new Timer(DELAY, this);
    	setBackground(WelcomePage.backgroundColor);
    	
    	loadImages();

    	setVisible(true);
    	
    	timer.start();
    	

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
    	
    	g.drawImage(titleImage, 50, 5, this);
    	
    	g.setFont(new Font("Geneva", 1, 20));
    	g.drawString(explanation1, 20, 100);
    	g.drawString(explanation1cont, 20, 125);
    	
    	g.drawString(explanation2, 20, 160);
    	
    	if(countAnimation == 0)
    	{	
    		g.setColor(Color.black);
    		g.setFont(new Font("Geneva", 1, 150));
        	g.drawString(four, 240, 330);
        	g.drawString(five, 350, 330);
        	
        	g.setColor(welcomePage.textColor);
        	g.setFont(new Font("Geneva", 1, 20));
        	g.drawString(tensPlace, 230, 370);
        	g.drawString(onesPlace, 355, 370);
        	
    	}
    	else if(countAnimation == 1)
    	{	
    		g.setColor(Color.black);
    		g.setFont(new Font("Geneva", 1, 150));
        	g.drawString(four, 240, 330);
        	g.drawString(five, 350, 330);
        	
        	g.setColor(Color.red);
        	g.drawRect(230, 195, 110, 150);
        	
        	g.setColor(welcomePage.textColor);
        	g.setFont(new Font("Geneva", 1, 20));
        	g.drawString(tensPlace, 230, 370);
        	g.drawString(onesPlace, 355, 370);
        	
        	
        	g.drawString(tensMultiplication, 240, 400);
        	
        	g.setColor(welcomePage.buttonPanelColor);
        	g.setFont(new Font("Geneva", 1, 30));
        	g.drawString(tensMultiplicationAnswer, 250, 440);
        	
    	}
    	else if(countAnimation == 2)
    	{	
    		g.setColor(Color.black);
    		g.setFont(new Font("Geneva", 1, 150));
        	g.drawString(four, 240, 330);
        	g.drawString(five, 350, 330);
        	
        	g.setColor(Color.red);
        	g.drawRect(345, 195, 110, 150);
        	
        	g.setColor(welcomePage.textColor);
        	g.setFont(new Font("Geneva", 1, 20));
        	g.drawString(tensPlace, 230, 370);
        	g.drawString(onesPlace, 355, 370);
        	
        	
        	g.drawString(onesMultiplication, 365, 400);
        	g.drawString(tensMultiplication, 240, 400);
        	
        	g.setColor(welcomePage.buttonPanelColor);
        	g.setFont(new Font("Geneva", 1, 30));
        	g.drawString(tensMultiplicationAnswer, 250, 440);
        	g.drawString(onesMultiplicationAnswer, 375, 440);
        
        	
    	}
    	else if(countAnimation == 3)
    	{	
    		g.setColor(Color.black);
    		g.setFont(new Font("Geneva", 1, 150));
        	g.drawString(four, 240, 330);
        	g.drawString(five, 350, 330);
        	
        	
        	g.setColor(welcomePage.textColor);
        	g.setFont(new Font("Geneva", 1, 20));
        	g.drawString(tensPlace, 230, 370);
        	g.drawString(onesPlace, 355, 370);
        	
        	
        	g.drawString(tensMultiplication, 240, 400);
        	g.drawString(onesMultiplication, 365, 400);
        	
        	g.setColor(welcomePage.buttonPanelColor);
        	g.setFont(new Font("Geneva", 1, 30));
        	g.drawString(tensMultiplicationAnswer, 250, 440);
        	g.drawString(onesMultiplicationAnswer, 375, 440);
        	
        	
        	g.setColor(welcomePage.textColor);
        	g.drawString(plusSign, 320, 440);

        	
    	}
    	else if(countAnimation >= 4)
    	{	
    		g.setColor(Color.black);
    		g.setFont(new Font("Geneva", 1, 150));
        	g.drawString(four, 240, 330);
        	g.drawString(five, 350, 330);
        	
        	
        	g.setColor(welcomePage.textColor);
        	g.setFont(new Font("Geneva", 1, 20));
        	g.drawString(tensPlace, 230, 370);
        	g.drawString(onesPlace, 355, 370);
        	
        	
        	g.drawString(tensMultiplication, 240, 400);
        	g.drawString(onesMultiplication, 365, 400);
        	
        	g.setColor(welcomePage.buttonPanelColor);
        	g.setFont(new Font("Geneva", 1, 30));
        	g.drawString(tensMultiplicationAnswer, 250, 440);
        	g.drawString(onesMultiplicationAnswer, 375, 440);
        	
        	
        	g.setColor(welcomePage.textColor);
        	g.drawString(plusSign, 320, 440);
        	
        	g.drawString(equalSign, 480, 440);
        	
        	g.setColor(welcomePage.buttonPanelColor);
        	g.drawString("45", 510, 440);
        	
    	}
    	
    } //end paint
    	
    
	@Override
    public void actionPerformed(ActionEvent e) 
	{
		
		if(countAnimation < 5)
		{	
			countAnimation++;
		}
		else
			timer.stop();
		
        repaint();
    }
	


}
