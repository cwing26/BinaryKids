package tutorial;


import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;
import java.awt.*; 
import java.awt.BorderLayout;
import java.awt.event.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;

import game.GamePage;


@SuppressWarnings("serial")
public class WelcomePage extends JApplet
{

	boolean notOnStartScreen = false;
	WelcomePage welcome = this;

	int pageFlag = 0;

	private int frameWidth = 800;
	private int frameHeight = 620;

	//new colors
	public static Color backgroundColor = new Color(255, 255, 204);
	public static Color buttonPanelColor = new Color(152, 46, 68);
	public static Color textColor = new Color(0, 0, 0);
	public static Color headersColor = new Color(255,102,102);

	//"cards"
	private StartPage startPage;
	private NumRepresentationPage numRepresentationPage;
	private NumRepresentationPage2 numRepresentationPage2;
	private FirstPage firstPage;
	private SegundaPage segundaPage;
	private TerceraPage terceraPage;
	private PreDemoPage preDemoPage;
	private PreDemoBinaryPage preDemoBinaryPage;
	private DemoPage demoPage;
	private DemoPage2 demoPage2;
	private FourthPage fourthPage;
	private DecToBinPage decToBinPage;
	private DecToBinPage2 decToBinPage2;
	private DecToBinPage3 decToBinPage3;
	private DecToBinPage4 decToBinPage4;
	private BinaryDecimalOne bdOne;
	private BinaryDecimalTwo bdTwo;
	private BinaryDecimalThree bdThree;
	private BinaryDecimalFour bdFour;
	private GamePage gamePage;

	//top panel commponents
	JPanel buttonPanel;
	JButton nextButton;
	JButton closeButton;
	JButton tutorialButton;
	JButton debugButton;
	JButton gameButton; //only become available once completed tutorials
	JButton backButton;
	JButton backToHomeButton;

	CardLayout cardLayout;
	JPanel cards;

	Container contentPane;

	private String userName = "";
	private String userAnswer = "";

	public static String titlePath = "images/titleTextImage.jpg";
	public static String titleImagePath = "images/titleImage.jpg";
	public static String lightOnImagePath = "images/lightOn.jpg";
	public static String lightOffImagePath = "images/lightOff.jpg";
	public static String binDecPg3TitleImagePath = "images/BinDecPg3Title.jpg";
	public static String tutorialImgPath = "images/tutorials.jpg";
	public Image titleImg;  //http://www.cs.colostate.edu/~boese/Geek/binaryCalculator.gif
	public Image lightOnImg;
	public Image lightOffImg;
	public Image titleTextImg;
	public Image binDec3TitleImg;

	//meghan's added images
	public static String welcomeToBKPath = "images/welcomeToBKTitle.jpg";
	public Image titleHeadline;
	public Image binaryGraphic;
	public Image tutorialHeadline;
	
	//num representation page images
	public static String binaryImageLightPath = "images/binaryLight.jpg";
	public static String binaryImageDarkPath = "images/binaryDark.jpg";
	public static String decimalImagePath = "images/decimal.jpg";
	public static String romanNumeralImagePath = "images/romanNumeral.jpg";
	public static String shapesImagePath = "images/shapes.jpg";
	public static String numRepTitlePath = "images/numRepPageTitle.jpg";
	public static String soccerBallPath = "images/soccerBall.jpg";


	//what are binary numbers page
	public static String whatBinaryTitlePath = "images/whatBinaryTitle.jpg";
	public static String dogBinaryImagePath = "images/dogBinary.jpg";
	public static String bikeImagePath = "images/bicycle.png";
	public static String binocularsPath = "images/binoculars.png";

	//why binary numbers important page
	public static String whyBinaryImportantTitlePath = "images/thirdPageTitle.jpg";
	public static String instagramPath = "images/instagram.png";
	public static String fbPath = "images/fb.png";
	public static String youtubePath = "images/youtube.png";
	public static String emailPath = "images/gmail.png";
	public static String skypePath = "images/skype.png";
	public static String gamePath = "images/game.png";
	public static String cellPath = "images/cellPhone.png";
	public static String lightOffPath = "images/realLightOff.png";
	public static String lightOnPath = "images/realLightOn.png";
	public static String binaryDigitPath = "images/binaryDigit.gif";

	//dec number basics/bin num basics images
	public static String decBasicsPath = "images/decNumBasics.jpg";
	public static String crossOutPath = "images/crossOut.png";
	public static String binBasicsPath = "images/binNumBasics.jpg";

	//demo page images
	public static String puttingTogetherPath = "images/puttingAllTogether.jpg";

