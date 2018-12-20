package satti;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ExtentRPS {

	public static void main(String[] args) throws Exception
	{
		
		Scanner sc=new Scanner(System.in);
		System.out.println("Enter a word");
		String x= sc.nextLine();
		ExtentReports er=new ExtentReports("satishres.html",false);
		ExtentTest et=er.startTest("satish title test");
		// Launsite
		System.setProperty("webdriver.chrome.driver", "F://chromedriver.exe");
		ChromeDriver ab=new ChromeDriver();
		ab.get("http://www.google.co.in");
		WebDriverWait w=new WebDriverWait(ab,20);
		w.until(ExpectedConditions.visibilityOfElementLocated(By.name("q")));
		ab.findElement(By.name("q")).sendKeys(x,Keys.ENTER);
		String y=ab.getTitle();
		if(y.contains(x))
		{
			File src=ab.getScreenshotAs(OutputType.FILE);
			File dest=new File("cvb.png");
			FileUtils.copyFile(src, dest);
			et.log(LogStatus.PASS,"Title test passed");
			et.log(LogStatus.PASS,et.addScreenCapture("screen.png"));
			
		}
		else
			
		{
			File src1=ab.getScreenshotAs(OutputType.FILE);
			File dest=new File("cvb.png");
			FileUtils.copyFile(src1, dest);
			et.log(LogStatus.FAIL,"Title test passed");
			et.log(LogStatus.FAIL,et.addScreenCapture("screen.png"));
		}

		ab.close();
		er.endTest(et);
		er.flush();
		
		
	}

}
