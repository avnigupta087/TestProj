package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage3 {

	WebDriver driver;
	
	public LoginPage3(WebDriver driver) {
		 this.driver=driver;
	 }
	private By authCode= By.id("seccode");
	private By deviceAuth=By.id("Device1");
	private By continueButton=By.id("ContinueBtn");
	
	public WebElement authCode() {
		return driver.findElement(authCode);
	}
	public WebElement deviceAuth() {
		return driver.findElement(deviceAuth);
	}
	public WebElement continueButton() {
		return driver.findElement(continueButton);
	}
}
