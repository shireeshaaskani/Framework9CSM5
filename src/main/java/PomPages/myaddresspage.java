package PomPages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class myaddresspage {
	
	//Declaration
	@FindBy(xpath="//button[text()='Add Address']")
	private WebElement addAddressButton;
	//added message
	@FindBy(xpath="div[text()='successfully added']")
	private WebElement successMessage;
	
	//Initialization
	public  void MyAddressPage(WebDriver driver)
	{
		PageFactory.initElements(driver,this);
	}
	
	//Utilization
	public void clickAddAddress()
	{
		addAddressButton.click();
	}
	public String getsuccessMessage()
	{
		return successMessage.getText();
	}

}
