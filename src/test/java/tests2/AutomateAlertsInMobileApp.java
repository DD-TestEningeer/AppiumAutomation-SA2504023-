package tests2;

import org.testng.annotations.Test;
import java.net.MalformedURLException;
import org.openqa.selenium.Alert;
import io.appium.java_client.AppiumBy;
import io.appium.java_client.android.AndroidDriver;
import utils.DriverUtil;

public class AutomateAlertsInMobileApp {
	@Test
	public void testAlert() throws InterruptedException, MalformedURLException {
		/*
		 * In Selenium we handle the Alerts using Alert interface
		 * 
		 * 1.getText(): text of alert 2.accept(): Ok 3.dismiss(): Cancel 4.sendKeys():
		 * prompt type alert
		 * 
		 * 
		 */

		// create a driver session
		AndroidDriver driver = DriverUtil.getAndroidDriver();

		// app
		driver.findElement(AppiumBy.accessibilityId("App")).click();
		
		Thread.sleep(3000);

		// alerts option
		driver.findElement(AppiumBy.accessibilityId("Alert Dialogs")).click();
		
		Thread.sleep(3000);

		// alert1
		driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with a message")).click();
		
		Thread.sleep(3000);

		// alert will open

		Alert alt1 = driver.switchTo().alert();
		System.out.println("Alert1 Text is: " + alt1.getText());
		
		Thread.sleep(3000);

		// ok
		alt1.accept();

		System.out.println("Alert1 handled ......");
		Thread.sleep(3000);

		// alert2
		driver.findElement(AppiumBy.accessibilityId("OK Cancel dialog with ultra long message")).click();

		Alert alt2 = driver.switchTo().alert();

		System.out.println("Alert 2 text is: " + alt2.getText());
		
		Thread.sleep(3000);

		// cancel
		alt2.dismiss();
		
		// driver.switchTo().alert();  alt3.sendKeys("text value");

	}
}
