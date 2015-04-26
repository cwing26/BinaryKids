package tutorial;

//http://stackoverflow.com/questions/3953208/value-change-listener-to-jtextfield
//refered above link for listeners to text field

import java.awt.*; 
import java.awt.event.*; 
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.LineBorder;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

@SuppressWarnings("serial")
public class DecToBinPage2 extends JPanel implements ActionListener 
{

	boolean submitClicked = false;
	private Timer timer;
	private int DELAY = 2000;

	WelcomePage welcomePage;
	JButton submitButton; 
	JButton startButton;
	String DecToBinNumSquaresText = "How do we get the number 11? 11 = how many tens + how many ones? We will put the 11 squares in the TENS and ONES";
	String DecToBinNumSquaresText2 = "boxes to practice our understanding of the base 10, or decimal, number system. We will do this first example together";
	String DecToBinNumSquaresText3 = "and then let you try! Click the start button to begin.";
	JTextField NumberTensField;
	JTextField NumberOnesField;

	final int DecToBinNumSquaresActual = 11;
	int DecToBinNumSquaresInput;

	String numTensInput;
	String numOnesInput;
	final String numTensActual = "1";
	final String numOnesActual = "1";

	// The X-coordinate and Y-coordinate of the last click. 
	int xpos; 
	int ypos;

	// The coordinates of the 10's rectangle and 1s rectangle 
	final int box10x = 210, box10y = 300, box10width = 150, box10height = 210;
	final int box1x = 400, box1y = 300, box1width = 150, box1height = 210;	

	//flags to see which box and squares selected
	boolean boxSelected10 = false;
	boolean boxSelected1 = false;
	boolean rectSelected = false;
	int rectSelectedNum = 0;

	//width and height of sqare
	final int rectUnit = 30;
	//starting location to draw squares
	final int startx = 180;
	final int starty = 240;
	//coordinate list for the squares
	ArrayList<Integer> xCoordList =  new ArrayList<Integer>();
	ArrayList<Integer> yCoordList =  new ArrayList<Integer>();

	private Rectangle rec;
	ArrayList<Rectangle> recList = new ArrayList<Rectangle>();

	int globalI = 0;

	String text3 = "Step 1: Do we have enough squares to put ten squares in the TENS box? Since we do; let's put ten red squares in the TENS box.";
	String text4 = ""; //           Click on a red square and then click on the box to put the square inside.
	String text5 = "Step 2: Since we had enough squares, type 1 below the TENS box.";
	String text6 = "Step 3: Check how many squares are left remaining. Do we have enough to put one square in the ONES box?";
	String text7 = "Step 4: We have enough! Let's move the square to the ONES box.";
	String text8 = "Step 5: Since we had enough squares, type 1 below the ONES box.";
	String text9 = "Step 6: Since there are no squares left we are all done!";
	String text10 = "Step 7: When you finish, click submit to check your answer.";

	boolean displayStep1= false;
	boolean displayStep2= false;
	boolean displayStep3= false;
	boolean displayStep4= false;
	boolean displayStep7= false;


	boolean number10correct = false;
	boolean number1correct = false;

	public void moveTens(){
		recList.get(globalI).setLocation(xCoordList.get(globalI), yCoordList.get(globalI));
		globalI++;
	}
	public void moveOnes(){
		recList.get(globalI).setLocation(xCoordList.get(globalI), yCoordList.get(globalI));
		globalI++;
		timer.stop();
	}

	boolean displayedStep2 = false;
	boolean displayedStep3 = false;

	@Override
	public void actionPerformed(ActionEvent e) {

		if (globalI < 10){
			moveTens();
		}
		if (globalI == 10 && displayedStep2 == false){
			displayStep1 = false;
			displayStep2 = true;
		}
		if (displayStep3){
			moveOnes();
		}

		if (displayStep7){
			timer.stop();
		}
		validate();
		repaint();

	}



	//inits the coords of the rects that user will move
	public void initRects(){
		//starting locations
		int startX = startx;
		for (int i = 0; i < DecToBinNumSquaresActual; i++){
			rec = new Rectangle(startX, starty, rectUnit,rectUnit);
			recList.add(rec);
			startX+=40;
		}

		//locations to move during animations
		int y = box10y+10;
		for (int i = 0; i < 5; i++){
			xCoordList.add(220);
			yCoordList.add(y);
			y = y + 10 + rectUnit;
		}
		y=box10y+10;
		for (int i = 0; i < 5; i++){
			xCoordList.add(260);
			yCoordList.add(y);
			y = y + 10 + rectUnit;
		}
		xCoordList.add(box1x+10);
		yCoordList.add(box1y+10);

	}


