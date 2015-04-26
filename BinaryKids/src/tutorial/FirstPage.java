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


public class FirstPage extends JPanel
{
	JButton submitButton;
	JPanel checkPanel;
	
	//check boxes
	JCheckBox skypeCheck;
	JCheckBox gameCheck;
	JCheckBox emailCheck;
	JCheckBox youtubeCheck;
	JCheckBox fbCheck;
	JCheckBox instaCheck;
	JCheckBox cellPhoneCheck;

	
	//booleans to indicate whether checks have been filled
	boolean skype = false;
	boolean game = false;
	boolean email = false;
	boolean youtube = false;
	boolean fb = false;
	boolean instagram = false;
	boolean cellPhone = false;
	
	//images
	public Image titleImage;
	public Image instagramImage;
	public Image fbImage;
	public Image emailImage;
	public Image youtubeImage;
	public Image skypeImage;
	public Image cellImage;
	public Image gameImage;
	
	private WelcomePage welcomePage; //to connect welcome page to individual pages 
    
	String explanation1 = "Binary numbers are important for computers and electronics";
	String question = "How do you use technology?";
	
    public FirstPage(WelcomePage welcome)
    {
    	welcomePage = welcome;
    	setBackground(welcomePage.backgroundColor);
    	
    	initComponents();
    	loadImages();
    	
    	setLayout(null);
    	add(checkPanel);
    	add(submitButton);
    	

    	Insets insets = getInsets();
		Dimension checkPanelSize = checkPanel.getPreferredSize();
		checkPanel.setBounds(100 + insets.left, 150 + insets.top,
	            checkPanelSize.width, checkPanelSize.height);
		
		Dimension buttonSize = submitButton.getPreferredSize();
		submitButton.setBounds(90 + insets.left, 380 + insets.top, buttonSize.width, buttonSize.height);
		

    }
    
    public void initComponents()
    {
    	submitButton = new JButton("Submit Answer");

        //Create the check boxes.
        skypeCheck = new JCheckBox("Skype");
        skypeCheck.setFont(new Font("Geneva", 1, 20));
        skypeCheck.setMnemonic(KeyEvent.VK_S);
        skypeCheck.setSelected(false);

        gameCheck = new JCheckBox("Games");
        gameCheck.setFont(new Font("Geneva", 1, 20));
        gameCheck.setMnemonic(KeyEvent.VK_G);
        gameCheck.setSelected(false);

        emailCheck = new JCheckBox("Email");
        emailCheck.setFont(new Font("Geneva", 1, 20));
        emailCheck.setMnemonic(KeyEvent.VK_E);
        emailCheck.setSelected(false);

        youtubeCheck = new JCheckBox("Videos");
        youtubeCheck.setFont(new Font("Geneva", 1, 20));
        youtubeCheck.setMnemonic(KeyEvent.VK_V);
        youtubeCheck.setSelected(false);
        
        fbCheck = new JCheckBox("Facebook");
        fbCheck.setFont(new Font("Geneva", 1, 20));
        fbCheck.setMnemonic(KeyEvent.VK_F);
        fbCheck.setSelected(false);
        
        instaCheck = new JCheckBox("Instagram");
        instaCheck.setFont(new Font("Geneva", 1, 20));
        instaCheck.setMnemonic(KeyEvent.VK_H);
        instaCheck.setSelected(false);
        
        cellPhoneCheck = new JCheckBox("Cell Phones");
        cellPhoneCheck.setFont(new Font("Geneva", 1, 20));
        cellPhoneCheck.setMnemonic(KeyEvent.VK_C);
        cellPhoneCheck.setSelected(false);

        //Register a listener for the check boxes.
        skypeCheck.addItemListener(new useListener());
        gameCheck.addItemListener(new useListener());
        instaCheck.addItemListener(new useListener());
        youtubeCheck.addItemListener(new useListener());
        fbCheck.addItemListener(new useListener());
        instaCheck.addItemListener(new useListener());
        cellPhoneCheck.addItemListener(new useListener());
        emailCheck.addItemListener(new useListener());
        
        checkPanel = new JPanel(new GridLayout(0, 1));
        checkPanel.setBackground(WelcomePage.backgroundColor);
        
        checkPanel.add(gameCheck);
        checkPanel.add(skypeCheck);
        checkPanel.add(emailCheck);
        checkPanel.add(youtubeCheck);
        checkPanel.add(fbCheck);
        checkPanel.add(instaCheck);
        checkPanel.add(cellPhoneCheck);
		
    	submitButton.addActionListener(new answerButtonListener());
    }
    
