package session2;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Action;
import org.openqa.selenium.interactions.Actions;

public class MouseBasics {
	/*
	 * Using the mouse involes building Actions, which are multi-step processes
	 * that are defined and then executed as a block. All mouse actions need to 
	 * be in an action even if there is only one.  The other case we'll see here 
	 * is that of keyboard actions requiring the use of modifier keys (control, shift, etc).
	 */
	
	public static void main(String [] args) {
		System.setProperty("webdriver.chrome.driver", "chromedriver");
		WebDriver driver = new ChromeDriver();

		String baseURL = "http://demo.guru99.com/test/login.html";
		driver.get(baseURL);
		driver.manage().window().maximize();
		
		WebElement txtUsername = driver.findElement(By.id("email"));

		Actions builder = new Actions(driver);
		Action seriesOfActions = builder
			.moveToElement(txtUsername)
			.click()
			.keyDown(txtUsername, Keys.SHIFT)
			.sendKeys(txtUsername, "hello")
			.keyUp(txtUsername, Keys.SHIFT)
			.doubleClick(txtUsername)
			.contextClick()
			.build();
			
		seriesOfActions.perform() ;
		
	
		/*
		 * Note: If you only need to have two or more keys down for a single
		 * keystroke, use Keys.chord(), which accepts any number of keys to press simultaneously
		 */
		
		
	}
}
