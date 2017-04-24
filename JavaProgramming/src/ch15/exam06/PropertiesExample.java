package ch15.exam06;

import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Properties;

public class PropertiesExample {

	public static void main(String[] args) throws FileNotFoundException, IOException {
		Properties p= new Properties();
		String path=PropertiesExample.class.getResource("database.properties").getPath();
		p.load(new FileReader(path));
		String a=p.getProperty("url");
		System.out.println(a);
		
		String manager=p.getProperty("manager");
		System.out.println(manager);
	}

}
