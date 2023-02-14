package edu.practice;

import java.net.MalformedURLException;
import java.net.URL;
import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.Platform;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.remote.DesiredCapabilities;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.testng.annotations.Test;

public class GridExecution {
	@Test
	public void google()
	{
		URL url = null;
		try {
			url = new URL("http://192.168.29.49:4444/wd/hub");
		} catch (MalformedURLException e) {
			
			e.printStackTrace();
		}
		DesiredCapabilities cap = new DesiredCapabilities();
		cap.setBrowserName("chrome");
		cap.setPlatform(Platform.WINDOWS);
		
		WebDriver driver = new RemoteWebDriver(url,cap);
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.google.com/");
		driver.findElement(By.xpath("//input[@title='Search']")).sendKeys("hello");
		driver.quit();
	}
}
