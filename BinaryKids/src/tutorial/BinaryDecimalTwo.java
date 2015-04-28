//this class is the second page in the binary to decimal tutorial


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
	int sqListIterator = 0;
	
	boolean displayedStep2 = false;
	boolean displayedStep3 = false;
	boolean displayedStep4 = false;

	private Timer timer;
	private int DELAY = 1000;

	Controller controller;

	//TextFields
	JTextField NumberEightsField;
	JTextField NumberFoursField;
	JTextField NumberTwosField;
	JTextField NumberOnesField;

	//buttons
	JButton submitButton;
	private JButton startButton;

	//13 in binary is 1101
	final int BinToDecNumSquaresActual = 13;

	//actual values
	private final String numEightsActual = "1";
	private final String numFoursActual = "1";
	private final String numTwosActual = "0";
	private final String numOnesActual = "1";

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

	//colored squares
	private final int squareUnit = 30;
	private final int startXSquare = 155;
	private final int startYSquare = 220;
	private Rectangle square;
	private ArrayList<Rectangle> squareList = new ArrayList<Rectangle>();
	//coordinate list for the squares
	private ArrayList<Integer> xCoordList =  new ArrayList<Integer>();
	private ArrayList<Integer> yCoordList =  new ArrayList<Integer>();
	
	private final String instructions1 = "How do we get the number 13? 13 = how many eights + how many fours + how many twos + how ";
	private final String instructions2 = "many ones? We will put the 13 squares in the below boxes to review the binary number system.";
	private final String instructions3 = "We will do this first example for you and then let you try! Click the start button to begin.";

	private final String text1 = "Do we have enough squares to put eight squares in the EIGHTS box?";
	private final String text2 = "Since we do; let's put eight red squares in the EIGHTS box."; 
	private final String text3 = "Since we had enough squares, type 1 below the EIGHTS box.";
	private final String text4 = "Check how many squares are left remaining. Do we have enough";
	private final String text5 = "to put four squares in the FOURS box?";
	private final String text6 = "Since we do; let's put four red squares in the FOURS box.";
	private final String text7 = "Since we had enough squares, type 1 below the FOURS box.";
	private final String text8 = "Check how many squares are left remaining. Do we have enough";
	private final String text9 = "to put two squares in the TWOS box?";
	private final String text10 = "Since we don't have enough, type 0 below the TWOS box.";
	private final String text11 = "Do we have enough to put one square in the ONES box?";
	private final String text12 = "Since we do; let's put one red squares in the ONES box.";
	private final String text13 = "Since we had enough squares, type 1 below the ONES box.";
	private final String text14 = "Since there are no squares left we are all done!";
	private final String text15 = "When you finish, click submit to check your answer.";
	
	final int submitButtonX = box1x +box1width + 20;
	final int submitButtonY = box1y+box1height+5;
	final int startButtonX = 290;
	final int startButtonY = 140;
	final int eightsFieldX = box8x + 25;
	final int eightsFieldY = box8y+box8height+5;
	final int foursFieldX = box4x + 25;
	final int foursFieldY = box4y+box8height+5;
	final int twosFieldX = box2x + 25;
	final int twosFieldY = box2y+box8height+5;
	final int onesFieldX = box1x + 25;
	final int onesFieldY = box1y+box8height+5;
	
	
	final int headerX = 100;
	final int headerY = 15;
	
	final int startTextX = 60;
	final int startTextY = 85;
	final int textYInc = 20;

	//this method defines the formatting of the components on the panel
	public void formatComponents(){
		Insets insets = getInsets();

		Dimension buttonSize = submitButton.getPreferredSize();
		submitButton.setBounds(submitButtonX + insets.left, submitButtonY + insets.top,
				buttonSize.width, buttonSize.height);
		
		buttonSize = startButton.getPreferredSize();
		startButton.setBounds(startButtonX + insets.left, startButtonY + insets.top,
				buttonSize.width*2, buttonSize.height);

		Dimension size = NumberEightsField.getPreferredSize();
		NumberEightsField.setBounds(eightsFieldX + insets.left, eightsFieldY + insets.top,
				size.width, buttonSize.height);
		NumberFoursField.setBounds(foursFieldX + insets.left, foursFieldY + insets.top,
				size.width, buttonSize.height);
		NumberTwosField.setBounds(twosFieldX + insets.left, twosFieldY + insets.top,
				size.width, buttonSize.height);
		NumberOnesField.setBounds(onesFieldX + insets.left, onesFieldY + insets.top,
				size.width, buttonSize.height);
	}
	
	//this method adds the components to the panel
	public void addComponentsToPanel() {
		setLayout(null);
		add(NumberEightsField);
		add(NumberFoursField);
		add(NumberTwosField);
		add(NumberOnesField);
		add(submitButton);
		add(startButton);
	}
	
	//init swing components
	public void initComponents(){
		timer = new Timer(DELAY, this);
		initTextFields();
		initRects();
		initButtons();
	}
	
	//constructor, param is applet
	public BinaryDecimalTwo(Controller welcome)
	{
		controller = welcome;
		setBackground(Controller.backgroundColor);
		initComponents();
		addComponentsToPanel();
		formatComponents();
		setVisible(true);

	}
	
	//move the squares into the eights box
	public void moveEights(){
		squareList.get(sqListIterator).setLocation(xCoordList.get(sqListIterator), yCoordList.get(sqListIterator));
		sqListIterator++;
	}
	
	//move the squares into the fours box
	public void moveFours(){
		squareList.get(sqListIterator).setLocation(xCoordList.get(sqListIterator), yCoordList.get(sqListIterator));
		sqListIterator++;
	}
	
	//move the squares into the ones box
	public void moveOnes(){
		squareList.get(sqListIterator).setLocation(xCoordList.get(sqListIterator), yCoordList.get(sqListIterator));
		timer.stop();
	}

	//timer event
	@Override
	public void actionPerformed(ActionEvent e) {
		if (sqListIterator < 8){
			moveEights();
		}
		if (sqListIterator == 8 && displayedStep2 == false){
			display1 = false;
			display2 = true;
		}
		if (sqListIterator >= 8 && display3){
			moveFours();
		}
		if (sqListIterator == 12 && displayedStep3 == false){
			display1 = false;
			display2 = false;
			display3 = false;
			display4 = true;
		}
		if (sqListIterator >= 12 && display6){
			moveOnes();
		}
		
		
		validate();
		repaint();
	}
	
	//action listener for start button
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
		int x = startXSquare;
		for (int i = 0; i < BinToDecNumSquaresActual; i++)
		{
			square = new Rectangle(x, startYSquare, squareUnit,squareUnit);
			squareList.add(square);
			x+=40;
		}
		
		
		//locations to move during animations
		//EIGHTS
		int y = box8y+10;
		for (int i = 0; i < 4; i++){
			xCoordList.add(box8x+10);
			yCoordList.add(y);
			y = y + 10 + squareUnit;
		}
		y=box8y+10;
		for (int i = 0; i < 4; i++){
			xCoordList.add(box8x+20+squareUnit);
			yCoordList.add(y);
			y = y + 10 + squareUnit;
		}
		//FOURS
		y=box4y+10;
		for (int i = 0; i < 2; i++){
			xCoordList.add(box4x+10);
			yCoordList.add(y);
			y = y + 10 + squareUnit;
		}
		y=box4y+10;
		for (int i = 0; i < 2; i++){
			xCoordList.add(box4x+20+squareUnit);
			yCoordList.add(y);
			y = y + 10 + squareUnit;
		}
		//ONES
		xCoordList.add(box1x+10);
		yCoordList.add(box1y+10);
		
		
	}

	//initialize buttons
	public void initButtons()
	{
		submitButton = new JButton("Submit");
		submitButton.addActionListener(new submitButtonListener());
		startButton = new JButton("Start Example");
		startButton.addActionListener(new startButtonListener());
	}

	//override paint method
	public void paint(Graphics g)
	{
		super.paint(g);

		//draw title text
		g.drawImage(controller.binDecImg, headerX, headerY, this);


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
		g.setColor(Controller.buttonPanelColor);
		for (int i = 0;i < squareList.size(); i++){
			g.fillRect((int)squareList.get(i).getX(),(int)squareList.get(i).getY(), squareUnit, squareUnit );
		}

		//box labels
		g.setColor(Controller.textColor);
		g.setFont(new Font("Verdana", 1, 20));
		g.drawString("EIGHTS", box8x+10, box8y-4);
		g.drawString("FOURS", box4x+15, box4y-4);
		g.drawString("TWOS", box2x+20, box2y-4);
		g.drawString("ONES", box1x+20, box1y-4);

		g.setColor(Controller.textColor);
		g.setFont(new Font("Geneva", Font.BOLD, 14));


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


	//action listener for submit button
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


			if (numEightsInput.equals(numEightsActual)
					&& numFoursInput.equals(numFoursActual)
					&& numTwosInput.equals(numTwosActual)
					&& numOnesInput.equals(numOnesActual)   ){
				controller.loadCard("BIN DEC PAGE 3");
			}
			else{
				String errorMessage = "Wrong answer, try again!";
				JOptionPane.showMessageDialog(controller, errorMessage, "wrong answer", JOptionPane.YES_NO_OPTION);

				NumberEightsField.setText("");
				NumberTwosField.setText("");
				NumberFoursField.setText("");
				NumberOnesField.setText("");
			}


		} //end action performed


	} //end button listener


} //end class thirdpage