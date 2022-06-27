package com.taxi.application.automation.utility;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

import com.taxi.application.automation.testbase.TestBase;

public class TimeAndDate extends TestBase {

	public static String currentTimeAndDate() {
		
		DateFormat dateFormat = new SimpleDateFormat("dd/MM/yyyy HH:mm");

		Date dates =new Date(System.currentTimeMillis() + TimeUnit.MINUTES.toMillis(5));

		String date1 = dateFormat.format(dates);

		System.out.println (date1);
		
		return date1;
		
	
		 
		

	}

	public static void main(String[] args) {
		currentTimeAndDate();
	}

	

}
