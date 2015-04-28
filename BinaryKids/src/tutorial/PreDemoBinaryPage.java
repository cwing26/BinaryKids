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


@SuppressWarnings("serial")
public class PreDemoBinaryPage extends JPanel implements ActionListener
{
    //fonts used on page
	Font displayFont = new Font("Geneva", 1, 150);
	Font textFont = new Font("Geneva", 1, 20);
	Font labelFont = new Font("Geneva", 1, 15);
	
	//timer handles animation and delay
	private Timer timer;
	private int DELAY = 3000;
	int countAnimation = 0;
	
	//images
	public Image titleImage;
	public Image crossOutImage;
    
	//text used on page
    String explanation1 = "The same goes for binary numbers!";
    String explanation1cont = "Binary numbers have digits that represent different places!";
    String explanation1cont2 = "Each digit represents a power of 2, from small to large";
    String explanation2 = "Binary numbers are written in base 2. ";
    String explanation2cont = "This means that they can have digits from 0-1";
    String explanation3 = "If a digit goes above 1, then instead of adding 2 there, ";
    String explanation3cont = "1 is added to the place directly larger than it.";
    
    
    String number1 = "1";
    String number0 = "0";
    String number2 = "2";
    
    String foursPlace = "Fours Place";
    String twosPlace = "Twos Place";
    String onesPlace = "Ones Place";
    
    String baseTwo0 = "1";
    String baseTwo1 = "2";
    String baseTwo2 = "2x2";
    
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
    
    
    
    //constructor
    public PreDemoBinaryPage()
    {
    	setBackground(WelcomePage.backgroundColor);
    	setLayout(null);
    	
    	loadImages();
    	
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
    	g.setFont(textFont);
    	g.drawString(explanation1, explanation1X, explanation1Y);
    	g.drawString(explanation1cont, explanation1X, explanation1contY);
    	g.drawString(explanation1cont2, explanation1X, explanation1cont2Y);
    	
    	g.drawString(explanation2, explanation2X, explanation2Y);
    	g.drawString(explanation2cont, explanation2X, explanation2contY);
    	
    	g.drawString(explanation3, explanation3X, explanation3Y);
    	g.drawString(explanation3cont, explanation3contX, explanation3contY);
    	
    	g.setFont(labelFont);
    	g.setColor(WelcomePage.textColor);
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
        	g.setColor(WelcomePage.buttonPanelColor);
        	g.drawString(number1, firstDisplayNumX, displayNumY);
        	g.drawString(number0, secondDisplayNumX, displayNumY);
        	g.drawString(number0, thirdDisplayNumX, displayNumY);
    	}
    	else if(countAnimation == 1)
    	{
	    	g.setFont(displayFont);
	    	g.setColor(WelcomePage.buttonPanelColor);
	    	g.drawString(number1, firstDisplayNumX, displayNumY);
	    	g.drawString(number0, secondDisplayNumX, displayNumY);
	    	g.drawString(number1, thirdDisplayNumX, displayNumY);
	    	
    	}
    	else if(countAnimation == 2)
    	{
    		g.setFont(displayFont);
	    	g.setColor(WelcomePage.buttonPanelColor);
	    	g.drawString(number1, firstDisplayNumX, displayNumY);
	    	g.drawString(number0, secondDisplayNumX, displayNumY);
	    	g.drawString(number2, thirdDisplayNumX, displayNumY);
	    	
    	}
    	else if(countAnimation == 3)
    	{
    		g.setFont(displayFont);
	    	g.setColor(WelcomePage.buttonPanelColor);
	    	g.drawString(number1, firstDisplayNumX, displayNumY);
	    	g.drawString(number0, secondDisplayNumX, displayNumY);
	    	g.drawString(number2, thirdDisplayNumX, displayNumY);
	    	
	    	//draws an x over the 2 to signify that we can't count to 2
	    	g.drawImage(crossOutImage, crossOutX, crossOutY, this);
	    	
    	}
    	else if(countAnimation >= 4)
    	{
    		g.setFont(displayFont);
	    	g.setColor(WelcomePage.buttonPanelColor);
	    	g.drawString(number1, firstDisplayNumX, displayNumY);
	    	g.drawString(number1, secondDisplayNumX, displayNumY);
	    	g.drawString(number0, thirdDisplayNumX, displayNumY);
	    	
    	}

    } //end paint method
    
    
    //loads images to display
    public void loadImages()
    {
    	titleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.binBasicsPath)); 
		titleImage = titleImage.getScaledInstance(600, 50, Image.SCALE_SMOOTH);
		
		
		crossOutImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.crossOutPath)); 
		crossOutImage = crossOutImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		

    }
    
	
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
