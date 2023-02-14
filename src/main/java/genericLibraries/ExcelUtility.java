package genericLibraries;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.DataFormatter;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
/**
 * This methods consists of reusable methods of excels
 * @author sunil
 *
 */
public class ExcelUtility {
	 private Workbook workbook;
	 private Sheet sheet;
	 DataFormatter dataformat;
	 /**
	  * This method is used to initialize the excel
	  * @param path
	  */
	public void excelInitialization(String path)
	{
		FileInputStream fis = null;
		try {
			fis = new FileInputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook = WorkbookFactory.create(fis);
		} catch (EncryptedDocumentException | IOException e) {
			e.printStackTrace();
		}	
	}
	/**
	 * This method is used to read the single data from excel
	 * @param sheetNumber
	 * @param rowNumber
	 * @param cellNumber
	 * @return
	 */
	public String readDataFromExcel(String sheetNumber, int rowNumber, int cellNumber)
	{
		sheet = workbook.getSheet(sheetNumber);
		dataformat = new DataFormatter();
		return dataformat.formatCellValue(sheet.getRow(rowNumber).getCell(cellNumber));
	}
	
	/**
	 * This method is used to write the single data into excel
	 * @param rowNumber
	 * @param cellNumber
	 * @param data
	 * @param path
	 * @param sheetNumber 
	 */
	public void setDataToExcel(int rowNumber, int cellNumber, String data, String path, String sheetNumber)
	{	
		sheet = workbook.getSheet(sheetNumber);
		sheet.getRow(rowNumber).createCell(cellNumber).setCellValue(data);
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook.write(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	/**
	 * This method is used to read multiple data from the excel workbook
	 * @param testCaseName
	 * @param sheetNumber 
	 * @return
	 */
	public Map<String, String> readDataFromExcel(String testCaseName, String sheetName)
	{
		Map<String , String > map = new HashMap<>();
		sheet = workbook.getSheet(sheetName);
		dataformat = new DataFormatter();
		for(int i=0;i<=sheet.getLastRowNum();i++)
		{
			if(dataformat.formatCellValue(sheet.getRow(i).getCell(1)).equals(testCaseName))
			{
				for(int j=i; j<sheet.getLastRowNum();j++)
				{
					String key = dataformat.formatCellValue(sheet.getRow(j).getCell(2));
					String value = dataformat.formatCellValue(sheet.getRow(j).getCell(3));
					map.put(key, value);
					if(dataformat.formatCellValue(sheet.getRow(j).getCell(2)).equals("####"))
						break;
				}
				break;
			}
			
		}
		return map;
	}
	
	/**
	 * This method is used to write the status into excel workbook
	 * @param path
	 * @param testCaseName
	 * @param status
	 * @param sheetNumber 
	 */
	public void setDataToExcel( String path, String testCaseName, String status, String sheetNumber)
	{
		sheet = workbook.getSheet(sheetNumber);
		for(int i=0; i<sheet.getLastRowNum();i++)
		{
			if(dataformat.formatCellValue(sheet.getRow(i).getCell(1)).equals(testCaseName))
			{
				sheet.getRow(i).getCell(4).setCellValue(status);
			}
		}
		FileOutputStream fos = null;
		try {
			fos = new FileOutputStream(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		try {
			workbook.write(fos);
		} catch (IOException e) {
			e.printStackTrace();
		}
		try {
			fos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}
	

	/**
	 * This method is used to close the workbook
	 */
	public void closeTheWorkbook()
	{
		try {
			workbook.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
