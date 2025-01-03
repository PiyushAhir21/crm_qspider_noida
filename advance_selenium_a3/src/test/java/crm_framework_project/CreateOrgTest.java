package crm_framework_project;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Driver;
import java.util.Properties;
import java.util.Random;
import java.util.Scanner;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class CreateOrgTest {

	public static void main(String[] args) throws IOException, InterruptedException {
		// Read common data from property file
		FileInputStream fis = new FileInputStream("./src\\main\\resources\\commonData.properties");
		Properties pObj = new Properties();
		pObj.load(fis);

		String BROWSER = pObj.getProperty("bro");
		String URL = pObj.getProperty("url");
		String USERNAME = pObj.getProperty("un");
		String PASSWORD = pObj.getProperty("pwd");

		// Generate random number
		Random random = new Random();
		int randomInt = random.nextInt(1000);
		System.out.println(randomInt);

		// Read testScript data from from excel file
		FileInputStream fis1 = new FileInputStream("C:\\Users\\User\\Desktop\\testScriptData.xlsx");
		Workbook wb = WorkbookFactory.create(fis1);
		Sheet sh = wb.getSheet("org");
		Row row = sh.getRow(1);
		String orgName = row.getCell(0).toString() + randomInt;

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

		driver.get(URL);

		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();

		driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();

		driver.findElement(By.xpath("//input[@type='text' and @name='accountname']")).sendKeys(orgName);
		driver.findElement(By.xpath("(//input[@type='button' and @class='crmbutton small save'])[2]")).click();

		Thread.sleep(2000);
		
		WebElement verify = driver.findElement(By.xpath("//span[contains(text(), '" + orgName + "')]"));
		if (verify.isDisplayed()) {
			System.out.println(orgName + " Created Successfully!!!");
		}

		driver.quit();
	}
}
