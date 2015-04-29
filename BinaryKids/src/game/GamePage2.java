package game;


import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.font.FontRenderContext;
import java.awt.geom.Rectangle2D;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.swing.Box;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JProgressBar;
import javax.swing.Timer;

import tutorial.Controller;


@SuppressWarnings("serial")
public class GamePage2 extends JPanel {
	
	int countCorrect = 0;
	
	private Controller controller;

	//size of applet
	private static int progressXCoord = 150;
	
	Insets insets;
	//indicates if game has been paused
	boolean isPaused;
	
	//progress bar to measure time remaining
	JProgressBar progressBar;
	//progress bar to measure score
	JProgressBar scoreBar;
	
	//timer
	public Timer timer;
	
	//Array to hold questions and answers
	public ArrayList<String> questionArray;
	public ArrayList<String> answerArray;
	
	//buttons to represent each binary decimal place
	JButton one;
	JButton two;
	JButton four;
	JButton eight;
	JButton sixteen;
	JButton thirtytwo;
	JButton sixtyfour;
	
	//button to submit answer for review
	JButton submitButton;
	//button to quit game prematurely 
	JButton stopButton;
	//button to pause game
	JButton pauseButton;
	//button to resume game while paused
	JButton resumeButton;
	
	//panel to hold pause and quit buttons 
	JPanel buttonPanel;
	
	//count down remaining time
	int counter;
	//track progress through questions 
	int progress;
	//track score
	int score;
	//track remaining lives 
	int lives;
	//track current level
	int level;
	
	int oneXCoord;
	int oneYCoord;
	int oneHeight;
	int twoXCoord;
	int fourXCoord;
	int eightXCoord;
	int sixteenXCoord;
	int thirtytwoXCoord;
	int sixtyfourXCoord;

	//flags for each decimal place to indicate if it
	//is currently at one or zero
	int flagOne;
	int flagTwo;
	int flagFour;
	int flagEight;
	int flagSixteen;
	int flagThirtyTwo;
	int flagSixtyFour;
	
	//random number generator
	Random rand;
	
	//current question
	String currentQuestion;
	
	//various colors used throughout
	public static Color backgroundColor = new Color(255, 255, 204);
	public static Color buttonPanelColor = new Color(152, 46, 68);
	public static Color headlineColor = new Color(255, 102, 102);
	public static Color questionColor = new Color(243, 202, 49);
	
	//constant strings to show user what place each binary digit button is
	//used for setting lcoation on panel
	public static String SIX_FOUR_PLACE = "64 place";
	public static String THREE_TWO_PLACE = "32 place";
	public static String ONE_SIX_PLACE = "16 place";
	public static String EIGHT_PLACE = "8 place";
	public static String FOUR_PLACE = "4 place";
	public static String TWO_PLACE = "2 place";
	public static String ONE_PLACE = "1 place";
	public static int PLACE_PADDING = 10;
	
	public static int STAT_TEXT_X_COORD = 40;
	
	public GamePage2(Controller _controller) {
		
		controller = _controller;

		setLayout(null);
		setBackground(Color.BLACK);
			
		insets = getInsets();
		
		//initialization functions
		initializeQuestions();
		initBinButtons();
		initVariables();

		//add buttons to extended JPanel
		add(sixtyfour);
		add(thirtytwo);
		add(sixteen);
		add(eight);
		add(four);
		add(two);
		add(one);
		
		initBars();
		
		//create board before starting game
		startGame();
	
		add(submitButton);
		add(resumeButton);
		
		add(buttonPanel);
		
		resumeButton.setVisible(false);
		
	}

	
	//initialize variables to starting values
	public void initVariables() {
		counter = 120;
		progress = 0;
		score = 0;
		lives = 3;
		level = 1;
		
		isPaused = false;

		currentQuestion = "";
	}
	
