package edu.practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;

public class Flipkart {

	public static void m1() throws EncryptedDocumentException, IOException
	{
		WebDriver driver = new ChromeDriver();
		driver.get("https://www.flipkart.com/search?q=iphone&otracker=search&otracker1=search&marketplace=FLIPKART&as-show=on&as=off&as-pos=1&as-type=HISTORY");
		String s = "//div[@class='_1YokD2 _3Mn1Gg']/div[@class='_1AtVbE col-12-12']";
		List<WebElement> lists = driver.findElements(By.xpath(s));
		FileInputStream fis;
		Workbook wb;
		Sheet sheets ;
		Row r;
		Cell c;
		FileOutputStream fos;	
		for(int i=1; i<lists.size()-1;i++)
		{
			String s1 = s+"["+i+"]";
			String s2 = driver.findElement(By.xpath(s1+"/descendant::div[@class='_4rR01T']")).getText();
			String s3 = driver.findElement(By.xpath(s1+"/descendant::div[@class='_30jeq3 _1_WHN1']")).getText();
			fis = new FileInputStream(".\\src\\test\\resources\\edu\\resources\\Flipkart.xlsx");
			wb = WorkbookFactory.create(fis);
			sheets = wb.getSheet("Sheet1");
			r = sheets.createRow(i);
			c = r.createCell(0);
			c.setCellValue(s2);
			fos = new FileOutputStream(".\\src\\test\\resources\\edu\\resources\\Flipkart.xlsx");
			wb.write(fos);
			wb.close();
			
			fis = new FileInputStream(".\\src\\test\\resources\\edu\\resources\\Flipkart.xlsx");
			wb = WorkbookFactory.create(fis);
			sheets = wb.getSheet("Sheet1");
			r = sheets.getRow(i);
			c= r.createCell(1);
			c.setCellValue(s3);
			fos = new FileOutputStream(".\\src\\test\\resources\\edu\\resources\\Flipkart.xlsx");
			wb.write(fos);
			wb.close();
		}
		driver.quit();
	}
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		m1();
	}
}
