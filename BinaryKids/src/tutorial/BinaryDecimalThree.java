package tutorial;


import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.border.LineBorder;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.util.ArrayList;



@SuppressWarnings("serial")
public class BinaryDecimalThree extends JPanel implements MouseListener
{	
	WelcomePage welcomePage;
	
	//13 in base 10 = 13
	final int BinToDecNumSquaresActual = 13;
	final String answer2 = "1";
	final String answer3 = "3";
	String userAnswer1;
	String userAnswer2;
	String userAnswer3;
	
	// The X-coordinate and Y-coordinate of the last click. 
	int xpos; 
	int ypos;
	
	// The coordinates of the 10's rectangle and 1s rectangle 
	int box10x, box10y, box10width, box10height;
	int box1x, box1y, box1width, box1height;
		
	//flags for rectangle movement
	int rectSelectedNum = 0;
	boolean boxSelected10 = false;
	boolean boxSelected1 = false;
	boolean rectSelected = false;

	//rectangle data
	final int rectUnit = 25;
	private Rectangle rec;
	ArrayList<Rectangle> recList = new ArrayList<Rectangle>();
	final int startx = 60;
	final int starty = 550;

	//labels and text fields
	JButton submitButton;
	JTextField answerField2;
	JTextField answerField3;

	//labels
	JLabel DecToBinNumSquaresText;
	JLabel DecToBinNumSquaresText2;
	JLabel DecToBinNumSquaresText3;
	JLabel DecToBinNumSquaresText4;
	JLabel DecToBinNumSquaresText5;
	JLabel TextTens;
	JLabel TextOnes;
	JLabel TextHowManyTens;
	JLabel TextHowManyOnes;

	//Panels
	JPanel titlePanel;
	JPanel textPanel;
	JPanel questionPanel;
	JPanel boxLabelPanel;
	
    
    public BinaryDecimalThree(WelcomePage welcome)
    {
    	welcomePage = welcome;

    	initRects();
    	initButton();
    	initTitlePanel();
    	initBoxCoords();
    	initJLabels();
    	initTextFields();
    	initTextPanel();
    	initBoxLabelPanel();
    	initQuestionPanel();

    	
    	add(titlePanel);
    	add(textPanel);
    	add(questionPanel);
    	add(boxLabelPanel);


    	addMouseListener(this); 
    	
    	setVisible(true);

    }
    
    
	//formats the title panel
	public void initTitlePanel()
	{
		titlePanel = new JPanel();
		titlePanel.setLayout(new BorderLayout());
		JLabel titleLabel = new JLabel("Converting Binary to Decimal");
		titleLabel.setFont(new Font("Verdana",1,20));
		titlePanel.add(titleLabel, BorderLayout.CENTER);
		titlePanel.setBorder(new LineBorder(Color.BLACK));
	}
	
	public void initButton()
	{
		submitButton = new JButton("Submit Answer");
		submitButton.addActionListener(new submitButtonListener());
	}
	
	//inits the coords of the rects that user will move
	public void initRects()
	{
		int startX = startx;
		for (int i = 0; i < BinToDecNumSquaresActual; i++){
			rec = new Rectangle(startX, starty, rectUnit,rectUnit);
			recList.add(rec);
			startX+=40;
		}
	}
    
	public void initBoxCoords()
	{
		box10x = 210; 
		box10y = 240; 
		box10width = 150; 
		box10height = 300;

		box1x = 400; 
		box1y = 240; 
		box1width= 150; 
		box1height = 300;	
	}
    

	public void initJLabels(){
		TextTens = new JLabel("Tens");
		TextOnes = new JLabel("Ones");
		TextHowManyTens = new JLabel("How many TENS are there in 13?");
		TextHowManyOnes = new JLabel("How many ONES are there in 13?");
		DecToBinNumSquaresText = new JLabel("                  How do we get the number 13? 13 = how many tens + how many ones?");
		DecToBinNumSquaresText2 = new JLabel("Click on a square and then click in one of the boxes to assign the square to the box. Distribute");
		DecToBinNumSquaresText3 = new JLabel("squares to the largest box possible, starting from the left.");
	}

	public void initTextFields(){
		answerField2 = new JTextField();
		answerField3 = new JTextField();
		answerField2.setColumns(5);
		answerField3.setColumns(5);
	}

	//formats the text panel layout
	public void initTextPanel(){
		textPanel = new JPanel();
		textPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.CENTER;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipadx = 20;
		c.gridx = 0;
		c.gridy = 0;
		textPanel.add(DecToBinNumSquaresText, c);
		c.gridy = 1;
		textPanel.add(DecToBinNumSquaresText2, c);
		c.gridy = 2;
		textPanel.add(DecToBinNumSquaresText3, c);
		
	}

	//formats the question panel layout
	public void initQuestionPanel(){
		questionPanel = new JPanel();
		questionPanel.setLayout(new GridBagLayout());
		GridBagConstraints c2 = new GridBagConstraints();
		c2.anchor = GridBagConstraints.CENTER;
		c2.fill = GridBagConstraints.HORIZONTAL;
		c2.ipadx = 20;
		c2.gridx = 0;
		c2.gridy = 0;
		questionPanel.add(TextHowManyTens, c2);
		c2.gridx = 1;
		c2.gridy = 0;
		questionPanel.add(answerField2, c2);
		c2.gridx = 2;
		c2.gridy = 0;
		questionPanel.add(TextHowManyOnes, c2);
		c2.gridx = 3;
		c2.gridy = 0;
		questionPanel.add(answerField3, c2);
		c2.gridx = 0;
		c2.gridy = 1;
		c2.gridwidth = 4;
		questionPanel.add(submitButton, c2);

	}


