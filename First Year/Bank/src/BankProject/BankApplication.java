package BankProject;
//:)
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;

public class BankApplication {

	public static void main(String[] args) {
			Bank bank = new Bank(); // create object to rep this class and puts it on heap
			bank.readCustomersFromFile();
			
			/*BankCustomer bankCustomer = new BankCustomer();
			
			bankCustomer.setAccountNumber(124456808); //get from customer
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
			
			bank.customerMap.put(new Long(Bank.account++),bankCustomer);
			bank.findCustomer(new Long (9988776));// use class as an object to allow us to call non static method to static main */

		}
	
	}


