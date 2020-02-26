import java.util.Scanner;

import javax.swing.JOptionPane;

public class PrimeFinder {

	public static void main(String[] args) {
		
		System.out.print("Enter the number of competitors in the race.");
		Scanner inputScanner = new Scanner(System.in);
		int competitors = inputScanner.nextInt();
		int currentNumber = 0;
		boolean prime = true;
		String output= ("");
		
		for (currentNumber = 1; (currentNumber <= competitors); currentNumber++)
		{
			switch (currentNumber)
			{
			case 1: 
				output= ("Prizes will be given to the comptetitors in 1st,");
				break;
			case 2:
				output =( "2nd, " );
				break;
			case 3: 
				output =( "3rd, ");
				break;
			default: 
				for (int divisor=2 ;((divisor < currentNumber) && (prime = true)) ; divisor++)
				{
					if (currentNumber % divisor ==0)
					{
						prime= false;
					}
					else if (currentNumber % divisor !=0) 
					{
						prime= true; 
						output = (currentNumber + "th,");
					}
				}
				break;
				
					
			}
			System.out.println(output);
		}
		
		
	
	}

}
