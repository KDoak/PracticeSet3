package base;

import static org.junit.Assert.*;
import org.junit.Test;
import base.Account;
import base.InsufficientFundsException;

public class Tester {

	@Test
	public void getterSetterTester(){ //Testing accessors and mutators.
		Account testAccount = new Account();
		
		testAccount.setId(1122);
		testAccount.setBalance(20000);
		testAccount.setAnnualInterestRate(4.5);
		
		testAccount.getDateCreated();
		System.out.println("ID: " + testAccount.getId());
		System.out.println("Account balance is: $" + testAccount.getBalance());
		System.out.println("Annual interest rate on account is: " + testAccount.getAnnualInterestRate() + "%");
	}
	@Test
	public void withdrawalTester() throws InsufficientFundsException{ //Testing withdraw with and without exception triggers
		Account testAccount = new Account(1122, 20000);
		try {
			testAccount.withdraw(25000);
		} catch (InsufficientFundsException exception) {
			System.out.println("InsufficientFundsException: " + exception.getAmount());
		}
		Account testAccount2 = new Account(1123, 20000);
		testAccount2.withdraw(2500);
		System.out.println("Balance after reasonable withdrawal is: $" + testAccount2.getBalance());
		assertEquals(testAccount2.getBalance(), 17500, 0);
	}
		
	
	@Test
	public void depositTester(){ //Testing deposit
		Account testAccount = new Account(1122, 20000);
		testAccount.deposit(3000);
		
		System.out.println("Balance after deposit is: $" + testAccount.getBalance());
		assertEquals(testAccount.getBalance(), 23000, 0);
		assertEquals(testAccount.deposit(-3), 23000, 0);
	}
	@Test
	public void monthlyInterestTester(){ //Testing getMonthlyInterestRate
		Account testAccount = new Account();
		testAccount.setAnnualInterestRate(4.5);
		testAccount.getMonthlyInterestRate();
		
		System.out.println("Monthly interest is: " + testAccount.getMonthlyInterestRate() + "%");
		assertEquals(testAccount.getMonthlyInterestRate(), (4.5/12), 0.001);
		
	}	
		
	
}
