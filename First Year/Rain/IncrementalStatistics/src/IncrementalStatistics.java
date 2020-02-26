import java.util.Scanner;

/* SELF ASSESSMENT 
1. Did I use easy-to-understand meaningful variable names? 
    Mark out of 10: 10
2. Did I format the variable names properly (in lowerCamelCase)? 
    Mark out of 5: 5
3. Did I indent the code appropriately? 
    Mark out of 10: 10
4. Did I input the numbers one at a time from the command line?
    Mark out of 10:10  
5. Did I check the input to ensure that invalid input was handled appropriately?
    Mark out of 10:  10
6. Did I use an appropriate while or do-while loop to allow the user to enter numbers until they entered exit/quit?
    Mark out of 20:  20
7. Did I implement the loop body correctly so that the average and variance were updated and output appropriately?
    Mark out of 30:  30
8. How well did I complete this self-assessment? 
    Mark out of 5: 5
Total Mark out of 100 (Add all the previous marks): 100
*/


public class IncrementalStatistics {

	public static void main(String[] args) {
		
		System.out.print ("Enter a number (or type 'exit'):");
		Scanner inputScanner = new Scanner (System.in);
		double currentAverage = 0;
		double currentVariance = 0;
		int count =1;
		
		while (inputScanner.hasNextDouble())
		{
		  
				double currentNumber = inputScanner.nextInt() ;
				double newAverage = currentAverage + ((currentNumber) - currentAverage)
						/ count;
				double newVariance = ((currentVariance * (count - 1)) 
						+((currentNumber - currentAverage) * (currentNumber - newAverage)) )
						/ count;
				currentAverage = newAverage;
				currentVariance = newVariance;
				count++;
				System.out.println("So far the average is " + newAverage + " and the variance is "
						+ newVariance + "\n Enter another number (or type 'exit'):" );
				inputScanner = new Scanner (System.in);	
			
		}
		if (inputScanner.hasNext("exit") || inputScanner.hasNext("quit"))
		{
			System.out.println ("Goodbye.");
		}
		else 
		{
			System.out.println("Error: No numbers entered. Please enter numbers eg 1,2,3 etc.");
			main(null);
		}
		inputScanner.close();
			
	
		
		// TODO Auto-generated method stub

	}

}
