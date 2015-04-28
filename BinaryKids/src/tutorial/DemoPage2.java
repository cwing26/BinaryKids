package tutorial;

//imports
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.*; 


/* This class serves as the tenth view in the introductory learning module, 
 * introducing the student to the conversion of binary and decimal numbers by
 * looking at the sum of their digits/places with an animation. This page builds
 * off the previous demonstration page to apply the same logic to understanding 
 * binary numbers: calculating the product and sum of their different digits
 */
@SuppressWarnings("serial")
public class DemoPage2 extends JPanel implements ActionListener
{

	//fonts used
	private Font displayFont = new Font("Geneva", 1, 150);
	private Font textFont = new Font("Geneva", 1, 20);
	private Font labelFont = new Font("Geneva", 1, 15);
	private Font subheadFont = new Font("Geneva", 1, 30);
   
	//text used on screen
	private final String explanation1 = "Counting with decimal numbers and binary numbers is the same!";
	private final String explanation1cont = "Just add the sum of all digits based on what place they are.";
	
	private final String explanation2 = "Let's do an example where we count to 45 in decimal and binary:";
	
    private final String plusSign = "+";
    private final String equalSign = "=";
    
    //components of second binary animation
    //45 in binary is 101101
    private final String binaryOne = "1";
    private final String binaryZero = "0";
    private final String fortyFive = "45";
    
    private final String thirtyTwosPlace = "Thirty-Twos";
    private final String sixteensPlace = "Sixteens";
    private final String place = "place";
    private final String eightsPlace = "Eights place";
    private final String foursPlace = "Fours place";
    private final String twosPlace = "Twos place";
    private final String onesPlace = "Ones Place";
     
    private final String thirtyTwoMultiplication = "32 x 1";
    private final String thirtyTwoMultiplicationAnswer = "32";
    
    private final String sixteenMultiplication = "16 x 0";
    private final String sixteenMultiplicationAnswer = "0";
    
    private final String eightMultiplication = "8 x 1";
    private final String eightMultiplicationAnswer = "8";
    
    private final String fourMultiplication = "4 x 1";
    private final String fourMultiplicationAnswer = "4";
    
    private final String twoMultiplication = "2 x 0";
    private final String twoMultiplicationAnswer = "0";
    
    private final String oneMultiplication = "1 x 1";
    private final String oneMultiplicationAnswer = "1";
    
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
    
    private final int multiplicationAnswerY = 470;
    private final int multiplicationY = 420;
    
    private final int plus1X = 150;
    private final int plus2X = 270;
    private final int plus3X = 390;
    private final int plus4X = 510;
    private final int plus5X = 630;
    
    private final int displayNumY = 330;
    private final int placesY = 370;
    private final int placesYoverflow = 390;
    
    private final int binary1X = 50;
    private final int binary2X = 170;
    private final int binary3X = 290;
    private final int binary4X = 410;
    private final int binary5X = 530;
    private final int binary6X = 650;
    
    private final int place32X = 45;
    private final int place32Xoverflow = 50;
    private final int place16X = 175;
    private final int place16Xoverflow = 180;
    private final int place8X = 285;
    private final int place4X = 410;
    private final int place2X = 530;
    private final int place1X = 650;
    
    private final int multip32X = 60;
    private final int multip16X = 180;
    private final int multip8X = 305;
    private final int multip4X = 425;
    private final int multip2X = 545;
    private final int multip1X = 665;
    
    private final int multip32answerX = 70;
    private final int multip16answerX = 195;
    private final int multip8answerX = 320;
    private final int multip4answerX = 440;
    private final int multip2answerX = 560;
    private final int multip1answerX = 680;
    
    private final int rectWidth = 110;
    private final int rectHeight = 150;
    
    private final int rectY = 195;
    
    private Controller controller;
    
