package stackjava.com.demojsf.service;

import java.util.ArrayList;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class FacebookInboxService {
	public static void main(String[] args) throws InterruptedException {
		// Create a new instance of the Firefox driver
		// Notice that the remainder of the code relies on the interface,
		// not the implementation.

		List<String> lst = new ArrayList<String>();
		lst.add("https://www.facebook.com/messages/t/cong.hoang.12327");
		lst.add("https://www.facebook.com/messages/t/cong.hoang.12327");
		lst.add("https://www.facebook.com/messages/t/cong.hoang.12327");
		lst.add("https://www.facebook.com/messages/t/cong.hoang.12327");
		lst.add("https://www.facebook.com/messages/t/cong.hoang.12327");
		lst.add("https://www.facebook.com/messages/t/cong.hoang.12327");
		
		ChromeOptions options = new ChromeOptions();
		options.addArguments("--disable-notifications");

		System.setProperty("webdriver.chrome.driver", "E:/chromedriver_win32/chromedriver.exe");
		WebDriver driver = new ChromeDriver(options);

		// And now use this to visit Google
		driver.get("https://www.facebook.com");
		// Alternatively the same thing can be done like this
		// driver.navigate().to("http://www.google.com");

		// Find the text input element by its name
		WebElement email = driver.findElement(By.name("email"));
		WebElement pass = driver.findElement(By.name("pass"));
		email.sendKeys("01675394511");
		pass.sendKeys("nothingmk");
		pass.submit();

		for (int i = 0; i < lst.size(); i++) {
			driver.get(lst.get(i));
			Thread.sleep(1000);

			WebElement currentElement = driver.switchTo().activeElement();
			currentElement.sendKeys("hehehe auto inbox");
			WebElement submit;
			submit = driver.findElement(By.partialLinkText("Gửi"));
			// wait.until(ExpectedConditions.visibilityOfElementLocated(By.id<locator>));
			submit.click();
			Thread.sleep(1000);

		}

		driver.quit();
	}
}
