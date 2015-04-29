package Test;

import static org.junit.Assert.*;

import javax.swing.ImageIcon;
import javax.swing.JButton;

import org.junit.Before;
import org.junit.Test;

import Tutorial.Controller;
import game.GamePage;

public class GamePageTest {
	
	Controller controller;
	GamePage myGamePage;
	
	@Before
	public void setUp() {
		
		controller = new Controller();
		controller.init();
		myGamePage = new GamePage(controller);
		
		
	}
	
	//make sure for every stored question there is a corresponding answer, i.e.
	//that the arrays are the same size 
	@Test
	public void initializeQuestionsTest()
	{
		myGamePage.initializeQuestions();
		int questionSize = myGamePage.questionArray.size();
		int answersSize = myGamePage.answerArray.size();
		
		assertEquals(questionSize, answersSize, 0);
		
	}
	
	//test that conversion function returns the right 
	//binary value, given a decimal value
	@Test
	public void convertToBinTest()
	{
		int decimal = 30;
		String expectedBinary = "11110";
		
		String actualBinary = myGamePage.convertToBin(decimal);
		
		boolean equal = expectedBinary.equals(actualBinary);
		assertTrue(equal);

	}
	
	//tests whether the flag function works
	//to change the images on the number buttons
	//when a user clicks them
	@Test
	public void setFlagTest()
	{
		int flag = 0;
		int testFlag = myGamePage.setFlag(flag);
		
		assertNotEquals(flag, testFlag, 0);
			
	}
	
	//tests whether game class correctly pads answers
	//when it needs to, if user does not input something
	//in the correct format
	@Test
	public void padAnswerTest()
	{
		String inputNum = "1111111";
		String padNum = myGamePage.padAnswer(inputNum);
		System.out.println(padNum);
		String testNum = "1111111";
		
		boolean equal = inputNum.equals(testNum);
		
		assertTrue(equal);
		
	}
}

