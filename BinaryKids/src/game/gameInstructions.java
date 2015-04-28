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

import tutorial.Controller;


public class gameInstructions extends JPanel {
	
	Controller controller;
	
	public static Color backgroundColor = new Color(255, 255, 204);
	public static Color buttonPanelColor = new Color(152, 46, 68);
	
	public static int cardSize = 75;
	public static Dimension buttonSize = new Dimension(cardSize, cardSize);
	
	Insets insets;
	
	ImageIcon zeroCard;
	ImageIcon oneCard;
	
	JButton zero;
	JButton one;
	
	//text displayed on screen
	private final String howToPlay = "HOW TO PLAY";
	
	
	public gameInstructions(Controller _controller)
	{
		controller = _controller;
		
		setBackground(backgroundColor);
		
		insets = getInsets();
		
		initComponents();
				
		add(zero);
		add(one);
		
	}
	
	private void initComponents() {
		
	
		zero = new JButton();
		zero.setPreferredSize(buttonSize);
		zero.setIcon((Icon) controller.game0ButtonImage);
		zero.setBounds(235-buttonSize.width/2 + insets.left, 300 + insets.top, buttonSize.width, buttonSize.height);
		
		one = new JButton();
		one.setPreferredSize(buttonSize);
		one.setIcon((Icon) controller.game1ButtonImage);
		one.setBounds(395-buttonSize.width/2 + insets.left, 500 + insets.top, buttonSize.width, buttonSize.height);
		
	}
	
	public void paint(Graphics g) 
	{
		g.setColor(buttonPanelColor);
		
		int x = 0;
		
		for (int i = 0; i < 10; i++) {
			g.fillRect(x, 0, 80, 80);
			x = x + 80;
		}
		
		g.setColor(Color.WHITE);
		g.setFont(new Font("Geneva", Font.BOLD , 25));
		g.drawString(howToPlay, 300, 50);
	
	}
	

}
