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

public class TC_01 
{
	//Preference>>Preference Dependencies>>wifi>>wifi setting>>Enter Anything>>Ok
	public static void main(String[] args) throws MalformedURLException {
		File app = new File("D:\\Projects\\Appium\\Appium\\apkFiles\\ApiDemo.apk");
		
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

}
