package tutorial;

import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.TextField;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.BoxLayout;
import javax.swing.JPanel;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import java.awt.*; 
import java.applet.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Image;
import java.awt.TextField;
import java.awt.Toolkit;


public class ThirdPage extends JPanel
{
    
	String binaryDef =  
	"The word binary comes from 'Bi-' meaning two. We see 'bi-' in words such as 'bicycle' (two wheels) or 'binocular (two eyes)."
	+ "A single binary digit (like '0' or '1') is called a 'bit'. For example 11010 is five bits long."
	+ "The word bit is made up from the words binary digit";

	JPanel firstPanel;
	JPanel secondPanel;
	JPanel thirdPanel;
	JPanel fourthPanel;
	
	
	WelcomePage welcomePage;
    public ThirdPage(WelcomePage welcome)
    {
    	welcomePage = welcome;
    	
    	setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    	
    	firstPanel = new JPanel();
    	JLabel firstLabel = new JLabel("What are Binary Numbers?");
    	firstLabel.setFont(new Font("Verdana",1,20));
    	firstPanel.add(firstLabel);
    	firstPanel.setBorder(new LineBorder(Color.green));     	
    	
    	secondPanel = new JPanel();
    	JLabel secondLabel = new JLabel("Why are binary numbers important?");
    	secondLabel.setFont(new Font("Verdana",1,20));
    	secondPanel.add(secondLabel);
    	secondPanel.setBorder(new LineBorder(Color.pink));     
    	
    	thirdPanel = new JPanel();
    	JLabel thirdLabel = new JLabel("Example of a binary number");
    	thirdLabel.setFont(new Font("Verdana",1,20));
    	thirdPanel.add(thirdLabel);
    	thirdPanel.setBorder(new LineBorder(Color.blue));  
    	
    	fourthPanel = new JPanel();
    	JLabel fourthLabel = new JLabel("Powers of two");
    	fourthLabel.setFont(new Font("Verdana",1,20));
    	fourthPanel.add(fourthLabel);
    	fourthPanel.setBorder(new LineBorder(Color.blue));  
    	
    	add(firstPanel);
    	add(secondPanel);
    	add(thirdPanel);
    	add(fourthPanel);
    	
    	setVisible(true);

    }
    
    public void paint(Graphics g)
    {
    	super.paint(g);
    	//g.setColor(Color.blue);
    	//g.drawString(binaryDef, 20, 500);
    	
    }

}

