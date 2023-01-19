package edu.practice;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.Point;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class JavaScriptExecutor {
	public static void hardCodingCords()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy(0,1000)");
	}
	
	public static void usingCords()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		WebElement scroll = driver.findElement(By.xpath("//a[contains(text(),'Popular Destinations')]"));
		Point cords = scroll.getLocation();
		int x = cords.getX();
		int y = cords.getY();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.scrollBy("+x+","+y+")");
	}
	
	public static void usingWebElement()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.get("https://www.ebay.com/");
		WebElement scroll = driver.findElement(By.xpath("//a[contains(text(),'Popular Destinations')]"));
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoView(true)");
	}
	
	public static void navigateTo()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.location=arguments[0]", "https://www.ebay.com/");
		WebElement scroll = driver.findElement(By.xpath("//a[contains(text(),'Popular Destinations')]"));
		js.executeScript("arguments[0].scrollIntoView(true)", scroll);
		
	}
	
	public static void passTheData()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.location=arguments[0]", "https://www.ebay.com/");
		
		WebElement value = driver.findElement(By.xpath("//input[@placeholder='Search for anything']"));
		js.executeScript("arguments[0].value = arguments[1]",value,"iphones");
		WebElement search = driver.findElement(By.xpath("//input[@value='Search']"));
		js.executeScript("arguments[0].click()",search);
	}
	
	public static void getTitleNUrl()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		js.executeScript("window.location=arguments[0]", "https://www.ebay.com/");
		System.out.println(js.executeScript("return document.title"));
		System.out.println(js.executeScript("return document.URL"));
		js.executeScript("history.go(0)");
	}
	
	public static void disabledElement()
	{
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		JavascriptExecutor js = (JavascriptExecutor)driver;
		driver.get("file:///C:/Users/sunil/Desktop/disabled.html");
		WebElement ele = driver.findElement(By.xpath("//input[@id='abc']"));
		js.executeScript("arguments[0].value=arguments[1]",ele,"hello");
	}
	
	public static void main(String[] args) {
		disabledElement();
	}
}
