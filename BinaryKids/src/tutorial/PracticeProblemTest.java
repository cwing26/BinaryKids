package tutorial;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

public class PracticeProblemTest {

	//check correct answer method
	//check algorithm to calcaulte
	
	Controller controller;
	DecimalToBinaryPractice decToBinPractice;
	BinaryToDecimalPractice binToDecPractice;
	
	@Before
	public void setUp() throws Exception 
	{
		controller = new Controller();
		decToBinPractice = new DecimalToBinaryPractice(controller);
		binToDecPractice = new BinaryToDecimalPractice(controller);
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		fail("Not yet implemented");
	}
	
	@Test
	public void initializeQuestionsTestBD()
	{
		int practiceValues = 200;
		decToBinPractice.populateQuestionArrays(practiceValues);
		decToBinPractice.populateAnswerArray(practiceValues);

		int questionSize = decToBinPractice.values.size();
		int answersSize = decToBinPractice.solutions.size();
		
		assertEquals(questionSize, answersSize, 0);
	}
	
	@Test
	public void initializeQuestionsTestDB()
	{
		int practiceValues = 200;
		binToDecPractice.populateQuestionArrays(practiceValues);
		binToDecPractice.populateAnswerArray(practiceValues);

		int questionSize = binToDecPractice.values.size();
		int answersSize = binToDecPractice.solutions.size();
		
		assertEquals(questionSize, answersSize, 0);
	}
	
	@Test
	public void checkAnswerCalculationDB()
	{
		int practiceValues = 200;
		decToBinPractice.populateQuestionArrays(practiceValues);
		decToBinPractice.populateAnswerArray(practiceValues);

		int index = 10;
		
		int convertNum = decToBinPractice.values.get(index);
		
		String answer = decToBinPractice.binaryConversion(convertNum);
		
		assertEquals(answer, decToBinPractice.solutions.get(index),0);
	}
	
	@Test
	public void checkHintClicked()
	{
		assertFalse(decToBinPractice.hintClicked);
		assertFalse(binToDecPractice.hintClicked);
	}
	
	@Test
	public void checkRandNum()
	{
		int practiceValues = 200;
		decToBinPractice.populateQuestionArrays(practiceValues);
		
		assertTrue(decToBinPractice.values.get(15) < 64);

	}

}
