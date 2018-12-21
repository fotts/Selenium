import java.util.LinkedList;
import java.util.concurrent.TimeUnit;

import org.junit.runner.RunWith;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runners.Parameterized;

@RunWith(Parameterized.class)
public class JUnit_DDT {
	
	private String platform;
	private String browser;
	private String AUT;
	
	@Parameterized.Parameters
	public static LinkedList<String[]> getEnvironments() throws Exception {
		LinkedList<String[]> env = new LinkedList<String[]>();
		env.add(new String[] { Platform.WINDOWS.toString(), "ie", "http://www.amazon.com" });
		env.add(new String[] { Platform.WINDOWS.toString(), "ie", "http://wwww.facebook.com" });
		env.add(new String[] { Platform.WINDOWS.toString(), "chrome", "http://www.fanniemae.com" });
		env.add(new String[] { Platform.WINDOWS.toString(), "opera", "http://www.sdettraining.com" });
		
		// add more browsers here
		
		return env;
	}
	
	public JUnit_DDT(String platform, String browser, String AUT) {
		this.platform = platform;
		this.browser = browser;
		this.AUT = AUT;
	}
	
	private WebDriver driver;
	private String baseUrl;
	
	@Before
	public void setUp() throws Exception {
		//BROWSER=browserName;
		if (browser.equals("firefox")) {
			//https://github.com/mozilla/geckodriver/releases
			System.setProperty("webdriver.gecko.driver", "geckodriver.exe");
			driver = new FirefoxDriver();
			System.out.println("Running test in browser....." + browser);
		}
		else if (browser.equals("ie")) {
			//https://github.com/mozilla/geckodriver/releases
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			System.out.println("Running test in browser....." + browser);
		}
		else if  (browser.equals("chrome"))
		{
			 System.setProperty("webdriver.chrome.driver", "chromedriver.exe");
			 driver = new ChromeDriver();
			 System.out.println("Running test in browser....." + browser);

		}
		else {
			System.setProperty("webdriver.ie.driver", "IEDriverServer.exe");
			driver = new InternetExplorerDriver();
			System.out.println("Running test in browser....." + browser);
		}
		
		baseUrl = AUT;
		driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
	}
	
	@Test
	public void testVerifyHomePage() throws Exception {
		driver.get(baseUrl + "/");
		Thread.sleep(2000);
		String actualPageTitle = driver.getTitle();
		//	String pageTitle = "Facebook - Log In or Sign Up";
		//	Assert.assertEquals(pageTitle, actualPageTitle);
		System.out.println("Navigated to : " + AUT + " and got Page title as : " +actualPageTitle);
		}

	@After
	public void tearDown() throws Exception {
		driver.quit();
	}
}
