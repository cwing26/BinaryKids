package Test;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import Tutorial.Controller;
import Tutorial.BinaryToDecimalPractice;
import Tutorial.DecimalToBinaryPractice;

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
		controller.init();
		decToBinPractice = new DecimalToBinaryPractice(controller);
		binToDecPractice = new BinaryToDecimalPractice(controller);
	}

	@After
	public void tearDown() throws Exception {
	}

	
	//determines whether the correct number of questions
	//have been put into each array, checking whether they're
	//equal or not
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
	
	//determines whether the right number of solutions have
	//calculated and populated into the right array
	@Test
	public void initializeQuestionsTestDB()
	{
		int practiceValues = 200;
		binToDecPractice.populateQuestionArrays(practiceValues);
		binToDecPractice.populateAnswerArray(practiceValues);

		int questionSize = binToDecPractice.values.size();
		int answersSize = binToDecPractice.solutions.size();
		
		assertEquals(answersSize, practiceValues, 0);
	}
	
	//tests whether binary conversion algorithm was implemented
	//properly by randomly generating arrays of questions and solutions,
	//choosing an arbitrary index from the array, and determining whether
	//the question and the solution correspond
	@Test
	public void checkAnswerCalculationDB()
	{
		int practiceValues = 200;
		decToBinPractice.populateQuestionArrays(practiceValues);
		decToBinPractice.populateAnswerArray(practiceValues);

		int index = 10;
		
		int convertNum = decToBinPractice.values.get(index);
		
		String answer = decToBinPractice.binaryConversion(convertNum);
		
		boolean equal = decToBinPractice.solutions.get(index).equals(answer);

		assertTrue(equal);
	}
	
	//tests whether the hintclicked flags accurately
	//keeps track of whether hint click button has been
	//clicked or not on both practice problems pages
	@Test
	public void checkHintClicked()
	{
		assertFalse(decToBinPractice.hintClicked);
		assertFalse(binToDecPractice.hintClicked);
	}
	
	//tests whether all of the randomly generated questions
	//are within the correct bounds of difficulty (below 64)
	@Test
	public void checkRandNum()
	{
		int practiceValues = 200;
		
		decToBinPractice.populateQuestionArrays(practiceValues);
		
		assertTrue(decToBinPractice.values.get(15) < 64);

	}

}
