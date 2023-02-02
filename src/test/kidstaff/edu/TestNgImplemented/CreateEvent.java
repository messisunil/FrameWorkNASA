package edu.TestNgImplemented;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

public class CreateEvent extends BaseClass {
	@Test
	public void EventCreation() 
	{
		
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(driver.getTitle().contains("Home"));
		homePage.selectEvent(web);
		eventsPage.setSubject("Meeting");
		eventsPage.setStartDate("2023-02-10");
		eventsPage.setStartTime("14:30");
		eventsPage.setEndDate("2023-02-11");
		eventsPage.clickSave();
		soft.assertTrue(eventInfoPage.getEventInfoHeader().contains("Meeting"));
		soft.assertTrue(eventInfoPage.getEventName().contains("Meeting"));
		soft.assertAll();
		
	}
	
}
