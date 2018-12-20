package satish;


import java.util.Scanner;

public class Program {

	public static void main(String[] args) 
	{
		String x[]=new String[5];
	//	Fill array with 5 strings 
		Scanner sc=new Scanner(System.in);
		for(int i=0;i<=5;i++)
		{
			System.out.println("Enter" +(i+1)+ "word");
			x[i]=sc.nextLine();
		}
	// sorting 
		for(int i=0;i<=5;i++)
		{
			for(int j=0;j<4;j++)
			{
				if(x[j].compareTo(x[j+1])>0)
						
				{
					String temp=x[j];
					x[j]=x[j+1];
					x[j+1]=temp;
				}
			}
		}
	// display string after arrays 
		for(int i=0;i<5;i++)
		{
			System.out.println(x[i]+" ");
		}
		
		
}

}
