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
	
	//text components of page
	private final String explanation1 = "Binary numbers are important for computers and electronics";
	private final String question = "How do you use technology?";
	
	//gui components of page
	private JButton submitButton;
	private JPanel checkPanel; //panel to hold checkboxes
	
	//check boxes
	private JCheckBox skypeCheck;
	private JCheckBox gameCheck;
	private JCheckBox emailCheck;
	private JCheckBox youtubeCheck;
	private JCheckBox fbCheck;
	private JCheckBox instaCheck;
	private JCheckBox cellPhoneCheck;

	//booleans to indicate whether checks have been filled
	private boolean skype = false;
	private boolean game = false;
	private boolean email = false;
	private boolean youtube = false;
	private boolean fb = false;
	private boolean instagram = false;
	private boolean cellPhone = false;
	
	
	//locations of components on screen
	private final int checkPanelX = 100;
	private final int checkPanelY = 150;
	
	private final int submitButtonX = 90;
	private final int submitButtonY = 380;
	
	private final int titleImageX = 5;
	private final int titleImageY = 5;
	
	private final int explanationX = 30;
	private final int explanationY = 100;

	private final int questionX = 40;
	private final int questionY = 135;
	
	private final int instaX = 255;
	private final int instaY = 155;
	
	private final int fbX = 600;
	private final int fbY = 410;
	
	private final int emailX = 600;
	private final int emailY = 125;
	
	private final int youtubeX = 415;
	private final int youtubeY = 175;
	
	private final int skypeX = 400;
	private final int skypeY = 380;
	
	private final int cellX = 230;
	private final int cellY = 390;
	
	private final int gameX = 600;
	private final int gameY = 250;
	
	private Controller controller; //to connect welcome page to individual pages 
    
	//constructor, param is the applet
    public FirstPage(Controller welcome)
    {
    	controller = welcome;
    	setBackground(controller.backgroundColor);
    	
    	initComponents();
    	addComponentsToPanel();
    	formatComponents();
 
    	
    	setVisible(true);
    	
    }
	
    
	public void addComponentsToPanel()
	{
    	setLayout(null);
    	add(checkPanel);
    	add(submitButton);
	}
	
	//positions gui components on screen
	public void formatComponents()
	{
    	Insets insets = getInsets();
    	
		Dimension checkPanelSize = checkPanel.getPreferredSize();
		checkPanel.setBounds(checkPanelX + insets.left, checkPanelY + insets.top,
	            checkPanelSize.width, checkPanelSize.height);
		
		Dimension buttonSize = submitButton.getPreferredSize();
		submitButton.setBounds(submitButtonX + insets.left, submitButtonY + insets.top, 
				buttonSize.width, buttonSize.height);
		
	}
	
	//initializes the swing components of the page: the button,
	//checkboxes, and panel of checkboxes
    public void initComponents()
    {
    	submitButton = new JButton("Submit Answer");
    	submitButton.addActionListener(new answerButtonListener());
    	
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
        
        //checkboxes are all housed in a subpanel
        checkPanel = new JPanel(new GridLayout(0, 1));
        checkPanel.setBackground(Controller.backgroundColor);
        
        checkPanel.add(gameCheck);
        checkPanel.add(skypeCheck);
        checkPanel.add(emailCheck);
        checkPanel.add(youtubeCheck);
        checkPanel.add(fbCheck);
        checkPanel.add(instaCheck);
        checkPanel.add(cellPhoneCheck);
		
    	
    }
    
    
    //paint is used to display the question on the screen,
    //as well as the images that correspond to the checkboxes
    //in checkpanel
    public void paint(Graphics g) 
    { 
    	super.paint(g);
    	
    	g.drawImage(controller.firstPageTitleImage, titleImageX, titleImageY, this);
    	
    	g.setColor(Color.black);
    	g.setFont(new Font("Geneva", 1, 20));
    	g.drawString(explanation1, explanationX, explanationY);
    	g.drawString(question, questionX, questionY);
    	
    	if(instagram)
    	{
    		g.drawImage(controller.instagramImage, instaX, instaY, this);
    	}
    	if(fb)
    	{
    		g.drawImage(controller.fbImage, fbX, fbY, this);
    	}
    	if(youtube)
    	{
    		g.drawImage(controller.youtubeImage, youtubeX, youtubeY, this);
    	}
    	if(email)
    	{
    		g.drawImage(controller.emailImage, emailX, emailY, this);
    	}
    	if(game)
    	{
    		g.drawImage(controller.gameImage, gameX, gameY, this);
    	}
    	if(cellPhone)
    	{
    		g.drawImage(controller.cellImage, cellX, cellY, this);
    	}
    	if(skype)
    	{
    		g.drawImage(controller.skypeImage, skypeX, skypeY, this);
    	}
    	

    }
    
    
    //this listener tells the paint method when a certain checkbox
    //has been selected or deselected, and whether to paint the corresponding image
    //it first determines the source of the action (which checkbox) and then determines
    //whether the box has been selected or deselected 
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
	
    //action listener for the submit button under the checkboxes.
    //if clicked, it takes user to the next page
	class answerButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			controller.loadCard("SEGUNDA");
			welcomePage.pageFlag++;
			welcomePage.nextButton.setVisible(true);
			repaint();
		}
	}

}
