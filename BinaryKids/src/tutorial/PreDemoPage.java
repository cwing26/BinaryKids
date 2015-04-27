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


/* This class serves as the seventh view in the introductory learning module, 
 * introducing the student to the derivation of digits/places for decimal numbers 
 * with an animation
 */
@SuppressWarnings("serial")
public class PreDemoPage extends JPanel implements ActionListener
{
    //timer handles animation and delay
	private Timer timer;
	private int DELAY = 3000;
	int countAnimation = 0;
	
	//images
	public Image titleImage;
	public Image crossOutImage;
    
    
	//text used on screen and in animation
	String explanation1 = "Decimal numbers have digits that represent different places!";
    String explanation1cont = "Each digit represents a power of 10, from small to large";
    String explanation2 = "Decimal numbers are written in base 10. ";
    String explanation2cont = "This means that they can have digits from 0-9";
    String explanation3 = "If a digit goes above 9, then instead of adding 10 there, ";
    String explanation3cont = "1 is added to the place directly larger than it.";
    
    String number4 = "4";
    String number3 = "3";
    String number8 = "8";
    String number9 = "9";
    String number10 = "10";
    String number0 = "0";
    
    String hundredsPlace = "Hundreds Place";
    String tensPlace = "Tens Place";
    String onesPlace = "Ones Place";
    
    String baseTen0 = "1";
    String baseTen1 = "10";
    String baseTen2 = "10x10";
    
    //coordinates for screen elements
    private final int titleImageX = 70;
    private final int titleImageY = 10;
    
    private final int explanation1X = 100;
    private final int explanation1Y = 100;
    private final int explanation1contY = 125;
    
    private final int explanation2X = 30;
    private final int explanation2Y = 440;
    private final int explanation2contY = 465;
    
    private final int explanation3X = 190;
    private final int explanation3Y = 520;
    private final int explanation3contX = 240;
    private final int explanation3contY = 545;
    
    private final int hundredsPlaceX = 100;
    private final int tensPlaceX = 310;
    private final int onesPlaceX = 510;
    private final int placesY = 350;
    
    private final int basesY = 380;
    private final int baseTen2X = 150;
    private final int baseTen1X = 340;
    private final int baseTen0X = 540;
    
    private final int rectWidth = 5;
    private final int rectHeight = 200;
    private final int rect1X = 250;
    private final int rect2X = 450;
    private final int rectY = 180;
    
    private final int displayNumY = 300;
    private final int firstDisplayNumX = 100;
    private final int secondDisplayNumX = 300;
    private final int thirdDisplayNumX = 500;
    
    private final int crossOutX = 500;
    private final int crossOutY = 150;
    
    //constructor
    public PreDemoPage()
    {

    	loadImages();

    	setBackground(WelcomePage.backgroundColor);
    	
    	timer = new Timer(DELAY, this);
		timer.start();
		
    	setVisible(true);

    }
    
    //displays the various components of the page and animation on screen,
    //changing the display based on the state of animation
    public void paint(Graphics g)
    {
    	super.paint(g);
    	
    	g.drawImage(titleImage, titleImageX, titleImageY, this);
    	
    	//strings and explanations
    	g.setColor(Color.black);
    	g.setFont(new Font("Geneva", 1, 20));
    	g.drawString(explanation1, explanation1X, explanation1Y);
    	g.drawString(explanation1cont, explanation1X, explanation1contY);
    	
    	g.drawString(explanation2, explanation2X, explanation2Y);
    	g.drawString(explanation2cont, explanation2X, explanation2contY);
    	
    	g.drawString(explanation3, explanation3X, explanation3Y);
    	g.drawString(explanation3cont, explanation3contX, explanation3contY);
	    	
    	g.setFont(new Font("Geneva", 1, 15));
    	g.setColor(WelcomePage.textColor);
    	g.drawString(hundredsPlace, hundredsPlaceX, placesY);
    	g.drawString(tensPlace, tensPlaceX, placesY);
    	g.drawString(onesPlace, onesPlaceX, placesY);
	    	
    	g.fillRect(rect1X, rectY, rectWidth, rectHeight);
    	g.fillRect(rect2X, rectY, rectWidth, rectHeight);
	    	
    	g.drawString(baseTen2, baseTen2X, basesY);
    	g.drawString(baseTen1, baseTen1X, basesY);
    	g.drawString(baseTen0, baseTen0X, basesY);
    	
    	//displays numbers
    	if(countAnimation == 0)
    	{
        	g.setFont(new Font("Geneva", 1, 150));
        	g.setColor(WelcomePage.buttonPanelColor);
        	g.drawString(number4, firstDisplayNumX, displayNumY);
        	g.drawString(number3, secondDisplayNumX, displayNumY);
        	g.drawString(number8, 500, displayNumY);
    	}
    	//increase count by 1
    	else if(countAnimation == 1)
    	{
	    	g.setFont(new Font("Geneva", 1, 150));
	    	g.setColor(WelcomePage.buttonPanelColor);
	    	g.drawString(number4, firstDisplayNumX, displayNumY);
	    	g.drawString(number3, secondDisplayNumX, displayNumY);
	    	g.drawString(number9, thirdDisplayNumX, displayNumY);
	    	
    	}
    	//increase count by 1
    	else if(countAnimation == 2)
    	{

	    	g.setFont(new Font("Geneva", 1, 150));
	    	g.setColor(WelcomePage.buttonPanelColor);
	    	g.drawString(number4, firstDisplayNumX, displayNumY);
	    	g.drawString(number3, secondDisplayNumX, displayNumY);
	    	g.drawString(number10, thirdDisplayNumX, displayNumY);
	    	
    	}
    	else if(countAnimation == 3)
    	{
	    	g.setFont(new Font("Geneva", 1, 150));
	    	g.setColor(WelcomePage.buttonPanelColor);
	    	g.drawString(number4, firstDisplayNumX, displayNumY);
	    	g.drawString(number3, secondDisplayNumX, displayNumY);
	    	g.drawString(number10, thirdDisplayNumX, displayNumY);
	    	
	    	//draws an x over the 10 to signify that we can't count to 10
	    	g.drawImage(crossOutImage, crossOutX, crossOutY, this);
	    	
    	}
    	//final number count
    	else if(countAnimation >= 4)
    	{
	    	g.setFont(new Font("Geneva", 1, 150));
	    	g.setColor(WelcomePage.buttonPanelColor);
	    	g.drawString(number4, firstDisplayNumX, displayNumY);
	    	g.drawString(number4, secondDisplayNumX, displayNumY);
	    	g.drawString(number0, thirdDisplayNumX, displayNumY);
	    	
    	}

    }
    
    //loads images to display
    public void loadImages()
    {
    	titleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.decBasicsPath)); 
		titleImage = titleImage.getScaledInstance(650, 40, Image.SCALE_SMOOTH);
		
		
		crossOutImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.crossOutPath)); 
		crossOutImage = crossOutImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);

    }
    
	
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
	
    

}
