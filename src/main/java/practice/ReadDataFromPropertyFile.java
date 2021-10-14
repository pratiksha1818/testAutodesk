package practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.Test;

public class ReadDataFromPropertyFile {

	@Test
	public void readDataFromPropertyFile() throws IOException {
	/*read data from properties file*/
		//step1:get the java representation of physical file
		FileInputStream fis= new FileInputStream("./Data\\CommonData.properties");
		
		//step2:create object of the properties class & load all key value pair
		Properties pobj=new Properties();
		pobj.load(fis);
		//step3:read value using getproperty (key)
     String URL=pobj.getProperty("url");
     String BROWSER=pobj.getProperty("browser"); 
     String USERNAME=pobj.getProperty("username");
     String PASSWORD=pobj.getProperty("password");
     
     System.out.println(URL);
     System.out.println(USERNAME);
     System.out.println(PASSWORD);
     System.out.println(BROWSER);
     
		
	}

}
