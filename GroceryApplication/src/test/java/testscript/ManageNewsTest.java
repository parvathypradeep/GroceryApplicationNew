package testscript;

import java.io.IOException;

import org.testng.Assert;
import org.testng.annotations.Test;

import automationcore.Base;
import constant.Constant;
import pages.HomePage;
import pages.LoginPage;
import pages.ManageNewsPage;
import utilities.ExcelUtility;

public class ManageNewsTest extends Base{
	
	HomePage hp;
	ManageNewsPage mp;
	
	@Test(description="user is trying to add new news")
	public void verifyWhetherUserIsAbleToAddNewNews() throws IOException
	{
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage lp = new LoginPage(driver);
		lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		hp=lp.clickOnLoginButton();
		
		
		mp=hp.clickOnManageNewsMoreInfo();
		mp.clickOnNewButton();
		
		String newstextvalue = ExcelUtility.getStringData(0, 0, "News");
		mp.enterNews(newstextvalue).clickOnSaveButton();
		
		boolean alertDisplayed = mp.isAlertTextDisplayed();
		Assert.assertTrue(alertDisplayed,Constant.ADDNEWSERROR);
		
		
	}
	
	@Test(description="user is trying to search newly added news")
	public void verifyWhetherUserIsAbleToSearchNewlyAddedNews() throws IOException
	{
		String usernamevalue = ExcelUtility.getStringData(0, 0, "LoginPage");
		String passwordvalue = ExcelUtility.getStringData(0, 1, "LoginPage");
		LoginPage lp = new LoginPage(driver);
		lp.enterUserNameOnUserNameField(usernamevalue).enterPasswordOnPasswordField(passwordvalue);
		hp=lp.clickOnLoginButton();
		
		//HomePage hp = new HomePage(driver);
		mp=hp.clickOnManageNewsMoreInfo();
		mp.clickOnSearch();
		
	
		String searchnews = ExcelUtility.getStringData(0, 0, "News");
		mp.searchNews(searchnews).clickOnSearchNewsButton();
		
		boolean manageNewsDisplayed = mp.isManageNewsDisplayed();
		Assert.assertTrue(manageNewsDisplayed,Constant.SEARCHNEWSERROR);
		
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
		mp=hp.clickOnManageNewsMoreInfo();
		
		mp.clickOnResetButton();
		
		boolean manageNewsDisplayed = mp.isManageNewsDisplayed();
		Assert.assertTrue(manageNewsDisplayed,Constant.RESETNEWSERROR);
	}
}
