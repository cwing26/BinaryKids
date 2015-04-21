package tutorial;


import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.TextField;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;

import javax.swing.BoxLayout;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import javax.swing.border.LineBorder;

import java.awt.*; 
import java.applet.*;
import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.BorderLayout;
import java.awt.Button;
import java.awt.Checkbox;
import java.awt.CheckboxGroup;
import java.awt.EventQueue;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Rectangle;
import java.awt.RenderingHints;
import java.awt.Image;
import java.awt.TextField;
import java.awt.Toolkit;
import java.util.ArrayList;



public class BinaryDecimalTwo extends JPanel implements MouseListener
{	
	WelcomePage welcomePage;
	
	BinaryDecimalThree bdThree;
	
	JLabel binToDecNumSquaresText; // 16, 8, 4, 2, etc

	
	int binToDecNumSquaresInput;
	private ImageIcon boxIcon;
	private Image img;
	private Rectangle rec;
	
	JButton submitButton;
	TextField answerField2;
	TextField answerField3;
	TextField answerField4;
	TextField answerField5;
	
	//13 in binary is 01101
	final int BinToDecNumSquaresActual = 13;
	final int answer2 = 1;
	final int answer3 = 1;
	final int answer4 = 0;
	final int answer5 = 1;
	
	int userAnswer1;
	int userAnswer2;
	int userAnswer3;
	int userAnswer4;
	int userAnswer5;
	
	// The coordinates of the 10's rectangle and 1s rectangle 
	int box8x, box8y, box8width, box8height;
	int box4x, box4y, box4width, box4height;
	int box2x, box2y, box2width, box2height;
	int box1x, box1y, box1width, box1height;
	
	
	
	// The X-coordinate and Y-coordinate of the last click. 
	int xpos; 
	int ypos;
		
	// variable that will be true when the user clicked i the rectangle  
	// the we will draw. 
	
	boolean clickOrMove = true;
	boolean boxSelected16 = false;
	boolean boxSelected8 = false;
	boolean boxSelected4 = false;
	boolean boxSelected2 = false;
	boolean boxSelected1 = false;
	
	boolean rectSelected = false;
	int rectSelectedNum = 0;
	
	final int rectUnit = 25;

	ArrayList<Image> imgList = new ArrayList<Image>();
	ArrayList<Rectangle> recList = new ArrayList<Rectangle>();

    
    public BinaryDecimalTwo(WelcomePage welcome)
    {
    	welcomePage = welcome;
    	bdThree = new BinaryDecimalThree(welcome);

    	int startx = 60;
		int starty = 600;
    	
		for (int i = 0; i < BinToDecNumSquaresActual; i++)
		{
			//g.drawImage(img, startx, starty, this);

			rec = new Rectangle(startx, starty, rectUnit,rectUnit);
			recList.add(rec);
			startx+=40;
		}
		
		
    	JPanel titlePanel = new JPanel();
    	JLabel titleLabel = new JLabel("BinaryKids");
    	titleLabel.setFont(new Font("Verdana",1,20));
    	titlePanel.add(titleLabel);
    	titlePanel.setBorder(new LineBorder(Color.BLACK));     	
    	
    	JLabel descriptionLabel = new JLabel("Let's learn how to convert from binary back to decimal with an example! (2)");
    	descriptionLabel.setFont(new Font("Verdana",1,20));
    	
    	JLabel descriptionLabel2 = new JLabel("In base two...");
    	descriptionLabel2.setFont(new Font("Verdana",1,20));
    	
    	JPanel tablePanel = new JPanel();
    	binToDecNumSquaresText = new JLabel("		8			4			2			1");
    	binToDecNumSquaresText.setFont(new Font("Verdana",1,60));
    	tablePanel.add(binToDecNumSquaresText);
    	tablePanel.setBorder(new LineBorder(Color.BLACK)); 
    	
    	submitButton = new JButton("Submit Answer");

    	
    	answerField2 = new TextField(" ______");
    	answerField2.setSize(100, 200);
    	
    	answerField3 = new TextField(" ______");
    	answerField3.setSize(100, 200);
    	
    	answerField4 = new TextField(" ______");
    	answerField4.setSize(100, 200);
    	
    	answerField5 = new TextField(" ______");
    	answerField5.setSize(100, 200);
    	
    	
    	submitButton.addActionListener(new submitButtonListener());
    	
		// Assign values to the rectanagle coordinates. 

		// Assign values to the rectanagle coordinates. 
		box8x = 200; 
		box8y = 160; 
		box8width= 120; 
		box8height = 400;
		
		// Assign values to the rectanagle coordinates. 
		box4x = 340; 
		box4y = 160; 
		box4width= 120; 
		box4height = 400;
		
		// Assign values to the rectanagle coordinates. 
		box2x = 480; 
		box2y = 160; 
		box2width= 120; 
		box2height = 400;
		
		// Assign values to the rectanagle coordinates. 
		box1x = 620; 
		box1y = 160; 
		box1width= 120; 
		box1height = 400;
		
    	
    	add(titlePanel);
    	add(descriptionLabel);
    	add(descriptionLabel2);
    	add(answerField2);
    	add(answerField3);
    	add(answerField4);
    	add(answerField5);
    	add(submitButton);
    	add(tablePanel);
    	
    	addMouseListener(this); 
    	
    	setVisible(true);

    }
    
