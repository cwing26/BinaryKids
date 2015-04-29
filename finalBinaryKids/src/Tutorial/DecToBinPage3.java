package Tutorial;

//this class is the third page in the decimal to binary tutorial


import java.awt.*; 
import java.awt.event.*; 
import java.util.ArrayList;

import javax.swing.*; 
import javax.swing.event.DocumentEvent;
import javax.swing.event.DocumentListener;

@SuppressWarnings("serial")
public class DecToBinPage3 extends JPanel implements MouseListener
{
	//flags for displaying text
	private boolean display1 = true;
	private boolean display2 = false;
	private boolean display3 = false;

	private Controller controller;
	private JButton submitButton; 

	//TextFields
	private JTextField NumberEightsField;
	private JTextField NumberFoursField;
	private JTextField NumberTwosField;
	private JTextField NumberOnesField;

	//user input
	private String numEightsInput;
	private String numFoursInput;
	private String numTwosInput;
	private String numOnesInput;

	//actual values
	private final String numEightsActual = "1";
	private final String numFoursActual = "0";
	private final String numTwosActual = "1";
	private final String numOnesActual = "1";
	private final int DecToBinNumSquaresActual = 11;

	//starting coords to draw squares
	private final int startXSquare = 200;
	private final int startYSquare = 220;

	//text to explain how to navigate the tutorial
	private final String text3 = "Do we have enough squares to put eight squares in the EIGHTS box?";
	private final String text4 = "If yes, put eight squares in the EIGHTS box. Click on a red square and then"; 
	private final String text45 = "click on the box to put the square inside.";
	private final String text5 = "Since we had enough squares, type 1 below the EIGHTS box.";
	private final String text6 = "Check how many squares are left remaining. Do we have enough";
	private final String text65 = "to put four squares in the FOURS box?";
	private final String text7 = "Since we don't have enough, type 0 below the FOURS box.";
	private final String text8 = "Keep assigning the remaining squares until none are left.";
	private final String text9 = "Remember: If you had enough squares to put in a box,";
	private final String text95 = "type 1, otherwise type 0.";
	private final String text10 = "When you finish, click submit to check your answer.";


	// The X-coordinate and Y-coordinate of the last click. 
	private int mouseX; 
	private int mouseY;

	// The coordinates of the boxes
	private final int box8x = 150, box8y = 280, box8width = 100, box8height = 250;
	private final int box4x = 290, box4y = 280, box4width = 100, box4height = 250;
	private final int box2x = 430, box2y = 280, box2width = 100, box2height = 250;
	private final int box1x = 570, box1y = 280, box1width = 100, box1height = 250;


	//flags for boxes and rectangles
	private boolean boxSelected8 = false;
	private boolean boxSelected4 = false;
	private boolean boxSelected2 = false;
	private boolean boxSelected1 = false;
	private boolean rectSelected = false;
	private int rectSelectedNum = 0;

	//rectangle width and height
	private final int squareUnit = 30;
	private Rectangle square;
	private ArrayList<Rectangle> squareList = new ArrayList<Rectangle>();

	//box labels coordinates
	private final int eightsX = box8x+10;
	private final int eightsY = box8y-4;
	private final int foursX = box4x+15;
	private final int foursY = box4y-4;
	private final int twosX = box2x+20;
	private final int twosY = box2y-4;
	private final int onesX = box1x+20;
	private final int onesY = box1y-4;

