package tutorial;

 
import java.awt.*; 
import java.awt.event.*; 
import java.util.ArrayList;

import javax.swing.*;
import javax.swing.border.LineBorder;

@SuppressWarnings("serial")
public class DecToBinPage2 extends JPanel implements ActionListener 
{
	
	
	private Timer timer;
	private int DELAY = 1000;
	
	WelcomePage welcomePage;
	JButton submitButton; 
	JButton startButton;
	JLabel DecToBinNumSquaresText;
	JLabel DecToBinNumSquaresText2;
	JLabel DecToBinNumSquaresText3;
	JLabel DecToBinNumSquaresText4;
	JLabel DecToBinNumSquaresText5;
	JLabel TextTens;
	JLabel TextOnes;
	JLabel TextHowManyTens;
	JLabel TextHowManyOnes;
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
	int box10x, box10y, box10width, box10height;
	int box1x, box1y, box1width, box1height;

	//flags to see which box and squares selected
	boolean boxSelected10 = false;
	boolean boxSelected1 = false;
	boolean rectSelected = false;
	int rectSelectedNum = 0;

	//width and height of sqare
	final int rectUnit = 30;
	//starting location to draw squares
	final int startx = 180;
	final int starty = 200;
	//coordinate list for the squares
	ArrayList<Integer> xCoordList =  new ArrayList<Integer>();
	ArrayList<Integer> yCoordList =  new ArrayList<Integer>();

	
	private Rectangle rec;
	ArrayList<Rectangle> recList = new ArrayList<Rectangle>();


	//Panels
	JPanel titlePanel;
	JPanel textPanel;
	JPanel questionPanel;
	JPanel boxLabelPanel;

	int globalI = 0;
	
	@Override
    public void actionPerformed(ActionEvent e) {
		if (globalI < recList.size()){
			recList.get(globalI).setLocation(xCoordList.get(globalI), yCoordList.get(globalI));
			globalI++;
		}
		else{
			DecToBinNumSquaresText4.setVisible(true);
			DecToBinNumSquaresText5.setVisible(true);
			questionPanel.setVisible(true);
			timer.stop();
		}

        repaint();
    }
	
	
	//formats the title panel
	public void initTitlePanel(){
		titlePanel = new JPanel();
		titlePanel.setLayout(new BorderLayout());
		JLabel titleLabel = new JLabel("Converting Decimal to Binary");
		titleLabel.setFont(new Font("Verdana",1,20));
		titlePanel.add(titleLabel, BorderLayout.CENTER);
		titlePanel.setBorder(new LineBorder(Color.BLACK));
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
		int y = 250;
		for (int i = 0; i < 5; i++){
			xCoordList.add(220);
			yCoordList.add(y);
			y = y + 10 + rectUnit;
		}
		y=250;
		for (int i = 0; i < 5; i++){
			xCoordList.add(260);
			yCoordList.add(y);
			y = y + 10 + rectUnit;
		}
		xCoordList.add(410);
		yCoordList.add(250);
		
	}

	public void initBoxCoords(){
		box10x = 210; 
		box10y = 240; 
		box10width = 150; 
		box10height = 300;

		box1x = 400; 
		box1y = 240; 
		box1width= 150; 
		box1height = 300;	
	}
	
