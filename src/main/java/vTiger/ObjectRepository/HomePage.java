package vTiger.ObjectRepository;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import vTiger.GenericUtility.WebDriverUtility;

public class HomePage extends WebDriverUtility {
	
	@FindBy(linkText="Organizations")
	private WebElement OrganizationsBtn;
	@FindBy(linkText="Contacts")
	private WebElement ContactsBtn;
	@FindBy(linkText="Opportunities")
	private WebElement OpportunitiesBtn;
	@FindBy(linkText="Products")
	private WebElement ProductsBtn;
	@FindBy(linkText="Documents")
	private WebElement DocumentsBtn;
	
	@FindBy(xpath="//img[@src='themes/softed/images/user.PNG']")
	private WebElement AdministratorImg;
	
	@FindBy(linkText="Sign Out")
	private WebElement SignOutLnk;
	
	public HomePage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	public WebElement getOrganizationsBtn() {
		return OrganizationsBtn;
	}
	public WebElement getContactsBtn() {
		return ContactsBtn;
	}
	public WebElement getOpportunitiesBtn() {
		return OpportunitiesBtn;
	}
	public WebElement getProductsBtn() {
		return ProductsBtn;
	}
	public WebElement getDocumentsBtn() {
		return DocumentsBtn;
	}
	
	public WebElement getAdministratorImg() {
		return AdministratorImg;
	}
	public WebElement getSignOutLnk() {
		return SignOutLnk;
	}
	public void OrganizationsBtn()
	{
		OrganizationsBtn.click();
	}
	public void ContactsBtn()
	{
		ContactsBtn.click();
	}
	public void OpportunitiesBtn()
	{
		OpportunitiesBtn.click();
	}
	public void DocumentsBtn()
	{
		DocumentsBtn.click();
	}
	public void ProductsBtn()
	{
		ProductsBtn.click();
	}
	public void logoutOfApp(WebDriver driver)
	{
		mouseHoverAction(driver, AdministratorImg);
		SignOutLnk.click();
	}
	


	
}
