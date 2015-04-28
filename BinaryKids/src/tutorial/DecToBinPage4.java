//this class is the fourth page in the decimal to binary tutorial

package tutorial;

import javax.swing.*; 

import java.awt.*; 
import java.awt.event.*; 

import javax.swing.JPanel;

@SuppressWarnings("serial")
public class DecToBinPage4 extends JPanel
{

	private Controller controller;
	private JButton submitButton; 
	private JButton tutorialButton;

	private final String text1 = "11 in decimal is equivalent to 1011 in binary!";
	private final String text2 = "Congratulations on making it through this tutorial. ";
	private final String text3 = "Now you can complete some practice problems or ";
	private final String text4 = "click tutorial to return to the tutorial menu screen.";

	//text coords
	private final int headerX = 200;
	private final int headerY = 20;
	private final int startTextX = 150;
	private final int startTextY = 70;
	private final int textYInc = 30;
	
	//button coords
	private final int submitButtonX = 260;
	private final int submitButtonY = 220;
	private final int tutButtonX = 260;
	private final int tutButtonY = 260;

	//action listener for tutorial button
	class tutorialButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent le) {  
			controller.setCompletedDecBin();
			controller.loadCard("FOURTH");

		} 
	}

	//action listener for submit button
	class submitButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent le) {  
			controller.loadCard("DEC BIN PAGE 5");
			controller.setCompletedDecBin();
		} 
	}

	//inits all the buttons in the panel
	public void initButtons(){
		submitButton = new JButton("Practice Problems"); 
		submitButton.addActionListener(new submitButtonListener());
		tutorialButton = new JButton("Return to Tutorials"); 
		tutorialButton.addActionListener(new tutorialButtonListener());
	}

	//init swing components
	public void initComponents(){
		initButtons();
	}

	//this method adds the components to the panel
	public void addComponentsToPanel() {
		setLayout(null);
		add(submitButton);
		add(tutorialButton);
	}

	//this method defines the formatting of the components on the panel
	public void formatComponents(){
		Insets insets = getInsets();
		Dimension buttonSize = submitButton.getPreferredSize();
		submitButton.setBounds(submitButtonX + insets.left, submitButtonY + insets.top,
				2* buttonSize.width, buttonSize.height);

		buttonSize = tutorialButton.getPreferredSize();
		tutorialButton.setBounds(tutButtonX + insets.left, tutButtonY + insets.top,
				2* buttonSize.width, buttonSize.height);
	}
	


	//constructor, param is the applet
	public DecToBinPage4(Controller welcome)
	{
		setBackground(Controller.backgroundColor);
		controller = welcome;
		initComponents();
		addComponentsToPanel();
		formatComponents();
		setVisible(true);
	}

	public void paint(Graphics g) {
		super.paint(g);


		g.drawImage(controller.tutorialCompleteImg, headerX, headerY, this);


		g.setFont(new Font("Geneva", Font.BOLD, 20));
		g.setColor(Controller.textColor);



		g.drawString(text1, startTextX+30, startTextY+textYInc);
		g.drawString(text2, startTextX, startTextY+2*textYInc);
		g.drawString(text3, startTextX, startTextY+3*textYInc);
		g.drawString(text4, startTextX, startTextY+4*textYInc);
	}


} //end class
