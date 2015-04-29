package Tutorial;

//this class is the third page in the binary to decimal tutorial


import java.awt.Graphics;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Rectangle;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.util.ArrayList;


@SuppressWarnings("serial")
public class BinaryDecimalThree extends JPanel implements MouseListener
{	
	Controller controller;

	boolean display1 = true;
	boolean display2 = false;
	boolean display3 = false;

	//13 in base 10 = 13
	final int BinToDecNumSquaresActual = 13;
	final String numTensActual = "1";
	final String numOnesActual = "3";
	String numTensInput;
	String numOnesInput;

	// The X-coordinate and Y-coordinate of the last click. 
	int mouseX; 
	int mouseY;

	// The coordinates of the 10's rectangle and 1s rectangle 
	final int box10x = 210, box10y = 300, box10width = 150, box10height = 210;
	final int box1x = 400, box1y = 300, box1width = 150, box1height = 210;	

	//flags for rectangle movement
	int rectSelectedNum = 0;
	boolean boxSelected10 = false;
	boolean boxSelected1 = false;
	boolean rectSelected = false;

	//rectangle data
	//width and height of sqare
	final int squareUnit = 30;
	private Rectangle square;
	ArrayList<Rectangle> squareList = new ArrayList<Rectangle>();
	final int startXSquare = 130;
	final int startYSquare = 240;

	//labels and text fields
	JButton submitButton;
	JTextField NumberTensField;
	JTextField NumberOnesField;

	final String text3 = "Do we have enough squares to put ten squares in the TENS box?";
	final String text4 = "If yes, put ten squares in the TENS box. Click on a red square and then"; 
	final String text45 = "click on the box to put the square inside.";
	final String text5 = "Since we had enough squares, type 1 below the TENS box.";
	final String text6 = "Check how many squares are left remaining. Do we have enough";
	final String text7 = "to put squares in the ONES box?";
	final String text8 = "Keep assigning the remaining squares until none are left.";
	final String text9 = "Type the number of squares you put in the ONES box.";
	final String text10 = "When you finish, click submit to check your answer.";

	final int submitButtonX = box1x +box1width + 20;
	final int submitButtonY = box1y+box1height+5;
	final int tensFieldX = box10x + 45;
	final int tensFieldY = box10y+box10height+5;
	final int onesFieldX = box1x + 45;
	final int onesFieldY = box1y+box1height+5;
	final int headerX = 90;
	final int headerY = 15;

	final int startTextX = 40;
	final int startTextY = 100;
	final int textYInc = 20;
	final int indentTextX = 30;

	public BinaryDecimalThree(Controller welcome)
	{
		controller = welcome;
		setBackground(Controller.backgroundColor);

		initComponents();
		addComponentsToPanel();
		formatComponents();
		setVisible(true);
	}


	//this method defines the formatting of the components on the panel
	public void formatComponents(){
		Insets insets = getInsets();
		Dimension buttonSize = submitButton.getPreferredSize();
		submitButton.setBounds(submitButtonX+ insets.left, submitButtonY + insets.top,
				buttonSize.width, buttonSize.height);

		Dimension fieldSize = NumberTensField.getPreferredSize();
		NumberTensField.setBounds(tensFieldX + insets.left, tensFieldY + insets.top,
				fieldSize.width, buttonSize.height);
		NumberOnesField.setBounds(onesFieldX + insets.left, onesFieldY + insets.top,
				fieldSize.width, buttonSize.height);
	}

	//init swing components
	public void initComponents(){
		initRects();
		initButton();
		initTextFields();
	}

	//this method adds the components to the panel
	public void addComponentsToPanel() {
		setLayout(null);
		add(submitButton);
		add(NumberTensField);
		add(NumberOnesField);
		addMouseListener(this);
	}

	public void initButton()
	{
		submitButton = new JButton("Submit");
		submitButton.addActionListener(new submitButtonListener());
	}

	//inits the coords of the rects that user will move
	public void initRects()
	{
		int startx = startXSquare;
		for (int i = 0; i < BinToDecNumSquaresActual; i++){
			square = new Rectangle(startx, startYSquare, squareUnit,squareUnit);
			squareList.add(square);
			startx+=40;
		}
	}


	public void initTextFields(){
		NumberTensField = new JTextField();
		NumberOnesField = new JTextField();
		NumberTensField.setColumns(5);
		NumberOnesField.setColumns(5);

		NumberTensField.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {}
			public void removeUpdate(DocumentEvent e) {}
			public void insertUpdate(DocumentEvent e) {
				display1 = false;
				display2 = true;
				display3 = false;
				repaint();
			}

		});

		NumberOnesField.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {}
			public void removeUpdate(DocumentEvent e) {}
			public void insertUpdate(DocumentEvent e) {
				display1 = false;
				display2 = false;
				display3 = true;
				repaint();
			}

		});


	} //end init text fields

