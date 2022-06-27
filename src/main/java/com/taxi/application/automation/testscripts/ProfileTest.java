package com.taxi.application.automation.testscripts;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.taxi.application.automation.constants.FilePathConstants;
import com.taxi.application.automation.constants.KeyConstants;
import com.taxi.application.automation.testbase.TestBase;
import com.taxi.application.automation.utility.ElementAction;
import com.taxi.application.automation.utility.LoginFunction;
import com.taxi.application.automation.utility.UserRegistration;

import static com.taxi.application.automation.utility.LoadProperty.readLocatorString;

import java.time.Duration;

public class ProfileTest extends TestBase {

	public static String registrationTestPath = FilePathConstants.REGISTRATION_TEST_PATH;
	public static String menuPagePath = FilePathConstants.MENU_PAGE_PATH;
	public static String updateProfilePath = FilePathConstants.PROFILE_UPDATE_PATH;
	public static String updateProfileDetails = FilePathConstants.PROFILE_UPDATE_DETAILS;
	

	public static void updateProfileVerification() {
		
		setup();
		
		UserRegistration.createUserRegister();
		
        LoginFunction.login();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		WebElement menuSelect = driver
				.findElement(By.xpath(readLocatorString(menuPagePath, KeyConstants.MENU_SCROLL_BAR)));
		ElementAction.clickButton(menuSelect);

		WebElement profileButton = driver
				.findElement(By.xpath(readLocatorString(registrationTestPath, KeyConstants.PROFILE_BUTTON)));
		ElementAction.clickButton(profileButton);

		WebElement updateFirstNameTextBox = driver
				.findElement(By.id(readLocatorString(updateProfilePath, KeyConstants.UPDATE_FIRST_NAME_TEXT_BOX)));
		updateFirstNameTextBox.clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		ElementAction.TextBox(updateFirstNameTextBox,
				readLocatorString(updateProfileDetails, KeyConstants.UPDATE_FIRST_NAME_TEXT));
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		WebElement updateLastNameTextBox = driver
				.findElement(By.id(readLocatorString(updateProfilePath, KeyConstants.UPDATE_LAST_NAME_TEXT_BOX)));
		updateLastNameTextBox.clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		ElementAction.TextBox(updateLastNameTextBox,
				readLocatorString(updateProfileDetails, KeyConstants.UPDATE_LAST_NAME_TEXT));

		WebElement updateEmailTextBox = driver
				.findElement(By.id(readLocatorString(updateProfilePath, KeyConstants.UPDATE_EMAIL_TEXT_BOX)));
		updateEmailTextBox.clear();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));
		ElementAction.TextBox(updateEmailTextBox,
				readLocatorString(updateProfileDetails, KeyConstants.UPDATE_EMAIL_TEXT));

		WebElement saveButton = driver
				.findElement(By.id(readLocatorString(updateProfilePath, KeyConstants.SAVE_BUTTON)));
		ElementAction.clickButton(saveButton);

		WebElement okButton = driver.findElement(By.id(readLocatorString(updateProfilePath, KeyConstants.OK_BUTTON)));
		ElementAction.clickButton(okButton);

		WebElement backButton = driver.findElement(By.xpath(readLocatorString(menuPagePath, KeyConstants.BACK_BUTTON)));
		ElementAction.clickButton(backButton);

		WebElement menuSelectLogout = driver
				.findElement(By.xpath(readLocatorString(menuPagePath, KeyConstants.MENU_SCROLL_BAR)));
		ElementAction.clickButton(menuSelectLogout);

		LoginFunction.logout();
		
		LoginFunction.login();

		WebElement menuSelectLogoutVerify = driver
				.findElement(By.xpath(readLocatorString(menuPagePath, KeyConstants.MENU_SCROLL_BAR)));
		ElementAction.clickButton(menuSelectLogoutVerify);

		WebElement profileButtonVerify = driver
				.findElement(By.xpath(readLocatorString(registrationTestPath, KeyConstants.PROFILE_BUTTON)));
		ElementAction.clickButton(profileButtonVerify);

		WebElement verifyElement = driver
				.findElement(By.id(readLocatorString(updateProfilePath, KeyConstants.UPDATE_FIRST_NAME_TEXT_BOX)));
		String verifyUser = ElementAction.Element_text(verifyElement);
		Assert.assertEquals(verifyUser, "kutty");
		System.out.println("successfully verified");

		WebElement backButtonAgain = driver
				.findElement(By.xpath(readLocatorString(menuPagePath, KeyConstants.BACK_BUTTON)));
		ElementAction.clickButton(backButtonAgain);

		WebElement menuSelectLogoutAgain = driver
				.findElement(By.xpath(readLocatorString(menuPagePath, KeyConstants.MENU_SCROLL_BAR)));
		ElementAction.clickButton(menuSelectLogoutAgain);

		LoginFunction.logout();
	}
	public static void main(String[] args) {
	updateProfileVerification();
	}
}


