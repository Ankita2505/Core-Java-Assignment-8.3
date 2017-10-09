package assignment8_3synchronize;
/*
 * application to implement the basic functions for the Online Banking Application 
 * Using synchronization
 */
class OnlineBank extends Thread
{
	Banking bank;
	OnlineBank(Banking bank)
	{
		this.bank=bank;
	}
	public void run()
	{
		bank.deposit(1000);		//Hard coding the deposit and withdrawal amount
		bank.withdraw(100);
	}

}

public class Banking 
{
	//int accountNumber; 
	double accountBalance;

	// to withdraw funds from the account
	public synchronized void withdraw (double amount)  
	{
		double newAccountBalance;

		if( amount > accountBalance)
		{
			//there are not enough funds in the account
			System.out.println("There are not enough fund in account to be withdrawn");
		}

		else
		{
			newAccountBalance = accountBalance - amount;
			accountBalance = newAccountBalance;
			System.out.println("Current balance in account after withdrawn---" + accountBalance);
		}
		try
		{
			Thread.sleep(500);
		}
		catch(Exception e) {}

	}
	//to add funds to bank account
	public synchronized void deposit(double amount) 
	{
		double newAccountBalance;

		if( amount < 0.0)
		{
			System.out.println("Negative amount cannot be deposit");// can not deposit a negative amount
		}

		else
		{
			newAccountBalance = accountBalance + amount;
			accountBalance = newAccountBalance;
			System.out.println("Account Balance after deposit is----" + accountBalance);
		}

		try
		{
			Thread.sleep(1000);
		}
		catch(Exception e) {}
	}
	public static void main(String[] args) //start of main class
	{
		Banking bank = new Banking();//creating object of banking class
		OnlineBank online_bank=new OnlineBank(bank);
		online_bank.start();
		
	}//Close of main class

}


