  import javax.swing.JOptionPane;
  import java.util.Scanner;
  
public class HellName2 {

	public static void main(String[] args) {
		
		String nameInput = JOptionPane.showInputDialog ("What is your name?");
		Scanner inputScanner1 = new Scanner (nameInput);
		String name = inputScanner1.next();
		
		JOptionPane.showMessageDialog (null, "Hello " + name );
		
		// TODO Auto-generated method stub

	}

}
