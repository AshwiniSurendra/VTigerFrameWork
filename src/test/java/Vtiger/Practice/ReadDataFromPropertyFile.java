package Vtiger.Practice;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ReadDataFromPropertyFile {
	public static void main(String args[]) throws IOException
	{
		//Step1:Read the file in java readable format using file input stream
		FileInputStream fis= new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
	
	//Step2: create the object of properties class from java.util
		Properties pObj=new Properties();
		
		
		//Step3:Load the file input Stream
		pObj.load(fis);
		
		
		//Step4:provide the key and read the value
		String URL=pObj.getProperty("url");
		System.out.println(URL);
		String Browser=pObj.getProperty("browser");
		System.out.println(Browser);
		}
		
	
	
	
	}


