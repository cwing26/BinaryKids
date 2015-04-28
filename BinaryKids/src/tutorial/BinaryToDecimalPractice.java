package tutorial;

//imports
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Toolkit;
import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;

import tutorial.DecimalToBinaryPractice.answerButtonListener;
import tutorial.DecimalToBinaryPractice.hintButtonListener;
import tutorial.DecimalToBinaryPractice.tutorialButtonListener;

import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;




/*This class implements the PracticeProblem interface to
 * give users practice problems to answer after they've completed
 * the decimal to binary learning tutorial
 */
@SuppressWarnings("serial")
public class BinaryToDecimalPractice extends JPanel implements PracticeProblem 
{

	//a boolean to show whether the user got the answer correct
	private boolean correctAnswer = false;
		//if user answers more than 3 questions correctly, they can return back to 
		//the tutorial home page
		private int countCorrect = 0; 
		
		//number of distinct practice problems the user can have
		private final int practiceValues = 200;
		
		//to hold the test practice values (binary)
		private ArrayList <String> values = new ArrayList<String>();
		
		//to hold the solutions to the practice problems (decimal)
		private ArrayList <Integer> solutions = new ArrayList<Integer>();
		
		
		//page components
		private JButton submitAnswerButton;
		private JButton hintButton;
		private JButton tutorialButton;
		private boolean hintClicked = false; //allows class to display graphic if hint button is clicked
		private JTextField answerField;
		private String question = "Convert the decimal number below to binary:";
		private String inputAnswer; //stores user input

		//keeps track of which question is being displayed and answered
		private int questionIndex = 0;
		
		//text on screen
		private final String hint = "Remember, each digit represents a different power of 2.";
		private final String hint2 = "Start with the ones place on this side!";
		
		//to connect to the controller class
		private WelcomePage welcomePage;
		
		//coordinates of components on screen
		private final int universalLeftBound = 200;
		private final int buttonTopBound = 330;
		private final int textFieldTopBound = 280;
		private final int hintButtonLeftBound = 350;
		private final int tutorialButtonTopBound = 380;
		
		private final int titleImageX = 5;
		private final int titleImageY = 5;
		
		private final int questionX = 5;
		private final int questionY = 140;
		
		private final int questionNumX = 200;
		private final int questionNumY = 240;
		
		private final int hintImageX = 410;
		private final int hintImageY = 410;
		
		private final int hintTextY = 400;
		
		private final int hint2X = 430;
		private final int hint2Y = 220;
	
	
	//constructor
	public BinaryToDecimalPractice(WelcomePage welcome)
	{
		welcomePage = welcome;
		
		setBackground(WelcomePage.backgroundColor);
		
		initComponents();
		addComponentsToPanel();
		positionComponents();

		populateQuestionArrays(practiceValues);
		populateAnswerArray(practiceValues);
		
		//sets the first question to a random index value
		//in the question array
		questionIndex = setQuestion();

	}
	
	//adds GUI components to panel
		@Override
		public void addComponentsToPanel()
		{
			setLayout(null);
			
			add(answerField);
			add(submitAnswerButton);
			add(hintButton);
			add(tutorialButton);

		}
		
		//positions GUI components on screen
		@Override
		public void positionComponents()
		{
			Insets insets = getInsets();
			Dimension textFieldSize = answerField.getPreferredSize();
			answerField.setBounds(universalLeftBound + insets.left, textFieldTopBound + insets.top,
		            textFieldSize.width, textFieldSize.height);
			
			Dimension buttonSize = submitAnswerButton.getPreferredSize();
			submitAnswerButton.setBounds(universalLeftBound + insets.left, buttonTopBound + insets.top, buttonSize.width, buttonSize.height);
			
			Dimension hintButtonSize = hintButton.getPreferredSize();
			hintButton.setBounds(hintButtonLeftBound + insets.left, buttonTopBound + insets.top, hintButtonSize.width, hintButtonSize.height);
			
			Dimension tutorialButtonSize = tutorialButton.getPreferredSize();
			tutorialButton.setBounds(universalLeftBound + insets.left, tutorialButtonTopBound + insets.top, tutorialButtonSize.width, tutorialButtonSize.height);
			tutorialButton.setVisible(false);
			
		}
	

