package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Tutorial.Controller;
import Tutorial.BinaryDecimalOne;
import Tutorial.DecToBinPage;


public class TutorialTest {
	
	Controller controller;
	
	BinaryDecimalOne bdOne;
	DecToBinPage dbOne;
	
	@Before
	public void setUp() throws Exception 
	{
		controller = new Controller();
		controller.init();
		
		bdOne = new BinaryDecimalOne(controller);
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
	
	//tests whether class checks user input correctly
	//using string equality to avoid errors when trying
	//to parse an int from a non-numerical answer
	@Test
	public void testUserInputDB() 
	{
		String input = "11";
		
		assertTrue(dbOne.checkAnswer(input));
	}

}
