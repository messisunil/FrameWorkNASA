package edu.TestNgImplemented;

import java.util.Map;

import org.testng.annotations.Test;
import org.testng.asserts.SoftAssert;

import genericLibraries.BaseClass;
import genericLibraries.TabNames;

public class ChooseIndustryInCreateOrgnaization2 extends BaseClass {
	@Test
	public void ChooseIndustryInCreateOrg() 
	{

		SoftAssert soft = new SoftAssert();
		soft.assertTrue(driver.getTitle().contains("Home"));
		homePage.clickRequiredTab(web, TabNames.ORGANIZATIONS);
		soft.assertTrue(driver.getTitle().contains("Organizations"));
		orgPage.clickPlusButton();
		soft.assertTrue(createOrgPage.verifyHeader().contains("Creating New Organization"));
		Map<String, String> map = excelUtil.readDataFromExcel("Create Organization", "TestData");
		String name = map.get("Organization Name")+javaUtil.generateRandomNumber(100);
		createOrgPage.setOrganizationName(name);
		createOrgPage.selectIndustry(web, map.get("Industry"));
		createOrgPage.selectType(web, map.get("Type"));
		createOrgPage.clickSave();
		String orgName = orgInfoPage.orgNameFromList();
		soft.assertTrue(orgName.contains(name));
		orgInfoPage.goToOrganization();
		soft.assertTrue(orgPage.verifyOrgNameInOrganizationPage().contains(orgName));
		soft.assertAll();
		
	}
	
}
