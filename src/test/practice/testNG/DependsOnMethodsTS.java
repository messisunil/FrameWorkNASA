package testNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;
import org.testng.annotations.Test;

public class DependsOnMethodsTS {
	public WebDriver driver;
	@Test
	public void openActitime()
	{
		driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://demo.actitime.com/login.do");
	}
	
	@Test(dependsOnMethods = "openActitime")
	public void LoginApplication()
	{
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys("admin"+Keys.TAB+"manager"+Keys.ENTER);
		WebDriverWait wait = new WebDriverWait(driver,Duration.ofSeconds(10));
		wait.until(ExpectedConditions.titleContains("Enter"));
		Assert.assertEquals(driver.getTitle(), "actiTIME - Enter Time-Track");
//		if(driver.getTitle().contains("Enter"))
//			System.out.println("pass");
//		else
//			System.out.println("fail");
		driver.quit();
	}
}
