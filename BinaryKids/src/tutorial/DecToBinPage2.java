//this class is the second page in the decimal to binary tutorial

package tutorial;

//http://stackoverflow.com/questions/3953208/value-change-listener-to-jtextfield
//refered above link for listeners to text field

import java.awt.*; 
import java.awt.event.*; 
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

@SuppressWarnings("serial")
public class DecToBinPage2 extends JPanel implements ActionListener 
{
	//whether or not clicked start button
	private boolean startClicked = false;

	//timer used for animation
	private Timer timer;
	private int DELAY = 000;

	//applet
	private Controller controller;
	
	//swing components
	private JButton submitButton; 
	private JButton startButton;
	private final String instructions1 = "How do we get the number 11? 11 = how many tens + how many ones? We will put the 11 squares";
	private final String instructions2 = "in the TENS and ONES boxes to review the decimal number system. We will do this first example";
	private final String instructions3 = "for you and then let you try! Click the start button to begin.";
	private JTextField NumberTensField;
	private JTextField NumberOnesField;
	
	// The coordinates of the 10's rectangle and 1s rectangle 
	private final int box10x = 210, box10y = 300, box10width = 150, box10height = 210;
	private final int box1x = 400, box1y = 300, box1width = 150, box1height = 210;	
	
	//swing somponent coords
	private final int submitButtonX = box1x +box1width + 20;
	private final int submitButtonY = box1y+box1height+5;
	private final int startButtonX = 290;
	private final int startButtonY = 140;
	private final int tensFieldX = box10x +45;
	private final int tensFieldY = box10y+box10height+5;
	private final int onesFieldX = box1x + 45;
	private final int onesFieldY = box1y+box1height+5;

	private final int DecToBinNumSquaresActual = 11;

	private String numTensInput;
	private String numOnesInput;
	private final String numTensActual = "1";
	private final String numOnesActual = "1";

	//width and height of sqare
	private final int squareUnit = 30;
	//starting location to draw squares
	final int startXSquare = 180;
	final int startYSquare = 240;
	//coordinate list for the squares
	private ArrayList<Integer> xCoordList =  new ArrayList<Integer>();
	private ArrayList<Integer> yCoordList =  new ArrayList<Integer>();

	private Rectangle square;
	private ArrayList<Rectangle> squareList = new ArrayList<Rectangle>();

	private final String text1 = "Do we have enough squares to put ten squares in the TENS box? ";
	private final String text2 = "Since we do; let's put ten red squares in the TENS box.";
	private final String text3 = "Since we had enough squares, type 1 below the TENS box.";
	private final String text4 = "Check how many squares are left remaining. Do we have enough";
	private final String text5 = "to put one square in the ONES box?";
	private final String text6 = "We have enough! Let's move the square to the ONES box.";
	private final String text7 = "Since we had enough squares, type 1 below the ONES box.";
	private final String text8 = "Since there are no squares left we are all done!";
	private final String text9 = "When you finish, click submit to check your answer.";

	//flags used in animating
	private int recListIterator = 0;
	private boolean displayStep1= false;
	private boolean displayStep2= false;
	private boolean displayStep3= false;
	private boolean displayStep4= false;
	boolean displayedStep2 = false;
	boolean displayedStep3 = false;
	boolean number10correct = false;
	boolean number1correct = false;

	//defines coordinates for help text
	private final int startTextX = 60;
	private final int startTextY = 85;
	private final int textYInc = 20;
	private final int stepTextY = 185;
	private final int indentTextX = 30;
	
	//constructor, param is the applet
	public DecToBinPage2(Controller welcome)
	{
		controller = welcome;
		setBackground(Controller.backgroundColor);

		initComponents();
		addComponentsToPanel();
		formatComponents();

		setVisible(true);
	}
	





	//overriden method for timer action
	@Override
	public void actionPerformed(ActionEvent e) {

		if (recListIterator < 10){
			moveTens();
		}
		if (recListIterator == 10 && displayedStep2 == false){
			displayStep1 = false;
			displayStep2 = true;
		}
		if (displayStep3){
			moveOnes();
		}

		if (displayStep4){
			timer.stop();
		}
		validate();
		repaint();

	}



	//inits the coords of the rects that user will move
	public void initRects(){
		//starting locations
		int x = startXSquare;
		for (int i = 0; i < DecToBinNumSquaresActual; i++){
			square = new Rectangle(x, startYSquare, squareUnit,squareUnit);
			squareList.add(square);
			x+=40;
		}

		//locations to move during animations
		int y = box10y+10;
		for (int i = 0; i < 5; i++){
			xCoordList.add(box10x + 10);
			yCoordList.add(y);
			y = y + 10 + squareUnit;
		}
		y=box10y+10;
		for (int i = 0; i < 5; i++){
			xCoordList.add(box10x + 50);
			yCoordList.add(y);
			y = y + 10 + squareUnit;
		}
		xCoordList.add(box1x+10);
		yCoordList.add(box1y+10);

	}

