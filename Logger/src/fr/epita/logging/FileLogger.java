package fr.epita.logging;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.PrintWriter;

public class FileLogger extends Logger {

	private File file = new File("/temp/application.log");
	private PrintWriter writer;

	public FileLogger() throws FileNotFoundException {
		this.writer = new PrintWriter(new FileOutputStream(this.file, true));
	}

	@Override
	protected void print(String message) {

		this.writer.println(message);
		this.writer.flush();

	}

	public void terminate() {
		this.writer.close();
	}

}
