import javax.swing.JOptionPane;

/* SELF ASSESSMENT 
1. Did I use easy-to-understand meaningful variable names? 
    Mark out of 10: 9
2. Did I format the variable names properly (in lowerCamelCase)? 
    Mark out of 10: 10
3. Did I indent the code appropriately? 
    Mark out of 10: 10
4. Did I read the input correctly from the user using appropriate questions? 
    Mark out of 20: 18
5. Did I use an appropriate (i.e. not more than necessary) series of if statements? 
    Mark out of 30: 27
6. Did I output the correct answer for each possibility in an easy to read format? 
    Mark out of 15: 14
7. How well did I complete this self-assessment? 
    Mark out of 5: 5
Total Mark out of 100 (Add all the previous marks): 93
*/

public class Rain {

	public static void main(String[] args) {
		int answer = JOptionPane.showConfirmDialog(null,"Is it raining or does it look like it might rain?");
		boolean possibleRain = (answer == JOptionPane.YES_OPTION);
		if (possibleRain)
		{
			answer = JOptionPane.showConfirmDialog(null, "Is it currently raining?");
			boolean yesRain = (answer== JOptionPane.YES_OPTION);
			if (yesRain)
			{
				JOptionPane.showMessageDialog(null,"You should bring an umbrella and you should put it up.");
			}
			else 
			{
				JOptionPane.showMessageDialog(null, "You should bring an umbrella in case it rains, "
						+ "but you may not need to put it up.");
			}
		}
		else 
		{
			JOptionPane.showMessageDialog(null,"You don't need to bring an umbrella.");
		}
		
		// TODO Auto-generated method stub

	}

}