package tutorial;

//imports
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.*; 




/* This class serves as the ninth view in the introductory learning module, 
 * introducing the student to the conversion of binary and decimal numbers by
 * looking at the sum of their digits/places with an animation
 */
@SuppressWarnings("serial")
public class DemoPage extends JPanel implements ActionListener
{
	
	//fonts used
	Font displayFont = new Font("Geneva", 1, 150);
	Font textFont = new Font("Geneva", 1, 20);
	Font labelFont = new Font("Geneva", 1, 15);
	Font subheadFont = new Font("Geneva", 1, 30);
   
	//images
	private Image titleImage;
	
	String explanation1 = "Counting with decimal numbers and binary numbers is the same!";
	String explanation1cont = "Just add the sum of all digits based on what place they are.";
	
	String explanation2 = "Let's do an example where we count to 45 in decimal and binary:";
	
	
	//text used on page
	String four = "4";
    String five = "5";
    String fortyFive = "45";
    
    String tensPlace = "Tens Place";
    String onesPlace = "Ones Place";
    
    String tensMultiplication = "10 x 4";
    String tensMultiplicationAnswer = "40";
    
    String onesMultiplication = "1 x 5";
    String onesMultiplicationAnswer = "5";
    
    String plusSign = "+";
    String equalSign = "=";
    
    
    //timer handles animation and delay
	private Timer timer;
	private int DELAY = 3000;
	int countAnimation = 0;
	
	
	//coordinates of screen components
	private final int titleImageX = 50;
	private final int titleImageY = 5;
	
	private final int explanationX = 20;
    private final int explanation1Y = 100;
    private final int explanation1contY = 125;
    private final int explanation2Y = 160;
    
    private final int displayNumY = 330;
    private final int firstDisplayNumX = 240;
    private final int secondDisplayNumX = 350;
    
    private final int rectWidth = 110;
    private final int rectHeight = 150;
    
    private final int rect1X = 230;
    private final int rect2X = 345;
    private final int rectY = 195;
    
    private final int placesY = 370;
    private final int placeTenX = 230;
    private final int placeOneX = 355;
    
    private final int multiplicationY = 400;
    private final int tensMultiplicationX = 240;
    private final int onesMultiplicationX = 365;
    
    private final int multiplicationAnswerY = 440;
    private final int tensMultiplicationAnswerX = 250;
    private final int onesMultiplicationAnswerX = 375;
    private final int plusSignX = 320;
    private final int equalSignX = 480;
    private final int finalAnswerX = 510;
    
    
	//constructor
    public DemoPage()
    {
    	
    	setBackground(WelcomePage.backgroundColor);
    	
    	loadImages();

    	setVisible(true);
    	
    	timer = new Timer(DELAY, this);
    	timer.start();

    }
    
