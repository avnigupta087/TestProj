package Test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.Test;

import pageObjects.LoginPage1;
import pageObjects.LoginPage2;
import pageObjects.LoginPage3;
import pageObjects.LoginPage4;
import resources.Base;

public class TestA extends Base {
	public WebDriver driver;
	Logger log;
	@Test
	public void login() throws IOException, InterruptedException {
	
		
		log.debug("This opens first login page");
		LoginPage1 loginpage1 = new LoginPage1(driver);
		
		//File srnfile= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileHandler.copy(srnfile, new File("./screenshot/page1_3.png"));
		
		loginpage1.usernamefield().sendKeys(prop.getProperty("username"));
		loginpage1.passwordfield().sendKeys(prop.getProperty("password"));
		loginpage1.loginButton().click();
		
		
		
		log.debug("This opens second login page");
		LoginPage2 loginpage2 = new LoginPage2(driver);

		//File srnfile3= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileHandler.copy(srnfile3,new File("./screenshot/page2_2.png"));	
		loginpage2.emailcheckbox().click();
		loginpage2.continueButton().click();
		
		//File srnfile2= ((TakesScreenshot)driver).getScreenshotAs(OutputType.FILE);
		//FileHandler.copy(srnfile2,new File("./screenshot/page3.png"));
		
		log.debug("This opens third login page");
		LoginPage3 loginpage3 = new LoginPage3(driver);
		loginpage3.authCode().sendKeys(prop.getProperty("AuthCode"));
		loginpage3.deviceAuth().click();
		loginpage3.continueButton().click();
		log.debug("This opens forth login page");
		LoginPage4 loginpage4 = new LoginPage4(driver);
		loginpage4.loginButton().click();
		
		driver.getTitle().equalsIgnoreCase("Gold");
		Assert.assertTrue(true);

	}

	@BeforeMethod
	public void startbrowser() throws IOException {
		log= LogManager.getLogger(TestA.class.getName());
		driver = Initializebrowser();
		driver.get(prop.getProperty("url"));
	}

	@AfterMethod
	public void closure() {
		driver.quit();
	}

}
