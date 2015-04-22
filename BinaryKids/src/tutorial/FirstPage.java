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
import java.awt.event.ItemEvent;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JCheckBox;
import javax.swing.JPanel;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
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
	
	//size of text area
	private final int areaWidth = 4;
	private final int areaHeight = 15;
		
	private JTextArea area = new JTextArea(areaWidth, areaHeight);
	
	JCheckBox skypeCheck;
	JCheckBox gameCheck;
	JCheckBox emailCheck;
	JCheckBox youtubeCheck;
	JCheckBox fbCheck;

	
	String userName = "";
	private ImageIcon boxIcon;
	private Image img;
	
	private WelcomePage welcomePage; //to connect welcome page to individual pages 
    
    public FirstPage(WelcomePage welcome)
    {
    	welcomePage = welcome;
    	userName = welcomePage.getUserName();
    	
    	area.setFont(new Font("Monospaced",Font.PLAIN,40)); //sets font of j text area 
		area.setBackground(Color.white);
    	
    	setBackground(welcomePage.backgroundColor);
    	//scroll pane is added to middle of jFrame
    	JScrollPane scroll = new JScrollPane(area,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS, 
    	JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS);
    			
    	//setLayout(new GridLayout(0,1));
    	//userName = welcomePage.getUserName();
    	
    	JPanel titlePanel = new JPanel();
    	JLabel titleLabel = new JLabel("Welcome to BinaryKids, " + userName);
    	titleLabel.setFont(new Font("Verdana",1,20));
    	titlePanel.add(titleLabel);
    	titlePanel.setBorder(new LineBorder(Color.BLACK)); 
    	

    	
    	JLabel questionLabel = new JLabel("Binary numbers are important to computers. What do you use computers for?");
    	questionLabel.setFont(new Font("Verdana", 1, 13));
    	
    	submitButton2 = new JButton("Submit Answer");
    	useField = new TextField("Type your answer here");
    	useField.setPreferredSize(new Dimension(200,24));
    	
    	//useField.setFont(new Font("Monospaced",Font.PLAIN,16)); //sets font of j text area 
		useField.setBackground(Color.lightGray);
    	
        //Create the check boxes.
        skypeCheck = new JCheckBox("Skype");
        skypeCheck.setMnemonic(KeyEvent.VK_S);
        skypeCheck.setSelected(false);

        gameCheck = new JCheckBox("Games");
        gameCheck.setMnemonic(KeyEvent.VK_G);
        gameCheck.setSelected(false);

        emailCheck = new JCheckBox("Email");
        emailCheck.setMnemonic(KeyEvent.VK_E);
        emailCheck.setSelected(false);

        youtubeCheck = new JCheckBox("Videos");
        youtubeCheck.setMnemonic(KeyEvent.VK_V);
        youtubeCheck.setSelected(false);
        
        fbCheck = new JCheckBox("Facebook");
        fbCheck.setMnemonic(KeyEvent.VK_F);
        fbCheck.setSelected(false);

        //Register a listener for the check boxes.
        skypeCheck.addItemListener(new useListener());
        gameCheck.addItemListener(new useListener());
        emailCheck.addItemListener(new useListener());
        youtubeCheck.addItemListener(new useListener());
        fbCheck.addItemListener(new useListener());
        
        JPanel checkPanel = new JPanel(new GridLayout(0, 1));
        checkPanel.add(gameCheck);
        checkPanel.add(skypeCheck);
        checkPanel.add(emailCheck);
        checkPanel.add(youtubeCheck);
        checkPanel.add(fbCheck);

		
		
    	submitButton2.addActionListener(new answerButtonListener());
    	
    	add(titlePanel);
    	
    	add(questionLabel);
    	//add(useField);
    	add(scroll);
        //add(checkPanel, BorderLayout.LINE_START);

    	add(submitButton2);
    	
    	String obstImgFileName = "titleImage.jpg";
		//try to load the image file
		try {
			boxIcon = new ImageIcon(ImageIO.read(new File(obstImgFileName)));
		} catch (IOException e) {
			System.out.println("Please check image file path.");
			e.printStackTrace();
		};
		img = boxIcon.getImage();
		img = img.getScaledInstance(400, 250, Image.SCALE_SMOOTH);
    	
    	
    	
    	
    }
    
    public void paint(Graphics g) 
    { 
    	super.paint(g);

    	g.drawImage(img, 200, 300, this);

    }
    
    class useListener implements ItemListener
    {
    	@Override
		public void itemStateChanged(ItemEvent e) 
    	{
			// TODO Auto-generated method stub
    		//if(e.getItemSelectable() == gameCheck)
    		//else if(e.getItemSelectable() == gameCheck)
			
		}

    }
	
	class answerButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			welcomePage.setUserAnswer(area.getText());
			repaint();
		}
	}

}
