package BankProject2;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;


public class Branch extends HeadOffice{
	String address;
	String manager;
	
	
	
	//public static final int SORT_CODE = 99122;
	public ArrayList<Customer>customerList ;
	
	public Branch() {
		 customerList =new ArrayList<Customer>();
	}
	
	public long createAccount(String accountType, Customer customer) {
		long accountNumber=0;
		if(accountType.equals(BankConstants.CURRENT_ACCOUNT) ||accountType.equals(BankConstants.SAVINGS_ACCOUNT)){
			accountNumber=createAccountNumber();
			if(accountType.equals(BankConstants.CURRENT_ACCOUNT)) {
				CurrentAccount currentAccount =  new CurrentAccount(accountNumber);
				customer.getCustomerAccounts().add(currentAccount);
				
			}
			else if(accountType.equals(BankConstants.SAVINGS_ACCOUNT)) {
				SavingsAccount savingsAccount = new SavingsAccount(accountNumber);
				customer.getCustomerAccounts().add(savingsAccount);
			}
	
		}
		return accountNumber;
	}
	public BankAccount getAccount(long accountNumber, Customer customer) {
		BankAccount bankAccount = null;
		if(customer!=null && accountNumber>0 ) {
			boolean accountFound = false;
			int count =0;
			while(!accountFound && count<customer.getCustomerAccounts().size()) {
				bankAccount = customer.getCustomerAccounts().get(count);
				if(bankAccount.getAccountNumber()==accountNumber) {
					accountFound=true;
				}
				count++;
			}
			if(!accountFound) {
				bankAccount = null;
			}
		}
		return bankAccount;
	}
	
	public void creditAccount(BankAccount bankAccount, double amount) {
		if(bankAccount!=null && amount>0) {
			bankAccount.creditBalance(amount);
			
		}
		//else return false;
		
	}
	
	public void debitAccount(BankAccount bankAccount, double amount) {
		if(bankAccount!=null && amount>0) {
			bankAccount.debitBalance(amount);
			
		}
		//else return false;
		
	}
	
	public Customer createCustomer(String name, String addresss, String email, String dateOfBirth) {
		DateFormat formatter = new SimpleDateFormat("dd-MM-yyyy");
		Date birthDate = null;
		try {
			birthDate=formatter.parse(dateOfBirth);
		}
		catch(ParseException e) {
			e.printStackTrace();
			
		}
		Customer newCustomer = new Customer(name, address, email, birthDate);
		customerList.add(newCustomer);
		return newCustomer;
		
	}
	
	public Customer getCustomer(long accountNumber) { //only use for loop of know yiure looping through shwhile things if gonna break out use while
		boolean customerFound = false;
		Customer tempCustomer =null;
		int count = 0;
		while(!customerFound && count <customerList.size()) {
			tempCustomer = customerList.get(count);
			ArrayList<BankAccount> customerAccount= tempCustomer.getCustomerAccounts();
			boolean accountFound = false;
			int count2 =0;
			while(!accountFound && count2<customerAccount.size()) {
				if(customerAccount.get(count2).getAccountNumber() ==accountNumber) {
					accountFound = true;
					customerFound = true;
				}
				count2++;
			}
			count++;
			
		}
		if(!customerFound) {
			tempCustomer=null;
		}
		return tempCustomer;
		
	}

}
