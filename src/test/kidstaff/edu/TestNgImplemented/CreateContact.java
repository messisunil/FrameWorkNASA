package edu.TestNgImplemented;



import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;

import PomClasses.ContactInformationPage;
import PomClasses.ContactsPage;
import PomClasses.CreateContactPage;
import PomClasses.HomePage;
import PomClasses.LoginPage;
import genericLibraries.ExcelUtility;
import genericLibraries.IConstantPath;
import genericLibraries.JavaUtility;
import genericLibraries.PropertiesFileUtility;
import genericLibraries.WebDriverUtility;

public class CreateContact {
	public static void createContact() throws InterruptedException
	{
		PropertiesFileUtility property = new PropertiesFileUtility();
		ExcelUtility excelUtil = new ExcelUtility();
		JavaUtility javaUtil = new JavaUtility();
		WebDriverUtility webDriverUtil = new WebDriverUtility();
		property.propertiesFileInitialization(IConstantPath.PROPERTY_FILE_PATH);
		excelUtil.excelInitialization(IConstantPath.EXCEL_FILE_PATH);
		long time  = Long.parseLong(property.fetchProperty("timeout"));
		WebDriver driver = webDriverUtil.openApplication(property.fetchProperty("browser"), property.fetchProperty("url"),time);
		
		//PomFileInitialization
		HomePage home = new HomePage(driver);
		LoginPage login = new LoginPage(driver);
		ContactsPage contactspage = new ContactsPage(driver);
		CreateContactPage createcontact = new CreateContactPage(driver);
		ContactInformationPage contactInfoPage = new ContactInformationPage(driver);
		if(driver.getTitle().contains("vtiger"))
			System.out.println("pass");
		else
			System.out.println("fail");
		login.loginToApplication(property.fetchProperty("username"), property.fetchProperty("password"));
		if(driver.getTitle().contains("Home"))
			System.out.println("pass");
		else
			System.out.println("fail");
		
		
//		WebDriver driver = new ChromeDriver();
//		driver.manage().window().maximize();
//		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
//		driver.findElement(By.xpath("//div[contains(text(),'User Name')]/ancestor::form/descendant::input[@name='user_name']")).sendKeys("admin");
//		driver.findElement(By.xpath("//div[contains(text(),'Password')]/ancestor::form/descendant::input[@name='user_password']")).sendKeys("admin");
//		driver.findElement(By.id("submitButton")).click();
//		Thread.sleep(3000);
		//creating new contact
		home.clickContacts();
//		driver.findElement(By.xpath("//td/a[contains(text(),'Contacts')]")).click();
//		Thread.sleep(2000);
		if(driver.getTitle().contains("Contacts"))
			System.out.println("pass");
		else
			System.out.println("fail");
		contactspage.clickCreateContacts();
//		driver.findElement(By.xpath("//img[contains(@alt,'Create Contact...')]")).click();
//		Thread.sleep(2000);
		if(createcontact.verifyCreateNweContactPage().contains("Creating new contact"))
			System.out.println("pass");
		else
			System.out.println("fail");
		Map<String, String> map = excelUtil.readDataFromExcel("Create Contact", "TestData");
		createcontact.selectSalutation(webDriverUtil,map.get("First Name Salutation"));
//		WebElement salutation = driver.findElement(By.xpath("//select[@name='salutationtype']"));
//		Select salutationlist = new Select(salutation);
//		salutationlist.selectByValue("Mr.");
		
		String firstName = "jassy"+javaUtil.generateRandomNumber(100);
		String lastName = map.get("Last Name")+javaUtil.generateRandomNumber(100);
		createcontact.setFirstName(firstName);
		createcontact.setLastName(lastName);
		createcontact.clickSaveButton();
//		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("sunil");
//		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("mudiker");
//		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
//		Thread.sleep(1000);
		if(contactInfoPage.getInfoPageHeaderName().contains(lastName))
			System.out.println("pass");
		else
			System.out.println("fail");
		if(contactInfoPage.getContactLastName().equals(lastName))
			System.out.println("pass");
		else
			System.out.println("fail");
		contactInfoPage.goToContactpage();
		if(contactspage.getLastNameFromList().contains(contactInfoPage.getContactLastName()))
			System.out.println("pass");
		else
			System.out.println("fail");
		home.signOutFromApplication(webDriverUtil);
		webDriverUtil.closeWindows();
//		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
//		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
//		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException {
		createContact();
	}
	
}
