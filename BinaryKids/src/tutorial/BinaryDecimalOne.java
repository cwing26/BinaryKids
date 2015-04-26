package tutorial;


import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Rectangle;
import java.util.ArrayList;



@SuppressWarnings("serial")
public class BinaryDecimalOne extends JPanel
{	
	WelcomePage welcomePage; //to connect with the applet

	JPanel titlePanel;
	JPanel textPanel;
	JLabel questionLabel;
	JButton submitButton;
	JTextField answerField;

	final int correctAnswer = 13;
	final String correctAnswerString = "13";
	int inputAnswer = 0;
	
	int startx = 180;
	int starty = 100;

	final int rectUnit = 25;
	
	private Rectangle rec;
	ArrayList<Rectangle> recList = new ArrayList<Rectangle>();

    
    public BinaryDecimalOne(WelcomePage welcome)
    {
    	welcomePage = welcome;
    
    	initComponents();
    	initSubmitButton();
    	initTitlePanel();
    	initTextPanel();
    	initRects();
    	
    	add(titlePanel);
    	add(textPanel);

    	
    	setVisible(true);

    }
    
  //adds an action listener to the submit button to verify input is correct
  	public void initSubmitButton()
  	{
  		submitButton = new JButton("Submit Answer");
  		submitButton.addActionListener(new submitButtonListener()); 
  	}




	//init title panel format
	public void initTitlePanel()
	{
		titlePanel = new JPanel();
		titlePanel.setLayout(new BorderLayout());
		JLabel titleLabel = new JLabel("Let's learn how to convert binary to decimal!");
		titleLabel.setFont(new Font("Verdana",1,20));
		titlePanel.add(titleLabel, BorderLayout.CENTER);
		titlePanel.setBorder(new LineBorder(Color.BLACK));
	}
	
	//init swing components
	public void initComponents()
	{
		questionLabel = new JLabel("How many squares are shown?");
		answerField = new JTextField();
		answerField.setColumns(5);
	}

	//formats the text panel layout
	public void initTextPanel()
	{
		textPanel = new JPanel();
		textPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 50;
		c.gridx = 0;
		c.gridy = 0;
		textPanel.add(questionLabel, c);
		c.gridx = 1;
		c.gridy = 0;
		textPanel.add(answerField);
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		textPanel.add(submitButton);
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
				
				welcomePage.validate();
		        welcomePage.setVisible(true);
		        welcomePage.repaint();
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


