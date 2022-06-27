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

public class HelpPageTest extends TestBase {

	public static String helppath = FilePathConstants.HELP_PATH;

	@Test
	public static void helppage() {
		setup();

		UserRegistration.createUserRegister();
		LoginFunction.login();

		WebElement menuSelect = driver.findElement(By.xpath(readLocatorString(helppath, KeyConstants.MENU_SCROLL_BAR)));
		ElementAction.clickButton(menuSelect);
		WebElement helpButton = driver.findElement(By.xpath(readLocatorString(helppath, KeyConstants.HELP_BUTTON)));
		Assert.assertTrue(helpButton.isDisplayed());
		helpButton.click();

		WebElement callSuppportButton = driver
				.findElement(By.id(readLocatorString(helppath, KeyConstants.CALL_SUPPPORT_BUTTON)));
		Assert.assertTrue(callSuppportButton.isDisplayed());
		callSuppportButton.click();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		WebElement verifymessage = driver.findElement(By.id(readLocatorString(helppath, KeyConstants.VERIFY_MESSAGE)));
		String POPMessage = verifymessage.getText();
		Assert.assertEquals(POPMessage.contains(
				"Successfully sent an email of your help request, One of our customer care executive will contact you on your registered mobile number."),
				true);
		Assert.assertEquals(POPMessage.contains("Failed to send an email of your help request, Please try again!"),
				false);
		System.out.println(POPMessage);

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(3));

		WebElement verifySupport = driver.findElement(By.id(readLocatorString(helppath, KeyConstants.VERIFY_SUPPORT)));
		Assert.assertTrue(verifySupport.isDisplayed());
		verifySupport.click();

		WebElement arrowbotton = driver.findElement(By.xpath(readLocatorString(helppath, KeyConstants.ARROW_BOTTON)));
		arrowbotton.click();

		WebElement meunbottonagain = driver
				.findElement(By.xpath(readLocatorString(helppath, KeyConstants.MENU_SCROLL_BAR)));
		ElementAction.clickButton(meunbottonagain);

		LoginFunction.logout();
		driver.quit();
	}
}
