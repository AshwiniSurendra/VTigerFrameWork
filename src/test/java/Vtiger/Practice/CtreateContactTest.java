package Vtiger.Practice;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
// Scenario 1: Launch Browser Login to application with valid credentials Navigate 
//to Contacts link Click on Create contact look Up Image Create Contact with
//Mandatory fields Save and Verify logout of Application
import org.openqa.selenium.interactions.Actions;


public class CtreateContactTest {
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
		
		//Step3:Click on contacts link
		driver.findElement(By.linkText("Contacts")).click();
		
		
		//driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();
		
		//Step 4: Click on create contact look up image
		driver.findElement(By.xpath("//img[@title=\"Create Contact...\"]")).click();

		//Step 5: create Contact with mandatory fields
driver.findElement(By.name("lastname")).sendKeys("ashu");

//Step6:SAVE THe details
driver.findElement(By.xpath("//input[@title=\"Save [Alt+S]\"]")).click();

//Step7:validate the application
String contact = driver.findElement(By.xpath("//span[@class=\"dvHeaderText\"]")).getText();
if(contact.contains("ashu"))
{
	System.out.print("yes it is validated");
	
}
else
{
	System.out.print("fail");
}
//Step 8: Logout of Application
WebElement element = driver.findElement(By.xpath("//img[@src='themes/softed/images/user.PNG']"));
Actions act = new Actions(driver);
act.moveToElement(element).perform();
driver.findElement(By.linkText("Sign Out")).click();

		
	}

}
