package testscripts;

import java.util.Map;

import org.testng.Assert;
import org.testng.annotations.Test;

import genericLibraries.BaseClass;

public class AddAddressTest1 extends BaseClass{
	
	@Test
	public void addAddressTest()
	{
		Map<String, String> map=excel.getData("Sheet1","Add Address");
		welcome.clickLoginButton();
		login.loginToApp(map.get("Email"),map.get("password"));
		Thread.sleep(2000);
		home.clickProfileButton();
		Thread.sleep(2000);
		home.selectMyProfile();
		Thread.sleep(2000);
		myProfile.clickMyAddress();
		myAddress.clickAddAddress();
		Thread.sleep(2000);
		Assert.assertEquals(myAddress.getSuccessMessage,"successfully added");
		Thread.sleep(5000);
	

}
