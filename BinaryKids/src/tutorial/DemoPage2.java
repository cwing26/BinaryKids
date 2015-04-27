package tutorial;


import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

import java.awt.*; 

//explains the places/digits with an animation
//decimal numbers can have many digits
//show: 132 (3 different strings)
//1. hundreds place: light up, rectangle around it, label with hundreds place
//2. 100x1 = 100 under hundreds place, 100x1 on side of page


@SuppressWarnings("serial")
public class DemoPage2 extends JPanel implements ActionListener
{

    //images
	private Image titleImage;
	
	String explanation1 = "Counting with decimal numbers and binary numbers is the same!";
	String explanation1cont = "Just add the sum of all digits based on what place they are.";
	
	String explanation2 = "Let's do an example where we count to 45 in decimal and binary:";
	
    String plusSign = "+";
    String equalSign = "=";
    
    //components of second binary animation
    //45 in binary is 101101
    String binaryOne = "1";
    String binaryZero = "0";
    
    String thirtyTwosPlace = "Thirty-Twos";
    String sixteensPlace = "Sixteens";
    String place = "place";
    String eightsPlace = "Eights place";
    String foursPlace = "Fours place";
    String twosPlace = "Twos place";
    String onesPlace = "Ones Place";
     
    String thirtyTwoMultiplication = "32 x 1";
    String thirtyTwoMultiplicationAnswer = "32";
    
    String sixteenMultiplication = "16 x 0";
    String sixteenMultiplicationAnswer = "0";
    
    String eightMultiplication = "8 x 1";
    String eightMultiplicationAnswer = "8";
    
    String fourMultiplication = "4 x 1";
    String fourMultiplicationAnswer = "4";
    
    String twoMultiplication = "2 x 0";
    String twoMultiplicationAnswer = "0";
    
    String oneMultiplication = "1 x 1";
    String oneMultiplicationAnswer = "1";
    
    
	private Timer timer;
	private int DELAY = 3000;
	int countAnimation = 0;
	
    
    public DemoPage2()
    {

    	timer = new Timer(DELAY, this);
    	setBackground(WelcomePage.backgroundColor);
    	
    	loadImages();

    	setVisible(true);
    	
    	timer.start();
    	

    }
    
