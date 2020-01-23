package Pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.CacheLookup;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class RegisterPage {
	
	WebDriver driver;
	
	public RegisterPage(WebDriver ldriver) {
		this.driver=ldriver;
	}
	
	/*@FindBy(how=How.NAME,using="firstName")
	public WebElement firstname;
	
	@FindBy(how=How.NAME,using="lastName")
	public WebElement lastname;
	
	@FindBy(how=How.NAME,using="phone")
	public WebElement tele;
	
	@FindBy(how=How.NAME,using="address1")
	public WebElement add1;
	
	@FindBy(how=How.NAME,using="city")
	public WebElement cit;
	
	@FindBy(how=How.NAME,using="state")
	public WebElement stat1;
	
	@FindBy(how=How.NAME,using="postalCode")
	public WebElement pc;*/
	
	@FindBy(how=How.NAME,using="email")
	
	public WebElement emaile;
	
	@FindBy(how=How.NAME,using="password")
	
	public WebElement pass;
	
	@FindBy(how=How.NAME,using="confirmPassword")
	
	public WebElement confirmPass;
	
	@FindBy(how=How.NAME,using="submit")
	public WebElement Submit;
	
	
	public void register(String Email,String Pass,String ConfPass) {
		emaile.sendKeys(Email);
		pass.sendKeys(Pass);
		confirmPass.sendKeys(ConfPass);
		Submit.click();
	}


}
