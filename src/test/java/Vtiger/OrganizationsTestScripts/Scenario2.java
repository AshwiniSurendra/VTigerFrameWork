package Vtiger.OrganizationsTestScripts;

import java.io.IOException;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;

import vTiger.GenericUtility.ExcelFileUtility;
import vTiger.GenericUtility.JavaUtility;
import vTiger.GenericUtility.PropertFileUtility;
import vTiger.GenericUtility.WebDriverUtility;

public class Scenario2 {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		//Step1:Create all the object of Required libraries
				JavaUtility jUtil=new JavaUtility();
				WebDriverUtility wUtil=new WebDriverUtility();
				PropertFileUtility pUtil=new PropertFileUtility();
				ExcelFileUtility eUtil=new ExcelFileUtility();
				
				//Step2:Read all the required data
				String BROWSER=pUtil.readDataFromPropertFile("browser");
				String URL=pUtil.readDataFromPropertFile("url");
				String USERNAME=pUtil.readDataFromPropertFile("username");
				String PASSWORD=pUtil.readDataFromPropertFile("password");
				
				//String LASTNAME=eUtil.readDataFromExcelFile("Contacts", 1, 2);
				String ORGName=eUtil.readDataFromExcelFile("Organizations", 1, 2)+jUtil.getRandomNumber();
				
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
				driver.findElement(By.name("user_name")).sendKeys(USERNAME);
				driver.findElement(By.name("user_password")).sendKeys(PASSWORD);
				driver.findElement(By.id("submitButton")).click();
				
				//Step 5: Navigate to Organizations Link
				driver.findElement(By.linkText("Organizations")).click();
				
				//Step 6: Click on Organizations look up image
				driver.findElement(By.xpath("//img[@alt='Create Organization...']")).click();
				
				//Step 7: Create new organization and save
				driver.findElement(By.name("accountname")).sendKeys(ORGName);
				
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				//Step 8: Validate for Organization
				String OrgHeader = driver.findElement(By.xpath("//span[@class='dvHeaderText']")).getText();
				if(OrgHeader.contains(ORGName))
				{
					System.out.println(OrgHeader);
					System.out.println("Organization successfully created");
				}
				else
				{
					System.out.println("Organization not created");
				}
				//Step 15: logout of App
				WebElement ele = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				wUtil.mouseHoverAction(driver, ele);
				driver.findElement(By.linkText("Sign Out")).click();
				driver.close();
			}
}
