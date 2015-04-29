package Tutorial;



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
public class decConversionDemoPage extends JPanel implements ActionListener
{
	
	//fonts used
	private Font displayFont = new Font("Geneva", 1, 150);
	private Font textFont = new Font("Geneva", 1, 20);
	private Font labelFont = new Font("Geneva", 1, 15);
	private Font subheadFont = new Font("Geneva", 1, 30);
 
	private final String explanation1 = "Counting with decimal numbers and binary numbers is the same!";
	private final String explanation1cont = "Just add the sum of all digits based on what place they are.";
	
	private final String explanation2 = "Let's do an example where we count to 45 in decimal and binary:";
	
	
	//text used on page
	private final String four = "4";
  private final String five = "5";
  private final String fortyFive = "45";
  
  private final String tensPlace = "Tens Place";
  private final String onesPlace = "Ones Place";
  
  private final String tensMultiplication = "10 x 4";
  private final String tensMultiplicationAnswer = "40";
  
  private final String onesMultiplication = "1 x 5";
  private final String onesMultiplicationAnswer = "5";
  
  private final String plusSign = "+";
  private final String equalSign = "=";
  
  
  //timer handles animation and delay
	public Timer timer;
	private int DELAY = 3000;
	private int countAnimation = 0;
	
	
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
  
  private Controller controller;
  
	//constructor
  public decConversionDemoPage(Controller welcome)
  {
  	controller = welcome;
  	setBackground(Controller.backgroundColor);
  	

  	setVisible(true);
  	
  	timer = new Timer(DELAY, this);

  }
  

  
  //displays the large number 45 on screen through
  //all animation
  public void displayDecimalNums(Graphics m)
  {
		m.setColor(Controller.textColor);
		m.setFont(displayFont);
  	m.drawString(four, firstDisplayNumX, displayNumY);
  	m.drawString(five, secondDisplayNumX, displayNumY);
  }
  
  //displays the places (tens, ones) labels on screen
  public void displayDecimalPlaces(Graphics m)
  {
  	m.setColor(Controller.textColor);
  	m.setFont(textFont);
  	m.drawString(tensPlace, placeTenX, placesY);
  	m.drawString(onesPlace, placeOneX, placesY);
  }
  
  //displays all text on screen through all animation
  public void displayText(Graphics m)
  {
  	m.setColor(Controller.textColor);
  	m.setFont(textFont);
  	m.drawString(explanation1, explanationX, explanation1Y);
  	m.drawString(explanation1cont, explanationX, explanation1contY);
  	
  	m.drawString(explanation2, explanationX, explanation2Y);
  	
  }
  
  
  //first step of animation, tens place focus
  public void displayAnimationStage1(Graphics g)
  {
  	g.setColor(Color.red);
  	g.drawRect(rect1X, rectY, rectWidth, rectHeight);
  	
  	g.setColor(Controller.textColor);
  	g.setFont(textFont);
  	g.drawString(tensMultiplication, tensMultiplicationX, multiplicationY);
  	
  	g.setColor(Controller.buttonPanelColor);
  	g.setFont(subheadFont);
  	g.drawString(tensMultiplicationAnswer, tensMultiplicationAnswerX, multiplicationAnswerY);
  		
  }
  
  //second step of animation, ones place focus
  public void displayAnimationStage2(Graphics g)
  {
  	g.setColor(Color.red);
  	g.drawRect(rect2X, rectY, rectWidth, rectHeight);
  	
  	g.setColor(Controller.textColor);
  	g.setFont(textFont);
  	g.drawString(onesMultiplication, onesMultiplicationX, multiplicationY);
  	g.drawString(tensMultiplication, tensMultiplicationX, multiplicationY);
  	
  	g.setColor(Controller.buttonPanelColor);
  	g.setFont(subheadFont);
  	g.drawString(tensMultiplicationAnswer, tensMultiplicationAnswerX, multiplicationAnswerY);
  	g.drawString(onesMultiplicationAnswer, onesMultiplicationAnswerX, multiplicationAnswerY);
  
  }
  
  //third stage of animation, sum up places
  public void displayAnimationStage3(Graphics g)
  {

  	g.setColor(Controller.textColor);
  	g.setFont(textFont);
  	g.drawString(tensMultiplication, tensMultiplicationX, multiplicationY);
  	g.drawString(onesMultiplication, onesMultiplicationX, multiplicationY);
  	
  	g.setColor(Controller.buttonPanelColor);
  	g.setFont(subheadFont);
  	g.drawString(tensMultiplicationAnswer, tensMultiplicationAnswerX, multiplicationAnswerY);
  	g.drawString(onesMultiplicationAnswer, onesMultiplicationAnswerX, multiplicationAnswerY);
  	
  	g.setColor(Controller.textColor);
  	g.drawString(plusSign, plusSignX, multiplicationAnswerY);

  	
  }
  
  //fourth stage of animation, summary
  public void displayAnimationStage4(Graphics g)
  {
  	g.setColor(Controller.textColor);
  	g.setFont(textFont);
  	
  	g.drawString(tensMultiplication, tensMultiplicationX, multiplicationY);
  	g.drawString(onesMultiplication, onesMultiplicationX, multiplicationY);
  	
  	g.setColor(Controller.buttonPanelColor);
  	g.setFont(subheadFont);
  	g.drawString(tensMultiplicationAnswer, tensMultiplicationAnswerX, multiplicationAnswerY);
  	g.drawString(onesMultiplicationAnswer, onesMultiplicationAnswerX, multiplicationAnswerY);
  	
  	
  	g.setColor(Controller.textColor);
  	g.drawString(plusSign, plusSignX, multiplicationAnswerY);
  	
  	g.drawString(equalSign, equalSignX, multiplicationAnswerY);
  	
  	g.setColor(Controller.buttonPanelColor);
  	g.drawString(fortyFive, finalAnswerX, multiplicationAnswerY);
  	
  }
  
  
//displays the various components of the page and animation on screen,
  //changing the display based on the state of animation
  public void paint(Graphics g)
  {
  	super.paint(g);
  	
  	//first step of animation, basic numbers and labels displayed
  	g.drawImage(controller.demoTitleImage, titleImageX, titleImageY, this);
  	
  	displayText(g);
  	displayDecimalNums(g);
  	displayDecimalPlaces(g);
  	
  	//focus on tens place
  	if(countAnimation == 1)
  	{	
  		displayAnimationStage1(g);
  	}
  	//focus on ones place
  	else if(countAnimation == 2)
  	{	
  		displayAnimationStage2(g);
  	}
  	//show that one must add the sum of each place together 
  	else if(countAnimation == 3)
  	{	
  		displayAnimationStage3(g);
  	}
  	//final animation stage: show that the sum of all places equals original number
  	else if(countAnimation >= 4)
  	{	
  		displayAnimationStage4(g);
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
