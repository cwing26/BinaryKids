
//
// Project 4
// Name: Meghan Anand, Chris Wing, Julia Kieserman, De'Ahna Johnson
// E-mail: ma797@georgetown.edu, cpw26@georgetown.edu, 
//  		jbk67@georgetown.edu, drj31@georgetown.edu
// Instructor: Singh 
// COSC 150
//
// In accordance with the class policies and Georgetown's Honor Code,
// We certify that, with the exceptions of the lecture notes and those
// items noted below, we have neither given nor received any assistance
// on this project. 
//
// Description: This application, named BinaryKids, is an interactive learning 
// applet designed to give middle school-aged students an introduction to the 
// binary number system and its importance to computing. It is divided into 
// four main parts, the pre-tutorial leaning module, the binary to decimal conversion
// learning module, the decimal to binary conversion learning module, and a game called
// binary blast. The applet also contains unit testing for key units of work in each
// module and the game. The applet is accompanied by a basic html page outlining the 
// utility of the application, its social good application, and the learning situations
// in which it should be primarily used. External resources and guides used are also
// listed on this webpage. 
//
// TA Assistance: We received basic help from TA Jordan King on how to set up gitHub 
// efficiently, and from Jordan/Andrew on how to deploy the applet into a webpage 
// (ended up being ultimately unsuccessful). 
//
//



package Tutorial;


import game.GamePage;
import game.GameWelcomePage;
import game.gameInstructions;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import java.awt.*; 
import java.awt.event.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;


@SuppressWarnings("serial")
public class Controller extends JApplet
{
	boolean inTutorial = false;
	boolean notOnStartScreen = false;
	Controller welcome = this;

	int pageFlag = 0;

	private int frameWidth = 800;
	private int frameHeight = 700;

	//custom colors
	public static Color backgroundColor = new Color(255, 255, 204);
	public static Color buttonPanelColor = new Color(152, 46, 68);
	public static Color textColor = new Color(0, 0, 0);
	public static Color headersColor = new Color(255,102,102);

	//"cards"
	private StartPage startPage;
	private NumRepresentationPage numRepresentationPage;
	private NumRepresentationPage2 numRepresentationPage2;
	private binaryTechPage binTechPage;
	private binaryApplicationPage baPage;
	private bitsPage bitsPage;
	private PreDemoDecimalPage preDemoPage;
	private PreDemoBinaryPage preDemoBinaryPage;
	private decConversionDemoPage demoPage;
	private binConversionDemoPage demoPage2;
	private tutorialHomePage tutorialPage;
	private DecToBinPage decToBinPage;
	private DecToBinPage2 decToBinPage2;
	private DecToBinPage3 decToBinPage3;
	private DecToBinPage4 decToBinPage4;
	private DecimalToBinaryPractice decToBinPractice;
	private BinaryDecimalOne bdOne;
	private BinaryDecimalTwo bdTwo;
	private BinaryDecimalThree bdThree;
	private BinaryDecimalFour bdFour;
	private BinaryToDecimalPractice bdPractice;
	private GameWelcomePage gameWelcomePage;
	private gameInstructions gameInstructionsPage;
	private GamePage gamePage;



	//bottom panel commponents
	JPanel buttonPanel;
	JButton nextButton;
	JButton closeButton;
	JButton gameButton;
	JButton backButton;
	JButton backToHomeButton;
	JButton gameWelcomeButton;
	JPanel topPanel;

	CardLayout cardLayout;
	JPanel cards;

	Container contentPane;

	//image paths
	public static String titlePath = "titleTextImage.jpg";
	public static String titleImagePath = "titleImage.jpg";
	public static String lightOnImagePath = "lightOn.jpg";
	public static String lightOffImagePath = "lightOff.jpg";
	public static String binDecPg3TitleImagePath = "BinDecPg3Title.jpg";
	public static String tutorialImgPath = "tutorials.jpg";

	public static String tutorialCompleteImgPath = "tutorialComplete.jpg";
	public static String checkmarkImgPath = "checkmark.png";

