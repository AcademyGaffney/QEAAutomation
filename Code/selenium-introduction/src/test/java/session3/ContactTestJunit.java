package session3;

import static org.junit.Assert.*;
import static org.testng.Assert.assertEquals;

import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvSource;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class ContactTestJunit {
	private static WebDriver driver = null;
	
	@BeforeAll
	public static void setUpBeforeClass() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
	}

	@AfterAll
	public static void tearDownAfterClass() throws Exception {
	}

	@BeforeEach
	public void setUp() throws Exception {
		String baseURL = "http://www.seleniumframework.com/Practiceform/";
		driver.get(baseURL);
	}

	@AfterEach
	public void tearDown() throws Exception {
	}

	@ParameterizedTest
	@CsvSource({"James, J@example.com, 23211199228", "Siobhan, Siobee@example.com,8927183928"})
	public void testSuccess(String name, String email, String phone) throws Exception {
		WebElement nameBox = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/aside/div/section[2]/form/div/span[1]/input"));
		WebElement emailBox = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/aside/div/section[2]/form/div/span[2]/input"));
		WebElement phoneBox = driver.findElement(By.xpath("/html/body/div[1]/div[2]/div[2]/div/aside/div/section[2]/form/div/span[3]/input"));
		
		nameBox.sendKeys(name);
		emailBox.sendKeys(email);
		phoneBox.sendKeys(phone);
		phoneBox.submit();
		
		
		WebDriverWait wait = new WebDriverWait(driver, 1);
		WebElement message = wait.until(ExpectedConditions.elementToBeClickable(By.xpath("//*[@id=\"presscore-contact-form-widget-3\"]/form/div[1]/div")));
	}

}
