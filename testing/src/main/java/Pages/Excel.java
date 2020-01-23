package Pages;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;
import org.openqa.selenium.support.PageFactory;

public class Excel {
	WebDriver driver;

	
	@FindBy(how=How.XPATH,using="//*[@id=\"txtUsername\"]")
	public  WebElement username;
	
	@FindBy(how=How.XPATH,using="//*[@id=\"txtPassword\"]")
	public  WebElement password;
	
	@FindBy(how=How.XPATH,using="/html/body/div[1]/div/div[3]/div[2]/div[2]/form/div[5]/input")
	public  WebElement login;
	
	public Excel(WebDriver driver){

        this.driver = driver;

        //This initElements method will create all WebElements

        PageFactory.initElements(driver, this);

    }
	
	public  void upload(String userName,String pass) throws InterruptedException
	{
		/*System.out.println(userName+"????");
		System.out.println(pass+"????");*/
		//login.click();
		username.sendKeys(userName);
		Thread.sleep(4000);

		password.sendKeys(pass);
		login.click();
		Thread.sleep(4000);
	}
	
	
	public static ArrayList<String> readExcel(int colNo,String filePath,String fileName,String sheetName) throws IOException
	{
	    //File file =    new File(filePath+"\\"+fileName);
	    FileInputStream inputStream = new FileInputStream(filePath+"\\"+fileName);
	    Workbook wb = null;
	    String fileExtensionName = fileName.substring(fileName.indexOf("."));
	    if(fileExtensionName.equals(".xlsx")){
	        wb = new XSSFWorkbook(inputStream);

	    }
	    else if(fileExtensionName.equals(".xls")){
	        wb = new HSSFWorkbook(inputStream);

	    }
	    Sheet sheet = wb.getSheet(sheetName);
	    Iterator <Row> rowIterator = sheet.iterator();
		rowIterator.next();
		ArrayList<String> list = new ArrayList<String>();
		while(rowIterator.hasNext()) {
			list.add(rowIterator.next().getCell(colNo).getStringCellValue());
			
		}
		System.out.println("List ="+ list);
		return list;

}
	
	/*public void up() throws InterruptedException, IOException {
	ArrayList<String> name = readExcel(0,"D:","property.xlsx","Sheet1");

	ArrayList<String> pass = readExcel(1,"D:","property.xlsx","Sheet1");
	for(int i=0; i<name.size();i++) {
		username.sendKeys(name.get(i));
		password.sendKeys(pass.get(i));
		login.click();
		Thread.sleep(4000);
	}*/
	}	


