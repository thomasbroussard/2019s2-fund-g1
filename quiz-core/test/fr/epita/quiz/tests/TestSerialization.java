package fr.epita.quiz.tests;

import java.util.Arrays;

import fr.epita.quiz.datamodel.MCQQuestion;

public class TestSerialization {

	
	private static final String TOPIC_DELIMITER = "|";
	private static final String DELIMITER = "@@@@";

	public static void main(String[] args) {
		
		MCQQuestion question = new MCQQuestion();
		question.setDifficulty(3);
		question.setTopics(new String[] {"java","uml","oop"});
		question.setQuestion("What is the keyword to define inheritance between 2 classes in java?");
		question.setId(1l);
		
		
		//we want to format it to : 
		//id;question;difficulty;topic1|topic2|topic3|...|topicn
		
		//formatting phase:
		String formatted = String.valueOf(question.getId()) + DELIMITER;
		formatted += question.getQuestion() + DELIMITER;
		formatted += question.getDifficulty() + DELIMITER;
		
		String[] topics = question.getTopics();
		for (int i = 0; i < topics.length; i++) {
			formatted += topics[i] + TOPIC_DELIMITER;
		}
	
		
		
		System.out.println(formatted);
		
		
		
		//reconstruction phase
		
		String[] parts = formatted.split(DELIMITER);
		Long id = Long.valueOf(parts[0]);
		String readQuestion = parts[1];
		Integer difficulty = Integer.valueOf(parts[2]);
		String rawTopics = parts[3];
		String[] subparts = rawTopics.split("\\" +TOPIC_DELIMITER);
		
		MCQQuestion readInstance = new MCQQuestion();
		readInstance.setId(id);
		readInstance.setQuestion(readQuestion);
		readInstance.setDifficulty(difficulty);
		readInstance.setTopics(subparts);
		
		
		System.out.println(Arrays.asList(parts));
		
		
	}
}
