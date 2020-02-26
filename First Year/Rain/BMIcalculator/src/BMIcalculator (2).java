  import javax.swing.JOptionPane;
  import java.util.Scanner;

public class BMIcalculator {

	 public static void main(String[] args) {
		 
		 String weightInput = JOptionPane.showInputDialog ( "What is your weight in kilograms?" );
		 Scanner inputScanner = new Scanner ( weightInput );	
		 double weight = inputScanner.nextDouble();
		 
		 String heightInput = JOptionPane.showInputDialog ("What is your height in meters?");
		 Scanner inputScanner1 = new Scanner ( heightInput);
		 double height = inputScanner1.nextDouble();
		 
		 double squareheight = height * height;
		 double BMI = weight / squareheight;
		 
		 JOptionPane.showMessageDialog (null,"Your BMI is" + BMI );
		 
		// TODO Auto-generated method stu
	}

}
