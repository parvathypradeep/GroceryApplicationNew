package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;

import utilities.PageUtility;

public class AdminPage {
	
public WebDriver driver;
	
	public AdminPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); // initElements - method is used to find elements
	}
	
	PageUtility pageutl = new PageUtility();
	
	@FindBy (xpath="//a[@class='btn btn-rounded btn-danger']") WebElement newButton;
	@FindBy(id="username") WebElement username;
	@FindBy(id="password") WebElement password;
	@FindBy (id ="user_type")WebElement dropdown;
	@FindBy (name="Create")WebElement save;
	
	@FindBy (xpath = "//a[contains(@href,'javascript:void(0)')and contains(@class,'btn-primary')]")WebElement searchbutton;
	@FindBy (id ="un")WebElement usernamesearch;
	@FindBy(id = "ut")WebElement usertypedropdown;
	@FindBy (name="Search")WebElement search;
	
	@FindBy (xpath ="//a[contains(@href,'com/admin/list-admin')and contains(@class,'btn-warning')]")WebElement resetbutton;
	
	@FindBy(xpath="//div[@class='alert alert-success alert-dismissible']")WebElement alertText;
	@FindBy(xpath="//h1[@class='m-0 text-dark' and text()='Admin Users']")WebElement adminUserText;
	
	
	public AdminPage clickOnNewButton()
	{
		newButton.click();
		return this;
	}
	
	public AdminPage enterUserName(String usernamevalue1)
	{
		username.sendKeys(usernamevalue1);
		return this;
	}
	
	public AdminPage enterPassword(String passwordvalue1)
	{
		password.sendKeys(passwordvalue1);
		return this;
	}
	
	public AdminPage choosedrowpdownValue()
	
	{
		pageutl.selectDragDropWithValue(dropdown, "staff");
		return this;
		
	}
	
	public AdminPage clickSave()
	{
		save.click();
		return this;
	}
	
	public AdminPage clickSearch()
	{
		searchbutton.click();
		return this;
	}
	
	public AdminPage searchUserName(String usernamesearchvalue)
	{
		usernamesearch.sendKeys(usernamesearchvalue);
		return this;
		
	}
	
	public AdminPage searchUserType()
	{
		pageutl.selectDragDropWithValue(usertypedropdown, "staff");
		return this;

	}
	
	public AdminPage searchUser()
	{
		search.click();
		return this;

	}
	
	public AdminPage clickOnResetButton()
	{
		resetbutton.click();
		return this;

	}
	
	public boolean isAlertTextDisplayed()
	{
		return alertText.isDisplayed();
	}
	
	public boolean isAdminUserTextDisplayed()
	{
		return adminUserText.isDisplayed();
	}
	
	

}
