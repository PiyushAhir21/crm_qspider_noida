package crm_framework_project;

import java.time.Duration;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart {

	public static void main(String[] args) throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(15));

		driver.get("https://www.flipkart.com/");

		driver.findElement(By.name("q")).sendKeys("iphone");
		driver.findElement(By.xpath("//span[contains(text(),'iphone')]")).click();
		Thread.sleep(2000);
		
		String parentID = driver.getWindowHandle();

		driver.findElement(By.xpath("//div[contains(text(),'Apple iPhone')]")).click();
		Set<String> childIDs = driver.getWindowHandles();
		childIDs.remove(parentID);

		for (String id : childIDs) {
			driver.switchTo().window(id);
			break;
		}

		Thread.sleep(4000);
		driver.findElement(By.xpath("//*[@class='KRzcNw' or text()='Add to cart']")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//span[contains(text(),'Place Order')]")).click();
		Thread.sleep(2000);

		driver.findElement(By.xpath("//*[@type='text']")).sendKeys("Trainer@qspiders.in");
		
		Thread.sleep(4000);
		System.out.println("Product added successfully to the cart !!!");
		driver.quit();
	}
}
