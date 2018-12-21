import java.io.File;
import java.io.IOException;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;

public class ReUsableFunctions {
	
	public ReUsableFunctions(){
		System.out.println("ReUsableFunctions DEFAULT CONSTRUCTOR code is getting executed");
	}
	
	/*
	public ReUsableFunctions(String TestEngineer){
		System.out.println("All these tests were designed by this : " + TestEngineer);
		System.out.println("ReUsableFunctions CONSTRUCTOR code is getting executed");
	}
	*/
	
	static WebDriver driver;
	
	public static WebDriver OpenBrowser(String RunTestInBrowser, String AUT_URL)
	{
		
		String BrowserToRun=null;
		String BrowserDriverLocation=null;
		
		if (RunTestInBrowser.equals("IE"))
		{
				BrowserToRun = "webdriver.ie.driver";
		        BrowserDriverLocation = "IEDriverServer.exe";
		        System.setProperty(BrowserToRun, BrowserDriverLocation);
				driver = new InternetExplorerDriver();
				driver.get(AUT_URL);
				System.out.println("Test Running in: " + RunTestInBrowser);
				driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
				return driver;
				
		}
		else if (RunTestInBrowser.equals("FF"))
		{
			BrowserToRun = "webdriver.gecko.driver";
	        BrowserDriverLocation = "geckodriver.exe";
	     		
	        System.setProperty(BrowserToRun, BrowserDriverLocation);
			driver = new FirefoxDriver();
			driver.get(AUT_URL);
			System.out.println("Test Running in: " + RunTestInBrowser);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			return driver;
		}
		else
		{
			BrowserToRun = "webdriver.chrome.chromedriver";
	        BrowserDriverLocation = "chromedriver.exe";
	        System.setProperty(BrowserToRun, BrowserDriverLocation);
			driver = new ChromeDriver();
			driver.get(AUT_URL);
			System.out.println("Test Running in: " + RunTestInBrowser);
			driver.manage().timeouts().implicitlyWait(30, TimeUnit.SECONDS);
			return driver;
		}
	
	}
	
	
	
	public static void GetSceenshot(String FileSaveLoc, String ScrshotName) throws IOException{
		
		
		 File RateLookupScreenShot =    ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
         FileUtils.copyFile(RateLookupScreenShot, new File (FileSaveLoc + ScrshotName + ".jpg"));
	}
	
	public static void TakeSceenshot(String customerName) throws IOException {
		File screenshot = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		FileUtils.copyFile(screenshot,
		new File("C:\\Users\\Huser\\screenshots\\" + customerName + "screenshot.jpg"));
	}
	

}