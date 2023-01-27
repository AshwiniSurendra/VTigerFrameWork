package vTiger.GenericUtility;

import java.io.IOException;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.github.bonigarcia.wdm.WebDriverManager;
import vTiger.ObjectRepository.HomePage;
import vTiger.ObjectRepository.LoginPage;

public class BaseClass {
	//Step1:Create the object of Required Generic Utilities
		 public JavaUtility jutil=new JavaUtility();
		 public WebDriverUtility wutil=new WebDriverUtility();
	public PropertFileUtility putil=new PropertFileUtility();
		public ExcelFileUtility eutil=new ExcelFileUtility();
		public WebDriver driver=null;
		public static WebDriver sdriver;


	@BeforeSuite(groups={"SmokeSuite","RegressionSuite"})

	public void bsconfig()
	{
		System.out.println("====DataBase Connection SuccessFull====");
	}
	//@Parameters("browser")
	//@BeforeTest
	@BeforeClass(groups={"SmokeSuite","RegressionSuite"})

	public void bcConfig() throws IOException
	{
		String BROWSER=putil.readDataFromPropertFile("browser");
		String URL=putil.readDataFromPropertFile("url");
		
		if(BROWSER.equalsIgnoreCase("chrome"))
		{
			WebDriverManager.chromedriver().setup();
			driver=new ChromeDriver();
			sdriver=driver;
			System.out.println("===="+BROWSER+" Launched Successfully");
		}
		else if(BROWSER.equalsIgnoreCase("firefox"))
			{

			WebDriverManager.firefoxdriver().setup();
			driver=new FirefoxDriver();
			sdriver=driver;

			System.out.println("===="+BROWSER+" Launched Successfully");

			}
		else if(BROWSER.equalsIgnoreCase("edge"))
			{
				WebDriverManager.edgedriver().setup();
				driver=new EdgeDriver();
				System.out.println("===="+BROWSER+" Launched Successfully");
			}
			else
			{
				System.out.println("invalid Browser");
			}
		driver.get(URL);
		wutil.windowMaximize(driver);
		wutil.waitForPageLoad(driver);
		
	}
	
	
	@BeforeMethod(groups={"SmokeSuite","RegressionSuite"})

	public void bmConfig() throws IOException
	{
		String USERNAME=putil.readDataFromPropertFile("username");
		String PASSWORD=putil.readDataFromPropertFile("password");
		LoginPage lp=new LoginPage(driver);
		lp.loginToApp(USERNAME, PASSWORD);
		System.out.println("===Login Successfull===");
		
	}
	@AfterMethod(groups={"SmokeSuite","RegressionSuite"})
	public void amConfig()
	{
		HomePage hp=new HomePage(driver);
		hp.logoutOfApp(driver);
		System.out.println("===Logout Successfull===");
	}
	//@AfterTest
	@AfterClass(groups={"SmokeSuite","RegressionSuite"})
	public void acConfig()
	{
		driver.quit();
		System.out.println("===Browser Closed===");
	}
	
	@AfterSuite(groups={"SmokeSuite","RegressionSuite"})

	public void asconfig()
	{
		System.out.println("====DataBase Connection closed====");
	}

}
