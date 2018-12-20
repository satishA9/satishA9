package satish;

public class Clerk {

	public static void main(String[] args)
	{
		Bankaccount a1=new Bankaccount();
		a1.setBalance(5000.00);
		System.out.println(a1.getBalance());
		a1.setBalance(-5000);
		System.out.println(a1.getBalance());
		

	}

}
