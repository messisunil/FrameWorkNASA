package genericLibraries;

import org.openqa.selenium.WebDriver;
import org.testng.Assert;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import PomClasses.ContactInformationPage;
import PomClasses.ContactsPage;
import PomClasses.CreateContactPage;
import PomClasses.CreateLeadsPage;
import PomClasses.CreateOrganizationPage;
import PomClasses.EventInformationPage;
import PomClasses.EventsPage;
import PomClasses.HomePage;
import PomClasses.LeadDuplicationPage;
import PomClasses.LeadInformationPage;
import PomClasses.LeadsPage;
import PomClasses.LoginPage;
import PomClasses.OrganizationInformationPage;
import PomClasses.OrganizationPage;

public class BaseClass {
	protected ExcelUtility excelUtil;
	protected JavaUtility javaUtil;
	protected static JavaUtility sjavaUtil;
	protected ListenersImplementation listenersImp;
	protected PropertiesFileUtility property;
	protected RetryToListenersImplementation retryToListeners;
	protected WebDriverUtility web;
	protected WebDriver driver;
	protected static WebDriver sdriver;
	
	protected HomePage homePage;
	protected ContactInformationPage contactInfoPage;
	protected ContactsPage contactsPage ; 
	protected CreateContactPage createContactPage;
	protected CreateLeadsPage createLeadsPage;
	protected CreateOrganizationPage createOrgPage;
	protected LeadDuplicationPage leadDuplicationPage;
	protected LeadInformationPage leadInfoPage;
	protected LeadsPage leadsPage;
	protected LoginPage loginPage;
	protected OrganizationInformationPage orgInfoPage;
	protected OrganizationPage orgPage;
	protected EventsPage eventsPage;
	protected EventInformationPage eventInfoPage;
	
//	@BeforeSuite

//	@BeforeTest

	@BeforeClass
	public void classSetup()
	{
		excelUtil = new ExcelUtility();
		javaUtil = new JavaUtility();
		sjavaUtil = javaUtil;
		listenersImp = new ListenersImplementation();
		property = new PropertiesFileUtility();
		retryToListeners = new RetryToListenersImplementation();
		web = new WebDriverUtility();
		
		property.propertiesFileInitialization(IConstantPath.PROPERTY_FILE_PATH);
		excelUtil.excelInitialization(IConstantPath.EXCEL_FILE_PATH);
		long time = Long.parseLong(property.fetchProperty("timeout"));
		driver = web.openApplication(property.fetchProperty("browser"),property.fetchProperty("url"), time);
		sdriver = driver;
		Assert.assertTrue(driver.getTitle().contains("vtiger"));
	}
	
	@BeforeMethod
	public void methodSetup()
	{
		homePage = new HomePage(driver);
		contactInfoPage = new ContactInformationPage(driver);
		contactsPage = new ContactsPage(driver);
		createContactPage = new CreateContactPage(driver);
		createLeadsPage = new CreateLeadsPage(driver);
		createOrgPage = new CreateOrganizationPage(driver);
		leadDuplicationPage = new LeadDuplicationPage(driver);
		leadInfoPage = new LeadInformationPage(driver);
		leadsPage = new LeadsPage(driver);
		loginPage = new LoginPage(driver);
		orgInfoPage=new OrganizationInformationPage(driver);
		orgPage = new OrganizationPage(driver);
		eventsPage = new EventsPage(driver);
		eventInfoPage = new EventInformationPage(driver);
		
		
		loginPage.loginToApplication(property.fetchProperty("username"), property.fetchProperty("password"));	
	}
		
	@AfterMethod
	public void methodTeardown()
	{
		homePage.signOutFromApplication(web);
		excelUtil.closeTheWorkbook();
	}
	
	@AfterClass
	public void classTeardown()
	{
		web.closeWindows();
	}
	
//	@AfterTest

//	@AfterSuite

}