    public void loadImages()
    {
    	titleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.puttingTogetherPath)); 
		titleImage = titleImage.getScaledInstance(680, 60, Image.SCALE_SMOOTH);
		
		
    }
    
    public void paint(Graphics g)
    {
    	super.paint(g);
    	
    	g.drawImage(titleImage, 50, 5, this);
    	
    	g.setFont(new Font("Geneva", 1, 20));
    	g.drawString(explanation1, 20, 100);
    	g.drawString(explanation1cont, 20, 125);
    	
    	g.drawString(explanation2, 20, 160);
    	
    	if(countAnimation == 0)
    	{	
    		//101101
    		g.setColor(WelcomePage.textColor);
    		g.setFont(new Font("Geneva", 1, 150));
        	g.drawString(binaryOne, 50, 330);
        	g.drawString(binaryZero, 170, 330);
        	g.drawString(binaryOne, 290, 330);
        	g.drawString(binaryOne, 410, 330);
        	g.drawString(binaryZero, 530, 330);
        	g.drawString(binaryOne, 650, 330);
        	
        	g.setColor(WelcomePage.textColor);
        	g.setFont(new Font("Geneva", 1, 20));
        	g.drawString(thirtyTwosPlace, 45, 370);
        	g.drawString(place, 50, 390);
        	g.drawString(sixteensPlace, 175, 370);
        	g.drawString(place, 180, 390);
        	g.drawString(eightsPlace, 285, 370);
        	g.drawString(foursPlace, 410, 370);
        	g.drawString(twosPlace, 530, 370);
        	g.drawString(onesPlace, 650, 370);
        	
    	}
    	else if(countAnimation == 1)
    	{	
    		//101101
    		g.setColor(WelcomePage.textColor);
    		g.setFont(new Font("Geneva", 1, 150));
        	g.drawString(binaryOne, 50, 330);
        	g.drawString(binaryZero, 170, 330);
        	g.drawString(binaryOne, 290, 330);
        	g.drawString(binaryOne, 410, 330);
        	g.drawString(binaryZero, 530, 330);
        	g.drawString(binaryOne, 650, 330);
        	
 
        	g.setColor(WelcomePage.textColor);
        	g.setFont(new Font("Geneva", 1, 20));
        	g.drawString(thirtyTwosPlace, 45, 370);
        	g.drawString(place, 50, 390);
        	g.drawString(sixteensPlace, 175, 370);
        	g.drawString(place, 180, 390);
        	g.drawString(eightsPlace, 285, 370);
        	g.drawString(foursPlace, 410, 370);
        	g.drawString(twosPlace, 530, 370);
        	g.drawString(onesPlace, 650, 370);
        	
        	
        	g.setColor(Color.red);
        	g.drawRect(50, 195, 110, 150);

        	
        	g.setColor(WelcomePage.textColor);
        	g.setFont(new Font("Geneva", 1, 20));
        	
        	g.drawString(thirtyTwoMultiplication, 60, 425);
        	
        	g.setColor(WelcomePage.buttonPanelColor);
        	g.setFont(new Font("Geneva", 1, 30));
        	g.drawString(thirtyTwoMultiplicationAnswer, 70, 470);

    	}
    	else if(countAnimation == 2)
    	{	
    		//101101
    		g.setColor(WelcomePage.textColor);
    		g.setFont(new Font("Geneva", 1, 150));
        	g.drawString(binaryOne, 50, 330);
        	g.drawString(binaryZero, 170, 330);
        	g.drawString(binaryOne, 290, 330);
        	g.drawString(binaryOne, 410, 330);
        	g.drawString(binaryZero, 530, 330);
        	g.drawString(binaryOne, 650, 330);
        	
 
        	g.setColor(WelcomePage.textColor);
        	g.setFont(new Font("Geneva", 1, 20));
        	g.drawString(thirtyTwosPlace, 45, 370);
        	g.drawString(place, 50, 390);
        	g.drawString(sixteensPlace, 175, 370);
        	g.drawString(place, 180, 390);
        	g.drawString(eightsPlace, 285, 370);
        	g.drawString(foursPlace, 410, 370);
        	g.drawString(twosPlace, 530, 370);
        	g.drawString(onesPlace, 650, 370);
        	
        	
        	g.setColor(Color.red);
        	g.drawRect(170, 195, 110, 150);

        	
        	g.setColor(WelcomePage.textColor);
        	g.setFont(new Font("Geneva", 1, 20));
        	
        	g.drawString(thirtyTwoMultiplication, 60, 425);
        	g.drawString(sixteenMultiplication, 180, 425);

        	
        	
        	g.setColor(WelcomePage.buttonPanelColor);
        	g.setFont(new Font("Geneva", 1, 30));
        	g.drawString(thirtyTwoMultiplicationAnswer, 70, 470);
        	g.drawString(sixteenMultiplicationAnswer, 195, 470);
        	
        	
    	}
    	else if(countAnimation == 3)
    	{	
    		//101101
    		g.setColor(WelcomePage.textColor);
    		g.setFont(new Font("Geneva", 1, 150));
        	g.drawString(binaryOne, 50, 330);
        	g.drawString(binaryZero, 170, 330);
        	g.drawString(binaryOne, 290, 330);
        	g.drawString(binaryOne, 410, 330);
        	g.drawString(binaryZero, 530, 330);
        	g.drawString(binaryOne, 650, 330);
        	
 
        	g.setColor(WelcomePage.textColor);
        	g.setFont(new Font("Geneva", 1, 20));
        	g.drawString(thirtyTwosPlace, 45, 370);
        	g.drawString(place, 50, 390);
        	g.drawString(sixteensPlace, 175, 370);
        	g.drawString(place, 180, 390);
        	g.drawString(eightsPlace, 285, 370);
        	g.drawString(foursPlace, 410, 370);
        	g.drawString(twosPlace, 530, 370);
        	g.drawString(onesPlace, 650, 370);
        	
        	
        	g.setColor(Color.red);
        	g.drawRect(290, 195, 110, 150);

        	
        	g.setColor(WelcomePage.textColor);
        	g.setFont(new Font("Geneva", 1, 20));
        	
        	g.drawString(thirtyTwoMultiplication, 60, 425);
        	g.drawString(sixteenMultiplication, 180, 425);
        	g.drawString(eightMultiplication, 305, 425);
        	
        	
        	g.setColor(WelcomePage.buttonPanelColor);
        	g.setFont(new Font("Geneva", 1, 30));
        	g.drawString(thirtyTwoMultiplicationAnswer, 70, 470);
        	g.drawString(sixteenMultiplicationAnswer, 195, 470);
        	g.drawString(eightMultiplicationAnswer, 320, 470);
        	
    	}
    	
    	else if (countAnimation == 4)
    	{
    		//101101
    		g.setColor(WelcomePage.textColor);
    		g.setFont(new Font("Geneva", 1, 150));
        	g.drawString(binaryOne, 50, 330);
        	g.drawString(binaryZero, 170, 330);
        	g.drawString(binaryOne, 290, 330);
        	g.drawString(binaryOne, 410, 330);
        	g.drawString(binaryZero, 530, 330);
        	g.drawString(binaryOne, 650, 330);
        	
 
        	g.setColor(WelcomePage.textColor);
        	g.setFont(new Font("Geneva", 1, 20));
        	g.drawString(thirtyTwosPlace, 45, 370);
        	g.drawString(place, 50, 390);
        	g.drawString(sixteensPlace, 175, 370);
        	g.drawString(place, 180, 390);
        	g.drawString(eightsPlace, 285, 370);
        	g.drawString(foursPlace, 410, 370);
        	g.drawString(twosPlace, 530, 370);
        	g.drawString(onesPlace, 650, 370);
        	
        	
        	g.setColor(Color.red);
          	g.drawRect(410, 195, 110, 150);

        	
        	g.setColor(WelcomePage.textColor);
        	g.setFont(new Font("Geneva", 1, 20));
        	
        	g.drawString(thirtyTwoMultiplication, 60, 425);
        	g.drawString(sixteenMultiplication, 180, 425);
        	g.drawString(eightMultiplication, 305, 425);
        	g.drawString(fourMultiplication, 425, 425);
        	
        	
        	g.setColor(WelcomePage.buttonPanelColor);
        	g.setFont(new Font("Geneva", 1, 30));
        	g.drawString(thirtyTwoMultiplicationAnswer, 70, 470);
        	g.drawString(sixteenMultiplicationAnswer, 195, 470);
        	g.drawString(eightMultiplicationAnswer, 320, 470);
        	g.drawString(fourMultiplicationAnswer, 440, 470);
        	
        	
    	}
    	else if(countAnimation ==5)
    	{
    		//101101
    		g.setColor(WelcomePage.textColor);
    		g.setFont(new Font("Geneva", 1, 150));
        	g.drawString(binaryOne, 50, 330);
        	g.drawString(binaryZero, 170, 330);
        	g.drawString(binaryOne, 290, 330);
        	g.drawString(binaryOne, 410, 330);
        	g.drawString(binaryZero, 530, 330);
        	g.drawString(binaryOne, 650, 330);
        	
 
        	g.setColor(WelcomePage.textColor);
        	g.setFont(new Font("Geneva", 1, 20));
        	g.drawString(thirtyTwosPlace, 45, 370);
        	g.drawString(place, 50, 390);
        	g.drawString(sixteensPlace, 175, 370);
        	g.drawString(place, 180, 390);
        	g.drawString(eightsPlace, 285, 370);
        	g.drawString(foursPlace, 410, 370);
        	g.drawString(twosPlace, 530, 370);
        	g.drawString(onesPlace, 650, 370);
        	
        	
        	g.setColor(Color.red);
        	g.drawRect(530, 195, 110, 150);
        	
        	g.setColor(WelcomePage.textColor);
        	g.setFont(new Font("Geneva", 1, 20));
        	
        	g.drawString(thirtyTwoMultiplication, 60, 425);
        	g.drawString(sixteenMultiplication, 180, 425);
        	g.drawString(eightMultiplication, 305, 425);
        	g.drawString(fourMultiplication, 425, 425);
        	g.drawString(twoMultiplication, 545, 425);
        	
        	
        	g.setColor(WelcomePage.buttonPanelColor);
        	g.setFont(new Font("Geneva", 1, 30));
        	g.drawString(thirtyTwoMultiplicationAnswer, 70, 470);
        	g.drawString(sixteenMultiplicationAnswer, 195, 470);
        	g.drawString(eightMultiplicationAnswer, 320, 470);
        	g.drawString(fourMultiplicationAnswer, 440, 470);
        	g.drawString(twoMultiplicationAnswer, 560, 470);
        	
    	}
    	else if(countAnimation == 6)
    	{
    		//101101
    		g.setColor(WelcomePage.textColor);
    		g.setFont(new Font("Geneva", 1, 150));
        	g.drawString(binaryOne, 50, 330);
        	g.drawString(binaryZero, 170, 330);
        	g.drawString(binaryOne, 290, 330);
        	g.drawString(binaryOne, 410, 330);
        	g.drawString(binaryZero, 530, 330);
        	g.drawString(binaryOne, 650, 330);
        	
 
        	g.setColor(WelcomePage.textColor);
        	g.setFont(new Font("Geneva", 1, 20));
        	g.drawString(thirtyTwosPlace, 45, 370);
        	g.drawString(place, 50, 390);
        	g.drawString(sixteensPlace, 175, 370);
        	g.drawString(place, 180, 390);
        	g.drawString(eightsPlace, 285, 370);
        	g.drawString(foursPlace, 410, 370);
        	g.drawString(twosPlace, 530, 370);
        	g.drawString(onesPlace, 650, 370);
        	
        	
        	g.setColor(Color.red);
        	g.drawRect(650, 195, 110, 150);
        	
        	g.setColor(WelcomePage.textColor);
        	g.setFont(new Font("Geneva", 1, 20));
        	
        	g.drawString(thirtyTwoMultiplication, 60, 425);
        	g.drawString(sixteenMultiplication, 180, 425);
        	g.drawString(eightMultiplication, 305, 425);
        	g.drawString(fourMultiplication, 425, 425);
        	g.drawString(twoMultiplication, 545, 425);
        	g.drawString(oneMultiplication, 665, 425);
        	
        	
        	g.setColor(WelcomePage.buttonPanelColor);
        	g.setFont(new Font("Geneva", 1, 30));
        	g.drawString(thirtyTwoMultiplicationAnswer, 70, 470);
        	g.drawString(sixteenMultiplicationAnswer, 195, 470);
        	g.drawString(eightMultiplicationAnswer, 320, 470);
        	g.drawString(fourMultiplicationAnswer, 440, 470);
        	g.drawString(twoMultiplicationAnswer, 560, 470);
        	g.drawString(oneMultiplicationAnswer, 680, 470);
        	
    	}
    	else if(countAnimation == 7)
    	{
    		//101101
    		g.setColor(WelcomePage.textColor);
    		g.setFont(new Font("Geneva", 1, 150));
        	g.drawString(binaryOne, 50, 330);
        	g.drawString(binaryZero, 170, 330);
        	g.drawString(binaryOne, 290, 330);
        	g.drawString(binaryOne, 410, 330);
        	g.drawString(binaryZero, 530, 330);
        	g.drawString(binaryOne, 650, 330);
        	
 
        	g.setColor(WelcomePage.textColor);
        	g.setFont(new Font("Geneva", 1, 20));
        	g.drawString(thirtyTwosPlace, 45, 370);
        	g.drawString(place, 50, 390);
        	g.drawString(sixteensPlace, 175, 370);
        	g.drawString(place, 180, 390);
        	g.drawString(eightsPlace, 285, 370);
        	g.drawString(foursPlace, 410, 370);
        	g.drawString(twosPlace, 530, 370);
        	g.drawString(onesPlace, 650, 370);
        	
        	g.setColor(WelcomePage.textColor);
        	g.setFont(new Font("Geneva", 1, 20));
        	
        	g.drawString(thirtyTwoMultiplication, 60, 425);
        	g.drawString(sixteenMultiplication, 180, 425);
        	g.drawString(eightMultiplication, 305, 425);
        	g.drawString(fourMultiplication, 425, 425);
        	g.drawString(twoMultiplication, 545, 425);
        	g.drawString(oneMultiplication, 665, 425);
        	
        	
        	g.setColor(WelcomePage.buttonPanelColor);
        	g.setFont(new Font("Geneva", 1, 30));
        	g.drawString(thirtyTwoMultiplicationAnswer, 70, 470);
        	g.drawString(sixteenMultiplicationAnswer, 195, 470);
        	g.drawString(eightMultiplicationAnswer, 320, 470);
        	g.drawString(fourMultiplicationAnswer, 440, 470);
        	g.drawString(twoMultiplicationAnswer, 560, 470);
        	g.drawString(oneMultiplicationAnswer, 680, 470);
        	
        	
        	g.setColor(WelcomePage.textColor);
        	g.drawString(plusSign, 150, 470);
        	g.drawString(plusSign, 270, 470);
        	g.drawString(plusSign, 390, 470);
        	g.drawString(plusSign, 510, 470);
        	g.drawString(plusSign, 630, 470);
        	
    	}
    	else if(countAnimation >=8)
    	{
    		//101101
    		g.setColor(WelcomePage.textColor);
    		g.setFont(new Font("Geneva", 1, 150));
        	g.drawString(binaryOne, 50, 330);
        	g.drawString(binaryZero, 170, 330);
        	g.drawString(binaryOne, 290, 330);
        	g.drawString(binaryOne, 410, 330);
        	g.drawString(binaryZero, 530, 330);
        	g.drawString(binaryOne, 650, 330);
        	
 
        	g.setColor(WelcomePage.textColor);
        	g.setFont(new Font("Geneva", 1, 20));
        	g.drawString(thirtyTwosPlace, 45, 370);
        	g.drawString(place, 50, 390);
        	g.drawString(sixteensPlace, 175, 370);
        	g.drawString(place, 180, 390);
        	g.drawString(eightsPlace, 285, 370);
        	g.drawString(foursPlace, 410, 370);
        	g.drawString(twosPlace, 530, 370);
        	g.drawString(onesPlace, 650, 370);
        	
        	g.setColor(WelcomePage.textColor);
        	g.setFont(new Font("Geneva", 1, 20));
        	
        	g.drawString(thirtyTwoMultiplication, 60, 425);
        	g.drawString(sixteenMultiplication, 180, 425);
        	g.drawString(eightMultiplication, 305, 425);
        	g.drawString(fourMultiplication, 425, 425);
        	g.drawString(twoMultiplication, 545, 425);
        	g.drawString(oneMultiplication, 665, 425);
        	
        	
        	g.setColor(WelcomePage.buttonPanelColor);
        	g.setFont(new Font("Geneva", 1, 30));
        	g.drawString(thirtyTwoMultiplicationAnswer, 70, 470);
        	g.drawString(sixteenMultiplicationAnswer, 195, 470);
        	g.drawString(eightMultiplicationAnswer, 320, 470);
        	g.drawString(fourMultiplicationAnswer, 440, 470);
        	g.drawString(twoMultiplicationAnswer, 560, 470);
        	g.drawString(oneMultiplicationAnswer, 680, 470);
        	
        	
        	g.setColor(WelcomePage.textColor);
        	g.drawString(plusSign, 150, 470);
        	g.drawString(plusSign, 270, 470);
        	g.drawString(plusSign, 390, 470);
        	g.drawString(plusSign, 510, 470);
        	g.drawString(plusSign, 630, 470);
        	
        	g.drawString(equalSign, 620, 540);
        	
        	g.setColor(WelcomePage.buttonPanelColor);
        	g.drawString("45", 650, 540);
        	
    	}
    	
    }
    
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
