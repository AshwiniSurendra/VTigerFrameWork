package Vtiger.OrganizationsTestScripts;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import vTiger.GenericUtility.BaseClass;
import vTiger.GenericUtility.ExcelFileUtility;
import vTiger.GenericUtility.JavaUtility;
import vTiger.GenericUtility.PropertFileUtility;
import vTiger.GenericUtility.WebDriverUtility;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.CreateOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.OrganizationInformationPage;
@Listeners(vTiger.GenericUtility.ListenersImplementationClass.class)
public class RegressionTestingWithOrganizationTest extends BaseClass {
	
	@Test(dataProvider="Orgnization",groups={"RegressionSuite","SmokeSuite"})
	
	
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
	
	@Test(groups="RegressionSuite")
	public void demoTest()
	{
		System.out.println("How are you");
		//Assert.fail();
	}
	
	@Test
	public void demoTest2()
	{
		System.out.println("I am Fine");
	}
	@DataProvider(name="Orgnization")
	public Object[][] getData()
	{
		Object[][]data=new Object[1][2];
		data[0][0]="wipro";
		data[0][1]="Technology";
		
		return data;
		
	}
	


}
