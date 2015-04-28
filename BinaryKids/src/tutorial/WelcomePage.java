package tutorial;


import game.GamePage2;

import javax.swing.ImageIcon;
import javax.swing.JApplet;
import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingUtilities;

import unused.GamePage;

import java.awt.*; 
import java.awt.event.*;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Toolkit;
import java.io.IOException;
import java.net.URL;


@SuppressWarnings("serial")
public class WelcomePage extends JApplet
{
	boolean inTutorial = false;
	boolean notOnStartScreen = false;
	WelcomePage welcome = this;

	int pageFlag = 0;

	private int frameWidth = 800;
	private int frameHeight = 620;

	//custom colors
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
	private DecimalToBinaryPractice decToBinPractice;
	private BinaryDecimalOne bdOne;
	private BinaryDecimalTwo bdTwo;
	private BinaryDecimalThree bdThree;
	private BinaryDecimalFour bdFour;
	private BinaryToDecimalPractice bdPractice;
	private GamePage2 gamePage;

	//top panel commponents
	JPanel buttonPanel;
	JButton nextButton;
	JButton closeButton;
	JButton tutorialButton;
	JButton debugButton;
	JButton gameButton;
	JButton backButton;
	JButton backToHomeButton;

	CardLayout cardLayout;
	JPanel cards;

	Container contentPane;

	private String userAnswer = "";


	
	//image paths
	public static String titlePath = "images/titleTextImage.jpg";
	public static String titleImagePath = "images/titleImage.jpg";
	public static String lightOnImagePath = "images/lightOn.jpg";
	public static String lightOffImagePath = "images/lightOff.jpg";
	public static String binDecPg3TitleImagePath = "images/BinDecPg3Title.jpg";
	public static String tutorialImgPath = "images/tutorials.jpg";
	
	public static String tutorialCompleteImgPath = "images/tutorialComplete.jpg";
	public static String checkmarkImgPath = "images/checkmark.png";
	
	//meghan's added images
	public static String welcomeToBKPath = "images/welcomeToBKTitle.jpg";
	public static String binDecImgPath = "images/BinToDec.jpg";

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
	public static String binPracticeProblemPath = "images/binPracticeProblemTitle.png";
	public static String hintGraphicPath = "images/hintGraphic.gif";
	public static String decPracticeProblemPath = "images/decPracticeProblemsTitle.jpg";

	
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
		//cardLayout.show(cards, "FOURTH");
		cardLayout.show(cards, "START PAGE");  //here

		//add buttonPanel to the top of game frame
		add(buttonPanel, BorderLayout.NORTH);

