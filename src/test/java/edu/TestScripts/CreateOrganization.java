package edu.TestScripts;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import genericLibraries.IConstantPath;
import genericLibraries.TabNames;


public class CreateOrganization  extends BaseClass{
	@Test
	public void createOrg() 
	{
		SoftAssert soft = new SoftAssert();
		soft.assertTrue(homePage.verifyHomePage().equalsIgnoreCase("Home"));
		homePage.clickRequiredTab(web, TabNames.ORGANIZATIONS);
		soft.assertTrue(orgPage.verifyOrganizationPageName().equals("Organizations"));
		orgPage.clickPlusButton();
		soft.assertTrue(createOrgPage.verifyHeader().equals("Creating New Organization"));
		Map<String, String> map = excelUtil.readDataFromExcel("Create Organization", "OrganizationsTestData");
		System.out.println(map);
		String orgname = map.get("Organization Name")+javaUtil.generateRandomNumber(100);
		//String orgname = "Microsoft";
		createOrgPage.setOrganizationName(orgname);
		createOrgPage.clickSave();
		soft.assertTrue(orgInfoPage.veryHeaderInfo().contains(orgname));
		String orgFromList = orgInfoPage.orgNameFromList();
		soft.assertTrue(orgFromList.contains(orgname));
		orgInfoPage.goToOrganization();
		soft.assertTrue(orgPage.verifyOrgNameInOrganizationPage().equals(orgFromList));
		
		if(orgPage.verifyOrgNameInOrganizationPage().equals(orgFromList))
			excelUtil.setDataToExcel(IConstantPath.EXCEL_FILE_PATH, "Create Organization", "pass", "OrganizationsTestData");
		else
			excelUtil.setDataToExcel(IConstantPath.EXCEL_FILE_PATH, "Create Organization", "fail", "OrganizationsTestData");
		soft.assertAll();
	}
	
}
