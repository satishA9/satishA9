package testngwithpom;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Sendsmspage 
{
       public WebDriver driver;
		@FindBy(name="toMobile")
		public WebElement sendmob;
		@FindBy(name="message")
		public WebElement textsms;
		@FindBy(id="sendButton")
		public WebElement sendsms;
		public Sendsmspage(WebDriver driver)
		{
			this.driver=driver;
			PageFactory.initElements(driver,this);
		}
		public void fillsendmob(String z)
		{
			sendmob.sendKeys(z);
		}
		public void filltextsms(String w)
		{
			textsms.sendKeys(w);
		}
		public void clicksendsms()
		{
			sendsms.click();
		}
	

}
