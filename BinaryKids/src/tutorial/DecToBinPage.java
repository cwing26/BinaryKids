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

public class DecToBinPage extends JPanel
{

	WelcomePage welcomePage;
	JButton DecToBinSubmit; 
	JLabel DecToBinNumSquaresText;
	JTextField DecToBinNumSquaresField;

	final int DecToBinNumSquaresActual = 11;
	int DecToBinNumSquaresInput;
	private ImageIcon boxIcon;
	private Image img;
	private Rectangle rec;
	int startx = 60;
	int starty = 100;

	final int rectUnit = 30;

	ArrayList<Rectangle> recList = new ArrayList<>();
	
	public DecToBinPage(WelcomePage welcome)
	{
		welcomePage = welcome;


		JPanel titlePanel = new JPanel();
		JLabel titleLabel = new JLabel("Let's learn how to convert decimal to binary!");
		titleLabel.setFont(new Font("Verdana",1,20));
		titlePanel.add(titleLabel);
		titlePanel.setBorder(new LineBorder(Color.BLACK)); 


		DecToBinSubmit = new JButton("Submit Answer"); 
		DecToBinNumSquaresField = new JTextField();
		DecToBinNumSquaresField.setColumns(20);
		DecToBinNumSquaresText = new JLabel("How many squares are there?");


		//Add action listeners for the buttons. 
		DecToBinSubmit.addActionListener(new ActionListener() {      
			public void actionPerformed(ActionEvent le) {  
				String input = DecToBinNumSquaresField.getText();
				DecToBinNumSquaresInput = Integer.parseInt(input);
				if (DecToBinNumSquaresInput == DecToBinNumSquaresActual){
					welcomePage.loadDecBin2();
				}
				else{
					String errorMessage = "Wrong answer, try again!";
			    	JOptionPane.showMessageDialog(welcomePage, errorMessage, "wrong answer", JOptionPane.YES_NO_OPTION);
			    	
			    	DecToBinNumSquaresField.setText("");
			    	
				}

			}      
		});      


		add(titlePanel);
		add(DecToBinNumSquaresText);
		add(DecToBinNumSquaresField);
		add(DecToBinSubmit);

		for (int i = 0; i < DecToBinNumSquaresActual; i++){
			//g.drawImage(img, startx, starty, this);

			rec = new Rectangle(startx, starty, rectUnit,rectUnit);
			recList.add(rec);
			startx+=40;
		}
	
	
	}

	public void paint(Graphics g) {
		super.paint(g);
		//drawBoxes(DecToBinNumSquaresActual, g);
		for (int i = 0;i < recList.size(); i++){
			g.fillRect((int)recList.get(i).getX(),(int)recList.get(i).getY(), rectUnit, rectUnit );
		}
	}



} //end class
