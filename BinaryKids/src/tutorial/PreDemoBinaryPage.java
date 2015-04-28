package tutorial;


import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.Timer;
import java.awt.Color;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;

/* This class serves as the eighth view in the introductory learning module, 
 * introducing the student to the derivation of digits/places for binary numbers 
 * with an animation
 */
@SuppressWarnings("serial")
public class PreDemoBinaryPage extends JPanel implements ActionListener
{
    //fonts used on page
	private Font displayFont = new Font("Geneva", 1, 150);
	private Font textFont = new Font("Geneva", 1, 20);
	private Font labelFont = new Font("Geneva", 1, 15);
	
	//timer handles animation and delay
	public Timer timer;
	private int DELAY = 3000;
	private int countAnimation = 0;
	
	//text used on page
    private final String explanation1 = "The same goes for binary numbers!";
    private final String explanation1cont = "Binary numbers have digits that represent different places!";
    private final String explanation1cont2 = "Each digit represents a power of 2, from small to large";
    private final String explanation2 = "Binary numbers are written in base 2. ";
    private final String explanation2cont = "This means that they can have digits from 0-1";
    private final String explanation3 = "If a digit goes above 1, then instead of adding 2 there, ";
    private final String explanation3cont = "1 is added to the place directly larger than it.";
    
    
    private final String number1 = "1";
    private final String number0 = "0";
    private final String number2 = "2";
    
    private final String foursPlace = "Fours Place";
    private final String twosPlace = "Twos Place";
    private final String onesPlace = "Ones Place";
    
    private final String baseTwo0 = "1";
    private final String baseTwo1 = "2";
    private final String baseTwo2 = "2x2";
    
    //coordinates for screen elements
    private final int titleImageX = 100;
    private final int titleImageY = 10;
    
    private final int explanation1X = 30;
    private final int explanation1Y = 90;
    private final int explanation1contY = 120;
    private final int explanation1cont2Y = 145;
    
    private final int explanation2X = 30;
    private final int explanation2Y = 440;
    private final int explanation2contY = 465;
    
    private final int explanation3X = 190;
    private final int explanation3Y = 520;
    private final int explanation3contX = 240;
    private final int explanation3contY = 545;
    
    private final int displayNumY = 300;
    private final int firstDisplayNumX = 100;
    private final int secondDisplayNumX = 300;
    private final int thirdDisplayNumX = 500;
    
    private final int crossOutX = 470;
    private final int crossOutY = 150;
    
    private final int rectWidth = 5;
    private final int rectHeight = 200;
    private final int rect1X = 250;
    private final int rect2X = 450;
    private final int rectY = 180;
    
    private final int foursPlaceX = 100;
    private final int twosPlaceX = 310;
    private final int onesPlaceX = 510;
    private final int placesY = 350;
    
    private final int basesY = 380;
    private final int baseTwo2X = 150;
    private final int baseTwo1X = 340;
    private final int baseTwo0X = 540;
    
    private Controller controller;
    
    //constructor
    public PreDemoBinaryPage(Controller welcome)
    {
    	controller = welcome;
    	
    	setBackground(Controller.backgroundColor);
    	setLayout(null);
    	

    	timer = new Timer(DELAY, this);
    	

		
    	setVisible(true);

    }
    
  //displays the various components of the page and animation on screen,
    //changing the display based on the state of animation
    public void paint(Graphics g)
    {
    	super.paint(g);
    	
    	g.drawImage(controller.preDemoBinaryTitleImage, titleImageX, titleImageY, this);
    	
    	//strings and explanations
    	g.setColor(Color.black);
    	g.setFont(textFont);
    	g.drawString(explanation1, explanation1X, explanation1Y);
    	g.drawString(explanation1cont, explanation1X, explanation1contY);
    	g.drawString(explanation1cont2, explanation1X, explanation1cont2Y);
    	
    	g.drawString(explanation2, explanation2X, explanation2Y);
    	g.drawString(explanation2cont, explanation2X, explanation2contY);
    	
    	g.drawString(explanation3, explanation3X, explanation3Y);
    	g.drawString(explanation3cont, explanation3contX, explanation3contY);
    	
    	g.setFont(labelFont);
    	g.setColor(Controller.textColor);
    	g.drawString(foursPlace, foursPlaceX, placesY);
    	g.drawString(twosPlace, twosPlaceX, placesY);
    	g.drawString(onesPlace, onesPlaceX, placesY);
	    	
    	g.fillRect(rect1X, rectY, rectWidth, rectHeight);
    	g.fillRect(rect2X, rectY, rectWidth, rectHeight);
	    
    	g.drawString(baseTwo2, baseTwo2X, basesY);
    	g.drawString(baseTwo1, baseTwo1X, basesY);
    	g.drawString(baseTwo0, baseTwo0X, basesY);
    	
    	
    	if(countAnimation == 0)
    	{
        	g.setFont(displayFont);
        	g.setColor(Controller.buttonPanelColor);
        	g.drawString(number1, firstDisplayNumX, displayNumY);
        	g.drawString(number0, secondDisplayNumX, displayNumY);
        	g.drawString(number0, thirdDisplayNumX, displayNumY);
    	}
    	else if(countAnimation == 1)
    	{
	    	g.setFont(displayFont);
	    	g.setColor(Controller.buttonPanelColor);
	    	g.drawString(number1, firstDisplayNumX, displayNumY);
	    	g.drawString(number0, secondDisplayNumX, displayNumY);
	    	g.drawString(number1, thirdDisplayNumX, displayNumY);
	    	
    	}
    	else if(countAnimation == 2)
    	{
    		g.setFont(displayFont);
	    	g.setColor(Controller.buttonPanelColor);
	    	g.drawString(number1, firstDisplayNumX, displayNumY);
	    	g.drawString(number0, secondDisplayNumX, displayNumY);
	    	g.drawString(number2, thirdDisplayNumX, displayNumY);
	    	
    	}
    	else if(countAnimation == 3)
    	{
    		g.setFont(displayFont);
	    	g.setColor(Controller.buttonPanelColor);
	    	g.drawString(number1, firstDisplayNumX, displayNumY);
	    	g.drawString(number0, secondDisplayNumX, displayNumY);
	    	g.drawString(number2, thirdDisplayNumX, displayNumY);
	    	
	    	//draws an x over the 2 to signify that we can't count to 2
	    	g.drawImage(controller.crossOutImage, crossOutX, crossOutY, this);
	    	
    	}
    	else if(countAnimation >= 4)
    	{
    		g.setFont(displayFont);
	    	g.setColor(Controller.buttonPanelColor);
	    	g.drawString(number1, firstDisplayNumX, displayNumY);
	    	g.drawString(number1, secondDisplayNumX, displayNumY);
	    	g.drawString(number0, thirdDisplayNumX, displayNumY);
	    	
    	}

    } //end paint method
    
    
    
	
    //increments as the timer progresses to determine what stage
    //of animation the page is in
	@Override
    public void actionPerformed(ActionEvent e) 
	{
		
		if(countAnimation < 6)
		{	
			countAnimation++;
		}
		else
			timer.stop();
		
        repaint();
    }
	
    

}
