  import java.util.Scanner;
  import javax.swing.JOptionPane;
  
  /*  SELF ASSESSMENT
  1. Did I use appropriate CONSTANTS instead of numbers within the code?
      Mark out of 10:   
  2. Did I use easy-to-understand, meaningful CONSTANT names?
      Mark out of 5:  
   3. Did I format the CONSTANT names properly (in UPPERCASE)?
      Mark out of 5:  
  4. Did I use easy-to-understand meaningful variable names?
      Mark out of 10:  
  5. Did I format the variable names properly (in lowerCamelCase)?
      Mark out of 10:  
  6. Did I indent the code appropriately?
      Mark out of 10:  
  7. Did I read the input correctly from the user using (an) appropriate question(s)?
      Mark out of 10:  
  8. Did I compute the answer correctly for all cases?
      Mark out of 20:  
  9. Did I output the correct answer in the correct format (as shown in the examples)?
      Mark out of 10:  				
  10. How well did I complete this self-assessment?
      Mark out of 10:  
  Total Mark out of 100 (Add all the previous marks):  
  */
  

  
public class SterlingConversions1 {
	
	public static final int NEW_PENNIES_PER_OLD_PENNY = 67;
	public static final int OLD_PENNIES_PER_OLD_SHILLING = 12;
	public static final int OLD_SHILLINGS_PER_OLD_POUND = 20;
	public static final int NEW_PENNIES_PER_NEW_POUND = 100;
	
	public static void main(String[] args) {
		
		String input = JOptionPane.showInputDialog ("Enter the old sterling amount seperated by spaces in"
				+ " the form : \n pounds shillings pence");
		Scanner inputScanner = new Scanner (input);
		double oldPounds = inputScanner.nextDouble();
		double oldShillings = inputScanner.nextDouble();
		double oldPence = inputScanner.nextDouble();
		inputScanner.close();
		
		double newPence = ((oldPence * NEW_PENNIES_PER_OLD_PENNY)
				/ NEW_PENNIES_PER_NEW_POUND );
		double newShillings = (((oldShillings * OLD_PENNIES_PER_OLD_SHILLING )
				* NEW_PENNIES_PER_OLD_PENNY )
				/ NEW_PENNIES_PER_NEW_POUND ) ;
		double newPounds = ((((oldPounds * OLD_SHILLINGS_PER_OLD_POUND)
				* OLD_PENNIES_PER_OLD_SHILLING)
				* NEW_PENNIES_PER_OLD_PENNY) 
				/ NEW_PENNIES_PER_NEW_POUND);
		double output = newPence + newShillings + newPounds;
		
		JOptionPane.showMessageDialog(null, oldPounds + " old pound, " + oldShillings + " old shilling and " + 
		        oldPence + " old pence = " + "£" + output );
		
		
		
		// TODO Auto-generated method stub

	}

}
