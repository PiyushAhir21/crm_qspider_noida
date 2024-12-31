package facebook;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Login {

	public static void main(String[] args) throws IOException {
//		step : 1 get the java representation object of the physical file
		FileInputStream fis = new FileInputStream("C:\\Users\\User\\Qspiders\\advance_selenium_a3\\src\\main\\resources\\commonData.properties");
		
//		step : 2 By using Properties class load all the keys
		Properties pObj = new Properties();
		pObj.load(fis);
		
//		step : 3 By using getProproty(), fetch the value
		String URL = pObj.getProperty("url");
		String BROWSER = pObj.getProperty("browser");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");
		System.out.println(URL + " " + BROWSER + " " + USERNAME + " " + PASSWORD);
		
//		step : 3 By using setProperty(), set the key and value
		pObj.setProperty("lastname", "Ahir");
		
//		Step 4 : open the file in write mode
		FileOutputStream fos = new FileOutputStream("C:\\Users\\User\\Qspiders\\advance_selenium_a3\\src\\main\\resources\\commonData.properties");
		
//		Step 5 : Save the file with store()
		pObj.store(fos, "one data added !!!");
	}
}
