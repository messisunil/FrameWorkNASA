package edu.practice;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;

public class DDTUsingProperties {
	public static void m1() throws IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\edu\\resources\\DDTusingProp.properties");
		Properties prop = new Properties();
		prop.load(fis);
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get(prop.getProperty("url"));
		driver.findElement(By.xpath("//input[@id='username']")).sendKeys(prop.getProperty("username"));
		driver.findElement(By.xpath("//input[@placeholder='Password']")).sendKeys(prop.getProperty("password"));
		driver.findElement(By.xpath("//div[text()='Login']")).click();
		driver.quit();
	}
	
	public static void main(String[] args) throws IOException {
		m1();
	}
}
