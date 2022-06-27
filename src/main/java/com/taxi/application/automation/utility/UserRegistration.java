package com.taxi.application.automation.utility;

import static com.taxi.application.automation.utility.LoadProperty.readLocatorString;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.taxi.application.automation.constants.FilePathConstants;
import com.taxi.application.automation.constants.KeyConstants;
import com.taxi.application.automation.testbase.TestBase;

public  class UserRegistration extends TestBase {
	public static String registrationPath = FilePathConstants.REGISTRATION_PATH;
	public static String registrationDetails = FilePathConstants.REGISTRATION_DETAIL;

	public static void createUserRegister() {
		
		WebElement newRegistration = driver
				.findElement(By.id(readLocatorString(registrationPath, KeyConstants.NEW_REGISTRATION)));
		ElementAction.clickButton(newRegistration);

		WebElement firstNametextBox = driver
				.findElement(By.id(readLocatorString(registrationPath, KeyConstants.FIRST_NAME_TEXT_BOX)));
		ElementAction.TextBox(firstNametextBox, readLocatorString(registrationDetails, KeyConstants.FIRST_NAME_TEXT));

		WebElement lastNameTextBox = driver
				.findElement(By.id(readLocatorString(registrationPath, KeyConstants.LAST_NAME_TEXT_BOX)));
		ElementAction.TextBox(lastNameTextBox, readLocatorString(registrationDetails, KeyConstants.LAST_NAME_TEXT));

		WebElement mobileNumberTextBox = driver
				.findElement(By.id(readLocatorString(registrationPath, KeyConstants.MOBILE_NUMBER_TEXT_BOX)));
		ElementAction.TextBox(mobileNumberTextBox,
				readLocatorString(registrationDetails, KeyConstants.MOBILE_NUMBER_TEXT));

		WebElement emailTextBox = driver
				.findElement(By.id(readLocatorString(registrationPath, KeyConstants.EMAIL_ADDRESS_TEXTBOX)));
		ElementAction.TextBox(emailTextBox, readLocatorString(registrationDetails, KeyConstants.EMAIL_ADDRESS_TEXT));

		WebElement passwordTextBox = driver
				.findElement(By.id(readLocatorString(registrationPath, KeyConstants.PASSWORD_TEXT_BOX)));
		ElementAction.TextBox(passwordTextBox, readLocatorString(registrationDetails, KeyConstants.PASSWORD_TEXT));

		WebElement confirmPasswordTextBox = driver
				.findElement(By.id(readLocatorString(registrationPath, KeyConstants.CONFIRM_PASSWORD_TEXT_BOX)));
		ElementAction.TextBox(confirmPasswordTextBox,
				readLocatorString(registrationDetails, KeyConstants.CONFIRM_PASSWORD_TEXT));

		WebElement registerButton = driver
				.findElement(By.id(readLocatorString(registrationPath, KeyConstants.REGISTER_BUTTON)));
		ElementAction.clickButton(registerButton);
		
		WebElement popmessage = driver.findElement(By.id(readLocatorString(registrationPath,KeyConstants.CONFIRM_MESSAGE)));
		String POPMessage =  popmessage.getText();
		System.out.println(POPMessage);

		WebElement okButton = driver.findElement(By.id(readLocatorString(registrationPath, KeyConstants.OK_BUTTON)));
		ElementAction.clickButton(okButton);

	}

}