	class submitButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent le) {  
			numTensInput = NumberTensField.getText();
			numOnesInput = NumberOnesField.getText();

			if (numTensInput.equals(numTensActual) && numOnesInput.equals(numOnesActual)){
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
		} 
	}

	public void initJLabels(){
		TextTens = new JLabel("Tens");
		TextOnes = new JLabel("Ones");
		TextHowManyTens = new JLabel("How many TENS are there in 11?");
		TextHowManyOnes = new JLabel("How many ONES are there in 11?");
		DecToBinNumSquaresText = new JLabel("How do we get the number 11? 11 = how many tens + how many ones? Click on a square and then click");
		DecToBinNumSquaresText2 = new JLabel("in one of the boxes to assign the square to the box. Distribute squares to the largest box possible, ");
		DecToBinNumSquaresText3 = new JLabel("starting from the left. Let's do this example together!! Click the start button to begin.");
		DecToBinNumSquaresText4 = new JLabel("11 = 1x10 + 1x1. We first moved ten squares into the TENS box. After doing so, there was only one square left,");
		DecToBinNumSquaresText5 = new JLabel("which we then moved into the ONES box. Enter 1 ten and 1 one in the boxes above and then click submit.");
	}

	public void initTextFields(){
		NumberTensField = new JTextField();
		NumberOnesField = new JTextField();
		NumberTensField.setColumns(5);
		NumberOnesField.setColumns(5);
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
		c.gridy = 3;
		textPanel.add(startButton, c);
		
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
		questionPanel.add(TextHowManyTens, c2);
		c2.gridx = 1;
		c2.gridy = 0;
		questionPanel.add(NumberTensField, c2);
		c2.gridx = 2;
		c2.gridy = 0;
		questionPanel.add(TextHowManyOnes, c2);
		c2.gridx = 3;
		c2.gridy = 0;
		questionPanel.add(NumberOnesField, c2);
		c2.gridx = 0;
		c2.gridy = 1;
		c2.gridwidth = 4;
		questionPanel.add(submitButton, c2);
		c2.gridy = 2;
		questionPanel.add(DecToBinNumSquaresText4, c2);
		c2.gridy = 3;
		questionPanel.add(DecToBinNumSquaresText5, c2);
		DecToBinNumSquaresText4.setVisible(false);
		DecToBinNumSquaresText5.setVisible(false);
	}


	//formats the labels for the boxes
	public void initBoxLabelPanel(){
		boxLabelPanel = new JPanel();
		boxLabelPanel.setLayout(new GridBagLayout());
		GridBagConstraints c3 = new GridBagConstraints();
		c3.anchor = GridBagConstraints.FIRST_LINE_START;
		c3.insets = new Insets(50,40,0,0);
		c3.fill = GridBagConstraints.HORIZONTAL;
		c3.ipadx = 100;
		boxLabelPanel.add(TextTens,c3);
		boxLabelPanel.add(TextOnes,c3);

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
		//timer.setInitialDelay(INITIAL_DELAY);
        //timer.start();
		welcomePage = welcome;

		//initializations
		initJLabels();
		initButtons();
		initTextFields();
		initTitlePanel();
		initTextPanel();
		initQuestionPanel();
		initRects();
		initBoxLabelPanel();
		initBoxCoords();  

		//add panels
		add(titlePanel);
		add(textPanel);
		add(questionPanel);
		add(boxLabelPanel);

		questionPanel.setVisible(false);
		// Add the MouseListener to your applet 
		//addMouseListener(this); 


	}

	public void paint(Graphics g) {
		super.paint(g);
		//drawBoxes(DecToBinNumSquaresActual, g);
		if (boxSelected1)
			g.setColor(Color.RED);
		g.drawRect(box1x,box1y,box1width,box1height);
		g.setColor(Color.BLACK);
		if (boxSelected10)
			g.setColor(Color.RED);
		g.drawRect(box10x,box10y,box10width,box10height);
		//Graphics2D g2d = (Graphics2D) g.create();
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
			if((xpos >= box10x) && (xpos <= (box10x + box10width)) && (ypos >= box10y) && (ypos <= (box10y + box10height)))
			{
				boxSelected10 = true;
				boxSelected1 = false;
				recList.get(rectSelectedNum).setLocation(me.getX(), me.getY());

			}
			else if((xpos >= box1x) && (xpos <= (box1x + box1width)) && (ypos >= box1y) && (ypos <= (box1y + box1height)))
			{
				boxSelected1 = true;
				boxSelected10 = false;
				recList.get(rectSelectedNum).setLocation(me.getX(), me.getY());

			}
			else {
				boxSelected10 = false;
				boxSelected1 = false;
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
