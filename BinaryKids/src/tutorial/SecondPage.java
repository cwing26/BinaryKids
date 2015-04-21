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


public class SecondPage extends JPanel
{
    String userName = "";
    String answer = "";
    JPanel titlePanel;
    JLabel titleLabel;
    
    String explanation = "Well, you’d be surprised to know nothing would be possible without binary numbers! "
			+ "Explanation of binary and its importance to computers: what are binary numbers? "
			+ "What are their practical uses?";
    
    private WelcomePage welcomePage;
    
    public SecondPage(WelcomePage welcome)
    {
    	welcomePage = welcome;

    	//setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    	setLayout(new GridLayout(4,1));
    	
    	titlePanel = new JPanel();
    	titleLabel = new JLabel("Welcome to binarykids!");
    	titleLabel.setFont(new Font("Verdana",1,20));
    	titlePanel.add(titleLabel);
    	titlePanel.setBorder(new LineBorder(Color.BLACK));     	
    	add(titlePanel, BorderLayout.NORTH);
    	
    	
    	JLabel answerLabel = new JLabel("How do you use computers?");
    	answerLabel.setFont(new Font("Verdana", 1, 15));
    	add(answerLabel, BorderLayout.CENTER);
    	

    	setVisible(true);

    }
    
    public void paint(Graphics g)
    {
    	super.paint(g);
    	g.drawString(answer, 20, 300);
    	
    	g.drawString(explanation, 20, 400);
    }

}
