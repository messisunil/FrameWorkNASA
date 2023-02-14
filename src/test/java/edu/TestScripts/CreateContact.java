package edu.TestScripts;



import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import genericLibraries.IConstantPath;
import genericLibraries.TabNames;

public class CreateContact extends BaseClass {
	@Test
	public void createContact() throws InterruptedException
	{

		SoftAssert soft = new SoftAssert();
		soft.assertTrue(driver.getTitle().contains("Home"));
		homePage.clickRequiredTab(web, TabNames.CONTACTS);
		soft.assertTrue(driver.getTitle().contains("Contacts"));
		contactsPage.clickCreateContacts();
		soft.assertTrue(createContactPage.verifyCreateNweContactPage().contains("Creating New Contact"));
		Map<String, String> map = excelUtil.readDataFromExcel("Create Contact", "ContactsTestData");
		System.out.println(map);
//		createContactPage.selectSalutation(web,map.get("First Name Salutation"));
//		String firstName = "jassy"+javaUtil.generateRandomNumber(100);
		String lastName = map.get("Last Name")+javaUtil.generateRandomNumber(100);
//		createContactPage.setFirstName(firstName);
		createContactPage.setLastName(lastName);
		createContactPage.clickSaveButton();
		soft.assertTrue(contactInfoPage.getInfoPageHeaderName().contains(lastName));
		String contactLastName = contactInfoPage.getContactLastName();
		soft.assertTrue(contactLastName.equals(lastName));
		contactInfoPage.goToContactpage();
		soft.assertTrue(contactsPage.getLastNameFromList().contains(contactLastName));
		if(contactsPage.getLastNameFromList().contains(contactLastName))
				excelUtil.setDataToExcel(IConstantPath.EXCEL_FILE_PATH, "Create Contact", "pass", "ContactsTestData");
			else
				excelUtil.setDataToExcel(IConstantPath.EXCEL_FILE_PATH, "Create Contact", "fail", "ContactsTestData");
		soft.assertAll();
	}	
}
