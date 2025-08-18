package assignments;

import java.net.MalformedURLException;

import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;

import io.appium.java_client.android.AndroidDriver;
import listeners.ExtentManager;
import utils.DriverUtil;
import utils.ElementUtil;
import utils.LogUtil;

public class Question1 {

	// 1: Write automation script for connecting android device and capture the
	// session Id for connection.

	@Test

	public void getSessionID() throws MalformedURLException {

		// Step 1: Get the ExtentReports instance
		ExtentReports extent = ExtentManager.getInstance();

		// Step 2: Create a test case in the report
		ExtentTest test = extent.createTest("getSessionID");

		LogUtil.info("The question1 test started..........");
		test.info("The question1 test started..........");

		AndroidDriver driver = DriverUtil.getAndroidDriver();

		LogUtil.info("The session id is : " + driver.getSessionId());

		ElementUtil.getScreenshot(driver, "getSessionID");

		LogUtil.info("The question1 test ended..........");
		test.pass("Test passed successfully!");

		// Step 3: Flush the report (writes the report file)
		extent.flush();

	}

}
