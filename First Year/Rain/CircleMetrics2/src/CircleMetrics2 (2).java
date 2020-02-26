  import java.util.Scanner;
  
public class CircleMetrics2 {

	public static void main(String[] args) {
		
		System.out.print("What is the radius of the circle?");
		Scanner inputScanner1 = new Scanner (System.in);
		double radius = inputScanner1.nextDouble();
		
		double diameter = radius * 2;
		double circumference = 2 * Math.PI * radius;
		double area = Math.PI * radius * radius;
		
		System.out.println ("For a circle of radius" + radius + "\n Diameter = " + diameter + "\n Circumference = " + circumference + "\n Area = " + area );
		
		
		// TODO Auto-generated method stub

	}

}
