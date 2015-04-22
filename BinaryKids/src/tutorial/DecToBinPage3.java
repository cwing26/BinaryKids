package tutorial;

import javax.imageio.ImageIO;
import javax.swing.*; 

import java.awt.*; 
import java.awt.event.*; 
import java.io.File;
import java.io.IOException;
import java.util.ArrayList;

import javax.swing.JPanel;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class DecToBinPage3 extends JPanel implements MouseListener
{

	WelcomePage welcomePage;
	JButton DecToBinSubmit; 
	
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
	
	//TextFields
	JTextField NumberEightsField;
	JTextField NumberFoursField;
	JTextField NumberTwosField;
	JTextField NumberOnesField;

	String numEightsInput;
	String numFoursInput;
	String numTwosInput;
	String numOnesInput;
	final String numEightsActual = "1";
	final String numFoursActual = "0";
	final String numTwosActual = "1";
	final String numOnesActual = "1";

	final int DecToBinNumSquaresActual = 11;
	final int startx = 200;
	final int starty = 180;
	int DecToBinNumSquaresInput;
	


	// The X-coordinate and Y-coordinate of the last click. 
	int xpos; 
	int ypos;

	// The coordinates of the boxes
	int box8x, box8y, box8width, box8height;
	int box4x, box4y, box4width, box4height;
	int box2x, box2y, box2width, box2height;
	int box1x, box1y, box1width, box1height;

	//flags for boxes and rectangles
	boolean boxSelected8 = false;
	boolean boxSelected4 = false;
	boolean boxSelected2 = false;
	boolean boxSelected1 = false;
	boolean rectSelected = false;
	int rectSelectedNum = 0;
	
	//rectangle width and height
	final int rectUnit = 30;
	private Rectangle rec;
	ArrayList<Rectangle> recList = new ArrayList<>();
	
	//Panels
	JPanel titlePanel;
	JPanel textPanel;
	JPanel questionPanel;
	JPanel boxLabelPanel;

	//formats the title panel
	public void initTitlePanel(){
		titlePanel = new JPanel();
		titlePanel.setLayout(new BorderLayout());
		JLabel titleLabel = new JLabel("Converting Decimal to Binary");
		titleLabel.setFont(new Font("Verdana",1,20));
		titlePanel.add(titleLabel, BorderLayout.CENTER);
		titlePanel.setBorder(new LineBorder(Color.BLACK));
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
		questionPanel.add(TextHowManyEights, c2);
		c2.gridx = 1;
		c2.gridy = 0;
		questionPanel.add(NumberEightsField, c2);
		c2.gridx = 2;
		c2.gridy = 0;
		questionPanel.add(TextHowManyFours, c2);
		c2.gridx = 3;
		c2.gridy = 0;
		questionPanel.add(NumberFoursField, c2);
		c2.gridx = 0;
		c2.gridy = 1;
		questionPanel.add(TextHowManyTwos, c2);
		c2.gridx = 1;
		c2.gridy = 1;
		questionPanel.add(NumberTwosField, c2);
		c2.gridx = 2;
		c2.gridy = 1;
		questionPanel.add(TextHowManyOnes, c2);
		c2.gridx = 3;
		c2.gridy = 1;
		questionPanel.add(NumberOnesField, c2);
		c2.gridx = 0;
		c2.gridy = 2;
		c2.gridwidth = 4;
		questionPanel.add(DecToBinSubmit, c2);
	}

	//sets all the texts of all Jlabels
	public void initJLabels(){
		TextEights = new JLabel("Eights");
		TextFours = new JLabel("Fours");
		TextTwos = new JLabel("Twos");
		TextOnes = new JLabel("Ones");
		TextHowManyEights = new JLabel("How many EIGHTS are there in 11?");
		TextHowManyFours = new JLabel("How many FOURS are there in 11?");
		TextHowManyTwos = new JLabel("How many TWOS are there in 11?");
		TextHowManyOnes = new JLabel("How many ONES are there in 11?");
		DecToBinNumSquaresText = new JLabel("Now let's see visually how to represent 11 in binary (base 2)! Click on a square and then click ");
		DecToBinNumSquaresText2 = new JLabel("inside one of the boxes to assign the square to the box. Distribute squares to the largest box");
		DecToBinNumSquaresText3 = new JLabel("possible, starting from the left.");
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
	}

	//inits the coords of the rects that user will move
	public void initRects(){
		int startX = startx;
		for (int i = 0; i < DecToBinNumSquaresActual; i++){
			rec = new Rectangle(startX, starty, rectUnit,rectUnit);
			recList.add(rec);
			startX+=40;
		}
	}

	//formats the labels for the boxes
	public void initBoxLabelPanel(){
		boxLabelPanel = new JPanel();
		boxLabelPanel.setLayout(new GridBagLayout());
		GridBagConstraints c3 = new GridBagConstraints();
		c3.anchor = GridBagConstraints.FIRST_LINE_START;
		c3.insets = new Insets(70,40,0,0);
		c3.fill = GridBagConstraints.HORIZONTAL;
		c3.ipadx = 60;
		boxLabelPanel.add(TextEights,c3);
		boxLabelPanel.add(TextFours,c3);
		boxLabelPanel.add(TextTwos,c3);
		boxLabelPanel.add(TextOnes,c3);

	}

	//adds an action listener to the submit button to verify input is correct
	public void initSubmitButtonListener(){
		DecToBinSubmit.addActionListener(new ActionListener() {      
			public void actionPerformed(ActionEvent le) {  
				numEightsInput = NumberEightsField.getText();
				numFoursInput = NumberFoursField.getText();
				numTwosInput = NumberTwosField.getText();
				numOnesInput = NumberOnesField.getText();

				if (numEightsInput.equals(numEightsActual)
						&& numFoursInput.equals(numFoursActual)
						&& numTwosInput.equals(numTwosActual)
						&& numOnesInput.equals(numOnesActual)   ){
						welcomePage.loadDecBin4(); 
				}
				else{
					String errorMessage = "Wrong answer, try again!";
					JOptionPane.showMessageDialog(welcomePage, errorMessage, "wrong answer", JOptionPane.YES_NO_OPTION);

					NumberEightsField.setText("");
					NumberTwosField.setText("");
					NumberFoursField.setText("");
					NumberOnesField.setText("");
				}

			}      
		});  
	}

	//init the coords of the boxes will move rects into
	public void initBoxCoords(){
		box8x = 150; 
		box8y = 260; 
		box8width = 100; 
		box8height = 300;

		box4x = 290; 
		box4y = 260; 
		box4width = 100; 
		box4height = 300;


		box2x = 430; 
		box2y = 260; 
		box2width = 100; 
		box2height = 300;

		box1x = 570; 
		box1y = 260; 
		box1width= 100; 
		box1height = 300;

	}


	//constructor, param is the applet
	public DecToBinPage3(WelcomePage welcome)
	{
		welcomePage = welcome;
		DecToBinSubmit = new JButton("Submit"); 

		//initializations
		initJLabels();
		initTextFields();
		initTitlePanel();
		initTextPanel();
		initQuestionPanel();
		initRects();
		initBoxLabelPanel();
		initSubmitButtonListener();
		initBoxCoords();    	

		//add panels
		add(titlePanel);
		add(textPanel);
		add(questionPanel);
		add(boxLabelPanel);

		// Add the MouseListener to the applet 
		addMouseListener(this); 
	}

	public void paint(Graphics g) {
		super.paint(g);
		
		//change the color of the box if it is selected
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
		for (int i = 0;i < recList.size(); i++){
			g.fillRect((int)recList.get(i).getX(),(int)recList.get(i).getY(), rectUnit, rectUnit );
		}
	}

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
			if((xpos >= box1x) && (xpos <= (box1x + box1width)) && (ypos >= box1y) && (ypos <= (box1y + box1height)))
			{
				boxSelected1 = true;
				boxSelected2 = false;
				boxSelected4 = false;
				boxSelected8 = false;
				recList.get(rectSelectedNum).setLocation(me.getX(), me.getY());

			}
			else if((xpos >= box2x) && (xpos <= (box2x + box2width)) && (ypos >= box2y) && (ypos <= (box2y + box2height)))
			{
				boxSelected1 = false;
				boxSelected2 = true;
				boxSelected4 = false;
				boxSelected8 = false;
				recList.get(rectSelectedNum).setLocation(me.getX(), me.getY());

			}

			else if((xpos >= box4x) && (xpos <= (box4x + box1width)) && (ypos >= box4y) && (ypos <= (box4y + box4height)))
			{
				boxSelected1 = false;
				boxSelected2 = false;
				boxSelected4 = true;
				boxSelected8 = false;
				recList.get(rectSelectedNum).setLocation(me.getX(), me.getY());

			}
			else if((xpos >= box8x) && (xpos <= (box8x + box8width)) && (ypos >= box8y) && (ypos <= (box8y + box8height)))
			{
				boxSelected1 = false;
				boxSelected2 = false;
				boxSelected4 = false;
				boxSelected8 = true;
				recList.get(rectSelectedNum).setLocation(me.getX(), me.getY());

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
