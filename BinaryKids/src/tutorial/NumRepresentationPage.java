package tutorial;

//imports
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;


/* This class serves as the first view in the introductory learning module, 
 * introducing the student to different systems of counting that are used
 * with images and animation
 */
@SuppressWarnings("serial")
public class NumRepresentationPage extends JPanel implements ActionListener
{
	//text elements on screen
	String question = "How many soccer balls are there?";
	String VI = "VI";
	String six = "6";
	String binarySix = "110";
	
	//positions of text, shapes, and images on screen
	int titleImageX = 5;
	int titleImageY = 10;
	
	int questionX = 40;
	int questionY = 150;
	
	int objectCount = 6;
	
	int soccerBallX = 50;
	int soccerBallY = 230;
	
	int ovalSize = 50;
	
	int rectSize = 25;
	int rectX = 350;
	int rectY = 310;
	
	int decTitleImageX = 40;
	int decTitleImageY = 100;
	
	int romanNumImageX = 40;
	int romanNumImageY = 200;
	
	int shapesImageX = 40;
	int shapesImageY = 300;
	
	int binaryImageX = 40;
	int binaryImageY = 450;
	
	int sixX = 560;
	int sixY = 140;
	
	int binarySixX = 535;
	int binarySixY = 490;
	
	int vIX = 545;
	int vIY = 240;
	
	
	//images used on screen
	public Image numRepTitleImage;
	public Image decimalTitleImage;
	public Image romanNumeralTitleImage;
	public Image shapesTitleImage;
	public Image binaryImageLight;
	public Image binaryImageDark;
	public Image soccerBall;
	

	
	private WelcomePage welcomePage; //to connect welcome page to individual pages 
	
	//handles animation on a 3 second delay
	private Timer timer;
	private int DELAY = 3000;
	int countAnimation = 0;

	//constructor sets the background color of the panel and starts the animation timer
    public NumRepresentationPage(WelcomePage welcome)
    {
    	
    	welcomePage = welcome;
    	setBackground(WelcomePage.backgroundColor);
    	
    	loadImages();

    	setVisible(true);
    	
    	//creates timer and starts animation
    	timer = new Timer(DELAY, this);
    	timer.start();
    }
    
    //used to draw all components of screen in proper position, 
    //repaints based on animation count
    public void paint(Graphics g) 
    { 
    	super.paint(g);
    	
    	g.drawImage(numRepTitleImage, titleImageX, titleImageY, this);
    	
    	//first iteration of animation only displays question
    	if(countAnimation == 1)
    	{
    		g.setFont(new Font("Geneva", 1, 25));
    		g.drawString(question, questionX, questionY);

    		for(int i = 0; i < objectCount; i ++)
    		{
    			//g.drawImage(soccerBall, soccerBallX, soccerBallY, this);	
    			g.setColor(WelcomePage.buttonPanelColor);
    			g.fillOval(soccerBallX, soccerBallY, ovalSize, ovalSize);
    			soccerBallX = soccerBallX + 100;
    		}
    		
    	}
    	//second iteration displays answer written in several number systems 
    	else if(countAnimation == 2)
    	{
	    	g.setColor(WelcomePage.textColor);
	    	
	    	rectX = 350;
	    	for(int i = 0; i < objectCount; i++)
	    	{
	    		
	    		g.fillRect(rectX, rectY, rectSize, rectSize);
	    		rectX = rectX + 50;
	    		
	    	}
	
	    	g.drawImage(decimalTitleImage, decTitleImageX, decTitleImageY, this);
	    	g.drawImage(romanNumeralTitleImage, romanNumImageX, romanNumImageY, this);
	    	g.drawImage(shapesTitleImage, shapesImageX, shapesImageY, this);
    		g.drawImage(binaryImageLight, binaryImageX, binaryImageY, this);

	    	g.setColor(WelcomePage.textColor);
	    	g.setFont(new Font("Monospaced", 1, 60));
	    	g.drawString(six, sixX, sixY);
	    	g.drawString(VI, vIX, vIY);
	    	g.drawString(binarySix, binarySixX, binarySixY);
    	
    	
    	}
    	//third iteration highlights binary number answer
  	    else if(countAnimation >= 3)
  	    {
  	    	g.drawImage(binaryImageDark, binaryImageX, binaryImageY, this);
  	    	g.setColor(WelcomePage.textColor);
  	    	g.drawRect(30, 435, 650, 80);
  	    	g.setFont(new Font("Monospaced", 1, 60));
  	    	g.drawString("=", 560, 415);
  	    	
  	    	g.setColor(WelcomePage.textColor);
	    	
	    	rectX = 350;
	    	for(int i = 0; i < objectCount; i++)
	    	{
	    		
	    		g.fillRect(rectX, rectY, rectSize, rectSize);
	    		rectX = rectX + 50;
	    		
	    	}
	
	    	g.drawImage(decimalTitleImage, decTitleImageX, decTitleImageY, this);
	    	g.drawImage(romanNumeralTitleImage, romanNumImageX, romanNumImageY, this);
	    	g.drawImage(shapesTitleImage, shapesImageX, shapesImageY, this);

	    	g.setColor(WelcomePage.textColor);
	    	g.setFont(new Font("Monospaced", 1, 60));
	    	g.drawString(six, sixX, sixY);
	    	g.drawString(VI, vIX, vIY);
	    	g.drawString(binarySix, binarySixX, binarySixY);
	    		
  	    }
	
    }
    
    
    //WILL BE TRANSFERRED TO welcomepage
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
    
    
    //class implements actions listener to handle animation
    //and thus must override action performed
    //method just increments an animation counter
    //to keep track of what stage the display is in
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
