//this class is the first page in the decimal to binary tutorial

package tutorial;
import javax.swing.*; 

import java.awt.*; 
import java.awt.event.*; 
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DecToBinPage extends JPanel
{
	//applet
	private WelcomePage welcomePage;

	//headline coords
	private final int headlineX = 90, headlineY = 15;

	//this panel's components
	private final String questionText = "How many squares are shown?";
	private final int questionTextX = 250, questionTextY = 200;
	private JButton submitButton;
	private final int submitButtonX = 400, submitButtonY = 230;
	private JTextField answerField;
	private final int answerFieldX = 320, answerFieldY = 230;

	//variables relating to the drawn squares
	private final String DecToBinNumSquaresActual = "11";
	private final int numSquares = 11;
	private String DecToBinNumSquaresInput;
	private final int startXSquare = 180;
	private final int startYSquare = 100;

	//width and height of square
	private final int squareUnit = 30;
	private Rectangle rec;
	private ArrayList<Rectangle> squareList = new ArrayList<>();

	//constructor, param is the applet
	public DecToBinPage(WelcomePage welcome)
	{
		welcomePage = welcome;
		setBackground(WelcomePage.backgroundColor);

		initComponents();	
		addComponentsToPanel();
		formatComponents();

		setVisible(true);
	}

	//init swing components
	public void initComponents(){
		initSquares();
		answerField = new JTextField();
		answerField.setColumns(5);
		submitButton = new JButton("Submit");
		submitButton.addActionListener(new submitButtonListener());
	}

	//this method adds the components to the panel
	public void addComponentsToPanel() {
		setLayout(null);
		add(answerField);
		add(submitButton);
	}

	//this method defines the formatting of the components on the panel
	public void formatComponents(){
		Insets insets = getInsets();

		Dimension buttonSize = submitButton.getPreferredSize();
		submitButton.setBounds(submitButtonX + insets.left, submitButtonY + insets.top,
				buttonSize.width, buttonSize.height);

		Dimension answerSize = answerField.getPreferredSize();
		answerField.setBounds(answerFieldX + insets.left, answerFieldY + insets.top,
				answerSize.width, buttonSize.height);
	}

	//inits the coords of the rects that user will move
	public void initSquares(){
		int startx = startXSquare;
		for (int i = 0; i < numSquares; i++){
			rec = new Rectangle(startx, startYSquare, squareUnit,squareUnit);
			squareList.add(rec);
			startx+=40;
		}
	}

	//override paint method
	public void paint(Graphics g) {
		super.paint(g);

		//draw title text
		g.drawImage(welcomePage.decBinHeadlineImg, headlineX, headlineY, this);

		//draw squares alternating colors
		for (int i = 0;i < squareList.size(); i++){
			if (i%2 == 1){
				g.setColor(new Color(153, 178, 191));
			}
			else{
				g.setColor(new Color (255, 204, 208));
			}
			g.fillRect((int)squareList.get(i).getX(),(int)squareList.get(i).getY(), squareUnit, squareUnit );
		}

		//question text
		g.setFont(new Font("Geneva",1,20));
		g.setColor(WelcomePage.textColor);
		g.drawString(questionText, questionTextX, questionTextY);
	}

	//class defines action listener for submit button
	class submitButtonListener implements ActionListener 
	{
		//this method handles when the button is clicked
		public void actionPerformed(ActionEvent le) {  
			//verify input against correct answer, if correct load next page
			DecToBinNumSquaresInput = answerField.getText();
			if (DecToBinNumSquaresInput.equals(DecToBinNumSquaresActual)){
				welcomePage.loadCard("DEC BIN PAGE 2");
			}
			//if incorrect, display error message and reset textfield
			else{
				String errorMessage = "Wrong answer, try again!";
				JOptionPane.showMessageDialog(welcomePage, errorMessage, "wrong answer", JOptionPane.YES_NO_OPTION);

				answerField.setText("");

			}

		} 
	}

} //end class
