package tests2;

import java.net.MalformedURLException;
import org.openqa.selenium.ScreenOrientation;
import org.testng.annotations.Test;
import io.appium.java_client.android.AndroidDriver;
import utils.DriverUtil;

public class TestDeviceLock_Unlock_Rotate {
	@Test
	public void deviceLockUnlock() throws InterruptedException, MalformedURLException {

		// create driver session
		AndroidDriver driver = DriverUtil.getAndroidDriver();

		// lock
		driver.lockDevice();

		Thread.sleep(2000);

		// unlock
		driver.unlockDevice();

		Thread.sleep(2000);

		// rotate screen
		driver.rotate(ScreenOrientation.LANDSCAPE);

		Thread.sleep(2000);

		driver.rotate(ScreenOrientation.PORTRAIT);

	}
}
