//this class is the first page in the binary to decimal tutorial

package Tutorial;


import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Rectangle;
import java.util.ArrayList;



@SuppressWarnings("serial")
public class BinaryDecimalOne extends JPanel
{	
	Controller controller;

	String questionText = "How many squares are shown?";
	JButton submitButton;
	JTextField answerField;

	final int correctAnswer = 13;
	final String correctAnswerString = "13";
	int inputAnswer = 0;
	
	final int startXSquare = 150;
	final int startYSquare = 100;

	final int squareUnit = 25;
	
	final int questionTextX = 250;
	final int questionTextY = 200;
	
	final int headerX = 90;
	final int headerY = 15;
	
	private Rectangle square;
	ArrayList<Rectangle> squareList = new ArrayList<Rectangle>();

    //constructor
    public BinaryDecimalOne(Controller welcome)
    {
    	controller = welcome;
    	setBackground(Controller.backgroundColor);
    	setLayout(null);
		Insets insets = getInsets();
		
    	initComponents();
    	initSquares();
    	add(answerField);
    	add(submitButton);
    	
    	Dimension buttonSize = submitButton.getPreferredSize();
		submitButton.setBounds(380 + insets.left, 230 + insets.top,
				buttonSize.width, buttonSize.height);
		
		Dimension answerSize = answerField.getPreferredSize();
		answerField.setBounds(300 + insets.left, 230 + insets.top,
				answerSize.width, buttonSize.height);

    	setVisible(true);

    }

	
	//init swing components
	public void initComponents()
	{
		answerField = new JTextField();
		answerField.setColumns(5);
  		submitButton = new JButton("Submit Answer");
  		submitButton.addActionListener(new submitButtonListener()); 
	}

	

	//inits the coords of the rects that user will move
	public void initSquares()
	{
		int startx = startXSquare;
		for (int i = 0; i < correctAnswer; i++)
		{
			square = new Rectangle(startx, startYSquare, squareUnit ,squareUnit);
			squareList.add(square);
			startx+=40;
		}
	}
  	
	//overriden paint method
    public void paint(Graphics g)
    {
    	super.paint(g);
    	
    	//draw title text
    	g.drawImage(controller.binDecImg, headerX, headerY, this);

    	//paint 13 rectangles
    	for (int i = 0;i < squareList.size(); i++){
			if (i%2 == 1)
			{
				g.setColor(Color.YELLOW);
			}
			else
			{
				g.setColor(Color.MAGENTA);
			}
			g.fillRect((int)squareList.get(i).getX(),(int)squareList.get(i).getY(), squareUnit, squareUnit );
		}
    	

    	//question text
    	g.setFont(new Font("Geneva",1,20));
    	g.setColor(Controller.textColor);
    	g.drawString(questionText, questionTextX, questionTextY);
    	
    }
    
    //checks whether user input is correct
    public boolean checkAnswer(String input)
    {
    	return correctAnswerString.equals(input);
    }
    
    //action listener for submit button
	class submitButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{			
			String input =  answerField.getText();
			inputAnswer = Integer.parseInt(input);
			
			//if correct answer load the next page
			if(checkAnswer(input))
			{
				controller.loadCard("BIN DEC PAGE 2");
			}
			else
			{
				//resets answer field
		    	String errorMessage = "Wrong answer, try again!";
		    	JOptionPane.showMessageDialog(controller, errorMessage, "wrong answer", JOptionPane.YES_NO_OPTION);
				
		    	answerField.setText("");
			}
		 
			
		} //end action performed
		
		
	} //end button listener

} //end class binary decimal one