	//meghan's added images
	public static String welcomeToBKPath = "welcomeToBKTitle.jpg";
	public static String binDecImgPath = "BinToDec.jpg";

	//num representation page images
	public static String binaryImageLightPath = "binaryLight.jpg";
	public static String binaryImageDarkPath = "binaryDark.jpg";
	public static String decimalImagePath = "decimal.jpg";
	public static String romanNumeralImagePath = "romanNumeral.jpg";
	public static String shapesImagePath = "shapes.jpg";
	public static String numRepTitlePath = "numRepPageTitle.jpg";
	public static String soccerBallPath = "soccerBall.jpg";

	//what are binary numbers page
	public static String whatBinaryTitlePath = "whatBinaryTitle.jpg";
	public static String dogBinaryImagePath = "dogBinary.jpg";
	public static String bikeImagePath = "bicycle.png";
	public static String binocularsPath = "binoculars.png";

	//why binary numbers important page
	public static String whyBinaryImportantTitlePath = "thirdPageTitle.jpg";
	public static String instagramPath = "instagram.png";
	public static String fbPath = "fb.png";
	public static String youtubePath = "youtube.png";
	public static String emailPath = "gmail.png";
	public static String skypePath = "skype.png";
	public static String gamePath = "game.png";
	public static String cellPath = "cellPhone.png";
	public static String lightOffPath = "realLightOff.png";
	public static String lightOnPath = "realLightOn.png";
	public static String binaryDigitPath = "binaryDigit.gif";

	//dec number basics/bin num basics images
	public static String decBasicsPath = "decNumBasics.jpg";
	public static String crossOutPath = "crossOut.png";
	public static String binBasicsPath = "binNumBasics.jpg";

	//demo page images
	public static String puttingTogetherPath = "puttingAllTogether.jpg";

	//practice problem images
	public static String binPracticeProblemPath = "binPracticeProblemTitle.png";
	public static String hintGraphicPath = "hintGraphic.gif";
	public static String decPracticeProblemPath = "decPracticeProblemsTitle.jpg";

	//game image paths
	public static String gameTitlePath = "welcometext.jpg";
	public static String game0Path = "myZero.png";
	public static String game1Path = "myOne.png";
	public static String gameSubmitPath = "submitalso.png";
	public static String gameInstructionsPath = "instructButton.png";
	public static String gamePlayPath = "playButton.png";
	public static String gameRocketPath = "rocketship.jpg";
	public static String binaryBlastPath = "binaryblast.jpg";

	//chris images
	public Image titleImg;  //http://www.cs.colostate.edu/~boese/Geek/binaryCalculator.gif
	public Image lightOnImg;
	public Image lightOffImg;
	public Image titleTextImg;
	public Image decBinHeadlineImg;
	public Image tutorialCompleteImg;
	public Image checkmarkImg;

	public Image titleHeadline;
	public Image binaryGraphic;
	public Image tutorialHeadline;
	public Image binDecImg;

	//num rep page images
	public Image numRepTitleImage;
	public Image decimalTitleImage;
	public Image romanNumeralTitleImage;
	public Image shapesTitleImage;
	public Image binaryImageLight;
	public Image binaryImageDark;
	public Image soccerBall;

	//num rep 2 images
	public Image numRep2TitleImage;
	public Image dogImage;
	public Image bikeImage;
	public Image binocImage;

	//first page images
	public Image firstPageTitleImage;
	public Image instagramImage;
	public Image fbImage;
	public Image emailImage;
	public Image youtubeImage;
	public Image skypeImage;
	public Image cellImage;
	public Image gameImage;

	//second page images
	public Image secondPageTitleImage;
	public Image instagramImage2;
	public Image fbImage2;
	public Image emailImage2;
	public Image youtubeImage2;
	public Image skypeImage2;
	public Image cellImage2;
	public Image gameImage2;
	public Image lightOff;
	public Image lightOn;

