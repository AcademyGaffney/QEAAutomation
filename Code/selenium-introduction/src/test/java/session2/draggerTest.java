package session2;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.AfterSuite;

public class draggerTest {
	private static WebDriver driver = null;

	@Test(priority = 1)
	public void testDragDrop() {
		WebElement dragMe = driver.findElement(By.id("draga"));
		WebElement dragTo = driver.findElement(By.id("dragb"));
		Actions act = new Actions(driver);
		
		//act.dragAndDrop(dragMe, dragTo).build().perform();
		
		act.moveToElement(dragMe)
		.clickAndHold()
		.moveToElement(dragTo, 10, -5)
		.release()
		.build()
		.perform();
		
		WebElement dragMeMoved = driver.findElement(By.xpath("//*[@id='dragb']/button"));
		//WebElement dragMeMoved = driver.findElement(By.id("draga"));
		
		Assert.assertEquals(dragMe, dragMeMoved);
	}

	@BeforeMethod
	public void beforeMethod() {
		String baseURL = "http://www.seleniumframework.com/Practiceform/";
		driver.get(baseURL);
	}

	@AfterMethod
	public void afterMethod() {
	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
	}

	@AfterClass
	public void afterClass() {
		//driver.close();
	}

	@BeforeTest
	public void beforeTest() {
		// Unused, as we haven't defined tests
	}

	@AfterTest
	public void afterTest() {
		// Unused, as we haven't defined tests
	}

	@BeforeSuite
	public void beforeSuite() {
		// Unused, as we haven't defined a suite
	}

	@AfterSuite
	public void afterSuite() {
		// Unused, as we haven't defined a suite
	}

}