    public void paint(Graphics g) 
    { 
    	super.paint(g);
    	
    	g.drawImage(titleImage, 5, 5, this);
    	
    	g.setColor(Color.black);
    	g.setFont(new Font("Geneva", 1, 20));
    	g.drawString(explanation1, 30, 100);
    	g.drawString(question, 40, 135);
    	
    	if(instagram)
    	{
    		g.drawImage(instagramImage, 255, 155, this);
    	}
    	if(fb)
    	{
    		g.drawImage(fbImage, 600, 410, this);
    	}
    	if(youtube)
    	{
    		g.drawImage(youtubeImage, 415, 175, this);
    	}
    	if(email)
    	{
    		g.drawImage(emailImage, 600, 125, this);
    	}
    	if(game)
    	{
    		g.drawImage(gameImage, 600, 250, this);
    	}
    	if(cellPhone)
    	{
    		g.drawImage(cellImage, 230, 390, this);
    	}
    	if(skype)
    	{
    		g.drawImage(skypeImage, 400, 380, this);
    	}
    	

    }
    
    public void loadImages()
    {
    	titleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.whyBinaryImportantTitlePath)); 
		titleImage = titleImage.getScaledInstance(790, 43, Image.SCALE_SMOOTH);
		
		
		instagramImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.instagramPath)); 
		instagramImage = instagramImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		
		fbImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.fbPath)); 
		fbImage = fbImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		
		youtubeImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.youtubePath)); 
		youtubeImage = youtubeImage.getScaledInstance(150, 160, Image.SCALE_SMOOTH);
		
		emailImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.emailPath)); 
		emailImage = emailImage.getScaledInstance(160, 116, Image.SCALE_SMOOTH);
		
		cellImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.cellPath)); 
		cellImage = cellImage.getScaledInstance(152, 152, Image.SCALE_SMOOTH);
		
		skypeImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.skypePath)); 
		skypeImage = skypeImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		
		gameImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.gamePath)); 
		gameImage = gameImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		

    }
    
    class useListener implements ItemListener
    {
    	@Override
		public void itemStateChanged(ItemEvent e) 
    	{
    		Object source = e.getItemSelectable();
    		
    		if (source == skypeCheck) 
    		{
                if (e.getStateChange() == ItemEvent.DESELECTED) 
                   skype = false;
                else
                	skype = true;
            } 
    		else if (source == gameCheck) 
    		{
    			if (e.getStateChange() == ItemEvent.DESELECTED) 
                    game = false;
                 else
                 	game = true;
            } 
    		else if (source == emailCheck) 
    		{
    			if (e.getStateChange() == ItemEvent.DESELECTED) 
                    email = false;
                 else
                 	email = true;
            } 
    		else if (source == youtubeCheck) 
    		{
    			if (e.getStateChange() == ItemEvent.DESELECTED) 
                    youtube = false;
                 else
                 	youtube = true;
            }
    		else if (source == fbCheck) 
    		{
    			if (e.getStateChange() == ItemEvent.DESELECTED) 
                    fb = false;
                 else
                 	fb = true;
            }
    		else if (source == instaCheck) 
    		{
    			if (e.getStateChange() == ItemEvent.DESELECTED) 
                    instagram = false;
                 else
                 	instagram = true;
            }
    		else if (source == cellPhoneCheck) 
    		{
    			if (e.getStateChange() == ItemEvent.DESELECTED) 
                    cellPhone = false;
                 else
                 	cellPhone = true;
            }
    		repaint();
		}

    }
	
	class answerButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			welcomePage.loadSegundaPage();
			repaint();
		}
	}

}
