package tutorial;



import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.Timer;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Insets;
import java.awt.Rectangle;
import java.util.ArrayList;

@SuppressWarnings("serial")
public class BinaryDecimalTwo extends JPanel implements ActionListener
{	

	boolean display1 = false;
	boolean display2 = false;
	boolean display3 = false;
	boolean display4 = false;
	boolean display5 = false;
	boolean display6 = false;
	boolean display7 = false;
	
	boolean startClicked = false;
	int globalI = 0;
	
	boolean displayedStep2 = false;
	boolean displayedStep3 = false;
	boolean displayedStep4 = false;

	private Timer timer;
	private int DELAY = 2000;

	WelcomePage welcomePage;

	//TextFields
	JTextField NumberEightsField;
	JTextField NumberFoursField;
	JTextField NumberTwosField;
	JTextField NumberOnesField;

	//buttons
	JButton submitButton;
	JButton startButton;

	//13 in binary is 1101
	final int BinToDecNumSquaresActual = 13;

	//actual values
	final String numEightsActual = "1";
	final String numFoursActual = "1";
	final String numTwosActual = "0";
	final String numOnesActual = "1";

	//user input
	String numEightsInput;
	String numFoursInput;
	String numTwosInput;
	String numOnesInput;

	// The coordinates of the boxes
	final int box8x = 150, box8y = 280, box8width = 100, box8height = 250;
	final int box4x = 290, box4y = 280, box4width = 100, box4height = 250;
	final int box2x = 430, box2y = 280, box2width = 100, box2height = 250;
	final int box1x = 570, box1y = 280, box1width = 100, box1height = 250;

	// variable that will be true when the user clicked in the rectangle  
	// the we will draw. 
	boolean boxSelected8 = false;
	boolean boxSelected4 = false;
	boolean boxSelected2 = false;
	boolean boxSelected1 = false;
	boolean rectSelected = false;
	int rectSelectedNum = 0;

	//rectangles
	final int rectUnit = 30;
	final int startx = 155;
	final int starty = 220;
	private Rectangle rec;
	ArrayList<Rectangle> recList = new ArrayList<Rectangle>();
	//coordinate list for the squares
	ArrayList<Integer> xCoordList =  new ArrayList<Integer>();
	ArrayList<Integer> yCoordList =  new ArrayList<Integer>();
	
	String instructions1 = "How do we get the number 13? 13 = how many eights + how many fours + how many twos + how ";
	String instructions2 = "many ones? We will put the 13 squares in the below boxes to review the binary number system.";
	String instructions3 = "We will do this first example for you and then let you try! Click the start button to begin.";

	String text1 = "Do we have enough squares to put eight squares in the EIGHTS box?";
	String text2 = "Since we do; let's put eight red squares in the EIGHTS box."; 
	String text3 = "Since we had enough squares, type 1 below the EIGHTS box.";
	String text4 = "Check how many squares are left remaining. Do we have enough";
	String text5 = "to put four squares in the FOURS box?";
	String text6 = "Since we do; let's put four red squares in the FOURS box.";
	String text7 = "Since we had enough squares, type 1 below the FOURS box.";
	String text8 = "Check how many squares are left remaining. Do we have enough";
	String text9 = "to put two squares in the TWOS box?";
	String text10 = "Since we don't have enough, type 0 below the TWOS box.";
	String text11 = "Do we have enough to put one square in the ONES box?";
	String text12 = "Since we do; let's put one red squares in the ONES box.";
	String text13 = "Since we had enough squares, type 1 below the ONES box.";
	String text14 = "Since there are no squares left we are all done!";
	String text15 = "When you finish, click submit to check your answer.";

