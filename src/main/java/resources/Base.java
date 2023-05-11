package resources;

import java.time.Duration;
import java.util.Date;
import java.util.Properties;
import java.io.*;
import java.text.SimpleDateFormat;

import org.openqa.selenium.TakesScreenshot;
import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

public class Base {
	public WebDriver driver;
	public Properties prop;

	public  WebDriver Initializebrowser() throws IOException{
		 prop= new Properties();
		String propPath=System.getProperty("user.dir")+"\\src\\main\\java\\resources\\info.properties";
		FileInputStream fis=new FileInputStream(propPath);
		prop.load(fis);
		
		String browsername=prop.getProperty("browser");
		
		if (browsername.equalsIgnoreCase("Chrome")) {
				driver=new ChromeDriver();
					}
		else if (browsername.equalsIgnoreCase("firefox")) {
				driver= new FirefoxDriver();
			
		}
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(5));
		
		return driver;
		
	}
	

	}
