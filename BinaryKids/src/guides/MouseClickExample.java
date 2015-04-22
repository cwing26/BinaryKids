package guides;



import java.awt.*; 
import java.applet.*; 
// import an extra class for the MouseListener 
import java.awt.event.*;

import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;


import java.awt.*; 
import java.applet.*;
import java.awt.BorderLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

// Tells the applet you will be using the MouseListener methods.

public class MouseClickExample extends JApplet implements MouseListener, MouseMotionListener 
{ 
	 // The X-coordinate and Y-coordinate of the last click. 
	 int xpos; 
	 int ypos;
	
	 // The coordinates of the rectangle we will draw. 
	 // It is easier to specify this here so that we can later 
	 // use it to see if the mouse is in that area. 
	 int rect1xco,rect1yco,rect1width,rect1height;
	 
	 int rect2xco,rect2yco,rect2width,rect2height;
	
	
	 // variable that will be true when the user clicked i the rectangle  
	 // the we will draw. 
	 boolean rect1Clicked;
	 boolean rect2Clicked;
	 boolean clickOrMove = true;
	 int rectSelected = 0;
	
	 public void init()  
	 { 
	  // Assign values to the rectanagle coordinates. 
	  rect1xco = 20; 
	  rect1yco = 20; 
	  rect1width = 100; 
	  rect1height = 50;
	  
	  // Assign values to the rectanagle coordinates. 
	  rect2xco = 100; 
	  rect2yco = 100; 
	  rect2width = 100; 
	  rect2height = 50;
		  
	  setSize(800,800);
	
	  // Add the MouseListener to your applet 
	  addMouseListener(this); 
	  addMouseMotionListener(this);
	  
	 }
	
	 public void paint(Graphics g)  
	 { 
		 super.paint(g);
	  // Rectangle's color 
	  g.setColor(Color.green);
	
	  g.fillRect(rect1xco,rect1yco,rect1width,rect1height);
	
	  //g.setColor(Color.red);
	
	  // When the user clicks this will show the coordinates of the click 
	  // at the place of the click. 
	  //g.drawString("("+xpos+","+ypos+")",xpos,ypos);
	
	  g.setColor(Color.blue);
		
	  g.fillRect(rect2xco,rect2yco,rect2width,rect2height);
	  // If the click was in the rectangle show this message 
	 // if (rect1Clicked) g.drawString("You clicked in the Rectangle",20,120); 
	  // else this one 
	  //else g.drawString("You clicked outside of the rectangle",20,120);
	
	  //if (mouseEntered) g.drawString("Mouse is in the applet area",20,160); 
	  //else g.drawString("Mouse is outside the Applet area",20,160); 
	 }
	
	 
	 
	 
	 
	 
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
		 if(clickOrMove) //click is to select rectangle
		 {
			// Save the coordinates of the click lke this.
			  xpos = me.getX(); 
			  ypos = me.getY();
			  
			  if((xpos >= rect1xco) && (xpos <= (rect1xco + 100)) && (ypos >= rect1yco) && (ypos <= (rect1yco + 50)))
			  {
				  rectSelected = 1;
			  }
			  else if((xpos >= rect2xco) && (xpos <= (rect2xco + 100)) && (ypos >= rect2yco) && (ypos <= (rect2yco + 50)))
			  {
				  rectSelected = 2;
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
	 
	 /* If you use MouseMotionListener then these methodshave to be here 
	 public void mouseMoved(MouseEvent me); 
	 public void mouseDragged(MouseEvent me); 
	*/
	 
	 public void mouseMoved(MouseEvent me){}
	 
	 public void mouseDragged(MouseEvent me) {}

 
}
