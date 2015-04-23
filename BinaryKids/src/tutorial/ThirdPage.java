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
import java.awt.event.MouseEvent;

import javax.imageio.ImageIO;
import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;
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
import java.io.File;
import java.io.IOException;


public class ThirdPage extends JPanel
{
    boolean pageClickedOnce = false;
    
	String binaryDef1 =  "The word binary comes from 'Bi-' meaning two." ;
	String binaryDef2 = "We see 'bi-' in words such as 'bicycle' (two wheels) or 'binocular (two eyes).";
	String binaryDef3 = "A single binary digit (like '0' or '1') is called a 'bit'. ";
	String binaryDef4 = "For example 11010 is five bits long.";
	String binaryDef5 = "The word bit is made up from the words binary digit";
	
	String binaryDef6 = "In binary, a 0 means off, and a 1 means on"; 
	String binaryDef7 = "Computers use binary numbers to send signals";

	JPanel firstPanel; 
	JPanel secondPanel;
	JPanel thirdPanel;
	JPanel fourthPanel;
	
	boolean firstPanelClicked = false;
	boolean secondPanelClicked = false;
	boolean thirdPanelClicked = false;
	boolean fourthPanelClicked = false;
	
	//variables for third panel
	final String toBinary = "To Binary";
	final String toDecimal = "To Decimal";
	String binaryNum = "110110";
	String decimalNum = " 54 ";
	boolean decimal = true;
	JButton convertButton;
	JLabel numLabel;
	
	ImageIcon boxIcon;
	ImageIcon boxIcon2;
	Image img1;
	Image img2;
	
	Boolean secondPanelOn = false;
	Boolean oneClicked = false;
	
	//variables for 4th panel
	JButton submitButton;
	JTextField answerField1;
	JTextField answerField2;
	JTextField answerField3;
	JTextField answerField4;
	JTextField answerField5;
	JLabel one;
	JLabel two;
	JLabel four;
	JLabel eight;
	JLabel sixteen;
	
	JLabel oneAnswer;
	JLabel twoAnswer;
	JLabel fourAnswer;
	JLabel eightAnswer;
	JLabel sixteenAnswer;
	
	int answerTries = 0;
	final int maxTries = 2;
	
	int userAnswer1;
	int userAnswer2;
	int userAnswer3;
	int userAnswer4;
	int userAnswer5;
	
	int answer16 = 16;
	int answer8 = 8;
	int answer4 = 4;
	int answer2 = 2;
	int answer1 = 1;
	
