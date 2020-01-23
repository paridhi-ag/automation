package Pages;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;
import org.apache.poi.ss.usermodel.Sheet;


public class ExcelReadDataProvider {
	static WebDriver driver;


	/*@BeforeMethod
	public void launchBrowser() {
		System. setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");

	}
	 */

	@Test(dataProvider="testData")
	public void Test(Map map) throws InterruptedException {
		System. setProperty("webdriver.chrome.driver", "D:\\chromedriver_win32\\chromedriver.exe");
		WebDriver driver=new ChromeDriver();
		driver.manage().window().maximize(); 
		driver.get("https://opensource-demo.orangehrmlive.com/index.php/auth/login");
     

		System.out.println(map.get("Username"));
		//String username= map.get("UserName");
		driver.findElement(By.xpath("//*[@id=\"txtUsername\"]")).sendKeys((String)map.get("Username"));
		driver.findElement(By.xpath("//*[@id=\"txtPassword\"]")).sendKeys((String)map.get("Password"));
		driver.findElement(By.xpath("//*[@id=\"btnLogin\"]")).click();
		Thread.sleep(4000);
		driver.quit();


	}


	//return Object[][]
	@DataProvider(name="testData")
	public Object[][] readExcelData() throws IOException  {
		File file=new File("D://property.xlsx");
		FileInputStream fis = new FileInputStream(file);

		XSSFWorkbook wb = new XSSFWorkbook(fis);
		XSSFSheet s = wb.getSheet("Sheet1");
		//XSSFSheet s=wb.getSheetAt(0);
		int rowcount=s.getLastRowNum();
		int colcount=s.getRow(0).getLastCellNum();
		//Iterator <Row> rowIterator = s.iterator();
		Object[][] obj=new Object[rowcount][1];
		for(int i=0;i<rowcount;i++)
		{
			Map<Object,Object> map=new HashMap<Object,Object>();
			for(int j=0;j<colcount;j++) {
				//read cell data and store in map
				map.put(s.getRow(0).getCell(j).getStringCellValue(),s.getRow(i+1).getCell(j).getStringCellValue());

			}
			obj[i][0]=map; 

		}
		return obj;

	}
	/*@AfterMethod
	public void quitBrowser() {
		driver.quit();

	}
	 */}
