package edu.listenerImp;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import genericLibraries.IConstantPath;


public class CreateOrganization  extends BaseClass{
	@Test
	public void createOrg() 
	{
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(homePage.verifyHomePage().equalsIgnoreCase("Home"));
		homePage.clickOrganization();
		soft.assertTrue(orgPage.verifyOrganizationPageName().equals("Organizations"));
		orgPage.clickPlusButton();
		soft.assertTrue(createOrgPage.verifyHeader().equals("Creating New Organization"));
		Map<String, String> map = excelUtil.readDataFromExcel("Create Organization", "TestData");
		String orgname = map.get("Organization Name")+javaUtil.generateRandomNumber(100);
		createOrgPage.setOrganizationName(orgname);
		createOrgPage.clickSave();
		soft.assertTrue(orgInfoPage.veryHeaderInfo().contains(orgname));
		String orgFromList = orgInfoPage.orgNameFromList();
		soft.assertTrue(orgFromList.contains(orgname));
		orgInfoPage.goToOrganization();
		soft.assertTrue(orgPage.verifyOrgNameInOrganizationPage().equals(orgFromList));
		
		if(orgPage.verifyOrgNameInOrganizationPage().equals(orgFromList))
			excelUtil.setDataToExcel(IConstantPath.EXCEL_FILE_PATH, "Create Organization", "pass", "TestData");
		else
			excelUtil.setDataToExcel(IConstantPath.EXCEL_FILE_PATH, "Create Organization", "fail", "TestData");
		soft.assertAll();
	}
	
}
