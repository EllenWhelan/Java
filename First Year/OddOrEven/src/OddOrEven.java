import java.util.Scanner;

public class OddOrEven {

	public static void main(String[] args) {
		
		System.out.print("Enter a number.");
		Scanner inputScanner = new Scanner (System.in);
		int number = inputScanner.nextInt();
		System.out.println ("The number "+ number + " is " + ( (number % 2 ==1) ? " odd. " : " even. " ));
		// TODO Auto-generated method stub
 
	}

}