		// Setup the applet
		getContentPane().setBackground(backgroundColor);
		setName("BinaryKids");
		setSize(frameWidth, frameHeight);
	}
	
	public void addComponents(){
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
		cards.add(decToBinPractice, "DEC BIN PAGE 5");
		cards.add(bdOne, "BIN DEC PAGE 1");
		cards.add(bdTwo, "BIN DEC PAGE 2");
		cards.add(bdThree, "BIN DEC PAGE 3");
		cards.add(bdFour, "BIN DEC PAGE 4");
		cards.add(bdPractice, "BIN DEC PAGE 5");
		//cards.add(gamePage, "GAME");
	}
	
	public void initComponents(){
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
		decToBinPractice = new DecimalToBinaryPractice(this);
		bdOne = new BinaryDecimalOne(this);
		bdTwo = new BinaryDecimalTwo(this);
		bdThree = new BinaryDecimalThree(this);
		bdFour = new BinaryDecimalFour(this);
		bdPractice = new BinaryToDecimalPractice(this);
		//gamePage = new GamePage2(this);
	}

	public void loadImages()
	{
		//chris images
		titleImg = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.titleImagePath));
		titleImg = titleImg.getScaledInstance(550, 300, Image.SCALE_SMOOTH);

		titleTextImg = titleTextImg.getScaledInstance(700, 40, Image.SCALE_SMOOTH);
		decBinHeadlineImg = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.binDecPg3TitleImagePath));  
		decBinHeadlineImg = decBinHeadlineImg.getScaledInstance(650, 50, Image.SCALE_SMOOTH);

		titleHeadline = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.welcomeToBKPath)); 
		titleHeadline = titleHeadline.getScaledInstance(586, 50, Image.SCALE_SMOOTH);

		tutorialHeadline = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.tutorialImgPath)); 
		tutorialHeadline = tutorialHeadline.getScaledInstance(280, 40, Image.SCALE_SMOOTH);
		
		binDecImg = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.binDecImgPath)); 
		binDecImg = binDecImg.getScaledInstance(600, 50, Image.SCALE_SMOOTH);
		
		tutorialCompleteImg = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.tutorialCompleteImgPath)); 
		tutorialCompleteImg = tutorialCompleteImg.getScaledInstance(400, 40, Image.SCALE_SMOOTH);
		
		checkmarkImg = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.checkmarkImgPath)); 
		checkmarkImg = checkmarkImg.getScaledInstance(40, 40, Image.SCALE_SMOOTH);

		//num rep page
		binaryImageLight = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.binaryImageLightPath)); 
		binaryImageLight = binaryImageLight.getScaledInstance(354, 44, Image.SCALE_SMOOTH);
		
		binaryImageDark = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.binaryImageDarkPath)); 
		binaryImageDark = binaryImageDark.getScaledInstance(354, 44, Image.SCALE_SMOOTH);
		
		numRepTitleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.numRepTitlePath)); 
		numRepTitleImage = numRepTitleImage.getScaledInstance(780, 44, Image.SCALE_SMOOTH);
		
		decimalTitleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.decimalImagePath)); 
		decimalTitleImage = decimalTitleImage.getScaledInstance(444, 40, Image.SCALE_SMOOTH);
		
		romanNumeralTitleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.romanNumeralImagePath)); 
		romanNumeralTitleImage = romanNumeralTitleImage.getScaledInstance(435, 40, Image.SCALE_SMOOTH);
		
		shapesTitleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.shapesImagePath)); 
		shapesTitleImage = shapesTitleImage.getScaledInstance(164, 48, Image.SCALE_SMOOTH);
		
		soccerBall = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.soccerBallPath)); 
		soccerBall = soccerBall.getScaledInstance(150, 151, Image.SCALE_SMOOTH);
		
		//num rep 2 page
		numRep2TitleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.whatBinaryTitlePath)); 
		numRep2TitleImage = numRep2TitleImage.getScaledInstance(673, 50, Image.SCALE_SMOOTH);
		
		dogImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.dogBinaryImagePath)); 
		dogImage = dogImage.getScaledInstance(121, 224, Image.SCALE_SMOOTH);
		
		bikeImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.bikeImagePath)); 
		bikeImage = bikeImage.getScaledInstance(192, 124, Image.SCALE_SMOOTH);
		
		binocImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.binocularsPath)); 
		binocImage = binocImage.getScaledInstance(166, 159, Image.SCALE_SMOOTH);
	
		//first page
    		firstPageTitleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.whyBinaryImportantTitlePath)); 
    		firstPageTitleImage = firstPageTitleImage.getScaledInstance(790, 43, Image.SCALE_SMOOTH);
		
		instagramImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.instagramPath)); 
		instagramImage = instagramImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		
		fbImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.fbPath)); 
		fbImage = fbImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		
		youtubeImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.youtubePath)); 
		youtubeImage = youtubeImage.getScaledInstance(150, 160, Image.SCALE_SMOOTH);
		
		emailImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.emailPath)); 
		emailImage = emailImage.getScaledInstance(160, 116, Image.SCALE_SMOOTH);
		
		cellImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.cellPath)); 
		cellImage = cellImage.getScaledInstance(152, 152, Image.SCALE_SMOOTH);
		
		skypeImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.skypePath)); 
		skypeImage = skypeImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		
		gameImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.gamePath)); 
		gameImage = gameImage.getScaledInstance(150, 150, Image.SCALE_SMOOTH);
		
		//second page images
		secondPageTitleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.whyBinaryImportantTitlePath)); 
		secondPageTitleImage  = secondPageTitleImage .getScaledInstance(790, 43, Image.SCALE_SMOOTH);
		
		 
		instagramImage2 = instagramImage.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		
		fbImage2 = fbImage.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		
		youtubeImage2 = youtubeImage.getScaledInstance(95, 96, Image.SCALE_SMOOTH);
		
		emailImage2 = emailImage.getScaledInstance(95, 69, Image.SCALE_SMOOTH);
		
		cellImage2 = cellImage.getScaledInstance(92, 92, Image.SCALE_SMOOTH);
		
		skypeImage2 = skypeImage.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		
		gameImage2 = gameImage.getScaledInstance(90, 90, Image.SCALE_SMOOTH);
		
		lightOff = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.lightOffPath)); 
		lightOff = lightOff.getScaledInstance(145, 200, Image.SCALE_SMOOTH);
		
		lightOn = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.lightOnPath)); 
		lightOn = lightOn.getScaledInstance(148, 200, Image.SCALE_SMOOTH);
		
		//third page images
    		thirdPageTitleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.whyBinaryImportantTitlePath)); 
    		thirdPageTitleImage = thirdPageTitleImage.getScaledInstance(790, 43, Image.SCALE_SMOOTH);
	
		binaryDigitImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.binaryDigitPath)); 
		binaryDigitImage = binaryDigitImage.getScaledInstance(150, 157, Image.SCALE_SMOOTH);

		
		//pre demo binary images
    		preDemoBinaryTitleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.binBasicsPath)); 
    		preDemoBinaryTitleImage = preDemoBinaryTitleImage.getScaledInstance(600, 50, Image.SCALE_SMOOTH);
		
		crossOutImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.crossOutPath)); 
		crossOutImage = crossOutImage.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		
		//pre demo images
	   	preDemoTitleImage = Toolkit.getDefaultToolkit().getImage(
					getClass().getClassLoader().getResource(WelcomePage.decBasicsPath)); 
		preDemoTitleImage = preDemoTitleImage.getScaledInstance(650, 40, Image.SCALE_SMOOTH);
			
		//demo title image
		demoTitleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.puttingTogetherPath)); 
		demoTitleImage = demoTitleImage.getScaledInstance(680, 60, Image.SCALE_SMOOTH);
		
		 //demo 2
    		demo2TitleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.puttingTogetherPath)); 
		demo2TitleImage = demo2TitleImage.getScaledInstance(680, 60, Image.SCALE_SMOOTH);

		
		//practice problem images
		practiceProblemTitleImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.decPracticeProblemPath)); 
		practiceProblemTitleImage = practiceProblemTitleImage.getScaledInstance(790, 40, Image.SCALE_SMOOTH);
		
		hintImage = Toolkit.getDefaultToolkit().getImage(
				getClass().getClassLoader().getResource(WelcomePage.hintGraphicPath)); 
		hintImage = hintImage.getScaledInstance(331,147, Image.SCALE_SMOOTH);
		
		
		//try to load the image file
		try {
			binaryGraphic = new ImageIcon(new URL("http://media.giphy.com/media/nlJF31X6I1LW/giphy.gif")).getImage();
			binaryGraphic = binaryGraphic.getScaledInstance(200, 200, Image.SCALE_SMOOTH);
		} catch (IOException e) {
			System.out.println("Please check image file path.");
			binaryGraphic = Toolkit.getDefaultToolkit().getImage(
					getClass().getClassLoader().getResource(WelcomePage.titleImagePath));
			binaryGraphic = binaryGraphic.getScaledInstance(600, 280, Image.SCALE_SMOOTH);
			e.printStackTrace();
		};
		
		
	}


	
	public void setCompletedDecBin(){
		fourthPage.completedDecBin = true;
		repaint();
	}
	
	public void setCompletedBinDec(){
		fourthPage.completedBinDec = true;
		repaint();
	}
	
	public void createButtonPanel()
	{
		//creates a close button to allow user to exit whenever
		closeButton = new JButton("Close");
		closeButton.addActionListener(new closeButtonListener());

		nextButton = new JButton("NEXT");
		nextButton.addActionListener(new nextButtonListener());

		tutorialButton = new JButton("Tutorials");
		tutorialButton.addActionListener(new tutorialButtonListener());

		backButton = new JButton("BACK");
		backButton.addActionListener(new backButtonListener());

		backToHomeButton = new JButton("Back to Home");
		backToHomeButton.addActionListener(new backHomeButtonListener());

		//add buttons to a panel
		buttonPanel = new JPanel();
		buttonPanel.setBackground(WelcomePage.buttonPanelColor);
		buttonPanel.add(backToHomeButton);
		buttonPanel.add(closeButton); 
		buttonPanel.add(backButton);
		backButton.setVisible(false);
		buttonPanel.add(nextButton);


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

	public void loadCard(String key){
		if (key.equals("DEC BIN PAGE 1")){
			decToBinPage = new DecToBinPage(welcome);
		}
		else if (key.equals("DEC BIN PAGE 2")){
			decToBinPage2 = new DecToBinPage2(welcome);
		}
		else if (key.equals("DEC BIN PAGE 3")){
			decToBinPage3 = new DecToBinPage3(welcome);
		}
		else if (key.equals("DEC BIN PAGE 4")){
			decToBinPage4 = new DecToBinPage4(welcome);
		}
		else if (key.equals("BIN DEC PAGE 1")){
			bdOne = new BinaryDecimalOne(welcome);
		}
		else if (key.equals("BIN DEC PAGE 2")){
			bdTwo = new BinaryDecimalTwo(welcome);
		}
		else if (key.equals("BIN DEC PAGE 3")){
			bdThree = new BinaryDecimalThree(welcome);
		}
		else if (key.equals("BIN DEC PAGE 4")){
			bdFour = new BinaryDecimalFour(welcome);
		}
		else if (key.equals("GAME")){
			gamePage = new GamePage2(welcome);
			cards.add(gamePage, "GAME");
		}
		
		
		cardLayout.show(cards, key);
		invalidate();
		validate();
		setVisible(true);
		repaint();
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
			validate();
			setVisible(true);
			repaint();	
		}
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

	
	class gameButtonListener implements ActionListener
	{
		public void actionPerformed(ActionEvent e) 
		{
			cardLayout.show(cards, "GAME");
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

		} //end action performed

	} //end class nextButtonListener

} //end class WelcomePage
