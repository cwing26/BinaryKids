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
	boolean correctAnswer = false;
	int countCorrect = 0;
	
	//number of potentially different practice problems the user can have
	int practiceValues = 200;
	
	//to hold the test practice values (binary)
	ArrayList <Integer> values = new ArrayList<Integer>();
	
	//to hold the solutions to the practice problems (decimal)
	ArrayList <String> solutions = new ArrayList<String>();
	
	Random rand;
	
	//page components
	JButton submitAnswerButton;
	JButton hintButton;
	JButton tutorialButton;
	boolean hintClicked = false;
	JTextField answerField;
	final String question = "Convert the decimal number below to binary:";
	String inputAnswer;

	int questionIndex = 0;
	
	final String hint = "Remember, each binary digit represents a different power of 2.";
	final String hint2 = "Start by finding the largest power of two";
	final String hint2cont = "smaller than this one and subtract!";
	
	//images
	Image titleImage;
	Image hintImage;
	
	WelcomePage welcomePage;
	
	
	
	public DecimalToBinaryPractice(WelcomePage welcome)
	{
		welcomePage = welcome;
		
		setBackground(WelcomePage.backgroundColor);
		
		initComponents();
		loadImages();
		
		populateQuestionArrays(practiceValues);
		populateAnswerArray(practiceValues);
		questionIndex = setQuestion();
		
		setLayout(null);
		
		add(answerField);
		add(submitAnswerButton);
		add(hintButton);
		add(tutorialButton);
		

		Insets insets = getInsets();
		Dimension textFieldSize = answerField.getPreferredSize();
		answerField.setBounds(200 + insets.left, 280 + insets.top,
	            textFieldSize.width, textFieldSize.height);
		
		Dimension buttonSize = submitAnswerButton.getPreferredSize();
		submitAnswerButton.setBounds(200 + insets.left, 330 + insets.top, buttonSize.width, buttonSize.height);
		
		Dimension hintButtonSize = hintButton.getPreferredSize();
		hintButton.setBounds(350 + insets.left, 330 + insets.top, hintButtonSize.width, hintButtonSize.height);
		
		Dimension tutorialButtonSize = tutorialButton.getPreferredSize();
		tutorialButton.setBounds(200 + insets.left, 380 + insets.top, tutorialButtonSize.width, tutorialButtonSize.height);
		tutorialButton.setVisible(false);
		
	}
	
	
	
	public void paint(Graphics g)
	{
		super.paint(g);
		
		g.drawImage(titleImage, 5, 5, this);
    	
    	g.setColor(WelcomePage.textColor);
    	g.setFont(new Font("Geneva", 1, 20));
    	g.drawString(question, 40, 135);
    	
    	g.setFont(new Font("Geneva", 1, 60));
    	g.setColor(WelcomePage.buttonPanelColor);
    	g.drawString(values.get(questionIndex).toString(), 200, 240);
    	
    	if (countCorrect >= 3){
    		tutorialButton.setVisible(true);
    	}
    	
    	if(hintClicked)
    	{
    		g.drawImage(hintImage, 410, 410, this);
    		g.setColor(WelcomePage.textColor);
        	g.setFont(new Font("Geneva", 1, 12));
        	g.drawString(hint, 410, 400);
        	
        	g.setColor(Color.red);
        	g.setFont(new Font("Geneva", 1, 15));
        	g.drawString(hint2, 430, 220);
        	g.drawString(hint2cont, 430, 240);
    		
    	}
    	
	}
	
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

	@Override
	public int setQuestion() 
	{
		//math.rand to choose a random index in array 
		Random rand = new Random();
		return rand.nextInt(200);

	}

	@Override
	public boolean checkAnswer(String userAnswer, int index) 
	{
		// TODO Auto-generated method stub
		if(inputAnswer.equals(solutions.get(index)))
		{
			return true;
		}
		else
			return false;
		
	}
	
	@Override
	public void populateAnswerArray(int size) 
	{
		
		solutions.clear();
		
		String binary = "";
		int decimalNumber = 0;
		int remainder = 0;
		String remainderString = "";
		
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
	
	
	
	class hintButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{			
			hintClicked = true;
			repaint();

		} //end action performed
	} //end button listener


	class tutorialButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{			
			welcomePage.loadFourth();

		} //end action performed
	} //end button listener

}


