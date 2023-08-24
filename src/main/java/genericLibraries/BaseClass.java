package genericLibraries;

import javax.security.auth.login.LoginContext;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;

import PomPages.AddressFormPage;
import PomPages.CartPage;
import PomPages.HeadPhonesPage;
import PomPages.HomePage;
import PomPages.ShopperLoginPage;
import PomPages.SignUpPages;
import PomPages.WelcomePage;
import PomPages.myaddresspage;
import PomPages.myprofilepage;

public class BaseClass {
	
	protected PropertiesUtility property;
	protected ExcelUtility excel;
	protected JavaUtility jutil;
	protected WebdriverUtility webutil;
	public WebDriver driver;
	public static WebDriver sdriver;
	protected WelcomePage welcome;
	protected ShopperLoginPage login;protected HomePage home;
	protected SignUpPages signUp;
	protected myprofilepage myprofile;
	protected myaddresspage myAddress;
	protected HeadPhonesPage headPhone;
	protected CartPage cart;
	protected AddressFormPage address;
	
	//@BeforeSuite
	//@BeforeTest
	
	@BeforeClass
	public void classConfiguration()
	{
		property=new PropertiesUtility();
		excel=new ExcelUtility();
		jutil=new JavaUtility();
		webutil=new WebdriverUtility();
		
		property.propertiesInit(IConstantPath.pROPERTIES_PATH);
		excel.excelInit(IConstantPath.EXCEL_PATH);
	}
	
	@BeforeMethod
	public void methodConfiguration()
	{
		driver=webutil.navigateToApp(property.getData("browser"), property.getData("url"),Long.parseLong(property.getData("time")));
		sdriver=driver;
		
		welcome=new WelcomePage(driver);
		login=new ShopperLoginPage(driver);
		home=new HomePage(driver);
		signUp=new SignUpPages(driver);
		myprofile=new myprofilepage(driver);
		myAddress=
	}
	

}
