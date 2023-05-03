package bank;

public class SavingAccount extends AccoutPojo
{

	private double interestRate;
	
	
	
	
	
	
	public SavingAccount() {
		super();
		// TODO Auto-generated constructor stub
	}

	public SavingAccount(int accNo, double interestRate)
	{
		super(accNo);
		this.interestRate = interestRate;
	}
	
	
	

	public double getInterestRate() {
		return interestRate;
	}

	public void setInterestRate(double interestRate) {
		this.interestRate = interestRate;
	}
	
	
	public double calInterest()
	{
		return balance*interestRate;
	}
	
	
	public void applyInterest()
	{
		double interest = calInterest();
		System.out.println("Interest amount added"+interest);
		deposit(interest);
	}

	@Override
	public void deposit(double amount) 
	{
		if(amount>0)
		{
			balance += amount;
			System.out.println("Amount Deposited"+amount);
			System.out.println("current balance"+balance);
		}
		else
		{
			System.out.println("You have entered invalid amount");
		}
		
		
	}

	@Override
	public void withdrow(double amount) 
	{
		if(amount > 0)
		{
			if(amount <= balance)
			{
				System.out.println("amounnt withdrawn"+amount);
				balance -= amount;
				System.out.println("Current balance");
			
			}
			
		}
		else
		{
			System.out.println("You have entered Invalid amount");
		}
		
	}

}
