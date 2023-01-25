package Vtiger.OrganizationsTestScripts;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.apache.poi.ss.usermodel.Workbook;
import org.apache.poi.ss.usermodel.WorkbookFactory;
import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;

import io.github.bonigarcia.wdm.WebDriverManager;

public class CreateOrganizationWithDDT {

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub 
		
		//Step1:Read all the Data
		/*Read the data from property file*/
		
		FileInputStream fis=new FileInputStream(".\\src\\test\\resources\\CommonData.properties");
		Properties pObj=new Properties();
		pObj.load(fis);
		String Browser=pObj.getProperty("browser");
		String URL=pObj.getProperty("url");
		String Username=pObj.getProperty("username");
		String Password=pObj.getProperty("password");
		
		/*Read the data from excelSheet*/
		FileInputStream fis1=new FileInputStream(".\\src\\test\\resources\\TestData.xlsx");
	Workbook wb=WorkbookFactory.create(fis1);
	String OrgName=wb.getSheet("Organizations").getRow(1).getCell(2).getStringCellValue();
	WebDriver driver=null;	
		
		
		
		
		//Step2:Launch the browser
	if (Browser.equalsIgnoreCase("chrome")) 
	{ 
		WebDriverManager.chromedriver().setup();
		driver = new ChromeDriver();
	}
	else if(Browser.equalsIgnoreCase("fIREFOX"))
	{
	WebDriverManager.firefoxdriver().setup();
		driver = new FirefoxDriver();
	}
	else
	{
		System.out.println("invalid Browser name");
	}
	
	driver.manage().window().maximize();
	driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	
	//driver.manage().timeouts().implicitlyWait(Duration.OfSeconds(20));
	driver.get(URL);
	
	
	
		//Step3:login to Application
	driver.findElement(By.name("user_name")).sendKeys(Username);
	driver.findElement(By.name("user_password")).sendKeys(Password);
	driver.findElement(By.id("submitButton")).click();
	
	
		//Step4:Click on on Organization link
	driver.findElement(By.linkText("Organizations")).click();
	
		//Step5:click on create Organization look up Image
	driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
		
	
	//Step6:create Organization with mandatory details 
	driver.findElement(By.name("accountname")).sendKeys(OrgName);
		
	
	//Step7:Save
	driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();

		//Step8:validate
	 String ele1 = driver.findElement(By.id("dtlview_Organization Name")).getText();
	if(ele1.contains(OrgName))
	{
		System.out.println(ele1);
		System.out.println("Pass");
	}
	else
	{
		System.out.println("Fail");
	}
	//Step 8: Logout of Application
	WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
	Actions act = new Actions(driver);
	act.moveToElement(element).perform();
	driver.findElement(By.linkText("Sign Out")).click();


		//Step9
		

	}

}
