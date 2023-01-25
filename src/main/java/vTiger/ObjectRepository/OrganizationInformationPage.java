package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class OrganizationInformationPage {
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement OrgHeaderTxt;
	
	@FindBy(xpath="//span[@id=\'dtlview_Industry\']")
	private WebElement IndustryDropbtn;
	
	public OrganizationInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public WebElement getOrgHeaderTxt() {
		return OrgHeaderTxt;
	}
	
	/**
	 * @return the industryDropbtn
	 */
	public WebElement getIndustryDropbtn() {
		return IndustryDropbtn;
	}
		//Business Library
		/**
		 * This method will capture the header text and return it to caller
		 * @return
		 */
		
	public String getOrganizationHeaderTxt()
	{
		return OrgHeaderTxt.getText();
	}
	
	public String getOrganizationIndustryDropBtn()
	{
		return IndustryDropbtn.getText();
	}
	

}
