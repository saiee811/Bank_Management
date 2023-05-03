package bank;

public class CheckingAccount extends AccoutPojo
{
	
	private static double FEE = 2.5;
	
	
	
	
	

	



	public CheckingAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	
	public CheckingAccount(int accNo, double Fee)
	{
		super(accNo);
		FEE = Fee;
	}
	

	@Override
	public void deposit(double amount) 
	{
		if(amount > 0)
		{
			balance+= amount;
			System.out.println("Balance after amount Deposited"+ amount);
			
			balance-= FEE;
			System.out.println("Fee Applied"+ FEE);
			System.out.println("Current Balance"+ balance);
			
		}
		else
		{
			System.out.println("You have entered invalid amount");
		}
		
	}

	@Override
	public void withdrow(double amount) 
	{
		if((amount+FEE)<= balance)
		{
			System.out.println("The Amount you want to withdraw"+amount);
			balance -= amount;
			balance -= FEE;
			System.out.println("Fee appied"+FEE);
			System.out.println("Balance after aithdrawal: "+balance);
		}
		else
		{
			System.out.println("You have entered invalid amount");
		}
		
		
	}

}
