package edu.HardedCoded;

import java.util.Iterator;
import java.util.List;
import java.util.Set;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class AddContactToExisitingOrganaization {
	public static void AddContact() throws InterruptedException {
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		driver.findElement(
				By.xpath("//div[contains(text(),'User Name')]/ancestor::form/descendant::input[@name='user_name']"))
				.sendKeys("admin");
		driver.findElement(
				By.xpath("//div[contains(text(),'Password')]/ancestor::form/descendant::input[@name='user_password']"))
				.sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		Thread.sleep(3000);
		// creating new contact
		driver.findElement(By.xpath("//td/a[contains(text(),'Contacts')]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[contains(@alt,'Create Contact...')]")).click();
		Thread.sleep(2000);
		WebElement salutation = driver.findElement(By.xpath("//select[@name='salutationtype']"));
		Select salutationlist = new Select(salutation);
		salutationlist.selectByValue("Mr.");
		driver.findElement(By.xpath("//input[@name='firstname']")).sendKeys("sunil");
		driver.findElement(By.xpath("//input[@name='lastname']")).sendKeys("mudiker");
		driver.findElement(By.xpath("//input[@name='account_name']/../img")).click();
		Thread.sleep(3000);
		Set<String> win = driver.getWindowHandles();
		Iterator<String> itr = win.iterator();
		String parent = itr.next();
		String dups = itr.next();
		driver.switchTo().window(dups);
		List<WebElement> companyList = driver
				.findElements(By.xpath("(//table[@class='small'])[3]/tbody/descendant::a"));
		for (int i = 0; i < companyList.size(); i++) {
			String company = companyList.get(i).getText();
			if (company.equalsIgnoreCase("microtechs")) {
				companyList.get(i).click();
				break;
			}
		}
		driver.switchTo().window(parent);
		driver.findElement(By.xpath("//div[@align='center']/input[@class='crmbutton small save'][1]")).click();
		Thread.sleep(2000);
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit();

	}

	public static void main(String[] args) throws InterruptedException {
		AddContact();
	}
}
