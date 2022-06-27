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
import com.taxi.application.automation.utility.ElementAction;
import com.taxi.application.automation.utility.LoginFunction;
import com.taxi.application.automation.utility.UserRegistration;

public class ChangePasswordTest extends TestBase {

	public static String passwordpath = FilePathConstants.PASSWORD_BUTTON;
	public static String loginDetails = FilePathConstants.LOGIN_DETAIL;
	public static String loginPath = FilePathConstants.LOGIN_PATH;

	@Test
	public static void passwordchange() {

		setup();

		UserRegistration.createUserRegister();
		LoginFunction.login();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		WebElement menuSelect = driver
				.findElement(By.xpath(readLocatorString(passwordpath, KeyConstants.MENU_SCROLL_BAR)));
		ElementAction.clickButton(menuSelect);

		WebElement settingsButton = driver
				.findElement(By.xpath(readLocatorString(passwordpath, KeyConstants.SETTINGS_BUTTON)));
		settingsButton.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		WebElement changepasswordbutton = driver
				.findElement(By.xpath(readLocatorString(passwordpath, KeyConstants.CHANGE_PASSWORD_BOTTON)));
		changepasswordbutton.click();

		WebElement oldpassword = driver
				.findElement(By.xpath(readLocatorString(passwordpath, KeyConstants.CHANGE_OLD_PASSWORD_BOTTON)));
		oldpassword.sendKeys(readLocatorString(passwordpath, KeyConstants.CHANGE_OLD_PASSWORD_BOTTON_TEXT));

		WebElement newpassword = driver
				.findElement(By.xpath(readLocatorString(passwordpath, KeyConstants.CHANGE_NEW_PASSWORD_BOTTON)));
		newpassword.sendKeys(readLocatorString(passwordpath, KeyConstants.CHANGE_NEW_PASSWORD_BOTTON_TEXT));
		WebElement repassword = driver
				.findElement(By.xpath(readLocatorString(passwordpath, KeyConstants.CHANGE_RENEW_PASSWORD_BOTTON)));
		repassword.sendKeys(readLocatorString(passwordpath, KeyConstants.CHANGE_RENEW_PASSWORD_BOTTON_TEXT));

		WebElement changebutton = driver
				.findElement(By.xpath(readLocatorString(passwordpath, KeyConstants.CHANGE_BOTTON)));
		changebutton.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		WebElement successfulmessage = driver
				.findElement(By.xpath(readLocatorString(passwordpath, KeyConstants.SUCCESSFULL_MESSAGE)));
		String popmessage = successfulmessage.getText();
		Assert.assertEquals(popmessage.contains("Password Changed Successfully!"), true);
		System.out.println(popmessage);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		WebElement okbutton = driver.findElement(By.id(readLocatorString(passwordpath, KeyConstants.OKAY_BUTTON)));
		okbutton.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		WebElement arrowbutton = driver
				.findElement(By.xpath(readLocatorString(passwordpath, KeyConstants.ARROW_CLASS)));
		arrowbutton.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		WebElement AgainmenuSelect = driver
				.findElement(By.xpath(readLocatorString(passwordpath, KeyConstants.MENU_SCROLL_BAR)));
		ElementAction.clickButton(AgainmenuSelect);

		LoginFunction.logout();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		WebElement loginMobileNumber = driver
				.findElement(By.id(readLocatorString(loginPath, KeyConstants.LOGIN_MOBILE_NUMBER)));
		ElementAction.TextBox(loginMobileNumber, readLocatorString(loginDetails, KeyConstants.MOBILE_NUMBER_TEXT));

		WebElement loginPassword = driver
				.findElement(By.id(readLocatorString(loginPath, KeyConstants.LOGIN_PASSWORD)));
		Assert.assertNotEquals(KeyConstants.CHANGE_RENEW_PASSWORD_BOTTON_TEXT, KeyConstants.PASSWORD_TEXT);
		ElementAction.TextBox(loginPassword,
				readLocatorString(passwordpath, KeyConstants.CHANGE_RENEW_PASSWORD_BOTTON_TEXT));

		WebElement loginButton = driver.findElement(By.id(readLocatorString(loginPath, KeyConstants.LOGIN_BUTTON)));
		ElementAction.clickButton(loginButton);

	}

}
