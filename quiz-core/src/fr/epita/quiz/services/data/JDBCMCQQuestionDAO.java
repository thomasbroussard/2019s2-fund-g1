package fr.epita.quiz.services.data;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import fr.epita.quiz.datamodel.MCQQuestion;

public class JDBCMCQQuestionDAO {

	private static final String INSERT_QUERY = "INSERT INTO MCQQUESTIONS(QUESTION, DIFFICULTY) VALUES (?, ?)";

	public int create(MCQQuestion question) {
		try (Connection connection = DriverManager.getConnection("jdbc:h2:mem:test2", "test", "test");
			 PreparedStatement preparedStatement = connection.prepareStatement(INSERT_QUERY);) {

			preparedStatement.setString(1, question.getQuestion());
			preparedStatement.setInt(2, question.getDifficulty());
			int id = preparedStatement.executeUpdate();

			return id;
		} catch (Exception e) {
			//throw a custom exception
			e.printStackTrace();
		}
		return 0;

	}

}
