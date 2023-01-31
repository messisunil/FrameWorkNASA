package DataProvider;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

public class ExcelDataProvider {
	
	
	@Test(dataProvider = "ticket")
	public void printTicket(String source, String destination) {
		System.out.println("source: "+source+"     destination: "+destination);
	}
	
	@DataProvider
	public Object[][] ticket()
	{
		Object[][] obj = new Object[3][2];
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(".\\src\\test\\resources\\edu\\resources\\ticketBooking.xlsx");
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		Workbook wb = null;
		try {
			wb = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		Sheet s = wb.getSheet("Sheet1");
		
		for(int i=0; i<2 ; i++)
		{
			
			for(int j=0; j<3 ; j++)
			{
				obj[j][i] =s.getRow(i).getCell(j).getStringCellValue();
			}
		}
		try {
			wb.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return obj;
	}
	
}
