package edu.practice;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;

public class ChrmeOptns {
	public static void m1()
	{
		ChromeOptions cs = new ChromeOptions();
		cs.setExperimentalOption("excludeSwitches", new String[] {"enable-automation"});
		cs.addArguments("--disable-notifications","start-maximized");
		WebDriver driver = new ChromeDriver(cs);
		driver.get("https://www.yatra.com/");
		driver.quit();
	}
	
	public static void m2()
	{
		ChromeOptions cs = new ChromeOptions();
		cs.addArguments("--headless");
		WebDriver driver = new ChromeDriver(cs);
		driver.get("https://www.yatra.com/");
		driver.quit();
	}
	
	public static void main(String[] args) {
		m1();
	}
}
