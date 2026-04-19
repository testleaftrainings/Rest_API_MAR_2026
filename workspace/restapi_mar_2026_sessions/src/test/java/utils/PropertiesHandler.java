package utils;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class PropertiesHandler {	

	public static String config(String key) {
		Properties properties = new Properties();
		String value = null;
		try {
			properties.load(new FileInputStream(new File("src/test/resources/"+getTypeOfApi()+"/config.properties")));
			value = properties.getProperty(key);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}

	public static String secret(String key) {
		Properties properties = new Properties();
		String value = null;
		try {
			properties.load(new FileInputStream(new File("src/test/resources/"+getTypeOfApi()+"/secret.properties")));
			value = properties.getProperty(key);
		} catch (FileNotFoundException e) {
			throw new RuntimeException(
					"Unable to found \"secret.properties\" file in the mentioned \"src/test/resources/"+getTypeOfApi()+"location.");
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
	
	private static String getTypeOfApi() {
		Properties properties = new Properties();
		String value = null;
		try {
			properties.load(new FileInputStream(new File(System.getProperty("user.dir")+File.separator+"config.properties")));
			value = properties.getProperty("aut.api.name");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return value;
	}
}