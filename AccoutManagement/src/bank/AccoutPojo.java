package bank;

public abstract class AccoutPojo 
{
	private int accNo;
	protected double balance;
	
	
	
	public int getAccNo() {
		return accNo;
	}

	public void setAccNo(int accNo) {
		this.accNo = accNo;
	}

	public AccoutPojo() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	public AccoutPojo(int accNo)
	{
		this.accNo = accNo;
		balance = 0;
	}

	public double getBalance() {
		return balance;
	}

	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	public abstract void deposit(double amount);
	public abstract void withdrow(double amount);


	
	
	
	
}
