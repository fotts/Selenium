import java.util.concurrent.TimeUnit;

import org.junit.After;
import org.junit.Before;
import org.junit.Ignore;
import org.junit.Test;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

import junit.framework.Assert;

public class C_17_4a_JUnit {
	WebDriver driver;
	String baseUrl;
	
	@Before
	public void setUp() throws Exception {
		System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
		driver = new ChromeDriver();
		baseUrl = "https://www.facebook.com";
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void testVerifyHomePage() throws Exception {
		driver.get(baseUrl + "/");
		String actualPageTitle = driver.getTitle();
		String pageTitle = "Facebook - Log In or Sign Up";
		Assert.assertEquals(pageTitle, actualPageTitle);
	}
	
	@Ignore
	public void testVerifyHomePage1() throws Exception {
		driver.get(baseUrl + "/");
		String actualSignUp = driver.findElement(By.cssSelector("#u_0_u")).getText();
		String SignUp = "Sign Up";
		Assert.assertEquals(SignUp, actualSignUp);	
	}
	
	@After
	public void tearDown() throws Exception {
		driver.quit();
	}

}
