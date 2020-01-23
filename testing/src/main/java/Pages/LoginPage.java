package Pages;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.How;

public class LoginPage {
	
	@FindBy(how=How.LINK_TEXT,using="sign-in")
	public WebElement signin;
	
	@FindBy(how=How.NAME,using="userName")
	public WebElement username;

	@FindBy(how=How.NAME,using="password")
	public WebElement pass;
	
	@FindBy(how=How.NAME,using="submit")
	public WebElement Submit;

	public void login(String UName,String Pass) {
		signin.click();
		username.sendKeys(UName);
		pass.sendKeys(Pass);
		Submit.click();
	}
	
	
}
