package stepDefinitions;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.testng.log4testng.Logger;

import io.cucumber.java.After;
import io.cucumber.java.en.*;
import pageObjects.LoginPage1;
import pageObjects.LoginPage2;
import pageObjects.LoginPage3;
import pageObjects.LoginPage4;
import resources.Base;

public class Login extends Base {
public WebDriver driver;
Logger log;
LoginPage1 loginpage1;
LoginPage2 loginpage2 ;
LoginPage3 loginpage3; 
LoginPage4 loginpage4; 


	@Given("^Open any browser$")
	public void Open_any_browser() throws IOException {
		driver = Initializebrowser();
		
	}
	
	@And("^navigate to login page$")
	public void navigate_to_login_page() {
		driver.get(prop.getProperty("url"));
		
	}
	
	@When("^User enters username and password$")
	public void User_enters_username_and_password() {
		loginpage1 = new LoginPage1(driver);
		loginpage1.usernamefield().sendKeys(prop.getProperty("username"));
		loginpage1.passwordfield().sendKeys(prop.getProperty("password"));
		loginpage1.loginButton().click();
		log.debug("This opens second login page");
		loginpage2 = new LoginPage2(driver);
		loginpage2.emailcheckbox().click();
		loginpage2.continueButton().click();
	}
	@And ("^clicks login button$")
	public void clicks_login_button() {
		log.debug("This opens third login page");
		loginpage3 = new LoginPage3(driver);
		loginpage3.authCode().sendKeys(prop.getProperty("AuthCode"));
		loginpage3.deviceAuth().click();
		loginpage3.continueButton().click();
		log.debug("This opens forth login page");
		loginpage4 = new LoginPage4(driver);
		loginpage4.loginButton().click();
	}
	@Then("^authentication page opens$")
	public void authentication_page_opens() {
		driver.getTitle().equalsIgnoreCase("Gold");
	}

	@After 
	public void closeBrowser() {
		driver.close();
	}

}
