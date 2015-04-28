


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
	public Timer timer;
	private int DELAY = 2000;
	private int countAnimation = 0;
	
    //text used on screen
    private final String explanation1 = "Combined, these numbers tell devices, like the computer you're on now,";
    private final String explanation1cont = "what to do and when to do it!";
    
    private final String explanation2 = "One binary digit is called a bit.";
    private final String explanation3 = "Computers have to store trillions of these bits to do all of the ";
    private final String explanation3cont = "cool things we love!";
    private final String exampleBit = "Ex. 11010 is 5 bits long";
    
    private final String b = "B";
    private final String i = "I";
    private final String n = "N";
    private final String a = "A";
    private final String r = "R";
    private final String y = "Y";
    
    private final String d = "D";
    private final String letterG = "G";
    private final String t = "T";
    
    //position of text on screen
    private final int bitTextY = 320;
    private final int explanationX = 30;
    
    private final int titleImageX = 5;
    private final int titleImageY = 5;
    
    private final int explanation1Y = 80;
    private final int explanation1contY = 110;
    private final int explanation2Y = 200;
    
    private final int explanation3Y = 420;
    private final int explanation3contY = 445;
    
    private final int binaryImageX = 525;
    private final int binaryImageY = 130;
    
    private final int bXcoord = 20;
    private final int iXcoord1 = 60; 
    private final int nXcoord = 90; 
    private final int aXcoord = 140;
    private final int rXcoord = 190;
    private final int yXcoord = 230;
    
    private final int dXcoord = 320;
    private final int iXcoord2 = 370;
    private final int gXcoord = 400;
    private final int iXcoord3 = 450;
    private final int tXcoord = 475;
    
    private final int finalBXcoord = 140;
    private final int finalIXcoord = 200;
    private final int finalTXcoord = 230;
    
    private Controller controller;
    
    //constructor
    public TerceraPage(Controller welcome)
    {
    	controller = welcome;
    	
    	timer = new Timer(DELAY, this);
    	setBackground(Controller.backgroundColor);
    	setVisible(true);
    	
 
    }
    
    //displays different text and images on screen, allowing for animation
    //of how binary digit-->bit
    public void paint(Graphics g)
    {
    	super.paint(g);
    	
    	g.drawImage(controller.thirdPageTitleImage, titleImageX, titleImageY, this);
    	
    	g.setColor(Color.black);
    	g.setFont(new Font("Geneva", 1, 20));
    	g.drawString(explanation1, explanationX, explanation1Y);
    	g.drawString(explanation1cont, explanationX, explanation1contY);
    	
    	g.drawString(explanation2, explanationX, explanation2Y);
    	g.drawImage(controller.binaryDigitImage, binaryImageX, binaryImageY, this);
    	
    	g.drawString(explanation3, explanationX, explanation3Y);
    	g.drawString(explanation3cont, explanationX, explanation3contY);
    	
    	//initially, binary digit is displayed
    	if(countAnimation ==0)
    	{
    		g.setFont(new Font("Geneva", 1, 60));
    		g.setColor(Controller.textColor);
    		g.drawString(b, bXcoord, bitTextY);
    		g.drawString(i, iXcoord1, bitTextY);
    		g.drawString(n, nXcoord, bitTextY);
    		g.drawString(a, aXcoord, bitTextY);
    		g.drawString(r, rXcoord, bitTextY);
    		g.drawString(y, yXcoord, bitTextY);
    		
    		g.drawString(d, dXcoord, bitTextY);
    		g.drawString(i, iXcoord2, bitTextY);
    		g.drawString(letterG, gXcoord, bitTextY);
    		g.drawString(i, iXcoord3, bitTextY);
    		g.drawString(t, tXcoord, bitTextY);
    		
    	}
    	//then the requisite letters in the portmanteau are displayed 
    	if(countAnimation == 1)
    	{
    		g.setFont(new Font("Geneva", 1, 60));
    		g.setColor(Color.red);
    		g.drawString(b, bXcoord, bitTextY);
    		
    		g.setColor(Controller.textColor);
    		g.drawString(i, iXcoord1, bitTextY);
    		g.drawString(n, nXcoord, bitTextY);
    		g.drawString(a, aXcoord, bitTextY);
    		g.drawString(r, rXcoord, bitTextY);
    		g.drawString(y, yXcoord, bitTextY);
    		
    		g.drawString(d, dXcoord, bitTextY);
    		g.drawString(i, iXcoord2, bitTextY);
    		g.drawString(letterG, gXcoord, bitTextY);
    		
    		g.setColor(Color.red);
    		g.drawString(i, iXcoord3, bitTextY);
    		g.drawString(t, tXcoord, bitTextY);
    		
    		
    	}
    	//finally, the derivation of BIT from binary digit is completed
    	if(countAnimation == 2)
    	{
    		g.setFont(new Font("Geneva", 1, 60));
    		g.setColor(Color.red);
    		g.drawString(b, bXcoord, bitTextY);
    		g.drawString(i, iXcoord3, bitTextY);
    		g.drawString(t, tXcoord, bitTextY);
	
    	}
    	//final animation that stays on screen
    	if(countAnimation >= 3)
    	{
    		g.setFont(new Font("Geneva", 1, 80));
    		g.setColor(Controller.buttonPanelColor);
    		g.drawString(b, finalBXcoord, bitTextY);
    		g.drawString(i, finalIXcoord, bitTextY);
    		g.drawString(t, finalTXcoord, bitTextY);
    		
    		g.setColor(Controller.textColor);
    		g.setFont(new Font("Geneva", 1, 20));
    		g.drawString(exampleBit, explanationX, 360);
    		
    	}
    	
    		
    } //end paint
    
    
    
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


