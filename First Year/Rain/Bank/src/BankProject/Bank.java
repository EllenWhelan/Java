package BankProject;
//:)
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;


public class Bank implements BankInterface {
	
	HashMap<Long, BankCustomer> customerMap;//could make this static 
	static long account; // instance variable
	
	Bank(){
		account=10001;
		customerMap= new HashMap<Long, BankCustomer>();
	}
	
	public static void main(String [] args) {
		 BankCustomer bankCustomer = new BankCustomer();
		 Bank bank = new Bank();
		  
		  bankCustomer.setAccountNumber(124456808);
		  bankCustomer.setSortCode(998877);
		  bankCustomer.setCustomerName("Joe");
		  bankCustomer.setCustomerAddress("Trinity College Dublin");
		  bankCustomer.setCustomerEmail("joe@tcd.ie");
		  SimpleDateFormat formatter = new SimpleDateFormat ("DD/MM/YYYY");
		  try {
		  bankCustomer.setCustomerDateOfBirth(formatter.parse("10/01/1990")); 
		  }
		  catch(ParseException e) {
			  e.printStackTrace(); 
		  }
		  bank.customerMap.put(new Long(9988876),bankCustomer); 
		  bank.findCustomer(new Long (9988776));
	  
	  }

	public void readCustomersFromFile() {
		try {
			FileReader fileReader = new FileReader("customers.txt");
			BufferedReader bufferedReader = new BufferedReader(fileReader);
			boolean endOfFileFound = false;
			while (!endOfFileFound) {
				String customerData = bufferedReader.readLine();
				if (customerData == null) {
					endOfFileFound = true;
				} else {
					SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
					Date dateOfBirth =null;
					String[] customerProperties = customerData.split(",");
					try {
						dateOfBirth = formatter.parse(customerProperties[5]);
					}catch(ParseException e) {
						e.printStackTrace();
					}
					BankCustomer customer1 = new BankCustomer(
						Long.parseLong(customerProperties[0]),
						 Integer.parseInt(customerProperties[1]),
						customerProperties[2],
						customerProperties[3],
						customerProperties[4],
						dateOfBirth,
						Double.parseDouble(customerProperties[6])
						);
										
										
					customer1.setBalance(new Double(customerProperties[6]));
					
					customerMap.put(customer1.getAccountNumber(), customer1);

				}
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}

	}

	public BankCustomer find(long accountNumber) {
		//BankCustomer customer = null;
		//boolean customerFound = false;
		//int count = 0;
		/*
		 * while (!customerFound && count < customerMap.size()) {
		 *  customer = customerMap.get(count); if (customer.getAccountNumber() ==
		 * accountNumber)customerFound = true; } count++;
		 */
		// return customer;
		return customerMap.get(accountNumber);
		}

	public BankCustomer find(String customerName, Date customerDateOfBirth, String customerAddress) {
		BankCustomer customer = null;
		boolean customerFound = false;
		int count = 0;
		while (!customerFound && count < customerMap.size()) {
			customer = customerMap.get(count);
			if ((customer.getCustomerName().equals(customerName))
					&& (customer.getCustomerDateOfBirth().equals(customerDateOfBirth))
					&& customer.getCustomerAddress().equals(customerAddress))
				customerFound = true;
		}
		count++;
		return customer;
	}

	@Override
	public long createAccountNumber() {
		// TODO Auto-generated method stub
		return account++;
	}
	

	@Override
	public boolean debitAccount(long accountNumber, double debitAmount) {
		BankCustomer customer = findCustomer(accountNumber);
		boolean accountDebited = false;
		double balance = customer.getBalance();
		if(balance>= debitAmount) {
		String type = "debit";
		Transactions myTransaction = new Transactions(Calendar.getInstance().getTime(),type,debitAmount,balance - debitAmount);
		
		ArrayList<Transactions> transactionsList = customer.getCustomerTransactions();
		transactionsList.add(myTransaction);
		accountDebited = true;
		}
		else accountDebited = false;

		return accountDebited;
	}

	@Override
	public boolean creditAccount(long accountNumber, double creditAmount) {
		BankCustomer customer = findCustomer(accountNumber);
		customer.setBalance(customer.getBalance() + creditAmount);
		String type = "credit";
		Transactions myTransaction = new Transactions(Calendar.getInstance().getTime(),type,creditAmount,customer.getBalance() - creditAmount);
		ArrayList<Transactions> transationsList = customer.getCustomerTransactions();
		transationsList.add(myTransaction);
		
		return true;
		
	}

	@Override
	public void printBalance(long accountNumber) {
		BankCustomer customer = findCustomer(accountNumber);
		ArrayList<Transactions> transactionList = customer.getCustomerTransactions();
		for(int i = 0; i < transactionList.size(); i++) {
			Transactions customerTransaction = transactionList.get(i);
			System.out.println(customerTransaction.toString());
		}

	}
	
	public ArrayList<Long> getCustomerAccountNumbers()
	{
		ArrayList<Long> customerAccountNumbers = new ArrayList<Long>();
		Set<Long> accountNumbers = customerMap.keySet();
		for(int count=0; count< accountNumbers.size(); count++)
		{
			customerAccountNumbers.add(accountNumbers.get)//???
		}
	}

	
	@Override
	public BankCustomer findCustomer(long accountNumber) {
		// TODO Auto-generated method stub
		return null;
	}
	

	@Override
	public BankCustomer findCustomer(String name, Date dateOfBirth, String address) {
		// TODO Auto-generated method stub
		return null;
	}
	


}
