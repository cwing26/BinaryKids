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


public class SecondPage extends JPanel implements ActionListener
{
    String userName = "";
    String answer = "";
    JPanel titlePanel;
    JLabel titleLabel;
    JPanel answerPanel;
    JButton animationButton;
    
    String explanation1 = "None of these would be possible without binary numbers! ";
    String explanation2 = "The word binary comes from 'Bi- meaning two.";
    JLabel label2;
    String explanation3 = "We see 'bi-' in words such as 'bicycle (two wheels) ";
    JLabel label3;
    String explanation4 = "or binocular (two eyes).";
    JLabel label4;
    
	private Timer timer;
	private int DELAY = 2000;
	int countAnimation = 0;
	
    boolean animationButtonClicked = false;
    
    private WelcomePage welcomePage;
    
    public SecondPage(WelcomePage welcome)
    {
    	welcomePage = welcome;
    	userName = welcomePage.getUserName();
    	answer = welcomePage.getUserAnswer();

    	timer = new Timer(DELAY, this);
    	label2 = new JLabel(explanation2);
    	label3 = new JLabel(explanation3);
    	label4 = new JLabel(explanation4);
    	
    	
    	//setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    	//setLayout(new GridLayout(4,1));
    	
    	setBackground(WelcomePage.backgroundColor);
    	
    	titlePanel = new JPanel();
    	titleLabel = new JLabel("Welcome to binarykids!");
    	titleLabel.setFont(new Font("Verdana",1,20));
    	titlePanel.add(titleLabel);
    	titlePanel.setBorder(new LineBorder(Color.BLACK));    
    	titlePanel.setBackground(new Color(200,40,160));
    	add(titlePanel);
    	
    	animationButton = new JButton("Click to learn more!");
    	animationButton.addActionListener(new animationButtonListener());
    	
    	JLabel answerLabel = new JLabel("How do you use computers?");
    	answerLabel.setFont(new Font("Verdana", 1, 15));
    	
    	answerPanel = new JPanel();
    	JLabel answerLab = new JLabel(answer);
    	answerLab.setFont(new Font("Verdana", 1, 13));
    	answerPanel.setBorder(new LineBorder(Color.green)); 
    	answerPanel.add(answerLabel);
    	answerPanel.setVisible(true);
    	//answerPanel.add(answerLab);
    	//answerPanel.add(label2);
    	//answerPanel.add(label3);
    	//answerPanel.add(label4);
    	//label2.setVisible(false);
    	//label3.setVisible(false);
    	//label4.setVisible(false);
    	
    	add(answerPanel);
    	add(animationButton);
    	setVisible(true);

    }
    
    public void paint(Graphics g)
    {
    	super.paint(g);
    	    	
    	
    	if(animationButtonClicked == false)
    	{	
    		g.setFont(new Font("Monospaced", 1, 40));
        	g.drawString(answer, 200, 100);
        	
    		g.setFont(new Font("Verdana", 1, 20));
    		g.drawString(explanation1, 20, 400);
    	}
    	
    	g.setFont(new Font("Verdana", 1, 15));
    		if(countAnimation == 1)
    		{
    			
    			g.drawString(explanation2, 10, 100);
    		}
    		else if(countAnimation == 2)
    		{
    			
    			g.drawString(explanation2, 10, 100);
    			g.drawString(explanation3, 20, 250);
    			//also images!
    		}
    		else if(countAnimation == 3)
    		{
    			
    			g.drawString(explanation2, 10, 100);
    			g.drawString(explanation3, 20, 250);
    			g.drawString(explanation4, 100, 270);
    			g.setColor(Color.blue);
    			g.fillOval(40, 310, 100, 100);
    			g.fillOval(300, 310, 100, 100);
    			//also images!
    		}
    		

    		
    }
    
	@Override
    public void actionPerformed(ActionEvent e) 
	{
		
		if(countAnimation < 3)
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

			animationButtonClicked = true;
			animationButton.setVisible(false);
			answerPanel.setVisible(false);
			timer.start();
			repaint();
		} 
	}
    

}
