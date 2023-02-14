package edu.TestScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import genericLibraries.IConstantPath;

public class CreateEvent extends BaseClass {
	@Test
	public void EventCreation() 
	{
		
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(driver.getTitle().contains("Home"));
		homePage.selectEvent(web);
		Map<String, String> map = excelUtil.readDataFromExcel("Create New Event", "EventsTestData");
		eventsPage.setSubject(map.get("Subject"));//"Meeting"
		eventsPage.setStartDate(map.get("Start Date"));//"2023-02-10"
		//eventsPage.setStartTime("14:30");
		eventsPage.setEndDate(map.get("Due Date"));//"2023-02-11"
		eventsPage.clickSave();
		soft.assertTrue(eventInfoPage.getEventInfoHeader().contains(map.get("Subject")));
		soft.assertTrue(eventInfoPage.getEventName().contains(map.get("Subject")));
		if(eventInfoPage.getEventName().contains(map.get("Subject")))
			excelUtil.setDataToExcel(IConstantPath.EXCEL_FILE_PATH, "Create New Event", "pass", "EventsTestData");
		else
			excelUtil.setDataToExcel(IConstantPath.EXCEL_FILE_PATH, "Create New Event", "fail", "EventsTestData");
		soft.assertAll();
		
	}
	
}
