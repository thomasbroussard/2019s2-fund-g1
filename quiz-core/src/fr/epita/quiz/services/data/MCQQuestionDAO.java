package fr.epita.quiz.services.data;

import java.util.ArrayList;
import java.util.List;

import fr.epita.quiz.datamodel.MCQQuestion;

public class MCQQuestionDAO {
	
	
	private static final String TOPIC_DELIMITER = "|";
	private static final String DELIMITER = "@@@@";
	
	public void create(MCQQuestion question) {
		String formatted = String.valueOf(question.getId()) + DELIMITER;
		formatted += question.getQuestion() + DELIMITER;
		formatted += question.getDifficulty() + DELIMITER;
		
		String[] topics = question.getTopics();
		for (int i = 0; i < topics.length; i++) {
			formatted += topics[i] + TOPIC_DELIMITER;
		}
		
		//TODO complete by appending the formatted line in file
	
	}
	public List<MCQQuestion> readAll() {
		
		List<MCQQuestion> results = new ArrayList<>();
		//TODO complete by reading all the lines from a file
		
		//while there is something to read in the file;
		
			String formatted = ""; //TODO this is the current read line
	
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
		
		results.add(readInstance);
		
		return results;
		
	}
	
	public MCQQuestion getById() {
		//TODO complete
		return null;
	}

}
