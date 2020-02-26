
public class ComputeFactoial {
	//this function will compute the factorial of a number passed as a parameter. It will not work for numbers whose 
	//factorial is greater than the ,max number in Java, in these cases it will retun a minus number
	public static int computeFactorial (int number)
	{
		int factorial = number;
		if (number-1>=1)
			factorial = factorial * computeFactorial(number-1);
		return factorial;
	}
	public static void main(String[] args) {
		int number = 10;
		System.out.println(computeFactorial(number));	
	}

}
