import java.util.Scanner;
/* SELF ASSESSMENT 

Class Rational 
I declared two member variables: numerator and denominator (marks out of 4: 4).
Comment:I created two int variables at the top of the class for numerator and denominator.

Constructor 1 
My program takes take two integers as parameters (for numerator and denominator) and initialises the member variables with the corresponding values . If the denominator is equal to 0 I throw an exception (marks out of 5: 5).
Comment: I use the this keyword to initialise the variables and if the denominator is zero i throw an illegal arguments excxeption.

Constructor 2 
My program takes only one integer as parameter (numerator), and set the numerator to this value . I set the denominator to 1 in this case, as the resulting rational number in this case is an integer (marks out of 3: 3).
Comment: The method takes the numerator parameter and uses the this keyword to set the numerator and sets the denominator to 1

Add Method 
My program takes only a rational number as a parameter and returns a new rational number which has a numerator and denominator which the addition of the two objects - this and the parameter. My program does not overwrite any of the other two rational numbers (marks out of 8: 8).
Comment: I use the this keyword and the rational number passed as a parameter and I use these to create a new numerator and denominator and then a new rational number object using the rational constructor. The original parameter rational and the this rational are unchanged

Subtract Method 
I have implemented this the same as add method, except it implements subtraction (marks out of 8:8 ).
Comment: I again use the this keyword and the parameter rational to create new numerators and denominators and create a new rational using the rational constructor. Both the original rationals remain unchanged

Multiply Method 
I have implemented this the same as add method, except it implements multiplication (marks out of 8: 8).
Comment: Again i use the this keyword and the rational passed as a parameter to create new numerators and denominators and use these as parameters to the rational constructor

Divide Method 
I have implemented this the same as add method, except it implements divide (marks out of 8:8 ).
Comment: I use the this keyword and the paramerer rational to create new numerators and denominators and a new rational object using the rational constructor. the original rationals remain the same.

Equals Method 
My program takes a rational number as a parameter and compares it to the reference object. I only use multiplication between numerators/denominators for the purpose of comparison, as integer division will lead to incorrect results. I return a boolean value ((marks out of 8:8 ).
Comment: I use the this keyword to compare it to the rational parameter. I find the common denominator by multiplying the denominatirs  and then compare the corresponding numerators to see if they are equal.

isLessThan 
My program takes a rational number as a parameter and compares it to the reference object. I only use multiplication as integer division will lead to incorrect results. I return a boolean value (marks out of 8:8 ).
Comment: I use the this keyword to compare the reference object to the parameter rational. I use multiplication to find a common denom, convert the fraction and then compare the numerators.

Simplify Method 
My program returns a rational number but not a new rational number, instead it returns the current reference which is this. It doesn't take any parameters as it works only with the reference object. I first find the greatest common divisor (GCD) between the numerator and denominator, and then obtain the new numerator and denominator by dividing to the GCD (marks out of 8:8 ).
Comment: My method finds the greatest common divider using a while loop in a seperate function and then updates the numerator and denominator of the refernece object. It returns the reference object and does not create a new rational. It takes no parameters and refers to a rational using the this keyword

gcd function 
My program returns the greatest common divider of two integers: the numerator and the denominator (marks out of 6:6 ).
Comment: I use a while loop that terminates when either the denominator or the numerator reaches zero. Inside the loop i repeatedly modulus the numerator and the denominator

toString Method 
My program returns a string showing the fraction representation of the number, eg. "1/2". It takes no parameters (marks out of 4:4 ).
Comment: my methid returns a rational in the form "a/b".It takes no parameters and uses the this keyword to access the numerator and the denominator

Test Client Class 
My program asks the user for two rational numbers, creates two rational objects using the constructor and passing in the provided values, calls addition, subtraction, multiplication, division, comparison and simplification and prints out the results (marks out of 22: 22).
Comment: I get user input for the numerator and the denominator seperately for each rational number. If there is a denominator I call the first rational constructor, if there is not the user types none and I call the second rational constructor. 
I then call all the methods from the rational class and then convert the results to string using the toString method and then print them to the console.
*/

public class Test {

	public static void main(String[] args) {
		Rational rational1= null;
		Rational rational2= null;
		int numerator1;
		int denominator1;
		int numerator2;
		int denominator2;
		
		
		// get first rational number
		System.out.println("Welcome! Please enter the numerator of your first rational number a/b.");
		Scanner input = new Scanner (System.in);
		numerator1 = input.nextInt();
		System.out.println ("Please enter the denominator of your first rational number or type none.");
		if(input.hasNextInt()) {
			denominator1= input.nextInt();
			if (denominator1 ==0)
			{
				System.out.println("Error: the denominator of a rational number cannot be zero. Please enter a non-zero value.");
				denominator1=input.nextInt();
				
			}
			rational1 = new Rational(numerator1, denominator1);
		}
		else if (input.hasNext("none")) {
			rational1 = new Rational(numerator1);
		}
		
		
			
		// second rational number
		System.out.println("Please enter the numerator of your second rational number a/b.");
		Scanner input2 = new Scanner(System.in);
		numerator2 = input2.nextInt();
		System.out.println("Please enter the denominator of your second rational number or type none.");
		if (input2.hasNextInt()) {
			denominator2= input2.nextInt();
			if (denominator2 ==0)
			{
				System.out.println("Error: the denominator of a rational number cannot be zero. Please enter a non-zero value.");
				denominator1=input2.nextInt();
				
			}
			rational2 = new Rational(numerator2, denominator2);
		}
		else if(input2.hasNext("none")) {
			rational2 = new Rational(numerator2);
		}
		
		
		
		
		//testing rational methods
		Rational addition= rational1.add(rational2);
		Rational subtraction = rational1.subtract(rational2);
		Rational multiply = rational1.multiply(rational2);
		Rational divide = rational1.divide(rational2);
		Boolean equals = rational1.equals(rational2);
		Boolean isLessThan = rational1.isLessThan(rational2);
		Rational simplifiedRat1 = rational1.simplify();
		Rational simplifiedRat2 = rational2.simplify();
		String rational1String = rational1.toString();
		String rational2String = rational2.toString();
		
		//printing results back to console 
		System.out.println("Your first rational number was: " + rational1String);
		System.out.println("Your second rational number was: " + rational2String);
		System.out.println("The result of these two numbers added is: " + addition.toString());
		System.out.println("The result of these two numbers subtracted is: " + subtraction.toString());
		System.out.println("The result of these two numbers multiplied is: " + multiply.toString());
		System.out.println("The result of these two numbers divied is: " + divide.toString());
		if (equals) System.out.println(rational1String + " and " + rational2String + " are equal.");
		if (isLessThan) System.out.println(rational1String + " is less than " + rational2String);
		System.out.println(rational1String + " simplified is: " + simplifiedRat1.toString());
		System.out.println(rational2String + " simplified is: " + simplifiedRat2.toString());
		
		input.close();
		input2.close();
		
	
	}

}
