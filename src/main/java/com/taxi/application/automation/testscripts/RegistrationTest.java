package com.taxi.application.automation.testscripts;

import static com.taxi.application.automation.utility.LoadProperty.readLocatorString;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.annotations.Test;

import com.taxi.application.automation.constants.FilePathConstants;
import com.taxi.application.automation.constants.KeyConstants;
import com.taxi.application.automation.testbase.TestBase;
import com.taxi.application.automation.utility.ElementAction;
import com.taxi.application.automation.utility.LoginFunction;
import com.taxi.application.automation.utility.UserRegistration;

public class RegistrationTest extends TestBase {

	public static String registrationTestPath = FilePathConstants.REGISTRATION_TEST_PATH;
	public static String menuPagePath = FilePathConstants.MENU_PAGE_PATH;
	public static String allowsbutton=FilePathConstants.REGISTRATION_PATH;
	
	@Test
	public static void verifyUserRegistration() {
		
		setup();
		UserRegistration.createUserRegister();
        LoginFunction.login();
		WebElement menuSelect = driver
				.findElement(By.xpath(readLocatorString(menuPagePath, KeyConstants.MENU_SCROLL_BAR)));
		ElementAction.clickButton(menuSelect);

//		WebElement profileButton = driver
//				.findElement(By.xpath(readLocatorString(registrationTestPath, KeyConstants.PROFILE_BUTTON)));
//		ElementAction.clickButton(profileButton);

		LoginFunction.logout();
		
//		WebElement verifyElement = driver
//				.findElement(By.id(readLocatorString(registrationTestPath, KeyConstants.GET_MOBILE_NUMBER)));
//		String verifyUser = ElementAction.Element_text(verifyElement);
//		Assert.assertEquals(verifyUser, readLocatorString(registrationTestPath, KeyConstants.VERIFY_REGISTRATION));
//
//		WebElement backButton = driver.findElement(By.xpath(readLocatorString(menuPagePath, KeyConstants.BACK_BUTTON)));
//		ElementAction.clickButton(backButton);
//
//		ElementAction.clickButton(menuSelect);

		driver.quit();
	}

	
	}