//override paint method
	public void paint(Graphics g)
	{
		super.paint(g);



		//draw title text
		g.drawImage(controller.binDecImg, headerX, headerY, this);

		//draw boxes
		g.setColor(Color.black);
		if (boxSelected1)
			g.setColor(Color.RED);
		g.drawRect(box1x,box1y,box1width,box1height);
		g.setColor(Color.BLACK);
		if (boxSelected10)
			g.setColor(Color.RED);
		g.drawRect(box10x,box10y,box10width,box10height);

		//draw the movable squares
		g.setColor(Controller.buttonPanelColor);
		for (int i = 0;i < squareList.size(); i++)
		{
			g.fillRect((int)squareList.get(i).getX(),(int)squareList.get(i).getY(), squareUnit, squareUnit );
		}

		//box labels
		g.setColor(Controller.textColor);
		g.setFont(new Font("Verdana", 1, 20));
		g.drawString("TENS", box10x+45, box10y-4);
		g.drawString("ONES", box1x+45, box1y-4);

		//instructions
		g.setFont(new Font("Geneva", Font.BOLD, 18));
		if (display1){
			g.drawString(text3, startTextX, startTextY+textYInc);
			g.drawString(text4, startTextX+indentTextX, startTextY+2*textYInc);
			g.drawString(text45, startTextX+indentTextX, startTextY+3*textYInc);
			g.drawString(text5, startTextX, startTextY+4*textYInc);
		}
		if (display2){
			g.drawString(text6, startTextX, startTextY+textYInc);
			g.drawString(text7, startTextX+indentTextX, startTextY+2*textYInc);
			g.drawString(text8, startTextX, startTextY+3*textYInc);
			g.drawString(text9, startTextX, startTextY+4*textYInc);
		}
		if (display3){
			g.drawString(text10, startTextX, startTextY+4*textYInc);
		}

	}

	//action listener for submit button
	class submitButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			//get all text from text boxes, if correct then display dialog box
			//then go to new page

			numTensInput =  NumberTensField.getText();
			numOnesInput =  NumberOnesField.getText();		

			//second part of correct answer: determine 
			//whether correct number of squares are in each box
			int countTens = 0;
			int countOnes = 0;

			for(int i = 0; i < squareList.size(); i++)
			{
				int x = (int) squareList.get(i).getX();
				int y = (int) squareList.get(i).getY();


				if((x >= box10x) && (x <= (box10x + box10width)) && (y >= box10y) && (y <= (box10y + box10height)))
				{
					countTens++; //if the square is in the tens box, add 1
				}
				else if((x >= box1x) && (x <= (box1x + box1width)) && (y >= box1y) && (y <= (box1y + box1height)))
				{
					//if the square is in the ones box
					countOnes++;
				}
				else
				{
					//test
				}

			}



			if(numTensInput.equals(numTensActual)
					&& numOnesInput.equals(numOnesActual) && countTens == 10 && countOnes == 3)
			{
				String congratsMessage = "Good job!";
				JOptionPane.showMessageDialog(controller, congratsMessage, "good job", JOptionPane.YES_NO_OPTION);
				controller.loadCard("BIN DEC PAGE 4"); 
			}
			else
			{

				String errorMessage = "Wrong answer, try again!";
				JOptionPane.showMessageDialog(controller, errorMessage, "Wrong Answer", JOptionPane.YES_NO_OPTION);

				NumberTensField.setText("");
				NumberOnesField.setText("");

				int startx = startXSquare;
				int starty = startYSquare;
				display1 = true;
				display3 = false;

				for (int i = 0; i < squareList.size(); i++)
				{
					squareList.get(i).setLocation(startx, starty);
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
		mouseX = me.getX(); 
		mouseY = me.getY();


		//select one of the rectangles first
		for (int i = 0; i < squareList.size(); i++){
			int recx = (int) squareList.get(i).getX();
			int recy = (int) squareList.get(i).getY();
			if ((mouseX >= recx) && (mouseX <= (recx + squareUnit)) && (mouseY >= recy) && (mouseY <= (recy + squareUnit))){
				rectSelected = true;
				rectSelectedNum = i;
				break;
			} 


		}

		if(rectSelected)
		{
			if((mouseX >= box10x) && (mouseX <= (box10x + box10width)) && (mouseY >= box10y) && (mouseY <= (box10y + box10height)))
			{
				boxSelected10 = true;
				boxSelected1 = false;
				squareList.get(rectSelectedNum).setLocation(me.getX(), me.getY());

			}
			else if((mouseX >= box1x) && (mouseX <= (box1x + box1width)) && (mouseY >= box1y) && (mouseY <= (box1y + box1height)))
			{
				boxSelected1 = true;
				boxSelected10 = false;
				squareList.get(rectSelectedNum).setLocation(me.getX(), me.getY());

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


