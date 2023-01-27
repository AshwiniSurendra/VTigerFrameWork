package vTiger.GenericUtility;

import java.io.File;
import java.io.IOException;
import java.time.Duration;
import java.util.Set;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import io.github.bonigarcia.wdm.WebDriverManager;

public class WebDriverUtility 
{
	/**
	 * This method will maximize the window
	 * @param driver
	 */
	public void windowMaximize(WebDriver driver)
	{
		driver.manage().window().maximize();
	}
	/**
	 * This method will minimize the window
	 * @param driver
	 */
	public void windowMinimize(WebDriver driver)
	{
		driver.manage().window().minimize();
	}
	/**This method will wait for 20 seconds for all the elements to get loaded
	 * 
	 * @param driver
	 */
	public void waitForPageLoad(WebDriver driver)
	{
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
	}
	
	/**this method will wait until particular element becomes visible
	 * @param driver
	 * @param element
	 */
	public void waitForElementToBeVisible(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.visibilityOf(element));
		
	}
	public void waitForElementToBeClickable(WebDriver driver,WebElement element)
	{
		WebDriverWait wait=new WebDriverWait(driver,Duration.ofSeconds(20));
		wait.until(ExpectedConditions.elementToBeClickable(element));
	}
	
	/**This method will handle the drop down using index
	 
	 * @param element
	 * @param index
	 */
	public void handleDropDown(WebElement element,int index)
	{
		Select s=new Select(element);
		s.selectByIndex(index);
		
	}
	/**this method will handle the drop down using value
	 * 
	 * @param element
	 * @param value
	 */
	public void handleDropDown(WebElement element,String value)
	{
		Select s=new Select(element);
		s.selectByValue(value);
	}	
	
	/**This will will handle the drop down using text
	 * 
	 * @param text
	 * @param element
	 */
	public void handleDropDown(String text,WebElement element)
	{
		Select s=new Select(element);
		s.selectByVisibleText(text);		
	}
	/**THis method perform mousehover action on a pertticular element
	 * 
	 * @param driver
	 * @param element
	 */
	public void mouseHoverAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.moveToElement(element).perform();
	}
	/**This method will perform doubleclick action anywhere on the page
	 * 
	 * @param driver
	 */
	public void doubleClickAction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.doubleClick().perform();
	}
	/**This method will perform doubleclick on particular element
	 * 
	 * @param driver
	 * @param element
	 */
	public void doubleClickAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.doubleClick(element).perform();
	}
	/**This method will perform RightClick action on a page
	 * 
	 * @param driver
	 */
	public void rightClickAction(WebDriver driver)
	{
		Actions act=new Actions(driver);
		act.contextClick().perform();
	}
	/**This method will perform right click action on a particular element
	 * 
	 * @param driver
	 * @param element
	 */
	public void rightClickAction(WebDriver driver,WebElement element)
	{
		Actions act=new Actions(driver);
		act.contextClick(element).perform();
	}
	/**This method will perform drag and drop action from source to destination
	 * 
	 * @param driver
	 * @param srcElement
	 * @param destElement
	 */
	public void dragAndDropAction(WebDriver driver,WebElement srcElement,WebElement destElement)
	{
		Actions act=new Actions(driver);
		act.dragAndDrop(srcElement, destElement).perform();
	}
	/*This method will switch to frame based on the index
	 * 
	 */
	public void switchToFrame(WebDriver driver,int frameIndex)
	{
		driver.switchTo().frame(frameIndex);
	}
	/*This method will switch to frame based on the frameID Or Frame Name
	 * 
	 */
	public void switchToFrame(WebDriver driver,String frameIDOrName)
	{
		driver.switchTo().frame(frameIDOrName);
	}
	/*This method will switch to frame based on the webelement
	 * 
	 */
	public void switchToFrame(WebDriver driver,WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	/*This method will switch back to immediate parent
	 * 
	 */
	public void switchToParentFrame(WebDriver driver)
	{
	driver.switchTo().parentFrame();
	}
	/*This method will switch back to default frame
	 * 
	 */
	public void switchToDefaultContent(WebDriver driver)
	{
	driver.switchTo().defaultContent();
	}
	/*This method will accept the alert pop up
	 * 
	 */
	public void acceptAlert(WebDriver driver)
	{
		driver.switchTo().alert().accept();
	}
	/*This method will dismiss the alert popup
	 * 
	 */
	public void dismissAlert(WebDriver driver)
	{
		driver.switchTo().alert().dismiss();
	}
	/*This method will get the text from alert pop up and return it to caller
	 * 
	 */
	public String getAlertText(WebDriver driver)
	{
		return driver.switchTo().alert().getText();
	}
	public void switchToWindow(WebDriver driver,String partialWinTitle)
	{
		//Step1:Capture all window IDs
		Set<String> winIds=driver.getWindowHandles();
		
		//Step2:Extract individual window ID
		for(String winID:winIds)
		{
			//Step3:Capture the CurrentWindow Title
			String CurrentTitle=driver.switchTo().window(winID).getTitle();
			//Step4:Capture the current window title with required title
			if(CurrentTitle.contains(partialWinTitle))
			{
				break;
			}
			
		}
	}
	/**This method will take ScreenShot and store it in a folder
	 * 
	 * @param driver
	 * @param ScreenShotName
	 * @return
	 * @throws IOException
	 */
	public String takesScreenShot(WebDriver driver,String ScreenShotName) throws IOException
	{
		TakesScreenshot ts=(TakesScreenshot) driver;
		File src=ts.getScreenshotAs(OutputType.FILE);
		File dst=new File(".\\ScreenShots"+ScreenShotName+".png");
		FileUtils.copyFile(src,dst);
		return dst.getAbsolutePath();		
	}
	/**This method will scroll downwards untill the specific element
	 * 
	 * @param driver
	 */
	public void scrollaction(WebDriver driver)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		js.executeScript("window.scrollBy(0,500)");	
	}
	
	public void scrollaction(WebDriver driver,WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor) driver;
		int y=element.getLocation().getY();
		js.executeScript("window.scrollBy(0,"+y+")",element);	
	}
	
	
	

}
