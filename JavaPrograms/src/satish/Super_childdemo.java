package satish;

public class Super_childdemo extends Super_parentdemo

{
	String name=" QA clickAcademy";
	public Super_childdemo()
	
	{
		super();
		System.out.println("am in child demo");
	}
	public void getStringdata()  //2. defining a method
	{
		super.getData(); // related to method
		System.out.println("iam in child class"); // related to method
		System.out.println(name);
		System.out.println(super.name);
		
	}
	
	

	public static void main(String[] args)
	{
		
		Super_childdemo cd=new Super_childdemo();
		cd.getStringdata(); // this is childdemo 
		cd.getData(); // this is parent demo
	}

}




/*public void getStringdata()  //2. defining a method
{
super.getData();         //  related to method
System.out.println("iam in child class"); // related to method  




public Super_childdemo()     // 3. defining constructor 
	{
	    super(); // whenever your in child demo we have to right in above it goes to parent class when ever using "Super"constructor always should be in first line
		System.out.println("am in child demo");
	}
	  */









