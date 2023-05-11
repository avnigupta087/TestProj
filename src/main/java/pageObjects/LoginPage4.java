package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage4 {

	WebDriver driver;
	public LoginPage4(WebDriver driver) {
		 this.driver=driver;
	 }
	private By loginButton= By.id("ContinueBtn");
	
		
	public WebElement loginButton() {
		return driver.findElement(loginButton);
	}
}
