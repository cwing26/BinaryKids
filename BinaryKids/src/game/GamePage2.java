package game;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

import tutorial.WelcomePage;

public class GamePage2 extends JPanel {
	
	private WelcomePage welcomePage;
	
	Insets insets;
	
	JProgressBar progressBar;
	JProgressBar scoreBar;
	private Timer timer;
	
	ArrayList<String> questionArray;
	ArrayList<String> answerArray;
	
	JButton one;
	JButton two;
	JButton four;
	JButton eight;
	JButton sixteen;
	JButton thirtytwo;
	JButton sixtyfour;
	
	JButton submitButton;
	
	int counter;
	int progress;
	int score;
	int lives;
	int level;
	
	int flagOne;
	int flagTwo;
	int flagFour;
	int flagEight;
	int flagSixteen;
	int flagThirtyTwo;
	int flagSixtyFour;
	
	ImageIcon zeroCard;
	ImageIcon oneCard;
	
	Random rand;
	
	String currentQuestion;
	
	public static Color backgroundColor = new Color(255, 255, 204);
	public static Color buttonPanelColor = new Color(152, 46, 68);
	public static Color headlineColor = new Color(255, 102, 102);
	
	public static String DIGIT_GUIDE = "        64    " + "         32    " + "       16    " + "         8    " + "         4    " + "          2    " + "          1    ";
	public static String DIGIT_GUIDE_TEXT = "    place   " + "    place   " + "   place   " + "     place  " + "     place  " + "      place  " + "      place   ";
 	
	public GamePage2(WelcomePage welcome) {
		welcomePage = welcome;
		
		setLayout(null);
		setBackground(Color.BLACK);
		
		insets = getInsets();
		
		zeroCard = new ImageIcon("images/myZero.png");
		oneCard = new ImageIcon("images/myOne.png");
		
		initializeQuestions();
		initBinButtons();
		initVariables();
		
		add(sixtyfour);
		add(thirtytwo);
		add(sixteen);
		add(eight);
		add(four);
		add(two);
		add(one);
		
		startGame();
		
		add(progressBar);
		add(scoreBar);
		add(submitButton);
		
		
	}
	
	private void initVariables() {
		counter = 120;
		progress = 0;
		score = 0;
		lives = 3;
		level = 1;
		
		currentQuestion = "";
	}
	
	private void startGame() {
		
		nextQuestion();
		
		timer = new Timer(1000, new timeListener());

		timer.start();
		
		initBars();
		
		submitButton = new JButton("Submit");
		Dimension size = submitButton.getPreferredSize();
		submitButton.setBounds(550-size.width/2 + insets.left, 300 + insets.top, size.width, size.height);
		submitButton.addActionListener(new submitListener());
		
	}
	
	private void nextQuestion() {
		currentQuestion = questionArray.get(progress);
		repaint();
	}
	
	class timeListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			counter--;
			progressBar.setValue(counter);
			repaint();
			
