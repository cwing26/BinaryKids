package tutorial;


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
import java.awt.RenderingHints;
import java.awt.Image;
import java.awt.TextField;
import java.awt.Toolkit;




public class WelcomePage extends JApplet
{
	public enum TutorialType {
		DECBIN, BINDEC, BINADD, BINSUB
	}
	
	TutorialType tutorial;
	
	WelcomePage welcome = this;
	
	int pageFlag = 0;
	int tutorialFlag = 0;
	
	private int frameWidth = 800;
	private int frameHeight = 600;
	
	
	private StartPage startPage;
	private FirstPage firstPage;
	private SecondPage secondPage;
	private ThirdPage thirdPage;
	FourthPage fourthPage;
	BinaryDecimalOne bdOne;
	private DecToBinPage decToBinPage;
	private DecToBinPage2 decToBinPage2;
<<<<<<< HEAD
	private DecToBinPage3 decToBinPage3;
=======
	private BinaryAddOne baOne;
>>>>>>> origin/master
	JPanel buttonPanel;
	JButton nextButton;
	JButton closeButton;
	JButton tutorialButton;
	JButton gameButton; //only become available once completed tutorials
	JButton page3GoBackButton;
	
	Container contentPane;
	
	private String userName = "";
	private String userAnswer = "";
<<<<<<< HEAD
	
	public static String obstImgFileName = "C:\\Users\\Christopher\\Documents\\GitHub\\BinaryKids\\BinaryKids\\resources\\titleImage.jpg";
=======

public static String obstImgFileName = "C:\\Users\\Christopher\\workspace\\BinaryKids\\resources\\titleImage.jpg";
>>>>>>> origin/master
	
    //Called when this applet is loaded into the browser.
    public void init() 
    {
        //Execute a job on the event-dispatching thread; creating this applet's GUI.
        try {
            SwingUtilities.invokeAndWait(new Runnable() 
            {
                public void run() 
                {
                    createGUI();
                }
            });
        } 
        catch (Exception e) 
        { 
            System.err.println("createGUI didn't complete successfully");
        }
    }
    
    
    /*
     * Create the GUI. For thread safety, this method should
     * be invoked from the event-dispatching thread.
     */
    private void createGUI() 
    {
    	contentPane = getContentPane();
    	startPage = new StartPage(this);
    	firstPage = new FirstPage(this);
    	secondPage = new SecondPage(this);
    	thirdPage = new ThirdPage(this);
    	fourthPage = new FourthPage(this);
    	bdOne = new BinaryDecimalOne(this);
    	decToBinPage = new DecToBinPage(this);
    	decToBinPage2 = new DecToBinPage2(this);
<<<<<<< HEAD
    	decToBinPage3 = new DecToBinPage3(this);
    	
=======
    	baOne = new BinaryAddOne(this);
>>>>>>> origin/master
    	
    	//dialog box welcomes user to game and gives them brief instructions
    	String welcomeMessage = "Welcome to BinaryKids: Type in your name and click next to get started!";
    	JOptionPane.showMessageDialog(this, welcomeMessage, "Welcome to BinaryKids", JOptionPane.YES_NO_OPTION);
    	
    	
    	//Create and set up the content pane.
    	setLayout(new BorderLayout()); 
    	add(startPage, BorderLayout.CENTER);
    	
  		//creates a close button to allow user to exit whenever
  		closeButton = new JButton("Close");
  		closeButton.addActionListener(new closeButtonListener());
  		nextButton = new JButton("NextPage");
  		nextButton.addActionListener(new nextButtonListener());
  		tutorialButton = new JButton("Tutorials");
  		tutorialButton.addActionListener(new tutorialButtonListener());
  		gameButton = new JButton("Play Game");
  		gameButton.addActionListener(new gameButtonListener());
  		page3GoBackButton = new JButton("Go back");
  		page3GoBackButton.addActionListener(new backButtonListener());
  		
  		//buttons panel that holds close button
  		buttonPanel = new JPanel();
  		buttonPanel.setBackground(Color.darkGray);
  		buttonPanel.add(closeButton); //add button to the buttonPanel
  		buttonPanel.add(nextButton);
  		add(buttonPanel, BorderLayout.NORTH); //add buttonPanel to the top of game frame
  		 
  		
  		 // Setup the applet
  		 setBackground(Color.pink);
  		 setName("BinaryKids");
<<<<<<< HEAD
  		 setSize(frameWidth, frameHeight);
=======
  		 setSize(frameSize, frameSize);

>>>>>>> origin/master
  		 setVisible(true);
  		    
    }  
    
 
    
    public void paint(Graphics g) 
    {     	
    	super.paint(g);
    	
    }
    
    



	/* gameOver - 
	 * When the game comes to an end, show a dialog box that says it is over 
	 * and shows the score before exiting.
	 */
	public void gameOver() 
	{
		String message = "Thanks for learning!";
		JOptionPane.showMessageDialog(this, message, "Close tutorial?", JOptionPane.YES_NO_OPTION);
		System.exit(ABORT);
	}
	

