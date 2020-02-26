 import java.util.Scanner;
 import javax.swing.JOptionPane;

public class AverageSd {

	public static void main(String[] args) {

		String input = JOptionPane.showInputDialog("Enter three numbers in the form: (number 1 : number 2 : number 3)");
		Scanner inputScanner = new Scanner( input );
		inputScanner.useDelimiter (":");
		double number1 = inputScanner.nextDouble();
		double number2 = inputScanner.nextDouble();
		double number3 = inputScanner.nextDouble();
		inputScanner.close();

		double average = (number1 + number2 + number3) / 3.0;
		double variance = ((number1-average)*(number1-average) +
						   (number2-average)*(number2-average) +
						   (number3-average)*(number3-average)) / 3.0;
		double standardDeviation = Math.sqrt( variance );

		JOptionPane.showMessageDialog(null, "For numbers " + number1 + ", " +
				number2 + ", " + number3 + ", the average is " + average + 
				" and the standard deviation is " + standardDeviation );
	}

}