	//formats the labels for the boxes
	public void initBoxLabelPanel(){
		boxLabelPanel = new JPanel();
		boxLabelPanel.setLayout(new GridBagLayout());
		GridBagConstraints c3 = new GridBagConstraints();
		c3.anchor = GridBagConstraints.FIRST_LINE_START;
		c3.insets = new Insets(50,40,0,0);
		c3.fill = GridBagConstraints.HORIZONTAL;
		c3.ipadx = 100;
		boxLabelPanel.add(TextTens,c3);
		boxLabelPanel.add(TextOnes,c3);

	}

    
    public void paint(Graphics g)
    {
    	super.paint(g);
    	g.setColor(Color.black);
    	if (boxSelected1)
			g.setColor(Color.RED);
		g.drawRect(box1x,box1y,box1width,box1height);
		g.setColor(Color.BLACK);
		if (boxSelected10)
			g.setColor(Color.RED);
		g.drawRect(box10x,box10y,box10width,box10height);
    	
    	g.setColor(Color.blue);
    	

    	//Graphics2D g2d = (Graphics2D) g.create();
    	for (int i = 0;i < recList.size(); i++)
    	{
    		g.fillRect((int)recList.get(i).getX(),(int)recList.get(i).getY(), rectUnit, rectUnit );
    	}
    	
    }
    
	class submitButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			//get all text from text boxes, if correct then display dialog box
			//then go to new page

			userAnswer2 =  answerField2.getText();
			userAnswer3 =  answerField3.getText();		
			
			//second part of correct answer: determine 
			//whether correct number of rects are in each box
			int countTens = 0;
			int countOnes = 0;
			
			for(int i = 0; i < recList.size(); i++)
			{
				int x = (int) recList.get(i).getX();
				int y = (int) recList.get(i).getY();
				

				if((x >= box10x) && (x <= (box10x + box10width)) && (y >= box10y) && (y <= (box10y + box10height)))
				{
					countTens++; //if the rect is in the tens box, add 1
				}
				else if((x >= box1x) && (x <= (box1x + box1width)) && (y >= box1y) && (y <= (box1y + box1height)))
				{
					//if the rect is in the ones box
					countOnes++;
				}
				else
				{
					//test
				}
				
			}
			

			
			/*
			if(input2.equals(answerTwo)
					&& input3.equals(answerThree) && countTens == 10 && countOnes == 3)
			*/
			if(userAnswer2.equals(answer2)
					&& userAnswer3.equals(answer3) && countTens == 10 && countOnes == 3)
			{
				String congratsMessage = "Good job!";
		    	JOptionPane.showMessageDialog(welcomePage, congratsMessage, "good job", JOptionPane.YES_NO_OPTION);
		    	welcomePage.loadBinToDec4(); 
			}
			else
			{
				//dialog box welcomes user to game and gives them brief instructions
		    	String errorMessage = "Wrong answer, try again!";
		    	JOptionPane.showMessageDialog(welcomePage, errorMessage, "worng answer", JOptionPane.YES_NO_OPTION);
		    	
		    	answerField2.setText("");
		    	answerField3.setText("");
		    	
				int startx = 60;
				int starty = 600;
				
				for (int i = 0; i < recList.size(); i++)
				{
					recList.get(i).setLocation(startx, starty);
					startx+=40;
				}
				repaint();

			}


			
		} //end action performed
		
		
	} //end button listener
	
	
	
	/* These methods always have to present when you implement MouseListener
	
	 public void mouseClicked (MouseEvent me) {} 
	 public void mouseEntered (MouseEvent me) {} 
	 public void mousePressed (MouseEvent me) {} 
	 public void mouseReleased (MouseEvent me) {}  
	 public void mouseExited (MouseEvent me) {}  
	*/
	
	 // This method will be called when the mouse has been clicked. 
	 public void mouseClicked (MouseEvent me) 
	 {
		// Save the coordinates of the click lke this.
			xpos = me.getX(); 
			ypos = me.getY();


			//select one of the rectangles first
			for (int i = 0; i < recList.size(); i++){
				int recx = (int) recList.get(i).getX();
				int recy = (int) recList.get(i).getY();
				if ((xpos >= recx) && (xpos <= (recx + rectUnit)) && (ypos >= recy) && (ypos <= (recy + rectUnit))){
					rectSelected = true;
					rectSelectedNum = i;
					break;
				} 
				

			}
			
			if(rectSelected)
			{
				if((xpos >= box10x) && (xpos <= (box10x + box10width)) && (ypos >= box10y) && (ypos <= (box10y + box10height)))
				{
					boxSelected10 = true;
					boxSelected1 = false;
					recList.get(rectSelectedNum).setLocation(me.getX(), me.getY());
					//imgList.get(rectSelectedNum).
					
				}
				else if((xpos >= box1x) && (xpos <= (box1x + box1width)) && (ypos >= box1y) && (ypos <= (box1y + box1height)))
				{
					boxSelected1 = true;
					boxSelected10 = false;
					recList.get(rectSelectedNum).setLocation(me.getX(), me.getY());
					
				}
				else {
					
				}

			}




			//show the results of the click 
			repaint();
		 
	 }
	
	
	 // When it has been released 
	 // note that a click also calls these Mouse-Pressed and Released. 
	 // since they are empty nothing hapens here. 
	 public void mouseReleased (MouseEvent me) {} 
	 
	 // This is called when the mous has been pressed 
	 public void mousePressed (MouseEvent me) {}
	
	 // This is executed when the mouse enters the applet. it will only 
	 // be executed again when the mouse has left and then re-entered. 
	 public void mouseEntered (MouseEvent me) {}
	
	 // When the Mouse leaves the applet. 
	 public void mouseExited (MouseEvent me) {} 

} //end class thirdpage


