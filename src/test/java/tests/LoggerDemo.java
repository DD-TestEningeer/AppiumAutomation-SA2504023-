package tests;

import io.appium.java_client.android.AndroidDriver;
import utils.LogUtil;

public class LoggerDemo {
	
	
	public static void main(String[] args) {
		
		
		
		System.out.println("this is my main method");
		
		LogUtil.info("this is text from logger");
		
//		AndroidDriver driver2 = null;
//		
//		driver2.quit();
		
		try {
			
			AndroidDriver driver = null;
			
			driver.quit();
			
		} catch (Exception e) {

			System.out.println(e.getLocalizedMessage());
			
			LogUtil.error(e.getLocalizedMessage());
			
		}
		
		
	}

}
