package game;

import static org.junit.Assert.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import org.junit.Before;
import org.junit.Test;

import tutorial.Controller;


public class GamePage2Test {
	
	Controller controller;
	GamePage2 myGamePage2;
	
	@Before
	public void setUp() {
		
		controller = new Controller();
		myGamePage2 = new GamePage2(controller);
		
	}
	
	//make sure for every stored question there is a corresponding answer, i.e.
	//that the arrays are the same size 
	@Test
	public void initializeQuestionsTest()
	{
		myGamePage2.initializeQuestions();
		int questionSize = myGamePage2.questionArray.size();
		int answersSize = myGamePage2.answerArray.size();
		
		assertEquals(questionSize, answersSize, 0);
		
	}
	
	//test that conversion function returns the right 
	//binary value, given a decimal value
	@Test
	public void convertToBinTest()
	{
		int decimal = 30;
		String expectedBinary = "11110";
		
		String actualBinary = myGamePage2.convertToBin(decimal);
		
		assertEquals(expectedBinary, actualBinary, 0);
		
	}
	
	
	//test that changeButton test correctly switches
	//from current digit (either 0 or 1) to opposite digit
	//(eiter 1 or 0)
	
	@Test
	public void changeButtonTest()
	{
		JButton myButton = new JButton();
		myButton.setIcon(new ImageIcon(controller.game0ButtonImage));
		int myButtonFlag = 0;
		
		myGamePage2.changeButton(myButton, myButtonFlag);
		
		assertTrue(myButton.getIcon() == new ImageIcon(controller.game0ButtonImage));
			
	}
}

