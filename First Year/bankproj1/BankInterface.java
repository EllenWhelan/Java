package bankProject;

import java.util.Date;

public interface BankInterface {
	
	public Long createAccountNumber();
	public BankCustomer findCustomer(long accountNumber);
	public BankCustomer findCustomer(String name, String address, Date dateOfBirth);
	public boolean debitAccount(long accountNumber, double debitAmount);
	public boolean creditAccount(long accountNumber, double creditAmount);
	public void printBalance(long accountNumber);

}
