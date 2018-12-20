package satish;

public class Bankaccount 
{
private double balance;
public void setBalance(double balance)
{
	if(balance<=0) {
		System.out.println("dont enter -ve balance");
	}
	else
	{
		this.balance=balance;
	}
}
public double getBalance()
{
	return balance;
}

}