	//third page images
	public Image thirdPageTitleImage;
	public Image binaryDigitImage;

	//pre-demo binary images
	public Image preDemoBinaryTitleImage;
	public Image crossOutImage;

	//pre demo images
	public Image preDemoTitleImage;

	//demo page image
	public Image demoTitleImage;

	//demo page 2
	public Image demo2TitleImage;

	//practice problem images
	public Image practiceProblemTitleImage;
	public Image hintImage;

	//game images
	public Image game0ButtonImage;
	public Image game1ButtonImage;
	public Image gameTitleImage;
	public Image gameInstructionsButtonImage;
	public Image playButtonImage;
	public Image submitButtonImage;
	public Image rocketshipImage;
	public Image binaryBlastImage;

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
		initComponents();

		//adds components
		addComponents();

		//Create and set up the content pane.
		setupLayout();

		setVisible(true);

	}  

	public void setupLayout(){
		setLayout(new BorderLayout()); 
		add(cards, BorderLayout.CENTER);
		cardLayout = (CardLayout)(cards.getLayout());

		cardLayout.show(cards, "START PAGE"); //here

		//add buttonPanel to game frame
		add(buttonPanel, BorderLayout.SOUTH); 
		add(topPanel, BorderLayout.NORTH);


		// Setup the applet
		getContentPane().setBackground(backgroundColor);
		setName("BinaryKids");
		setSize(frameWidth, frameHeight);
	}

	//add the panels to cards
	public void addComponents(){
		cards.add(startPage, "START PAGE");
		cards.add(numRepresentationPage, "NUM REP 1");
		cards.add(numRepresentationPage2, "NUM REP 2");
		cards.add(binTechPage, "FIRST");
		cards.add(baPage, "SEGUNDA");
		cards.add(bitsPage, "TERCERDA");
		cards.add(preDemoPage, "PRE DEMO");
		cards.add(preDemoBinaryPage, "PRE DEMO 2");
		cards.add(demoPage, "DEMO");
		cards.add(demoPage2, "DEMO 2");
		cards.add(tutorialPage, "FOURTH");
		cards.add(decToBinPage, "DEC BIN PAGE 1");
		cards.add(decToBinPage2, "DEC BIN PAGE 2");
		cards.add(decToBinPage3, "DEC BIN PAGE 3");
		cards.add(decToBinPage4, "DEC BIN PAGE 4");
		cards.add(decToBinPractice, "DEC BIN PAGE 5");
		cards.add(bdOne, "BIN DEC PAGE 1");
		cards.add(bdTwo, "BIN DEC PAGE 2");
		cards.add(bdThree, "BIN DEC PAGE 3");
		cards.add(bdFour, "BIN DEC PAGE 4");
		cards.add(bdPractice, "BIN DEC PAGE 5");
		cards.add(gameWelcomePage, "GAME WELCOME");
		
	}

	//init swing components
	public void initComponents(){
		cards = new JPanel(new CardLayout());
		contentPane = getContentPane();
		startPage = new StartPage(this);
		numRepresentationPage = new NumRepresentationPage(this);
		numRepresentationPage2 = new NumRepresentationPage2(this);
		binTechPage = new binaryTechPage(this);
		baPage = new binaryApplicationPage(this);
		bitsPage = new bitsPage(this);
		preDemoPage = new PreDemoDecimalPage(this);
		preDemoBinaryPage = new PreDemoBinaryPage(this);
		demoPage = new decConversionDemoPage(this);
		demoPage2 = new binConversionDemoPage(this);
		tutorialPage = new tutorialHomePage(this);
		decToBinPage = new DecToBinPage(this);
		decToBinPage2 = new DecToBinPage2(this);
		decToBinPage3 = new DecToBinPage3(this);
		decToBinPage4 = new DecToBinPage4(this);
		decToBinPractice = new DecimalToBinaryPractice(this);
		bdOne = new BinaryDecimalOne(this);
		bdTwo = new BinaryDecimalTwo(this);
		bdThree = new BinaryDecimalThree(this);
		bdFour = new BinaryDecimalFour(this);
		bdPractice = new BinaryToDecimalPractice(this);
		gameWelcomePage = new GameWelcomePage(this);
		gameInstructionsPage = new gameInstructions(this);
		gamePage = new GamePage(this);
	}

	//load all the images when start applet
	public void loadImages()
	{
		//chris images
		titleImg = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.titleImagePath));
		titleImg = titleImg.getScaledInstance(550, 300, Image.SCALE_SMOOTH);

		decBinHeadlineImg = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.binDecPg3TitleImagePath));  
		decBinHeadlineImg = decBinHeadlineImg.getScaledInstance(650, 50, Image.SCALE_SMOOTH);

		titleHeadline = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.welcomeToBKPath)); 
		titleHeadline = titleHeadline.getScaledInstance(586, 50, Image.SCALE_SMOOTH);

		tutorialHeadline = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.tutorialImgPath)); 
		tutorialHeadline = tutorialHeadline.getScaledInstance(280, 40, Image.SCALE_SMOOTH);

		binDecImg = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.binDecImgPath)); 
		binDecImg = binDecImg.getScaledInstance(600, 50, Image.SCALE_SMOOTH);

		tutorialCompleteImg = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.tutorialCompleteImgPath)); 
		tutorialCompleteImg = tutorialCompleteImg.getScaledInstance(400, 40, Image.SCALE_SMOOTH);

		checkmarkImg = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.checkmarkImgPath)); 
		checkmarkImg = checkmarkImg.getScaledInstance(40, 40, Image.SCALE_SMOOTH);

		//num rep page
		binaryImageLight = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.binaryImageLightPath)); 
		binaryImageLight = binaryImageLight.getScaledInstance(354, 44, Image.SCALE_SMOOTH);

		binaryImageDark = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.binaryImageDarkPath)); 
		binaryImageDark = binaryImageDark.getScaledInstance(354, 44, Image.SCALE_SMOOTH);

		numRepTitleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.numRepTitlePath)); 
		numRepTitleImage = numRepTitleImage.getScaledInstance(780, 44, Image.SCALE_SMOOTH);

		decimalTitleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.decimalImagePath)); 
		decimalTitleImage = decimalTitleImage.getScaledInstance(444, 40, Image.SCALE_SMOOTH);

		romanNumeralTitleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.romanNumeralImagePath)); 
		romanNumeralTitleImage = romanNumeralTitleImage.getScaledInstance(435, 40, Image.SCALE_SMOOTH);

		shapesTitleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.shapesImagePath)); 
		shapesTitleImage = shapesTitleImage.getScaledInstance(164, 48, Image.SCALE_SMOOTH);

		soccerBall = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.soccerBallPath)); 
		soccerBall = soccerBall.getScaledInstance(150, 151, Image.SCALE_SMOOTH);

		//num rep 2 page
		numRep2TitleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.whatBinaryTitlePath)); 
		numRep2TitleImage = numRep2TitleImage.getScaledInstance(673, 50, Image.SCALE_SMOOTH);

		dogImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.dogBinaryImagePath)); 
		dogImage = dogImage.getScaledInstance(121, 224, Image.SCALE_SMOOTH);

		bikeImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.bikeImagePath)); 
		bikeImage = bikeImage.getScaledInstance(192, 124, Image.SCALE_SMOOTH);

		binocImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.binocularsPath)); 
		binocImage = binocImage.getScaledInstance(140, 140, Image.SCALE_SMOOTH);

		//first page
		firstPageTitleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.whyBinaryImportantTitlePath)); 
		firstPageTitleImage = firstPageTitleImage.getScaledInstance(790, 43, Image.SCALE_SMOOTH);

		instagramImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.instagramPath)); 
		instagramImage = instagramImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

		fbImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.fbPath)); 
		fbImage = fbImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

		youtubeImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.youtubePath)); 
		youtubeImage = youtubeImage.getScaledInstance(100, 105, Image.SCALE_SMOOTH);

		emailImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.emailPath)); 
		emailImage = emailImage.getScaledInstance(120, 100, Image.SCALE_SMOOTH);

		cellImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.cellPath)); 
		cellImage = cellImage.getScaledInstance(90, 90, Image.SCALE_SMOOTH);

		skypeImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.skypePath)); 
		skypeImage = skypeImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

		gameImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.gamePath)); 
		gameImage = gameImage.getScaledInstance(100, 100, Image.SCALE_SMOOTH);

		//second page images
		secondPageTitleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.whyBinaryImportantTitlePath)); 
		secondPageTitleImage  = secondPageTitleImage .getScaledInstance(790, 43, Image.SCALE_SMOOTH);


		instagramImage2 = instagramImage.getScaledInstance(90, 90, Image.SCALE_SMOOTH);

		fbImage2 = fbImage.getScaledInstance(90, 90, Image.SCALE_SMOOTH);

		youtubeImage2 = youtubeImage.getScaledInstance(95, 96, Image.SCALE_SMOOTH);

		emailImage2 = emailImage.getScaledInstance(95, 69, Image.SCALE_SMOOTH);

		cellImage2 = cellImage.getScaledInstance(92, 92, Image.SCALE_SMOOTH);

		skypeImage2 = skypeImage.getScaledInstance(90, 90, Image.SCALE_SMOOTH);

		gameImage2 = gameImage.getScaledInstance(90, 90, Image.SCALE_SMOOTH);

		lightOff = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.lightOffPath)); 
		lightOff = lightOff.getScaledInstance(140, 180, Image.SCALE_SMOOTH);

		lightOn = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.lightOnPath)); 
		lightOn = lightOn.getScaledInstance(140, 180, Image.SCALE_SMOOTH);

		//third page images
		thirdPageTitleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.whyBinaryImportantTitlePath)); 
		thirdPageTitleImage = thirdPageTitleImage.getScaledInstance(790, 43, Image.SCALE_SMOOTH);

		binaryDigitImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.binaryDigitPath)); 
		binaryDigitImage = binaryDigitImage.getScaledInstance(150, 157, Image.SCALE_SMOOTH);


		//pre demo binary images
		preDemoBinaryTitleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.binBasicsPath)); 
		preDemoBinaryTitleImage = preDemoBinaryTitleImage.getScaledInstance(600, 50, Image.SCALE_SMOOTH);

		crossOutImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.crossOutPath)); 
		crossOutImage = crossOutImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);

		//pre demo images
		preDemoTitleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.decBasicsPath)); 
		preDemoTitleImage = preDemoTitleImage.getScaledInstance(650, 40, Image.SCALE_SMOOTH);

		//demo title image
		demoTitleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.puttingTogetherPath)); 
		demoTitleImage = demoTitleImage.getScaledInstance(680, 60, Image.SCALE_SMOOTH);

		//demo 2
		demo2TitleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.puttingTogetherPath)); 
		demo2TitleImage = demo2TitleImage.getScaledInstance(680, 60, Image.SCALE_SMOOTH);


		//practice problem images
		practiceProblemTitleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.decPracticeProblemPath)); 
		practiceProblemTitleImage = practiceProblemTitleImage.getScaledInstance(790, 40, Image.SCALE_SMOOTH);

		hintImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.hintGraphicPath)); 
		hintImage = hintImage.getScaledInstance(331,147, Image.SCALE_SMOOTH);


		//game images
		game0ButtonImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.game0Path)); 
		game0ButtonImage = game0ButtonImage.getScaledInstance(100, 93, Image.SCALE_SMOOTH);

		game1ButtonImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.game1Path)); 
		game1ButtonImage = game1ButtonImage.getScaledInstance(100, 93, Image.SCALE_SMOOTH);

		gameTitleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.gameTitlePath)); 
		gameTitleImage = game1ButtonImage.getScaledInstance(600, 49, Image.SCALE_SMOOTH);

		gameInstructionsButtonImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.gameInstructionsPath)); 
		gameInstructionsButtonImage = gameInstructionsButtonImage.getScaledInstance(363, 87, Image.SCALE_SMOOTH);

		playButtonImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.gamePlayPath)); 
		playButtonImage  = playButtonImage.getScaledInstance(380, 155, Image.SCALE_SMOOTH);

		submitButtonImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.gameSubmitPath)); 
		submitButtonImage  = submitButtonImage.getScaledInstance(100, 40, Image.SCALE_SMOOTH);

		rocketshipImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.gameRocketPath)); 
		rocketshipImage  = rocketshipImage.getScaledInstance(50,50, Image.SCALE_SMOOTH);

		binaryBlastImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(Controller.binaryBlastPath)); 
		binaryBlastImage  = binaryBlastImage.getScaledInstance(485,73, Image.SCALE_SMOOTH);



		//try to load the image file
		try {
			binaryGraphic = new ImageIcon(new URL("http://media.giphy.com/media/nlJF31X6I1LW/giphy.gif")).getImage();
			binaryGraphic = binaryGraphic.getScaledInstance(300, 300, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			System.out.println("Please check image file path.");
			binaryGraphic = Toolkit.getDefaultToolkit().getImage(
					getClass().getClassLoader().getResource(Controller.titleImagePath));
			binaryGraphic = binaryGraphic.getScaledInstance(600, 280, Image.SCALE_SMOOTH);
			e.printStackTrace();
		};


	}


	//update that completed dec to bin tutorial
	public void setCompletedDecBin(){
		tutorialPage.completedDecBin = true;
		repaint();
	}

	//update that commpleted bin to dec tutorial
	public void setCompletedBinDec(){
		tutorialPage.completedBinDec = true;
		repaint();
	}

	//create the buttons and add to button panel
	public void createButtonPanel()
	{
		//creates a close button to allow user to exit whenever
		closeButton = new JButton("Close");
		closeButton.addActionListener(new closeButtonListener());

		nextButton = new JButton("NEXT");
		nextButton.addActionListener(new nextButtonListener());

		backButton = new JButton("BACK");
		backButton.addActionListener(new backButtonListener());

		backToHomeButton = new JButton("Back to Home");
		backToHomeButton.addActionListener(new backHomeButtonListener());
		
		gameWelcomeButton = new JButton("Game Page");
		gameWelcomeButton.addActionListener(new gameWelcomeListener());

		//add buttons to a panel
		buttonPanel = new JPanel();
		buttonPanel.setBackground(Controller.buttonPanelColor);
		buttonPanel.add(backToHomeButton);
		buttonPanel.add(closeButton); 
		buttonPanel.add(backButton);
		backButton.setVisible(false);
		buttonPanel.add(nextButton);
		buttonPanel.add(gameWelcomeButton);
		gameWelcomeButton.setVisible(false);

		topPanel = new JPanel();
		topPanel.setBackground(Controller.buttonPanelColor);
		JLabel text = new JLabel("Binary Kids");
		text.setFont(new Font("Geneva", Font.PLAIN, 8));
		text.setForeground(Controller.buttonPanelColor);
		topPanel.add(text);

	}