    //loads images necessary for page
    public void loadImages()
    {
    	titleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.puttingTogetherPath)); 
		titleImage = titleImage.getScaledInstance(680, 60, Image.SCALE_SMOOTH);
		
		
    }
    
    public void paint(Graphics g)
    {
    	super.paint(g);
    	
    	g.drawImage(titleImage, titleImageX, titleImageY, this);
    	
    	g.setFont(textFont);
    	g.drawString(explanation1, explanationX, explanation1Y);
    	g.drawString(explanation1cont, explanationX, explanation1contY);
    	
    	g.drawString(explanation2, explanationX, explanation2Y);
    	
    	//initial display of just the numbers
    	if(countAnimation == 0)
    	{	
    		g.setColor(Color.black);
    		g.setFont(displayFont);
        	g.drawString(four, firstDisplayNumX, displayNumY);
        	g.drawString(five, secondDisplayNumX, displayNumY);
        	
        	g.setColor(WelcomePage.textColor);
        	g.setFont(textFont);
        	g.drawString(tensPlace, placeTenX, placesY);
        	g.drawString(onesPlace, placeOneX, placesY);
        	
    	}
    	//focus on tens place
    	else if(countAnimation == 1)
    	{	
    		g.setColor(Color.black);
    		g.setFont(displayFont);
        	g.drawString(four, firstDisplayNumX, displayNumY);
        	g.drawString(five, secondDisplayNumX, displayNumY);
        	
        	g.setColor(Color.red);
        	g.drawRect(rect1X, rectY, rectWidth, rectHeight);
        	
        	g.setColor(WelcomePage.textColor);
        	g.setFont(textFont);
        	g.drawString(tensPlace, placeTenX, placesY);
        	g.drawString(onesPlace, placeOneX, placesY);
        	
        	g.drawString(tensMultiplication, tensMultiplicationX, multiplicationY);
        	
        	g.setColor(WelcomePage.buttonPanelColor);
        	g.setFont(subheadFont);
        	g.drawString(tensMultiplicationAnswer, tensMultiplicationAnswerX, multiplicationAnswerY);
        	
    	}
    	//focus on ones place
    	else if(countAnimation == 2)
    	{	
    		g.setColor(Color.black);
    		g.setFont(displayFont);
        	g.drawString(four, firstDisplayNumX, displayNumY);
        	g.drawString(five, secondDisplayNumX, displayNumY);
        	
        	g.setColor(Color.red);
        	g.drawRect(rect2X, rectY, rectWidth, rectHeight);
        	
        	g.setColor(WelcomePage.textColor);
        	g.setFont(textFont);
        	g.drawString(tensPlace, placeTenX, placesY);
        	g.drawString(onesPlace, placeOneX, placesY);
        	
        	g.drawString(onesMultiplication, onesMultiplicationX, multiplicationY);
        	g.drawString(tensMultiplication, tensMultiplicationX, multiplicationY);
        	
        	g.setColor(WelcomePage.buttonPanelColor);
        	g.setFont(subheadFont);
        	g.drawString(tensMultiplicationAnswer, tensMultiplicationAnswerX, multiplicationAnswerY);
        	g.drawString(onesMultiplicationAnswer, onesMultiplicationAnswerX, multiplicationAnswerY);
        
        	
    	}
    	//show that one must add the sum of each place together 
    	else if(countAnimation == 3)
    	{	
    		g.setColor(Color.black);
    		g.setFont(displayFont);
        	g.drawString(four, firstDisplayNumX, displayNumY);
        	g.drawString(five, secondDisplayNumX, displayNumY);
        	
        	
        	g.setColor(WelcomePage.textColor);
        	g.setFont(textFont);
        	g.drawString(tensPlace, placeTenX, placesY);
        	g.drawString(onesPlace, placeOneX, placesY);
        	
        	
        	g.drawString(tensMultiplication, tensMultiplicationX, multiplicationY);
        	g.drawString(onesMultiplication, onesMultiplicationX, multiplicationY);
        	
        	g.setColor(WelcomePage.buttonPanelColor);
        	g.setFont(subheadFont);
        	g.drawString(tensMultiplicationAnswer, tensMultiplicationAnswerX, multiplicationAnswerY);
        	g.drawString(onesMultiplicationAnswer, onesMultiplicationAnswerX, multiplicationAnswerY);
        	
        	
        	g.setColor(WelcomePage.textColor);
        	g.drawString(plusSign, plusSignX, multiplicationAnswerY);

        	
    	}
    	//final animation stage: show that the sum of all places equals original number
    	else if(countAnimation >= 4)
    	{	
    		g.setColor(Color.black);
    		g.setFont(displayFont);
        	g.drawString(four, firstDisplayNumX, displayNumY);
        	g.drawString(five, secondDisplayNumX, displayNumY);
        	
        	
        	g.setColor(WelcomePage.textColor);
        	g.setFont(textFont);
        	g.drawString(tensPlace, placeTenX, placesY);
        	g.drawString(onesPlace, placeOneX, placesY);
        	
        	
        	g.drawString(tensMultiplication, tensMultiplicationX, multiplicationY);
        	g.drawString(onesMultiplication, onesMultiplicationX, multiplicationY);
        	
        	g.setColor(WelcomePage.buttonPanelColor);
        	g.setFont(subheadFont);
        	g.drawString(tensMultiplicationAnswer, tensMultiplicationAnswerX, multiplicationAnswerY);
        	g.drawString(onesMultiplicationAnswer, onesMultiplicationAnswerX, multiplicationAnswerY);
        	
        	
        	g.setColor(WelcomePage.textColor);
        	g.drawString(plusSign, plusSignX, multiplicationAnswerY);
        	
        	g.drawString(equalSign, equalSignX, multiplicationAnswerY);
        	
        	g.setColor(WelcomePage.buttonPanelColor);
        	g.drawString(fortyFive, finalAnswerX, multiplicationAnswerY);
        	
    	}
    	
    } //end paint
    	
    
    //increments as the timer progresses to determine what stage
    //of animation the page is in
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
	


} //end class
