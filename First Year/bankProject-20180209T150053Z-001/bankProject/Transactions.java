package bankProject;

import java.util.Date;

public class Transactions {
	private Date transactionDate;
	private String transactionType;
	private double transactionAmount;
	private double closingBalance;
	
	public Transactions(Date date, String type, double amount, double balance) {
		transactionDate = date;
		transactionType = type;
		transactionAmount = amount;
		closingBalance = balance;
	}
	
	public Date getTransactionDate() {
		return transactionDate;
	}
	public void setTransactionDate(Date transactionDate) {
		this.transactionDate = transactionDate;
	}
	public String getTransactionType() {
		return transactionType;
	}
	public void setTransactionType(String transactionType) {
		this.transactionType = transactionType;
	}
	public double getTransactionAmount() {
		return transactionAmount;
	}
	public void setTransactionAmount(double transactionAmount) {
		this.transactionAmount = transactionAmount;
	}
	public double getClosingBalance() {
		return closingBalance;
	}
	public void setClosingBalance(double closingBalance) {
		this.closingBalance = closingBalance;
	}
	@Override
	public String toString() {
		return "Transactions [transactionDate=" + transactionDate + ", transactionType=" + transactionType
				+ ", transactionAmount=" + transactionAmount + ", closingBalance=" + closingBalance + "]";
	}
	
	
	
}
