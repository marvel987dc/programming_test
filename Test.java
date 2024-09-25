package testpac;

import javax.swing.JOptionPane;
import java.util.Random;

public class Test {
    // Array of questions
    static String[] questions = {
        "1. What does a method stand for?",
        "2. Which method integrated in Java is useful to show the actual date time?",
        "3. What is a Driver class?",
        "4. Which of these could be an object in real life?",
        "5. What is a constructor for?"
    };

    // Array of multiple-choice options for each question
    static String[][] options = {
        {"A. A block of code", "B. A function", "C. A variable", "D. An object"},
        {"A. DateTime", "B. Scanner", "C. LocalDate", "D. TimeZone"},
        {"A. The main class", "B. A class to create objects", "C. A utility class", "D. A data class"},
        {"A. A car", "B. A dog", "C. A house", "D. All of these"},
        {"A. To initialize an object", "B. To destroy an object", "C. To create a method", "D. To implement an interface"}
    };

    // Correct answers corresponding to each question
    static String[] correctAnswers = {"A", "C", "A", "D", "A"};
    int correctAnswersCount = 0;
    int incorrectAnswersCount= 0;
    
    public static String inputAnswer(String question, String[] options) {
    	String message = question + "\n\n" + String.join("\n", options);
    	String userAnswer = JOptionPane.showInputDialog(message);
    	return userAnswer.toUpperCase().trim();
    }

    
    public  void simulateQuestions() {
    	for(int i = 0; i < questions.length; i++) {
			String userAnswer = inputAnswer(questions[i], options[i]);
			checkAnswers(userAnswer, correctAnswers[i], i);
			
		}
		displayResults();
    }

	public void displayResults(){
		double percentage = (((double)correctAnswersCount / (double) questions.length) * 100);
		String message = "You got " + correctAnswersCount + " correct answers" + "\n" + "and " + incorrectAnswersCount + " incorrect"
				+ "\n" + "Percentage of correct answers: " + percentage + "%";
		JOptionPane.showMessageDialog(null, message);
	}
    
    public void checkAnswers(String userAnswer, String correctAnswer, int questionIndex) {
    	String message;
    	
    	if(userAnswer.equals(correctAnswer)) {
    		correctAnswersCount++;
    		 message = generateMessage(true);
    	}
    		else {
    			incorrectAnswersCount++;
    		 message = generateMessage(false);
    		}
    	JOptionPane.showMessageDialog(null, message);
    	}
    
    public String generateMessage(Boolean isCorrect) {
    	Random random = new Random();
    	switch(random.nextInt(4)) {
    	case 0:
    		return isCorrect ? "Excellent!" : "No, please try again";
    	case 1:
    		return isCorrect ? "Good" : "Weong, try once more";
    	case 2:
    		return isCorrect ? "keep up the good work!" : "Don't give up";
    	case 3:
    		return isCorrect ? "Nice Work!" : "No, keep trying";
    	}
		return null;
    }
}
  