	//displays the nonGUI components on the screen
	public void paint(Graphics g)
	{
		super.paint(g);
		
		g.drawImage(welcomePage.practiceProblemTitleImage, titleImageX, titleImageY, this);
    	
    	g.setColor(WelcomePage.textColor);
    	g.setFont(new Font("Geneva", 1, 20));
    	g.drawString(question, questionX, questionY);
    	
    	g.setFont(new Font("Geneva", 1, 60));
    	g.setColor(WelcomePage.buttonPanelColor);
    	g.drawString(values.get(questionIndex), questionNumX, questionNumY);
    	
    	if (countCorrect >= 3)
    	{
    		tutorialButton.setVisible(true);
    	}
    	
    	if(hintClicked)
    	{
    		g.drawImage(welcomePage.hintImage, hintImageX, hintImageY, this);
    		g.setColor(WelcomePage.textColor);
        	g.setFont(new Font("Geneva", 1, 12));
        	g.drawString(hint, hintImageX, hintTextY);
        	
        	g.setColor(Color.red);
        	g.setFont(new Font("Geneva", 1, 15));
        	g.drawString(hint2, hint2X, hint2Y);
    		
    	}
    	
	} //end paint
	
	
	
	@Override
	public void populateQuestionArrays(int size)
	{
		solutions.clear();
		
		Random rand = new Random();
		for(int count = 0; count < size; count++)
		{
			int randomNum = rand.nextInt(65);
			solutions.add(randomNum);
		}
	}
	
	
	//initializes all GUI components 
	@Override
	public void initComponents() 
	{
		submitAnswerButton = new JButton("Submit Answer");
		submitAnswerButton.addActionListener(new answerButtonListener());
		
		hintButton = new JButton("Need a hint?");
		hintButton.addActionListener(new hintButtonListener());
		
		tutorialButton = new JButton("Return to Tutorial Selection");
		tutorialButton.addActionListener(new tutorialButtonListener());
		
		answerField = new JTextField("");
		answerField.setFont(new Font("Geneva", 1, 20));
		answerField.setColumns(10);

	}

	//sets the next question to a random
	//index in the question array
	@Override
	public int setQuestion() 
	{
		Random rand = new Random();
		return rand.nextInt(practiceValues);

	}

	//checks for correct answer 
	@Override
	public boolean checkAnswer(String userAnswer, int index) 
	{
		// TODO Auto-generated method stub
		if(inputAnswer.equals(solutions.get(index).toString()))
		{
			return true;
		}
		else
			return false;
		
	}
	
	//calculates the binary value of the random
	//decimal values in the question array and 
	//stores them in the values array of strings
	@Override
	public void populateAnswerArray(int size) 
	{
		
		values.clear();
		
		String binary = "";
		int decimalNumber = 0;
		int remainder = 0;
		
		for(int count = 0; count < size; count++)
		{
			binary = "";
			
			if(solutions.get(count) == 0)
				values.add(count, "0");
			else
			{
				decimalNumber = solutions.get(count);
				//common algorithm to calculate binary number value
				while(decimalNumber > 0)
				{
					remainder = decimalNumber % 2;
					binary = remainder + binary;
					decimalNumber = decimalNumber / 2;
				}
				
			}
			
			values.add(count, binary);
		}
		
	}


	//calls the checkAnswer() method to determine whether 
	//user entered the correct answer. if answer is correct,
	//generates another random question for user to answer and
	//increments count correct to decide whether it's appropriate
	//to allow user to return to tutorial home page
	//if wrong answer, gives user another try 
	class answerButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{			
			inputAnswer = answerField.getText();
			if (checkAnswer(inputAnswer, questionIndex))
			{
				countCorrect++;
				String congratsMessage = "Correct answer!";
				JOptionPane.showMessageDialog(welcomePage, congratsMessage, "correct answer", JOptionPane.YES_NO_OPTION);
				answerField.setText("");
				questionIndex = setQuestion();
				repaint();
			}
			else{
				String errorMessage = "Wrong answer, try again!";
				JOptionPane.showMessageDialog(welcomePage, errorMessage, "wrong answer", JOptionPane.YES_NO_OPTION);
				answerField.setText("");
				repaint();
			}

		} //end action performed
	} //end button listener
	
	
	//signals to the paint method to display the hint graphic if 
	//hint button is clicked
	class hintButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{			
			hintClicked = true;
			repaint();

		} //end action performed
	} //end button listener

	
	//if the user answers 3 questions correctly, the tutorial button will appear
	//and allow users to navigate back to the tutorial home page
	class tutorialButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{			
			welcomePage.loadCard("FOURTH");

		} //end action performed
	} //end button listener

}


