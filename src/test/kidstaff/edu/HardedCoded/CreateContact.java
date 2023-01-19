package edu.HardedCoded;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateContact {
	public static void createContact() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.findElement(By.xpath("//div[contains(text(),'User Name')]/ancestor::form/descendant::input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//div[contains(text(),'Password')]/ancestor::form/descendant::input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(3000);
		//creating new contact
		driver.findElement(By.xpath("//td/a[contains(text(),'Contacts')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[contains(@alt,'Create Contact...')]")).click();
		Thread.sleep(2000);
		WebElement salutation = driver.findElement(By.xpath("//select[@name='salutationtype']"));
		Select salutationlist = new Select(salutation);
		salutationlist.selectByValue("Mr.");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("sunil");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("mudiker");
		driver.findElement(By.xpath("//input[@class='crmButton small save']")).click();
		Thread.sleep(1000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit();
	}
	
	public static void main(String[] args) throws InterruptedException {
		createContact();
	}
	
}
