package fr.epita.quiz.services.data;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class Configuration {

	private static Properties properties = new Properties();
	private static boolean isInit = false;

	public static void init() throws FileNotFoundException, IOException {
		String location = System.getProperty("conf.location");
		properties.load(new FileInputStream(new File(location)));
		isInit = true;
	}

	public static String getValue(String key) {
		if (!isInit) {
			try {
				init();
			} catch (Exception e) {
				// TODO do a custom exception
			}
		}
		return properties.getProperty(key);
	}

}
