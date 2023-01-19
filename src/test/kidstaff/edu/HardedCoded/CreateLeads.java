package edu.HardedCoded;

import java.util.Map;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import genericLibraries.DataBaseUtility;
import genericLibraries.ExcelUtility;
import genericLibraries.IConstantPath;
import genericLibraries.JavaUtility;
import genericLibraries.PropertiesFileUtility;
import genericLibraries.WebDriverUtility;

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
		if(driver.getTitle().equals("vtiger CRM 5 - Commercial Open Source CRM"))
			System.out.println("Login page displayed");
		else
			System.out.println("Login page not displayed");
		driver.findElement(By.xpath("//div[contains(text(),'User Name')]/ancestor::form/descendant::input[@name='user_name']")).sendKeys(prop.fetchProperty("username"));
		driver.findElement(By.xpath("//div[contains(text(),'Password')]/ancestor::form/descendant::input[@name='user_password']")).sendKeys(prop.fetchProperty("password"));
		driver.findElement(By.id("submitButton")).click();
		//home page validation
		String title= driver.findElement(By.linkText("Home")).getText();
		if(title.equalsIgnoreCase("Home"))
			System.out.println("Home page displayed");
		else
			System.out.println("Home page not displayed");
		driver.findElement(By.xpath("//td[@class='tabUnSelected']/a[contains(text(),'Leads')]")).click();
		driver.findElement(By.xpath("//img[@alt='Create Lead...']")).click();
		excel.excelInitialization(IConstantPath.EXCEL_FILE_PATH);
		Map<String, String> map = excel.readDataFromExcel("Create Lead", "TestData");
		//driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("vijay");
		WebElement salutation = driver.findElement(By.xpath("//select[@name='salutationtype']"));
		driverutility.dropDown(map.get("First Name Salutation"),salutation);
		
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(map.get("Last Name"));
		driver.findElement(By.xpath("//input[@name='company']")).sendKeys(map.get("Company"));
		driver.findElement(By.xpath("//div[@align='center']/input[@class='crmbutton small save'][1]")).click();
		driver.findElement(By.xpath("//td[@class='dvtTabCache']/input[@name='Duplicate']")).click();
		driver.findElement(By.xpath("//input[@name='lastname']")).clear();
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys(map.get("New Last Name"));
		driver.findElement(By.xpath("//div[@align='center']/input[@class='crmbutton small save'][1]")).click();
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit();
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		leadCreation();
	}
}
