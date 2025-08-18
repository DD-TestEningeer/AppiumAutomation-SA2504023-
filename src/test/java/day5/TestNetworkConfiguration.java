package day5;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import utils.DriverUtil;
import utils.ElementUtil;

public class TestNetworkConfiguration {
	/*
	 * 
	 * toggleWifi() toggleData():mobile data toggleAirplaneMode()
	 * 
	 */
	@Test
	public void testNetwrokConfiguration() throws InterruptedException, MalformedURLException {

		// create driver session

		AndroidDriver driver = DriverUtil.getAndroidDriver();

		System.out.println("Current state of Wifi is ON");
		// ON--->OFF

		driver.toggleWifi();

		Thread.sleep(4000);
		System.out.println("After calling Method state of Wifi is OFF");
		// OFF--->ON

		driver.toggleWifi();
		Thread.sleep(4000);

		System.out.println("After calling Method state of Wifi is ON");

		// mobile data do swipe

		// area
		WebElement area = driver.findElement(AppiumBy.id("com.android.systemui:id/notification_stack_scroller"));
		ElementUtil.swipeLeft(driver, area);

		Thread.sleep(4000);

		System.out.println("Current status of MobileData is ON");
		// ON to OFF

		driver.toggleData();

		System.out.println("After calling method status of MobileData is OFF");

		Thread.sleep(3000);

		// OFF To ON
		driver.toggleData();

		System.out.println("After calling method status of MobileData is ON");

		// Airplane Mode
		Thread.sleep(4000);

		System.out.println("Current status of AirplaneMode is OFF");
		// OFF to ON

		driver.toggleAirplaneMode();

		System.out.println("After calling method status of AirplaneMode is ON");
		// ON--->OFF

		Thread.sleep(4000);

		driver.toggleAirplaneMode();

		System.out.println("After calling method status of AirplaneMode is OFF");

	}
}
