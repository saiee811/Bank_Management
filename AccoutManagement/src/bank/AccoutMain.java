package bank;

import java.util.Scanner;

public class AccoutMain 
{
	
	public static void main(String[] args) 
	{
		Scanner sc = new Scanner(System.in);
		
		AccoutPojo[] account = new AccoutPojo[10];
		int noOfAcc = 0;
		int choice;
		
		do 
		{
			
			choice = menu(sc);
			System.out.println();
			
			
			if(choice==1)
			{
				account[noOfAcc++] = createAccout(sc);
				
			}
			else if(choice==2)
			{
				doDeposit(account,noOfAcc,sc);
				
			}
			else if(choice==3)
			{
				doWithdraw(account,noOfAcc,sc);
			}
			else if(choice==4)
			{
				applyInterest(account, noOfAcc, sc);
			}
			else
			{
				System.out.println("You have entered Invalid choice!!");
			}
			
			System.out.println();
			
		}
		while(choice != 5);
	}
		
		
		public static int menu(Scanner sc)
		{
			System.out.println("**********MENU***********");
			System.out.println("1. Creare Account ");
			System.out.println("2. Deposit Amount ");
			System.out.println("3. WithDraw Amount ");
			System.out.println("4. Apply Interest ");
			System.out.println("5. Quit ");
			
			int choice;
			
			do 
			{
				System.out.println("Enter Choice: ");
				choice = sc.nextInt();
				
			}while(choice < 1 || choice>5);
			
			return choice;
		}
		
		
		public static AccoutPojo createAccout(Scanner sc)
		{
			
			AccoutPojo account = null;
			int choice = accountMenu(sc);
			
			int accNo;
			System.out.println("Enter Account Number: ");
			accNo = sc.nextInt();
			
			if(choice==1)
			{
				System.out.println("Enter transaction fee: ");
				double fee = sc.nextDouble();
				account = new CheckingAccount(accNo, fee);
			}
			else
			{
				System.out.println("Please Enter Interest rate: ");
				double ir = sc.nextDouble();
				account = new SavingAccount(accNo, ir);
				
			}
			return account;
		
		}
		
		public static int accountMenu(Scanner sc)
		{
			System.out.println("Select Account Type: ");
			System.out.println("1. Checking Account ");
			System.out.println("2. Saving Account ");
			
			int choice;
			do {
				System.out.println("Enter Choice: ");
				choice = sc.nextInt();
				
			}while(choice<1 || choice>2);
			
			return choice;
		}
		
		public static void doDeposit(AccoutPojo account[], int count, Scanner sc)
		{
			
			System.out.println("Enter AccountNo : ");
			int accNo = sc.nextInt();
			
			int index = searchAccount(account, count, accNo);
			
			if(index >= 0)
			{
				System.out.println("Please enter the amount you want to deposit: ");
				double amount = sc.nextDouble();
				
				account[index].deposit(amount);
			}
			else
			{
				System.out.println("No account exist with AccountNo ");
			}
		}
		
		public static int searchAccount(AccoutPojo account[],int count, int accNo )
		{
			for(int i=0; i<count;i++)
			{
				if(account[i].getAccNo() == accNo)
				{
					return i;
				}
			}
			return -1;
		}
		
		
		public static void doWithdraw(AccoutPojo account[], int count, Scanner sc)
		{
			System.out.println("Please Enter account No: ");
			int accNo = sc.nextInt();
			
			int index = searchAccount(account, count, accNo);
			
			if(index>=0)
			{
				System.out.println("Please Enter the amount you want to withdraw: ");
				double amount = sc.nextDouble();
				account[index].withdrow(amount);
			}
			else
			{
				System.out.println("Account doesn't exsist");
			}
			
		}
		
		public static void applyInterest(AccoutPojo account[], int count, Scanner sc)
		{
			System.out.println("Please Enter Account No: ");
			int accNo = sc.nextInt();
			
			int index = searchAccount(account, count, accNo);
			
			if(index >=0)
			{
				if(account[index] instanceof SavingAccount)
				{
				((SavingAccount) account[index]).applyInterest();
				}
				else
				{
					System.out.println("Account doesn't exsist");
				}
			}
			
		}
			
			
			
			
			
			
			
			
			
			
				
		

}
