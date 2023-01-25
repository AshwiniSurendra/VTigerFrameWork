package Vtiger.Practice;

import java.io.IOException;
import java.time.Duration;

import org.apache.poi.EncryptedDocumentException;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import vTiger.GenericUtility.ExcelFileUtility;
import vTiger.GenericUtility.JavaUtility;
import vTiger.GenericUtility.PropertFileUtility;
import vTiger.GenericUtility.WebDriverUtility;
import vTiger.ObjectRepository.CreateContactInformationPage;
import vTiger.ObjectRepository.CreateContactPage;
import vTiger.ObjectRepository.CreateNewContactPage;
import vTiger.ObjectRepository.CreateNewOrganizationPage;
import vTiger.ObjectRepository.CreateOrganizationPage;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;
import vTiger.ObjectRepository.OrganizationInformationPage;

public class PomClassPractice {

	public static void main(String[] args) throws EncryptedDocumentException, IOException {
		JavaUtility jUtil=new JavaUtility();
		WebDriverUtility wUtil=new WebDriverUtility();
		PropertFileUtility pUtil=new PropertFileUtility();
		ExcelFileUtility eUtil=new ExcelFileUtility();
		
		//Step2:Read all the required data
		String BROWSER=pUtil.readDataFromPropertFile("browser");
		String URL=pUtil.readDataFromPropertFile("url");
		String USERNAME=pUtil.readDataFromPropertFile("username");
		String PASSWORD=pUtil.readDataFromPropertFile("password");
		
		String LASTNAME=eUtil.readDataFromExcelFile("Contacts", 9, 2);
		String ORGName=eUtil.readDataFromExcelFile("Organizations", 4, 2)+jUtil.getRandomNumber();
		
		//Step3:Launch the Browser
		WebDriver driver=null;
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			driver=new ChromeDriver();
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
		{
			driver=new FirefoxDriver();
		}
		else
		{
			System.out.println("invalid browser name"); 
		}
		wUtil.windowMaximize(driver);
		wUtil.waitForPageLoad(driver);
		driver.get(URL);
		
		//Step4:Login to App
		
		LoginPage lp=new LoginPage(driver);
		//lp.getUserNameEdt().sendKeys("admin");
		//lp.getPasswordEdt().sendKeys("admin");
		//lp.getSubmitBtn().click();
		lp.loginToApp("admin", "admin");
		HomePage hp=new HomePage(driver);
		hp.OrganizationsBtn();
		//Step 5: Navigate to Organizations Link
		
		CreateOrganizationPage c=new CreateOrganizationPage(driver);
		c.createOrganization();
		
		//Step6:Click on Create New organization image and enter valid information and save
		CreateNewOrganizationPage cn=new CreateNewOrganizationPage(driver);
		cn.createNewOrganization(ORGName);
		
		//Step7:verify the Created organization 
		OrganizationInformationPage oip=new OrganizationInformationPage(driver);
		String Header=oip.getOrganizationHeaderTxt();
		if(Header.contains(ORGName))
		{
			System.out.println(ORGName+"Organization is Added");
		}
		else
		{
			System.out.println("Fail");
		}
		
		//Step8:Navigate to contacts Link
		hp.ContactsBtn();
		//Step9:Click on Create contact Image
		CreateContactPage cp=new CreateContactPage(driver);
		cp.getCreateImg();
		//Step10:Create contact with valid data
		CreateNewContactPage cnp=new CreateNewContactPage(driver);
		cnp.GetLastName(driver, LASTNAME, ORGName);
		//Step7:verify the Created organization 
		CreateContactInformationPage cip=new CreateContactInformationPage(driver);
				String ContactHeader=cip.getHeaderTxt();
				if(ContactHeader.contains(LASTNAME))
				{
					System.out.println(LASTNAME+"Contact is Added");
				}
				else
				{
					System.out.println("Fail");
				}
				
				hp.logoutOfApp(driver);
		
		
		
		

	}

}
