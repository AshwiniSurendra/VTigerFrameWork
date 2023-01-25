package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class CreateContactInformationPage {
	@FindBy(xpath="//span[@class='dvHeaderText']")
	private WebElement ContactHeaderTxt;
	public CreateContactInformationPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public WebElement getContactHeaderTxt() {
		return ContactHeaderTxt;
	}
	public String getHeaderTxt()
	{
		return ContactHeaderTxt.getText();
	}

}
