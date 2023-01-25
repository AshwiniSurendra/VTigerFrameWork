package Vtiger.Practice;

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

public class WriteDataIntoExcelSheet {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		// TODO Auto-generated method stub
		//Step1:Load the file into file input stream-java readable format
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
		
		//Step2:cREATE a workbook
	Workbook wb=WorkbookFactory.create(fis);
	
	//Step3:Navigate to the required sheet
	Sheet sh=wb.getSheet("Organizations");
	
	//Step4:navigate to the required row
	Row rw=sh.getRow(1);
	
	//Step5:navigate to the required cell
	Cell ce=rw.createCell(4);
	
	//Step6:Set the value
	ce.setCellValue("Aspiders");
	
	//Step7:Write into the file using file output Stream
	FileOutputStream fos=new FileOutputStream(".\\src\\test\\resources\\TestData.xlsx");
	wb.write(fos);
	System.out.println("Data is added");
	}

}
