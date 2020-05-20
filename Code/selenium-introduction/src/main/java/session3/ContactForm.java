package session3;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class ContactForm {
	public static void main(String [] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();
		String baseURL = "http://www.seleniumframework.com/Practiceform/";
		driver.get(baseURL);
		
		WebElement nameBox = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/aside/div/section[2]/form/div/span[1]/input"));
		WebElement emailBox = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/aside/div/section[2]/form/div/span[2]/input"));
		WebElement phoneBox = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/aside/div/section[2]/form/div/span[3]/input"));
		
		nameBox.sendKeys("Mike");
		emailBox.sendKeys("mike@example.com");
		phoneBox.sendKeys("8271037232");
		phoneBox.submit();
	}

}
