import java.io.IOException;
import java.io.FileReader;
import java.util.Properties;

import java.io.BufferedReader;
import java.io.FileNotFoundException;


public class ConfigFileReader {
    
    private Properties properties;
	private final String propertyFilePath= "resources//config.properties";

    Properties readConfigFile() throws IOException {
        BufferedReader reader;
		try {
			reader = new BufferedReader(new FileReader(propertyFilePath));
			properties = new Properties();
			try {
				properties.load(reader);
				reader.close();
                return properties;
			} catch (IOException e) {
				e.printStackTrace();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			throw new RuntimeException("Configuration.properties not found at " + propertyFilePath);
		}	
        return null;
    }
}
