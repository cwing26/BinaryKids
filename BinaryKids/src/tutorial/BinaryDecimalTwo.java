package tutorial;


import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import java.awt.*; 
import java.applet.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Insets;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Image;
import java.awt.TextField;
import java.awt.Toolkit;
import java.util.ArrayList;



public class BinaryDecimalTwo extends JPanel implements MouseListener
{	
	WelcomePage welcomePage;

	//Labels
	JLabel DecToBinNumSquaresText;
	JLabel DecToBinNumSquaresText2;
	JLabel DecToBinNumSquaresText3;
	JLabel TextEights;
	JLabel TextFours;
	JLabel TextTwos;
	JLabel TextOnes;
	JLabel TextHowManyEights;
	JLabel TextHowManyFours;
	JLabel TextHowManyTwos;
	JLabel TextHowManyOnes;

	//Panels
	JPanel titlePanel;
	JPanel textPanel;
	JPanel questionPanel;
	JPanel boxLabelPanel;

	//my panels--hope grid layout
	JPanel labelPanel; //for the 8, 4, 2, 1
	JPanel answerPanel; //for the textboxes

	//text fields
	JTextField answerField2;
	JTextField answerField3;
	JTextField answerField4;
	JTextField answerField5;

	//button to submit answer
	JButton submitButton;


	//13 in binary is 01101
	final int BinToDecNumSquaresActual = 13;
	final String answer2 = "1";
	final String answer3 = "1";
	final String answer4 = "0";
	final String answer5 = "1";

	final String answerTwo = "1";
	final String answerThree = "0";
	final String answerFour = "1";
	final String answerFive = "1";

	//int version user answer
	String userAnswer2;
	String userAnswer3;
	String userAnswer4;
	String userAnswer5;

	//string version user answer
	String numEightsInput;
	String numFoursInput;
	String numTwosInput;
	String numOnesInput;

	// The coordinates of the 10's rectangle and 1s rectangle 
	int box8x, box8y, box8width, box8height;
	int box4x, box4y, box4width, box4height;
	int box2x, box2y, box2width, box2height;
	int box1x, box1y, box1width, box1height;


	// The X-coordinate and Y-coordinate of the last click. 
	int xpos; 
	int ypos;

	// variable that will be true when the user clicked i the rectangle  
	// the we will draw. 

	boolean clickOrMove = true;
	boolean boxSelected16 = false;
	boolean boxSelected8 = false;
	boolean boxSelected4 = false;
	boolean boxSelected2 = false;
	boolean boxSelected1 = false;

	boolean rectSelected = false;
	int rectSelectedNum = 0;

	//rectangles
	final int rectUnit = 25;
	final int startx = 60;
	final int starty = 550;
	private Rectangle rec;
	ArrayList<Rectangle> recList = new ArrayList<Rectangle>();



