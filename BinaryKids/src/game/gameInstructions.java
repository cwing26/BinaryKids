package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JPanel;
import javax.swing.JTextArea;


import tutorial.Controller;


public class gameInstructions extends JPanel {
	
	Controller controller;
	
	private Font textFont = new Font("Geneva", 1, 20);
	private Font displayFont = new Font("Geneva", 1, 30);
	
	public int cardSize = 75;
	public Dimension buttonSize = new Dimension(cardSize, cardSize);
	
	ImageIcon zeroCard;
	ImageIcon oneCard;
	
	JButton zero;
	JButton one;
	
	//text displayed on screen
	private final String howToPlay = "How to Play:";
	private final String introText = "These buttons show 0's and 1's.";
	private final String introText2 = "To switch back and forth between them, just click!";
	private final String introText3 = "To answer a question, set each one to the the correct number (0 or 1)";
	private final String introText4 = "and then click submit!";
	
	private final String levelText = "There are 4 levels in the game.";
	private final String levelText2 = "To advance to level 2, you must complete 5 questions before time runs out!";
	private final String levelText3 = "For all other levels, you must complete 10 questions before time runs out!";
	private final String levelText4 = "Be careful, each level is harder than the last.";
	
	private final String goalText = "Answer as many questions as possible before time runs out!";
	private final String goalText2 = "Act wisely, because a wrong question will cost you a life!";
			
	
	public gameInstructions(Controller control)
	{
		controller = control;
		
		setBackground(Controller.backgroundColor);
		
		initComponents();

		setLayout(null);		
		add(zero);
		add(one);
		
		positionComponents();
		
	}

	private void initComponents() {
		
	
		zero = new JButton();
		//zero.setPreferredSize(buttonSize);
		zero.setIcon(new ImageIcon( controller.game0ButtonImage));
		
		
		one = new JButton();
		//one.setPreferredSize(buttonSize);
		one.setIcon(new ImageIcon( controller.game1ButtonImage));
		
		
	}
	
	private void positionComponents()
	{
		Insets insets = getInsets();
		Dimension buttonSize = one.getPreferredSize();
		
		one.setBounds(100+buttonSize.width + insets.left, 220 + insets.top, buttonSize.width, buttonSize.height);
		
		zero.setBounds(400 + buttonSize.width + insets.left, 220 + insets.top, buttonSize.width, buttonSize.height);
		
	}
	

	
	public void paint(Graphics g) 
	{
		super.paint(g);
		g.setColor(Controller.textColor);
		
		int x = 0;
		
		for (int i = 0; i < 10; i++) {
			g.fillRect(x, 0, 80, 80);
			x = x + 80;
		}
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Geneva", Font.BOLD , 35));
		g.drawString(howToPlay, 300, 50);
		
		//g.drawImage(controller.game0ButtonImage, 100, 100, this);
		//g.drawImage(controller.game1ButtonImage, 300, 100, this);
		
		g.setColor(Controller.textColor);
		g.setFont(textFont);
		g.drawString(introText, 30, 125);
		g.drawString(introText2, 30, 150);
		g.drawString(introText3, 30, 175);
		g.drawString(introText4, 30, 200);
		
		g.drawString(levelText, 30, 275);
		g.drawString(levelText2, 30, 300);
		g.drawString(levelText3, 30, 325);
		g.drawString(levelText4, 30, 350);
		
		g.drawString(goalText, 30, 400);
		g.setColor(Controller.buttonPanelColor);
		g.drawString(goalText2, 30, 425);
		
	
	}
	

}
