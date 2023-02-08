package DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class FacebookLogin {
	
	@Test(dataProvider = "readData")
	public void login(String username, String password)
	{
		
		WebDriver driver = new ChromeDriver();
		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(10));
		driver.get("https://www.facebook.com/");
		WebElement usrname = driver.findElement(By.xpath("//input[@id='email']"));
		usrname.sendKeys(username);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		usrname.clear();
		WebElement pass = driver.findElement(By.xpath("//input[@id='pass']"));
		pass.sendKeys(password);
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		pass.clear(); 
		driver.close();
	}
	
	@DataProvider
	public Object[][] readData()
	{
		Object obj[][] = new Object[2][2];
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(".\\src\\test\\resources\\edu\\resources\\FBdata.xlsx");
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		Sheet s = wb.getSheet("Sheet1");
		
		for(int i=0; i<2 ; i++)
		{
			for(int j=0; j<2; j++)
			{
				obj[i][j] = s.getRow(j).getCell(i).getStringCellValue();
			}
		}
		try {
			wb.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		return obj;
	}
}
