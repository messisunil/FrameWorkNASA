package advanceSelenium;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class WriteDataIntoExcel {
	public static void writeData() throws EncryptedDocumentException, IOException
	{
		FileInputStream fis = new FileInputStream(".\\src\\test\\resources\\edu\\resources\\demoData.xlsx");
		Workbook wb = WorkbookFactory.create(fis);
		Sheet s = wb.getSheet("Sheet1");
		//create new cell by deleting older data in the cell
		Row r = s.createRow(4);
		//create new cell by deleting older data in the cell
		Cell c =r.createCell(2);
		//writes data into the cell
		c.setCellValue("hello");
		//saves data into excel
		FileOutputStream fos = new FileOutputStream(".\\src\\test\\resources\\edu\\resources\\demoData.xlsx");
		wb.write(fos);
		wb.close();
	}
	
	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		writeData();
	}
}
