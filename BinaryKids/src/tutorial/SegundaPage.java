


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
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Insets;
import java.awt.RenderingHints;
import java.awt.Image;
import java.awt.TextField;
import java.awt.Toolkit;


public class SegundaPage extends JPanel implements ActionListener
{
    
	private Timer timer;
	private int DELAY = 2000;
	int countAnimation = 0;
	
	//images
	public Image titleImage;
	public Image instagramImage;
	public Image fbImage;
	public Image emailImage;
	public Image youtubeImage;
	public Image skypeImage;
	public Image cellImage;
	public Image gameImage;
	public Image lightOff;
	public Image lightOn;
	
    private WelcomePage welcomePage;
    
    String explanation1 = "Actually, none of these would exist without binary numbers!";
    
    String explanation2 = "Electronics and technology use binary numbers, ";
    String explanation2cont = "streams of 1s and 0s, to operate.";
    String explanation3 = "At the most basic level,";
    String explanation4 = "1 means ON and 0 means OFF";

    //components for number conversion
	String binaryNum = "110110";
	String decimalNum = " 54 ";
	String displayNum = "54";
	boolean decimal = false;
	JLabel convertLabel;
	
	//components for on off switch
	JButton oneButton;
	JButton zeroButton;
	boolean oneClicked = false;
	
    //clikc button to be on and off 
    //example click button and have it change binary to decimal
    
    
    public SegundaPage(WelcomePage welcome)
    {
    	welcomePage = welcome;
    	setLayout(null);
    	
    	loadImages();
    	loadComponents();
    	
    	timer = new Timer(DELAY, this);
    	setBackground(WelcomePage.backgroundColor);
    	
    	add(convertLabel);
    	add(zeroButton);
    	add(oneButton);
    	
    	Insets insets = getInsets();
		Dimension labelSize = convertLabel.getPreferredSize();
		convertLabel.setBounds(440 + insets.left, 260 + insets.top, labelSize.width + 20, labelSize.height);
		
		Dimension button0Size = zeroButton.getPreferredSize();
		zeroButton.setBounds(200 + insets.left, 440 + insets.top, button0Size.width, button0Size.height);
		
		Dimension button1Size = oneButton.getPreferredSize();
		oneButton.setBounds(200 + insets.left, 490 + insets.top, button1Size.width, button1Size.height);
		
		
    	setVisible(true);

    }
    
    public void paint(Graphics g)
    {
    	super.paint(g);
    	
    	g.drawImage(titleImage, 5, 5, this);
    	
    	g.setColor(Color.black);
    	g.setFont(new Font("Geneva", 1, 20));
    	g.drawString(explanation1, 30, 80);
    	
    	g.drawImage(instagramImage, 20, 100, this);
    	g.drawImage(fbImage, 125, 100, this);
    	g.drawImage(youtubeImage, 230, 100, this);
    	g.drawImage(emailImage, 335, 100, this);
    	g.drawImage(cellImage, 440, 100, this);
    	g.drawImage(gameImage, 545, 100, this);
    	g.drawImage(skypeImage, 650, 100, this);
    	
    	
    	g.setFont(new Font("Geneva", 1, 25));
    	g.drawString(explanation2, 30, 220);
    	g.drawString(explanation2cont, 30, 250);
    	
    	g.drawString(explanation3, 30, 360);
    	g.drawString(explanation4, 30, 390);
    	
    	g.setFont(new Font("Geneva", 1, 15));
    	g.drawString("Click number to convert!", 457, 324);
    	
    	g.setFont(new Font("Geneva", 1, 15));
    	g.drawString("Click the buttons to see how binary numbers send signals!", 30, 425);
    	
    	if(oneClicked)
		{
			g.drawImage(lightOn, 460, 370, this);
		}
		else
		{
			g.drawImage(lightOff, 460, 370, this);
		}
    		
    }
    
    public void loadImages()
    {
    	titleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.whyBinaryImportantTitlePath)); 
		titleImage = titleImage.getScaledInstance(790, 43, Image.SCALE_SMOOTH);
		
		
		instagramImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.instagramPath)); 
		instagramImage = instagramImage.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		
		fbImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.fbPath)); 
		fbImage = fbImage.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		
		youtubeImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.youtubePath)); 
		youtubeImage = youtubeImage.getScaledInstance(95, 96, Image.SCALE_SMOOTH);
		
		emailImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.emailPath)); 
		emailImage = emailImage.getScaledInstance(95, 69, Image.SCALE_SMOOTH);
		
		cellImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.cellPath)); 
		cellImage = cellImage.getScaledInstance(92, 92, Image.SCALE_SMOOTH);
		
		skypeImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.skypePath)); 
		skypeImage = skypeImage.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		
		gameImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.gamePath)); 
		gameImage = gameImage.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		
		lightOff = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.lightOffPath)); 
		lightOff = lightOff.getScaledInstance(145, 200, Image.SCALE_SMOOTH);
		
		lightOn = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.lightOnPath)); 
		lightOn = lightOn.getScaledInstance(148, 200, Image.SCALE_SMOOTH);
		
		

    }
    
    public void loadComponents()
    {
		convertLabel = new JLabel();
		convertLabel.setBackground(welcomePage.backgroundColor);
		convertLabel.setFont(new Font("Monospaced", 1, 60));
		convertLabel.setForeground(welcomePage.buttonPanelColor);
		convertLabel.setText(binaryNum);
		
		convertLabel.addMouseListener(new MouseListener() 
		{      

			@Override
			public void mouseClicked(MouseEvent arg0) 
			{
				if(decimal == true) //need to convert to binary
				{
					convertLabel.setText(binaryNum);
					decimal = false;
					
				}
				else //need to convert to decimal
				{
					convertLabel.setText(decimalNum);
					decimal = true;
				}
				
				repaint();
				
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseExited(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mousePressed(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}

			@Override
			public void mouseReleased(MouseEvent arg0) {
				// TODO Auto-generated method stub
				
			}      
		}); 
		
		
		oneButton = new JButton("1");
    	oneButton.addActionListener(new ActionListener() 
		{      
			public void actionPerformed(ActionEvent e) 
			{  
				//change image to light on
				oneClicked = true;
				repaint();
			}      
		}); 
    	
    	zeroButton = new JButton("0");
    	zeroButton.addActionListener(new ActionListener() 
		{      
			public void actionPerformed(ActionEvent e) 
			{  
				//change image to light of
				oneClicked = false;
				repaint();
			}      
		}); 
    	
		
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
	
    

}
