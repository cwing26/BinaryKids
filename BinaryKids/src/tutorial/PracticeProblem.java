package tutorial;


//this interface is used to standardize the structure and presentation
//of practice problems at the end of the binary to decimal and decimal to binary 
//tutorials. Abstract methods that are overridden in the BinaryToDecimalPractice 
//and DecimalToBinaryPractice classes include methods to populate question and answer
//arrays with random problems to solve, checking whether user input is the correct answer
//and initializing all of the GUI components required to handle user input of practice problem
//answers

public interface PracticeProblem 
{
	//initializes all GUI components on screen, including 
	//a text field, submit button, hint button
	void initComponents();
	
	//loads requisite images for each practice problem, including
	//a title and a hint graphic
	void loadImages();
	
	//populated question arrays with either decimal
	//or binary numbers
	void populateQuestionArrays(int size);
	
	//calculates and stores the conversion to the
	//other type of number
	void populateAnswerArray(int size); 
	
	//selects a random question to display
	int setQuestion();
	
	//checks whether the user answer provided is correct
	boolean checkAnswer(String userAnswer, int index);

	
}