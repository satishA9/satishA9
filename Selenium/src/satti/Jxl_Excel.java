package satti;

import java.io.File;
import java.io.IOException;
import java.util.Date;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Label;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class Jxl_Excel {

	public static void main(String[] args) throws Exception
	{
		File f=new File("C:\\Users\\lenovo\\Documents\\Book1.xls");
		Workbook rwb = Workbook.getWorkbook(f);
		Sheet rsh=rwb.getSheet(0);
        int nour=rsh.getRows();
        int nouc=rsh.getColumns();
        // open same excel file for writing
        WritableWorkbook wwb=Workbook.createWorkbook(f,rwb);
        WritableSheet wsh=wwb.getSheet(0); // 0 for sheet1
        //Automation
        try
        {
         Date d=new Date();
        jxl.write.Label l1=new jxl.write.Label(nouc,0,"Result on"+d.toString());
        wsh.addCell(l1);
        //0th row have columns headings
        for(int i=1;i<nour;i++)
        
        	
        {
        	String x=rsh.getCell(0, i).getContents();
        	
        	//Launch site
        	System.setProperty("webdriver.chrome.driver", "F://chromedriver.exe");
        	ChromeDriver ab=new ChromeDriver();
        	ab.get("http://www.google.co.in");
        	WebDriverWait w =new WebDriverWait(ab,20);
        	w.until(ExpectedConditions.visibilityOfElementLocated(By.name("q"))); // search for Locator
        	// search word
        	ab.manage().window().maximize();
        	ab.findElement(By.name("q")).sendKeys(x,Keys.ENTER);
        	// CHECK Title
        	String y=ab.getTitle();
        	if(y.contains(x))
        	{
        		Label c=new Label(nouc,i,"Test Passed");
        		wsh.addCell(c);
        	}
        	else
        	{
        		File src=ab.getScreenshotAs(OutputType.FILE);
        		File dest=new File("failscr on" +d.toString()+".png");
        		FileUtils.copyFile(src, dest);
        		Label l3=new Label(nouc,i,"Test failed:"+dest.getAbsolutePath());
        		wsh.addCell(l3);
        		
        	}
        	ab.close();
        }
        		
        }  		
        		
        catch(Exception ex)	
        {
          System.out.println(ex.getMessage());
        }
        // save and Close excel file
        wwb.write();
        wwb.close();
        rwb.close();
	}

}







