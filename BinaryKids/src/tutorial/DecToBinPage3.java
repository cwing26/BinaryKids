package tutorial;



import java.awt.*; 
import java.awt.event.*; 
import java.util.ArrayList;

import javax.swing.*; 

@SuppressWarnings("serial")
public class DecToBinPage3 extends JPanel implements MouseListener
{

	boolean drawStep2 = false;

	WelcomePage welcomePage;
	JButton submitButton; 

	//Labels
	JLabel DecToBinNumSquaresText;
	JLabel DecToBinNumSquaresText2;
	JLabel DecToBinNumSquaresText3;
	JLabel DecToBinNumSquaresText4;
	JLabel DecToBinNumSquaresText5;
	JLabel DecToBinNumSquaresText6;
	JLabel DecToBinNumSquaresText7;
	JLabel DecToBinNumSquaresText8;
	JLabel DecToBinNumSquaresText9;
	JLabel DecToBinNumSquaresText10;

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
	final int starty = 220;
	int DecToBinNumSquaresInput;

	//String text1 = "Now we are going to convert 11 from decimal to binary!"; // In decimal, we put 10 squares into the TENS box and";
	String text2 = "";//1 square into the ONES box. Now we will put squares into the EIGHTS, FOURS, TWOS, and ONES boxes.";
	String text3 = "Step 1: Do we have enough squares to put eight squares in the EIGHTS box? If yes, put eight squares in the";
	String text4 = "          EIGHTS box. Click on a square and then click on the box to put the square inside.";
	String text5 = "Step 2: Since we had enough squares, type 1 below the EIGHTS box.";
	String text6 = "Step 3: Check how many squares are left remaining. Do we have enough to put four squares in the FOURS box?";
	String text7 = "Step 4: Since we don't have enough, type 0 below the FOURS box.";
	String text8 = "Step 5: Keep assigning the remaining squares until none are left.";
	String text9 = "Step 6: Remember: If you had enough squares to put in a box, type 1, otherwise type 0.";
	String text10 = "Step 7: When you finish, click submit to check your answer.";



	// The X-coordinate and Y-coordinate of the last click. 
	int xpos; 
	int ypos;

	// The coordinates of the boxes
	final int box8x = 150, box8y = 280, box8width = 100, box8height = 250;
	final int box4x = 290, box4y = 280, box4width = 100, box4height = 250;
	final int box2x = 430, box2y = 280, box2width = 100, box2height = 250;
	final int box1x = 570, box1y = 280, box1width = 100, box1height = 250;


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
	ArrayList<Rectangle> recList = new ArrayList<Rectangle>();

	//Panels
	JPanel titlePanel;
	JPanel textPanel;
	JPanel questionPanel;

	//formats the title panel
	public void initTitlePanel(){
		titlePanel = new JPanel();
		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBackground(WelcomePage.backgroundColor);
		JLabel titleLabel = new JLabel("Converting Decimal to Binary");
		titleLabel.setFont(new Font("Verdana",1,20));
		titlePanel.add(titleLabel, BorderLayout.CENTER);
		//titlePanel.setBorder(new LineBorder(WelcomePage.darkBlueColor));
	}

//	//formats the question panel layout
//	public void initQuestionPanel(){
//		questionPanel = new JPanel();
//		
//		questionPanel.setLayout(new GridBagLayout());
//		questionPanel.setBackground(WelcomePage.backgroundColor);
//		GridBagConstraints c = new GridBagConstraints();
//		c.anchor = GridBagConstraints.CENTER;
//		c.fill = GridBagConstraints.HORIZONTAL;
//		c.ipadx = 40;
//		c.gridx = 0;
//		questionPanel.add(NumberEightsField,c);
//		c.gridx = 1;
//		questionPanel.add(NumberFoursField,c);
//		c.gridx = 2;
//		questionPanel.add(NumberTwosField,c);
//		c.gridx = 3;
//		questionPanel.add(NumberOnesField,c);
//		c.gridx = 4;
//		questionPanel.add(submitButton, c);
//	}

//	//sets all the texts of all Jlabels
//	public void initJLabels(){
//		DecToBinNumSquaresText = new JLabel("Now we are going to convert 11 from decimal to binary! In decimal, we put 10 squares ino ");
//		DecToBinNumSquaresText2 = new JLabel("the TENS box and 1 square into the ONES box. Now we are going to put squares into the EIGHTS, FOURS, TWOS, and ONES boxes.");
//		DecToBinNumSquaresText3 = new JLabel("Step 1: Do we have enough squares to put eight squares in the EIGHTS box? If yes, put eight squares in the");
//		DecToBinNumSquaresText4 = new JLabel("              EIGHTS box. Click on a square and then click on the box to put the square inside.");
//		DecToBinNumSquaresText5 = new JLabel("Step 2: Since we had enough squares, type 1 below the EIGHTS box.");
//		DecToBinNumSquaresText6 = new JLabel("Step 3: Check how many squares are left remaining. Do we have enough to put four squares in the FOURS box?");
//		DecToBinNumSquaresText7 = new JLabel("Step 4: Since we don't have enough, type 0 below the FOURS box.");
//		DecToBinNumSquaresText8 = new JLabel("Step 5: Keep assigning the remaining squares until none are left.");
//		DecToBinNumSquaresText9 = new JLabel("Step 6: Remember: If you had enough squares to put in a box, type 1, otherwise type 0.");
//		DecToBinNumSquaresText10 = new JLabel("Step 7: When you finish, click submit to check your answer.");
//	}

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

