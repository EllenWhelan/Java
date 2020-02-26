import java.util.Scanner;

public class QuadraticFormula {

	public static void main(String[] args) {
		System.out.println(" Enter the coefficients of your second order polynomial separated by spaces (or enter quit):");
		Scanner inputScanner = new Scanner (System.in);
		double x1 =0;
		double x2= 0;
		
		
		
		while (inputScanner.hasNextInt())
		{
			int a= inputScanner.nextInt();
			int b = inputScanner.nextInt();
			int c = inputScanner.nextInt();
			if (a==0)
			{
				x1 = (-1 * c) / b;
			}
			else if (a==0 && b==0)
			{
				System.out.println("Error: Invalid equation.");
			}
			else
			{
				x1 = ((-1 * b) + Math.sqrt((b*b) - (4 *(a *c)))) / (2 * a);
				x2 = ((-1 * b) - Math.sqrt((b*b) - (4 *(a *c)))) / (2 * a);
				if (x1 != x2)
				{
					System.out.println("The roots to this equation are x=" + x1 + " and x=" + x2);
				}
				else if (x1 == x2)
				{
					System.out.println ("There is only root, x=" + x1);
				}
			}
			System.out.println(" Enter the coefficients of your second order polynomial separated by spaces (or enter quit):");
			inputScanner = new Scanner (System.in);
		}
		if (inputScanner.hasNext("quit"))
		{
			System.out.println ("Goodbye.");
		}
		else 
		{
			System.out.print("Error: invalid input");
			main (null);
		}
		inputScanner.close();
			
		// TODO Auto-generated method stub

	}

}
