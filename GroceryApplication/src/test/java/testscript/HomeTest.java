package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class HomeTest extends Base{
	
	HomePage hp;

	@Test(description="user is trying to logout successfully")
	public void verifyUserIsAbletoSuccessfullyLoggedOut() throws IOException
	{
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage lp = new LoginPage(driver);
		lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		hp=lp.clickOnLoginButton();
		
		hp.clickOnAdminButton();
		lp=hp.clickOnLogoutButton();
		
		
		String expected = "7rmart supermarket";
		String actual = lp.isTitleDisplayed();
		Assert.assertEquals(actual, expected, Constant.LOGOUTERROR);
	}
	
}
