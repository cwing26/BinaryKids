package tutorial;

import javax.swing.*; 

import java.awt.*; 
import java.awt.event.*; 
import java.util.ArrayList;

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DecToBinPage4 extends JPanel
{

	WelcomePage welcomePage;
	JButton submitButton; 
	
	//Labels
	JLabel DecToBinNumSquaresText;
	JLabel DecToBinNumSquaresText2;
	JLabel DecToBinNumSquaresText3;

	final int DecToBinNumSquaresActual = 11;
	final int startx = 200;
	final int starty = 180;
	int DecToBinNumSquaresInput;
	
	
	//Panels
	JPanel titlePanel;
	JPanel textPanel;

	//formats the title panel
	public void initTitlePanel(){
		titlePanel = new JPanel();
		titlePanel.setLayout(new BorderLayout());
		titlePanel.setBackground(WelcomePage.backgroundColor);
		JLabel titleLabel = new JLabel("Tutorial: Convert Decimal to Binary Complete!");
		titleLabel.setFont(new Font("Verdana",1,20));
		titlePanel.add(titleLabel, BorderLayout.CENTER);
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
	}

	//sets all the texts of all Jlabels
	public void initJLabels(){
		DecToBinNumSquaresText = new JLabel("11 in decimal is equivalent to 1011 in binary!");
		DecToBinNumSquaresText2 = new JLabel("Congratulations on making it through this tutorial. Now you can complete some practice problems");
		DecToBinNumSquaresText3 = new JLabel("or click tutorial to return to the tutorial menu screen.");
	}


	class submitButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent le) {  


		} 
	}
	public void initButtons(){
		submitButton = new JButton("Submit"); 
		submitButton.addActionListener(new submitButtonListener());
	}

	//constructor, param is the applet
	public DecToBinPage4(WelcomePage welcome)
	{
		setBackground(WelcomePage.backgroundColor);
		welcomePage = welcome;

		//initializations
		initButtons();
		initJLabels();
		initTitlePanel();
		initTextPanel();	

		//add panels
		add(titlePanel);
		add(textPanel);

	}

	public void paint(Graphics g) {
		super.paint(g);
		
	}


} //end class
