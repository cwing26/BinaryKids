package tutorial;


import java.awt.Graphics;
import java.awt.Font;
import java.awt.Image;
import java.awt.Toolkit;
import javax.swing.JPanel;


@SuppressWarnings("serial")
public class NumRepresentationPage2 extends JPanel
{

	public Image titleImage;
	public Image dogImage;
	public Image bikeImage;
	public Image binocImage;
	
	String explanation1 = "Binary numbers are used to count things, just like normal numbers! ";
	String explanation2 = "But binary numbers are made up of only 0s or 1s";
	String explanation3 = "The word 'Binary' comes from the root 'bi-' meaning 2.";
	
	String bike = "Bicycle";
	String bike1 = "(2 wheels)";
	String binoculars = "Binoculars";
	String binoculars2 = "(2 eyes)";
			
    
    public NumRepresentationPage2()
    {

    	setBackground(WelcomePage.backgroundColor);
    	
    	loadImages();
    	
    	
    	setVisible(true);
    }
    
    public void paint(Graphics g) 
    { 
    	super.paint(g);
    	
    	g.drawImage(titleImage, 45, 10, this);
    	
    	g.setFont(new Font("Geneva", 1, 20));
    	g.drawString(explanation1, 40, 100);
    	g.drawString(explanation2, 295, 200);
    	g.drawString(explanation3, 40, 400);
    	
    	g.setColor(WelcomePage.buttonPanelColor);
    	g.setFont(new Font("Geneva", 1, 15));
    	
    	g.drawString(bike, 100, 435);
    	g.drawString(bike1, 100, 455);
    	g.drawString(binoculars, 450, 435);
    	g.drawString(binoculars2, 450, 455);
    	
    	g.drawImage(dogImage, 120, 125, this);
    	g.drawImage(bikeImage, 150, 430, this );
    	g.drawImage(binocImage, 500, 415, this );
    	


    }
    
    
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
