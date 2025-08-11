package com.app.Appium;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class TC_03 
{
	//Prefrences>>Advance Preference>>My prefrences
	public static void main(String[] args) throws MalformedURLException 
	{
File app = new File("D:\\Projects\\Appium\\Appium\\apkFiles\\ApiDemo.apk");
		
		//127.0.0.1:4723
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "10AC8R126P000TV");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
		WebElement prefrenceLink = driver.findElement(AppiumBy.accessibilityId("Preference"));
		prefrenceLink.click();
		
		WebElement AdvancePreference = driver.findElement(AppiumBy.accessibilityId("6. Advanced preferences"));
		AdvancePreference.click();
		
		WebElement myPreferences = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"My preference\")"));
		myPreferences.click();
		
		
		
	}

}
