package fr.epita.quiz.tests;

import fr.epita.quiz.datamodel.MCQQuestion;
import fr.epita.quiz.services.data.MCQQuestionDAO;

public class TestMCQQuestionCSVDAO {

	public static void main(String[] args) {
		//given
		MCQQuestion question = new MCQQuestion();
		question.setDifficulty(3);
		question.setQuestion("What is CSV?");
		question.setTopics(new String[] {"file", "format", "text"});
		question.setId(3l);
		
		MCQQuestionDAO dao = new MCQQuestionDAO();
		
		//when
		dao.create(question);
		
		//then
		MCQQuestion retrievedQuestion = dao.getById(3);
		
		boolean success = retrievedQuestion.getQuestion().equals(question.getQuestion());
		System.out.println("success? " + success);
		
		
	}

}