    //constructor
    public DemoPage2(Controller welcome)
    {
    	controller = welcome;
    	
    	setBackground(Controller.backgroundColor);
    	

    	setVisible(true);
    	
    	timer = new Timer(DELAY, this);
    	timer.start();
    	

    }
    
    
    
    //displays all digits making up binary number through animation
    public void displayBinaryNums(Graphics m)
    {
    	m.setColor(Controller.textColor);
		m.setFont(displayFont);
    	m.drawString(binaryOne, binary1X, displayNumY);
    	m.drawString(binaryZero, binary2X, displayNumY);
    	m.drawString(binaryOne, binary3X, displayNumY);
    	m.drawString(binaryOne, binary4X, displayNumY);
    	m.drawString(binaryZero, binary5X, displayNumY);
    	m.drawString(binaryOne, binary6X, displayNumY);
    }
    
  //displays all binary places under binary number through animation
    public void displayBinaryPlaces(Graphics m)
    {
    	m.setColor(Controller.textColor);
    	m.setFont(textFont);
    	m.drawString(thirtyTwosPlace, place32X, placesY);
    	m.drawString(place, place32Xoverflow, placesYoverflow);
    	m.drawString(sixteensPlace, place16X, placesY);
    	m.drawString(place, place16Xoverflow, placesYoverflow);
    	m.drawString(eightsPlace, place8X, placesY);
    	m.drawString(foursPlace, place4X, placesY);
    	m.drawString(twosPlace, place2X, placesY);
    	m.drawString(onesPlace, place1X, placesY);
    }
    
    //displays all explanatory text through animation
    public void displayText(Graphics m)
    {
    	m.setColor(Controller.textColor);
    	m.setFont(textFont);
    	m.drawString(explanation1, explanationX, explanation1Y);
    	m.drawString(explanation1cont, explanationX, explanation1contY);
    	
    	m.drawString(explanation2, explanationX, explanation2Y);
    }
    
    //displays plus signs at last two animation stages to illustrate
    //summing of digits
    public void displayPlusSign(Graphics g)
    {
    	g.setColor(Controller.textColor);
    	g.drawString(plusSign, plus1X, multiplicationAnswerY);
    	g.drawString(plusSign, plus2X, multiplicationAnswerY);
    	g.drawString(plusSign, plus3X, multiplicationAnswerY);
    	g.drawString(plusSign, plus4X, multiplicationAnswerY);
    	g.drawString(plusSign, plus5X, multiplicationAnswerY);
    	
    }
    
    //displays multiplication formulas for each binary place at
    //last two stages of animation
    public void displayMultiplication(Graphics g)
    {
    	g.setColor(Controller.textColor);
    	g.setFont(textFont);
    	
    	g.drawString(thirtyTwoMultiplication, multip32X, multiplicationY);
    	g.drawString(sixteenMultiplication, multip16X, multiplicationY);
    	g.drawString(eightMultiplication, multip8X, multiplicationY);
    	g.drawString(fourMultiplication, multip4X, multiplicationY);
    	g.drawString(twoMultiplication, multip2X, multiplicationY);
    	g.drawString(oneMultiplication, multip1X, multiplicationY);
    	
    }
    
    //displays multiplication answers to above formulas for each binary place at
    //last two stages of animation
    public void displayMultiplicationAnswer(Graphics g)
    {
    	g.setColor(Controller.buttonPanelColor);
    	g.setFont(subheadFont);
    	
    	g.drawString(thirtyTwoMultiplicationAnswer, multip32answerX, multiplicationAnswerY);
    	g.drawString(sixteenMultiplicationAnswer, multip16answerX, multiplicationAnswerY);
    	g.drawString(eightMultiplicationAnswer, multip8answerX, multiplicationAnswerY);
    	g.drawString(fourMultiplicationAnswer, multip4answerX, multiplicationAnswerY);
    	g.drawString(twoMultiplicationAnswer, multip2answerX, multiplicationAnswerY);
    	g.drawString(oneMultiplicationAnswer, multip1answerX, multiplicationAnswerY);
    	
    }
    
