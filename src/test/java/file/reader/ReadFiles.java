package file.reader;

import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class ReadFiles {

	public static void main(String[] args) throws IOException {
		
		//Create new object that locate properties file
		FileReader file = new FileReader("G:\\Selenium\\NewTest\\org.apache.maven\\src\\test\\resources\\config_files\\properties");
		
		//Create new object that read properties file
		Properties prop = new Properties();
		
		//Read properties File
		prop.load(file);

	}

}