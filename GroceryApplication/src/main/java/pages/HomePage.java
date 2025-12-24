package pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class HomePage {
	
public WebDriver driver;
	
	public HomePage(WebDriver driver)
	{
		this.driver = driver;
		PageFactory.initElements(driver, this); // initElements - method is used to find elements
	}

	@FindBy(xpath="//a[@class='nav-link' and @data-toggle='dropdown']") WebElement adminButton;
	@FindBy(xpath="//a[@class='dropdown-item' and contains(@href,'logout')]") WebElement logoutButton;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-admin' and contains(@class, 'small-box-footer')]")WebElement moreinfo;
	@FindBy(xpath="//a[@href='https://groceryapp.uniqassosiates.com/admin/list-news'and contains (@class,'small-box-footer')]") WebElement managenewsmoreinfo;
	@FindBy(xpath="//p[text()='Dashboard']")WebElement dashboard;
	@FindBy(xpath="//b[text()='7rmart supermarket']")WebElement loginText;
	
	
	
	public HomePage clickOnAdminButton() {
		
		adminButton.click();
		return this;
	}
	
	public LoginPage clickOnLogoutButton()
	{
		logoutButton.click();
		return new LoginPage(driver);
	}
	
	public AdminPage clickOnMoreInfo()
	{
		moreinfo.click();
		return new AdminPage(driver);

	}
	
	public ManageNewsPage clickOnManageNewsMoreInfo()
	{
		managenewsmoreinfo.click();
		return new ManageNewsPage(driver);

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