	class submitButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent le) {  
			numTensInput = NumberTensField.getText();
			numOnesInput = NumberOnesField.getText();

			if (numTensInput.equals(numTensActual) && numOnesInput.equals(numOnesActual)){
				submitClicked = true;
				remove(submitButton);
				remove(startButton);
				remove(NumberTensField);
				remove(NumberOnesField);
				welcomePage.loadDecBin3();
			}
			else{
				String errorMessage = "Wrong answer, try again!";
				JOptionPane.showMessageDialog(welcomePage, errorMessage, "wrong answer", JOptionPane.YES_NO_OPTION);

				NumberTensField.setText("");
				NumberOnesField.setText("");
			}

		} 
	}

	class startButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent le) {  
			startButton.setVisible(false);
			timer.start();
			displayStep1 = true;
		} 
	}


	public void initTextFields(){
		NumberTensField = new JTextField();
		NumberOnesField = new JTextField();
		NumberTensField.setColumns(5);
		NumberOnesField.setColumns(5);
		NumberTensField.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				warn();
			}
			public void removeUpdate(DocumentEvent e) {
				warn();
			}
			public void insertUpdate(DocumentEvent e) {
				warn();
			}

			public void warn() {
				if (!NumberTensField.getText().equals("1")){
					JOptionPane.showMessageDialog(null,
							"Error: Please enter 1", "Error Messege",
							JOptionPane.ERROR_MESSAGE);
				}
				else{
					number10correct = true;
					displayStep1 = false;
					displayStep2 = false;
					displayedStep2 = true;
					displayStep3 = true;
					repaint();
				}
			}
		});
		NumberOnesField.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {
				warn();
			}
			public void removeUpdate(DocumentEvent e) {
				warn();
			}
			public void insertUpdate(DocumentEvent e) {
				warn();
			}

			public void warn() {
				if (!NumberOnesField.getText().equals("1")){
					JOptionPane.showMessageDialog(null,
							"Error: Please enter 1", "Error Messege",
							JOptionPane.ERROR_MESSAGE);
				}
				else{
					number1correct = true;
					displayStep3 = false;
					displayedStep3 = true;
					displayStep7 = true;
					repaint();
				}
			}
		});

	}



	public void initButtons(){
		submitButton = new JButton("Submit"); 
		submitButton.addActionListener(new submitButtonListener());
		startButton = new JButton("Start Example");
		startButton.addActionListener(new startButtonListener());
	}

	//constructor, param is the applet
	public DecToBinPage2(WelcomePage welcome)
	{
		timer = new Timer(DELAY, this);
		welcomePage = welcome;
		setBackground(WelcomePage.backgroundColor);

		//initializations
		initButtons();
		initTextFields();
		initRects();

		setLayout(null);
		Insets insets = getInsets();

		//add(titlePanel);
		add(submitButton);
		add(startButton);
		add(NumberTensField);
		add(NumberOnesField);

		Dimension fieldSize = NumberTensField.getPreferredSize();
		NumberTensField.setBounds(box10x +45 + insets.left, box10y+box10height+5 + insets.top,
				fieldSize.width, fieldSize.height);
		NumberOnesField.setBounds(box1x +45 + insets.left, box1y+box1height+5 + insets.top,
				fieldSize.width, fieldSize.height);

		Dimension buttonSize = submitButton.getPreferredSize();
		submitButton.setBounds(box1x +box1width + 20 + insets.left, box1y+box1height+5 + insets.top,
				buttonSize.width, buttonSize.height);
		buttonSize = startButton.getPreferredSize();
		startButton.setBounds(290 + insets.left, 120 + insets.top,
				buttonSize.width*2, buttonSize.height);


	}

	public void paint(Graphics g) {
		super.paint(g);

		//draw title text
		g.drawImage(welcomePage.binDec3TitleImg, 75, 10, this);

		//draw the boxes
		g.setColor(WelcomePage.textColor);
		g.drawRect(box1x,box1y,box1width,box1height);
		g.drawRect(box10x,box10y,box10width,box10height);

		//draw the movable squares
		g.setColor(WelcomePage.buttonPanelColor);
		for (int i = 0;i < recList.size(); i++){
			g.fillRect((int)recList.get(i).getX(),(int)recList.get(i).getY(), rectUnit, rectUnit );
		}

		//box labels
		g.setColor(WelcomePage.textColor);
		g.setFont(new Font("Verdana", 1, 20));
		g.drawString("TENS", box10x+45, box10y-4);
		g.drawString("ONES", box1x+45, box1y-4);

		g.setColor(WelcomePage.textColor);
		g.setFont(new Font("Geneva", Font.BOLD, 12));
		int startTextX = 50;
		int startTextY = 75;
		int textYInc = 18;

		g.drawString(DecToBinNumSquaresText, startTextX, startTextY);
		g.drawString(DecToBinNumSquaresText2, startTextX, startTextY+=textYInc);
		g.drawString(DecToBinNumSquaresText3, startTextX, startTextY+=textYInc);

		int stepTextY = startTextY+ 70;
		if (displayStep1){
			g.drawString(text3, startTextX, stepTextY );
			g.drawString(text4, startTextX, stepTextY+textYInc);
		}
		if (displayStep2){
			g.drawString(text5, startTextX, stepTextY);
		}
		if (displayStep3){
			g.drawString(text6, startTextX, stepTextY );
			g.drawString(text7, startTextX, stepTextY+textYInc);
			g.drawString(text8, startTextX, stepTextY+2*textYInc);
		}
		if (displayStep7){
			g.drawString(text9, startTextX, stepTextY);
			g.drawString(text10, startTextX, stepTextY+textYInc);
		}

	}





} //end class