	public BinaryDecimalTwo(WelcomePage welcome)
	{
		timer = new Timer(DELAY, this);
		welcomePage = welcome;
		setBackground(WelcomePage.backgroundColor);
		Insets insets = getInsets();

		initTextFields();
		initRects();
		initButtons();

		setLayout(null);
		add(NumberEightsField);
		add(NumberFoursField);
		add(NumberTwosField);
		add(NumberOnesField);
		add(submitButton);
		add(startButton);

		Dimension buttonSize = submitButton.getPreferredSize();
		submitButton.setBounds(box1x +box1width + 20 + insets.left, box1y+box1height+5 + insets.top,
				buttonSize.width, buttonSize.height);
		buttonSize = startButton.getPreferredSize();
		startButton.setBounds(290 + insets.left, 140 + insets.top,
				buttonSize.width*2, buttonSize.height);

		Dimension size = NumberEightsField.getPreferredSize();
		NumberEightsField.setBounds(box8x + 25 + insets.left, box8y+box8height+5 + insets.top,
				size.width, buttonSize.height);
		NumberFoursField.setBounds(box4x + 25 + insets.left, box4y+box8height+5 + insets.top,
				size.width, buttonSize.height);
		NumberTwosField.setBounds(box2x + 25 + insets.left, box2y+box8height+5 + insets.top,
				size.width, buttonSize.height);
		NumberOnesField.setBounds(box1x + 25 + insets.left, box1y+box8height+5 + insets.top,
				size.width, buttonSize.height);

		setVisible(true);

	}
	
	public void moveEights(){
		recList.get(globalI).setLocation(xCoordList.get(globalI), yCoordList.get(globalI));
		globalI++;
	}
	public void moveFours(){
		recList.get(globalI).setLocation(xCoordList.get(globalI), yCoordList.get(globalI));
		globalI++;
	}
	public void moveOnes(){
		recList.get(globalI).setLocation(xCoordList.get(globalI), yCoordList.get(globalI));
		timer.stop();
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		if (globalI < 8){
			moveEights();
		}
		if (globalI == 8 && displayedStep2 == false){
			display1 = false;
			display2 = true;
		}
		if (globalI >= 8 && display3){
			moveFours();
		}
		if (globalI == 12 && displayedStep3 == false){
			display1 = false;
			display2 = false;
			display3 = false;
			display4 = true;
		}
		if (globalI >= 12 && display6){
			moveOnes();
		}
		
		
		validate();
		repaint();
	}
	
