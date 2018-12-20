package satti;

import java.io.File;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;

import jxl.Sheet;
import jxl.Workbook;
import jxl.write.Alignment;
import jxl.write.Label;
import jxl.write.WritableCellFormat;
import jxl.write.WritableSheet;
import jxl.write.WritableWorkbook;

public class MyRunner 
{

	public static void main(String[] args) throws Exception
	{
		// Connect to Excel File
		File f=new File("F:\\Selenium\\keywords1.xls");
		// open excel file for Reading
		Workbook rwb=Workbook.getWorkbook(f);
		Sheet rsh1=rwb.getSheet(0); // 0 for Sheet1
		int nour1=rsh1.getRows(); // no: of used rows and used columns
		int nouc1=rsh1.getColumns();
		Sheet rsh2=rwb.getSheet(1); // 1 for sheet 
		int nour2=rsh2.getRows();
		int nouc2=rsh2.getColumns();
		// Open excel file for Writing 
		WritableWorkbook wwb=Workbook.createWorkbook(f,rwb);
		WritableSheet wsh1=wwb.getSheet(0); // 0 for Sheet1
		WritableSheet wsh2=wwb.getSheet(1); // 0 for Sheet2
		WritableCellFormat cf=new WritableCellFormat();
		cf.setAlignment(Alignment.JUSTIFY);
		cf.setWrap(true); // multiple lines 
		// Set name to Result column in Sheet2
		Date dt=new Date();
		SimpleDateFormat df=new SimpleDateFormat("dd-MM-yyyy-hh-mm-ss");
		String cname=df.format(dt);
		// same name to result column in Sheet1
		Label l1=new Label(nouc1,0,cname,cf);
		wsh1.addCell(l1);
		// set name to result column in sheet2
		Label l2= new Label(nouc2,0,cname,cf);
		wsh2.addCell(l2);
		// create object to method class 
		Mymethods mm= new Mymethods();
		// collect methods info using methods class object 
		Method m[]=mm.getClass().getMethods();
		// Keyword Driven
		try 
		{
			// calling methods one after another 
			// 1st row(index=0) have names of columns is sheet1
			for(int i=1;i<nour1;i++)
			    {
				       int flag=0; // for any step failed
				       // get tid and mode from Sheet1
				       String tid=rsh1.getCell(0, i).getContents();
				       String mode=rsh1.getCell(2, i).getContents();
				       if(mode.equalsIgnoreCase("yes"))
				       {
				    	     //   1st mode(index=0) have names of column in sheet2
				    	           for(int j=1;j<nour2;j++)
				    	            {
				    	        	   
				    		            String sid=rsh2.getCell(0, j).getContents(); // stepid coming id coming from sheet2
				    		     
				    		               if(tid.equalsIgnoreCase(sid))
				    		            
				    		                    {
				    		        	             // take step details from Sheet2
				    			                      String mn=rsh2.getCell(2,j).getContents();
				    			                      String e=rsh2.getCell(3, j).getContents();
				    			                      String d=rsh2.getCell(4, j).getContents();
				    			                      String c=rsh2.getCell(5,j).getContents();
				    			                      System.out.println(mn+""+e+""+d+""+c);
				    			      
				    			                      for(int k=0;k<m.length;k++)
				    			                      {
				    			                          if(m[k].getName().equals(mn))
				    			                            {
				    				                             String r=(String)m[k].invoke(mm,e,d,c);    
				    				                             Label lb= new Label(nouc2,j,r,cf);
				    			 	                             ((WritableSheet) wsh2).addCell(lb);
				    				                             if(r.equals("unknown browser"))
				    				                              {
				    					                            wwb.write();
				    					                            wwb.close();
				    					                            rwb.close();
				    				                               }
				    			                                   if(r.contains("failed") || r.contains("Interrupted"))
				    			                                   {
				    				                                 flag=1;
				    			                                   }
				    			                              }   // if(m[k) loop close
				    			                        }   // k loop        
				    		                      }  //              
				    		     
				    		             }   // j loop close             
				       
				    			 
				    	                     if(flag==0) // all related steps is passed  
				    	                     {
				    	                 	    Label l=new Label(nouc1,i,"passed",cf);
				    	        	            wsh1.addCell(l1);
				    	                     }
				    	                     else
				    	                     {
				    	        	          Label l=new Label(nouc1,i,"failed",cf);
				    	        	          wsh1.addCell(l2);
				    	                     }
				    	         
				           }   // mode loop closing
				       
			     }   // for i closing
			 
		}// try closing
	
		           catch(Exception ex)
		           {
		        	 System.out.println(ex.getMessage());
		        	   
		           }
		           wwb.write();
		           wwb.close();
		           rwb.close();     
		
	}
		
}	
		