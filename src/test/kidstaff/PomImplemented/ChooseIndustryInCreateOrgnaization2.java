package PomImplemented;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;

import PomClasses.CreateOrganizationPage;
import PomClasses.HomePage;
import PomClasses.LoginPage;
import PomClasses.OrganizationInformationPage;
import PomClasses.OrganizationPage;
import genericLibraries.ExcelUtility;
import genericLibraries.IConstantPath;
import genericLibraries.JavaUtility;
import genericLibraries.PropertiesFileUtility;
import genericLibraries.TabNames;
import genericLibraries.WebDriverUtility;

public class ChooseIndustryInCreateOrgnaization2 {
	public static void ChooseIndustryInCreateOrg() throws InterruptedException
	{
		ExcelUtility excel = new ExcelUtility();
		JavaUtility jutil = new JavaUtility();
		PropertiesFileUtility property = new PropertiesFileUtility();
		WebDriverUtility driverUtil = new WebDriverUtility();
		property.propertiesFileInitialization(IConstantPath.PROPERTY_FILE_PATH);
		excel.excelInitialization(IConstantPath.EXCEL_FILE_PATH);
		String browser = property.fetchProperty("browser");
		String url = property.fetchProperty("url");
		long time = Long.parseLong(property.fetchProperty("time"));
		WebDriver driver =driverUtil.openApplication(browser, url, time);
		if(driver.getTitle().contains("vtiger CRM 5"))
			System.out.println("pass");
		else
			System.out.println("fail");
		
		LoginPage login = new LoginPage(driver);
		HomePage home = new HomePage(driver);
		CreateOrganizationPage createOrg = new CreateOrganizationPage(driver);
		OrganizationInformationPage orgInfo = new OrganizationInformationPage(driver);
		OrganizationPage orgpage = new OrganizationPage(driver);
//		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//	
//		driver.manage().window().maximize();
//		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		login.loginToApplication(property.fetchProperty("username"), property.fetchProperty("password"));
//		driver.findElement(By.xpath("//div[contains(text(),'User Name')]/ancestor::form/descendant::input[@name='user_name']")).sendKeys(property.fetchProperty("username"));
//		driver.findElement(By.xpath("//div[contains(text(),'Password')]/ancestor::form/descendant::input[@name='user_password']")).sendKeys(property.fetchProperty("password"));
//		driver.findElement(By.id("submitButton")).click();
		if(driver.getTitle().contains("Home"))
			System.out.println("pass");
		else
			System.out.println("fail");
		home.clickRequiredTab(driverUtil, TabNames.ORGANIZATIONS);
//		driver.findElement(By.xpath("//td[@class='tabSelected']/following::td[@class='small']/descendant::a[contains(text(),'Organizations')]")).click();
		if(driver.getTitle().contains("Organizations"))
			System.out.println("pass");
		else
			System.out.println("fail");
		orgpage.clickPlusButton();
//		driver.findElement(By.xpath("//td[@class='moduleName']/following::td/descendant::img[@title='Create Organization...']")).click();
		
		if(createOrg.verifyHeader().contains("Creating New Organization"))
			System.out.println("pass");
		else
			System.out.println("fail");
		excel.excelInitialization(IConstantPath.EXCEL_FILE_PATH);
		
		Map<String, String> map = excel.readDataFromExcel("Create Organization", "TestData");
		String name = map.get("Organization Name")+jutil.generateRandomNumber(100);
		createOrg.setOrganizationName(name);
//		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(name);
		/////////////
		createOrg.selectIndustry(driverUtil, "Technology");
//		WebElement industry = driver.findElement(By.xpath("//select[@name='industry']"));
//		Select chooseIndustry = new Select(industry);
//		chooseIndustry.selectByValue("Technology");
		createOrg.selectType(driverUtil, "Investor");
//		WebElement type = driver.findElement(By.xpath("//select[@name='accounttype']"));
//		Select typeList = new Select(type);
//		typeList.selectByValue("Investor");
		createOrg.clickSave();
//		driver.findElement(By.xpath("//div[@align='center']/input[@class='crmbutton small save'][1]")).click();
		/////////////////////
		String orgName = orgInfo.orgNameFromList();
		if(orgName.contains(name))
			System.out.println("pass");
		else
			System.out.println("fail");
		orgInfo.goToOrganization();
		if(orgpage.verifyOrgNameInOrganizationPage().contains(orgName))
			System.out.println("pass");
		else
			System.out.println("fail");
		home.signOutFromApplication(driverUtil);
		driverUtil.closeWindows();
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
//		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException {
		ChooseIndustryInCreateOrg();
	}
}