	class startButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent le) {  
			startButton.setVisible(false);
			timer.start();
			startClicked = true;
			display1 = true;
			repaint();
		} 
	}
	
	//inits format of text field
	public void initTextFields(){
		NumberEightsField = new JTextField();
		NumberFoursField = new JTextField();
		NumberTwosField = new JTextField();
		NumberOnesField = new JTextField();
		NumberEightsField.setColumns(5);
		NumberFoursField.setColumns(5);
		NumberTwosField.setColumns(5);
		NumberOnesField.setColumns(5);


		NumberEightsField.getDocument().addDocumentListener(new DocumentListener() {
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
				if (!NumberEightsField.getText().equals("1")){
					JOptionPane.showMessageDialog(null,
							"Error: Please enter 1", "Error Messege",
							JOptionPane.ERROR_MESSAGE);
				}
				else{
					display1 = false;
					display2 = false;
					display3 = true;
					displayedStep2 = true;
					repaint();
				}
			}

		});

		NumberFoursField.getDocument().addDocumentListener(new DocumentListener() {
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
				if (!NumberFoursField.getText().equals("1")){
					JOptionPane.showMessageDialog(null,
							"Error: Please enter 1", "Error Messege",
							JOptionPane.ERROR_MESSAGE);
				}
				else{
					display1 = false;
					display2 = false;
					display3 = false;
					display4 = false;
					display5 = true;
					displayedStep3 = true;
					repaint();
				}
			}

		});
		
		NumberTwosField.getDocument().addDocumentListener(new DocumentListener() {
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
				if (!NumberTwosField.getText().equals("0")){
					JOptionPane.showMessageDialog(null,
							"Error: Please enter 0", "Error Messege",
							JOptionPane.ERROR_MESSAGE);
				}
				else{
					display1 = false;
					display2 = false;
					display3 = false;
					display4 = false;
					display5 = false;
					display6 = true;
					displayedStep4 = true;
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
					display1 = false;
					display2 = false;
					display3 = false;
					display4 = false;
					display5 = false;
					display6 = false;
					display7 = true;
					displayedStep4 = true;
					repaint();
				}
			}

		});
		
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
		
		
		//locations to move during animations
		//EIGHTS
		int y = box8y+10;
		for (int i = 0; i < 4; i++){
			xCoordList.add(box8x+10);
			yCoordList.add(y);
			y = y + 10 + rectUnit;
		}
		y=box8y+10;
		for (int i = 0; i < 4; i++){
			xCoordList.add(box8x+20+rectUnit);
			yCoordList.add(y);
			y = y + 10 + rectUnit;
		}
		//FOURS
		y=box4y+10;
		for (int i = 0; i < 2; i++){
			xCoordList.add(box4x+10);
			yCoordList.add(y);
			y = y + 10 + rectUnit;
		}
		y=box4y+10;
		for (int i = 0; i < 2; i++){
			xCoordList.add(box4x+20+rectUnit);
			yCoordList.add(y);
			y = y + 10 + rectUnit;
		}
		//ONES
		xCoordList.add(box1x+10);
		yCoordList.add(box1y+10);
		
		
	}

	public void initButtons()
	{
		submitButton = new JButton("Submit");
		submitButton.addActionListener(new submitButtonListener());
		startButton = new JButton("Start Example");
		startButton.addActionListener(new startButtonListener());
	}


	public void paint(Graphics g)
	{
		super.paint(g);

		//draw title text
		g.drawImage(welcomePage.binDecImg, 100, 15, this);


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


		//draw the squares
		g.setColor(WelcomePage.buttonPanelColor);
		for (int i = 0;i < recList.size(); i++){
			g.fillRect((int)recList.get(i).getX(),(int)recList.get(i).getY(), rectUnit, rectUnit );
		}

		//box labels
		g.setColor(WelcomePage.textColor);
		g.setFont(new Font("Verdana", 1, 20));
		g.drawString("EIGHTS", box8x+10, box8y-4);
		g.drawString("FOURS", box4x+15, box4y-4);
		g.drawString("TWOS", box2x+20, box2y-4);
		g.drawString("ONES", box1x+20, box1y-4);

		g.setColor(WelcomePage.textColor);
		g.setFont(new Font("Geneva", Font.BOLD, 14));
		int startTextX = 60;
		int startTextY = 85;
		int textYInc = 20;

		if (!startClicked){
			g.drawString(instructions1, startTextX, startTextY);
			g.drawString(instructions2, startTextX, startTextY+textYInc);
			g.drawString(instructions3, startTextX, startTextY+2*textYInc);
		}
		
		g.setFont(new Font("Geneva", Font.BOLD, 18));
		if (display1){
			g.drawString(text1, startTextX, startTextY);
			g.drawString(text2, startTextX, startTextY+textYInc);
		}
		if (display2){
			g.drawString(text3, startTextX, startTextY);
		}
		if (display3){
			g.drawString(text4, startTextX, startTextY);
			g.drawString(text5, startTextX, startTextY+textYInc);
			g.drawString(text6, startTextX, startTextY+2*textYInc);
		}
		if (display4){
			g.drawString(text7, startTextX, startTextY);
		}
		if (display5){
			g.drawString(text8, startTextX, startTextY);
			g.drawString(text9, startTextX, startTextY+textYInc);
			g.drawString(text10, startTextX, startTextY+2*textYInc);
		}
		if (display6){
			g.drawString(text11, startTextX, startTextY);
			g.drawString(text12, startTextX, startTextY+textYInc);
			g.drawString(text13, startTextX, startTextY+2*textYInc);
		}
		if (display7){
			g.drawString(text14, startTextX, startTextY);
			g.drawString(text15, startTextX, startTextY+textYInc);
		}
		
		
	} //end paint



	class submitButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			//get all text from text boxes, if correct then display dialog box
			//then go to new page

			numEightsInput = NumberEightsField.getText();
			numFoursInput = NumberFoursField.getText();
			numTwosInput = NumberTwosField.getText();
			numOnesInput = NumberOnesField.getText();