	public BinaryDecimalTwo(WelcomePage welcome)
	{
		welcomePage = welcome;

		initJLabels();
		initTextFields();
		initTitlePanel();
		initRects();
		initTextFields();
		initTextPanel();
		initButton();
		initBoxLabelPanel();
		initBoxCoords();
		initQuestionPanel();

		//add panels
		add(titlePanel);
		add(textPanel);
		add(questionPanel);
		add(boxLabelPanel);


		addMouseListener(this); //adds mouse listener to listen for clicks on objects

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

	//inits format of text field
	public void initTextFields()
	{
		answerField2 = new JTextField();
		answerField3 = new JTextField();
		answerField4 = new JTextField();
		answerField5 = new JTextField();
		answerField2.setColumns(3);
		answerField3.setColumns(3);
		answerField4.setColumns(3);
		answerField5.setColumns(3);

		//answerField2.setFont(new Font("Verdana", 1, 45));
		//answerField3.setFont(new Font("Verdana", 1, 45));
		//answerField4.setFont(new Font("Verdana", 1, 45));
		//answerField5.setFont(new Font("Verdana", 1, 45));
	}

	//inits the coords of the rects that user will move
	public void initRects()
	{
		int startX = startx;
		for (int i = 0; i < BinToDecNumSquaresActual; i++)
		{
			rec = new Rectangle(startX, starty, rectUnit,rectUnit);
			recList.add(rec);
			startX+=40;
		}
	}

	public void initButton()
	{
		submitButton = new JButton("Submit Answer");
		submitButton.addActionListener(new submitButtonListener());
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


	//sets all the texts of all Jlabels
	public void initJLabels(){
		TextEights = new JLabel("Eights");
		TextFours = new JLabel("Fours");
		TextTwos = new JLabel("Twos");
		TextOnes = new JLabel("Ones");
		TextHowManyEights = new JLabel("How many EIGHTS are there in 13?");
		TextHowManyFours = new JLabel("How many FOURS are there in 13?");
		TextHowManyTwos = new JLabel("How many TWOS are there in 13?");
		TextHowManyOnes = new JLabel("How many ONES are there in 13?");
		DecToBinNumSquaresText = new JLabel("Now let's see visually how to represent 13 in binary (base 2)! Click on a square and then click ");
		DecToBinNumSquaresText2 = new JLabel("inside one of the boxes to assign the square to the box. Distribute squares to the largest box");
		DecToBinNumSquaresText3 = new JLabel("possible, starting from the left.");
	}

	//formats the labels for the boxes
	public void initBoxLabelPanel()
	{
		boxLabelPanel = new JPanel();
		boxLabelPanel.setLayout(new GridBagLayout());
		GridBagConstraints c3 = new GridBagConstraints();
		c3.anchor = GridBagConstraints.FIRST_LINE_START;
		c3.insets = new Insets(0,40,0,0);
		c3.fill = GridBagConstraints.HORIZONTAL;
		c3.ipadx = 60;
		boxLabelPanel.add(TextEights,c3);
		boxLabelPanel.add(TextFours,c3);
		boxLabelPanel.add(TextTwos,c3);
		boxLabelPanel.add(TextOnes,c3);

		/*
    	JPanel tablePanel = new JPanel(new GridLayout(1, 6));
    	JLabel blank1 = new JLabel(" ");
    	blank1.setFont(new Font("Verdana", 1, 40));
    	JLabel blank2 = new JLabel(" ");
    	blank2.setFont(new Font("Verdana", 1, 40));
    	JLabel eights = new JLabel("8");
    	eights.setFont(new Font("Verdana", 1, 40));
    	JLabel fours = new JLabel("4");
    	fours.setFont(new Font("Verdana", 1, 40));
    	JLabel twos = new JLabel("2");
    	twos.setFont(new Font("Verdana", 1, 40));
    	JLabel ones = new JLabel("1");
    	ones.setFont(new Font("Verdana", 1, 40));


    	tablePanel.setBorder(new LineBorder(Color.BLACK)); 
    	tablePanel.add(blank1);
    	tablePanel.add(eights);
    	tablePanel.add(fours);
    	tablePanel.add(twos);
    	tablePanel.add(ones);
    	tablePanel.add(blank2);
		 */


	}

	//init the coords of the boxes will move rects into
	public void initBoxCoords()
	{
		// Assign values to the rectanagle coordinates. 
		box8x = 160; 
		box8y = 210; 
		box8width= 120; 
		box8height = 300;

		// Assign values to the rectanagle coordinates. 
		box4x = 300; 
		box4y = 210; 
		box4width= 120; 
		box4height = 300;

		// Assign values to the rectanagle coordinates. 
		box2x = 440; 
		box2y = 210; 
		box2width= 120; 
		box2height = 300;

		// Assign values to the rectanagle coordinates. 
		box1x = 580; 
		box1y = 210; 
		box1width= 120; 
		box1height = 300;

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
		questionPanel.add(TextHowManyEights, c2);
		c2.gridx = 1;
		c2.gridy = 0;
		questionPanel.add(answerField2, c2);
		c2.gridx = 2;
		c2.gridy = 0;
		questionPanel.add(TextHowManyFours, c2);
		c2.gridx = 3;
		c2.gridy = 0;
		questionPanel.add(answerField3, c2);
		c2.gridx = 0;
		c2.gridy = 1;
		questionPanel.add(TextHowManyTwos, c2);
		c2.gridx = 1;
		c2.gridy = 1;
		questionPanel.add(answerField4, c2);
		c2.gridx = 2;
		c2.gridy = 1;
		questionPanel.add(TextHowManyOnes, c2);
		c2.gridx = 3;
		c2.gridy = 1;
		questionPanel.add(answerField5, c2);
		c2.gridx = 0;
		c2.gridy = 2;
		c2.gridwidth = 4;
		questionPanel.add(submitButton, c2);
	}

	public void paint(Graphics g)
	{
		super.paint(g);
		g.setColor(Color.black);
		if (boxSelected1)
			g.setColor(Color.RED);
		g.drawRect(box1x,box1y,box1width,box1height);
		g.setColor(Color.BLACK);

		if (boxSelected2)
			g.setColor(Color.RED);
		g.drawRect(box2x,box2y,box2width,box2height);
		g.setColor(Color.BLACK);

		if (boxSelected4)
			g.setColor(Color.RED);
		g.drawRect(box4x,box4y,box4width,box4height);
		g.setColor(Color.BLACK);

		if (boxSelected8)
			g.setColor(Color.RED);
		g.drawRect(box8x,box8y,box8width,box8height);
		g.setColor(Color.BLACK);


		g.setColor(Color.blue);

		for (int i = 0;i < recList.size(); i++){
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
			userAnswer4 =  answerField4.getText();
			userAnswer5 =  answerField5.getText();


			int countEights = 0;
			int countFours = 0;
			int countTwos = 0;
			int countOnes = 0;

			for(int i = 0; i < recList.size(); i++)
			{
				int x = (int) recList.get(i).getX();
				int y = (int) recList.get(i).getY();


				if((x >= box8x) && (x <= (box8x + box8width)) && (y >= box8y) && (y <= (box8y + box8height)))
				{
					countEights++; //if the rect is in the eights box, add 1
				}
				else if((x >= box4x) && (x <= (box4x + box4width)) && (y >= box4y) && (y <= (box4y + box4height)))
				{
					//if the rect is in the fours box
					countFours++;
				}
				else if((x >= box2x) && (x <= (box2x + box2width)) && (y >= box2y) && (y <= (box2y + box2height)))
				{
					//if the rect is in the twos box
					countTwos++;
				}
				else if((x >= box1x) && (x <= (box1x + box1width)) && (y >= box1y) && (y <= (box1y + box1height)))
				{
					//if the rect is in the ones box
					countOnes++;
				}
				else
				{

				}

			}


			if(userAnswer2.equals(answer2)
					&& userAnswer3.equals(answer3)
					&& userAnswer4.equals(answer4)
					&& userAnswer5.equals(answer5)
					&& countEights == 8
					&& countFours == 4
					&& countTwos == 0
					&& countOnes == 1)
			{

				welcomePage.loadBinToDec3();

				welcomePage.validate();
				welcomePage.setVisible(true);
				welcomePage.repaint();
			}
			else
			{
				//dialog box welcomes user to game and gives them brief instructions
				String errorMessage = "Wrong answer, try again!";
				JOptionPane.showMessageDialog(welcomePage, errorMessage, "worng answer", JOptionPane.YES_NO_OPTION);

				answerField2.setText("");
				answerField3.setText("");
				answerField4.setText("");
				answerField5.setText("");

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

			if((xpos >= box8x) && (xpos <= (box8x + box8width)) && (ypos >= box8y) && (ypos <= (box8y + box8height)))
			{
				boxSelected8 = true;
				boxSelected4 = false;
				boxSelected2 = false;
				boxSelected1 = false;
				recList.get(rectSelectedNum).setLocation(me.getX(), me.getY());

			}
			else if((xpos >= box4x) && (xpos <= (box4x + box4width)) && (ypos >= box4y) && (ypos <= (box4y + box4height)))
			{
				boxSelected4 = true;
				boxSelected8 = false;
				boxSelected2 = false;
				boxSelected1 = false;
				recList.get(rectSelectedNum).setLocation(me.getX(), me.getY());

			}
			else if((xpos >= box2x) && (xpos <= (box2x + box2width)) && (ypos >= box2y) && (ypos <= (box2y + box2height)))
			{
				boxSelected2 = true;
				boxSelected4 = false;
				boxSelected8 = false;
				boxSelected1 = false;
				recList.get(rectSelectedNum).setLocation(me.getX(), me.getY());

			}
			else if((xpos >= box1x) && (xpos <= (box1x + box1width)) && (ypos >= box1y) && (ypos <= (box1y + box1height)))
			{
				boxSelected1 = true;
				boxSelected4 = false;
				boxSelected2 = false;
				boxSelected8 = false;
				recList.get(rectSelectedNum).setLocation(me.getX(), me.getY());

			}
			else {

			}

		}




		//show the results of the click 
		repaint();

	} //end mouse click listener


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


