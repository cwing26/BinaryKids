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
    
	private Timer timer;
	private int DELAY = 3000;
	int countAnimation = 0;
	
	//images
	public Image titleImage;
	public Image crossOutImage;
    
    String explanation1 = "The same goes for binary numbers!";
    String explanation1cont = "Binary numbers have digits that represent different places!";
    String explanation1cont2 = "Each digit represents a power of 2, from small to large";
    String explanation2 = "Binary numbers are written in base 2. ";
    String explanation2cont = "This means that they can have digits from 0-1";
    String explanation3 = "If a digit goes above 1, then instead of adding 2 there, ";
    String explanation3cont = "1 is added to the place directly larger than it.";
    
    
    String number1 = "1";
    String number0 = "0";
    
    String foursPlace = "Fours Place";
    String twosPlace = "Twos Place";
    String onesPlace = "Ones Place";
    
    String baseTwo0 = "1";
    String baseTwo1 = "2";
    String baseTwo2 = "2x2";
    
    public PreDemoBinaryPage()
    {
    	setBackground(WelcomePage.backgroundColor);
    	setLayout(null);
    	
    	loadImages();
    	
    	timer = new Timer(DELAY, this);
    	
		
		timer.start();
		
    	setVisible(true);

    }
    
    public void paint(Graphics g)
    {
    	super.paint(g);
    	
    	g.drawImage(titleImage, 100, 10, this);
    	
    	//strings and explanations
    	g.setColor(Color.black);
    	g.setFont(new Font("Geneva", 1, 20));
    	g.drawString(explanation1, 30, 90);
    	g.drawString(explanation1cont, 30, 120);
    	g.drawString(explanation1cont2, 30, 145);
    	
    	g.drawString(explanation2, 30, 440);
    	g.drawString(explanation2cont, 30, 465);
    	
    	g.drawString(explanation3, 190, 520);
    	g.drawString(explanation3cont, 240, 545);
	    	
    	g.setFont(new Font("Geneva", 1, 15));
    	g.setColor(WelcomePage.textColor);
    	g.drawString(foursPlace, 100, 350);
    	g.drawString(twosPlace, 310, 350);
    	g.drawString(onesPlace, 510, 350);
	    	
    	g.fillRect(250, 180, 5, 200);
    	g.fillRect(450, 180, 5, 200);
	    	
    	g.drawString(baseTwo2, 150, 380);
    	g.drawString(baseTwo1, 340, 380);
    	g.drawString(baseTwo0, 540, 380);
    	
    	
    	if(countAnimation == 0)
    	{
        	g.setFont(new Font("Geneva", 1, 150));
        	g.setColor(WelcomePage.buttonPanelColor);
        	g.drawString(number1, 100, 300);
        	g.drawString(number0, 300, 300);
        	g.drawString(number0, 500, 300);
    	}
    	else if(countAnimation == 1)
    	{
	    	g.setFont(new Font("Geneva", 1, 150));
	    	g.setColor(WelcomePage.buttonPanelColor);
	    	g.drawString(number1, 100, 300);
	    	g.drawString(number0, 300, 300);
	    	g.drawString("1", 500, 300);
	    	
    	}
    	else if(countAnimation == 2)
    	{

	    	g.setFont(new Font("Geneva", 1, 150));
	    	g.setColor(WelcomePage.buttonPanelColor);
	    	g.drawString(number1, 100, 300);
	    	g.drawString(number0, 300, 300);
	    	g.drawString("2", 500, 300);
	    	
    	}
    	else if(countAnimation == 3)
    	{

	    	g.setFont(new Font("Geneva", 1, 150));
	    	g.setColor(WelcomePage.buttonPanelColor);
	    	g.drawString(number1, 100, 300);
	    	g.drawString(number0, 300, 300);
	    	g.drawString("2", 500, 300);
	    	
	    	//DRAW X OVER IT
	    	g.drawImage(crossOutImage, 470, 150, this);
	    	
    	}
    	else if(countAnimation >= 4)
    	{
	    	g.setFont(new Font("Geneva", 1, 150));
	    	g.setColor(WelcomePage.buttonPanelColor);
	    	g.drawString(number1, 100, 300);
	    	g.drawString("1", 300, 300);
	    	g.drawString("0", 500, 300);
	    	
    	}
    	
    	
    	
    }
    
    public void loadImages()
    {
    	titleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.binBasicsPath)); 
		titleImage = titleImage.getScaledInstance(600, 50, Image.SCALE_SMOOTH);
		
		
		crossOutImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.crossOutPath)); 
		crossOutImage = crossOutImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		

    }
    
	
    
	@Override
    public void actionPerformed(ActionEvent e) 
	{
		
		if(countAnimation < 15)
		{	
			countAnimation++;
		}
		else
			timer.stop();
		
        repaint();
    }
	
    

}