			if (counter == 0) {
				timer.stop();
				endGame(0);
			}
		}
	}
	
	class submitListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) 
		{
			boolean isCorrect;
			isCorrect = checkAnswer();
			
			if (isCorrect == true) {
				score++;
		    	JOptionPane.showMessageDialog(new JFrame(), "Correct, good job!", "Right Answer", JOptionPane.YES_NO_OPTION);
				
		    	scoreBar.setValue(score);
		    	
				checkLevel();
				nextQuestion();
			}
			else {
				
				lives--;
				if (lives == 0)
					endGame(1);
				
				else {
					String wrongAnswer = "Wrong Answer! Try again";
			    	JOptionPane.showMessageDialog(new JFrame(), wrongAnswer, "Wrong Answer", JOptionPane.YES_NO_OPTION);
				}
			}
				
		}
	}
	
	private void checkLevel() {
		
		if (score == 5) {
			level = 2;
			JOptionPane.showMessageDialog(new JFrame(), "On to level 2!", "Next Level", JOptionPane.YES_NO_OPTION);
			counter = 120;
		} else if (score == 15) {
			level = 3;
			JOptionPane.showMessageDialog(new JFrame(), "On to level 3!", "Next Level", JOptionPane.YES_NO_OPTION);
			counter = 120;
		} else if (score == 25) {
			level = 4;
			JOptionPane.showMessageDialog(new JFrame(), "On to level 4!", "Next Level", JOptionPane.YES_NO_OPTION);
		}
	}
	
	private void endGame(int reason) {
		
		String message="";
		
		if (reason == 0)
			message = "You ran out of time! Game over.";
		else if (reason == 1)
			message = "Out of lives! Game Over.";
		
		JOptionPane.showMessageDialog(this, message, "Game Over!", JOptionPane.YES_NO_OPTION);	
	}
	
	private boolean checkAnswer() {
		
		ArrayList<Character> digits = new ArrayList<Character>();
		String finalAnswer = "";
		
		if (flagOne == 1)
			digits.add('1');
		else if (flagOne == 0)
			digits.add('0');
		
		if (flagTwo == 1)
			digits.add('1');
		else if (flagTwo == 0)
			digits.add('0');

		if (flagFour == 1)
			digits.add('1');
		else if (flagFour == 0)
			digits.add('0');

		if (flagEight == 1)
			digits.add('1');
		else if (flagEight == 0)
			digits.add('0');

		if (flagSixteen == 1)
			digits.add('1');
		else if (flagSixteen == 0)
			digits.add('0');

		if (flagThirtyTwo == 1)
			digits.add('1');
		else if (flagThirtyTwo == 0)
			digits.add('0');
		
		if (flagSixtyFour == 1)
			digits.add('1');
		else if (flagSixtyFour == 0)
			digits.add('0');
		
		for (int i=0; i < digits.size(); i++) {
			finalAnswer += digits.get(i);
		}
		
		if (finalAnswer.equals(answerArray.get(progress))) {
			progress++;
			return true;
		} else 
			return false;
	}
	
	private void initBars() {
		
		progressBar = new JProgressBar(JProgressBar.VERTICAL);
		progressBar.setValue(120);
		progressBar.setBackground(buttonPanelColor);
		progressBar.setForeground(Color.GREEN);	
		
		Dimension size = progressBar.getPreferredSize();
		progressBar.setBounds(650-size.width/2 + insets.left, 150 + insets.top, size.width, size.height);
	
	
		scoreBar = new JProgressBar(JProgressBar.VERTICAL);
		scoreBar.setValue(0);
		scoreBar.setBackground(buttonPanelColor);
		scoreBar.setForeground(Color.GREEN);
		scoreBar.setBounds(725-size.width/2 + insets.left, 150 + insets.top, size.width, size.height);
	}
	
	
	private void initBinButtons() {
		
		Dimension size = new Dimension(75, 75);
		//randomlySetFlags();
		
		one = new JButton();
		changeButton(one, flagOne);
		one.setBounds(75-size.width/2 + insets.left, 150 + insets.top, size.width, size.height);
		one.addActionListener(new changeDigitListener());
		
		two = new JButton();
		changeButton(two, flagTwo);
		two.setPreferredSize(new Dimension(75, 75));
		two.setBounds(155-size.width/2 + insets.left, 150 + insets.top, size.width, size.height);
		two.addActionListener(new changeDigitListener());
		
		four = new JButton();
		changeButton(four, flagFour);
		four.setPreferredSize(new Dimension(75, 75));
		four.setBounds(235-size.width/2 + insets.left, 150 + insets.top, size.width, size.height);
		four.addActionListener(new changeDigitListener());
		
		eight = new JButton();
		changeButton(eight, flagEight);
		eight.setPreferredSize(new Dimension(75, 75));
		eight.setBounds(315-size.width/2 + insets.left, 150 + insets.top, size.width, size.height);
		eight.addActionListener(new changeDigitListener());
		
		sixteen = new JButton();
		changeButton(sixteen, flagSixteen);
		sixteen.setPreferredSize(new Dimension(75, 75));
		sixteen.setBounds(395-size.width/2 + insets.left, 150 + insets.top, size.width, size.height);
		sixteen.addActionListener(new changeDigitListener());
		
		thirtytwo = new JButton();
		changeButton(thirtytwo, flagThirtyTwo);
		thirtytwo.setPreferredSize(new Dimension(75, 75));
		thirtytwo.setBounds(475-size.width/2 + insets.left, 150 + insets.top, size.width, size.height);
		thirtytwo.addActionListener(new changeDigitListener());
		
		sixtyfour = new JButton();
		changeButton(sixtyfour, flagSixtyFour);
		sixtyfour.setPreferredSize(new Dimension(75, 75));
		sixtyfour.setBounds(555-size.width/2 + insets.left, 150 + insets.top, size.width, size.height);
		sixtyfour.addActionListener(new changeDigitListener());
		
		setButtonIconFlag();
	}
	
	private void setButtonIconFlag() {
		
		one.setIcon(zeroCard);
		two.setIcon(zeroCard);
		four.setIcon(zeroCard);
		eight.setIcon(zeroCard);
		sixteen.setIcon(zeroCard);
		thirtytwo.setIcon(zeroCard);
		sixtyfour.setIcon(zeroCard);
		
		flagOne = 0;
		flagTwo = 0;
		flagFour = 0;
		flagEight = 0;
		flagSixteen = 0;
		flagThirtyTwo = 0;
		flagSixtyFour = 0;
	}
	
	class changeDigitListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			Object src = e.getSource();

			if (src == one) {
				changeButton(one, flagOne);
				flagOne = setFlag(flagOne);
				//System.out.println("one");
			} else if (src == two) {
				changeButton(two, flagTwo);
				flagTwo = setFlag(flagTwo);
				//System.out.println("two changed flag to: " + flagTwo);
			} else if (src == four) {
				changeButton(four, flagFour);
				flagFour = setFlag(flagFour);
				//System.out.println("four");
			} else if (src == eight) {
				changeButton(eight, flagEight);
				flagEight = setFlag(flagEight);
				//System.out.println("eight");
			} else if (src == sixteen) {
				changeButton(sixteen, flagSixteen);
				flagSixteen = setFlag(flagSixteen);
				//System.out.println("sixteen");
			} else if (src == thirtytwo) {
				changeButton(thirtytwo, flagThirtyTwo);
				flagThirtyTwo = setFlag(flagThirtyTwo);
				//System.out.println("thirtytwo changed flag to: " + flagThirtyTwo);
			} else if (src == sixtyfour) {
				changeButton(sixtyfour, flagSixtyFour);
				flagSixtyFour = setFlag(flagSixtyFour);
				//System.out.println("sixtyfour");
			}
		}
	}
	
	private int setFlag(int flag) {
		if (flag == 0)
			flag = 1;
		else if (flag == 1)
			flag = 0;
		
		return flag;
	}
	
	private void changeButton(JButton myButton, int flag) {
		
		if (flag == 0) {
			myButton.setIcon(oneCard);
		} else if (flag == 1) {
			myButton.setIcon(zeroCard);
		}
		
		repaint();
		
	}
	
	private void initializeQuestions() {
		
		questionArray = new ArrayList<String>();
		answerArray = new ArrayList<String>();
		
		String convertAnswerBin;
		
		int MAX_BIN_SIZE = 63;
		int MIN_BIN_SIZE = 0;
		
		//LEVELS 1-3
		for (int i=0; i < 25; i++)
		{
			rand = new Random();
			int randNum = rand.nextInt((MAX_BIN_SIZE - MIN_BIN_SIZE) + 1) + MIN_BIN_SIZE;
			convertAnswerBin = convertToBin(randNum);
			questionArray.add("QUESTION: What is " + randNum + " in binary?");
			convertAnswerBin = padAnswer(convertAnswerBin);
			answerArray.add(convertAnswerBin);
		}
		
		MAX_BIN_SIZE = 128;
		
		//LEVEL 4
		for (int i=25; i < 35; i++) {
			
			rand = new Random();
			int randNum = rand.nextInt((MAX_BIN_SIZE - MIN_BIN_SIZE) + 1) + MIN_BIN_SIZE;
			convertAnswerBin = convertToBin(randNum);
			questionArray.add("QUESTION: What is " + randNum + " in binary?");
			convertAnswerBin = padAnswer(convertAnswerBin);
			answerArray.add(convertAnswerBin);
			
		}
	}

	/*
	private void randomlySetFlags() {
		
		ArrayList<Integer> digitChoices = new ArrayList<Integer>();
		digitChoices.add(0);
		digitChoices.add(1);
		
		int pick;
		
		pick = rand.nextInt(digitChoices.size());
		flagOne = digitChoices.get(pick);
		System.out.println(flagOne);
		
		pick = rand.nextInt(digitChoices.size());
		flagTwo = digitChoices.get(pick);
		
		pick = rand.nextInt(digitChoices.size());
		flagFour = digitChoices.get(pick);
		
		pick = rand.nextInt(digitChoices.size());
		flagEight = digitChoices.get(pick);
		
		pick = rand.nextInt(digitChoices.size());
		flagSixteen = digitChoices.get(pick);
		
		pick = rand.nextInt(digitChoices.size());
		flagThirtyTwo = digitChoices.get(pick);
		
		pick = rand.nextInt(digitChoices.size());
		flagSixtyFour = digitChoices.get(pick);
		
	}*/
	
	private String padAnswer(String number) {
		while (number.length() < 7)
			number = "0" + number;
		return number;
	}

	String convertToBin (int i) {
		return Integer.toString(i, 2);
	}
	
	public void paint(Graphics g) {
		super.paint(g);
		
		//draw question at top of screen
		g.setColor(Color.WHITE);
		g.setFont(new Font("Geneva", 1 , 20));
		g.drawString(currentQuestion, 250, 50);
		
		g.setFont(new Font("Geneva", 1, 17));
		g.drawString(DIGIT_GUIDE, 25, 250);
		g.drawString(DIGIT_GUIDE_TEXT, 25, 265);
		
		g.drawString("Time Remaining: ", 575, 125);
		g.drawString("Score: ", 725, 125);
		
		g.setFont(new Font("Geneva", 1, 25));
		g.drawString("GAME STATS: ", 150, 400);
		
		g.setFont(new Font("Geneva", 1, 20));
		g.drawString("Score: " + score, 150, 430);
		g.drawString("Level: " + level, 150, 460);
		g.drawString("Lives: " + lives, 150, 490);
		
		
		
	}
	

}