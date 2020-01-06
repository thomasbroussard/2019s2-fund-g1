package fr.epita.logging;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Logger {
	
	public void log(String message) {
		SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss.SSS");
		String timestamp = sdf.format(new Date());
		
		print(format(message, timestamp));
		
	}

	protected void print(String message) {
		System.out.println(message);
	}

	private String format(String message, String timestamp) {
		return timestamp + " -- " + message;
	}

}
