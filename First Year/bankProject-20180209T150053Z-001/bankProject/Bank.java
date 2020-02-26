package bankProject;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;
import java.io.*;


public class Bank implements BankInterface {
	static long account;
	TreeMap<Long, BankCustomer> bankCustomerMap;
	Bank(){
		account = 10001;
		bankCustomerMap = new TreeMap<Long, BankCustomer>();
	}
	

	public static void main(String[] args)
	{
		Bank bank = new Bank();
		
		BankCustomer bankCustomer = new BankCustomer();
		bankCustomer.setAccountNumber(12223232);
		bankCustomer.setSortCode(997452);
		bankCustomer.setCustomerName("Fred");
		bankCustomer.setCustomerEmail("fred@hotmail.ie");
		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy");
		try {
			bankCustomer.setCustomerDateOfBirth(formatter.parse("10/01/1990"));
		}catch(ParseException e) {
			e.printStackTrace();
		}
		bankCustomer.setCustomerAddress("Trinity Hall, Dartry Rd");
		bank.bankCustomerMap.put(new Long(account++), bankCustomer);
		bank.findCustomer(new Long(12223232));
		
	}
	
	
	public void readCustomersFromFile(){
		
		try {
		FileReader fr = new FileReader("/BankProject/customers.txt");
		BufferedReader br = new BufferedReader(fr);
		
		boolean endOfFileFound = false;
		while(!endOfFileFound) {
			String customerData = br.readLine();
			if (customerData == null){
				endOfFileFound = true;
			}
			else {
				SimpleDateFormat formatter = new SimpleDateFormat("dd-mm-yyyy");
				Date dateOfBirth = null;
				String [] customerProperties = customerData.split(",");
				
				try {
					dateOfBirth = formatter.parse(customerProperties[5]);
				}catch(ParseException e) {
					e.printStackTrace();
				}
				BankCustomer customer = new BankCustomer(
				Long.parseLong(customerProperties[0]),
				Integer.parseInt(customerProperties[1]),
				customerProperties[2],
				customerProperties[3],
				customerProperties[4],
				dateOfBirth,
				Double.parseDouble(customerProperties[6])
						);
				customer.setBalance(new Double(customerProperties[6]));
				
				bankCustomerMap.put(customer.getAccountNumber(), customer);
			}
		}
		}catch(FileNotFoundException e) {
			e.printStackTrace();
		}catch(IOException e) {
			e.printStackTrace();
		}
	
	}
	public BankCustomer findC(long accountNumber) {
		//BankCustomer customer = null;
		//boolean customerFound = false;
		//int counter = 0;
		/*while (!customerFound && counter < bankCustomerMap.size()) {
			customer = bankCustomerMap.get(counter);
			if(customer.getAccountNumber() == accountNumber) {
				customerFound = true;
			}
			counter++;
		}*/
		return bankCustomerMap.get(accountNumber);
		}
	public BankCustomer findC(String name, String address, Date birthDate) {
		BankCustomer customer = null;
		boolean customerFound = false;
		int counter = 0;
		while (!customerFound && counter < bankCustomerMap.size()) {
			customer = bankCustomerMap.get(counter);
			if(customer.getCustomerName().equals(name) && 
					customer.getCustomerAddress().equals(address) && 
					customer.getCustomerDateOfBirth().equals(birthDate)) {
				customerFound = true;
			}
			counter++;
		}
		return customer;
		}
	@Override
	public Long createAccountNumber() {
		// TODO Auto-generated method stub
		return account++;
	}

	@Override
	public boolean debitAccount(long accountNumber, double debitAmount) {
		// TODO Auto-generated method stub
		boolean accountDebited = false;
		BankCustomer customer = findCustomer(accountNumber);
		double balance = customer.getBalance();
		if(balance >= debitAmount) {
		String type = "debit";
		Transactions myTransaction = new Transactions(Calendar.getInstance().getTime(),type,debitAmount,balance - debitAmount);
		
		ArrayList<Transactions> transationsList = customer.getCustomerTransactions();
		transationsList.add(myTransaction);
		accountDebited = true;
		}
		else accountDebited = false;
		
		return accountDebited;
	}
	@Override
	public boolean creditAccount(long accountNumber, double creditAmount) {
		// TODO Auto-generated method stub
		BankCustomer customer = findCustomer(accountNumber);
		customer.setBalance(customer.getBalance() + creditAmount);
		String type = "credit";
		Transactions myTransaction = new Transactions(Calendar.getInstance().getTime(),type,creditAmount,customer.getBalance() + creditAmount);
		
		
		ArrayList<Transactions> transationsList = customer.getCustomerTransactions();
		transationsList.add(myTransaction);
		
		return true;
	}
	@Override
	public void printBalance(long accountNumber) {
		// TODO Auto-generated method stub
		BankCustomer customer = findCustomer(accountNumber);
		ArrayList<Transactions> transactionList = customer.getCustomerTransactions();
		for(int i = 0; i < transactionList.size(); i++) {
			Transactions customerTransaction = transactionList.get(i);
			System.out.println(customerTransaction.toString());
		}
	}
	@Override
	public BankCustomer findCustomer(long accountNumber) {
		// TODO Auto-generated method stub
		return null;
	}
	@Override
	public BankCustomer findCustomer(String name, String address, Date dateOfBirth) {
		// TODO Auto-generated method stub
		return null;
	}
	
}

