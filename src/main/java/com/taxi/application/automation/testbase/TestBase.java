package com.taxi.application.automation.testbase;

import static com.taxi.application.automation.utility.LoadProperty.readLocatorString;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.remote.DesiredCapabilities;

import com.taxi.application.automation.constants.FilePathConstants;
import com.taxi.application.automation.constants.KeyConstants;
import com.taxi.application.automation.utility.ElementAction;
import com.taxi.application.automation.utility.LoadProperty;

import io.appium.java_client.AppiumDriver;
import io.appium.java_client.android.AndroidDriver;

public class TestBase {
	public static AppiumDriver driver;
	public static URL url;
	public static String allowsbutton = FilePathConstants.REGISTRATION_PATH;
	static String testPath = FilePathConstants.CAPABILITIES_DETAIL;
	public static JavascriptExecutor executor;

	public static void setup() {

		String appServerURL = LoadProperty.readLocatorString(testPath, KeyConstants.LAUNCH_APP_URL);

		try {
			url = new URL(appServerURL);
		} catch (MalformedURLException malformedURLException) {
			malformedURLException.printStackTrace();
		}

		DesiredCapabilities capabilities = new DesiredCapabilities();

		capabilities.setCapability("platformName", "Android");
		capabilities.setCapability("platformVersion", "9.0");
		capabilities.setCapability("udid", "emulator-5554");
		capabilities.setCapability("deviceName", "Pixel 2");
		capabilities.setCapability("appPackage", "com.atmecs.taxi");
		capabilities.setCapability("appActivity", "com.atmecs.taxi.LoginActivity");

		if (url != null) {
			driver = new AndroidDriver(url, capabilities);
			driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));

		} else {
			System.out.println("Failed to load the Taxi App!!");
		}

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		WebElement smspermission = driver
				.findElement(By.id(readLocatorString(allowsbutton, KeyConstants.SMS_PERMISSION)));
		ElementAction.isElementPresent(smspermission);
		smspermission.click();

		WebElement locationPermission = driver
				.findElement(By.id(readLocatorString(allowsbutton, KeyConstants.LOCATION_PERMISSION)));
		ElementAction.isElementPresent(locationPermission);
		locationPermission.click();

	}

	public static void main(String[] args) {
		setup();
	}
}