	//for fourth panel 
	JPanel labelPanel;
	
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
    	

    	
		//try to load the image file
    	String fileName = "lightOn.jpg";
		try {
			boxIcon = new ImageIcon(ImageIO.read(new File(fileName))); //obstImgFileName1
		} catch (IOException e) {
			System.out.println("Please check image file path.");
			e.printStackTrace();
		};
		img1 = boxIcon.getImage();
		img1 = img1.getScaledInstance(200, 400, Image.SCALE_SMOOTH);
		
		
		String fileName2 = "titleImage.jpg";
		//try to load the image file
		try {
			boxIcon2 = new ImageIcon(ImageIO.read(new File(fileName2))); //fileName2
		} catch (IOException e) {
			System.out.println("Please check image file path.");
			e.printStackTrace();
		};
		img2 = boxIcon2.getImage();
		img2 = img2.getScaledInstance(200, 400, Image.SCALE_SMOOTH);
    	
    	
    	
    	
    	firstPanel.addMouseListener(new MouseListener() 
    	{      
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(firstPanelClicked == false)
				{
					welcomePage.buttonPanel.add(welcomePage.page3GoBackButton);
					welcomePage.validate();
					welcomePage.repaint();
					welcomePage.setVisible(true);
					
					remove(secondPanel);
					remove(thirdPanel);
					remove(fourthPanel);
					loadFirstPanel();
					validate();
			        setVisible(true);
			        repaint();
			        firstPanelClicked = true;
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {}

			@Override
			public void mouseExited(MouseEvent arg0) {}

			@Override
			public void mousePressed(MouseEvent arg0) {}

			@Override
			public void mouseReleased(MouseEvent arg0) {}      
		}); 
    	
    	secondPanel.addMouseListener(new MouseListener() 
    	{      
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(secondPanelClicked == false)
				{
					welcomePage.buttonPanel.add(welcomePage.page3GoBackButton);
					welcomePage.validate();
					welcomePage.repaint();
					welcomePage.setVisible(true);
					
					remove(firstPanel);
					remove(thirdPanel);
					remove(fourthPanel);
					loadSecondPanel();
					validate();
			        setVisible(true);
			        repaint();
			        secondPanelClicked = true;
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {}

			@Override
			public void mouseExited(MouseEvent arg0) {}

			@Override
			public void mousePressed(MouseEvent arg0) {}

			@Override
			public void mouseReleased(MouseEvent arg0) {}      
		}); 
    	
    	thirdPanel.addMouseListener(new MouseListener() 
    	{      
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(thirdPanelClicked == false)
				{
					
					welcomePage.buttonPanel.add(welcomePage.page3GoBackButton);
					welcomePage.validate();
					welcomePage.repaint();
					welcomePage.setVisible(true);
					remove(firstPanel);
					remove(secondPanel);
					remove(fourthPanel);
					loadThirdPanel();
					validate();
					setVisible(true);
					repaint();
					thirdPanelClicked = true;
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {}

			@Override
			public void mouseExited(MouseEvent arg0) {}

			@Override
			public void mousePressed(MouseEvent arg0) {}

			@Override
			public void mouseReleased(MouseEvent arg0) {}      
		});
    	
    	fourthPanel.addMouseListener(new MouseListener() 
    	{      
			@Override
			public void mouseClicked(MouseEvent e) 
			{
				if(fourthPanelClicked == false)
				{
					welcomePage.buttonPanel.add(welcomePage.page3GoBackButton);
					welcomePage.validate();
					welcomePage.repaint();
					welcomePage.setVisible(true);
					
					remove(firstPanel);
					remove(secondPanel);
					remove(thirdPanel);
					loadFourthPanel();
					validate();
			        setVisible(true);
			        repaint();
			        fourthPanelClicked = true;
				}
			}

			@Override
			public void mouseEntered(MouseEvent arg0) {}

			@Override
			public void mouseExited(MouseEvent arg0) {}

			@Override
			public void mousePressed(MouseEvent arg0) {}

			@Override
			public void mouseReleased(MouseEvent arg0) {}      
		});

    }
    
    
    public void loadFirstPanel()
    {
    	firstPanel.setBackground(Color.yellow);
    	JTextArea firstLabel2 = new JTextArea(1, 2);
    	firstLabel2.setText(binaryDef1);
    	firstLabel2.setFont(new Font("Verdana", 1, 15));
    	firstPanel.add(firstLabel2);
    	validate();
        setVisible(true);
        repaint();
    }
    
    public void loadSecondPanel()
    {
    	secondPanelOn = true;
    	secondPanel.setBackground(Color.pink);
    	JTextArea firstLabel2 = new JTextArea(1, 2);
    	firstLabel2.setText(binaryDef6);
    	firstLabel2.setFont(new Font("Verdana", 1, 15));
    	
    	JTextArea firstLabel3 = new JTextArea(1, 2);
    	firstLabel3.setText(binaryDef7);
    	firstLabel3.setFont(new Font("Verdana", 1, 15));
    	
    	JTextArea firstLabel4 = new JTextArea(1, 2);
    	firstLabel4.setText("click to buttons to see how binary numbers send signals!");
    	firstLabel4.setFont(new Font("Verdana", 1, 15));
    	

    	
    	JPanel buttonPanel = new JPanel();
    	JButton oneButton = new JButton("1");
    	buttonPanel.add(oneButton);
    	oneButton.addActionListener(new ActionListener() 
		{      
			public void actionPerformed(ActionEvent e) 
			{  
				//change image to light on
				oneClicked = true;
				repaint();
			}      
		}); 
    	JButton zeroButton = new JButton("0");
    	buttonPanel.add(zeroButton);
    	zeroButton.addActionListener(new ActionListener() 
		{      
			public void actionPerformed(ActionEvent e) 
			{  
				//change image to light of
				oneClicked = false;
				repaint();
			}      
		}); 
    	
    	
    	secondPanel.setLayout(new GridLayout(0,1));
    	secondPanel.add(firstLabel2);
    	secondPanel.add(firstLabel3);
    	secondPanel.add(firstLabel4);
    	secondPanel.add(buttonPanel);

    	
    	validate();
        setVisible(true);
        repaint();
    }
    
    public void loadThirdPanel()
    {
    	thirdPanel.setBackground(Color.cyan);
    	JTextArea firstLabel3 = new JTextArea(1, 2);
    	firstLabel3.setText("Click the button to see a binary decimal conversion!");
    	firstLabel3.setFont(new Font("Verdana", 1, 15));
    	thirdPanel.add(firstLabel3);
    	
    	numLabel = new JLabel(decimalNum);
    	numLabel.setFont(new Font("Verdana", 1, 90));
    	thirdPanel.add(numLabel);
    	

    	convertButton = new JButton(toBinary);
		convertButton.addActionListener(new ActionListener() 
		{      
			public void actionPerformed(ActionEvent le) //when button is clicked, change text of button and text of label
			{  
				if(decimal == true) //need to convert to binary
				{
					convertButton.setText(toDecimal);
					numLabel.setText(binaryNum);
					decimal = false;
					
				}
				else //need to convert to decimal
				{
					convertButton.setText(toBinary);
					numLabel.setText(decimalNum);
					decimal = true;
				}

			}      
		}); 
    	
    	
    	thirdPanel.add(convertButton);
    	
    	
    	validate();
        setVisible(true);
        repaint();
    }
    
    public void loadFourthPanel()
    {
    	fourthPanel.setBackground(Color.blue);
    	fourthPanel.setLayout(new GridLayout(0,1));
    	
    	JPanel textPanel = new JPanel();
    	labelPanel = new JPanel(new GridLayout(2,5));
    	//JPanel answerPanel = new JPanel();
    	JPanel submitPanel = new JPanel();
    	
    	JLabel textLabel = new JLabel("Each binary digit is a power of two");
    	JLabel questionLabel = new JLabel("What are the powers of two, or places in binary?");
    	textLabel.setFont(new Font("Verdana", 1, 20));
    	questionLabel.setFont(new Font("Verdana", 1, 20));
    	//textPanel.setLayout(new BoxLayout(this, BoxLayout.Y_AXIS));
    	textPanel.add(textLabel);
    	textPanel.add(questionLabel);
    	
    	sixteen = new JLabel("2^4");
    	sixteen.setFont(new Font("Verdana", 1, 25));
    	sixteen.setBorder(new LineBorder(Color.blue)); 
    	
    	eight = new JLabel("2^3");
    	eight.setFont(new Font("Verdana", 1, 25));
    	eight.setBorder(new LineBorder(Color.green)); 
    	
    	four = new JLabel("2^2");
    	four.setFont(new Font("Verdana", 1, 25));
    	four.setBorder(new LineBorder(Color.blue)); 
    	
    	two = new JLabel("2^1");
    	two.setFont(new Font("Verdana", 1, 25));
    	two.setBorder(new LineBorder(Color.green)); 
    	
    	one = new JLabel("2^0");
    	one.setFont(new Font("Verdana", 1, 25));
    	one.setBorder(new LineBorder(Color.blue)); 

    	sixteenAnswer = new JLabel("16");
    	sixteenAnswer.setFont(new Font("Verdana", 1, 25));
    	sixteenAnswer.setBorder(new LineBorder(Color.blue)); 
    	
    	eightAnswer = new JLabel("8");
    	eightAnswer.setFont(new Font("Verdana", 1, 25));
    	eightAnswer.setBorder(new LineBorder(Color.green)); 
    	
    	fourAnswer = new JLabel("4");
    	fourAnswer.setFont(new Font("Verdana", 1, 25));
    	fourAnswer.setBorder(new LineBorder(Color.blue)); 
    	
    	twoAnswer = new JLabel("2");
    	twoAnswer.setFont(new Font("Verdana", 1, 25));
    	twoAnswer.setBorder(new LineBorder(Color.green)); 
    	
    	oneAnswer = new JLabel("1");
    	oneAnswer.setFont(new Font("Verdana", 1, 25));
    	oneAnswer.setBorder(new LineBorder(Color.blue)); 
    	
    	
    	labelPanel.add(sixteen);
    	labelPanel.add(eight);
    	labelPanel.add(four);
    	labelPanel.add(two);
    	labelPanel.add(one);
    	
    	answerField1 = new JTextField();
    	answerField2 = new JTextField();
    	answerField3 = new JTextField();
    	answerField4 = new JTextField();
    	answerField5 = new JTextField();
    	
    	
    	answerField1.setColumns(5);
    	answerField1.setFont(new Font("Verdana", 1, 25));
    	answerField2.setColumns(5);
    	answerField2.setFont(new Font("Verdana", 1, 25));
    	answerField3.setColumns(5);
    	answerField3.setFont(new Font("Verdana", 1, 25));
    	answerField4.setColumns(5);
    	answerField4.setFont(new Font("Verdana", 1, 25));
    	answerField5.setColumns(5);
    	answerField5.setFont(new Font("Verdana", 1, 25));
    	
    	labelPanel.add(answerField1);
    	labelPanel.add(answerField2);
    	labelPanel.add(answerField3);
    	labelPanel.add(answerField4);
    	labelPanel.add(answerField5);
    	
    	
    	submitButton = new JButton("Check your answer");
    	submitButton.addActionListener(new submitButtonListener());
    	submitPanel.setBackground(welcomePage.backgroundColor);
    	submitPanel.add(submitButton);
    	
    	fourthPanel.add(textPanel);
    	fourthPanel.add(labelPanel);
    	//fourthPanel.add(answerPanel);
    	fourthPanel.add(submitPanel);
    	
    	
    	validate();
        setVisible(true);
        repaint();
    }
    
    public void paint(Graphics g)
    {
    	super.paint(g);
    	//g.setColor(Color.blue);
    	//g.drawString(binaryDef, 20, 500);
    	
    	if(secondPanelOn)
    	{	
    		if(oneClicked)
    		{
    			g.drawImage(img1, 650, 300, this);
    		}
    		else
    		{
    			g.drawImage(img2, 650, 300, this);
    		}
    			
    	} //end if
    }
    
	class submitButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			//get text, give user 2 chances to get it right and then if not, replace with labels in grid
			String userInput1 = answerField1.getText();
			String userInput2 = answerField2.getText();
			String userInput3 = answerField3.getText();
			String userInput4 = answerField4.getText();
			String userInput5 = answerField5.getText();
			
			userAnswer1 = Integer.parseInt(userInput1);
			userAnswer2 = Integer.parseInt(userInput2);
			userAnswer3 = Integer.parseInt(userInput3);
			userAnswer4 = Integer.parseInt(userInput4);
			userAnswer5 = Integer.parseInt(userInput5);
			
			if(answerTries < maxTries)
			{
				if(userAnswer1 == answer16 
						&& userAnswer2 == answer8
						&& userAnswer3 == answer4
						&& userAnswer4 == answer2
						&& userAnswer5 == answer1)
				{
					//dialog box welcomes user to game and gives them brief instructions
			    	String errorMessage = "correct answer";
			    	JOptionPane.showMessageDialog(welcomePage, errorMessage, "worng answer", JOptionPane.YES_NO_OPTION);
	
					labelPanel.remove(answerField1);
			    	labelPanel.remove(answerField2);
			    	labelPanel.remove(answerField3);
			    	labelPanel.remove(answerField4);
			    	labelPanel.remove(answerField5);
			    	
			    	labelPanel.add(sixteenAnswer);
			    	labelPanel.add(eightAnswer);
			    	labelPanel.add(fourAnswer);
			    	labelPanel.add(twoAnswer);
			    	labelPanel.add(oneAnswer);
			    	
			    	labelPanel.validate();
			    	labelPanel.setVisible(true);
			    	labelPanel.repaint();
			    	
			    	fourthPanel.validate();
			    	fourthPanel.repaint();
			    	fourthPanel.setVisible(true);
			    	
			    
				}
				else
				{
					//dialog box welcomes user to game and gives them brief instructions
			    	String errorMessage = "wrong answer";
			    	JOptionPane.showMessageDialog(welcomePage, errorMessage, "worng answer", JOptionPane.YES_NO_OPTION);
			    	
			    	answerField1.setText("");
			    	answerField2.setText("");
			    	answerField3.setText("");
			    	answerField4.setText("");
			    	answerField5.setText("");
			    	
			    	labelPanel.validate();
			    	labelPanel.setVisible(true);
			    	labelPanel.repaint();
			    	
			    	fourthPanel.validate();
			    	fourthPanel.repaint();
			    	fourthPanel.setVisible(true);
			    	
			    	answerTries++;
			    	
				}
			}
			else
			{
				//dialog box welcomes user to game and gives them brief instructions
		    	String errorMessage = "wrong answer";
		    	JOptionPane.showMessageDialog(welcomePage, errorMessage, "worng answer", JOptionPane.YES_NO_OPTION);
		    	
		    	labelPanel.remove(answerField1);
		    	labelPanel.remove(answerField2);
		    	labelPanel.remove(answerField3);
		    	labelPanel.remove(answerField4);
		    	labelPanel.remove(answerField5);
		    	
		    	labelPanel.add(sixteenAnswer);
		    	labelPanel.add(eightAnswer);
		    	labelPanel.add(fourAnswer);
		    	labelPanel.add(twoAnswer);
		    	labelPanel.add(oneAnswer);
		    	
		    	labelPanel.validate();
		    	labelPanel.setVisible(true);
		    	labelPanel.repaint();
		    	
		    	fourthPanel.validate();
		    	fourthPanel.repaint();
		    	fourthPanel.setVisible(true);
		    	
		    	
			}
			validate();
	        setVisible(true);
	        repaint();	
		}
	}
	

}

