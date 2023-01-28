package edu.HardedCoded;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import PomClasses.CreateOrganizationPage;
import PomClasses.HomePage;
import PomClasses.LoginPage;
import PomClasses.OrganizationInformationPage;
import PomClasses.OrganizationPage;
import genericLibraries.DataBaseUtility;
import genericLibraries.ExcelUtility;
import genericLibraries.IConstantPath;
import genericLibraries.JavaUtility;
import genericLibraries.PropertiesFileUtility;
import genericLibraries.WebDriverUtility;


public class CreateOrganization {
	
	public static void createOrg() 
	{
//		WebDriver driver = new ChromeDriver();
//		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
//		driver.manage().window().maximize();
//		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		//login page validation
		
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
	
		if(driver.getTitle().equals("vtiger CRM 5 - Commercial Open Source CRM"))
			System.out.println("pass");
		else
			System.out.println("fail");
		

		driver.findElement(By.xpath("//div[contains(text(),'User Name')]/ancestor::form/descendant::input[@name='user_name']")).sendKeys(prop.fetchProperty("username"));
		driver.findElement(By.xpath("//div[contains(text(),'Password')]/ancestor::form/descendant::input[@name='user_password']")).sendKeys(prop.fetchProperty("password"));
		driver.findElement(By.id("submitButton")).click();
		//home page validation
		String title= driver.findElement(By.linkText("Home")).getText();
		if(title.equalsIgnoreCase("Home"))
			System.out.println("pass");
		else
			System.out.println("fail");
	
		driver.findElement(By.xpath("//td[@class='tabSelected']/following::td[@class='small']/descendant::a[contains(text(),'Organizations')]")).click();
	
		String orgpage = driver.findElement(By.xpath("//a[@class='hdrLink']")).getText();
		if(orgpage.equals("Organizations"))
			System.out.println("pass");
		else
			System.out.println("fail");
	
		driver.findElement(By.xpath("//td[@class='moduleName']/following::td/descendant::img[@title='Create Organization...']")).click();
		String headerName =driver.findElement(By.xpath("//span[@class='lvtHeaderText']")).getText();
		
		if(headerName.equals("Creating New Organization"))
			System.out.println("pass");
		else
			System.out.println("fail");
		excel.excelInitialization(IConstantPath.EXCEL_FILE_PATH);
		
		Map<String, String> map = excel.readDataFromExcel("Create Organization", "TestData");
		String orgname = map.get("Organization Name")+javautil.generateRandomNumber(100);
		
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys(orgname);
	
		driver.findElement(By.xpath("//div[@align='center']/input[@class='crmbutton small save'][1]")).click();
		
		String orgInfoHeaderName = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
		if(orgInfoHeaderName.contains(orgname))
			System.out.println("pass");
		else
			System.out.println("fail");
		
		String newOrgName = driver.findElement(By.xpath("//span[@id='dtlview_Organization Name']")).getText();
		if(newOrgName.equals(orgname))
			System.out.println("pass");
		else
			System.out.println("fail");

		driver.findElement(By.xpath("//a[text()='Organizations']")).click();
		
		String orgNameInList = driver.findElement(By.xpath("//table[@class='lvt small']/descendant::tr[last()]/td[3]/a")).getText();
		if(orgNameInList.equals(newOrgName))
			System.out.println("pass");
		else
			System.out.println("fail");
		
		WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
		driverutility.mouseHover(ele);
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit(); 
		
		
	}
	
	public static void main(String[] args)  {
		createOrg();
	}
}
