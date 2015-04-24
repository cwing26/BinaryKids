package tutorial;



import java.awt.*; 
import java.awt.event.*; 
import java.util.ArrayList;

import javax.swing.*; 

@SuppressWarnings("serial")
public class DecToBinPage3 extends JPanel implements MouseListener
{

	WelcomePage welcomePage;
	JButton DecToBinSubmit; 
	
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

	//formats the text panel layout
	public void initTextPanel(){
		textPanel = new JPanel();
		textPanel.setLayout(new GridBagLayout());
		textPanel.setBackground(WelcomePage.backgroundColor);
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
		c.gridy = 3;
		textPanel.add(DecToBinNumSquaresText4, c);
		c.gridy = 4;
		textPanel.add(DecToBinNumSquaresText5, c);
		c.gridy = 5;
		textPanel.add(DecToBinNumSquaresText6, c);
		c.gridy = 6;
		textPanel.add(DecToBinNumSquaresText7, c);
		c.gridy = 7;
		textPanel.add(DecToBinNumSquaresText8, c);
		c.gridy = 8;
		textPanel.add(DecToBinNumSquaresText9, c);
		c.gridy = 9;
		textPanel.add(DecToBinNumSquaresText10, c);
	}

	//formats the question panel layout
	public void initQuestionPanel(){
		questionPanel = new JPanel();
		questionPanel.setLayout(new GridBagLayout());
		questionPanel.setBackground(WelcomePage.backgroundColor);
		GridBagConstraints c = new GridBagConstraints();
		c.anchor = GridBagConstraints.CENTER;
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 10;
		questionPanel.add(DecToBinSubmit, c);
	}

	//sets all the texts of all Jlabels
	public void initJLabels(){
		DecToBinNumSquaresText = new JLabel("Now we are going to convert 11 from decimal to binary! In decimal, we put 10 squares ino ");
		DecToBinNumSquaresText2 = new JLabel("the TENS box and 1 square into the ONES box. Now we are going to put squares into the EIGHTS, FOURS, TWOS, and ONES boxes.");
		DecToBinNumSquaresText3 = new JLabel("Step 1: Do we have enough squares to put eight squares in the EIGHTS box? If yes, put eight squares in the");
		DecToBinNumSquaresText4 = new JLabel("              EIGHTS box. Click on a square and then click on the box to put the square inside.");
		DecToBinNumSquaresText5 = new JLabel("Step 2: Since we had enough squares, type 1 below the EIGHTS box.");
		DecToBinNumSquaresText6 = new JLabel("Step 3: Check how many squares are left remaining. Do we have enough to put four squares in the FOURS box?");
		DecToBinNumSquaresText7 = new JLabel("Step 4: Since we don't have enough, type 0 below the FOURS box.");
		DecToBinNumSquaresText8 = new JLabel("Step 5: Keep assigning the remaining squares until none are left.");
		DecToBinNumSquaresText9 = new JLabel("Step 6: Remember: If you had enough squares to put in a box, type 1, otherwise type 0.");
		DecToBinNumSquaresText10 = new JLabel("Step 7: When you finish, click submit to check your answer.");
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

	//adds an action listener to the submit button to verify input is correct
	public void initSubmitButtonListener(){
		DecToBinSubmit.addActionListener(new ActionListener() {      
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
		});  
	}



	//constructor, param is the applet
	public DecToBinPage3(WelcomePage welcome)
	{
		welcomePage = welcome;
		setBackground(WelcomePage.backgroundColor);
		DecToBinSubmit = new JButton("Submit"); 

		//initializations
		initJLabels();
		initTextFields();
		initTitlePanel();
		initTextPanel();
		initQuestionPanel();
		initRects();
		initSubmitButtonListener();   	

		//add panels
		add(titlePanel);
		add(textPanel);
		add(questionPanel);

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
