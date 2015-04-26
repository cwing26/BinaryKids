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
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
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
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Image;
import java.awt.TextField;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;

/*
3.	representations of numbers (decimal, roman numeral, blocks) how theyre used
4.	one system of numbers you might not be familiar with is binary, which we’re going to teach you
*/

public class numRepresentationPage extends JPanel implements ActionListener
{

	String userName = "";
	String question = "How many soccer balls are there?";
	int soccerBallX = 30;
	
	public Image numRepTitleImage;
	public Image decimalTitleImage;
	public Image romanNumeralTitleImage;
	public Image shapesTitleImage;
	public Image binaryImageLight;
	public Image binaryImageDark;
	public Image soccerBall;
	
	int rectSize = 25;
	int rectX = 40;
	int rectY = 200;
	
	private WelcomePage welcomePage; //to connect welcome page to individual pages 
			
	private Timer timer;
	private int DELAY = 2000;
	int countAnimation = 0;

    public numRepresentationPage(WelcomePage welcome)
    {
    	
    	welcomePage = welcome;
    	userName = welcomePage.getUserName();
    	setBackground(WelcomePage.backgroundColor);
    	timer = new Timer(DELAY, this);
    	
    	loadImages();

    	
    	setVisible(true);
    	
    	timer.start();
    }
    
    public void paint(Graphics g) 
    { 
    	super.paint(g);
    	
    	g.drawImage(numRepTitleImage, 5, 10, this);
    	
    	
    	if(countAnimation == 1)
    	{
    		g.setFont(new Font("Geneva", 1, 25));
    		g.drawString(question, 40, 150);
    		
    		for(int i = 0; i < 6; i ++)
    		{
    			//g.drawImage(soccerBall, soccerBallX, 250, this);	
    			g.setColor(welcomePage.buttonPanelColor);
    			g.fillOval(soccerBallX, 250, 50, 50);
    			soccerBallX = soccerBallX + 100;
    		}
    		
    	}
    	
    	else if(countAnimation == 2)
    	{
	    	g.setColor(welcomePage.buttonPanelColor);
	    	g.setColor(Color.black);
	    	rectX = 350;
	    	for(int i = 0; i < 6; i++)
	    	{
	    		
	    		g.fillRect(rectX, 310, rectSize, rectSize);
	    		rectX = rectX + 50;
	    		
	    	}
	
	    	g.drawImage(decimalTitleImage, 40, 100, this);
	    	g.drawImage(romanNumeralTitleImage, 40, 200, this);
	    	g.drawImage(shapesTitleImage, 40, 300, this);
    		g.drawImage(binaryImageLight, 40, 450, this);

	    	g.setColor(welcomePage.textColor);
	    	g.setFont(new Font("Monospaced", 1, 60));
	    	g.drawString("6", 560, 140);
	    	g.drawString("VI", 545, 240);
	    	g.drawString("110", 535, 490);
    	
    	
    	}
  	    else if(countAnimation > 2)
  	    {
  	    	g.drawImage(binaryImageDark, 40, 450, this);
  	    	g.setColor(welcomePage.textColor);
  	    	g.drawRect(30, 435, 650, 80);
  	    	g.setFont(new Font("Monospaced", 1, 60));
  	    	g.drawString("=", 560, 415);
  	    	
	    	g.setColor(welcomePage.buttonPanelColor);
	    	g.setColor(Color.black);
	    	rectX = 350;
	    	for(int i = 0; i < 6; i++)
	    	{
	    		
	    		g.fillRect(rectX, 310, rectSize, rectSize);
	    		rectX = rectX + 50;
	    		
	    	}

	    	g.drawImage(decimalTitleImage, 40, 100, this);
	    	g.drawImage(romanNumeralTitleImage, 40, 200, this);
	    	g.drawImage(shapesTitleImage, 40, 300, this);

	    	g.setColor(welcomePage.textColor);
	    	g.setFont(new Font("Monospaced", 1, 60));
	    	g.drawString("6", 560, 140);
	    	g.drawString("VI", 545, 240);
	    	g.drawString("110", 535, 490);
	    		
  	    }
	
    }
    
    
    public void loadImages()
    {
		
		binaryImageLight = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.binaryImageLightPath)); 
		binaryImageLight = binaryImageLight.getScaledInstance(354, 44, Image.SCALE_SMOOTH);
		
		binaryImageDark = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.binaryImageDarkPath)); 
		binaryImageDark = binaryImageDark.getScaledInstance(354, 44, Image.SCALE_SMOOTH);
		
		numRepTitleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.numRepTitlePath)); 
		numRepTitleImage = numRepTitleImage.getScaledInstance(780, 44, Image.SCALE_SMOOTH);
		
		decimalTitleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.decimalImagePath)); 
		decimalTitleImage = decimalTitleImage.getScaledInstance(444, 40, Image.SCALE_SMOOTH);
		
		romanNumeralTitleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.romanNumeralImagePath)); 
		romanNumeralTitleImage = romanNumeralTitleImage.getScaledInstance(435, 40, Image.SCALE_SMOOTH);
		
		shapesTitleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.shapesImagePath)); 
		shapesTitleImage = shapesTitleImage.getScaledInstance(164, 48, Image.SCALE_SMOOTH);
		
		soccerBall = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.soccerBallPath)); 
		soccerBall = soccerBall.getScaledInstance(150, 151, Image.SCALE_SMOOTH);
		
		
    }
    
	@Override
    public void actionPerformed(ActionEvent e) 
	{
		
		if(countAnimation < 10)
		{	
			countAnimation++;
		}
		else
			timer.stop();
		
        repaint();
    }


}
