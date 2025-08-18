package assignments;

import java.net.MalformedURLException;

import org.openqa.selenium.WebElement;
import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.AppiumBy;
import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import utils.DriverUtil;
import utils.ElementUtil;
import utils.LogUtil;

public class Question3 {

	// 3: Write automation script to open APIDemos application on Mobile device
	// Goto view and perform drag and drop functionality.

	@Test

	public void dragAndDropTest() throws InterruptedException, MalformedURLException {

		// create a driver session
		AppiumDriver driver = DriverUtil.getAndroidDriver();
		ElementUtil.getScreenshot(driver, "HomePage");

		// views
		driver.findElement(AppiumBy.accessibilityId("Views")).click();
//				ElementUtil.getScreenshot(driver, "ViewPage");

		Thread.sleep(2000);

		// drag and drop
		driver.findElement(AppiumBy.accessibilityId("Drag and Drop")).click();
//				ElementUtil.getScreenshot(driver, "DragPage");

		Thread.sleep(2000);

		// dot1
		WebElement element = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_dot_1"));

//				ElementUtil.getScreenshot(driver, "Dotpage");

		Thread.sleep(2000);

		ElementUtil.dragAndDropElement(driver, element);

		// result message
		String resultText = driver.findElement(AppiumBy.id("io.appium.android.apis:id/drag_result_text")).getText();

//				ElementUtil.getScreenshot(driver, "Completion");

		String expText = "Dropped!";

		Assert.assertEquals(resultText, expText);
		LogUtil.info("Result Text is: " + resultText);

	}

}
