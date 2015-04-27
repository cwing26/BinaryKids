package tutorial;


import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.Timer;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Image;
import java.awt.Toolkit;

/* This class serves as the fourth view in the introductory learning module, 
 * introducing the student to the basics of binary numbers and their relationship to computers
 * with an on/off button and an example conversion
 */
@SuppressWarnings("serial")
public class SegundaPage extends JPanel
{
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

    //text on page
    String explanation1 = "Actually, none of these would exist without binary numbers!";
    String explanation2 = "Electronics and technology use binary numbers, ";
    String explanation2cont = "streams of 1s and 0s, to operate.";
    String explanation3 = "At the most basic level,";
    String explanation4 = "1 means ON and 0 means OFF";
    String buttonInstruction = "Click the buttons to see how binary numbers send signals!";
    String labelInstruction = "Click number to convert!";

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
	
	//positions of components on screen
	private final int titleImageX = 5;
	private final int titleImageY = 5;
	
	private final int textX = 30;
	private final int  ex1Y = 80;
	
	private final int  ex2Y = 220;
	private final int  ex2contY = 250;
	
	private final int  ex3Y = 360;
	private final int  ex4Y = 390;
	
	private final int labelInstructionX = 457;
	private final int labelInstructionY = 324;
	
	private final int buttonInstructionY = 425;
	
	private final int thumbnailY = 100;
	private final int instaX = 20;
	private final int fbX = 125;
	private final int youtubeX = 235;
	private final int emailX = 335;
	private final int cellX = 440;
	private final int gameX = 545;
	private final int skypeX = 650;
	
	private final int buttonX = 200;
	private final int button0Y = 440;
	private final int button1Y = 490;
	
	private final int labelX = 440;
	private final int labelY = 260;
	
	private final int lightX = 460;
	private final int lightY = 370;
	
	
	//constructor
    public SegundaPage()
    {
    	
    	loadImages();
    	initComponents();
    	addComponentsToPanel();
    	formatComponents();
    	
    	setBackground(WelcomePage.backgroundColor);
    	
    	setVisible(true);

    }
    
    //displays various images and text on the screen, allowing
    //for change based on user clicks 
    public void paint(Graphics g)
    {
    	super.paint(g);
    	
    	g.drawImage(titleImage, titleImageX, titleImageY, this);
    	
    	g.setColor(Color.black);
    	g.setFont(new Font("Geneva", 1, 20));
    	g.drawString(explanation1, textX, ex1Y);
    	
    	g.drawImage(instagramImage, instaX, thumbnailY, this);
    	g.drawImage(fbImage, fbX, thumbnailY, this);
    	g.drawImage(youtubeImage, youtubeX, thumbnailY, this);
    	g.drawImage(emailImage, emailX, thumbnailY, this);
    	g.drawImage(cellImage, cellX, thumbnailY, this);
    	g.drawImage(gameImage, gameX, thumbnailY, this);
    	g.drawImage(skypeImage, skypeX, thumbnailY, this);
    	
    	
    	g.setFont(new Font("Geneva", 1, 25));
    	g.drawString(explanation2, textX, ex2Y);
    	g.drawString(explanation2cont, textX, ex2contY);
    	
    	g.drawString(explanation3, textX, ex3Y);
    	g.drawString(explanation4, textX, ex4Y);
    	
    	g.setFont(new Font("Geneva", 1, 15));
    	g.drawString(labelInstruction, labelInstructionX, labelInstructionY);
    	
    	g.setFont(new Font("Geneva", 1, 15));
    	g.drawString(buttonInstruction, textX, buttonInstructionY);
    	
    	if(oneClicked)
		{
			g.drawImage(lightOn, lightX, lightY, this);
		}
		else
		{
			g.drawImage(lightOff, lightX, lightY, this);
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
    
    //adds all swing components to the panel
    public void addComponentsToPanel()
    {
    	setLayout(null);
    	add(convertLabel);
    	add(zeroButton);
    	add(oneButton);
    }
    
    
    public void formatComponents()
    {
    	Insets insets = getInsets();
		Dimension labelSize = convertLabel.getPreferredSize();
		convertLabel.setBounds(labelX + insets.left, labelY + insets.top, labelSize.width, labelSize.height);
		
		Dimension button0Size = zeroButton.getPreferredSize();
		zeroButton.setBounds(buttonX + insets.left, button0Y + insets.top, button0Size.width, button0Size.height);
		
		Dimension button1Size = oneButton.getPreferredSize();
		oneButton.setBounds(buttonX + insets.left, button1Y + insets.top, button1Size.width, button1Size.height);
    	
    }
    
    //initializes and sets up all of the swing components on the screen
    public void initComponents()
    {
		convertLabel = new JLabel();
		convertLabel.setBackground(WelcomePage.backgroundColor);
		convertLabel.setFont(new Font("Monospaced", 1, 60));
		convertLabel.setForeground(WelcomePage.buttonPanelColor);
		convertLabel.setText(binaryNum);
		
		//listener indicates to the label when to change the label's
		//text to a binary number or a decimal number 
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
		
		//listener indicates to paint when to change the lightbulb image
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
    	
    	//listener indicates to paint when to change the lightbulb image
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
	
	
	
    

} //end class 
