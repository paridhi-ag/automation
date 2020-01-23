package Scripts;

import java.io.IOException;
import java.util.ArrayList;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Parameters;
import org.testng.annotations.Test;

import Pages.Excel;

public class VerifyExcel {
	 public static WebDriver driver;
	
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
	
	@Test
	public void test() throws IOException, InterruptedException {
		NavigateToUrl("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
		Excel exe=new Excel(driver);
		
		ArrayList<String> name=Excel.readExcel(0, "D:","property.xlsx","Sheet1");
		ArrayList<String> pass=Excel.readExcel(1, "D:","property.xlsx","Sheet1");
		//System.out.println(name.get(0));
		for(int i=0; i<name.size();i++) {
			System.out.println(name.get(i));
			System.out.println(pass.get(i));
			exe.upload(name.get(i),pass.get(i));
		}
		
	}
	@AfterMethod
	 public static void quitBrowser() {
		 driver.quit();
	 }

}
