package contacttest;

import java.io.FileInputStream;
import java.util.Properties;
import java.util.Random;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import generic_utility.FileUtility;
import generic_utility.WebDriverUtility;

public class CreateContactTest {

	public static void main(String[] args) throws Throwable {
		// Read common data from property file
		/*
		 * FileInputStream fis = new
		 * FileInputStream("./src\\main\\resources\\commonData.properties"); Properties
		 * pObj = new Properties(); pObj.load(fis);
		 * 
		 * String BROWSER = pObj.getProperty("bro"); 
		 * String URL = pObj.getProperty("url"); 
		 * String USERNAME = pObj.getProperty("un"); 
		 * String PASSWORD = pObj.getProperty("pwd");
		 */

		FileUtility flib = new FileUtility();
		String BROWSER = flib.getDataFromPropertiesFile("bro");
		String URL = flib.getDataFromPropertiesFile("url");
		String USERNAME = flib.getDataFromPropertiesFile("un");
		String PASSWORD = flib.getDataFromPropertiesFile("pwd");

		// Generate random number
//		Random random = new Random();
//		int randomInt = random.nextInt(1000);
//		System.out.println(randomInt);

		// Read testScript data from from excel file
//		FileInputStream fis1 = new FileInputStream("C:\\Users\\User\\Desktop\\testScriptData.xlsx");
//		Workbook wb = WorkbookFactory.create(fis1);
//		Sheet sh = wb.getSheet("contact");
//		Row row = sh.getRow(1);
//		String LastName = row.getCell(2).toString() + randomInt;
		
		String LastName = flib.getDataFromExcelFile("contact", 1, 2);

		WebDriver driver = null;

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else {
			driver = new ChromeDriver();
		}

		WebDriverUtility wdlib = new WebDriverUtility(driver);
		wdlib.maximize(driver);
		
		driver.get(URL);

		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();

		driver.findElement(By.linkText("Contacts")).click();
		driver.findElement(By.xpath("//img[@title='Create Contact...']")).click();

		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(LastName);

		driver.findElement(By.xpath("(//input[@title='Save [Alt+S]'])")).click();

		String verifyLn = driver.findElement(By.id("dtlview_Last Name")).getText();
		if (verifyLn.equals(LastName)) {
			System.out.println(LastName + " given Successfully!!!");
		}

		driver.quit();
	}
}