	//start game
	private void startGame() {
		
		//load first question from questionsArray to screen
		nextQuestion();
		
		//create a new timer
		timer = new Timer(1000, new timeListener());

		//start the timer
		//timer.start();
		
		//create submit button
		Dimension buttonSize = new Dimension(100, 100);
		submitButton = new JButton("Submit");
		submitButton.setIcon(new ImageIcon( controller.submitButtonImage));
		submitButton.setBorderPainted(false);
		submitButton.setContentAreaFilled(false);
	
		submitButton.setBounds(350-buttonSize.width/2 + insets.left, 250 + insets.top, buttonSize.width, buttonSize.height);
		submitButton.addActionListener(new submitListener());
		
		//create pause button
		pauseButton = new JButton("Pause");
		pauseButton.setBackground(backgroundColor);
		pauseButton.setBounds(300, 480, buttonSize.width, buttonSize.height);
		pauseButton.addActionListener(new pauseListener());

		//create stop button
		stopButton = new JButton("Quit");
		stopButton.setBackground(backgroundColor);
		buttonSize = stopButton.getPreferredSize();
		stopButton.setBounds(300, 500, buttonSize.width, buttonSize.height);
		stopButton.addActionListener(new stopListener());
		
		//create box to format spacing between stop and pause button on buttonPanel
		Box box = Box.createVerticalBox();
		
		//create button panel to hold pause and stop button on main panel
		buttonPanel = new JPanel();
		Dimension panelDimension = new Dimension(225, 200);
		buttonPanel.setBackground(headlineColor);
		box.add(Box.createVerticalStrut(50));
		box.add(pauseButton);
		box.add(Box.createVerticalStrut(30));
		box.add(stopButton);
		buttonPanel.add(box);
		buttonPanel.setBounds(285, 365, panelDimension.width, panelDimension.height);
		
		//create resume button
		resumeButton = new JButton("Resume");
		buttonSize = new Dimension(400, 100);
		resumeButton.setBounds(375-buttonSize.width/2 + insets.left, 300 + insets.top, buttonSize.width, buttonSize.height);
		resumeButton.addActionListener(new resumeListener());
		
	
	}
	
	//set currentquestion equal to value in question array at current index
	private void nextQuestion() {
		currentQuestion = questionArray.get(progress);
		repaint();
	}
	
