package tests;

import java.net.MalformedURLException;
import java.net.URL;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.testng.annotations.Test;

import io.appium.java_client.android.AndroidDriver;
import io.appium.java_client.android.options.UiAutomator2Options;

public class LanuchMobileApp {
	
	
	
	public static void main(String[] args) {
		
		
		System.out.println("main method");
		
	}

	
	@Test
	
	public void testMethod() {
		
		System.out.println("testng method");
	}
	
	
	
	
	@Test
	
	public void installAppTest() throws MalformedURLException {
		
//		{
//			  "platformName": "Android",
//			  "appium:automationName": "UiAutomator2",
//			  "appium:deviceName": "emulator-5556",
//			  "appium:app": "C:\\apk_files\\ApiDemos-debug.apk"
//			}
		
		
		// web automation 
		
//		ChromeOptions options = new ChromeOptions();
//		options.addArguments("--headless");
//		
//		ChromeDriver driver = new ChromeDriver(options);
		
		
		UiAutomator2Options options = new UiAutomator2Options();
		options.setCapability("platformName", "Android");
		options.setCapability("appium:automationName", "UiAutomator2");
		options.setCapability("appium:deviceName", "emulator-5554");
		options.setCapability("appium:app", "C:\\StarAgile\\AndroidMobileTestingDemo\\demo.apk");
		
		
		URL url = new URL("http://127.0.0.1:4723/");
		
		AndroidDriver driver = new AndroidDriver(url, options);
		
		
		System.out.println(driver.getSessionId());
		
		

		
	}
	
	
	
}
