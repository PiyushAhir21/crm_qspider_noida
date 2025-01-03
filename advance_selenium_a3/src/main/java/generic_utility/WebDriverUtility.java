package generic_utility;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WebDriverUtility {
	WebDriver driver;
	WebDriverWait wait;
	Actions act;
	
	public WebDriverUtility(WebDriver driver){
		this.driver = new ChromeDriver();
		this.wait = new WebDriverWait(driver, Duration.ofSeconds(15));
		this.act = new Actions(driver);
	}
	
	public void maximize(WebDriver driver) {
		driver.manage().window().maximize();
	}
	
	
}
