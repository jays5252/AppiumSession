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
		test = report.createTest("TC1 — navigate to the app and verify there are 10 elements or not");
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
		test = report.createTest("TC2 — navigate to the app, add one product into the cart");
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
		test = report.createTest("TC3 — navigate to the app, add two product into the cart and verify total is correct or not");
		WebElement nameField = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField"));
		nameField.sendKeys("Jay");
		
		WebElement letShopButton = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop"));
		letShopButton.click();
		
		WebElement firstProductAddtoCardButton = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"ADDED TO CART\")"));
		firstProductAddtoCardButton.click();
		
		WebElement secondProductAddtoCardButton = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"ADD TO CART\")"));
		secondProductAddtoCardButton.click();
	}

	@Test
	public void TC_04()
	{
		test = report.createTest("TC4 — navigate to the app, add one product into the cart and verify visit to the website msg is appear or not");

		WebElement nameField = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField"));
		nameField.sendKeys("Jay");
		
		WebElement letShopButton = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop"));
		letShopButton.click();

		WebElement firstProduct = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().resourceId(\"com.androidsample.generalstore:id/productAddCart\").instance(0)"));
		firstProduct.click();

		WebElement cartButton = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/counterText"));
		cartButton.click();

		WebElement cartProductElement = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/productName"));
		boolean isVisible = cartProductElement.isDisplayed();
		assertEquals(isVisible, true, "Cart product element should be visible.");
	}

	@Test(priority = 1)
	public void TC_05()
	{
		test = report.createTest("TC5 — navigate to the app and do the scrolling till last item and add that item into the cart");

		WebElement nameField = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField"));
		nameField.sendKeys("Jay");

		WebElement letShopButton = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop"));
		letShopButton.click();

		// Get all products initially visible
		List<WebElement> allProducts = driver.findElements(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"]"));
		
		// Click on each available product
		for (int i = 0; i < allProducts.size(); i++) {
			try {
				// Re-find elements to avoid stale element exception
				allProducts = driver.findElements(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"]"));
				
				if (i < allProducts.size()) {
					WebElement product = allProducts.get(i);
					
					// Scroll to element if not visible
					if (!product.isDisplayed()) {
						// Use Android UI Automator to scroll to the element
						driver.findElement(AppiumBy.androidUIAutomator(
							"new UiScrollable(new UiSelector().scrollable(true)).scrollIntoView(" +
							"new UiSelector().resourceId(\"com.androidsample.generalstore:id/productAddCart\"))"));
					}
					
					// Click the product
					product.click();
					
					// Small delay to allow UI to update
					Thread.sleep(1000);
				}
			} catch (Exception e) {
				System.out.println("Error clicking product at index " + i + ": " + e.getMessage());
			}
		}
		
		// Continue scrolling and clicking until no more products are found
		boolean moreProductsFound = true;
		int maxScrolls = 10; // Limit scrolling to prevent infinite loop
		int scrollCount = 0;
		
		while (moreProductsFound && scrollCount < maxScrolls) {
			try {
				// Scroll down to find more products
				driver.findElement(AppiumBy.androidUIAutomator(
					"new UiScrollable(new UiSelector().scrollable(true)).scrollForward()"));
				
				// Find new products after scrolling
				List<WebElement> newProducts = driver.findElements(AppiumBy.xpath("//android.widget.TextView[@resource-id=\"com.androidsample.generalstore:id/productAddCart\"]"));
				
				// Check if we found new products that haven't been clicked yet
				int clickedCount = 0;
				for (WebElement product : newProducts) {
					if (product.isDisplayed() && product.getText().equals("ADD TO CART")) {
						product.click();
						clickedCount++;
						Thread.sleep(1000);
					}
				}
				
				// If no new products were clicked, stop the loop
				if (clickedCount == 0) {
					moreProductsFound = false;
				}
				
				scrollCount++;
				
			} catch (Exception e) {
				moreProductsFound = false;
				System.out.println("No more products found or error occurred: " + e.getMessage());
			}
		}

		WebElement cartButton = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/counterText"));
		cartButton.click();

		WebElement counterText = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/counterText"));
		assertEquals(counterText.getText(), "10", "Cart counter should be 10.");

	}

	@Test
	public void TC_06()
	{
		test = report.createTest("TC6 — navigate to the app and select an item and enter name and click on Let's go");

		WebElement nameField = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/nameField"));
		nameField.sendKeys("Jay");
		
		WebElement letShopButton = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/btnLetsShop"));
		letShopButton.click();

		WebElement pageTitle = driver.findElement(AppiumBy.id("com.androidsample.generalstore:id/toolbar_title"));
		assertEquals(pageTitle.getText(), "Products", "Page title should be 'Products'.");

	}
}