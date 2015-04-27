package tutorial;


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
	WelcomePage welcomePage;

	String questionText = "How many squares are shown?";
	JButton submitButton;
	JTextField answerField;

	final int correctAnswer = 13;
	final String correctAnswerString = "13";
	int inputAnswer = 0;
	
	int startx = 150;
	int starty = 100;

	final int rectUnit = 25;
	
	private Rectangle rec;
	ArrayList<Rectangle> recList = new ArrayList<Rectangle>();

    //constructor
    public BinaryDecimalOne(WelcomePage welcome)
    {
    	welcomePage = welcome;
    	setBackground(WelcomePage.backgroundColor);
    	setLayout(null);
		Insets insets = getInsets();
		
    	initComponents();
    	initRects();
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
	public void initRects()
	{
		for (int i = 0; i < correctAnswer; i++)
		{
			rec = new Rectangle(startx, starty, rectUnit,rectUnit);
			recList.add(rec);
			startx+=40;
		}
	}
  	
    public void paint(Graphics g)
    {
    	super.paint(g);
    	
    	//draw title text
    	g.drawImage(welcomePage.binDecImg, 90, 15, this);

    	//paint 13 rectangles
    	for (int i = 0;i < recList.size(); i++){
			if (i%2 == 1)
			{
				g.setColor(Color.YELLOW);
			}
			else
			{
				g.setColor(Color.MAGENTA);
			}
			g.fillRect((int)recList.get(i).getX(),(int)recList.get(i).getY(), rectUnit, rectUnit );
		}
    	
    	//question text
    	g.setFont(new Font("Geneva",1,20));
    	g.setColor(WelcomePage.textColor);
    	g.drawString(questionText, 250, 200);
    	
    }
    
	class submitButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{			
			String input =  answerField.getText();
			inputAnswer = Integer.parseInt(input);
			

			if(inputAnswer == correctAnswer)
			{
				welcomePage.loadBinToDec2();
			}
			else
			{
				//dialog box welcomes user to game and gives them brief instructions
		    	String errorMessage = "Wrong answer, try again!";
		    	JOptionPane.showMessageDialog(welcomePage, errorMessage, "wrong answer", JOptionPane.YES_NO_OPTION);
				
		    	answerField.setText("");
			}
			
			
			//check if answer is right before allowing to proceed to next page
			//if not, then reset text of textfield and say try again, maybe display diaglog box 
			
		} //end action performed
		
		
	} //end button listener

} //end class binary decimal one