//override paint method
	public void paint(Graphics g) 
	{     	
		super.paint(g);
		if (pageFlag > 10){
			nextButton.setVisible(false);
			backButton.setVisible(false);
		}
			
		
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

	/* gameWelcomeButton- 
	 * Create a new custom listener that is an inner class
	 * to handle when user clicks back to game button on
	 * game instructions page
	 */
	class gameWelcomeListener implements ActionListener 
	{
		public void actionPerformed(ActionEvent e) 
		{
			loadCard("GAME WELCOME");
		}
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

	//load new card based on key
	public void loadCard(String key){
		if (key.equals("DEC BIN PAGE 1")){
			decToBinPage = new DecToBinPage(welcome);
			nextButton.setVisible(false);
		}
		else if (key.equals("DEC BIN PAGE 2")){
			decToBinPage2 = new DecToBinPage2(welcome);
			nextButton.setVisible(false);
		}
		else if (key.equals("DEC BIN PAGE 3")){
			decToBinPage3 = new DecToBinPage3(welcome);
			nextButton.setVisible(false);
		}
		else if (key.equals("DEC BIN PAGE 4")){
			decToBinPage4 = new DecToBinPage4(welcome);
			nextButton.setVisible(false);
		}
		else if (key.equals("BIN DEC PAGE 1")){
			bdOne = new BinaryDecimalOne(welcome);
			nextButton.setVisible(false);
		}
		else if (key.equals("BIN DEC PAGE 2")){
			bdTwo = new BinaryDecimalTwo(welcome);
			nextButton.setVisible(false);
		}
		else if (key.equals("BIN DEC PAGE 3")){
			bdThree = new BinaryDecimalThree(welcome);
			nextButton.setVisible(false);
		}
		else if (key.equals("BIN DEC PAGE 4")){
			bdFour = new BinaryDecimalFour(welcome);
			nextButton.setVisible(false);
		}
		else if (key.equals("FOURTH")){
			nextButton.setVisible(false);
			backButton.setVisible(false);
		}
		else if (key.equals("GAME WELCOME")){
			cards.add(gameWelcomePage, "GAME WELCOME");
			gameWelcomeButton.setVisible(false);
		}
		else if (key.equals("GAME")){
			gamePage = new GamePage(welcome);
			gamePage.timer.start();
			cards.add(gamePage, "GAME");
		}
		else if (key.equals("GAME INSTRUCTIONS")){
			gameInstructionsPage = new gameInstructions(welcome);
			cards.add(gameInstructionsPage, "GAME INSTRUCTIONS");
			gameWelcomeButton.setVisible(true);
		}


		cardLayout.show(cards, key);
		invalidate();
		validate();
		setVisible(true);
		repaint();
	}
	

	public void background(){
		startPage = new StartPage(welcome);
		notOnStartScreen = false;
		inTutorial = false;
		pageFlag = 0;
		backButton.setVisible(false);
		nextButton.setVisible(true);
		cardLayout.show(cards, "START PAGE");
		validate();
		setVisible(true);
		repaint();
	}

	
	//action listener for back home button
	class backHomeButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			startPage = new StartPage(welcome);
			notOnStartScreen = false;
			inTutorial = false;
			pageFlag = 0;
			backButton.setVisible(false);
			nextButton.setVisible(true);
			cardLayout.show(cards, "START PAGE");
			validate();
			setVisible(true);
			repaint();	
		}
	}


