package Vtiger.ObjectRepositoryTestScripts;

import org.testng.annotations.Test;
import org.testng.annotations.Test;
import org.testng.annotations.Test;

import java.io.IOException;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.GenericUtility.ExcelFileUtility;
import vTiger.GenericUtility.JavaUtility;
import vTiger.GenericUtility.PropertFileUtility;
import vTiger.GenericUtility.WebDriverUtility;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.CreateOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationInformationPage;

import vTiger.GenericUtility.BaseClass;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.CreateOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganizationInformationPage;


public class CreateOrganizationWithBaseclassTest extends BaseClass
{
	@Test
	public void createOrgWithIndustryTest() throws EncryptedDocumentException, IOException
	{
	String ORGNAME=eutil.readDataFromExcelFile("Organizations", 4, 2)+jutil.getRandomNumber();
	String INDUSTRY=eutil.readDataFromExcelFile("Organizations", 4, 3);
	
	
	//Step5:navigate to Organization
		HomePage hp=new HomePage(driver);
		hp.OrganizationsBtn();
		
		
		//Step6:Click on Create Organization LookUp Image
		CreateOrganizationPage cop=new CreateOrganizationPage(driver);
		cop.createOrganization();
		//Step7:Create new organization and save
		CreateNewOrganizationPage cnop=new CreateNewOrganizationPage(driver);
		cnop.createNewOrganization(ORGNAME);
		//Step8:validate
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		String OrgHeader=oip.getOrganizationHeaderTxt();
		//String IndustryType=oip.getOrganizationIndustryDropBtn();
		if(OrgHeader.contains(ORGNAME))
		{
			System.out.println(OrgHeader+" Created successfully with");
		}
		else
		{
			System.out.println(ORGNAME+" Not created");
		}
		
}
	@Test
	public void demoTest()
	{
		System.out.println("Hai");
	}
}