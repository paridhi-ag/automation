package Scripts;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.*;

public class VerifyReg {
	//WebDriver driver=BrowserFactory.launchBrowser("chrome","http://demo.guru99.com/test/newtours/register.php");
	/*static WebDriver driver=null;
	
	
	
	public static void NavigateToURL(String URL) {
		driver.get(URL);
		//System.out.println(URL);
	} */
	static WebDriver driver;
	
	@Parameters({ "browser" })
	@BeforeMethod
	public void Browserlaunch(String browser) {
		if(browser.equalsIgnoreCase("chrome")) {
		System. setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		driver=new ChromeDriver();
		driver.manage().window().maximize();
		}
		else if(browser.equalsIgnoreCase("firefox")) {
			System. setProperty("webdriver.gecko.driver", "D:\\chromedriver_win32\\geckodriver.exe");
			driver=new FirefoxDriver();
			driver.manage().window().maximize();
		}
   }
	public void NavigateToUrl(String URL) {
		driver.get(URL);
	}
	
	@Test(priority=0)
	public void checkValidUser() {
		//BrowserFactory f=new BrowserFactory();
		NavigateToUrl("http://demo.guru99.com/test/newtours/register.php");
    //	WebDriver driver=BrowserFactory.launchBrowser("chrome","http://demo.guru99.com/test/newtours/register.php");
		RegisterPage registerPage=PageFactory.initElements(driver, RegisterPage.class);
		registerPage.register("test996", "test@123", "test@123");
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		loginPage.login("test996","test@123");
		
		
	}
	
	/*@Test(priority=1)
	public void verifyLogin() {
		LoginPage loginPage=PageFactory.initElements(driver, LoginPage.class);
		loginPage.login("test996","test@123");
}*/
	@AfterMethod
	 public static void quitBrowser() {
		 driver.quit();
	 }
}
