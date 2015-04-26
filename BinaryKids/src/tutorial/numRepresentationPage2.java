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
import java.net.MalformedURLException;
import java.net.URL;

/*
3.	representations of numbers (decimal, roman numeral, blocks) how theyre used
4.	one system of numbers you might not be familiar with is binary, which we’re going to teach you
*/

public class numRepresentationPage2 extends JPanel
{

	public Image titleImage;
	public Image dogImage;
	public Image bikeImage;
	public Image binocImage;
	
	private Timer timer;
	private int DELAY = 1000;
	
	String explanation1 = "Binary numbers are used to count things, just like normal numbers! ";
	String explanation2 = "But binary numbers are made up of only 0s or 1s";
	String explanation3 = "The word 'Binary' comes from the root 'bi-' meaning 2.";
	
	String bike = "Bicycle";
	String bike1 = "(2 wheels)";
	String binoculars = "Binoculars";
	String binoculars2 = "(2 eyes)";
	
	
	private WelcomePage welcomePage; //to connect welcome page to individual pages 
			
    
    public numRepresentationPage2(WelcomePage welcome)
    {
    	welcomePage = welcome;

    	setBackground(WelcomePage.backgroundColor);
    	
    	loadImages();
    	
    	
    	setVisible(true);
    }
    
    public void paint(Graphics g) 
    { 
    	super.paint(g);
    	
    	g.drawImage(titleImage, 45, 10, this);
    	
    	g.setFont(new Font("Geneva", 1, 20));
    	g.drawString(explanation1, 40, 100);
    	g.drawString(explanation2, 295, 200);
    	g.drawString(explanation3, 40, 400);
    	
    	g.setColor(welcomePage.buttonPanelColor);
    	g.setFont(new Font("Geneva", 1, 15));
    	
    	g.drawString(bike, 100, 435);
    	g.drawString(bike1, 100, 455);
    	g.drawString(binoculars, 450, 435);
    	g.drawString(binoculars2, 450, 455);
    	
    	g.drawImage(dogImage, 120, 125, this);
    	g.drawImage(bikeImage, 150, 430, this );
    	g.drawImage(binocImage, 500, 415, this );
    	


    }
    
    
    public void loadImages()
    {
		titleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.whatBinaryTitlePath)); 
		titleImage = titleImage.getScaledInstance(673, 50, Image.SCALE_SMOOTH);
		
		dogImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.dogBinaryImagePath)); 
		dogImage = dogImage.getScaledInstance(121, 224, Image.SCALE_SMOOTH);
		
		bikeImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.bikeImagePath)); 
		bikeImage = bikeImage.getScaledInstance(192, 124, Image.SCALE_SMOOTH);
		
		binocImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.binocularsPath)); 
		binocImage = binocImage.getScaledInstance(166, 159, Image.SCALE_SMOOTH);
	
		
    }


}
