package BankProject;
//:)
import java.util.Date;

public interface BankInterface {

public long createAccountNumber();
public Customer findCustomer(long accountnumber);
public Customer findCustomer(String name, Date dateOfBirth, String address);
public boolean debitAccount(long accountNumber, double debitAmount);
public boolean  creditAccount(long accountNumber, double creditAmount);
public void printBalance(long accountNumber);//, double debitAmount);

}