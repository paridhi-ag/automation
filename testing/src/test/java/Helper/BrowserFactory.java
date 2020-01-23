package Helper;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;

public class BrowserFactory {
	 static WebDriver driver=null;
	 
	 
	 @Parameters({ "browser" })
	 @BeforeMethod
	public static WebDriver launchBrowser(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
			System. setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
			driver=new ChromeDriver();
			
			}
			else if(browser.equalsIgnoreCase("firefox")) {
				System. setProperty("webdriver.gecko.driver", "D:\\chromedriver_win32\\geckodriver.exe");
				driver=new FirefoxDriver();
				//driver.manage().window().maximize();
			}
		driver.manage().window().maximize();
		//driver.get(URL);
		return driver;
	}
	 
	 @AfterMethod
	 public static void quitBrowser() {
		 driver.quit();
	 }
	
	}



