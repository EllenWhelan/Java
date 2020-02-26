package BankProject2;

import java.util.ArrayList;

public class BankAccount {
	double balance;
	long accountNumber;
	ArrayList<Transaction> accountTransactions;
	
	
	public BankAccount(long accountNumber) {
		this.accountNumber=accountNumber;
		this.balance=0.0;
		this.accountTransactions=new ArrayList<Transaction>();
		
	}
	public long getAccountNumber() {
		return accountNumber;
	}
	public void setAccountNumber(long accountNumber) {
		this.accountNumber = accountNumber;
	}
	public double getBalance() {
		return balance;
	}
	public void setBalance(double balance) {
		this.balance = balance;
	}
	
	
	public double returnBalance() {
		return balance;
	}
	public void creditBalance(double balance) {
		this.balance += balance;
	}
	public void debitBalance (double balance) {
		this.balance-= balance;
	}
}
