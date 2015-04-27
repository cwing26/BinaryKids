


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


//create a binary stream and bits and shit

@SuppressWarnings("serial")
public class TerceraPage extends JPanel implements ActionListener
{
    
	private Timer timer;
	private int DELAY = 2000;
	int countAnimation = 0;
	
	//images
	public Image titleImage;
	public Image binaryDigitImage;
	
    
    String explanation1 = "Combined, these numbers tell devices, like the computer you're on now,";
    String explanation1cont = "what to do and when to do it!";
    
    String explanation2 = "One binary digit is called a bit.";
    String explanation3 = "Computers have to store trillions of these bits to do all of the ";
    String explanation3cont = "cool things we love!";
    
    String b = "B";
    String i = "I";
    String n = "N";
    String a = "A";
    String r = "R";
    String y = "Y";
    
    String d = "D";
    String letterG = "G";
    String t = "T";
    
    String decorativeBorder = "010101010111010010010010100010100101000101010100100011101010101001010";
    
    //activities: create a binary stream of numbers
    //bit = binary digit (timer)
    
    
    public TerceraPage()
    {

    	loadImages();
    	
    	timer = new Timer(DELAY, this);
    	setBackground(WelcomePage.backgroundColor);
    	setVisible(true);
    	
    	timer.start();

    }
    
    public void paint(Graphics g)
    {
    	super.paint(g);
    	
    	g.drawImage(titleImage, 5, 5, this);
    	
    	g.setColor(Color.black);
    	g.setFont(new Font("Geneva", 1, 20));
    	g.drawString(explanation1, 30, 80);
    	g.drawString(explanation1cont, 30, 110);
    	
    	g.drawLine(0, 150, 0, 0);
    	
    	g.drawString(explanation2, 30, 200);
    	g.drawImage(binaryDigitImage, 525, 130, this);
    	
    	g.drawString(explanation3, 30, 420);
    	g.drawString(explanation3cont, 30, 445);
    	
    	if(countAnimation ==0)
    	{
    		g.setFont(new Font("Geneva", 1, 60));
    		g.setColor(WelcomePage.textColor);
    		g.drawString(b, 20, 320);
    		g.drawString(i, 60, 320);
    		g.drawString(n, 90, 320);
    		g.drawString(a, 140, 320);
    		g.drawString(r, 190, 320);
    		g.drawString(y, 230, 320);
    		
    		g.drawString(d, 320, 320);
    		g.drawString(i, 370, 320);
    		g.drawString(letterG, 400, 320);
    		g.drawString(i, 450, 320);
    		g.drawString(t, 475, 320);
    		
    	}
    	if(countAnimation == 1)
    	{
    		g.setFont(new Font("Geneva", 1, 60));
    		g.setColor(Color.red);
    		g.drawString(b, 20, 320);
    		
    		g.setColor(WelcomePage.textColor);
    		g.drawString(i, 60, 320);
    		g.drawString(n, 90, 320);
    		g.drawString(a, 140, 320);
    		g.drawString(r, 190, 320);
    		g.drawString(y, 230, 320);
    		
    		g.drawString(d, 320, 320);
    		g.drawString(i, 370, 320);
    		g.drawString(letterG, 400, 320);
    		
    		g.setColor(Color.red);
    		g.drawString(i, 450, 320);
    		g.drawString(t, 475, 320);
    		
    	}
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
    		g.drawString(b, 140, 320);
    		g.drawString(i, 200, 320);
    		g.drawString(t, 230, 320);
    		
    		g.setColor(WelcomePage.textColor);
    		g.setFont(new Font("Geneva", 1, 20));
    		g.drawString("Ex. 11010 is 5 bits long", 30, 360);
    		
    	}
    	
    		
    }
    
    public void loadImages()
    {
    	titleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.whyBinaryImportantTitlePath)); 
		titleImage = titleImage.getScaledInstance(790, 43, Image.SCALE_SMOOTH);
	
		binaryDigitImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.binaryDigitPath)); 
		binaryDigitImage = binaryDigitImage.getScaledInstance(150, 157, Image.SCALE_SMOOTH);

    }
    
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


