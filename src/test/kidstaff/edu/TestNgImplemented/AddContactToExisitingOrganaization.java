package edu.TestNgImplemented;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;

public class AddContactToExisitingOrganaization extends BaseClass {
	@Test
	public void AddContact() {
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(driver.getTitle().contains("Home"));
		homePage.clickContacts();
		soft.assertTrue(driver.getTitle().contains("Contacts"));
		contactsPage.clickCreateContacts();
		soft.assertTrue(createContactPage.verifyCreateNweContactPage().contains("Creating New Contact"));
		Map<String, String> map = excelUtil.readDataFromExcel("Create Contact", "TestData");
		createContactPage.selectSalutation(web,map.get("First Name Salutation"));
		String firstName = "jassy"+javaUtil.generateRandomNumber(100);
		String lastName = map.get("Last Name")+javaUtil.generateRandomNumber(100);
		createContactPage.setFirstName(firstName);
		createContactPage.setLastName(lastName);
		String parent_id = web.getParentWindowHandleID();
		createContactPage.clickAddOrganization();
		createContactPage.selectOrganization(web,"TYSS59");
		driver.switchTo().window(parent_id);
		createContactPage.clickSaveButton();
		soft.assertTrue(contactInfoPage.getInfoPageHeaderName().contains(lastName));
		String contactLastName = contactInfoPage.getContactLastName();
		soft.assertTrue(contactLastName.equals(lastName));
		contactInfoPage.goToContactpage();
		String listName = contactsPage.getLastNameFromList();
		soft.assertTrue(listName.contains(contactLastName));
		soft.assertAll();

	}

}
