  import java.util.Scanner;
  import javax.swing.JOptionPane;
  
public class BMIcalculator2 {

	public static void main(String[] args) {
		
		System.out.print("What is your weight in kilograms?");
		Scanner inputScanner = new Scanner (System.in);
		double weight = inputScanner.nextDouble();
		
		System.out.print("What is your height in meters?");
		Scanner inputScanner1 = new Scanner (System.in);
		double height = inputScanner1.nextDouble();
		
		double squareheight = height * height;
		double BMI = weight / squareheight;
		
		System.out.println ("Your BMI is " + BMI);
		// TODO Auto-generated method stub

	}

}
