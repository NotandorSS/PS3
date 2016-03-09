package base;

import static org.junit.Assert.*;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;

import exceptions.InsufficientFundsException;

public class Account_Test {

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() throws InsufficientFundsException {
		Account account = new Account();
		account.setId(1122);
		account.setBalance(20000);
		account.setAnnualInterestRate(.045);

		assertEquals(account.getId(),1122);
		assertEquals(account.getBalance(),20000,0.001);
		assertEquals(account.getAnnualInterestRate(),0.045,0.001);

		account.deposit(3000);
		try{
			account.withdraw(2500);}
		catch(InsufficientFundsException e){
			System.out.println("Sorry, but you are short $"+ e.getAmount());}


		System.out.println("The balance is " + account.getBalance());
		System.out.println("The monthly interest rate is " + account.getMonthlyInterestRate());
		System.out.println("The account's creation date is " + account.getDateCreated());

		try{
			account.withdraw(25000);}
		catch(InsufficientFundsException e){
			System.out.println("You are short $"+ e.getAmount());}
	}

}
