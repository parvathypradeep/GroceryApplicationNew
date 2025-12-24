package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constant.Constant;
import pages.AdminPage;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;
import utilities.RandomDataUtility;

public class AdminTest extends Base{
	
	HomePage hp;
	AdminPage ap;
	
	@Test(description="user is trying to create new admin")
	public void verifyWhetherUserIsAbleToCreateNewAdmin() throws IOException
	{
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage lp = new LoginPage(driver);
		lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		hp=lp.clickOnLoginButton();
		
		
		
		ap=hp.clickOnMoreInfo();
		
		RandomDataUtility random = new RandomDataUtility();
		String usernamevalue1 = random.randomUserName();
		String passwordvalue1 = random.randomUserPassword();
		
		ap.clickOnNewButton().enterUserName(usernamevalue1).enterPassword(passwordvalue1).choosedrowpdownValue().clickSave();
		
		boolean alertDisplayed = ap.isAlertTextDisplayed();
		Assert.assertTrue(alertDisplayed,Constant.CREATEADMINERROR);
	}
	
	@Test(description="user is trying to search newly added user")
	public void verifyWhetherUserIsAbleToSearchNewlyAddedUser() throws IOException
	{
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage lp = new LoginPage(driver);
		lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		hp=lp.clickOnLoginButton();
		
		
		//HomePage hp = new HomePage(driver);
		ap=hp.clickOnMoreInfo();
		
		
		//AdminPage ap1 = new AdminPage(driver);
		String usernamesearchvalue = ExcelUtility.getStringData(0, 0, "UserDetails");
		ap.clickSearch().searchUserName(usernamesearchvalue).searchUserType().searchUser();
		
		boolean adminTextDisplayed = ap.isAdminUserTextDisplayed();
		Assert.assertTrue(adminTextDisplayed,Constant.SEARCHADMINERROR);
	}
	
	@Test(description="user is trying to reset the page")
	public void verifyUserIsAbleToReset() throws IOException
	{
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage lp = new LoginPage(driver);
		lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		hp=lp.clickOnLoginButton();
		
		
		//HomePage hp = new HomePage(driver);
		ap=hp.clickOnMoreInfo();
		ap.clickOnResetButton();
		
		boolean adminTextDisplayed = ap.isAdminUserTextDisplayed();
		Assert.assertTrue(adminTextDisplayed,Constant.RESETADMINERROR);
	}

}
