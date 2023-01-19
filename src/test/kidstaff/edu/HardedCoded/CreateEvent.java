package edu.HardedCoded;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.Select;

public class CreateEvent {
	public static void EventCreation() throws InterruptedException
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));	
		driver.manage().window().maximize();
		driver.get("http://localhost:8888/index.php?action=Login&module=Users");
		//login page validation
		if(driver.getTitle().equals("vtiger CRM 5 - Commercial Open Source CRM"))
			System.out.println("Login page displayed");
		else
			System.out.println("Login page not displayed");
		driver.findElement(By.xpath("//div[contains(text(),'User Name')]/ancestor::form/descendant::input[@name='user_name']")).sendKeys("admin");
		driver.findElement(By.xpath("//div[contains(text(),'Password')]/ancestor::form/descendant::input[@name='user_password']")).sendKeys("admin");
		driver.findElement(By.id("submitButton")).click();
		//home page validation
		Thread.sleep(3000);
		String title= driver.findElement(By.linkText("Home")).getText();
		if(title.equalsIgnoreCase("Home"))
			System.out.println("Home page displayed");
		else
			System.out.println("Home page not displayed");
		WebElement quickList = driver.findElement(By.xpath("//select[@id='qccombo']"));
		Select qlist = new Select(quickList);
		qlist.selectByValue("Events");
		Thread.sleep(3000);
		driver.findElement(By.xpath("//input[@name='subject']")).sendKeys("meeting");
		driver.findElement(By.xpath("//img[@id='jscal_trigger_date_start']")).click();
		List<WebElement> fromdays = driver.findElements(By.xpath("//td[contains(@class,'day')]"));
		
		for(int i=0; i<fromdays.size();i++)
		{
			String day = fromdays.get(i).getText();
			if(day.equals("10"))
			{
				fromdays.get(i).click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//img[@id='jscal_trigger_due_date']")).click();
		
		List<WebElement> duedays = driver.findElements(By.xpath("//td[contains(@class,'day')]"));
		
		for(int i=0; i<duedays.size();i++)
		{
			String day = duedays.get(i).getText();
			if(day.equals("10"))
			{
				duedays.get(i).click();
				break;
			}
		}
		
		driver.findElement(By.xpath("//table[@class='mailClient mailClientBg']/descendant::input[@class='crmbutton small save']")).click();
		
		driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']")).click();
		driver.findElement(By.xpath("//a[text()='Sign Out']")).click();
		driver.quit();
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		EventCreation();
	}
}
