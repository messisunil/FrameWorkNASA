package advanceSelenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcel {
	public static void readData() throws EncryptedDocumentException, IOException
	{
		//convert physical file to java readable object
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\edu\\resources\\demoData.xlsx");
		//open the excel workbook
		//import workbook from org.apache.poi.ss.usermodel
		//the below statement throws 
		Workbook wb = WorkbookFactory.create(fis);
		DataFormatter df = new DataFormatter();
		//get control over particular sheet
		Sheet s = wb.getSheet("Sheet1");
		//get control over specific row
		Row r = s.getRow(0);
		//get control over specific cell
		Cell c = r.getCell(1);
		//fetch the data from cell
		System.out.println(c.getStringCellValue());
		//close workbook
		// one more way of writing code
		String s1 = wb.getSheet("Sheet1").getRow(1).getCell(1).getStringCellValue();
		System.out.println(s1);
		System.out.println(df.formatCellValue(wb.getSheet("Sheet1").getRow(3).getCell(1)));
		
		wb.close();
	}
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		readData();
	}
}
