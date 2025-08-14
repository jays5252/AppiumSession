package com.app.Base;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.app.Assertions.Assertions;
import com.app.Utils.ReportHandling;
import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class BaseClass 
{
	public AndroidDriver driver;
    public ExtentReports report;
    public ExtentTest test;

    @BeforeSuite
    public void setupReport()
    {
        ExtentSparkReporter sparkReporter = ReportHandling.TakeReport("../Appium/Test-Report/report.html");
        report = new ExtentReports();
        report.attachReporter(sparkReporter);
    }

	@BeforeMethod
	public void LaunchApp() throws MalformedURLException
	{
		File app = new File("../Appium/apkFiles/General-Store.apk");
		
		//127.0.0.1:4723
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "10AC8R126P000TV");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		
		// Add capability to reset app state between tests
		cap.setCapability("noReset", false);
		cap.setCapability("fullReset", false);
		
		driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	@AfterMethod
	public void CloseApp(ITestResult result)
	{
		// Use Assertions utility for centralized test result handling
		// Expected message will be retrieved from test context or passed via test method
		String expectedMessage = getExpectedMessageFromContext(result);
		Assertions.assertResult(result, test, expectedMessage);
		
		if (driver != null) {
			driver.quit();
		}
	}
	
	/**
	 * Method to retrieve expected message from test context
	 * Override this method in test classes to provide custom expected messages
	 */
	protected String getExpectedMessageFromContext(ITestResult result) {
		// Default implementation - can be overridden by test classes
		// Test classes can use @Test annotation attributes or custom methods
		return "Test should complete successfully";
	}
	
	@AfterSuite
	public void closeReport()
    {
        report.flush();
    }
}
