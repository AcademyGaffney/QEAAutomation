package session3;

import org.testng.annotations.Test;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.BeforeClass;

import static org.testng.Assert.*;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.annotations.AfterClass;

public class ContactTest {

	private static WebDriver driver = null;

	@Test(dataProvider = "dpS")
	public void TestSuccess(String name, String email, String phone) throws Exception {
		WebElement nameBox = driver.findElement(
				By.xpath("/html/body/div[1]/div[2]/div[2]/div/aside/div/section[2]/form/div/span[1]/input"));
		WebElement emailBox = driver.findElement(
				By.xpath("/html/body/div[1]/div[2]/div[2]/div/aside/div/section[2]/form/div/span[2]/input"));
		WebElement phoneBox = driver.findElement(
				By.xpath("/html/body/div[1]/div[2]/div[2]/div/aside/div/section[2]/form/div/span[3]/input"));

		nameBox.sendKeys(name);
		emailBox.sendKeys(email);
		phoneBox.sendKeys(phone);
		phoneBox.submit();

		WebDriverWait wait = new WebDriverWait(driver, 1);

		WebElement message = wait.until(ExpectedConditions
				.elementToBeClickable(By.xpath("//*[@id=\"presscore-contact-form-widget-3\"]/form/div[1]/div")));
		assertEquals("Feedback has been sent to the administrator", message.getText());

	}

	@Test(dataProvider = "dpF")
	public void testEmailFail(String name, String email, String phone, String error) throws Exception {
		WebElement nameBox = driver.findElement(
				By.xpath("/html/body/div[1]/div[2]/div[2]/div/aside/div/section[2]/form/div/span[1]/input"));
		WebElement emailBox = driver.findElement(
				By.xpath("/html/body/div[1]/div[2]/div[2]/div/aside/div/section[2]/form/div/span[2]/input"));
		WebElement phoneBox = driver.findElement(
				By.xpath("/html/body/div[1]/div[2]/div[2]/div/aside/div/section[2]/form/div/span[3]/input"));

		nameBox.sendKeys(name);
		emailBox.sendKeys(email);
		phoneBox.sendKeys(phone);
		phoneBox.submit();

		WebDriverWait wait = new WebDriverWait(driver, 1);

		WebElement message = wait.until(ExpectedConditions.elementToBeClickable(
				By.xpath("/html/body/div[1]/div[2]/div[2]/div/aside/div/section[2]/form/div/span[2]/div/div[1]")));

		assert (message.getText().contains(error));

	}

	@BeforeMethod
	public void beforeMethod() {
		String baseURL = "http://www.seleniumframework.com/Practiceform/";
		driver.get(baseURL);
	}

	@AfterMethod
	public void afterMethod() {
	}

	@DataProvider
	public Object[][] dpS() {
		return new Object[][] { new Object[] { "James", "J@example.com", "23211199228" },
				new Object[] { "Siobhan", "Siobee@example.com", "8927183928" }, };
	}

	@DataProvider
	public Object[][] dpF() {
		return new Object[][] { new Object[] { "James", "J@example", "23211199228", "Invalid email address" },
				new Object[] { "Siobhan", "", "87192737121", "This field is required" }, };
	}

	@BeforeClass
	public void beforeClass() {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		driver = new ChromeDriver();
	}

	@AfterClass
	public void afterClass() {
		driver.close();
	}

}
