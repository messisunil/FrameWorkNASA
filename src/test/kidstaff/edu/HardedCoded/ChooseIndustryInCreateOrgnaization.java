package edu.HardedCoded;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class ChooseIndustryInCreateOrgnaization {
	public static void ChooseIndustryInCreateOrg() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
	
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.findElement(By.xpath("//div[contains(text(),'User Name')]/ancestor::form/descendant::input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//div[contains(text(),'Password')]/ancestor::form/descendant::input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(3000);
		driver.findElement(By.xpath("//td[@class='tabSelected']/following::td[@class='small']/descendant::a[contains(text(),'Organizations')]")).click();
		driver.findElement(By.xpath("//td[@class='moduleName']/following::td/descendant::img[@title='Create Organization...']")).click();	
		driver.findElement(By.xpath("//input[@name='accountname']")).sendKeys("suninfotech");
		WebElement industry = driver.findElement(By.xpath("//select[@name='industry']"));
		Select chooseIndustry = new Select(industry);
		chooseIndustry.selectByValue("Technology");
		WebElement type = driver.findElement(By.xpath("//select[@name='accounttype']"));
		Select typeList = new Select(type);
		typeList.selectByValue("Investor");
		driver.findElement(By.xpath("//div[@align='center']/input[@class='crmbutton small save'][1]")).click();
		Thread.sleep(4000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException {
		ChooseIndustryInCreateOrg();
	}
}
