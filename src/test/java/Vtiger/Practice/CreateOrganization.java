package Vtiger.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.interactions.Actions;


// Scenario 2: Launch Browser Login to application with valid credentials 
//Navigate to Organizations link Click on Create Organization look Up Image 
//Create Organization with Mandatory fields Save and Verify logout of Application


public class CreateOrganization {
	public static void main(String args[])
	{
		//Step1:Launch the browser
		
				WebDriver driver=new ChromeDriver();
				driver.manage().window().maximize();
				driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
				driver.get("http://localhost:8888/");
				
					
				//step2:Login to Application
				driver.findElement(By.name("user_name")).sendKeys("admin");
				driver.findElement(By.name("user_password")).sendKeys("admin");
				driver.findElement(By.id("submitButton")).click();
				
				//Step3:Click on Organization link
				driver.findElement(By.linkText("Organizations")).click();
				
				//Step4:click on Create organization lookup image
				driver.findElement(By.xpath("//img[@src='themes/softed/images/btnL3Add.gif']")).click();
				
				//Step5:Enter valid details
				driver.findElement(By.name("accountname")).sendKeys("Qspiders2");
				
				//Step6:Save
				driver.findElement(By.xpath("//input[@title='Save [Alt+S]']")).click();
				
				//Step7:validate
				String name = driver.findElement(By.id("mouseArea_Organization Name")).getText();
				if(name.contains("Qspiders2"))
				{
					System.out.println(name);
					System.out.println("Pass");
					
				}
				else
				{
					System.out.println("Fail");
				}
				
				//Step8:Logout Application
				WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
				Actions act = new Actions(driver);
				act.moveToElement(element).perform();
				driver.findElement(By.linkText("Sign Out")).click();

	}

}
