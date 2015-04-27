package tutorial;


public interface PracticeProblem 
{
	void initComponents();
	
	void loadImages();
	
	void populateQuestionArrays(int size);
	
	void populateAnswerArray(int size); 
	
	int setQuestion();
	
	boolean checkAnswer(String userAnswer, int index);

	
}