	//instructions coordinates
	private final int startTextX = 40;
	private final int startTextY = 100;
	private final int textYInc = 20;
	private final int indentTextX = 30;
	private final int headerX = 75;
	private final int headerY = 10;

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
			public void changedUpdate(DocumentEvent e) {}
			public void removeUpdate(DocumentEvent e) {}
			public void insertUpdate(DocumentEvent e) {
				display1 = false;
				display2 = true;
				display3 = false;
				repaint();
			}

		});

		NumberFoursField.getDocument().addDocumentListener(new DocumentListener() {
			public void changedUpdate(DocumentEvent e) {}
			public void removeUpdate(DocumentEvent e) {}
			public void insertUpdate(DocumentEvent e) {
				display1 = false;
				display2 = false;
				display3 = true;
				repaint();
			}

		});
	}

	//inits the coords of the rects that user will move
	public void initRects(){
		int x = startXSquare;
		for (int i = 0; i < DecToBinNumSquaresActual; i++){
			square = new Rectangle(x, startYSquare, squareUnit,squareUnit);
			squareList.add(square);
			x+=40;
		}
	}

	//adds an action listener to the submit button to verify input is correct
	class submitButtonListener implements ActionListener {   
		public void actionPerformed(ActionEvent le) {  
			numEightsInput = NumberEightsField.getText();
			numFoursInput = NumberFoursField.getText();
			numTwosInput = NumberTwosField.getText();
			numOnesInput = NumberOnesField.getText();

			int countEights = 0;
			int countFours = 0;
			int countTwos = 0;
			int countOnes = 0;

			for(int i = 0; i < squareList.size(); i++)
			{
				int x = (int) squareList.get(i).getX();
				int y = (int) squareList.get(i).getY();


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

			if (countEights == 8
					&& countFours == 0
					&& countTwos == 2
					&& countOnes == 1){

			}
			else{
				String errorMessage = "The squares are not in the correct boxes, try again!";
				JOptionPane.showMessageDialog(controller, errorMessage, "wrong answer", JOptionPane.YES_NO_OPTION);
				NumberEightsField.setText("");
				NumberTwosField.setText("");
				NumberFoursField.setText("");
				NumberOnesField.setText("");
				return;
			}


			if (numEightsInput.equals(numEightsActual)
					&& numFoursInput.equals(numFoursActual)
					&& numTwosInput.equals(numTwosActual)
					&& numOnesInput.equals(numOnesActual)   ){
				controller.loadCard("DEC BIN PAGE 4"); 
			}
			else{
				String errorMessage = "Wrong answer, try again!";
				JOptionPane.showMessageDialog(controller, errorMessage, "wrong answer", JOptionPane.YES_NO_OPTION);

				NumberEightsField.setText("");
				NumberTwosField.setText("");
				NumberFoursField.setText("");
				NumberOnesField.setText("");
			}

		}      
	}

	public void initButtons(){
		submitButton = new JButton("Submit"); 
		submitButton.addActionListener(new submitButtonListener());
	}


	//init swing components
	public void initComponents(){
		initTextFields();
		initRects();
		initButtons();
	}

	//this method adds the components to the panel
	public void addComponentsToPanel() {
		setLayout(null);
		add(NumberEightsField);
		add(NumberFoursField);
		add(NumberTwosField);
		add(NumberOnesField);
		add(submitButton);
		addMouseListener(this); 
	}

	//this method defines the formatting of the components on the panel
	public void formatComponents(){
		Insets insets = getInsets();
		Dimension buttonSize = submitButton.getPreferredSize();
		submitButton.setBounds(box1x +box1width + 20 + insets.left, box1y+box1height+5 + insets.top,
				buttonSize.width, buttonSize.height);

		Dimension size = NumberEightsField.getPreferredSize();
		NumberEightsField.setBounds(box8x +25 + insets.left, box8y+box8height+5 + insets.top,
				size.width, buttonSize.height);
		NumberFoursField.setBounds(box4x +25 + insets.left, box4y+box8height+5 + insets.top,
				size.width, buttonSize.height);
		NumberTwosField.setBounds(box2x +25 + insets.left, box2y+box8height+5 + insets.top,
				size.width, buttonSize.height);
		NumberOnesField.setBounds(box1x +25 + insets.left, box1y+box8height+5 + insets.top,
				size.width, buttonSize.height);
	}

	//constructor, param is the applet
	public DecToBinPage3(Controller welcome)
	{
		controller = welcome;
		setBackground(Controller.backgroundColor);
		initComponents();
		addComponentsToPanel();
		formatComponents();
		setVisible(true);
	}

	//override paint method
	public void paint(Graphics g) {
		super.paint(g);

		//change the color of the box if it is selected
		g.setColor(Controller.textColor);
		if (boxSelected1)
			g.setColor(Color.RED);
		g.drawRect(box1x,box1y,box1width,box1height);

		g.setColor(Controller.textColor);
		if (boxSelected2)
			g.setColor(Color.RED);
		g.drawRect(box2x,box2y,box2width,box2height);

		g.setColor(Controller.textColor);
		if (boxSelected4)
			g.setColor(Color.RED);
		g.drawRect(box4x,box4y,box4width,box4height);

		g.setColor(Controller.textColor);
		if (boxSelected8)
			g.setColor(Color.RED);
		g.drawRect(box8x,box8y,box8width,box8height);

		//draw the squares
		g.setColor(Controller.buttonPanelColor);
		for (int i = 0;i < squareList.size(); i++){
			g.fillRect((int)squareList.get(i).getX(),(int)squareList.get(i).getY(), squareUnit, squareUnit );
		}

		//box labels
		g.setColor(Controller.textColor);
		g.setFont(new Font("Verdana", 1, 20));
		g.drawString("EIGHTS", eightsX, eightsY);
		g.drawString("FOURS", foursX, foursY);
		g.drawString("TWOS", twosX, twosY);
		g.drawString("ONES", onesX, onesY);

		//title
		g.drawImage(controller.decBinHeadlineImg, headerX, headerY, this);


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
			g.drawString(text65, startTextX+indentTextX, startTextY+2*textYInc);
			g.drawString(text7, startTextX, startTextY+3*textYInc);
		}
		if (display3){
			g.drawString(text8, startTextX, startTextY+textYInc);
			g.drawString(text9, startTextX, startTextY+2*textYInc);
			g.drawString(text95, startTextX+indentTextX, startTextY+3*textYInc);
			g.drawString(text10, startTextX, startTextY+4*textYInc);
		}


	}

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
			if((mouseX >= box1x) && (mouseX <= (box1x + box1width)) && (mouseY >= box1y) && (mouseY <= (box1y + box1height)))
			{
				boxSelected1 = true;
				boxSelected2 = false;
				boxSelected4 = false;
				boxSelected8 = false;
				squareList.get(rectSelectedNum).setLocation(me.getX(), me.getY());

			}
			else if((mouseX >= box2x) && (mouseX <= (box2x + box2width)) && (mouseY >= box2y) && (mouseY <= (box2y + box2height)))
			{
				boxSelected1 = false;
				boxSelected2 = true;
				boxSelected4 = false;
				boxSelected8 = false;
				squareList.get(rectSelectedNum).setLocation(me.getX(), me.getY());

			}

			else if((mouseX >= box4x) && (mouseX <= (box4x + box1width)) && (mouseY >= box4y) && (mouseY <= (box4y + box4height)))
			{
				boxSelected1 = false;
				boxSelected2 = false;
				boxSelected4 = true;
				boxSelected8 = false;
				squareList.get(rectSelectedNum).setLocation(me.getX(), me.getY());

			}
			else if((mouseX >= box8x) && (mouseX <= (box8x + box8width)) && (mouseY >= box8y) && (mouseY <= (box8y + box8height)))
			{
				boxSelected1 = false;
				boxSelected2 = false;
				boxSelected4 = false;
				boxSelected8 = true;
				squareList.get(rectSelectedNum).setLocation(me.getX(), me.getY());

			}
			else {
				boxSelected1 = false;
				boxSelected2 = false;
				boxSelected4 = false;
				boxSelected8 = false;
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

	public void mouseMoved(MouseEvent me){}

	public void mouseDragged(MouseEvent me) {}


} //end class


