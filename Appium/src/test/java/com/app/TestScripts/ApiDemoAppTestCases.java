package com.app.TestScripts;

import java.io.File;
import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.remote.MobileCapabilityType;
import io.appium.java_client.remote.MobilePlatform;

public class ApiDemoAppTestCases
{
	@Test
	public void TC_01() throws MalformedURLException
	{
		File app = new File("../Appium/apkFiles/ApiDemo.apk");
		
		//127.0.0.1:4723
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "10AC8R126P000TV");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
		WebElement preferenceLink = driver.findElement(AppiumBy.accessibilityId("Preference"));
		preferenceLink.click();
		
		WebElement PreferenceDependenciesLink = driver.findElement(AppiumBy.accessibilityId("3. Preference dependencies"));
		PreferenceDependenciesLink.click();
		
		WebElement Wifi = driver.findElement(AppiumBy.
				xpath("//android.widget.ListView[@resource-id=\"android:id/list\"]/android.widget.LinearLayout[1]/android.widget.RelativeLayout"));
		Wifi.click();
		
		WebElement wifiSettings = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.RelativeLayout\").instance(1)"));
		wifiSettings.click();
		
		WebElement wifiPasswordTextBox = driver.findElement(AppiumBy.id("android:id/edit"));
		wifiPasswordTextBox.sendKeys("1234567890");
		
		WebElement OkButton = driver.findElement(AppiumBy.id("android:id/button1"));
		OkButton.click();
		
		driver.close();
	}
	
	@Test
	public void TC_02() throws MalformedURLException
	{
		File app = new File("../Appium/apkFiles/ApiDemo.apk");
		
		//127.0.0.1:4723
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setCapability(MobileCapabilityType.PLATFORM_NAME, MobilePlatform.ANDROID);
		cap.setCapability(MobileCapabilityType.DEVICE_NAME, "10AC8R126P000TV");
		cap.setCapability(MobileCapabilityType.APP, app.getAbsolutePath());
		AndroidDriver driver = new AndroidDriver(new URL("http://127.0.0.1:4723/wd/hub"), cap);
		
		WebElement preferenceLink = driver.findElement(AppiumBy.accessibilityId("Preference"));
		preferenceLink.click();
		
		WebElement launchingPreferences = driver.findElement(AppiumBy.accessibilityId("2. Launching preferences"));
		launchingPreferences.click();
		
		WebElement launchPrefrenceActivity = driver.findElement(AppiumBy.className("android.widget.Button"));
		launchPrefrenceActivity.click();
		
		WebElement myPreferences = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().className(\"android.widget.RelativeLayout\").instance(0)"));
		myPreferences.click();
		
		driver.close();
	}
	
	@Test
	public void TC_03() throws MalformedURLException
	{
		File app = new File("../Appium/apkFiles/ApiDemo.apk");
		
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
	
	@Test
	public void TC_04() throws MalformedURLException
	{
		File app = new File("../Appium/apkFiles/ApiDemo.apk");
		
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
