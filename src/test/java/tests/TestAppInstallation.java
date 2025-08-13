package tests;

import java.net.MalformedURLException;
import java.time.Duration;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.appmanagement.ApplicationState;
import utils.DriverUtil;

public class TestAppInstallation {

	@Test

	public void testCase1() throws MalformedURLException {

		AndroidDriver driver = DriverUtil.getAndroidDriver("C:\\StarAgile\\AndroidMobileTestingDemo\\demo.apk");

		driver.resetInputState();

		driver.activateApp("io.appium.android.apis");

		driver.installApp("C:\\StarAgile\\AndroidMobileTestingDemo\\demo.apk");

		boolean installed = driver.isAppInstalled("io.appium.android.apis");

		System.out.println(installed);

		ApplicationState state = driver.queryAppState("io.appium.android.apis");

		System.out.println(state);

		driver.runAppInBackground(Duration.ofSeconds(10));

		driver.terminateApp("io.appium.android.apis");

		driver.removeApp("io.appium.android.apis");

	}

}
