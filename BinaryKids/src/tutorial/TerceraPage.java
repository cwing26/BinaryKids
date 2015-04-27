


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


/* This class serves as the fifth view in the introductory learning module, 
 * introducing the student to the basics of binary numbers and their relationship to computers
 * with an animation about bits
 */
@SuppressWarnings("serial")
public class TerceraPage extends JPanel implements ActionListener
{
    //timer components to handle animations
	private Timer timer;
	private int DELAY = 2000;
	int countAnimation = 0;
	
	//images
	public Image titleImage;
	public Image binaryDigitImage;
	
    //text used on screen
    String explanation1 = "Combined, these numbers tell devices, like the computer you're on now,";
    String explanation1cont = "what to do and when to do it!";
    
    String explanation2 = "One binary digit is called a bit.";
    String explanation3 = "Computers have to store trillions of these bits to do all of the ";
    String explanation3cont = "cool things we love!";
    String exampleBit = "Ex. 11010 is 5 bits long";
    
    String b = "B";
    String i = "I";
    String n = "N";
    String a = "A";
    String r = "R";
    String y = "Y";
    
    String d = "D";
    String letterG = "G";
    String t = "T";
    
    //position of text on screen
    private final int bitTextY = 320;
    private final int explanationX = 30;
    
    private final int titleImageX = 5;
    private final int titleImageY = 5;
    
    //constructor
    public TerceraPage()
    {

    	loadImages();
    	
    	timer = new Timer(DELAY, this);
    	setBackground(WelcomePage.backgroundColor);
    	setVisible(true);
    	
    	timer.start();

    }
    
    //displays different text and images on screen, allowing for animation
    //of how binary digit-->bit
    public void paint(Graphics g)
    {
    	super.paint(g);
    	
    	g.drawImage(titleImage, titleImageX, titleImageY, this);
    	
    	g.setColor(Color.black);
    	g.setFont(new Font("Geneva", 1, 20));
    	g.drawString(explanation1, explanationX, 80);
    	g.drawString(explanation1cont, explanationX, 110);
    	
    	
    	g.drawString(explanation2, explanationX, 200);
    	g.drawImage(binaryDigitImage, 525, 130, this);
    	
    	g.drawString(explanation3, explanationX, 420);
    	g.drawString(explanation3cont, explanationX, 445);
    	
    	//initially, binary digit is displayed
    	if(countAnimation ==0)
    	{
    		g.setFont(new Font("Geneva", 1, 60));
    		g.setColor(WelcomePage.textColor);
    		g.drawString(b, 20, bitTextY);
    		g.drawString(i, 60, bitTextY);
    		g.drawString(n, 90, bitTextY);
    		g.drawString(a, 140, bitTextY);
    		g.drawString(r, 190, bitTextY);
    		g.drawString(y, 230, bitTextY);
    		
    		g.drawString(d, 320, bitTextY);
    		g.drawString(i, 370, bitTextY);
    		g.drawString(letterG, 400, bitTextY);
    		g.drawString(i, 450, bitTextY);
    		g.drawString(t, 475, bitTextY);
    		
    	}
    	//then the requisite letters in the portmanteau are displayed 
    	if(countAnimation == 1)
    	{
    		g.setFont(new Font("Geneva", 1, 60));
    		g.setColor(Color.red);
    		g.drawString(b, 20, bitTextY);
    		
    		g.setColor(WelcomePage.textColor);
    		g.drawString(i, 60, bitTextY);
    		g.drawString(n, 90, bitTextY);
    		g.drawString(a, 140, bitTextY);
    		g.drawString(r, 190, bitTextY);
    		g.drawString(y, 230, bitTextY);
    		
    		g.drawString(d, 320, bitTextY);
    		g.drawString(i, 370, bitTextY);
    		g.drawString(letterG, 400, bitTextY);
    		
    		g.setColor(Color.red);
    		g.drawString(i, 450, bitTextY);
    		g.drawString(t, 475, bitTextY);
    		
    	}
    	//finally, the derivation of BIT from binary digit is completed
    	if(countAnimation == 2)
    	{
    		g.setFont(new Font("Geneva", 1, 60));
    		g.setColor(Color.red);
    		g.drawString(b, 20, 320);    		
    		g.drawString(i, 450, 320);
    		g.drawString(t, 475, 320);

    		
    	}
    	if(countAnimation >= 3)
    	{
    		g.setFont(new Font("Geneva", 1, 80));
    		g.setColor(WelcomePage.buttonPanelColor);
    		g.drawString(b, 140, bitTextY);
    		g.drawString(i, 200, bitTextY);
    		g.drawString(t, 230, bitTextY);
    		
    		g.setColor(WelcomePage.textColor);
    		g.setFont(new Font("Geneva", 1, 20));
    		g.drawString(exampleBit, explanationX, 360);
    		
    	}
    	
    		
    } //end paint
    
    public void loadImages()
    {
    	titleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.whyBinaryImportantTitlePath)); 
		titleImage = titleImage.getScaledInstance(790, 43, Image.SCALE_SMOOTH);
	
		binaryDigitImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.binaryDigitPath)); 
		binaryDigitImage = binaryDigitImage.getScaledInstance(150, 157, Image.SCALE_SMOOTH);

    }
    
    //keeps track of the stage of animation to tell the 
    //paint method what to display
	@Override
    public void actionPerformed(ActionEvent e) 
	{
		
		if(countAnimation < 4)
		{	
			countAnimation++;
		}
		else
			timer.stop();
		
        repaint();
    }
	
    

}


