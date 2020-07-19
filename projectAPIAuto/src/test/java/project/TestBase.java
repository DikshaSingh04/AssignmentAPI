package project;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Description: Base class 
 * @link TestBase
 *
 * @author Diksha.Singh
 */
public class TestBase {

	public static void main(String[] args) {
		
	}
	Properties props  = new Properties();

	public TestBase() throws IOException {
		 
		FileInputStream fis = new FileInputStream("/project/src/test/resources/file.properties");
		props.load(fis);
	}
}