    //focus on 32s place, displaying multiplication formula and answer
    public void displayAnimationStage1(Graphics g)
    {
    	g.setColor(Color.red);
    	g.drawRect(binary1X, rectY, rectWidth, rectHeight);

    	g.setColor(Controller.textColor);
    	g.setFont(textFont);
    	g.drawString(thirtyTwoMultiplication, multip32X, multiplicationY);
    	
    	g.setColor(Controller.buttonPanelColor);
    	g.setFont(subheadFont);
    	g.drawString(thirtyTwoMultiplicationAnswer, multip32answerX, multiplicationAnswerY);

    }
    
  //focus on 16s place, displaying multiplication formula and answer
    public void displayAnimationStage2(Graphics g)
    {
    	g.setColor(Color.red);
    	g.drawRect(binary2X, rectY, rectWidth, rectHeight);

    	
    	g.setColor(Controller.textColor);
    	g.setFont(textFont);
    	
    	g.drawString(thirtyTwoMultiplication, multip32X, multiplicationY);
    	g.drawString(sixteenMultiplication, multip16X, multiplicationY);


    	g.setColor(Controller.buttonPanelColor);
    	g.setFont(subheadFont);
    	g.drawString(thirtyTwoMultiplicationAnswer, multip32answerX, multiplicationAnswerY);
    	g.drawString(sixteenMultiplicationAnswer, multip16answerX, multiplicationAnswerY);
    	
    }
    
  //focus on 8s place, displaying multiplication formula and answer
    public void displayAnimationStage3(Graphics g)
    {

    	g.setColor(Color.red);
    	g.drawRect(binary3X, rectY, rectWidth, rectHeight);

    	
    	g.setColor(Controller.textColor);
    	g.setFont(textFont);
    	
    	g.drawString(thirtyTwoMultiplication, multip32X, multiplicationY);
    	g.drawString(sixteenMultiplication, multip16X, multiplicationY);
    	g.drawString(eightMultiplication, multip8X, multiplicationY);
    	
    	
    	g.setColor(Controller.buttonPanelColor);
    	g.setFont(subheadFont);
    	g.drawString(thirtyTwoMultiplicationAnswer, multip32answerX, multiplicationAnswerY);
    	g.drawString(sixteenMultiplicationAnswer, multip16answerX, multiplicationAnswerY);
    	g.drawString(eightMultiplicationAnswer, multip8answerX, multiplicationAnswerY);
    	
    }
    
  //focus on 4s place, displaying multiplication formula and answer
    public void displayAnimationStage4(Graphics g)
    {
    	
    	g.setColor(Color.red);
      	g.drawRect(binary4X, rectY, rectWidth, rectHeight);

    	
    	g.setColor(Controller.textColor);
    	g.setFont(textFont);
    	
    	g.drawString(thirtyTwoMultiplication, multip32X, multiplicationY);
    	g.drawString(sixteenMultiplication, multip16X, multiplicationY);
    	g.drawString(eightMultiplication, multip8X, multiplicationY);
    	g.drawString(fourMultiplication, multip4X, multiplicationY);
    	
    	
    	g.setColor(Controller.buttonPanelColor);
    	g.setFont(subheadFont);
    	g.drawString(thirtyTwoMultiplicationAnswer, multip32answerX, multiplicationAnswerY);
    	g.drawString(sixteenMultiplicationAnswer, multip16answerX, multiplicationAnswerY);
    	g.drawString(eightMultiplicationAnswer, multip8answerX, multiplicationAnswerY);
    	g.drawString(fourMultiplicationAnswer, multip4answerX, multiplicationAnswerY);
    	
    	
    }
    
