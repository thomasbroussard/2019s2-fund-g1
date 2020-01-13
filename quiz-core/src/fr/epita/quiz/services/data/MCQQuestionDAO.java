package fr.epita.quiz.services.data;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.PrintWriter;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import fr.epita.quiz.datamodel.MCQQuestion;

public class MCQQuestionDAO {
	
	
	private static final String FILE = Configuration.getValue("data.file");
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
		
		try (PrintWriter writer = new PrintWriter(new File(FILE));){
			writer.println(formatted);
		} catch (FileNotFoundException e) {
			//TODO probably define a custom exception.
			e.printStackTrace();
		}
	
	
	
	}
	public List<MCQQuestion> readAll() {
		
		List<MCQQuestion> results = new ArrayList<>();
		List<String> content = null;
		try {
			content = Files.readAllLines(new File(FILE).toPath());
			for (String line : content) {
				
				
				String[] parts = line.split(DELIMITER);
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
			}
		} catch (IOException e) {
			// TODO define a custom exception
			e.printStackTrace();
		}
		//TODO complete by reading all the lines from a file
		
		return results;
		
	}
	
	public MCQQuestion getById(int id) {
		List<MCQQuestion> list = readAll()
				.stream()
				.filter(mcqQuestion -> mcqQuestion.getId() == id)
				.collect(Collectors.toList());
		
		// TODO handle the case where we have more than one result

		return list.get(0);
	}

}
