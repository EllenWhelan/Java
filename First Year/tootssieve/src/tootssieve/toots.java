/* SELF ASSESSMENT 
   1. createSequence:
Did I use the correct method definition?
Mark out of 5: 5
Comment: It purpose is to create an array of integers which is defined as the return type. The array is to be from 2: a number entered by the user (N) which is defined as a parameter,
Did I create an array of size n (passed as the parameter) and initialise it?
Mark out of 5: 5
Comment: The Array goes from 2:n 
Did I return the correct item?
Mark out of 5: 5
Comment: I returned an array of integers
   2. crossOutMultiples
Did I use the correct method definition?
Mark out of 5: 5
Comment: The crossOutMultiples method has correct parameters and a return type that are suited to its function
Did I ensure the parameters are not null and one of them is a valid index into the array
Mark out of 2:2
Comment: i used an if statement to check if the array was null and checked the primeNumber during on the conditions on a loop
Did I loop through the array using the correct multiple?
Mark out of 5: 5
Comment: The loop goes through the rest of the array looking for multiples of the primeNumber found.
Did I cross out correct items in the array that were not already crossed out?
Mark out of 3: 3
Comment: The multiples of the prime number were crossed out.
   3. sieve   
Did I have the correct function definition?
Mark out of 5: 5
Comment: The sieve method has correct parameters and a return type that are suited to its function
Did I make calls to other methods?
Mark out of 5: 5
Comment:      I call the crossOutMultiples method and the nonCrossedSubSeqToString method but I call the sequenceTostring method in the cross out multiples method so that it is only called if new multiples have been crossed out.
Did I return an array with all non-prime numbers are crossed out?
Mark out of 2: 0
Comment: It does not have a return type because I think in this case it doesn't need one. The method calls on other functions to print out inside of itself so there is no need for the sequence array once it has terminated.
   4. sequenceTostring  
Did I have the correct function definition?
Mark out of 5: 5
Comment: The sequenceTostring method has correct parameters and a return type that are suited to its function
Did I ensure the parameter to be used is not null?
Mark out of 3: 3
Comment: I used an if statement
Did I Loop through the array updating the String variable with the non-crossed out numbers and the crossed numbers in brackets? 
Mark out of 10: 10
Comment:    I used a for loop and an if-elseif statement
   5. nonCrossedOutSubseqToString  
Did I have the correct function definition
Mark out of 5: 5
Comment:  The nonCrossedOutSubseqToString method has correct parameters and a return type that are suited to its function    
Did I ensure the parameter to be used is not null?  
Mark out of 3: 3
Comment: I used an if statement to check that the sequence array was not null
Did I loop through the array updating the String variable with just the non-crossed out numbers? 
Mark out of 5: 5
Comment: I used a for loop
   6. main  
Did I ask  the user for input n and handles input errors?  
Mark out of 5: 3
Comments: I only handled one error in user input
Did I make calls to other methods (at least one)?
Mark out of 5: 0
Comment:  No because I called the methods to print out the sequence within the sieve and crossOutMultiples functions.
Did I print the output as shown in the question?  
Mark out of 5: 5
Comment: My output is as shown in the question 
   7. Overall
Is my code indented correctly?
Mark out of 4: 4
Comments: the code is indented as indicated in the coding standard
Do my variable names make sense?
Mark out of 4: 4
Comments: The variable names are easy to understand
Do my variable names, method names and class name follow the Java coding standard
Mark out of 4: 4
Comments: they follow the standard
      Total Mark out of 100 (Add all the previous marks): 91
*/

package tootssieve;
import java.util.Scanner;
public class toots {
	public static int[] createSequence(int N)
	{
		int[] sequence= new int[N-1];
		for (int index=0; index<sequence.length; index++)
		{
			sequence[index]= index+2;
		}
		return sequence;
	}
	public static int[] crossOutHigherMultiples(int[] sequence, int primeNumber)
	{ 
		if (sequence != null) {
			boolean sequenceIncludesMultiples=false;
			for (int index=0; index<sequence.length; index++)
			{
				if (sequence[index]%primeNumber==0 && sequence[index]>primeNumber)
				{
					sequence[index]=0;
					sequenceIncludesMultiples=true;
				}
			}
			if (sequenceIncludesMultiples)
			{
				System.out.println(sequenceToString(sequence));
			}
		}
		
		return sequence;
	}
	public static void sieve(int N)
	{
		int[] sequence = createSequence(N);
		System.out.println(sequenceToString(sequence));
		for (int index=0; index<sequence.length; index++)
		{
			boolean prime = true;
			for (int divisor=2; prime && divisor<sequence[index]; divisor++)
			{
				if (sequence[index]%divisor==0 && sequence[index]!=0)
				{
					prime=false;
				}
			}
			if (prime && sequence[index]!=0)
			{
				sequence= crossOutHigherMultiples(sequence, sequence[index]);
			}	
		}
		System.out.println(nonCrossedSubSeqToString(sequence));
	}
	public static String sequenceToString(int[] seq)
	{
		String seqString ="";
		if (seq != null) {
			int[] sequence2 = new int[seq.length];
			int index=0;
			for (index=0; index<seq.length; index++)
			{
				sequence2[index]=index+2;
			}
			for (index=0; index<seq.length; index++)
			{
				String myString = Integer.toString(sequence2[index]);
				if (seq[index]!=0)
				{
					seqString+= myString + ", ";
				}
				else if (seq[index]==0)
				{
					seqString += "[" + myString + "], ";
				}
			}
		}
		return seqString;
	}
	public static String nonCrossedSubSeqToString(int[] seq)
	{
		String seqString="";
		if (seq != null) {
			for (int index=0; index<seq.length; index++)
			{
				if (seq[index]!=0)
						seqString+=seq[index]+ ", ";
			}
		}
		return seqString;
	}
	public static void main(String[] args)
	{
		System.out.println("Enter your number: ");
		Scanner inputScanner =new Scanner(System.in);
		if (inputScanner.hasNextInt())
		{
			int N =inputScanner.nextInt();
			sieve(N);
		}
		inputScanner.close();
		
	}

}
