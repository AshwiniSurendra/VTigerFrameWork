package Vtiger.Practice;

import java.io.IOException;

import vTiger.GenericUtility.ExcelFileUtility;
import vTiger.GenericUtility.JavaUtility;
import vTiger.GenericUtility.PropertFileUtility;
import vTiger.GenericUtility.WebDriverUtility;

public class GenericUtilityPractice {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		JavaUtility j=new JavaUtility();
		int data=j.getRandomNumber();
		System.out.println(data);
		
		String date=j.getSystemDate();
		System.out.println(date);
		
		String date1=j.getSystemDateInFormat();
		System.out.println(date1);
		
		PropertFileUtility pUtil=new PropertFileUtility();
		String value=pUtil.readDataFromPropertFile("browser");
		System.out.println(value);
		
	String	url=pUtil.readDataFromPropertFile("url");
		System.out.println(url);
		
		ExcelFileUtility eUtil=new ExcelFileUtility();
		String value1=eUtil.readDataFromExcelFile("Organizations", 0, 0);
		System.out.println(value1);
		
		int count=eUtil.getRowCount("Organizations");
		System.out.println(count);
		
		eUtil.writeIntoExcelFile("Organizations", 1, 7, "Qspiders");
		System.out.println("data added");
		
		
		

	}

}