	//listen for press of the pause buton
	class pauseListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			System.out.println("The pause button was pressed");
			//set isPaused equal to true
			isPaused = true;
			//create the pause game screen
			initPauseScreen();
		}
	}
	
	//create the pause game screen
	public void initPauseScreen() 
	{
		//stop the timer
		timer.stop();
		
		setBackground(backgroundColor);
		
		//hide all game components
		hideGame();

		
		repaint();
		
	}
	
	//set game components visibility to false when game is paused
	private void hideGame()
	{
		sixtyfour.setVisible(false);
		thirtytwo.setVisible(false);
		sixteen.setVisible(false);
		eight.setVisible(false);
		four.setVisible(false);
		two.setVisible(false);
		one.setVisible(false);
		
		progressBar.setVisible(false);
		scoreBar.setVisible(false);
		
		submitButton.setVisible(false);
		pauseButton.setVisible(false);
		
		buttonPanel.setVisible(false);
		
		//set resume button visibility to true so user can return to game
		resumeButton.setVisible(true);
		
	}
	
	//listen for press of the stop button
	class stopListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e)
		{
			//if pressed, call the endGame function with int 2
			endGame(2);
		}
	
	}
	
	//list for press of the resume button
	class resumeListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) 
		{
			//re-start the gimer
			timer.start();
			
			//game is no longer paused
			isPaused = false;
			
			//make main game components visible again
			revealGame();
		}
	}
	
	//make main game components visible
	private void revealGame()
	{
		setBackground(Color.BLACK);
		
		sixtyfour.setVisible(true);
		thirtytwo.setVisible(true);
		sixteen.setVisible(true);
		eight.setVisible(true);
		four.setVisible(true);
		two.setVisible(true);
		one.setVisible(true);
		
		progressBar.setVisible(true);
		scoreBar.setVisible(true);
		
		submitButton.setVisible(true);
		pauseButton.setVisible(true);
		
		buttonPanel.setVisible(true);
		
		//hide pause screen components 
		resumeButton.setVisible(false);
	}
	
	//listen for timer
	class timeListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			//decrease counter by one
			counter--;
			//set progress bar to updated time value
			progressBar.setValue(counter);
			//repaint
			repaint();
			
			//when counter reaches 0, time is up!
			if (counter == 0) {
				//stop the timer
				timer.stop();
				//end the game
				endGame(0);
			}
		}
	}
	
	//listen for press of submit button
	class submitListener implements ActionListener {
		
		public void actionPerformed(ActionEvent e) 
		{
			boolean isCorrect;
			//check to see if submitted answer was correct
			isCorrect = checkAnswer();
			
			//if so...
			if (isCorrect == true) {
				//update score exponentially
				score = updateScore();
				
				//show congrats message
		    	JOptionPane.showMessageDialog(new JFrame(), "Correct, good job!", "Right Answer", JOptionPane.YES_NO_OPTION);
				
		    	//update score bar with new score
		    	scoreBar.setValue(score);
		    	
		    	//check to see if there have been level changes
				checkLevel();
				//load the next question
				nextQuestion();
				
				one.setIcon(new ImageIcon( controller.game0ButtonImage));
				two.setIcon(new ImageIcon( controller.game0ButtonImage));
				four.setIcon(new ImageIcon( controller.game0ButtonImage));
				eight.setIcon(new ImageIcon( controller.game0ButtonImage));
				sixteen.setIcon(new ImageIcon( controller.game0ButtonImage));
				thirtytwo.setIcon(new ImageIcon( controller.game0ButtonImage));
				sixtyfour.setIcon(new ImageIcon(controller.game0ButtonImage));
				
				//set flag to corresponding integer 0
				flagOne = 0;
				flagTwo = 0;
				flagFour = 0;
				flagEight = 0;
				flagSixteen = 0;
				flagThirtyTwo = 0;
				flagSixtyFour = 0;
				
			}
			//if the answer was wrong
			else {
				
				//decrement lives
				lives--;
				//if the player is out of lives
				if (lives == 0)
					//call end game with integer 1
					endGame(1);
				//if the user has not run out of lives
				else {
					//alert they have answered incorrectly and let them continue playing
					String wrongAnswer = "Wrong Answer! Try again";
			    	JOptionPane.showMessageDialog(new JFrame(), wrongAnswer, "Wrong Answer", JOptionPane.YES_NO_OPTION);
				}
			}
				
		}
	}
	
	//function to update the score
	private int updateScore() {
		countCorrect++;
		return score + 50;
		
	}
	
	//function to check current level
	private void checkLevel() {
		
		//if they have answered 5 questions correctly before running out of time
		if (countCorrect == 5) {
			//move to level 2
			level = 2;
			//alert user they have reached level 2
			JOptionPane.showMessageDialog(new JFrame(), "On to level 2!", "Next Level", JOptionPane.YES_NO_OPTION);
			//re-set time
			counter = 120;
		}
		//if they have answered 15 questions correctly before running out of time
		else if (countCorrect == 15) {
			//move to level 3
			level = 3;
			//alert user they have reached level 2
			JOptionPane.showMessageDialog(new JFrame(), "On to level 3!", "Next Level", JOptionPane.YES_NO_OPTION);
			//re-set time for level
			counter = 120;
		} 
		//if they have answered 25 questions correctly before running out of time
		else if (countCorrect == 25) {
			//update to level 4
			level = 4;
			//let user they have reached level 4
			JOptionPane.showMessageDialog(new JFrame(), "On to level 4!", "Next Level", JOptionPane.YES_NO_OPTION);
		} 
		//if they have answered all questions
		else if (countCorrect == 40) {
			//alert user they have won the game
			JOptionPane.showMessageDialog(new JFrame(), "Congrats! You won!", "You Won!", JOptionPane.YES_NO_OPTION);
			endGame(2);
		}
	}
	
	//function that ends the game and returns to the GameWelcomePage
	private void endGame(int reason) {
		
		String message="";
		
		//if game is ending because time has run out
		if (reason == 0) {
			message = "You ran out of time! Game over.";
			//display goodbye message
			JOptionPane.showMessageDialog(this, message, "Game Over!", JOptionPane.YES_NO_OPTION);	
		
			controller.loadCard("GAME WELCOME");
		}
		//if game is ending because lives have run out
		else if (reason == 1) {
			timer.stop();
			message = "Out of lives! Game Over.";
			//display goodbye message
			JOptionPane.showMessageDialog(this, message, "Game Over!", JOptionPane.YES_NO_OPTION);	
		
			controller.loadCard("GAME WELCOME");
		}
		//if game is ending because user quits and/or beats the game
		else if (reason == 2) {
			timer.stop();
			message = "Goodbye! Come back soon!";
					
			//display goodbye message
			JOptionPane.showMessageDialog(this, message, "Game Over!", JOptionPane.YES_NO_OPTION);	
		
			controller.loadCard("GAME WELCOME");
		}
		else if (reason == 2 && countCorrect >=1 ) { 
			timer.stop();
			message = "You're awesome! Congrats on learning binary!!";
					
			//display goodbye message
			JOptionPane.showMessageDialog(this, message, "Game Over!", JOptionPane.YES_NO_OPTION);	
		
			controller.loadCard("GAME WELCOME");
		}

	}
	
	//check submitted answer
	private boolean checkAnswer() {
		
		//go through each bin button. If flag is set to 0, add 0 to array
		//if flag is set to 1, add 1 to array
		//concatonate array of characters into a final binary number string
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
		
		//compare final concatenated string with binary value in answer array
		//in corresponding index to the question
		if (finalAnswer.equals(answerArray.get(progress))) {
			//move on to the next question/answer pair, if correct
			progress++;
			return true;
		} else 
			return false;
	}
	
	//initialize progress bars
	private void initBars() {
		
		//set size for bars
		Dimension size = new Dimension(60, 350);
		
		//set starting value, background and foreground colors
		progressBar = new JProgressBar(JProgressBar.VERTICAL);
		progressBar.setValue(120);
		progressBar.setBackground(Color.RED);
		progressBar.setForeground(Color.GREEN);	
		
		progressBar.setBounds(650-size.width/2 + insets.left, progressXCoord + insets.top, size.width, size.height);
	
		scoreBar = new JProgressBar(JProgressBar.VERTICAL);
		scoreBar.setValue(0);
		scoreBar.setBackground(Color.RED);
		scoreBar.setForeground(Color.GREEN);
		scoreBar.setBounds(725-size.width/2 + insets.left, progressXCoord + insets.top, size.width, size.height);
	
		//add to panel
		add(progressBar);
		add(scoreBar);
	
	}
	
	//initialize binary digit buttons
	private void initBinButtons() {
		
		//create new dimension for the buttons
		Dimension size = new Dimension(75, 75);
		
		//set coordinates on screen
		oneXCoord = 75-size.width/2 + insets.left;
		oneYCoord = 150 + insets.top;
		oneHeight = size.height;
	
		twoXCoord = 155-size.width/2 + insets.left;
		fourXCoord = 235-size.width/2 + insets.left;
		eightXCoord = 315 - size.width/2 + insets.left;
		sixteenXCoord = 395-size.width/2 + insets.left;
		thirtytwoXCoord = 475-size.width/2 + insets.left;
		sixtyfourXCoord = 555-size.width/2 + insets.left;
				
		//for each button:
		//1. create new JButton
		//2. set background icon to '0' and flag to 0 to reflect current state
		one = new JButton();
		changeButton(one, flagOne);
		//set bounds on screen
		one.setBounds(oneXCoord, oneYCoord, size.width, size.height);
		//add action listener 
		one.addActionListener(new changeDigitListener());
		
		two = new JButton();
		changeButton(two, flagTwo);
		two.setPreferredSize(size);
		two.setBounds(twoXCoord, oneYCoord, size.width, size.height);
		two.addActionListener(new changeDigitListener());
		
		four = new JButton();
		changeButton(four, flagFour);
		four.setPreferredSize(size);
		four.setBounds(fourXCoord, oneYCoord, size.width, size.height);
		four.addActionListener(new changeDigitListener());
		
		eight = new JButton();
		changeButton(eight, flagEight);
		eight.setPreferredSize(size);
		eight.setBounds(eightXCoord, oneYCoord, size.width, size.height);
		eight.addActionListener(new changeDigitListener());
		
		sixteen = new JButton();
		changeButton(sixteen, flagSixteen);
		sixteen.setPreferredSize(size);
		sixteen.setBounds(sixteenXCoord, oneYCoord, size.width, size.height);
		sixteen.addActionListener(new changeDigitListener());
		
		thirtytwo = new JButton();
		changeButton(thirtytwo, flagThirtyTwo);
		thirtytwo.setPreferredSize(size);
		thirtytwo.setBounds(thirtytwoXCoord, oneYCoord, size.width, size.height);
		thirtytwo.addActionListener(new changeDigitListener());
		
		sixtyfour = new JButton();
		changeButton(sixtyfour, flagSixtyFour);
		sixtyfour.setPreferredSize(size);
		sixtyfour.setBounds(sixtyfourXCoord, oneYCoord, size.width, size.height);
		sixtyfour.addActionListener(new changeDigitListener());
		
		//call function to set background image of buttons
		setButtonIconFlag();
		
	}
	
	private void setButtonIconFlag() {
		
		//initialize background image of all buttons to digit 0
		one.setIcon(new ImageIcon( controller.game0ButtonImage));
		two.setIcon(new ImageIcon( controller.game0ButtonImage));
		four.setIcon(new ImageIcon( controller.game0ButtonImage));
		eight.setIcon(new ImageIcon( controller.game0ButtonImage));
		sixteen.setIcon(new ImageIcon( controller.game0ButtonImage));
		thirtytwo.setIcon(new ImageIcon( controller.game0ButtonImage));
		sixtyfour.setIcon(new ImageIcon(controller.game0ButtonImage));
		
		//set flag to corresponding integer 0
		flagOne = 0;
		flagTwo = 0;
		flagFour = 0;
		flagEight = 0;
		flagSixteen = 0;
		flagThirtyTwo = 0;
		flagSixtyFour = 0;
	}
	
	//listen for click of a binary digit button
	class changeDigitListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e)
		{
			//identify which button was clicked
			Object src = e.getSource();

			if (src == one) {
				//change background to the opposite of what it currently is
				//determined by flag value
				changeButton(one, flagOne);
				//update flag to reflect new state
				flagOne = setFlag(flagOne);
			} else if (src == two) {
				changeButton(two, flagTwo);
				flagTwo = setFlag(flagTwo);
			} else if (src == four) {
				changeButton(four, flagFour);
				flagFour = setFlag(flagFour);
			} else if (src == eight) {
				changeButton(eight, flagEight);
				flagEight = setFlag(flagEight);
			} else if (src == sixteen) {
				changeButton(sixteen, flagSixteen);
				flagSixteen = setFlag(flagSixteen);
			} else if (src == thirtytwo) {
				changeButton(thirtytwo, flagThirtyTwo);
				flagThirtyTwo = setFlag(flagThirtyTwo);
			} else if (src == sixtyfour) {
				changeButton(sixtyfour, flagSixtyFour);
				flagSixtyFour = setFlag(flagSixtyFour);
			}
		}
	}
	
	//update flag after changing button icon
	private int setFlag(int flag) {
		//set flag to opposite of whatever was passed in
		if (flag == 0)
			flag = 1;
		else if (flag == 1)
			flag = 0;
		
		return flag;
	}
	
	//chage background image of button when clicked
	public void changeButton(JButton myButton, int flag) {
		
		//set to opposite of whatever it currently is
		//as determined by current flag value
		if (flag == 0) {
			myButton.setIcon(new ImageIcon( controller.game1ButtonImage));
		} else if (flag == 1) {
			myButton.setIcon(new ImageIcon( controller.game0ButtonImage));
		}
		
		repaint();
		
	}
	
	//fill array with questions and answers for game
	public void initializeQuestions() {
		
		questionArray = new ArrayList<String>();
		answerArray = new ArrayList<String>();
		
		String convertAnswerBin;
		
		//for levels 1-3, only use numbers between 0 and 64
		int MAX_BIN_SIZE = 63;
		int MIN_BIN_SIZE = 0;
		
		//LEVELS 1-3
		for (int i=0; i < 25; i++)
		{
			//randomly create number in range
			rand = new Random();
			int randNum = rand.nextInt((MAX_BIN_SIZE - MIN_BIN_SIZE) + 1) + MIN_BIN_SIZE;
			//convert that number to binary
			convertAnswerBin = convertToBin(randNum);
			//add number (with question text) to question array
			questionArray.add("QUESTION: What is " + randNum + " in binary?");
			//pad binary answer (becuase user automatically submits all binary digits)
			//so add 0's if necessary
			convertAnswerBin = padAnswer(convertAnswerBin);
			//add padded answer to answer array at index corresponding with the question
			answerArray.add(convertAnswerBin);
		}
		
		//if level is 4, increase difficulty
		//by allowing numbers up to 127
		MAX_BIN_SIZE = 127;
		
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

	//if question does not use all digits
	//pad answer with 0's so input answer will match
	//expected answer 
	private String padAnswer(String number) {
		while (number.length() < 7)
			number = "0" + number;
		return number;
	}

	//convert decimal to binary number
	String convertToBin (int i) {
		return Integer.toString(i, 2);
	}
	
	public void paint(Graphics g) {
			
		super.paint(g);
		
		//create quesiton panel at top of the screen
		g.setColor(questionColor);
		
		int x = 0;
		
		for (int i = 0; i < 10; i++) {
			g.fillRect(x, 0, 80, 80);
			x = x + 80;
		}
		
		g.setColor(Color.BLACK);
		g.setFont(new Font("Geneva", Font.BOLD , 25));
		
		//if game is paused, only display string with pause message
		if (isPaused == true)
		{
			g.drawString("Game is paused. Click to resume", 250, 50);
		}

		//otherwise, display everything else
		else if (isPaused == false) {
			
			g.drawString(currentQuestion, 250, 50);
			
			int placeStringHeight = oneYCoord + oneHeight + PLACE_PADDING;
			
			if (level < 4) {
				g.setColor(Color.WHITE);
				g.setFont(new Font("Geneva", 1, 17));
				g.drawString(SIX_FOUR_PLACE, oneXCoord, placeStringHeight);
				g.drawString(THREE_TWO_PLACE, twoXCoord, placeStringHeight);
				g.drawString(ONE_SIX_PLACE, fourXCoord, placeStringHeight);
				g.drawString(EIGHT_PLACE, eightXCoord, placeStringHeight);
				g.drawString(FOUR_PLACE, sixteenXCoord, placeStringHeight);
				g.drawString(TWO_PLACE, thirtytwoXCoord, placeStringHeight);
				g.drawString(ONE_PLACE, sixtyfourXCoord, placeStringHeight);
			}
			
			g.setFont(new Font("Geneva", 1, 14));
			g.drawString("Time: " + counter, 605, 125);
			g.drawString("Score: " + score, 700, 125);
			
			//gameStats box
			g.setColor(backgroundColor);
			g.fillRect(25, 365, 225, 200);
		
			
			//scoreboard box
			g.setColor(headlineColor);
			g.fillRect(35, 405, 205, 155);
		
			g.setFont(new Font("Geneva", 1, 25));
			g.setColor(Color.BLACK);
			
			g.drawString("GAME STATS: ", 35, 400);
			g.drawString("CONTROLLERS: ", 290, 400);
			
			g.setFont(new Font("Geneva", 1, 25));
			g.setColor(Color.WHITE);
			g.drawString("Score: ", STAT_TEXT_X_COORD, 440);
			g.drawString("Level: ", STAT_TEXT_X_COORD, 470);
			g.drawString("Lives: ", STAT_TEXT_X_COORD, 500);
			
			int updatingText = STAT_TEXT_X_COORD + 80;
			
			g.setColor(Color.GREEN);
			
			String scoreString = Integer.toString(score);
			String levelString = Integer.toString(level);
			String liveString = Integer.toString(lives);
		
			g.drawString(scoreString, updatingText, 440);
			g.drawString(levelString, updatingText, 470);
			g.drawString(liveString, updatingText, 500); 
		}
		
	}	
	
}
	
	
	

