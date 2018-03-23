package api.test;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class PropertiesTest {
	public static void main(String[] args) {
		Properties pr = new Properties();
		try {
			pr.load(new FileInputStream("src/api/test/file.properties"));
			System.out.println(pr.getProperty("name"));
			System.out.println(pr.getProperty("age"));
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
}
