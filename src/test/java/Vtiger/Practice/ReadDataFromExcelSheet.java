package Vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;

public class ReadDataFromExcelSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		
		//Step1:Load the file into File input Stream -java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step2:Create a Workbook
		Workbook wb=WorkbookFactory.create(fis);
		//Step3:Navigate to the Required Sheet
	Sheet sh=wb.getSheet("Organizations");
		//Step4:Navigate to the required row
		Row rw=sh.getRow(1);
		
		
		//Step5:Navigate to the required Cell
		Cell ch=rw.getCell(1);
		
		//step6:Capture the data present in the cell
		String value=ch.getStringCellValue();
		System.out.println(value);
		
		

	}

}
