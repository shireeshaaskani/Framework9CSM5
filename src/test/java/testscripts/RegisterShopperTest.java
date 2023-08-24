package testscripts;

import java.util.Map;


import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;



public class RegisterShopperTest extends BaseClass {
	
	@Test
	public void createAccountTest()
	{
		
		welcome.clickLoginButton();
		login.clickCreateAccountButton();
		
		Map<String, String>map=excel.getData("Sheet1","Shopper Registration");
		int randomNum=jutil.generateRandomNum(100);
		//String firstName=map.get("First Name")+randomNum;
		//String lastName=map.get("Last Name")+randomNum;
		String email=randomNum+map.get("Email Address");
		String pwd=map.get("password")+randomNum;
		signUp.createUserAccount(map.get("First Name"),map.get("Last Name"),map.get("Gender"),map.get("phone Number"),email,pwd);
		
	    Thread.sleep(10000);
		
		welcome.clickLoginButton();
		login.loginToApp(email,pwd);
		Thread.sleep(2000);
		Assert.assertTrue(driver.getTitle().contains("Home"));
	}

}
