package com.app.TestScripts;

import static org.testng.Assert.assertEquals;
import java.net.MalformedURLException;
import java.util.List;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;
import com.app.Base.BaseClass;
import io.appium.java_client.AppiumBy;

public class GeneralStoreTestCases extends BaseClass 
{
	@Test
	public void TC_01() throws MalformedURLException
	{
		test = report.createTest("TC_01");
		WebElement nameField = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField"));
		nameField.sendKeys("Jay");
		
		WebElement letShopButton = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop"));
		letShopButton.click();
		
		List<WebElement> productList = driver.findElements(AppiumBy.xpath("//android.widget.ImageView[@resource-id=\"com.androidsample.generalstore:id/productImage\"]"));
		int count = productList.size();
		System.out.println("Count: "+count);
		
		assertEquals(count, 10, "Products count should be 10");
	}
	@Test
	public void TC_02() throws MalformedURLException
	{
		test = report.createTest("TC_02");
		WebElement nameField = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField"));
		nameField.sendKeys("Jay");
		
		WebElement letShopButton = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop"));
		letShopButton.click();
		
		WebElement firstProcuctKart = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/productAddCart\").instance(0)"));
		firstProcuctKart.click();
		
		WebElement cartButton = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/appbar_btn_cart"));
		cartButton.click();
		
		WebElement cartProductElement = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/productName"));
		assertEquals(cartProductElement.getText(), "Air Jordan 4 Retro");
	}
	@Test
	public void TC_03()
	{
		test = report.createTest("TC_03");
		WebElement nameField = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField"));
		nameField.sendKeys("Jay");
		
		WebElement letShopButton = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop"));
		letShopButton.click();
		
		WebElement firstProductAddtoCardButton = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"ADDED TO CART\")"));
		firstProductAddtoCardButton.click();
		
		WebElement secondProductAddtoCardButton = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"ADD TO CART\")"));
		secondProductAddtoCardButton.click();
	}
}
