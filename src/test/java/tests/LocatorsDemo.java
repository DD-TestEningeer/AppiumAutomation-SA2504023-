package tests;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import utils.DriverUtil;

public class LocatorsDemo {

	@Test

	public void appiumLocatorTest() throws MalformedURLException {

		// 1 - Create a android mobile session - driver uitility

		AndroidDriver driver = DriverUtil.getAndroidDriver();

		// Locator 1 - adnroidUIAutomator

		WebElement element1 = driver.findElement(AppiumBy.androidUIAutomator("new UiSelector().text(\"API Demos\")"));

		String actHeaderText = element1.getText();

		System.out.println("The app header text is : " + actHeaderText);
		
		
		Assert.assertEquals(actHeaderText, "API Demos123");
		
		
		
		

		// Locator 2 - xpath

		WebElement element2 = driver.findElement(AppiumBy.xpath("//android.widget.TextView[@text=\"API Demos\"]"));

		actHeaderText = element2.getText();

		System.out.println("The app header text is : " + actHeaderText);

		// Locator 3 - Element ID

		WebElement element3 = driver.findElement(AppiumBy.id("android:id/text1"));

		actHeaderText = element3.getText();

		System.out.println("The app header text is : " + actHeaderText);

		// Locator 4 - className

		WebElement element4 = driver.findElement(AppiumBy.className("android.widget.TextView"));

		actHeaderText = element4.getText();

		System.out.println("The app header text is : " + actHeaderText);
		
		
		// Locator 5 - Accesibility ID

		WebElement element5 = driver.findElement(AppiumBy.accessibilityId("Access'ibility"));

		actHeaderText = element5.getText();

		System.out.println("The app header text is : " + actHeaderText);

		
		driver.close();
//		driver.quit();
	}

}