			if (countEights == 8
					&& countFours == 0
					&& countTwos == 2
					&& countOnes == 1){

			}
			else{
				String errorMessage = "The squares are not in the correct boxes, try again!";
				JOptionPane.showMessageDialog(welcomePage, errorMessage, "wrong answer", JOptionPane.YES_NO_OPTION);
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
	}

public void initButtons(){
	submitButton = new JButton("Submit"); 
	submitButton.addActionListener(new submitButtonListener());
}

//constructor, param is the applet
public DecToBinPage3(WelcomePage welcome)
{
	welcomePage = welcome;
	setBackground(WelcomePage.backgroundColor);


	//initializations
	//initJLabels();
	initTextFields();
	initRects();
	initButtons();
	initTitlePanel();

	setLayout(null);
	//add(titlePanel);
	add(NumberEightsField);
	add(NumberFoursField);
	add(NumberTwosField);
	add(NumberOnesField);
	add(submitButton);
	Insets insets = getInsets();
	
	
	Dimension size = NumberEightsField.getPreferredSize();
	NumberEightsField.setBounds(box8x +25 + insets.left, box8y+box8height+5 + insets.top,
            size.width, size.height);
	NumberFoursField.setBounds(box4x +25 + insets.left, box4y+box8height+5 + insets.top,
            size.width, size.height);
	NumberTwosField.setBounds(box2x +25 + insets.left, box2y+box8height+5 + insets.top,
            size.width, size.height);
	NumberOnesField.setBounds(box1x +25 + insets.left, box1y+box8height+5 + insets.top,
            size.width, size.height);

	// Add the MouseListener to the applet 
	addMouseListener(this); 
}

public void paint(Graphics g) {
	super.paint(g);

	//change the color of the box if it is selected
	g.setColor(WelcomePage.darkBlueColor);
	if (boxSelected1)
		g.setColor(Color.RED);
	g.drawRect(box1x,box1y,box1width,box1height);

	g.setColor(WelcomePage.darkBlueColor);
	if (boxSelected2)
		g.setColor(Color.RED);
	g.drawRect(box2x,box2y,box2width,box2height);

	g.setColor(WelcomePage.darkBlueColor);
	if (boxSelected4)
		g.setColor(Color.RED);
	g.drawRect(box4x,box4y,box4width,box4height);

	g.setColor(WelcomePage.darkBlueColor);
	if (boxSelected8)
		g.setColor(Color.RED);
	g.drawRect(box8x,box8y,box8width,box8height);

	//draw the squares
	g.setColor(WelcomePage.darkBlueColor);
	for (int i = 0;i < recList.size(); i++){
		g.fillRect((int)recList.get(i).getX(),(int)recList.get(i).getY(), rectUnit, rectUnit );
	}

	//box labels
	g.setFont(new Font("Verdana", 1, 20));
	g.drawString("EIGHTS", box8x+10, box8y-4);
	g.drawString("FOURS", box4x+15, box4y-4);
	g.drawString("TWOS", box2x+20, box2y-4);
	g.drawString("ONES", box1x+20, box1y-4);


	//instructions
	g.setFont(new Font("Comic Sans MS", Font.BOLD, 13));
	int startTextX = 40;
	int startTextY = 50;
	int textYInc = 18;
	
	g.drawImage(welcomePage.binDec3TitleImg, 75, 10, this);
	
	//g.drawString(text1, startTextX, startTextY);
	g.drawString(text2, startTextX, startTextY+=textYInc);
	g.drawString(text3, startTextX, startTextY+=textYInc);
	g.drawString(text4, startTextX, startTextY+=textYInc);
	g.drawString(text5, startTextX, startTextY+=textYInc);
	g.drawString(text6, startTextX, startTextY+=textYInc);
	g.drawString(text7, startTextX, startTextY+=textYInc);
	g.drawString(text8, startTextX, startTextY+=textYInc);
	g.drawString(text9, startTextX, startTextY+=textYInc);
	g.drawString(text10, startTextX, startTextY+=textYInc);


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