	/* closeButtonListener- 
	 * Create a new custom listener that is an inner class
	 * to handle when user clicks close button
	 */
	class closeButtonListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			gameOver();
		}
	}
	
	
	public void loadNewTutorial(String tutorialType)
	{
		contentPane.remove(fourthPage);
		if (tutorialType.equals("DECBIN"))
		{
			contentPane.add(decToBinPage, BorderLayout.CENTER);
		}
		else if (tutorialType.equals("BINDEC"))
		{
			contentPane.add(bdOne, BorderLayout.CENTER);
		}
		else {
			System.out.println("still need to implement other tutorial pages");
		}
		
		
		validate();
        setVisible(true);
        repaint();
	}
	
	public void loadDecBin2()
	{
		contentPane.remove(decToBinPage);
		contentPane.add(decToBinPage2, BorderLayout.CENTER);
		validate();
        setVisible(true);
        repaint();
	}

	public void loadDecBin3()
	{
		contentPane.remove(decToBinPage2);
		contentPane.add(decToBinPage3, BorderLayout.CENTER);
		validate();
        setVisible(true);
        repaint();
	}
	
	public void decToBinTutorial()
	{
		contentPane.remove(fourthPage);
		contentPane.add(decToBinPage, BorderLayout.CENTER);
		validate();
        setVisible(true);
        repaint();
	}
	
	public void binToDecTutorial()
	{
		contentPane.remove(fourthPage);
		bdOne = new BinaryDecimalOne(welcome);
		contentPane.add(bdOne, BorderLayout.CENTER);
		validate();
        setVisible(true);
        repaint();
	}
	
	public void binAddTutorial()
	{
		contentPane.remove(fourthPage);
		baOne = new BinaryAddOne(this);
		contentPane.add(baOne, BorderLayout.CENTER);
		validate();
        setVisible(true);
        repaint();
	}
	
	public void setUserName(String name)
	{
		userName = name;
	}
	
	public String getUserName()
	{
		return userName;
	}
	
	
	public void setUserAnswer(String answer)
	{
		userAnswer = answer;
	}
	
	public String getUserAnswer()
	{
		return userAnswer;
	}
	
	class tutorialButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			contentPane.remove(thirdPage);
			contentPane.remove(fourthPage);
			contentPane.remove(bdOne);
			contentPane.remove(bdOne.bdTwo);
			contentPane.remove(bdOne.bdTwo.bdThree);
			contentPane.remove(decToBinPage);
			contentPane.remove(decToBinPage2);
<<<<<<< HEAD
			contentPane.remove(decToBinPage3);
=======
			contentPane.remove(baOne);
>>>>>>> origin/master
			contentPane.add(fourthPage);
			validate();
	        setVisible(true);
	        repaint();	
		}
	}
	
	class gameButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			contentPane.remove(thirdPage);
			contentPane.remove(fourthPage);
			contentPane.remove(bdOne);
			contentPane.remove(bdOne.bdTwo);
			contentPane.remove(bdOne.bdTwo.bdThree);
			contentPane.remove(decToBinPage);
			contentPane.remove(decToBinPage2);
			//contentPane.add(gamePage);
			validate();
	        setVisible(true);
	        repaint();	
		}
	}
	
	class backButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			contentPane.remove(secondPage);
			contentPane.remove(thirdPage);
			contentPane.remove(bdOne);
			contentPane.remove(decToBinPage);
			contentPane.remove(decToBinPage2);
			thirdPage = new ThirdPage(welcome);
			contentPane.add(thirdPage);
			validate();
	        setVisible(true);
	        repaint();	
		}
	}
	
	
	class nextButtonListener implements ActionListener 
	{
		
		public void actionPerformed(ActionEvent e) 
		{

			if(pageFlag == 0)
			{
				contentPane.remove(startPage);
				firstPage = new FirstPage(welcome);
				contentPane.add(firstPage, BorderLayout.CENTER);
				pageFlag++;
				
				validate();
		        setVisible(true);
		        repaint();
				
			}
			else if(pageFlag == 1)
			{
				contentPane.remove(firstPage);
				secondPage = new SecondPage(welcome);
				secondPage.userName = userName;
				secondPage.answer = userAnswer;
				contentPane.add(secondPage, BorderLayout.CENTER);
				pageFlag++;
				
				validate();
		        setVisible(true);
		        repaint();
				
			}
			else if(pageFlag == 2)
			{
				contentPane.remove(secondPage);
				contentPane.add(thirdPage, BorderLayout.CENTER);
				buttonPanel.add(page3GoBackButton);
				pageFlag++;
				
				validate();
		        setVisible(true);
		        repaint();
			}
			else if(pageFlag == 3)
			{

				contentPane.remove(thirdPage);
				buttonPanel.remove(nextButton);
				buttonPanel.remove(page3GoBackButton);
				buttonPanel.add(tutorialButton);
				contentPane.add(fourthPage, BorderLayout.CENTER);
				
				pageFlag++;
				
				validate();
		        setVisible(true);
		        repaint();
			}
			else
			{
				//buttonPanel.add(gameButton);
				//gameOver();
			}
			
		} //end action performed
		
	} //end class nextButtonListener
	
} //end class WelcomePage
