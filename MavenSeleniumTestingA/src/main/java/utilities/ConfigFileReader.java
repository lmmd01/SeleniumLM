package utilities;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ConfigFileReader {

	private Properties properties;
	private final String propertyFilePath = "configs//Configuration.properties";

	public  ConfigFileReader() {
		BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}
	}

	public String getStandarUser() {
		String user = properties.getProperty("standar-user");
		if (user != null)
			return user;
		else
			throw new RuntimeException("Variable not specified in the Configuration.properties file.");
	}

	public String getStandarPassword() {
		String pass = properties.getProperty("standar-pass");
		if (pass != null)
			return pass;
		else
			throw new RuntimeException("Variable is not specified in the Configuration.properties file.");
	}

}
