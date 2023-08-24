package genericLibraries;

import java.time.Duration;
import java.util.HashMap;
import java.util.Set;


import org.openqa.selenium.Alert;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.Select;

public class WebdriverUtility {
	
	private WebDriver driver;
	
	public void navigateToApp(String browser, String url,long time)
	{
		switch(browser)
		{
		case "chrome":
			System.setProperty("webdriver.chrome.driver","C:\\\\Users\\\\DELL\\\\selenium\\\\seleniumscript\\\\server\\\\chromedriver.exe");
			ChromeOptions options=new ChromeOptions();
			HashMap<String, Boolean> prefs=new HashMap<String,Boolean>();
			prefs.put("autofill.profile_enabled",false);
			options.setExperimentalOption("prefs",prefs);
			driver=new ChromeDriver();
			break;
			
		case "firefox":
			driver=new FirefoxDriver();
			break;
			
		case "edge":
			driver=new EdgeDriver();
			break;
			default:
				System.out.println("Invalid browser info");
		}
		driver.manage().window().maximize();
		driver.get(url);
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(time));
	}
	public void mouseHover(WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.moveToElement(element).perform();
	}
	public void doubleClick(WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.doubleClick(element).perform();
	}
	public void rightClick(WebElement element)
	{
		Actions actions=new Actions(driver);
		actions.contextClick(element).perform();
	}
	public void dragAndDropdown(WebElement element,WebElement target)
	{
		Actions actions=new Actions(driver);
		actions.dragAndDrop(element,target).perform();
	}
	public void selectFromDropdown(WebElement element,int index)
	{
		Select select=new Select(element);
		select.selectByIndex(index);
	}
	public void selectFromDropdown(WebElement element,String value)
	{
		Select select=new Select(element);
		select.selectByValue(value);
	}
	public void selectFromDropdown(String text,WebElement element)
	{
		Select select=new Select(element);
		select.selectByVisibleText(text);
	}
	public void switchToFrame(int index)
	{
		driver.switchTo().frame(index);
	}
	public void switchToFrame(String idOrName)
	{
		driver.switchTo().frame(idOrName);
	}
	public void switchToFrame(WebElement frameElement)
	{
		driver.switchTo().frame(frameElement);
	}
	public void switchBackFromFrame()
	{
		driver.switchTo().defaultContent();
	}
	public void scrollTitleElement(WebElement element)
	{
		JavascriptExecutor js=(JavascriptExecutor)driver;
		js.executeScript("arguments[0].scrollIntoViem",element);
	}
	public void handleAlert(String status)
	{
		Alert al=driver.switchTo().alert();
		if(status.equalsIgnoreCase("ok"))
		
			al.accept();
		else
			al.dismiss();
	}
	public void switchToChildBrowser()
	{
		Set<String> set=driver.getWindowHandles();
		for(String s:set)
		{
			driver.switchTo().window(s);
		}
	}
	public void switchToWindow(String id)
	{
		driver.switchTo().window(id);
	}
	public String getParentWindowID()
	{
		return driver.getWindowHandle();
	}
	
	
	
	
	

}
