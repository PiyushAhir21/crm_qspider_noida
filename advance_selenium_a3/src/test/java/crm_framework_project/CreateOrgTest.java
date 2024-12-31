package crm_framework_project;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.remote.ErrorHandler.UnknownServerException;
import org.openqa.selenium.safari.SafariDriver;

public class CreateOrgTest {

	public static void main(String[] args) throws IOException {
		WebDriver driver = null;

//		WebDriver driver = new ChromeDriver();
//		driver = new FirefoxDriver();
//		driver = new EdgeDriver();
//		driver = new SafariDriver();

		FileInputStream fis = new FileInputStream(
				"C:\\Users\\User\\Qspiders\\advance_selenium_a3\\src\\main\\resources\\commonData.properties");

		Properties pObj = new Properties();
		pObj.load(fis);

		String URL = pObj.getProperty("url");
		String BROWSER = pObj.getProperty("browser");
		String USERNAME = pObj.getProperty("username");
		String PASSWORD = pObj.getProperty("password");

		FileInputStream fis2 = new FileInputStream("C:\\Users\\User\\Desktop\\testScriptData.xlsx");

		Workbook wb = WorkbookFactory.create(fis2);

		String orgName = wb.getSheet("org").getRow(1).getCell(0).getStringCellValue();

		System.out.println(orgName);

		if (BROWSER.equals("chrome")) {
			driver = new ChromeDriver();
		} else if (BROWSER.equals("firefox")) {
			driver = new FirefoxDriver();
		} else if (BROWSER.equals("edge")) {
			driver = new EdgeDriver();
		} else if (BROWSER.equals("safari")) {
			driver = new SafariDriver();
		} else {
			driver = new ChromeDriver();
		}
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get(URL);

		driver.findElement(By.name("user_name")).sendKeys(USERNAME);
		driver.findElement(By.name("user_password")).sendKeys(PASSWORD);

		driver.findElement(By.id("submitButton")).click();
		driver.findElement(By.linkText("Organizations")).click();
		driver.findElement(By.xpath("//img[@title='Create Organization...']")).click();
		driver.findElement(By.name("accountname")).sendKeys(orgName);
		driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		String actOrgName = driver.findElement(By.className("dvHeaderText")).getText();
		if (actOrgName.contains(orgName)) {
			System.out.println("Organization created successfully!!!!");
		}
		wb.close();
		driver.close();
	}
}