  //focus on 2s place, displaying multiplication formula and answer
    public void displayAnimationStage5(Graphics g)
    {
    	g.setColor(Color.red);
    	g.drawRect(binary5X, rectY, rectWidth, rectHeight);
    	
    	g.setColor(Controller.textColor);
    	g.setFont(textFont);
    	
    	g.drawString(thirtyTwoMultiplication, multip32X, multiplicationY);
    	g.drawString(sixteenMultiplication, multip16X, multiplicationY);
    	g.drawString(eightMultiplication, multip8X, multiplicationY);
    	g.drawString(fourMultiplication, multip4X, multiplicationY);
    	g.drawString(twoMultiplication, multip2X, multiplicationY);

    	
    	g.setColor(Controller.buttonPanelColor);
    	g.setFont(subheadFont);
    	g.drawString(thirtyTwoMultiplicationAnswer, multip32answerX, multiplicationAnswerY);
    	g.drawString(sixteenMultiplicationAnswer, multip16answerX, multiplicationAnswerY);
    	g.drawString(eightMultiplicationAnswer, multip8answerX, multiplicationAnswerY);
    	g.drawString(fourMultiplicationAnswer, multip4answerX, multiplicationAnswerY);
    	g.drawString(twoMultiplicationAnswer, multip2answerX, multiplicationAnswerY);
    	
    }
    
  //focus on 1s place, displaying multiplication formula and answer
    public void displayAnimationStage6(Graphics g)
    {
    	g.setColor(Color.red);
    	g.drawRect(binary6X, rectY, rectWidth, rectHeight);
    	
    	displayMultiplication(g);
    	displayMultiplicationAnswer(g);
    	
    }
    
    //summary of all multiplication formulas and their answers with illustration
    //that we must sum multiplications answers up to get final answer
    public void displayAnimationStage7(Graphics g)
    {
		displayMultiplication(g);
    	displayMultiplicationAnswer(g);
    	displayPlusSign(g);
    	
    }
    
    //displays summing of multiplication answers to arrive at final
    //answer of 45
    public void displayAnimationStage8(Graphics g)
    {
  		displayMultiplication(g);
    	displayMultiplicationAnswer(g);
    	displayPlusSign(g);

    	g.drawString(equalSign, 620, 540);
    	
    	g.setColor(Controller.buttonPanelColor);
    	g.drawString(fortyFive, 650, 540);
    	
    }
    
    //displays the various components of the page and animation on screen,
    //changing the display based on the state of animation
    public void paint(Graphics g)
    {
    	super.paint(g);
    	
    	g.drawImage(controller.demo2TitleImage, titleImageX, titleImageY, this);
    	
    	//numbers, place labels, and explanatory text
    	//displayed throughout animation
    	displayText(g);
    	displayBinaryNums(g);
    	displayBinaryPlaces(g);
    	
    	//32s place
    	if(countAnimation == 1)
    	{	
    		displayAnimationStage1(g);
    	}
    	//16s place
    	else if(countAnimation == 2)
    	{	
    		displayAnimationStage2(g);
        	
    	}
    	//8s place
    	else if(countAnimation == 3)
    	{	
    		displayAnimationStage3(g);
    	}
    	//4s place
    	else if (countAnimation == 4)
    	{
    		displayAnimationStage4(g);
    	}
    	//2s place
    	else if(countAnimation ==5)
    	{
    		displayAnimationStage5(g);
    	}
    	//1s place
    	else if(countAnimation == 6)
    	{
    		displayAnimationStage6(g);
    	}
    	//sum of answers
    	else if(countAnimation == 7)
    	{
    		displayAnimationStage7(g);
    	}
    	//final answer stage
    	else if(countAnimation >=8)
    	{
    		displayAnimationStage8(g);
    	}
    	
    } //end paint
    
    //increments as the timer progresses to determine what stage
    //of animation the page is in
	@Override
    public void actionPerformed(ActionEvent e) 
	{
		
		if(countAnimation < 100)
		{	
			countAnimation++;
		}
		else
			timer.stop();
		
        repaint();
    }
	


}