//			int countEights = 0;
//			int countFours = 0;
//			int countTwos = 0;
//			int countOnes = 0;
//
//			for(int i = 0; i < recList.size(); i++)
//			{
//				int x = (int) recList.get(i).getX();
//				int y = (int) recList.get(i).getY();
//
//
//				if((x >= box8x) && (x <= (box8x + box8width)) && (y >= box8y) && (y <= (box8y + box8height)))
//				{
//					countEights++; //if the rect is in the eights box, add 1
//				}
//				else if((x >= box4x) && (x <= (box4x + box4width)) && (y >= box4y) && (y <= (box4y + box4height)))
//				{
//					//if the rect is in the fours box
//					countFours++;
//				}
//				else if((x >= box2x) && (x <= (box2x + box2width)) && (y >= box2y) && (y <= (box2y + box2height)))
//				{
//					//if the rect is in the twos box
//					countTwos++;
//				}
//				else if((x >= box1x) && (x <= (box1x + box1width)) && (y >= box1y) && (y <= (box1y + box1height)))
//				{
//					//if the rect is in the ones box
//					countOnes++;
//				}
//				else
//				{
//
//				}
//
//			}
//
//
//			if (countEights == 8
//					&& countFours == 4
//					&& countTwos == 0
//					&& countOnes == 1){
//
//			}
//			else{
//				String errorMessage = "The squares are not in the correct boxes, try again!";
//				JOptionPane.showMessageDialog(welcomePage, errorMessage, "wrong answer", JOptionPane.YES_NO_OPTION);
//				NumberEightsField.setText("");
//				NumberTwosField.setText("");
//				NumberFoursField.setText("");
//				NumberOnesField.setText("");
//				return;
//			}


			if (numEightsInput.equals(numEightsActual)
					&& numFoursInput.equals(numFoursActual)
					&& numTwosInput.equals(numTwosActual)
					&& numOnesInput.equals(numOnesActual)   ){
				welcomePage.loadBinToDec3();
			}
			else{
				String errorMessage = "Wrong answer, try again!";
				JOptionPane.showMessageDialog(welcomePage, errorMessage, "wrong answer", JOptionPane.YES_NO_OPTION);

				NumberEightsField.setText("");
				NumberTwosField.setText("");
				NumberFoursField.setText("");
				NumberOnesField.setText("");
			}


		} //end action performed


	} //end button listener


} //end class thirdpage

//This method will be called when the mouse has been clicked. 
//	public void mouseClicked (MouseEvent me) 
//	{
//
//		// Save the coordinates of the click lke this.
//		xpos = me.getX(); 
//		ypos = me.getY();
//
//
//		//select one of the rectangles first
//		for (int i = 0; i < recList.size(); i++){
//			int recx = (int) recList.get(i).getX();
//			int recy = (int) recList.get(i).getY();
//			if ((xpos >= recx) && (xpos <= (recx + rectUnit)) && (ypos >= recy) && (ypos <= (recy + rectUnit))){
//				rectSelected = true;
//				rectSelectedNum = i;
//				break;
//			} 
//
//
//		}
//
//		if(rectSelected)
//		{
//
//			if((xpos >= box8x) && (xpos <= (box8x + box8width)) && (ypos >= box8y) && (ypos <= (box8y + box8height)))
//			{
//				boxSelected8 = true;
//				boxSelected4 = false;
//				boxSelected2 = false;
//				boxSelected1 = false;
//				recList.get(rectSelectedNum).setLocation(me.getX(), me.getY());
//
//			}
//			else if((xpos >= box4x) && (xpos <= (box4x + box4width)) && (ypos >= box4y) && (ypos <= (box4y + box4height)))
//			{
//				boxSelected4 = true;
//				boxSelected8 = false;
//				boxSelected2 = false;
//				boxSelected1 = false;
//				recList.get(rectSelectedNum).setLocation(me.getX(), me.getY());
//
//			}
//			else if((xpos >= box2x) && (xpos <= (box2x + box2width)) && (ypos >= box2y) && (ypos <= (box2y + box2height)))
//			{
//				boxSelected2 = true;
//				boxSelected4 = false;
//				boxSelected8 = false;
//				boxSelected1 = false;
//				recList.get(rectSelectedNum).setLocation(me.getX(), me.getY());
//
//			}
//			else if((xpos >= box1x) && (xpos <= (box1x + box1width)) && (ypos >= box1y) && (ypos <= (box1y + box1height)))
//			{
//				boxSelected1 = true;
//				boxSelected4 = false;
//				boxSelected2 = false;
//				boxSelected8 = false;
//				recList.get(rectSelectedNum).setLocation(me.getX(), me.getY());
//
//			}
//			else {
//
//			}
//
//		}
//
//
//
//
//		//show the results of the click 
//		repaint();
//
//	} //end mouse click listener
//
//
//	// When it has been released 
//	// note that a click also calls these Mouse-Pressed and Released. 
//	// since they are empty nothing hapens here. 
//	public void mouseReleased (MouseEvent me) {} 
//
//	// This is called when the mous has been pressed 
//	public void mousePressed (MouseEvent me) {}
//
//	// This is executed when the mouse enters the applet. it will only 
//	// be executed again when the mouse has left and then re-entered. 
//	public void mouseEntered (MouseEvent me) {}
//
//	// When the Mouse leaves the applet. 
//	public void mouseExited (MouseEvent me) {} 
