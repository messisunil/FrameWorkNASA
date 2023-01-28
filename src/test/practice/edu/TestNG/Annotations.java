package edu.TestNG;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Test;

public class Annotations {
	
	@Test(enabled=false)
	public void openFacebook()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");
		driver.findElement(By.xpath("//input[@id='email']")).sendKeys("admin");
		driver.quit();
	}
	
	@AfterMethod()
	public void aftermethod()
	{
		System.out.println("after method");
	}
	
	@AfterClass()
	public void afterclass()
	{
		System.out.println("after class");
	}
	
	@AfterTest()
	public void aftertest()
	{
		System.out.println("after test");
	}
	
	@AfterSuite()
	public void aftersuite()
	{
		System.out.println("after suite");
	}
	@BeforeSuite()
	public void beforesuite()
	{
		System.out.println("before suite");
	}
	@BeforeTest()
	public void beforetest()
	{
		System.out.println("before test");
	}
	@BeforeClass()
	public void beforeclass()
	{
		System.out.println("before class");
	}
	
	@BeforeMethod()
	public void beforemethod()
	{
		System.out.println("before method");
	}
	
	@Test
	public void test()
	{
		System.out.println("test");
	}
	
}
