package constant;

public class Constant {
	
	public static final String CONFIGFILE=System.getProperty("user.dir")+"\\src\\main\\resources\\config.property";
	public static final String TESTDATA=System.getProperty("user.dir")+"\\src\\test\\resources\\TestData.xlsx";
	
	public static final String VALIDCREDENTIALERROR="User is unable to login with valid credentials";
	public static final String INVALIDCREDENTIALERROR="User is able to login with invalid credentials";
	public static final String INVALIDUSERNAMEERROR="User is able to login with invalid username";
	public static final String INVALIDPASSWORDERROR="User is able to login with invalid password";
	
	public static final String LOGOUTERROR="User is unable to logout";
	
	public static final String CREATEADMINERROR="User is unable to create new admin.";
	public static final String SEARCHADMINERROR="User is unable to search new admin.";
	public static final String RESETADMINERROR="User is unable to reset the page.";
	
	public static final String ADDNEWSERROR="User is unable to add new news.";
	public static final String SEARCHNEWSERROR="User is unable to search new news.";
	public static final String RESETNEWSERROR="User is unable to reset news page.";



}
