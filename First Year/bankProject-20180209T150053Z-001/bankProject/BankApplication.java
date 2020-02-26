package bankProject;

import java.text.ParseException;
import java.text.SimpleDateFormat;

public class BankApplication {
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
		bank.bankCustomerMap.put(new Long(bankCustomer.accountNumber++), bankCustomer);
		bank.findCustomer(new Long(12223232));
	}
}