    public void paint(Graphics g)
    {
    	super.paint(g);
    	g.drawRect(box8x,box8y,box8width,box8height);
    	g.drawRect(box4x,box4y,box4width,box4height);
    	g.drawRect(box2x,box2y,box2width,box2height);
    	g.drawRect(box1x,box1y,box1width,box1height);
    	
    	
    	g.setColor(Color.blue);
    	
    	
		//Graphics2D g2d = (Graphics2D) g.create();
		for (int i = 0;i < recList.size(); i++){
			g.fillRect((int)recList.get(i).getX(),(int)recList.get(i).getY(), rectUnit, rectUnit );
		}

    }
    
	class submitButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			//get all text from text boxes, if correct then display dialog box
			//then go to new page
			
			String input2 =  answerField2.getText();
			String input3 =  answerField3.getText();
			String input4 =  answerField4.getText();
			String input5 =  answerField5.getText();
			

			userAnswer2 = Integer.parseInt(input2);
			userAnswer3 = Integer.parseInt(input3);
			userAnswer4 = Integer.parseInt(input4);
			userAnswer5 = Integer.parseInt(input5);
			
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
			

			if(userAnswer2 == answer2
					&& userAnswer3 == answer3
					&& userAnswer4 == answer4
					&& userAnswer5 == answer5
					&& countEights == 8
					&& countFours == 4
					&& countTwos == 0
					&& countOnes == 1
					)
			{
				welcomePage.getContentPane().remove(welcomePage.bdOne.bdTwo);
				welcomePage.getContentPane().add(bdThree, BorderLayout.CENTER);
				
				welcomePage.validate();
		        welcomePage.setVisible(true);
		        welcomePage.repaint();
			}
			else
			{
				//dialog box welcomes user to game and gives them brief instructions
		    	String errorMessage = "Wrong answer, try again!";
		    	JOptionPane.showMessageDialog(welcomePage, errorMessage, "worng answer", JOptionPane.YES_NO_OPTION);
		    	
		    	answerField2.setText("");
		    	answerField3.setText("");
		    	answerField4.setText("");
		    	answerField5.setText("");
		    	
				int startx = 60;
				int starty = 600;
				
				for (int i = 0; i < recList.size(); i++)
				{
					recList.get(i).setLocation(startx, starty);
					startx+=40;
				}
				repaint();
		    	
				
			}

			
		} //end action performed
		
		
	} //end button listener
	
	
	
	/* These methods always have to present when you implement MouseListener
	
	 public void mouseClicked (MouseEvent me) {} 
	 public void mouseEntered (MouseEvent me) {} 
	 public void mousePressed (MouseEvent me) {} 
	 public void mouseReleased (MouseEvent me) {}  
	 public void mouseExited (MouseEvent me) {}  
	*/
	
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

				if((xpos >= box8x) && (xpos <= (box8x + box8width)) && (ypos >= box8y) && (ypos <= (box8y + box8height)))
				{
					boxSelected8 = true;
					recList.get(rectSelectedNum).setLocation(me.getX(), me.getY());
					
				}
				else if((xpos >= box4x) && (xpos <= (box4x + box4width)) && (ypos >= box4y) && (ypos <= (box4y + box4height)))
				{
					boxSelected4 = true;
					recList.get(rectSelectedNum).setLocation(me.getX(), me.getY());
					
				}
				else if((xpos >= box2x) && (xpos <= (box2x + box2width)) && (ypos >= box2y) && (ypos <= (box2y + box2height)))
				{
					boxSelected2 = true;
					recList.get(rectSelectedNum).setLocation(me.getX(), me.getY());
					
				}
				else if((xpos >= box1x) && (xpos <= (box1x + box1width)) && (ypos >= box1y) && (ypos <= (box1y + box1height)))
				{
					boxSelected1 = true;
					recList.get(rectSelectedNum).setLocation(me.getX(), me.getY());
					
				}
				else {
					
				}

			}




			//show the results of the click 
			repaint();
		 
		 /*
		 if(clickOrMove) //click is to select rectangle
		 {
			// Save the coordinates of the click lke this.
			  xpos = me.getX(); 
			  ypos = me.getY();
			  
			  if((xpos >= rect1xco) && (xpos <= (rect1xco + rectWidth)) && (ypos >= rect1yco) && (ypos <= (rect1yco + rectHeight)))
			  {
				  rectSelected = 1;
			  }
			  else if((xpos >= rect2xco) && (xpos <= (rect2xco + rectWidth)) && (ypos >= rect2yco) && (ypos <= (rect2yco + rectHeight)))
			  {
				  rectSelected = 2;
			  }
			  else if((xpos >= rect3xco) && (xpos <= (rect3xco + rectWidth)) && (ypos >= rect3yco) && (ypos <= (rect3yco + rectHeight)))
			  {
				  rectSelected = 3;
			  }
			  else if((xpos >= rect4xco) && (xpos <= (rect4xco + rectWidth)) && (ypos >= rect4yco) && (ypos <= (rect4yco + rectHeight)))
			  {
				  rectSelected = 4;
			  }
			  else if((xpos >= rect5xco) && (xpos <= (rect5xco + rectWidth)) && (ypos >= rect5yco) && (ypos <= (rect5yco + rectHeight)))
			  {
				  rectSelected = 5;
			  }
			  else if((xpos >= rect6xco) && (xpos <= (rect6xco + rectWidth)) && (ypos >= rect6yco) && (ypos <= (rect6yco + rectHeight)))
			  {
				  rectSelected = 6;
			  }
			  else if((xpos >= rect7xco) && (xpos <= (rect7xco + rectWidth)) && (ypos >= rect7yco) && (ypos <= (rect7yco + rectHeight)))
			  {
				  rectSelected = 7;
			  }
			  else if((xpos >= rect8xco) && (xpos <= (rect8xco + rectWidth)) && (ypos >= rect8yco) && (ypos <= (rect8yco + rectHeight)))
			  {
				  rectSelected = 8;
			  }
			  else if((xpos >= rect9xco) && (xpos <= (rect9xco + rectWidth)) && (ypos >= rect9yco) && (ypos <= (rect9yco + rectHeight)))
			  {
				  rectSelected = 9;
			  }
			  else if((xpos >= rect10xco) && (xpos <= (rect10xco + rectWidth)) && (ypos >= rect10yco) && (ypos <= (rect10yco + rectHeight)))
			  {
				  rectSelected = 10;
			  }
			  else if((xpos >= rect11xco) && (xpos <= (rect11xco + rectWidth)) && (ypos >= rect11yco) && (ypos <= (rect11yco + rectHeight)))
			  {
				  rectSelected = 11;
			  }
			  else if((xpos >= rect12xco) && (xpos <= (rect12xco + rectWidth)) && (ypos >= rect12yco) && (ypos <= (rect12yco + rectHeight)))
			  {
				  rectSelected = 12;
			  }
			  else if((xpos >= rect13xco) && (xpos <= (rect13xco + rectWidth)) && (ypos >= rect13yco) && (ypos <= (rect13yco + rectHeight)))
			  {
				  rectSelected = 13;
			  }
			  else
				  rectSelected = 0;
			  
			  clickOrMove = false;
			  
		 }
		 else //click is where to move it
		 {
			// Save the coordinates of the click lke this.
			  xpos = me.getX(); 
			  ypos = me.getY();
			  
			  if(rectSelected == 1)
			  {
				  rect1xco = me.getX();
				  rect1yco = me.getY();
			  }
			  else if(rectSelected ==2)
			  {
				  rect2xco = me.getX();
				  rect2yco = me.getY();
			  }
			  else if(rectSelected == 3)
			  {
				  rect3xco = me.getX();
				  rect3yco = me.getY();
			  }
			  else if(rectSelected == 4)
			  {
				  rect4xco = me.getX();
				  rect4yco = me.getY();
			  }
			  else if(rectSelected == 5)
			  {
				  rect5xco = me.getX();
				  rect5yco = me.getY();
			  }
			  else if(rectSelected == 6)
			  {
				  rect6xco = me.getX();
				  rect6yco = me.getY();
			  }
			  else if(rectSelected == 7)
			  {
				  rect7xco = me.getX();
				  rect7yco = me.getY();
			  }
			  else if(rectSelected == 8)
			  {
				  rect8xco = me.getX();
				  rect8yco = me.getY();
			  }
			  else if(rectSelected == 9)
			  {
				  rect9xco = me.getX();
				  rect9yco = me.getY();
			  }
			  else if(rectSelected == 10)
			  {
				  rect10xco = me.getX();
				  rect10yco = me.getY();
			  }
			  else if(rectSelected == 11)
			  {
				  rect11xco = me.getX();
				  rect11yco = me.getY();
			  }
			  else if(rectSelected == 12)
			  {
				  rect12xco = me.getX();
				  rect12yco = me.getY();
			  }
			  else if(rectSelected == 13)
			  {
				  rect13xco = me.getX();
				  rect13yco = me.getY();
			  }
			  
			  clickOrMove = true;
				  
		 }
	   

	  
	  //check if click was inside any of the rectangles
	  //if yes, then select it
	  //then wait for the next click, and if its not inside any rectangles, 
	  //then drop the previous rectangle there
	  
	  //like have a tag that is either null (meaning a drag drop cycle has been completed)
	  //or the tag equals one of the rectangles, then we just have to set its new x and y
	  //coordinates for the repaint

	  
	  //show the results of the click 
	  repaint();
	*/
	 } //end mouse click listener
	
	
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

} //end class thirdpage


