package utils;

import java.io.File;
import java.io.IOException;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.io.FileHandler;
import org.openqa.selenium.remote.RemoteWebElement;

import com.google.common.collect.ImmutableMap;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class ElementUtil

//https://github.com/appium/appium-uiautomator2-driver/blob/master/docs/android-mobile-gestures.md

{

	public static void longClick(AppiumDriver driver, WebElement element) {

		driver.executeScript("mobile:longClickGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) element).getId(), "duration", 4000

				));

	}

	public static void dragAndDropElement(AndroidDriver driver, WebElement element) {

		// gesture
		driver.executeScript("mobile:dragGesture", ImmutableMap.of(

				"elementId", ((RemoteWebElement) element).getId(), "endX", 804, "endY", 1543

		));

	}

	public static void dragAndDropElement(AppiumDriver driver, WebElement element) {

		// gesture
		driver.executeScript("mobile:dragGesture", ImmutableMap.of(

				"elementId", ((RemoteWebElement) element).getId(), "endX", 804, "endY", 1543

		));

	}

	public static void getScreenshot(AndroidDriver driver, String fname) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(
				System.getProperty("user.dir") + "//Screenshots//" + fname + System.currentTimeMillis() + ".png");
		try {
			FileHandler.copy(temp, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void getScreenshot(AppiumDriver driver, String fname) {
		TakesScreenshot ts = (TakesScreenshot) driver;
		File temp = ts.getScreenshotAs(OutputType.FILE);
		File dest = new File(
				System.getProperty("user.dir") + "//Screenshots//" + fname + System.currentTimeMillis() + ".png");
		try {
			FileHandler.copy(temp, dest);
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

	public static void scrollDown(AppiumDriver driver, WebElement area) {
		driver.executeScript("mobile:scrollGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) area).getId(), "direction", "down", "percent", 1.0

				));
	}

	public static void scrollDown(AndroidDriver driver, WebElement area) {
		driver.executeScript("mobile:scrollGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) area).getId(), "direction", "down", "percent", 1.0

				));
	}

	public static void scrollDownUpToCount(AppiumDriver driver, WebElement area, int count) {
		for (int i = 1; i <= count; i++) {

			driver.executeScript("mobile:scrollGesture",
					ImmutableMap.of("elementId", ((RemoteWebElement) area).getId(), "direction", "down", "percent", 1.0

					));
			System.out.println("Iteration count is: " + i);
		}
	}

	public static void scrollUp(AppiumDriver driver, WebElement area) {
		driver.executeScript("mobile:scrollGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) area).getId(), "direction", "up", "percent", 1.0

				));
	}

	public static void scrollLeft(AppiumDriver driver, WebElement area) {
		driver.executeScript("mobile:scrollGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) area).getId(), "direction", "left", "percent", 1.0

				));
	}

	public static void scrollRight(AppiumDriver driver, WebElement area) {
		driver.executeScript("mobile:scrollGesture",
				ImmutableMap.of("elementId", ((RemoteWebElement) area).getId(), "direction", "right", "percent", 1.0

				));
	}

	// swipe
	public static void swipeLeft(AppiumDriver driver, WebElement area) {
		driver.executeScript("mobile:swipeGesture", ImmutableMap.of(

				"elementId", ((RemoteWebElement) area).getId(), "direction", "left", "percent", 1.0));
	}

	public static void swipeUp(AppiumDriver driver, WebElement area) {
		driver.executeScript("mobile:swipeGesture", ImmutableMap.of(

				"elementId", ((RemoteWebElement) area).getId(), "direction", "up", "percent", 1.0));
	}

	public static void swipeDown(AppiumDriver driver, WebElement area) {
		driver.executeScript("mobile:swipeGesture", ImmutableMap.of(

				"elementId", ((RemoteWebElement) area).getId(), "direction", "down", "percent", 1.0));
	}

	public static void swipeRight(AppiumDriver driver, WebElement area) {
		driver.executeScript("mobile:swipeGesture", ImmutableMap.of(

				"elementId", ((RemoteWebElement) area).getId(), "direction", "right", "percent", 1.0));
	}

	public static void clickButton(AppiumDriver driver, WebElement ele) {

		driver.executeScript("mobile:clickGesture", ImmutableMap.of(

				"elementId", ((RemoteWebElement) ele).getId()

		));

	}

}
