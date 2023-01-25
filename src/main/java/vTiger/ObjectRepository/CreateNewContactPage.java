package vTiger.ObjectRepository;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtility.WebDriverUtility;

public class CreateNewContactPage extends WebDriverUtility{
	@FindBy(name="lastname")
	private WebElement LastNameEdt;
	
	@FindBy(xpath = "//input[@name='account_name']/following-sibling::img[@title='Select']")
	private WebElement OrgNameImg;
	
	@FindBy(name = "search_text")
	private WebElement searchEdt;

	@FindBy(name = "search")
	private WebElement searchBtn;


	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement SaveBtn;
	
	public CreateNewContactPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public WebElement getLastNameEdt()
	{
		return LastNameEdt;
	}
	
	public WebElement getOrgNameImg() {
		return OrgNameImg;
	}
	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	
	public WebElement getSearchEdt() {
		return searchEdt;
	}
	public WebElement getSearchBtn() {
		return searchBtn;
	}
	public void GetLastName(String Lastname)
	{
		LastNameEdt.sendKeys(Lastname);
		SaveBtn.click();
	}
	public void GetLastName(WebDriver driver,String LastName,String OrgName)
	{
		LastNameEdt.sendKeys(LastName);
		OrgNameImg.click();
		switchToWindow(driver,"Accounts");
		searchEdt.sendKeys(OrgName);
		searchBtn.click();
		driver.findElement(By.xpath("//a[text()='"+OrgName+"']")).click();
		switchToWindow(driver, "Contacts");
		SaveBtn.click();

	}
	
}
