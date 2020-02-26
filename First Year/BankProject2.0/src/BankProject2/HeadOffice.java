package BankProject2;


import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public abstract class HeadOffice {
	String bankName;
	String address;
	private long accountNumber=100000000;
	private int sortCode =991100;
	
	public HeadOffice() {
		writeAccountNumberToFile(this.accountNumber);
		writeSortCodeToFile(this.sortCode);
	}
	
	public long createAccountNumber() {
		long accountNumber =-1;
		FileReader fr;
		try {
			fr = new FileReader("accountNumber.txt");
			BufferedReader br = new BufferedReader(fr);
			boolean endOfFileFound = false;
			while(!endOfFileFound) {
				String accNum=br.readLine();
				if(accNum!=null) accountNumber=Long.parseLong(accNum);
				else endOfFileFound=true;
			}
			
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(accountNumber>0) {
		accountNumber++;
		writeAccountNumberToFile(accountNumber);
		}
		return accountNumber;
		
		
	}
	
public int createSortCode() {
		int sortCode =-1;
		FileReader fr;
		try {
			fr = new FileReader("sortCode.txt");
			BufferedReader br = new BufferedReader(fr);
			boolean endOfFileFound = false;
			while(!endOfFileFound) {
				String sortC=br.readLine();
				if(sortC!=null)sortCode=Integer.parseInt(sortC);
				else endOfFileFound=true;
			}
			
		
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		if(sortCode>0) {
			sortCode++;
			writeSortCodeToFile(sortCode);
		}
		return sortCode;
	
	}
	
	private void writeAccountNumberToFile(long accountNumber) {
		FileWriter fileWrite;
		try {
			fileWrite = new FileWriter("accountNumber.txt");
			BufferedWriter buffWrite = new BufferedWriter(fileWrite);
			buffWrite.write(String.valueOf(this.accountNumber));
			buffWrite.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	private void writeSortCodeToFile(int sortCode) {
		FileWriter fileWrite;
		try {
			fileWrite = new FileWriter("sortCode.txt");
			BufferedWriter buffWrite = new BufferedWriter(fileWrite);
			buffWrite.write(String.valueOf(this.sortCode));
			buffWrite.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
}



