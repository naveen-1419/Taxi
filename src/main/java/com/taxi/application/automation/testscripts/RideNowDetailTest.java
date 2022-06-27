package com.taxi.application.automation.testscripts;

import static com.taxi.application.automation.utility.LoadProperty.readLocatorString;

import java.io.IOException;
import java.sql.Time;
import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.time.Duration;
import java.time.format.DateTimeFormatter;
import java.util.Date;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import org.testng.Assert;
import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import com.taxi.application.automation.constants.FilePathConstants;
import com.taxi.application.automation.constants.KeyConstants;
import com.taxi.application.automation.testbase.TestBase;
import com.taxi.application.automation.utility.ElementAction;
import com.taxi.application.automation.utility.LoginFunction;
import com.taxi.application.automation.utility.TimeAndDate;
import com.taxi.application.automation.utility.UserRegistration;


public class RideNowDetailTest extends TestBase {

	public static String menuPagePath = FilePathConstants.MENU_PAGE_PATH;
	public static String rideNowPath = FilePathConstants.RIDE_NOW_PATH;
	public static String rideNowDetails = FilePathConstants.RIDE_NOW_DETAILS;

	/**
	 * 
	 * @throws IOException
	 */

	public static void rideNowdetailsTest() throws IOException {

		setup();

		UserRegistration.createUserRegister();

		LoginFunction.login();

		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));

		WebElement pickupTextBox = driver
				.findElement(By.id(readLocatorString(rideNowPath, KeyConstants.PICK_UP_TEXT_BOX)));
		ElementAction.TextBox(pickupTextBox, readLocatorString(rideNowDetails, KeyConstants.PICK_UP_TEXT));

		WebElement dropTextBox = driver.findElement(By.id(readLocatorString(rideNowPath, KeyConstants.DROP_TEXT_BOX)));
		ElementAction.TextBox(dropTextBox, readLocatorString(rideNowDetails, KeyConstants.DROP_TEXT));

		WebElement rideNowButton = driver
				.findElement(By.id(readLocatorString(rideNowPath, KeyConstants.RIDE_NOW_BUTTON)));
		ElementAction.clickButton(rideNowButton);

		WebElement okButton = driver.findElement(By.id(readLocatorString(rideNowPath, KeyConstants.OK_BUTTON)));
		ElementAction.clickButton(okButton);

		WebElement menuSelect = driver
				.findElement(By.xpath(readLocatorString(menuPagePath, KeyConstants.MENU_SCROLL_BAR)));
		ElementAction.clickButton(menuSelect);

		WebElement yourTripButton = driver
				.findElement(By.xpath(readLocatorString(rideNowPath, KeyConstants.YOUR_TRIP_BUTTON)));
		ElementAction.clickButton(yourTripButton);
		
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(2));
		
		WebElement verifytext = driver
				.findElement(By.xpath(readLocatorString(rideNowPath, KeyConstants.VERIFY_TRIP_BUTTON)));

		String verify = ElementAction.Element_text(verifytext);

		Assert.assertEquals(verify.contains(KeyConstants.PICK_UP_TEXT), verify.contains(KeyConstants.DROP_TEXT));
		
		
		System.out.println(verify);
		System.out.println(
				"Your Pickup Test And Drop Text :" + readLocatorString(rideNowDetails, KeyConstants.PICK_UP_TEXT) + " "
						+ readLocatorString(rideNowDetails, KeyConstants.DROP_TEXT));
		
        
	
	Assert.assertEquals(verify.contains(TimeAndDate.currentTimeAndDate()),false);
		
		
		
		
//
//		SoftAssert assert1 = new SoftAssert();
//		assert1.assertNotEquals(verify.contains(KeyConstants.PICK_UP_TEXT), verify.contains(KeyConstants.DROP_TEXT));
//
//		System.out.println(
//				"Your Pickup Test And Drop Text :" + readLocatorString(rideNowDetails, KeyConstants.PICK_UP_TEXT) + " "
//						+ readLocatorString(rideNowDetails, KeyConstants.DROP_TEXT));
//		System.err.println("Your TO and From Not Matched ");

	}

	public static void main(String[] args)  {
		try {
			rideNowdetailsTest();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}

