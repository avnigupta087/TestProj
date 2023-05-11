package pageObjects;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class LoginPage1 {
	 WebDriver driver;
	 
	 public LoginPage1(WebDriver driver) {
		 this.driver=driver;
		 PageFactory.initElements(driver, this);
		 
	 }
	 
	@FindBy(id="USERNAME") 
	private WebElement usernamefield;
	
	@FindBy(id="password")
	private WebElement passwordfield;
	
	@FindBy(id="ContinueBtn")
	private WebElement loginButton;
	 
	/*private  By usernamefield= By.id("USERNAME");
	private By passwordfield= By.id("password");
	private By loginButton= By.id("ContinueBtn");*/
	
	public  WebElement usernamefield() {
		return usernamefield;
		
	}
	
	public WebElement passwordfield() {
		return passwordfield;
	}
	
	public WebElement loginButton() {
		return loginButton;
	}
}

