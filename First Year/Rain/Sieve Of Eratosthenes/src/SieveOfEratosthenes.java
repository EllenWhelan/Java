import java.util.Scanner;
/* SELF ASSESSMENT 
1. createSequence:
Did I use the correct method definition?
Mark out of 5:5
Comment: I used the correct method defintion with the correct return type and parameters.
Did I create an array of size n (passed as the parameter) and initialise it?
Mark out of 5:5
Comment:The array of all the numbers from 2 to max number n is created and initialised within the function and returned to the main line.
Did I return the correct item?
Mark out of 5:5
Comment:The array is returned to the mainline array called array1.
2. crossOutMultiples
Did I use the correct method definition?
Mark out of 5:5
Comment:The method defintion has the right name return type and parameters.
Did I ensure the parameters are not null and one of them is a valid index into the array
Mark out of 2:2
Comment:neither of the parameters can be null and the array created in createSequence is one of the parameters ensuring one of the parameters to be an array.
Did I loop through the array using the correct multiple?
Mark out of 5:5
Comment:The program takes the current multiple n from sieve method and starts dividing from the next number in the array from n.
Did I cross out correct items in the array that were not already crossed out?
Mark out of 3:2
Comment:I replaced the correct items with a zero and later used the index to realise what numbers they were originally.
3. sieve   
Did I have the correct function definition?
Mark out of 5:5
Comment:correct parameters return type and name are all used.
Did I make calls to other methods?
Mark out of 5:5
Comment:      I looped through the multiples n and called to crossOutHigherMultiples for each n.
Did I return an array with all non-prime numbers are crossed out?
Mark out of 2:1
Comment:All the prime numbers are replaced with zero instead of being crossed out
4. sequenceTostring  
Did I have the correct function definition?
Mark out of 5:5
Comment:correct parameter correct name and return type.
Did I ensure the parameter to be used is not null?
Mark out of 3:3
Comment: I checked first if the array2 was null and nothing is carrie out if it is null.
Did I Loop through the array updating the String variable with the non-crossed out numbers and the crossed numbers in brackets? 
Mark out of 10:10
Comment:    The full array is run through in a loop and each element is added to the string.
5. nonCrossedOutSubseqToString  
Did I have the correct function definition
Mark out of 5:5
Comment:correct name parameters and return type. 
Did I ensure the parameter to be used is not null?  
Mark out of 3:3
Comment:if statement used to check array2 is not  null before the code runs
Did I loop through the array updating the String variable with just the non-crossed out numbers? 
Mark out of 5:5
Comment:each element is checked if crossed out or not and added to the string if not crossed out.
6. main  
Did I ask  the user for input n and handles input errors?  
Mark out of 5:3
Comments:I correctly obtain user input and check if its an integer.
Did I make calls to other methods (at least one)?
Mark out of 5:5
Comment:  I call the other methods from the mainline.
Did I print the output as shown in the question?  
Mark out of 5:5
Comment:  Thge output is printed as shown.
7. Overall
Is my code indented correctly?
Mark out of 4:3
Comments:The code is correctly indented
Do my variable names make sense?
Mark out of 4:3
Comments:Perhaps some of them are a little hard to understand.
Do my variable names, method names and class name follow the Java coding standard
Mark out of 4:4
Comments:They follow the coding standard to the best of my knowledge.
   Total Mark out of 100 (Add all the previous marks): 94
*/
public class SieveOfEratosthenes {

	public static void main(String[] args) {
		System.out.print("Please enter the maximum number for the list of prime numbers"
				+ ":");
		Scanner input = new Scanner (System.in);
		if(input.hasNextInt())
		{
	
				int maxNumber = input.nextInt();
				input.close();
				int[] array1 = createSequence(maxNumber);
				int[] array2 = sieve(maxNumber, array1);
				String outputAll = sequenceToString(array2);
				String primeOutput = nonCrossedOutSubseqToString(array2);
				System.out.println ("The full list of numbers up to " + maxNumber + 
						" with the prime numbers in brackets is as follows: " + outputAll);
				System.out.println("The full list of prime numbers from 2 to " + maxNumber 
						+ " is as follows: " +primeOutput);
				
		}
		else 
		{
			System.out.println("Error: please enter a number.");
						
		}
		
	}

	public static String nonCrossedOutSubseqToString(int[] array2) 
	{
		String primeOutput = "";
		if(array2 != null)
			{
	
				for (int index =0 ; index < array2.length-2 ; index++)
				{
					if ((index + 2) < array2.length)
					{
						if (array2[index] !=0) primeOutput +=  array2[index] + ", ";
					}
					else if((index +2) ==array2.length) primeOutput+= array2[index]; 
				}
				primeOutput += ".";
	}
		return primeOutput;
	}

	public static String sequenceToString(int [] array2)
	{
		String outputAll = "";
		if (array2!=null)
			{
					
				
				for (int index =0; index < array2.length -2; index++)
				{
					if ((index + 2) < array2.length)
					{
						if (array2[index] !=0) outputAll += array2[index] + ", ";
						else if (array2[index] == 0) outputAll += "[" + (index +2) +"] , ";
					}
					else if ((index + 2)== array2.length) outputAll += array2[index] ;
				}
				outputAll += ".";
				
			}
		return outputAll;
	}

	public static int[] crossOutHigherMultiples (int[]array2, int n)
	{
		if (array2 [n-2] !=0)
		{
			for (int index = n-1 ; index < array2.length ; index++)
			{
				if (((array2[index]) % n )==0) array2[index] = 0;
			}
		}
		
		
		return array2;
	}
	
	public static int[] sieve(int maxNumber, int[]array1)
	{
		int[] array2 = array1.clone();
		for (int n =2 ; n <= maxNumber ; n++)
		{
		  array2= crossOutHigherMultiples(array2, n);	
		}

		return array2;
	}

	public static int[] createSequence(int maxNumber) 
	{
		int[]array1 = new int[maxNumber];
		int positionNumber = 2;
		for (int index=0 ; index < array1.length-1 ;index++ )
		{
			array1[index] = positionNumber;
			positionNumber ++;
		}
		array1[maxNumber-1] = 0;
		return array1;
	}

}
