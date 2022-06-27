package com.taxi.application.automation.utility;

import static com.taxi.application.automation.utility.LoadProperty.readLocatorString;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.taxi.application.automation.constants.FilePathConstants;
import com.taxi.application.automation.constants.KeyConstants;
import com.taxi.application.automation.testbase.TestBase;

public class LoginFunction extends TestBase {
	public static String loginDetails = FilePathConstants.LOGIN_DETAIL;
	public static String loginPath = FilePathConstants.LOGIN_PATH;
	public static String logoutPath = FilePathConstants.LOGOUT_PATH;


	public static void login() {
		
		WebElement loginMobileNumber = driver
				.findElement(By.id(readLocatorString(loginPath, KeyConstants.LOGIN_MOBILE_NUMBER)));
		ElementAction.TextBox(loginMobileNumber, readLocatorString(loginDetails, KeyConstants.MOBILE_NUMBER_TEXT));

		WebElement loginPassword = driver.findElement(By.id(readLocatorString(loginPath, KeyConstants.LOGIN_PASSWORD)));
		ElementAction.TextBox(loginPassword, readLocatorString(loginDetails, KeyConstants.PASSWORD_TEXT));

		WebElement loginButton = driver.findElement(By.id(readLocatorString(loginPath, KeyConstants.LOGIN_BUTTON)));
		ElementAction.clickButton(loginButton);
	
		

	}
	public static void logout() {
		
		WebElement logout = driver.findElement(By.xpath(readLocatorString(logoutPath, KeyConstants.LOGOUT)));
		ElementAction.clickButton(logout);
		
	}
}
