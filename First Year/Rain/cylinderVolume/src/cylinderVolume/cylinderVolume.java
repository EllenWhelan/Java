package cylinderVolume;

  import javax.swing.JOptionPane;
  import java.util.Scanner;

public class cylinderVolume {

	public static void main(String[] args) {
		
		String radiusInput = JOptionPane.showInputDialog("What is the radius of the cyliner?");
		Scanner inputScanner1 = new Scanner (radiusInput);
		double radius = inputScanner1.nextDouble();
		
		String heightInput = JOptionPane.showInputDialog ("What is the height of the cylinder?");
		Scanner inputScanner2 = new Scanner (heightInput);
		double height = inputScanner2.nextDouble();
		
		double squareradius = radius * radius;
		double volume = Math.PI * squareradius * height;
		
		JOptionPane.showMessageDialog (null, "The volume of the cylinder = " + volume );
		
				
				
			
		
		// TODO Auto-generated method stub

	}

}
