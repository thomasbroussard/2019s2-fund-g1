package fr.epita.quiz.tests;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import fr.epita.quiz.datamodel.MCQQuestion;
import fr.epita.quiz.services.data.JDBCMCQQuestionDAO;

public class TestJDBCSerialization {

	public static void main(String[] args) throws SQLException {
		// 1 . connect to the database engine
		// a . username
		// b . password
		// c . engine/instance
		// d . declare what driver to use

		// simpleConnectionTest();

		Connection connection = DriverManager.getConnection("jdbc:h2:mem:test2", "test", "test");

		//testSearch(connection);
		testCreateThroughDAO(connection);
		connection.close();
	}

	private static void testSearch(Connection connection) throws SQLException {
		// given
		testCreate(connection);
		
		//when
		String searchQuery = "SELECT  ID, QUESTION, DIFFICULTY from MCQQUESTIONS\r\n" + 
				"where QUESTION LIKE ? \r\n" + 
				"and DIFFICULTY  < ?";
		
		PreparedStatement preparedStatement = connection.prepareStatement(searchQuery);
		preparedStatement.setString(1,"%" + "H2" +"%");
		preparedStatement.setInt(2,4);
		
		ResultSet rs = preparedStatement.executeQuery();
		while(rs.next()) {
			int id = rs.getInt("ID");
			String question = rs.getString("QUESTION");
			int difficulty = rs.getInt("DIFFICULTY");
			System.out.println(id + " "  + question + " " + difficulty);
		}

		connection.close();
	}

	private static void testCreate(Connection connection) throws SQLException {
		// given

		MCQQuestion question = new MCQQuestion();
		question.setDifficulty(3);
		question.setQuestion("What is H2?");
		String creationQuery = "CREATE TABLE IF NOT EXISTS MCQQUESTIONS(ID INT auto_increment PRIMARY KEY, QUESTION VARCHAR(500), DIFFICULTY INT)";
		PreparedStatement initialStatement = connection.prepareStatement(creationQuery);
		initialStatement.execute();
		initialStatement.close();

		// when

		PreparedStatement preparedStatement = connection
				.prepareStatement("INSERT INTO MCQQUESTIONS(QUESTION, DIFFICULTY) VALUES (?, ?)");
		preparedStatement.setString(1, question.getQuestion());
		preparedStatement.setInt(2, question.getDifficulty());
		int id = preparedStatement.executeUpdate();

		// then
		System.out.println(id);
		boolean success = id != 0;

		System.out.println("success : " + success);

		preparedStatement.close();
	}
	private static void testCreateThroughDAO(Connection connection) throws SQLException {
		// given
		
		MCQQuestion question = new MCQQuestion();
		question.setDifficulty(3);
		question.setQuestion("What is H2?");
		String creationQuery = "CREATE TABLE IF NOT EXISTS MCQQUESTIONS(ID INT auto_increment PRIMARY KEY, QUESTION VARCHAR(500), DIFFICULTY INT)";
		PreparedStatement initialStatement = connection.prepareStatement(creationQuery);
		initialStatement.execute();
		initialStatement.close();
		JDBCMCQQuestionDAO dao = new JDBCMCQQuestionDAO();
		
		// when
		int id = dao.create(question);
		
		// then
		System.out.println(id);
		boolean success = id != 0;
		
		System.out.println("success : " + success);
	
	}

	private static void simpleConnectionTest() throws SQLException {
		// given
		Connection connection = DriverManager.getConnection("jdbc:h2:mem:test2", "test", "test");
		// when
		String schema = connection.getSchema();
		// then
		boolean success = "PUBLIC".equals(schema);
		System.out.println("success : " + success);
		connection.close();
	}

}
