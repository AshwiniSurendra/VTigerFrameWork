package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtility.WebDriverUtility;

public class CreateNewOrganizationPage extends WebDriverUtility
{
	@FindBy(name="accountname")
	private WebElement OrgNameEdt;
	
	@FindBy(name="industry")
	private WebElement IndustryDropDown;
	
	@FindBy(xpath="(//input[@title='Save [Alt+S]'])[1]")
	private WebElement SaveBtn;
	
	public CreateNewOrganizationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public WebElement getOrgNameEdt() {
		return OrgNameEdt;
	}
	
	public WebElement getIndustryDropDown() {
		return IndustryDropDown;
	}
	
	public WebElement getSaveBtn() {
		return SaveBtn;
	}
	public void createNewOrganization(String OrgName)
	{
		OrgNameEdt.sendKeys(OrgName);
		SaveBtn.click();
	}
	/**
	 * this method will create new organization with industry
	 * @param OrgName
	 * @param industry
	 */
	public void createNewOrganization(String OrgName,String industry)
	{
		OrgNameEdt.sendKeys(OrgName);
		handleDropDown(IndustryDropDown, industry);
		SaveBtn.click();
	}
	
}
