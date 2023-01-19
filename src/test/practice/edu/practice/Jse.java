package edu.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Jse {
	public static void m1()
	{
		WebDriver driver = new ChromeDriver();
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("window.location=arguments[0]","https://demo.actitime.com/login.do");
		WebElement username = driver.findElement(By.xpath("//input[@id='username']"));
		js.executeScript("arguments[0].value=arguments[1]",username,"admin");
		WebElement password = driver.findElement(By.xpath("//input[@placeholder='Password']"));
		js.executeScript("arguments[0].value=arguments[1]",password,"manager");
		System.out.println(js.executeScript("return document.Title"));
		System.out.println(js.executeScript("return document.URL"));
	}
	
	public static void main(String[] args) {
		m1();
	}
}
