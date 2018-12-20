package satti;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Loginpage 
{
	public WebDriver driver;
	@FindBy(name="password")
	public WebElement pwd;
	@FindBy(xpath="//*[text()='Next']")
	public WebElement pwdnext;
	public Loginpage(WebDriver driver) // constructor 
	{
		this.driver=driver;
		PageFactory.initElements(driver, this);
	}
    public void fillpwd(String x)
    {
     pwd.sendKeys(x);
    }
    public void clickpwdnext ()	
    {
    	pwdnext.click();
    }
	
	
	
	
	
}
