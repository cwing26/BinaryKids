package tutorial;

//imports
import java.awt.Graphics;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;


/* This class serves as the second view in the introductory learning module, 
 * introducing the student to binary numbers and their definition 
 * with images 
 */
@SuppressWarnings("serial")
public class NumRepresentationPage2 extends JPanel
{
	//images
	private Image titleImage;
	private Image dogImage;
	private Image bikeImage;
	private Image binocImage;
	
	//text used on screen
	private final String explanation1 = "Binary numbers are used to count things, just like normal numbers! ";
	private final String explanation2 = "But binary numbers are made up of only 0s or 1s";
	private final String explanation3 = "The word 'Binary' comes from the root 'bi-' meaning 2.";
	
	private final String bike = "Bicycle";
	private final String bike1 = "(2 wheels)";
	private final String binoculars = "Binoculars";
	private final String binoculars2 = "(2 eyes)";
	
	//positions of various text and image components
	private final int ex1X = 40;
	private final int ex1Y = 100;
	
	private final int ex2X = 295;
	private final int ex2Y = 200;
	
	private final int ex3X = 40;
	private final int ex3Y = 400;
	
	private final int bikeX = 100;
	private final int bikeY = 435;
	
	private final int bike1X = 100;
	private final int bike1Y = 455;
	
	private final int binocularsX = 450;
	private final int binocularsY = 435;
	
	private final int binoculars1X = 450;
	private final int binoculars1Y = 455;
	
	private final int titleImageX = 45;
	private final int titleImageY = 10;
	
	private final int dogImageX = 120;
	private final int dogImageY = 125;
	
	private final int bikeImageX = 150;
	private final int bikeImageY = 430;
	
	private final int binocImageX = 500;
	private final int binocImageY = 415;
			
    
	//constructor simply sets the background color
    public NumRepresentationPage2()
    {

    	setBackground(WelcomePage.backgroundColor);
    	
    	loadImages();
    	
    	
    	setVisible(true);
    }
    
    //used to draw all components of screen in proper position
    public void paint(Graphics g) 
    { 
    	super.paint(g);
    	
    	g.drawImage(titleImage, titleImageX, titleImageY, this);
    	
    	g.setFont(new Font("Geneva", 1, 20));
    	
    	g.drawString(explanation1, ex1X, ex1Y);
    	g.drawString(explanation2, ex2X, ex2Y);
    	g.drawString(explanation3, ex3X, ex3Y);
    	
    	g.setColor(WelcomePage.buttonPanelColor);
    	g.setFont(new Font("Geneva", 1, 15));
    	
    	g.drawString(bike, bikeX, bikeY);
    	g.drawString(bike1, bike1X, bike1Y);
    	g.drawString(binoculars, binocularsX, binocularsY);
    	g.drawString(binoculars2, binoculars1X, binoculars1Y);
    	
    	g.drawImage(dogImage, dogImageX, dogImageY, this);
    	g.drawImage(bikeImage, bikeImageX, bikeImageY, this );
    	g.drawImage(binocImage, binocImageX, binocImageY, this );
    	


    }
    
    //TRANSFER TO MAIN
    public void loadImages()
    {
		titleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.whatBinaryTitlePath)); 
		titleImage = titleImage.getScaledInstance(673, 50, Image.SCALE_SMOOTH);
		
		dogImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.dogBinaryImagePath)); 
		dogImage = dogImage.getScaledInstance(121, 224, Image.SCALE_SMOOTH);
		
		bikeImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.bikeImagePath)); 
		bikeImage = bikeImage.getScaledInstance(192, 124, Image.SCALE_SMOOTH);
		
		binocImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.binocularsPath)); 
		binocImage = binocImage.getScaledInstance(166, 159, Image.SCALE_SMOOTH);
	
		
    }


}
