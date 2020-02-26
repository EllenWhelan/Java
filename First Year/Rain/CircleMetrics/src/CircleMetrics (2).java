  import javax.swing.JOptionPane;
  import java.util.Scanner;

public class CircleMetrics {

	public static void main(String[] args) {
		
		String radiusInput = JOptionPane.showInputDialog("What is the radius of the circle?");
		Scanner inputScanner = new Scanner( radiusInput);
		double radius = inputScanner.nextDouble();
		
		double diameter = radius*2;
		double circumference = 2 * Math.PI * radius;
		double area = Math.PI * radius * radius;
		
		JOptionPane.showMessageDialog(null, "For a circle of radius " + radius + "\n Diamter = " + diameter + "\n Circumference =" + circumference +"\n Area = " + area);
		// TODO Auto-generated method stub

	}

}