	//defines listener for submit button
	class submitButtonListener implements ActionListener 
	{
		//checks input when button clicked
		public void actionPerformed(ActionEvent le) {  
			numTensInput = NumberTensField.getText();
			numOnesInput = NumberOnesField.getText();

			if (numTensInput.equals(numTensActual) && numOnesInput.equals(numOnesActual)){
				controller.loadCard("DEC BIN PAGE 3");
			}
			else{
				String errorMessage = "Wrong answer, try again!";
				JOptionPane.showMessageDialog(controller, errorMessage, "wrong answer", JOptionPane.YES_NO_OPTION);

				NumberTensField.setText("");
				NumberOnesField.setText("");
			}

		} 
	}

	//defines listener for start button
	class startButtonListener implements ActionListener 
	{
		//starts timer and updates text when clicked
		public void actionPerformed(ActionEvent le) {  
			startButton.setVisible(false);
			timer.start();
			displayStep1 = true;
			startClicked = true;
		} 
	}

	//inits text fields and adds listeners
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
					displayStep4 = true;
					repaint();
				}
			}
		});

	}


	//inits button components
	public void initButtons(){
		submitButton = new JButton("Submit"); 
		submitButton.addActionListener(new submitButtonListener());
		startButton = new JButton("Start Example");
		startButton.addActionListener(new startButtonListener());
	}

	//init swing components
	public void initComponents(){
		timer = new Timer(DELAY, this);
		initButtons();
		initTextFields();
		initRects();
	}
	
	public void moveTens(){
		squareList.get(recListIterator).setLocation(xCoordList.get(recListIterator), yCoordList.get(recListIterator));
		recListIterator++;
	}


	//this method adds the components to the panel
	public void addComponentsToPanel() {
		setLayout(null);

		add(submitButton);
		add(startButton);
		add(NumberTensField);
		add(NumberOnesField);

	}

	//this method defines the formatting of the components on the panel
	public void formatComponents(){
		Insets insets = getInsets();
		
		Dimension buttonSize = submitButton.getPreferredSize();
		submitButton.setBounds(submitButtonX + insets.left, submitButtonY + insets.top,
				buttonSize.width, buttonSize.height);
		
		buttonSize = startButton.getPreferredSize();
		startButton.setBounds(startButtonX + insets.left, startButtonY + insets.top,
				buttonSize.width*2, buttonSize.height);

		Dimension fieldSize = NumberTensField.getPreferredSize();
		NumberTensField.setBounds(tensFieldX + insets.left, tensFieldY + insets.top,
				fieldSize.width, buttonSize.height);
		NumberOnesField.setBounds(onesFieldX+ insets.left, onesFieldY + insets.top,
				fieldSize.width, buttonSize.height);
	}

	public void moveOnes(){
		squareList.get(recListIterator).setLocation(xCoordList.get(recListIterator), yCoordList.get(recListIterator));
		timer.stop();
	}

	//overridden paint method
	public void paint(Graphics g) {
		super.paint(g);

		//draw title text
		g.drawImage(controller.decBinHeadlineImg, 75, 10, this);

		//draw the boxes
		g.setColor(Controller.textColor);
		g.drawRect(box1x,box1y,box1width,box1height);
		g.drawRect(box10x,box10y,box10width,box10height);

		//draw the movable squares
		g.setColor(Controller.buttonPanelColor);
		for (int i = 0;i < squareList.size(); i++){
			g.fillRect((int)squareList.get(i).getX(),(int)squareList.get(i).getY(), squareUnit, squareUnit );
		}

		//box labels
		g.setColor(Controller.textColor);
		g.setFont(new Font("Verdana", 1, 20));
		g.drawString("TENS", box10x+45, box10y-4);
		g.drawString("ONES", box1x+45, box1y-4);


		//display instructions
		g.setColor(Controller.textColor);
		g.setFont(new Font("Geneva", Font.BOLD, 14));
		if (!startClicked){
			g.drawString(instructions1, startTextX, startTextY);
			g.drawString(instructions2, startTextX, startTextY+textYInc);
			g.drawString(instructions3, startTextX, startTextY+textYInc);
		}

		
		//display steps
		g.setFont(new Font("Geneva", Font.BOLD, 18));
		if (displayStep1){
			g.drawString(text1, startTextX, stepTextY );
			g.drawString(text2, startTextX+indentTextX, stepTextY+textYInc);
		}
		if (displayStep2){
			g.drawString(text3, startTextX, stepTextY);
		}
		if (displayStep3){
			g.drawString(text4, startTextX, stepTextY );
			g.drawString(text5, startTextX+indentTextX, stepTextY+textYInc);
			g.drawString(text6, startTextX, stepTextY+2*textYInc);
			g.drawString(text7, startTextX, stepTextY+3*textYInc);
		}
		if (displayStep4){
			g.drawString(text8, startTextX, stepTextY);
			g.drawString(text9, startTextX, stepTextY+textYInc);
		}

	}





} //end class