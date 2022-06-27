package com.taxi.application.automation.testscripts;

import static com.taxi.application.automation.utility.LoadProperty.readLocatorString;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.taxi.application.automation.constants.FilePathConstants;
import com.taxi.application.automation.constants.KeyConstants;
import com.taxi.application.automation.testbase.TestBase;
import com.taxi.application.automation.utility.LoginFunction;
import com.taxi.application.automation.utility.UserRegistration;

public class DeleteAccountTest extends TestBase {

	public static String delectpath = FilePathConstants.DELETE_PATH;
	public static String loginDetails = FilePathConstants.LOGIN_DETAIL;
	public static String loginPath = FilePathConstants.LOGIN_PATH;

	@Test
	public static void delectpage() throws InterruptedException {

		setup();
		
		UserRegistration.createUserRegister();
		LoginFunction.login();

		WebElement menuSelect = driver
				.findElement(By.xpath(readLocatorString(delectpath, KeyConstants.MENU_SCROLL_BAR)));
		menuSelect.click();

		WebElement settingsButton = driver
				.findElement(By.xpath(readLocatorString(delectpath, KeyConstants.SETTINGS_BUTTON)));
		settingsButton.click();

		WebElement deleteButton = driver
				.findElement(By.xpath(readLocatorString(delectpath, KeyConstants.DELETE_BUTTON)));
		deleteButton.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		WebElement delectaccount = driver
				.findElement(By.id(readLocatorString(delectpath, KeyConstants.DELECT_ACCOUNT_CONFRIM)));
		String POPMessage = delectaccount.getText();
		System.out.println(POPMessage);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		WebElement okaybotton = driver.findElement(By.id(readLocatorString(delectpath, KeyConstants.DELETE_OK_BUTTON)));
		Assert.assertTrue(okaybotton.isDisplayed());
		okaybotton.click();

		LoginFunction.login();
		Assert.assertFalse(true);
		driver.quit();

	}

}
