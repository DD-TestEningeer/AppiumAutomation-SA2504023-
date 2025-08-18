package day5;

import java.net.MalformedURLException;
import java.util.List;

import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import utils.DriverUtil;

public class TestNotifications {
	@Test
	public void testNotifications() throws InterruptedException, MalformedURLException {
		// create driver session
		AndroidDriver driver = DriverUtil.getAndroidDriver();

		// to open notification first convert appium driver to android driver

		driver.openNotifications();

		// expandButton
		driver.findElement(AppiumBy.accessibilityId("Expand")).click();

		Thread.sleep(2000);

		// number of notifications
		List<WebElement> notifications = driver.findElements(AppiumBy.id("android:id/title"));

		Thread.sleep(2000);

		System.out.println("For Android System  and Appium Setting Total Notifications are: " + notifications.size());// 2

		System.out.println("*****Notification Headings are*****");
		// headings for every notification

		for (WebElement i : notifications) {
			System.out.println(i.getText());

			Thread.sleep(2000);
		}

	}
}
