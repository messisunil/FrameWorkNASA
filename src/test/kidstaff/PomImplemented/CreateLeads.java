package PomImplemented;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PomClasses.CreateLeadsPage;
import PomClasses.HomePage;
import PomClasses.LeadDuplicationPage;
import PomClasses.LeadInformationPage;
import PomClasses.LeadsPage;
import PomClasses.LoginPage;
import genericLibraries.DataBaseUtility;
import genericLibraries.ExcelUtility;
import genericLibraries.IConstantPath;
import genericLibraries.JavaUtility;
import genericLibraries.PropertiesFileUtility;
import genericLibraries.WebDriverUtility;
import io.opentelemetry.exporter.logging.SystemOutLogRecordExporter;

public class CreateLeads {
	public static void leadCreation() throws InterruptedException
	{
//		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		
//		driver.manage().window().maximize();
//		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
//		//login page validation
		PropertiesFileUtility prop = new PropertiesFileUtility();
		WebDriverUtility driverutility = new WebDriverUtility();
		DataBaseUtility database = new DataBaseUtility();
		JavaUtility javautil = new JavaUtility();
		ExcelUtility excel = new ExcelUtility();
		
		prop.propertiesFileInitialization(IConstantPath.PROPERTY_FILE_PATH);
		String browser = prop.fetchProperty("browser");
		String url = prop.fetchProperty("url");
		long time = Long.parseLong(prop.fetchProperty("timeout"));
		
		WebDriver driver = driverutility.openApplication(browser, url, time);
		LoginPage login = new LoginPage(driver);
		HomePage home = new HomePage(driver);
		LeadsPage leadspage = new LeadsPage(driver);
		CreateLeadsPage createLeads = new CreateLeadsPage(driver);
		LeadInformationPage leadsInfo = new LeadInformationPage(driver);
		LeadDuplicationPage leadDuplication = new LeadDuplicationPage(driver);
		
		
		if(driver.getTitle().equals("vtiger CRM 5 - Commercial Open Source CRM"))
			System.out.println("pass");
		else
			System.out.println("fail");
		login.loginToApplication(prop.fetchProperty("username"), prop.fetchProperty("password"));
//		driver.findElement(By.xpath("//div[contains(text(),'User Name')]/ancestor::form/descendant::input[@name='user_name']")).sendKeys(prop.fetchProperty("username"));
//		driver.findElement(By.xpath("//div[contains(text(),'Password')]/ancestor::form/descendant::input[@name='user_password']")).sendKeys(prop.fetchProperty("password"));
//		driver.findElement(By.id("submitButton")).click();
		//home page validation
		
		if(driver.getTitle().contains("Home"))
			System.out.println("pass");
		else
			System.out.println("fail");
		home.clickLeads();
//		driver.findElement(By.xpath("//td[@class='tabUnSelected']/a[contains(text(),'Leads')]")).click();
		if(driver.getTitle().contains("Leads"))
			System.out.println("pass");
		else
			System.out.println("fail");
		leadspage.clickCreateLeads();
		if(createLeads.getCreateLeadsHeader().contains("New"))
			System.out.println("pass");
		else
			System.out.println("fail");
//		driver.findElement(By.xpath("//img[@alt='Create Lead...']")).click();
		excel.excelInitialization(IConstantPath.EXCEL_FILE_PATH);
		Map<String, String> map = excel.readDataFromExcel("Create Lead", "TestData");
		//driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("vijay");
		createLeads.selectSalutation(driverutility,map.get("First Name Salutation"));
		
//		WebElement salutation = driver.findElement(By.xpath("//select[@name='salutationtype']"));
//		driverutility.dropDown(map.get("First Name Salutation"),salutation);
		String lastName = map.get("Last Name")+ javautil.generateRandomNumber(100);
		String companyName = map.get("Company")+ javautil.generateRandomNumber(100);
		createLeads.setLastName(lastName);
		createLeads.setCompany(companyName);
		createLeads.clickSave();
//		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(map.get("Last Name"));
//		driver.findElement(By.xpath("//input[@name='company']")).sendKeys(map.get("Company"));
//		driver.findElement(By.xpath("//div[@align='center']/input[@class='crmbutton small save'][1]")).click();
		if(leadsInfo.getLeadInfoHeaderText().contains(lastName))
			System.out.println("pass");
		else
			System.out.println("fail");
		leadsInfo.clickDuplicateButton();
//		driver.findElement(By.xpath("//td[@class='dvtTabCache']/input[@name='Duplicate']")).click();
		if(leadDuplication.getDupluicatePageHeaderText().contains(lastName))
			System.out.println("pass");
		else
			System.out.println("fail");
		leadDuplication.clearLastName();
		String newLastName = map.get("New Last Name")+javautil.generateRandomNumber(100);
		leadDuplication.setLastName(newLastName);
		leadDuplication.clickSaveButton();
		if(leadsInfo.getLeadInfoHeaderText().contains(newLastName))
			System.out.println("pass");
		else
			System.out.println("fail");
		
		leadsInfo.goToLeadsPage();
		if(leadspage.getLastNameFromList().contains(newLastName))
			System.out.println("pass");
		else
			System.out.println("fail");
		home.signOutFromApplication(driverutility);
		driverutility.closeWindows();
//		driver.findElement(By.xpath("//input[@name='lastname']")).clear();
//		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(map.get("New Last Name"));
//		driver.findElement(By.xpath("//div[@align='center']/input[@class='crmbutton small save'][1]")).click();
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
//		driver.quit();		
	}
	
	public static void main(String[] args) throws InterruptedException {
		leadCreation();
	}
}
