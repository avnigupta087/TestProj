package pageObjects;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class LoginPage2 {
	
	WebDriver driver;
	
	public LoginPage2(WebDriver driver) {
		 this.driver=driver;
	 }
	
		private By emailcheckbox=By.id("Email");
		private By continueButton=By.id("ContinueBtn");
		
		public WebElement emailcheckbox() {
		return	driver.findElement(emailcheckbox);
		}
			
			public WebElement continueButton() {	
			
			return driver.findElement(continueButton);
		}
	}

