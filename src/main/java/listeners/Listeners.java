package listeners;
import java.io.File;
import java.io.IOException;
import java.util.Calendar;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.MediaEntityBuilder;
import com.aventstack.extentreports.Status;
import com.aventstack.extentreports.markuputils.ExtentColor;
import com.aventstack.extentreports.markuputils.MarkupHelper;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.aventstack.extentreports.reporter.configuration.Theme;

import resources.Base;


public class Listeners extends Base implements ITestListener {
	WebDriver driver;
	 ExtentSparkReporter htmlreporter;
	 ExtentReports reports;
	 ExtentTest test;
	
public void configurereport() {
	htmlreporter= new ExtentSparkReporter("Report2.html");
	reports= new ExtentReports();
	reports.attachReporter(htmlreporter);
	
	//add environment information
	reports.setSystemInfo("Browser", "Chrome");
	htmlreporter.config().setReportName("Login Report");
	htmlreporter.config().setDocumentTitle("Avni's report");
	htmlreporter.config().setTheme(Theme.STANDARD);
	htmlreporter.config().setTimeStampFormat("EEEE, MM DD, YYYY, hh:mm a '('zzz')'");
}
	
	@Override
	public void onTestStart(ITestResult result) {
		configurereport();
		System.out.println("test case started"+result.getName());
	}

	@Override
	public void onTestSuccess(ITestResult result) {
		test=reports.createTest(result.getName());
		test.log(Status.PASS, MarkupHelper.createLabel("Name of failed test case os"+result.getName(), ExtentColor.BLUE));
		
		
	}

	@Override
	public  void onTestFailure(ITestResult result) {
		test=reports.createTest(result.getName());
		test.log(Status.FAIL, MarkupHelper.createLabel("Name of failed test case os"+result.getName(), ExtentColor.RED));
		System.out.println("test case failed"+result.getName());
		test.fail(MediaEntityBuilder.createScreenCaptureFromPath("img.png").build());
		//test.fail(MediaEntityBuilder.createScreenCaptureFromBase64String("base64").build());

	}
	@Override
	public void onTestSkipped(ITestResult result) {
		
	}

	@Override
	public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
		
	}

	@Override
	public void onTestFailedWithTimeout(ITestResult result) {
		
	}

	@Override
	public void onStart(ITestContext context) {
		System.out.println("test started"+context.getName());
	}

	@Override
	public void onFinish(ITestContext context) {
		System.out.println("test completed"+context.getName());
		reports.flush();
	}
	
	

}
