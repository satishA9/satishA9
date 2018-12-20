package satti;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage
{

	public WebDriver Driver;
	@FindBy(name="identifier")
	public WebElement uid;
	@FindBy(xpath="//*[text()='Next']")
	WebElement uidnext;
	public Homepage(WebDriver driver)
	{
		this.Driver=driver;
		PageFactory.initElements(driver, this);
	}
	
	public void filluid(String x)
	{
		uid.sendKeys();
	}
	public void clickuidnext()
	{
	uidnext.click();	
	}
	
	
	
	
}
