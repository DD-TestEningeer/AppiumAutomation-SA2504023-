package tests2;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;
import io.appium.java_client.appmanagement.ApplicationState;

public class AppManagementWithTestNGAssertions {

    private static final String DEVICE_NAME = "emulator-5554";
    private static final String APPIUM_SERVER_URL = "http://127.0.0.1:4723";
    private static final String APP_PACKAGE = "io.appium.android.apis";
    private static final String APK_PATH = "C:\\StarAgile\\AndroidMobileAppTesting\\src\\test\\resources\\ApiDemos-debug.apk";

    @Test
    public void testAppManagement() throws MalformedURLException, InterruptedException {

        AndroidDriver driver = null;

        try {
            // Set up device options
            UiAutomator2Options options = new UiAutomator2Options()
                    .setDeviceName(DEVICE_NAME);

            // Create Android driver
            driver = new AndroidDriver(new URL(APPIUM_SERVER_URL), options);
            System.out.println("Session created with ID: " + driver.getSessionId());

            // 1. Check if app is installed
            boolean isAppInstalled = driver.isAppInstalled(APP_PACKAGE);
            System.out.println("App installed: " + isAppInstalled);

            // 2. Assert that the app is not installed initially
            Assert.assertTrue(isAppInstalled, "The app should not be installed initially.");

            // 3. Install the app if not installed
            if (!isAppInstalled) {
                driver.installApp(APK_PATH);
                System.out.println("App installed successfully.");
            } else {
                System.out.println("App is already installed.");
            }

            // 4. Assert that the app is now installed
            isAppInstalled = driver.isAppInstalled(APP_PACKAGE);
            Assert.assertTrue(isAppInstalled, "The app should be installed now.");

            // 5. Activate the app
            driver.activateApp(APP_PACKAGE);
            System.out.println("App activated.");

            // 6. Query app state and assert that it's running
            ApplicationState appState = driver.queryAppState(APP_PACKAGE);
            Assert.assertEquals(appState.toString(), "RUNNING_IN_FOREGROUND", "The app should be in the running state.");

            // 7. Terminate the app
            driver.terminateApp(APP_PACKAGE);
            System.out.println("App terminated.");

            // 8. Assert that the app is terminated (not running)
            appState = driver.queryAppState(APP_PACKAGE);
            Assert.assertEquals(appState.toString(), "NOT_RUNNING", "The app should be terminated.");

            // 9. Reactivate the app
            driver.activateApp(APP_PACKAGE);
            System.out.println("App reactivated.");

            // 10. Run app in background for 5 seconds
            driver.runAppInBackground(Duration.ofSeconds(5));
            System.out.println("App running in background for 5 seconds.");

            // 11. Assert that the app state has changed
            appState = driver.queryAppState(APP_PACKAGE);
            Assert.assertEquals(appState.toString(), "RUNNING_IN_BACKGROUND", "The app should be in the running state after background.");

            // 12. Uninstall the app
            driver.removeApp(APP_PACKAGE);
            System.out.println("App uninstalled.");

            // 13. Assert that the app is uninstalled
            isAppInstalled = driver.isAppInstalled(APP_PACKAGE);
            Assert.assertFalse(isAppInstalled, "The app should be uninstalled.");

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            // Quit the driver to close the session
            if (driver != null) {
                driver.quit();
                System.out.println("Driver session closed.");
            }
        }
    }
}
