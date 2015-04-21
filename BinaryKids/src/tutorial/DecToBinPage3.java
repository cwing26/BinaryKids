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
	int DecToBinNumSquaresInput;
	private Rectangle rec;

	// The X-coordinate and Y-coordinate of the last click. 
	int xpos; 
	int ypos;

	// The coordinates of the boxes
	int box8x, box8y, box8width, box8height;
	int box4x, box4y, box4width, box4height;
	int box2x, box2y, box2width, box2height;
	int box1x, box1y, box1width, box1height;

	int rectSelectedNum = 0;
	boolean boxSelected8 = false;
	boolean boxSelected4 = false;
	boolean boxSelected2 = false;
	boolean boxSelected1 = false;
	boolean rectSelected = false;

	final int rectUnit = 30;

	ArrayList<Image> imgList = new ArrayList<>();
	ArrayList<Rectangle> recList = new ArrayList<>();

	public DecToBinPage3(WelcomePage welcome)
	{
		welcomePage = welcome;

		int startx = 60;
		int starty = 100;

		JPanel titlePanel = new JPanel();
		titlePanel.setLayout(new BorderLayout());
		JLabel titleLabel = new JLabel("Converting Decimal to Binary");
		titleLabel.setFont(new Font("Verdana",1,20));
		titlePanel.add(titleLabel, BorderLayout.CENTER);
		titlePanel.setBorder(new LineBorder(Color.BLACK)); 
		
		
		
		TextEights = new JLabel("Eights");
		TextFours = new JLabel("Fours");
		TextTwos = new JLabel("Twos");
		TextOnes = new JLabel("Ones");
		TextHowManyEights = new JLabel("How many EIGHTS are there in 11?");
		TextHowManyFours = new JLabel("How many FOURS are there in 11?");
		TextHowManyTwos = new JLabel("How many TWOS are there in 11?");
		TextHowManyOnes = new JLabel("How many ONES are there in 11?");
		NumberEightsField = new JTextField();
		NumberFoursField = new JTextField();
		NumberTwosField = new JTextField();
		NumberOnesField = new JTextField();
		NumberEightsField.setColumns(5);
		NumberFoursField.setColumns(5);
		NumberTwosField.setColumns(5);
		NumberOnesField.setColumns(5);
		
		DecToBinSubmit = new JButton("Next Page"); 
		DecToBinNumSquaresText = new JLabel("Now let's see visually how to represent 11 in binary (base 2)!");
		DecToBinNumSquaresText2 = new JLabel("Click on a square and then click "
				+ "inside one of the boxes to assign the square to the box.");

		DecToBinNumSquaresText3 = new JLabel("You should assign squares to the largest box possible, starting from the left.");

		
		JPanel textPanel = new JPanel();
		textPanel.setLayout(new GridLayout(0,1));
		textPanel.add(DecToBinNumSquaresText);
		textPanel.add(DecToBinNumSquaresText2);
		textPanel.add(DecToBinNumSquaresText3);
		
		
		for (int i = 0; i < DecToBinNumSquaresActual; i++){
			//g.drawImage(img, startx, starty, this);

			rec = new Rectangle(startx, starty, rectUnit,rectUnit);
			recList.add(rec);
			startx+=40;
		}

		

		//Add action listeners for the buttons. 
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
					//welcomePage.loadDecBin4();  //fix here
				}
				else{
					String errorMessage = "Wrong answer, try again!";
					JOptionPane.showMessageDialog(welcomePage, errorMessage, "wrong answer", JOptionPane.YES_NO_OPTION);

					NumberEightsField.setText("");
					NumberOnesField.setText("");
				}

			}      
		});      


		

		add(titlePanel);
		add(textPanel);
//		add(DecToBinNumSquaresText);
//		add(DecToBinNumSquaresText2);
//		add(DecToBinNumSquaresText3);
		

		add(TextHowManyEights);
		add(NumberEightsField);
		add(TextHowManyFours);
		add(NumberFoursField);
		add(TextHowManyTwos);
		add(NumberTwosField);
		add(TextHowManyOnes);
		add(NumberOnesField);
		add(DecToBinSubmit);

		add(TextEights);
		add(TextFours);
		add(TextTwos);
		add(TextOnes);


		// Assign values to the rectanagle coordinates. 
		box8x = 60; 
		box8y = 160; 
		box8width = 100; 
		box8height = 400;
		
		// Assign values to the rectanagle coordinates. 
		box4x = 200; 
		box4y = 160; 
		box4width = 100; 
		box4height = 400;


		// Assign values to the rectanagle coordinates. 
		box2x = 340; 
		box2y = 160; 
		box2width = 100; 
		box2height = 400;

		// Assign values to the rectanagle coordinates. 
		box1x = 480; 
		box1y = 160; 
		box1width= 100; 
		box1height = 400;

		// Add the MouseListener to your applet 
		addMouseListener(this); 


	}

	public void paint(Graphics g) {
		super.paint(g);
		//drawBoxes(DecToBinNumSquaresActual, g);
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
			if((xpos >= box2x) && (xpos <= (box2x + box2width)) && (ypos >= box2y) && (ypos <= (box2y + box2height)))
			{
				boxSelected4 = false;
				boxSelected8 = false;
				boxSelected2 = true;
				boxSelected1 = false;
				recList.get(rectSelectedNum).setLocation(me.getX(), me.getY());
				//imgList.get(rectSelectedNum).

			}
			else if((xpos >= box1x) && (xpos <= (box1x + box1width)) && (ypos >= box1y) && (ypos <= (box1y + box1height)))
			{
				boxSelected1 = true;
				boxSelected2 = false;
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
				boxSelected2 = false;
				boxSelected1 = false;
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
