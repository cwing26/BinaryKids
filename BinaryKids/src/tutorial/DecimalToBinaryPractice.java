//this class is the fifth page in the decimal to binary tutorial
//has practice probelsm from decimal to binary

package tutorial;
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
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;


@SuppressWarnings("serial")
public class DecimalToBinaryPractice extends JPanel implements PracticeProblem 
{
	//a boolean to show whether the user got the answer correct
	private int countCorrect = 0;

	//number of potentially different practice problems the user can have
	private int practiceValues = 200;

	//to hold the test practice values (binary)
	private ArrayList <Integer> values = new ArrayList<Integer>();

	//to hold the solutions to the practice problems (decimal)
	private ArrayList <String> solutions = new ArrayList<String>();


	//page components
	private JButton submitAnswerButton;
	private JButton hintButton;
	private JButton tutorialButton;
	boolean hintClicked = false;
	private JTextField answerField;
	private final String question = "Convert the decimal number below to binary:";
	private String inputAnswer;

	int questionIndex = 0;

	private final String hint = "Remember, each binary digit represents a different power of 2.";
	private final String hint2 = "Start by finding the largest power of two";
	private final String hint2cont = "smaller than this one and subtract!";

	//images
	private Image titleImage;
	private Image hintImage;

	WelcomePage welcomePage;

	private final int hintImgX = 410;
	private final int hintImgY = 410;
	private final int hint1X = 410;
	private final int hint1Y = 400;
	private final int hint2X = 430;
	private final int hint2Y = 220;
	private final int hint2ContX = 430;
	private final int hint2ContY = 240;
	private final int answerFieldX = 200;
	private final int answerFieldY = 280;
	private final int submitButtonX = 200;
	private final int submitButtonY = 330;
	private final int hintButtonX = 350;
	private final int hintButtonY = 330;
	private final int tutButtonX = 200;
	private final int tutButtonY = 380;


	private final int questionX = 40;
	private final int questionY = 135;
	private final int questionIndexX = 200;
	private final int questionIndexY = 240;
	private final int headerX = 5;
	private final int headerY = 5;


	//constructor, param is applet
	public DecimalToBinaryPractice(WelcomePage welcome)
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
		submitAnswerButton.setBounds(submitButtonX + insets.left, submitButtonY + insets.top, buttonSize.width, buttonSize.height);

		Dimension hintButtonSize = hintButton.getPreferredSize();
		hintButton.setBounds(hintButtonX + insets.left, hintButtonY + insets.top, hintButtonSize.width, hintButtonSize.height);

		Dimension tutorialButtonSize = tutorialButton.getPreferredSize();
		tutorialButton.setBounds(tutButtonX + insets.left, tutButtonY + insets.top, tutorialButtonSize.width, tutorialButtonSize.height);
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

	//overrides paint method
	public void paint(Graphics g)
	{
		super.paint(g);

		g.drawImage(titleImage, headerX, headerY, this);


		g.setColor(WelcomePage.textColor);
		g.setFont(new Font("Geneva", 1, 20));
		g.drawString(question, questionX, questionY);


		g.setFont(new Font("Geneva", 1, 60));
		g.setColor(WelcomePage.buttonPanelColor);
		g.drawString(values.get(questionIndex).toString(), questionIndexX, questionIndexY);

		if (countCorrect >= 3){
			tutorialButton.setVisible(true);
		}

		if(hintClicked)
		{
			g.drawImage(hintImage, hintImgX, hintImgY, this);
			g.setColor(WelcomePage.textColor);
			g.setFont(new Font("Geneva", 1, 12));
			g.drawString(hint, hint1X, hint1Y);

			g.setColor(Color.red);
			g.setFont(new Font("Geneva", 1, 15));
			g.drawString(hint2, hint2X, hint2Y);
			g.drawString(hint2cont, hint2ContX, hint2ContY);

		}

	}


	//load images for this panel
	@Override
	public void loadImages()
	{
		titleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.decPracticeProblemPath)); 
		titleImage = titleImage.getScaledInstance(790, 40, Image.SCALE_SMOOTH);

		hintImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.hintGraphicPath)); 
		hintImage = hintImage.getScaledInstance(331,147, Image.SCALE_SMOOTH);

	}

	//generate the questions
	@Override
	public void populateQuestionArrays(int size)
	{
		values.clear();

		Random rand = new Random();
		for(int count = 0; count < size; count++)
		{
			int randomNum = rand.nextInt(63);
			values.add(randomNum);
		}


	}

	//init swing components
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

	//sets the current question
	@Override
	public int setQuestion() 
	{
		//math.rand to choose a random index in array 
		Random rand = new Random();
		return rand.nextInt(200);

	}

	//compares the users answer against the correct answer
	@Override
	public boolean checkAnswer(String userAnswer, int index) 
	{
		if(inputAnswer.equals(solutions.get(index)))
		{
			return true;
		}
		else
			return false;

	}

	//generates the answers to questions
	@Override
	public void populateAnswerArray(int size) 
	{

		solutions.clear();

		String binary = "";
		int decimalNumber = 0;
		int remainder = 0;

		for(int count = 0; count < size; count++)
		{
			binary = "";

			if(values.get(count) == 0)
				solutions.add(count, "0");
			else
			{
				decimalNumber = values.get(count);
				while(decimalNumber > 0)
				{
					remainder = decimalNumber % 2;
					binary = remainder + binary;
					decimalNumber = decimalNumber / 2;
				}

			}

			solutions.add(count, binary);
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
				String congratsMessage = "Correct answer!";
				JOptionPane.showMessageDialog(welcomePage, congratsMessage, "correct answer", JOptionPane.YES_NO_OPTION);
				answerField.setText("");
				questionIndex = setQuestion();
				countCorrect++;
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


