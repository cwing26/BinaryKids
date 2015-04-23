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

    JPanel titlePanel;
    JLabel titleLabel;
    JButton animationButton;

    //components of animation
    String one = "1";
    String three = "3";
    String two = "2";
    
    String hundredsPlace = "Hundreds Place";
    String tensPlace = "Tens Place";
    String onesPlace = "Ones Place";
    
    String hundredsMultiplication = "100 x 1";
    String hundredsMultiplicationAnswer = "100 x 1 = 100";
    
    String tensMultiplication = "10 x 3";
    String tensMultiplicationAnswer = "10 x 3 = 30";
    
    String onesMultiplication = "1 x 2";
    String onesMultiplicationAnswer = "1 x 2 = 2";
    
    String explanation = "Decimal numbers can have many digits.";
    
	private Timer timer;
	private int DELAY = 2000;
	int countAnimation = 0;
	
    
    private WelcomePage welcomePage;
    
    public DemoPage(WelcomePage welcome)
    {
    	welcomePage = welcome;
    	timer = new Timer(DELAY, this);
    	setBackground(WelcomePage.backgroundColor);
    	
    	initTitlePanel();
    	initButtons();

    	add(titlePanel);
    	add(animationButton);
    	
    	
    	setVisible(true);

    }
    
    public void initTitlePanel()
    {
    	titlePanel = new JPanel();
    	titleLabel = new JLabel("Binary numbers vs. decimal numbers");
    	titleLabel.setFont(new Font("Verdana",1,20));
    	titlePanel.add(titleLabel);
    	titlePanel.setBorder(new LineBorder(Color.BLACK));    
    	titlePanel.setBackground(new Color(200,40,160));
    }
    
    public void initButtons()
    {
    	animationButton = new JButton("Click to learn more!");
    	animationButton.addActionListener(new animationButtonListener());
    }
    
    
    public void paint(Graphics g)
    {
    	super.paint(g);
    	
    	g.setFont(new Font("Verdana", 1, 20));
    	g.drawString(explanation, 20, 100);
    	
    	
    	if(countAnimation == 1)
    	{	
    		g.setColor(Color.black);
    		g.setFont(new Font("Verdana", 1, 150));
        	g.drawString(one, 200, 300);
        	g.drawString(three, 350, 300);
        	g.drawString(two, 500, 300);
    	}
    	else if(countAnimation == 2)
    	{		
    		g.setColor(Color.black);
    		g.setFont(new Font("Verdana", 1, 150));
        	g.drawString(one, 200, 300);
        	g.drawString(three, 350, 300);
        	g.drawString(two, 500, 300);
        	g.setColor(Color.red);
        	g.drawRect(198, 175, 110, 150);
        	
    	}
    	else if(countAnimation == 3)
    	{		
    		g.setColor(Color.black);
    		g.setFont(new Font("Verdana", 1, 150));
        	g.drawString(one, 200, 300);
        	g.drawString(three, 350, 300);
        	g.drawString(two, 500, 300);
        	g.setColor(Color.red);
        	g.drawRect(198, 175, 110, 150);
        	g.setColor(Color.blue);
        	g.setFont(new Font("Verdana", 1, 16));
        	g.drawString(hundredsPlace, 190, 165);
        	
    	}
    	else if(countAnimation == 4)
    	{		
    		g.setColor(Color.black);
    		g.setFont(new Font("Verdana", 1, 150));
        	g.drawString(one, 200, 300);
        	g.drawString(three, 350, 300);
        	g.drawString(two, 500, 300);
        	g.setColor(Color.red);
        	g.drawRect(198, 175, 110, 150);
        	
        	g.setColor(Color.blue);
        	g.setFont(new Font("Verdana", 1, 16));
        	g.drawString(hundredsPlace, 190, 165);
        	g.drawString(hundredsMultiplication, 215, 345);
        	
        	g.setColor(Color.black);
        	g.setFont(new Font("Verdana", 1, 20));
        	g.drawString(hundredsMultiplicationAnswer, 615, 200);

    	}
    	else if(countAnimation == 5)
    	{		
    		g.setColor(Color.black);
    		g.setFont(new Font("Verdana", 1, 150));
        	g.drawString(one, 200, 300);
        	g.drawString(three, 350, 300);
        	g.drawString(two, 500, 300);
        	g.setColor(Color.red);
        	g.drawRect(348, 175, 110, 150);
        	
        	g.setColor(Color.black);
        	g.setFont(new Font("Verdana", 1, 20));
        	g.drawString(hundredsMultiplicationAnswer, 615, 200);

    	}
    	else if(countAnimation == 6)
    	{		
    		g.setColor(Color.black);
    		g.setFont(new Font("Verdana", 1, 150));
        	g.drawString(one, 200, 300);
        	g.drawString(three, 350, 300);
        	g.drawString(two, 500, 300);
        	g.setColor(Color.red);
        	g.drawRect(348, 175, 110, 150);
        	
        	g.setColor(Color.blue);
        	g.setFont(new Font("Verdana", 1, 16));
        	g.drawString(tensPlace, 340, 165);
        	
        	g.setColor(Color.black);
        	g.setFont(new Font("Verdana", 1, 20));
        	g.drawString(hundredsMultiplicationAnswer, 615, 200);

    	}
    	else if(countAnimation == 7)
    	{		
    		g.setColor(Color.black);
    		g.setFont(new Font("Verdana", 1, 150));
        	g.drawString(one, 200, 300);
        	g.drawString(three, 350, 300);
        	g.drawString(two, 500, 300);
        	g.setColor(Color.red);
        	g.drawRect(348, 175, 110, 150);
        	
        	g.setColor(Color.blue);
        	g.setFont(new Font("Verdana", 1, 16));
        	g.drawString(tensPlace, 340, 165);
        	g.drawString(tensMultiplication, 350, 345);
        	
        	g.setColor(Color.black);
        	g.setFont(new Font("Verdana", 1, 20));
        	g.drawString(hundredsMultiplicationAnswer, 615, 200);
        	g.drawString(tensMultiplicationAnswer, 615, 240);

    	}
    	else if(countAnimation == 8)
    	{		
    		g.setColor(Color.black);
    		g.setFont(new Font("Verdana", 1, 150));
        	g.drawString(one, 200, 300);
        	g.drawString(three, 350, 300);
        	g.drawString(two, 500, 300);
        	g.setColor(Color.red);
        	g.drawRect(500, 175, 110, 150);

        	g.setColor(Color.black);
        	g.setFont(new Font("Verdana", 1, 20));
        	g.drawString(hundredsMultiplicationAnswer, 615, 200);
        	g.drawString(tensMultiplicationAnswer, 615, 240);

    	}
    	else if(countAnimation == 9)
    	{		
    		g.setColor(Color.black);
    		g.setFont(new Font("Verdana", 1, 150));
        	g.drawString(one, 200, 300);
        	g.drawString(three, 350, 300);
        	g.drawString(two, 500, 300);
        	g.setColor(Color.red);
        	g.drawRect(500, 175, 110, 150);
        	
        	g.setColor(Color.blue);
        	g.setFont(new Font("Verdana", 1, 16));
        	g.drawString(onesPlace, 500, 165);
        	
        	g.setColor(Color.black);
        	g.setFont(new Font("Verdana", 1, 20));
        	g.drawString(hundredsMultiplicationAnswer, 615, 200);
        	g.drawString(tensMultiplicationAnswer, 615, 240);

    	}
    	else if(countAnimation == 10)
    	{		
    		g.setColor(Color.black);
    		g.setFont(new Font("Verdana", 1, 150));
        	g.drawString(one, 200, 300);
        	g.drawString(three, 350, 300);
        	g.drawString(two, 500, 300);
        	g.setColor(Color.red);
        	g.drawRect(500, 175, 110, 150);

        	g.setColor(Color.blue);
        	g.setFont(new Font("Verdana", 1, 16));
        	g.drawString(onesPlace, 500, 165);
        	g.drawString(onesMultiplication, 500, 345);
        	
        	g.setColor(Color.black);
        	g.setFont(new Font("Verdana", 1, 20));
        	g.drawString(hundredsMultiplicationAnswer, 615, 200);
        	g.drawString(tensMultiplicationAnswer, 615, 240);
        	g.drawString(onesMultiplicationAnswer, 615, 280);
        	

    	}
    	else if(countAnimation == 11)
    	{		
    		g.setColor(Color.black);
    		g.setFont(new Font("Verdana", 1, 150));
        	g.drawString(one, 200, 300);
        	g.drawString(three, 350, 300);
        	g.drawString(two, 500, 300);

        	
        	g.setColor(Color.black);
        	g.setFont(new Font("Verdana", 1, 20));
        	g.drawString(hundredsMultiplicationAnswer, 615, 200);
        	g.drawString(tensMultiplicationAnswer, 615, 240);
        	g.drawString(onesMultiplicationAnswer, 615, 280);
        	
        	g.setColor(Color.blue);
        	g.drawString("Sum : 132", 615, 320);

    	}
    		

    		
    }
    
	@Override
    public void actionPerformed(ActionEvent e) 
	{
		
		if(countAnimation < 12)
		{	
			countAnimation++;
		}
		else
			timer.stop();
		
        repaint();
    }
	
	class animationButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent le) 
		{  

			animationButton.setVisible(false);
			timer.start();
			repaint();
		} 
	}
    

}
