package tutorial;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
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
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Image;
import java.awt.TextField;
import java.awt.Toolkit;
import java.io.File;
import java.io.IOException;


public class FirstPage extends JPanel
{
	JButton submitButton2;
	TextField useField;
	//JTextArea useField = new JTextArea(400, 400);
	
	String userName = "";
	private ImageIcon boxIcon;
	private Image img;
	
	private WelcomePage welcomePage; //to connect welcome page to individual pages 
    
    public FirstPage(WelcomePage welcome)
    {
    	welcomePage = welcome;
    	setBackground(Color.pink);
    	//userName = welcomePage.getUserName();
    	
    	JPanel titlePanel = new JPanel();
    	JLabel titleLabel = new JLabel("Welcome to BinaryKids!");
    	titleLabel.setFont(new Font("Verdana",1,20));
    	titlePanel.add(titleLabel);
    	titlePanel.setBorder(new LineBorder(Color.BLACK)); 
    	

    	
    	JLabel questionLabel = new JLabel("Binary numbers are important to computers. What do you use computers for?");
    	questionLabel.setFont(new Font("Verdana", 1, 13));
    	
    	submitButton2 = new JButton("Submit Answer");
    	useField = new TextField("Type your answer here");
    	useField.setSize(400, 400);
    	
    	//useField.setFont(new Font("Monospaced",Font.PLAIN,16)); //sets font of j text area 
		useField.setBackground(Color.lightGray);
    	
    	
    	submitButton2.addActionListener(new answerButtonListener());
    	
    	add(titlePanel);
    	
    	add(questionLabel);
    	add(useField);
    	add(submitButton2);
    	
    	String obstImgFileName = "titleImage.jpg";
		//try to load the image file
		try {
			boxIcon = new ImageIcon(ImageIO.read(new File(WelcomePage.obstImgFileName)));
		} catch (IOException e) {
			System.out.println("Please check image file path.");
			e.printStackTrace();
		};
		img = boxIcon.getImage();
		img = img.getScaledInstance(400, 300, Image.SCALE_SMOOTH);
    	
    	
    	
    	
    }
    
    public void paint(Graphics g) 
    { 
    	super.paint(g);

    	g.drawImage(img, 200, 300, this);

    }
    

	
	class answerButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			welcomePage.setUserAnswer(useField.getText());
			repaint();
		}
	}

}
