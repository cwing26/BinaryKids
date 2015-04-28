//this class is the fifth page in the binary to decimal tutorial
//has practice probelsm from binary to decimal

package tutorial;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Insets;
import java.awt.Toolkit;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import java.util.ArrayList;
import java.util.Random;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;


@SuppressWarnings("serial")
public class BinaryToDecimalPractice extends JPanel implements PracticeProblem 
{
	//a boolean to show whether the user got the answer correct
	boolean correctAnswer = false;
	int countCorrect = 0;

	//number of potentially different practice problems the user can have
	int practiceValues = 200;

	//to hold the test practice values (binary)
	ArrayList <String> values = new ArrayList<String>();

	//to hold the solutions to the practice problems (decimal)
	ArrayList <Integer> solutions = new ArrayList<Integer>();

	Random rand;

	//page components
	JButton submitAnswerButton;
	JButton hintButton;
	JButton tutorialButton;
	boolean hintClicked = false;
	JTextField answerField;
	private final String question = "Convert the binary number below to decimal:";
	String inputAnswer;

	int questionIndex = 0;


	private final String hint = "Remember, each digit represents a different power of 2.";
	private final String hint2 = "Start with the ones place on this side!";

	//images
	Image titleImage;
	Image hintImage;

	WelcomePage welcomePage;

	private final int answerFieldX = 200;
	private final int answerFieldY = 280;
	private final int submitButttonX = 200;
	private final int submitButtonY = 330;
	private final int hintButttonX = 350;
	private final int hintButtonY = 330;
	private final int tutButttonX = 200;
	private final int tutButtonY = 380;
	private final int headerX = 5;
	private final int headerY = 5;
	private final int questionX = 40;
	private final int questionY = 135;
	private final int questionIndexX = 180;
	private final int questionIndexY = 240;
	private final int hintImgX = 410;
	private final int hintImgY = 410;
	private final int hint1X = 410;
	private final int hint1Y = 400;
	private final int hint2X = 480;
	private final int hint2Y = 230;


	//constructor, param is applet
	public BinaryToDecimalPractice(WelcomePage welcome)
	{
		welcomePage = welcome;

		setBackground(WelcomePage.backgroundColor);

		initComponents();
		loadImages();
		populateQuestionArrays(practiceValues);
		populateAnswerArray(practiceValues);
		questionIndex = setQuestion();
		addComponentsToPanel();
		formatComponents();

		setVisible(true);
	}



	//this method defines the formatting of the components on the panel
	public void formatComponents(){
		Insets insets = getInsets();
		Dimension textFieldSize = answerField.getPreferredSize();
		answerField.setBounds(answerFieldX + insets.left, answerFieldY + insets.top,
				textFieldSize.width, textFieldSize.height);

		Dimension buttonSize = submitAnswerButton.getPreferredSize();
		submitAnswerButton.setBounds(submitButttonX + insets.left, submitButtonY + insets.top, buttonSize.width, buttonSize.height);

		Dimension hintButtonSize = hintButton.getPreferredSize();
		hintButton.setBounds(hintButttonX + insets.left, hintButtonY + insets.top, hintButtonSize.width, hintButtonSize.height);

		Dimension tutorialButtonSize = tutorialButton.getPreferredSize();
		tutorialButton.setBounds(tutButttonX + insets.left, tutButtonY + insets.top, tutorialButtonSize.width, tutorialButtonSize.height);
		tutorialButton.setVisible(false);

	}

	//this method adds the components to the panel
	public void addComponentsToPanel() {
		setLayout(null);
		add(answerField);
		add(submitAnswerButton);
		add(hintButton);
		add(tutorialButton);
	}

	//overridden paint method
	public void paint(Graphics g)
	{
		super.paint(g);

		//title image
		g.drawImage(titleImage, headerX, headerY, this);

		g.setColor(WelcomePage.textColor);
		g.setFont(new Font("Geneva", 1, 20));
		g.drawString(question, questionX, questionY);

		g.setFont(new Font("Geneva", 1, 60));
		g.setColor(WelcomePage.buttonPanelColor);
		g.drawString(values.get(questionIndex), questionIndexX, questionIndexY);

		if (countCorrect >= 3){
			tutorialButton.setVisible(true);
		}

		//display hint if the button has been clicked
		if(hintClicked)
		{
			g.drawImage(hintImage, hintImgX, hintImgY, this);
			g.setColor(WelcomePage.textColor);
			g.setFont(new Font("Geneva", 1, 12));
			g.drawString(hint, hint1X, hint1Y);

			g.setColor(Color.red);
			g.setFont(new Font("Geneva", 1, 15));
			g.drawString(hint2, hint2X, hint2Y);

		}

	}


	//load images
	@Override
	public void loadImages()
	{
		titleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.binPracticeProblemPath)); 
		titleImage = titleImage.getScaledInstance(760, 60, Image.SCALE_SMOOTH);

		hintImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.hintGraphicPath)); 
		hintImage = hintImage.getScaledInstance(331,147, Image.SCALE_SMOOTH);

	}

	//generate questions with random numbers
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

	//initialize all swing components
	@Override
	public void initComponents() 
	{
		submitAnswerButton = new JButton("Submit Answer");
		submitAnswerButton.addActionListener(new answerButtonListener());

		hintButton = new JButton("Need a hint?");
		hintButton.addActionListener(new hintButtonListener());

		tutorialButton = new JButton("Return to Tutorial Select");
		tutorialButton.addActionListener(new tutorialButtonListener());

		answerField = new JTextField("");
		answerField.setFont(new Font("Geneva", 1, 20));
		answerField.setColumns(10);

	}

	//set the question
	@Override
	public int setQuestion() 
	{
		//math.rand to choose a random index in array 
		Random rand = new Random();
		return rand.nextInt(200);

	}

	//verify if the answer is correct or not
	@Override
	public boolean checkAnswer(String userAnswer, int index) 
	{
		if(inputAnswer.equals(solutions.get(index).toString()))
		{
			return true;
		}
		else
			return false;

	}

	//this method populate the answers to the questions
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


	//action listener for answer button
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


	//action listener for hint button
	class hintButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{			
			hintClicked = true;
			repaint();

		} //end action performed
	} //end button listener

	//action listener for tutorial button
	class tutorialButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{			
			welcomePage.loadFourth();

		} //end action performed
	} //end button listener

}