//	public void returnGameWelcome(){
//
//	}

	//action listener for back button
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
			
			if(pageFlag == 2)
			{
				nextButton.setVisible(true);
			}
			cardLayout.previous(cards);
			validate();
			setVisible(true);
			repaint();	
		}
	}

	//action listener for next button
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


			//handling animation
			if(pageFlag == 1)
			{
				numRepresentationPage.timer.start();
			}
			else if(pageFlag == 5)
			{
				bitsPage.timer.start();
			}
			else if(pageFlag == 6)
			{
				preDemoPage.timer.start();
			}
			else if(pageFlag == 7)
			{
				preDemoBinaryPage.timer.start();
			}
			else if(pageFlag == 8)
			{
				demoPage.timer.start();
			}
			else if(pageFlag == 9)
			{
				demoPage2.timer.start();
			}

			//back button
			//if flag greater than 10, means user is in tutorial
			//or game pages with no need for back or button
			if(pageFlag > 10)
			{
				backButton.setVisible(false);
				nextButton.setVisible(false);
			}

			//handling next button visibility
			if(pageFlag == 3)
			{
				nextButton.setVisible(false);
			}
			else
			{
				nextButton.setVisible(true);
			}
			repaint();

		} //end action performed

	} //end class nextButtonListener

} //end class WelcomePage
