package n2Exercici1;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

public class Config {
	
	private static final String ARCHIVO = "C:\\Users\\Public\\Downloads\\config.properties";
	
	public static String leer(String key) {

		String value = null;

		try (InputStream ips = new FileInputStream(ARCHIVO)) {

			Properties properties = new Properties();

			properties.load(ips);
			value = properties.getProperty(key);

		} catch (IOException ex) {
			ex.printStackTrace();
		}
		return value;

		}

}
