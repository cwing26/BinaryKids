package tutorial;
import javax.swing.*; 

import java.awt.*; 
import java.awt.event.*; 
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DecToBinPage extends JPanel
{

	WelcomePage welcomePage;
	String questionText = "How many squares are shown?";
	JButton submitButton;
	JTextField answerField;

	final String DecToBinNumSquaresActual = "11";
	final int numSquares = 11;
	String DecToBinNumSquaresInput;

	int startx = 180;
	int starty = 100;

	final int rectUnit = 30;

	private Rectangle rec;
	ArrayList<Rectangle> recList = new ArrayList<>();

	
	class submitButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent le) {  
			DecToBinNumSquaresInput = answerField.getText();
			if (DecToBinNumSquaresInput.equals(DecToBinNumSquaresActual)){
				welcomePage.loadDecBin2();
			}
			else{
				String errorMessage = "Wrong answer, try again!";
				JOptionPane.showMessageDialog(welcomePage, errorMessage, "wrong answer", JOptionPane.YES_NO_OPTION);

				answerField.setText("");

			}

		} 
	}

	
	//init swing components
	public void initComponents(){
		answerField = new JTextField();
		answerField.setColumns(5);
		submitButton = new JButton("Submit");
		submitButton.addActionListener(new submitButtonListener());
	}

	//constructor, param is the applet
	public DecToBinPage(WelcomePage welcome)
	{
		welcomePage = welcome;
		setBackground(WelcomePage.backgroundColor);
		setLayout(null);
		Insets insets = getInsets();
		
		//initializations
		initComponents();
		initRects();

		add(answerField);
    	add(submitButton);
    	
    	Dimension buttonSize = submitButton.getPreferredSize();
		submitButton.setBounds(400 + insets.left, 230 + insets.top,
				buttonSize.width, buttonSize.height);
		
		Dimension answerSize = answerField.getPreferredSize();
		answerField.setBounds(320 + insets.left, 230 + insets.top,
				answerSize.width, buttonSize.height);
		
		setVisible(true);


	}

	//inits the coords of the rects that user will move
	public void initRects(){
		for (int i = 0; i < numSquares; i++){
			rec = new Rectangle(startx, starty, rectUnit,rectUnit);
			recList.add(rec);
			startx+=40;
		}
	}

	public void paint(Graphics g) {
		super.paint(g);
		
		//draw title text
    	g.drawImage(welcomePage.binDec3TitleImg, 90, 15, this);
		
    	//draw squares
		for (int i = 0;i < recList.size(); i++){
			if (i%2 == 1){
				g.setColor(new Color(153, 178, 191));
			}
			else{
				g.setColor(new Color (255, 204, 208));
			}
			g.fillRect((int)recList.get(i).getX(),(int)recList.get(i).getY(), rectUnit, rectUnit );
		}
		
		//question text
    	g.setFont(new Font("Geneva",1,20));
    	g.setColor(WelcomePage.textColor);
    	g.drawString(questionText, 250, 200);
	}



} //end class
