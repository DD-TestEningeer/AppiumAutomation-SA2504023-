package tests2;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.appmanagement.ApplicationState;
import utils.DriverUtil;

public class AppManagementAndroid {

	@Test
	public void testAppManagement() throws MalformedURLException, InterruptedException {

		AndroidDriver driver = null;

		driver = DriverUtil.getAndroidDriver();

		// install the app

		driver.installApp("C:\\StarAgile\\AndroidMobileAppTesting\\src\\test\\resources\\ApiDemos-debug.apk");

		// activate the app

		driver.activateApp("io.appium.android.apis");

		// run the app in background
		driver.runAppInBackground(Duration.ofSeconds(10));

		Thread.sleep(3000);

		// status of the app

		ApplicationState state = driver.queryAppState("io.appium.android.apis");

		System.out.println("The current app state : " + state);

		// uninstalled the app

//         driver.removeApp("io.appium.android.apis");

	}

}
