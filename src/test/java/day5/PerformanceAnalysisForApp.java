package day5;

import java.net.MalformedURLException;
import java.util.List;

import org.testng.annotations.Test;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;
import utils.DriverUtil;

public class PerformanceAnalysisForApp {
	@Test
	public void performanecParameterTesting() throws MalformedURLException {
		// create driver session
		AndroidDriver driver = DriverUtil.getAndroidDriver();

		// To find the app package name
		String packageName = ((AndroidDriver) driver).getCurrentPackage();
		System.out.println("App Package name is: " + packageName);

		List<String> allDataTypes = driver.getSupportedPerformanceDataTypes();

		System.out.println(allDataTypes);
		// [cpuinfo, memoryinfo, batteryinfo, networkinfo]

		// batteryInfo
		List<List<Object>> batteryData = driver.getPerformanceData(packageName, "batteryinfo", 5);
		System.out.println(batteryData);

		// MemoryInfo
		List<List<Object>> memoryData = driver.getPerformanceData(packageName, "memoryinfo", 5);
		System.out.println(memoryData);

		// NetworkInfo
		List<List<Object>> networkData = driver.getPerformanceData(packageName, "networkinfo", 5);
		System.out.println(networkData);

		/*
		 * //CPUInfo List<List<Object>>
		 * cpuData=((AndroidDriver)driver).getPerformanceData(packageName,"cpuinfo",5);
		 * System.out.println(cpuData);
		 * 
		 */

	}
}
