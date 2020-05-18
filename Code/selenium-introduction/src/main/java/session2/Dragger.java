package session2;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;

public class Dragger {
	public static void main(String[] args) throws Exception {

		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();

		String baseURL = "http://www.seleniumframework.com/Practiceform/";

		driver.get(baseURL);
		WebElement dragMe = driver.findElement(By.id("draga"));
		WebElement dragTo = driver.findElement(By.id("dragb"));
		Actions act = new Actions(driver);
		
		act.dragAndDrop(dragMe, dragTo);
	}
}
