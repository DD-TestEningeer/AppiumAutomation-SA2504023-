package assignments;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.appmanagement.ApplicationState;
import utils.DriverUtil;
import utils.LogUtil;

public class Question2 {

	@Test

	public void testAppState() throws MalformedURLException {

		// 2: Write automation script for launching mobile application

		AndroidDriver driver = DriverUtil.getAndroidDriver();

		// a. test the application current state

		ApplicationState state = driver.queryAppState("io.appium.android.apis");

		LogUtil.info("The current state of app :  " + state);
		
		
		// Unistalled the App 
		
		driver.removeApp("io.appium.android.apis");
		
		LogUtil.info("The app is uninstalled");

		
		

	}

}
