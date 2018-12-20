package testngwithpom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Homepage 
{
public WebDriver driver;
@FindBy(name="mobileNo")
public WebElement mobno;
@FindBy(name="password")
public WebElement mobpwd;
@FindBy(xpath="(//button[@type='button'])[4]")
public WebElement waylogin;
public Homepage(WebDriver driver)
{
	this.driver=driver;
	PageFactory.initElements(driver,this);
}
public void fillmobno(String x)
{
	mobno.sendKeys(x);
}
public void fillmobpwd(String y)
{
	mobpwd.sendKeys(y);
}
public void clicklogin()
{
	waylogin.click();
}

}
