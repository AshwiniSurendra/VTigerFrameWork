package Vtiger.OrganizationsTestScripts;

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

public class CreateMultipleOrganizations {
	
	//Step1:Create the object of Required Generic Utilities
	JavaUtility jutil=new JavaUtility();
	WebDriverUtility wutil=new WebDriverUtility();
	PropertFileUtility putil=new PropertFileUtility();
	ExcelFileUtility eutil=new ExcelFileUtility();

	
	@Test(dataProvider="Orgnization")
	public void createOrgWithIndustryDataProviderTest(String OrgName,String Industry) throws IOException, InterruptedException
	{
		
		
		//Step2:Read Required Data
		String BROWSER=putil.readDataFromPropertFile("browser");
		String URL=putil.readDataFromPropertFile("url");
		String USERNAME=putil.readDataFromPropertFile("username");
		String PASSWORD=putil.readDataFromPropertFile("password");
		
		//Step3:Launch the Browser
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
		}else if(BROWSER.equalsIgnoreCase("firefox"))
			{
			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			}else
			{
				System.out.println("invalid Browser");
			}
		driver.get(URL);
		wutil.windowMaximize(driver);
		wutil.waitForPageLoad(driver);
		//Step4:Login to Application
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
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
		wutil.waitForPageLoad(driver);
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		String OrgHeader=oip.getOrganizationHeaderTxt();
		String IndustryType=oip.getOrganizationIndustryDropBtn();
		if(OrgHeader.contains(OrgName) && IndustryType.contains(Industry))
		{
			System.out.println(OrgHeader+" Created successfully with"+IndustryType);
		}
		else
		{
			System.out.println(OrgName+" Not created");
		}
		//Step9:Logout from the application
		hp.logoutOfApp(driver);
		//Step10:close the driver
		driver.quit();
	}
	@DataProvider(name="Orgnization")
	public Object[][] getData() throws EncryptedDocumentException, IOException
	{
	Object[][] data=eutil.readMultipleData("MultipleOrg");
	return data;
	}
}
