package Vtiger.OrganizationsTestScripts;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtility.BaseClass;
import vTiger.GenericUtility.ExcelFileUtility;
import vTiger.GenericUtility.JavaUtility;
import vTiger.GenericUtility.PropertFileUtility;
import vTiger.GenericUtility.WebDriverUtility;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.CreateOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationInformationPage;

public class SmokeTestingWithOrganizationTest extends BaseClass {
		@Test(dataProvider="Orgnization")
		public void createOrgWithIndustryDataProviderWithSmokeTest(String OrgName,String Industry) throws IOException
		{
			//Step1:Create the object of Required Generic Utilities
			JavaUtility jutil=new JavaUtility();
			WebDriverUtility wutil=new WebDriverUtility();
			PropertFileUtility putil=new PropertFileUtility();
			ExcelFileUtility eutil=new ExcelFileUtility();
			
			//Step2:Read Required Data
			
			//Step3:Launch the Browser
			//Step4:Login to Application
			//Step5:navigate to Organization
			HomePage hp=new HomePage(driver);
			hp.OrganizationsBtn();
			//Step6:Click on Create Organization LookUp Image
			CreateOrganizationPage cop=new CreateOrganizationPage(driver);
			cop.createOrganization();
			//Step7:Create new organization and save
			CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
			cnop.createNewOrganization(OrgName+jutil.getRandomNumber(),Industry);
			//Step8:validate
			OrganizationInformationPage oip=new OrganizationInformationPage(driver);
			String OrgHeader=oip.getOrganizationHeaderTxt();
			//String IndustryType=oip.getOrganizationIndustryDropBtn();
			if(OrgHeader.contains(OrgName))
			{
				System.out.println(OrgHeader+" Created successfully with");
			}
			else
			{
				System.out.println(OrgName+" Not created");
			}
			//Step9:Logout from the application
			
		}
		
		
		@DataProvider(name="Orgnization")
		public Object[][] getData()
		{
			Object[][]data=new Object[5][2];
			data[0][0]="Infosys";
			data[0][1]="Technology";
			
			data[1][0]="HDFC";
			data[1][1]="Banking";
			
			data[2][0]="Honda";
			data[2][1]="Manufacturing";
			
			data[3][0]="HAL";
			data[3][1]="Manufacturing";
			
		data[4][0]="Chaitanya";
		data[4][1]="Education";
			return data;
			
		}
		

	

}