    	//practice problem images
    	public static String binPracticeProblemPath = “images/binPracticeProblemTitle.png";
    	public static String hintGraphicPath = “images/hintGraphic.gif";
	public static String decPracticeProblemPath = “images/decPracticeProblemsTitle.jpg";
    


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
			e.printStackTrace();
		}
	}


	/*
	 * Create the GUI. For thread safety, this method should
	 * be invoked from the event-dispatching thread.
	 */
	private void createGUI() 
	{

		//load all images to be used in the applet
		loadImages();

		//set up the panel of buttons that is always visible
		createButtonPanel();

		//initializaing all of the components of the tutorial
		cards = new JPanel(new CardLayout());
		contentPane = getContentPane();


		startPage = new StartPage(this);

		numRepresentationPage = new NumRepresentationPage(this);
		numRepresentationPage2 = new NumRepresentationPage2(this);
		firstPage = new FirstPage(this);
		segundaPage = new SegundaPage(this);
		terceraPage = new TerceraPage(this);
		preDemoPage = new PreDemoPage(this);
		preDemoBinaryPage = new PreDemoBinaryPage(this);
		demoPage = new DemoPage(this);
		demoPage2 = new DemoPage2(this);
		fourthPage = new FourthPage(this);
		decToBinPage = new DecToBinPage(this);
		decToBinPage2 = new DecToBinPage2(this);
		decToBinPage3 = new DecToBinPage3(this);
		decToBinPage4 = new DecToBinPage4(this);
		bdOne = new BinaryDecimalOne(this);
		bdTwo = new BinaryDecimalTwo(this);
		bdThree = new BinaryDecimalThree(this);
		bdFour = new BinaryDecimalFour(this);
		gamePage = new GamePage(this);


		cards.add(startPage, "START PAGE");
		cards.add(numRepresentationPage, "NUM REP 1");
		cards.add(numRepresentationPage2, "NUM REP 2");
		cards.add(firstPage, "FIRST");
		cards.add(segundaPage, "SEGUNDA");
		cards.add(terceraPage, "TERCERDA");
		cards.add(preDemoPage, "PRE DEMO");
		cards.add(preDemoBinaryPage, "PRE DEMO 2");
		cards.add(demoPage, "DEMO");
		cards.add(demoPage2, "DEMO 2");
		cards.add(fourthPage, "FOURTH");
		cards.add(decToBinPage, "DEC BIN PAGE 1");
		cards.add(decToBinPage2, "DEC BIN PAGE 2");
		cards.add(decToBinPage3, "DEC BIN PAGE 3");
		cards.add(decToBinPage4, "DEC BIN PAGE 4");
		cards.add(bdOne, "BIN DEC PAGE 1");
		cards.add(bdTwo, "BIN DEC PAGE 2");
		cards.add(bdThree, "BIN DEC PAGE 3");
		cards.add(bdFour, "BIN DEC PAGE 4");
		cards.add(gamePage, "GAME");



		//Create and set up the content pane.
		setLayout(new BorderLayout()); 
		add(cards, BorderLayout.CENTER);
		cardLayout = (CardLayout)(cards.getLayout());
		cardLayout.show(cards, "START PAGE");

		//add(startPage, BorderLayout.CENTER);
		//add buttonPanel to the top of game frame
		add(buttonPanel, BorderLayout.NORTH);




		// Setup the applet
		getContentPane().setBackground(backgroundColor);
		setName("BinaryKids");
		setSize(frameWidth, frameHeight);
		setVisible(true);

	}  

	public void loadImages(){

		titleImg = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.titleImagePath));
		titleImg = titleImg.getScaledInstance(550, 300, Image.SCALE_SMOOTH);

		lightOnImg = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.lightOnImagePath));

		lightOnImg = lightOnImg.getScaledInstance(200, 400, Image.SCALE_SMOOTH);
		lightOffImg = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.lightOffImagePath));
		lightOffImg = lightOnImg.getScaledInstance(200, 400, Image.SCALE_SMOOTH);
		titleTextImg = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.titlePath));
		titleTextImg = titleTextImg.getScaledInstance(700, 40, Image.SCALE_SMOOTH);
		binDec3TitleImg = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.binDecPg3TitleImagePath));  
		binDec3TitleImg = binDec3TitleImg.getScaledInstance(650, 50, Image.SCALE_SMOOTH);

		titleHeadline = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.welcomeToBKPath)); 
		titleHeadline = titleHeadline.getScaledInstance(586, 50, Image.SCALE_SMOOTH);
		
		tutorialHeadline = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.tutorialImgPath)); 
		tutorialHeadline = tutorialHeadline.getScaledInstance(280, 40, Image.SCALE_SMOOTH);

		//try to load the image file
		try {
			binaryGraphic = new ImageIcon(new URL("http://media.giphy.com/media/nlJF31X6I1LW/giphy.gif")).getImage();

		} catch (IOException e) {
			System.out.println("Please check image file path.");
			e.printStackTrace();
		};
		binaryGraphic = binaryGraphic.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
	}

	public void createButtonPanel()
	{
		//creates a close button to allow user to exit whenever
		closeButton = new JButton("Close");
		closeButton.addActionListener(new closeButtonListener());

		debugButton = new JButton("Debug");
		debugButton.addActionListener(new debugButtonListener());

		nextButton = new JButton("NEXT");
		nextButton.addActionListener(new nextButtonListener());

		tutorialButton = new JButton("Tutorials");
		tutorialButton.addActionListener(new tutorialButtonListener());

		gameButton = new JButton("Play Game");
		gameButton.addActionListener(new gameButtonListener());

		backButton = new JButton("BACK");
		backButton.addActionListener(new backButtonListener());

		backToHomeButton = new JButton("Back to Home");
		backToHomeButton.addActionListener(new backHomeButtonListener());

		//buttons panel that holds close button
		buttonPanel = new JPanel();
		buttonPanel.setBackground(WelcomePage.buttonPanelColor);
		buttonPanel.add(backToHomeButton);
		buttonPanel.add(closeButton); 
		buttonPanel.add(backButton);
		backButton.setVisible(false);
		buttonPanel.add(nextButton);
		//buttonPanel.add(debugButton);

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
		if (tutorialType.equals("DECBIN"))
		{
			decToBinPage = new DecToBinPage(this);
			cardLayout.show(cards, "DEC BIN PAGE 1");
			backButton.setVisible(false);
			nextButton.setVisible(false);
		}
		else if (tutorialType.equals("BINDEC"))
		{
			bdOne = new BinaryDecimalOne(this);
			cardLayout.show(cards, "BIN DEC PAGE 1");
			backButton.setVisible(false);
			nextButton.setVisible(false);
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
		decToBinPage2 = new DecToBinPage2(welcome);
		contentPane.add(decToBinPage2, BorderLayout.CENTER);
		invalidate();
		validate();
		setVisible(true);
		repaint();
	}

	public void loadDecBin3()
	{
		//contentPane.remove(decToBinPage2);
		//decToBinPage3 = new DecToBinPage3(welcome);
		cardLayout.show(cards, "DEC BIN PAGE 3");
		//contentPane.add(decToBinPage3, BorderLayout.CENTER);
		invalidate();
		validate();
		setVisible(true);
		repaint();
	}

	public void loadDecBin4()
	{
		contentPane.remove(decToBinPage3);
		decToBinPage4 = new DecToBinPage4(welcome);
		contentPane.add(decToBinPage4, BorderLayout.CENTER);
		validate();
		setVisible(true);
		repaint();
	}



	public void decToBinTutorial()
	{
		contentPane.remove(fourthPage);
		decToBinPage = new DecToBinPage(welcome);
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

	public void loadBinToDec2()
	{
		contentPane.remove(bdOne);
		bdTwo = new BinaryDecimalTwo(welcome);
		contentPane.add(bdTwo, BorderLayout.CENTER);
		validate();
		setVisible(true);
		repaint();
	}

	public void loadBinToDec3()
	{
		contentPane.remove(bdTwo);
		bdThree = new BinaryDecimalThree(welcome);
		contentPane.add(bdThree, BorderLayout.CENTER);
		validate();
		setVisible(true);
		repaint();
	}

	public void loadBinToDec4()
	{
		contentPane.remove(bdThree);
		bdFour = new BinaryDecimalFour(welcome);
		contentPane.add(bdFour, BorderLayout.CENTER);
		validate();
		setVisible(true);
		repaint();
	}

	public void loadNumRep1(){
		cardLayout.show(cards, "NUM REP 1");
	}

	public void loadNumRep2(){
		cardLayout.show(cards, "NUM REP 2");
	}

	public void loadNumRep3(){
		cardLayout.show(cards, "NUM REP 3");
	}

	public void loadSegundaPage(){
		cardLayout.show(cards, "SEGUNDA");
	}

	public void loadTerceraPage(){
		cardLayout.show(cards, "TERCERA");
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
			cardLayout.show(fourthPage, "FOURTH");
			//			contentPane.remove(firstPage);
			//			contentPane.remove(fourthPage);
			//			contentPane.remove(bdOne);
			//			contentPane.remove(bdTwo);
			//			contentPane.remove(bdThree);
			//			contentPane.remove(bdFour);
			//			contentPane.remove(decToBinPage);
			//			contentPane.remove(decToBinPage2);
			//			contentPane.remove(decToBinPage3);
			//			contentPane.remove(decToBinPage4);
			//			contentPane.remove(baOne);
			//			contentPane.remove(demoPage);
			//			contentPane.add(fourthPage);
			validate();
			setVisible(true);
			repaint();	
		}
	}

	class backHomeButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			//			contentPane.remove(startPage);
			//			contentPane.remove(firstPage);
			//			contentPane.remove(secondPage);
			//			contentPane.remove(thirdPage);
			//			contentPane.remove(fourthPage);
			//			contentPane.remove(bdOne);
			//			contentPane.remove(bdTwo);
			//			contentPane.remove(bdThree);
			//			contentPane.remove(bdFour);
			//			contentPane.remove(decToBinPage);
			//			contentPane.remove(decToBinPage2);
			//			contentPane.remove(decToBinPage3);
			//			contentPane.remove(decToBinPage4);
			//			contentPane.remove(baOne);
			//			contentPane.remove(demoPage);

			startPage = new StartPage(welcome);
			//contentPane.add(startPage);
			notOnStartScreen = false;
			pageFlag = 0;
			backButton.setVisible(false);
			nextButton.setVisible(true);
			cardLayout.show(cards, "START PAGE");
			validate();
			setVisible(true);
			repaint();	
		}
	}

	class gameButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			cardLayout.show(gamePage, "GAME");
			//			contentPane.remove(thirdPage);
			//			contentPane.remove(fourthPage);
			//			contentPane.remove(bdOne);
			//			contentPane.remove(bdTwo);
			//			contentPane.remove(bdThree);
			//			contentPane.remove(bdFour);
			//			contentPane.remove(decToBinPage);
			//			contentPane.remove(decToBinPage2);
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
			pageFlag--;
			if (pageFlag == 0){
				backButton.setVisible(false);
			}
			else{
				backButton.setVisible(true);
			}
			cardLayout.previous(cards);
			validate();
			setVisible(true);
			repaint();	
		}
	}

	class debugButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			//			contentPane.remove(startPage);
			//			contentPane.remove(firstPage);
			//			contentPane.remove(secondPage);
			//			contentPane.remove(thirdPage);
			//			contentPane.remove(fourthPage);
			//			contentPane.remove(bdOne);
			//			contentPane.remove(bdTwo);
			//			contentPane.remove(bdThree);
			//			contentPane.remove(bdFour);
			//			contentPane.remove(decToBinPage);
			//			contentPane.remove(decToBinPage2);
			//			contentPane.remove(decToBinPage3);
			//			contentPane.remove(decToBinPage4);
			//			contentPane.remove(baOne);
			//			contentPane.remove(demoPage);
			//
			//
			//			contentPane.add(new DecToBinPage2(welcome));

			validate();
			setVisible(true);
			repaint();	
		}
	}

	class nextButtonListener implements ActionListener 
	{

		public void actionPerformed(ActionEvent e) 
		{
			pageFlag++;
			cardLayout.next(cards);
			notOnStartScreen = true;
			if (pageFlag == 0){
				backButton.setVisible(false);
			}
			else{
				backButton.setVisible(true);
			}
			
			/*
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
			 */
			//			if(pageFlag == 0)
			//			{
			//				contentPane.remove(secondPage);
			//				contentPane.add(thirdPage, BorderLayout.CENTER);
			//				if(thirdPage.pageClickedOnce)
			//				{
			//					buttonPanel.add(page3GoBackButton);
			//				}
			//				pageFlag++;
			//
			//				validate();
			//				setVisible(true);
			//				repaint();
			//			}
			//			else if(pageFlag == 1)
			//			{
			//
			//				contentPane.remove(thirdPage);
			//				contentPane.add(demoPage, BorderLayout.CENTER);
			//
			//				pageFlag++;
			//
			//				validate();
			//				setVisible(true);
			//				repaint();
			//			}
			//			else if(pageFlag == 2)
			//			{
			//
			//				contentPane.remove(demoPage);
			//				buttonPanel.remove(nextButton);
			//				buttonPanel.remove(page3GoBackButton);
			//				buttonPanel.add(tutorialButton);
			//				contentPane.add(fourthPage, BorderLayout.CENTER);
			//
			//				pageFlag++;
			//
			//				validate();
			//				setVisible(true);
			//				repaint();
			//			}
			//			else
			//			{
			//				//buttonPanel.add(gameButton);
			//				//gameOver();
			//			}

		} //end action performed

	} //end class nextButtonListener

} //end class WelcomePage
