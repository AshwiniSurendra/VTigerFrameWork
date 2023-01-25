package vTiger.GenericUtility;

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

public class ExcelFileUtility {
	/**This method read the data from Excel Sheet 
	 * @throws
	 *@param 
	 * @return
	 * */
	
	public static String readDataFromExcelFile(String sheet,int rowNum,int cellNum) throws EncryptedDocumentException, IOException
	{
		
	
		FileInputStream fis=new FileInputStream(IconstantsUtility.ExcelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheet);
		Row rw=sh.getRow(rowNum);
		Cell ce=rw.getCell(cellNum);
		String value=ce.getStringCellValue();
		wb.close();
		return value;
	}
	/**Thismethod reurn the rowcount
	 
	 * @param sheet
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	
	public int getRowCount(String sheet) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IconstantsUtility.ExcelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheet);
		int rowCount=sh.getLastRowNum();
		return rowCount;
	}
	
	/*This method write data into excel sheet
	 *  @param
	 *  @throws
	 */
	
	public void writeIntoExcelFile(String sheet,int rowNum,int cellNum,String data) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IconstantsUtility.ExcelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		
		Sheet sh=wb.getSheet(sheet);
		Row rw=sh.getRow(rowNum);
		Cell ce=rw.createCell(cellNum);
		ce.setCellValue(data);
		FileOutputStream fos=new FileOutputStream(IconstantsUtility.ExcelFilePath);
		wb.write(fos);
		wb.close();
		
		

	}
	/**
	 * this method will read multiple data
	 * @param sheetName
	 * @return
	 * @throws EncryptedDocumentException
	 * @throws IOException
	 */
	public Object[][] readMultipleData(String sheetName) throws EncryptedDocumentException, IOException
	{
		FileInputStream fis=new FileInputStream(IconstantsUtility.ExcelFilePath);
		Workbook wb=WorkbookFactory.create(fis);
		Sheet sh=wb.getSheet(sheetName);
		int lastRow=sh.getLastRowNum();
		int lastCell=sh.getRow(0).getLastCellNum();
		
		Object[][] data=new Object[lastRow][lastCell];
		for(int i=0;i<lastRow;i++)
		{
			for(int j=0;j<lastCell;j++)
			{
				data[i][j]=sh.getRow(i+1).getCell(j).getStringCellValue();
			}
		}
		return data;
	}


	}


