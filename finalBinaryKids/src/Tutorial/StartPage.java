package Tutorial;

import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JPanel;
import javax.swing.JButton;
import javax.swing.JTextField;
import java.awt.Font;
import java.awt.Insets;


@SuppressWarnings("serial")
public class StartPage extends JPanel
{
	//gui components
	JButton submitButton;
	JTextField nameField;
	
	//page directions
	String directions = "This applet will teach you about binary numbers.";
	String directions2 = "Then you can play a fun game with the skills you've learned!";
	
	
	private Controller controller; //to connect welcome page to individual pages 
    
	//initializes all gui components on the page
	public void initComponents()
	{
    	submitButton = new JButton("Start Binary Kids");
    	submitButton.addActionListener(new submitButtonListener());
		
	}
	
	
    public StartPage(Controller welcome)
    {
    	controller = welcome;

    	setBackground(Controller.backgroundColor);
    	initComponents();
    	setLayout(null);
    	//add(submitButton);
    	Insets insets = getInsets();
    	Dimension size = submitButton.getPreferredSize();
    	submitButton.setBounds(330-size.width/2 + insets.left, 200 + insets.top,
                2*size.width, size.height);   	
    	
    }
    
    public void paint(Graphics g) 
    { 
    	super.paint(g);
    	//title text
    	g.drawImage(controller.titleHeadline, 100, 50, this);
    	
    	//directions 
    	g.setFont(new Font("Geneva", 1 , 20));
    	g.drawString(directions, 170, 150);
    	g.drawString(directions2, 110, 175);
    	
    	g.drawImage(controller.binaryGraphic, 1, 400, this);
    	g.drawImage(controller.binaryGraphic, 201, 400, this);
    	g.drawImage(controller.binaryGraphic, 401, 400, this);
    	g.drawImage(controller.binaryGraphic, 601, 400, this);
    	


    }
    
	class submitButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			controller.pageFlag++;
			controller.backButton.setVisible(true);
			controller.loadCard("NUM REP 1");
			repaint();
			
		}
	}
	


}
