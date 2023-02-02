package edu.TestNgImplemented;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import genericLibraries.IConstantPath;


public class CreateLeads extends BaseClass {
	@Test
	public void leadCreation() 
	{
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(driver.getTitle().contains("Home"));
		homePage.clickLeads();
		soft.assertTrue(driver.getTitle().contains("Leads"));
		leadsPage.clickCreateLeads();
		soft.assertTrue(createLeadsPage.getCreateLeadsHeader().contains("New"));
		Map<String, String> map = excelUtil.readDataFromExcel("Create Lead", "TestData");
		createLeadsPage.selectSalutation(web,map.get("First Name Salutation"));
		String lastName = map.get("Last Name")+ javaUtil.generateRandomNumber(100);
		String companyName = map.get("Company")+ javaUtil.generateRandomNumber(100);
		createLeadsPage.setLastName(lastName);
		createLeadsPage.setCompany(companyName);
		createLeadsPage.clickSave();
		soft.assertTrue(leadInfoPage.getLeadInfoHeaderText().contains(lastName));
		leadInfoPage.clickDuplicateButton();
		soft.assertTrue(leadDuplicationPage.getDupluicatePageHeaderText().contains(lastName));
		leadDuplicationPage.clearLastName();
		String newLastName = map.get("New Last Name")+javaUtil.generateRandomNumber(100);
		leadDuplicationPage.setLastName(newLastName);
		leadDuplicationPage.clickSaveButton();
		leadInfoPage.goToLeadsPage();
		soft.assertTrue(leadsPage.getLastNameFromList().contains(newLastName));
		if(leadsPage.getLastNameFromList().contains(newLastName))
			excelUtil.setDataToExcel(IConstantPath.EXCEL_FILE_PATH, "Create Lead", "pass", "TestData");
		else
			excelUtil.setDataToExcel(IConstantPath.EXCEL_FILE_PATH, "Create Lead", "fail", "TestData");
		soft.assertAll();
		
	}
	
}
