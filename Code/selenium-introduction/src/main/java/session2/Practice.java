package session2;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class Practice {
	
	/*
	 * Perform the basic email/password/submit login process using 
	 * one or more Action objects.
	 */
	public static void main(String[] args) throws Exception{
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();

		String baseURL = "http://demo.guru99.com/test/login.html";

		driver.get(baseURL);
		driver.manage().window().maximize();
		WebElement email = driver.findElement(By.id("email"));
		WebElement passwd = driver.findElement(By.id("passwd"));
		WebElement button = driver.findElement(By.id("SubmitLogin"));
		Actions builder = new Actions(driver);
		builder
			.moveToElement(email)
			.click()
			.sendKeys("MyName");
		Thread.sleep(1000);
		builder.sendKeys(Keys.TAB)
			.sendKeys("passowrd")
			.moveToElement(button)
			.click();
		Action login = builder.build();
			
		login.perform() ;
		//driver.quit();
	}
}
