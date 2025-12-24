package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import automationcore.Base;
import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import utilities.ExcelUtility;

public class LoginTest extends Base{
	
	HomePage home;
	
	@Test(priority=1, description="user is trying to login with valid credentials", groups= {"smoke"})
	public void verifyUserLogiWithValidCredentials() throws IOException
	{
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage lp = new LoginPage(driver);
		lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		home=lp.clickOnLoginButton(); // navigates to homepage
		boolean dashboardDisplayed = lp.isDashboardDisplayed();
		Assert.assertTrue(dashboardDisplayed,Constant.VALIDCREDENTIALERROR);
		
	}

	@Test(priority=2, description="user is trying to login with invalid credentials", retryAnalyzer=retry.Retry.class)
	public void verifyUserLogiWithInvalidCredentials() throws IOException
	{String usernamevalue = ExcelUtility.getStringData(1, 0, "LoginPage");
	String passwordvalue = ExcelUtility.getStringData(1, 1, "LoginPage");
	LoginPage lp = new LoginPage(driver);
	lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue).clickOnLoginButton();
	
	String expected = "7rmart supermarket";
	String actual = lp.isTitleDisplayed();
	Assert.assertEquals(actual, expected, Constant.INVALIDCREDENTIALERROR);
	}
	
	@Test(priority=3, description="user is trying to login with invalid username")
	public void verifyUserLogiWithInvalidUsername() throws IOException
	{
		String usernamevalue = ExcelUtility.getStringData(2, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(2, 1, "LoginPage");
		LoginPage lp = new LoginPage(driver);
		lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue).clickOnLoginButton();
		
		String expected = "7rmart supermarket";
		String actual = lp.isTitleDisplayed();
		Assert.assertEquals(actual, expected, Constant.INVALIDUSERNAMEERROR);
	}
	
	@Test(priority=4, groups={"smoke"}, description="user is trying to login with invalid password", dataProvider="loginProvider")
	public void verifyUserLogiWithInvalidPassword(String usernamevalue, String passwordvalue) throws IOException
	{
		LoginPage lp = new LoginPage(driver);
		lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue).clickOnLoginButton();
		
		String expected = "7rmart supermarket";
		String actual = lp.isTitleDisplayed();
		Assert.assertEquals(actual, expected, Constant.INVALIDPASSWORDERROR);
	}
	
	
	@DataProvider(name = "loginProvider") // @DataProvider-is a TestNG annotation that provide data
	public Object[][] getDataFromDataProvider() throws IOException { // method dataprovider syntax

	return new Object[][] { new Object[] { "admin", "admin22" }, new Object[] { "admin123", "123" },
	// new Object[] {ExcelUtility.getStringData(3,
	// 0,"Login"),ExcelUtility.getStringData(3,1 ,"Login")}
	};
	}
	

}
