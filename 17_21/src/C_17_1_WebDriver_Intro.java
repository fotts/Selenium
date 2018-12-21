import java.util.concurrent.TimeUnit;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class C_17_1_WebDriver_Intro {
	public static void main(String[] args) throws InterruptedException {
		
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		WebDriver driver = new ChromeDriver();
		
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
		
		driver.manage().window().maximize();
		driver.get("http://www.facebook.com/");
		System.out.println("Page title is: " + driver.getTitle());
		
		driver.findElement(By.id("email")).sendKeys("irfan@sdettraining.com");
		driver.findElement(By.cssSelector("#pass")).sendKeys("Passw0rd!@#");
		// Thread.sleep(3000);
		driver.findElement(By.id("u_0_2")).click();
		
		String expectedValue = "The email you’ve entered doesn’t match any account. Sign up for an account.";
		String actualValue;
		//Thread.sleep(3000);
		actualValue = "";
		actualValue = driver
				.findElement(By.cssSelector(
						"#globalContainer > div.uiContextualLayerPositioner._572t.uiLayer > div > div > div"))
				.getText();
		
		System.out.println("expect Value is: " + expectedValue);
		System.out.println("actual Value is: " + actualValue);
		
		if (expectedValue.equals(actualValue)) {
			System.out.println("TEST PASSED");
		}
		else 
			System.out.println("TEST FAILED");
		// driver.quit();	
	}
}