//// This method will be called when the mouse has been clicked. 
//public void mouseClicked (MouseEvent me) 
//{
//	// Save the coordinates of the click lke this.
//	xpos = me.getX(); 
//	ypos = me.getY();
//
//
//	//select one of the rectangles first
//	for (int i = 0; i < recList.size(); i++){
//		int recx = (int) recList.get(i).getX();
//		int recy = (int) recList.get(i).getY();
//		if ((xpos >= recx) && (xpos <= (recx + rectUnit)) && (ypos >= recy) && (ypos <= (recy + rectUnit))){
//			rectSelected = true;
//			rectSelectedNum = i;
//			break;
//		} 
//
//
//	}
//
//	if(rectSelected)
//	{
//		if((xpos >= box10x) && (xpos <= (box10x + box10width)) && (ypos >= box10y) && (ypos <= (box10y + box10height)))
//		{
//			boxSelected10 = true;
//			boxSelected1 = false;
//			recList.get(rectSelectedNum).setLocation(me.getX(), me.getY());
//
//		}
//		else if((xpos >= box1x) && (xpos <= (box1x + box1width)) && (ypos >= box1y) && (ypos <= (box1y + box1height)))
//		{
//			boxSelected1 = true;
//			boxSelected10 = false;
//			recList.get(rectSelectedNum).setLocation(me.getX(), me.getY());
//
//		}
//		else {
//			boxSelected10 = false;
//			boxSelected1 = false;
//		}
//
//	}
//
//
//	//show the results of the click 
//	repaint();
//
//}

//formats the text panel layout
//	public void initTextPanel(){
//		textPanel = new JPanel();
//		textPanel.setLayout(new GridBagLayout());
//		textPanel.setBackground(WelcomePage.backgroundColor);
//		GridBagConstraints c = new GridBagConstraints();
//		c.anchor = GridBagConstraints.CENTER;
//		c.fill = GridBagConstraints.HORIZONTAL;
//		c.ipadx = 20;
//		c.gridx = 0;
//		c.gridy = 0;
//		textPanel.add(DecToBinNumSquaresText, c);
//		c.gridy = 1;
//		textPanel.add(DecToBinNumSquaresText2, c);
//		c.gridy = 2;
//		textPanel.add(DecToBinNumSquaresText3, c);
//		c.gridy = 3;
//		textPanel.add(startButton, c);
//		
//	}

//	//formats the question panel layout
//	public void initQuestionPanel(){
//		questionPanel = new JPanel();
//		questionPanel.setLayout(new GridBagLayout());
//		questionPanel.setBackground(WelcomePage.backgroundColor);
//		GridBagConstraints c2 = new GridBagConstraints();
//		c2.anchor = GridBagConstraints.CENTER;
//		c2.fill = GridBagConstraints.HORIZONTAL;
//		c2.ipadx = 20;
//		c2.gridx = 0;
//		c2.gridy = 0;
//		questionPanel.add(TextHowManyTens, c2);
//		c2.gridx = 1;
//		c2.gridy = 0;
//		questionPanel.add(NumberTensField, c2);
//		c2.gridx = 2;
//		c2.gridy = 0;
//		questionPanel.add(TextHowManyOnes, c2);
//		c2.gridx = 3;
//		c2.gridy = 0;
//		questionPanel.add(NumberOnesField, c2);
//		c2.gridx = 0;
//		c2.gridy = 1;
//		c2.gridwidth = 4;
//		questionPanel.add(submitButton, c2);
//		c2.gridy = 2;
//		questionPanel.add(DecToBinNumSquaresText4, c2);
//		c2.gridy = 3;
//		questionPanel.add(DecToBinNumSquaresText5, c2);
//		DecToBinNumSquaresText4.setVisible(false);
//		DecToBinNumSquaresText5.setVisible(false);
//	}