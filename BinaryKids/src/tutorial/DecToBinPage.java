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
	JButton DecToBinSubmit; 
	JLabel DecToBinNumSquaresText;
	JTextField DecToBinNumSquaresField;

	final String DecToBinNumSquaresActual = "11";
	final int numSquares = 11;
	String DecToBinNumSquaresInput;

	int startx = 180;
	int starty = 100;

	final int rectUnit = 30;

	private Rectangle rec;
	ArrayList<Rectangle> recList = new ArrayList<>();

	//Panels
	JPanel titlePanel;
	JPanel textPanel;
	JPanel questionPanel;
	JPanel boxLabelPanel;

	//adds an action listener to the submit button to verify input is correct
	public void initSubmitButtonListener(){
		DecToBinSubmit.addActionListener(new ActionListener() {      
			public void actionPerformed(ActionEvent le) {  
				DecToBinNumSquaresInput = DecToBinNumSquaresField.getText();
				if (DecToBinNumSquaresInput.equals(DecToBinNumSquaresActual)){
					welcomePage.loadDecBin2();
				}
				else{
					String errorMessage = "Wrong answer, try again!";
					JOptionPane.showMessageDialog(welcomePage, errorMessage, "wrong answer", JOptionPane.YES_NO_OPTION);

					DecToBinNumSquaresField.setText("");

				}

			}      
		}); 
	}

	//init title panel format
	public void initTitlePanel(){
		titlePanel = new JPanel();
		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBackground(WelcomePage.backgroundColor);
		JLabel titleLabel = new JLabel("Let's learn how to convert decimal to binary!");
		titleLabel.setFont(new Font("Verdana",1,20));
		titlePanel.add(titleLabel, BorderLayout.CENTER);
		//titlePanel.setBorder(new LineBorder(Color.BLACK));
	}

	//formats the text panel layout
	public void initTextPanel(){
		textPanel = new JPanel();
		textPanel.setBackground(WelcomePage.backgroundColor);
		textPanel.setLayout(new GridBagLayout());
		GridBagConstraints c = new GridBagConstraints();
		c.fill = GridBagConstraints.HORIZONTAL;
		c.ipady = 50;
		c.gridx = 0;
		c.gridy = 0;
		textPanel.add(DecToBinNumSquaresText, c);
		c.gridx = 1;
		c.gridy = 0;
		textPanel.add(DecToBinNumSquaresField);
		c.gridx = 0;
		c.gridy = 1;
		c.gridwidth = 2;
		textPanel.add(DecToBinSubmit);
	}
	
	//init swing components
	public void initComponents(){
		DecToBinNumSquaresText = new JLabel("How many squares are shown?");
		DecToBinNumSquaresField = new JTextField();
		DecToBinNumSquaresField.setColumns(5);
		DecToBinSubmit = new JButton("Submit"); 
	}

	//constructor, param is the applet
	public DecToBinPage(WelcomePage welcome)
	{
		welcomePage = welcome;
		setBackground(WelcomePage.backgroundColor);
		
		//initializations
		initComponents();
		initTitlePanel();
		initTextPanel();
		initSubmitButtonListener();
		initRects();

		//add panels
		add(titlePanel);
		add(textPanel);


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
		for (int i = 0;i < recList.size(); i++){
			if (i%2 == 1){
				g.setColor(new Color(153, 178, 191));
			}
			else{
				g.setColor(new Color (255, 204, 208));
			}
			g.fillRect((int)recList.get(i).getX(),(int)recList.get(i).getY(), rectUnit, rectUnit );
		}
	}



} //end class
