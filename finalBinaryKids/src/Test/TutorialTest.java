package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Tutorial.BinaryDecimalThree;
import Tutorial.BinaryDecimalTwo;
import Tutorial.Controller;
import Tutorial.BinaryDecimalOne;
import Tutorial.DecToBinPage;
import Tutorial.DecToBinPage2;
import Tutorial.DecToBinPage3;


public class TutorialTest {

	Controller controller;

	BinaryDecimalOne bdOne;
	BinaryDecimalTwo bdTwo;
	BinaryDecimalThree bdThree;
	DecToBinPage dbOne;
	DecToBinPage2 dbTwo;
	DecToBinPage3 dbThree;

	@Before
	public void setUp() throws Exception 
	{
		controller = new Controller();
		controller.init();

		bdOne = new BinaryDecimalOne(controller);
		bdTwo = new BinaryDecimalTwo(controller);
		bdThree = new BinaryDecimalThree(controller);
		dbOne = new DecToBinPage(controller);
		dbTwo = new DecToBinPage2(controller);
		dbThree = new DecToBinPage3(controller);
		dbOne = new DecToBinPage(controller);


	}

	@After
	public void tearDown() throws Exception {
	}

	//tests whether class checks user input correctly
	//using string equality to avoid errors when trying
	//to parse an int from a non-numerical answer
	@Test
	public void testUserInputBD() 
	{
		String input = "44";

		assertFalse(bdOne.checkAnswer(input));


	}


	//tests to make sure user entered correct input in binary decimal tutorial 2
	@Test
	public void testUserInputBD2() 
	{
		//1101 correct answer
		bdTwo.numEightsInput = "1";
		bdTwo.numFoursInput = "1";
		bdTwo.numTwosInput = "0";
		bdTwo.numOnesInput = "1";

		assertTrue(bdTwo.checkAnswer());

		//incorrect answer
		bdTwo.numEightsInput = "1";
		bdTwo.numFoursInput = "0";
		bdTwo.numTwosInput = "0";
		bdTwo.numOnesInput = "1";
		assertFalse(bdTwo.checkAnswer());

	}

	//tests to make sure user entered correct input in binary decimal tutorial 3
	@Test
	public void testUserInputBD3() 
	{
		//13 correct answer
		bdThree.numTensInput = "1";
		bdThree.numOnesInput = "3";
		assertTrue(bdThree.checkAnswer());

		//incorrect answer
		bdThree.numTensInput = "1";
		bdThree.numOnesInput = "1";
		assertFalse(bdThree.checkAnswer());

	}

	//tests whether class checks user input correctly
	//using string equality to avoid errors when trying
	//to parse an int from a non-numerical answer
	@Test
	public void testUserInputDB() 
	{
		String input = "11";

		assertTrue(dbOne.checkAnswer(input));
	}

	//tests to make sure user entered correct input in decimal binary tutorial 2
	@Test
	public void testUserInputDB2() 
	{
		//11 correct answer
		dbTwo.numTensInput = "1";
		dbTwo.numOnesInput = "1";
		assertTrue(dbTwo.checkAnswer());

		//incorrect answer
		dbTwo.numTensInput = "2";
		dbTwo.numOnesInput = "1";
		assertFalse(dbTwo.checkAnswer());
	}


	//tests to make sure user entered correct input in decimal binary tutorial 3
	@Test
	public void testUserInputDB3() 
	{
		//1011 correct answer
		dbThree.numEightsInput = "1";
		dbThree.numFoursInput = "0";
		dbThree.numTwosInput = "1";
		dbThree.numOnesInput = "1";
		assertTrue(dbThree.checkAnswer());

		//incorrect answer
		dbThree.numEightsInput = "1";
		dbThree.numFoursInput = "0";
		dbThree.numTwosInput = "0";
		dbThree.numOnesInput = "1";
		assertFalse(dbThree.checkAnswer());
	}


}
