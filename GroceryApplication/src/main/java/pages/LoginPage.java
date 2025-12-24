package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import utilities.WaitUtility;

public class LoginPage {
	
public WebDriver driver;
	
	public LoginPage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); // initElements - method is used to find elements
	}
	
	WaitUtility waitutl = new WaitUtility();
	
	@FindBy(name="username")WebElement username; // @FindBy - used to find elements
	@FindBy(name="password")WebElement password;
	@FindBy(xpath="//button[text()='Sign In']")WebElement loginbutton;
	@FindBy(xpath="//p[text()='Dashboard']")WebElement dashboard;
	@FindBy(xpath="//b[text()='7rmart supermarket']")WebElement loginText;
	
	
	
	public LoginPage enterUserNameOnUserNameField(String usernamevalue)
	{
		username.sendKeys(usernamevalue);
		return this;
	}

	public LoginPage enterPasswordOnPasswordField(String passwordvalue)
	{
		password.sendKeys(passwordvalue);
		return this;
	}
	
	public HomePage clickOnLoginButton()
	{
		waitutl.waitUntilElementToBeClickable(driver, loginbutton);
		loginbutton.click();
		return new HomePage(driver);
	}
	
	public boolean isDashboardDisplayed()
	{
		return dashboard.isDisplayed();
	}
	
	public String isTitleDisplayed()
	{
		return loginText.getText();
	}



}
