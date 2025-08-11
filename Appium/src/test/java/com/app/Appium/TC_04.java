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

public class TC_04 
{
	//Preference from XML>>Checkbox preference (Click on the checkbox  parent checkbox and the child checkbox)
	public static void main(String[] args) throws MalformedURLException 
	{
File app = new File("D:\\Projects\\Appium\\Appium\\apkFiles\\ApiDemo.apk");
		
		//127.0.0.1:4723
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "10AC8R126P000TV");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
		WebElement preferenceLink = driver.findElement(AppiumBy.accessibilityId("Preference"));
		preferenceLink.click();
		
		WebElement preferencefromXML = driver.findElement(AppiumBy.accessibilityId("1. Preferences from XML"));
		preferencefromXML.click();
		
		WebElement preferenceCheckBox = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/checkbox\").instance(0)"));
		preferenceCheckBox.click();
		
		WebElement parentCheckBoxPreferences = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/checkbox\").instance(1)"));
		parentCheckBoxPreferences.click();
		
		WebElement childCheckBoxPreferences = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"android:id/checkbox\").instance(2)"));
		childCheckBoxPreferences.click();
		
		
	}

}
