package ClimbingClubHarnessSystem;

import java.io.FileInputStream;
import java.io.FileNotFoundException;

import javax.swing.JOptionPane;

/* SELF ASSESSMENT


Harness Class: Member variables (8 marks)8
All my data members are declared, private and the ones that don't change are marked as private. I also have a constant for the maximum number of uses of a harness.
Comment:all data members are declared private and getters nd setters are generted so that these values can be accessed by other clasess

Harness Class: Harness constructor 1 & constructor 2 (6 marks)6
I initialise all the variables using the parameters given and set the other members to reasonable default values.
Comment:The first cnstructor takes in all the parameters and makes use of the this keyword. The second take sin only the make model and instructor and sets the other data values to 0 or null where appropriate as if it is  a brand new harness.

Harness Class: checkHarness method (5 marks)5
My method takes an instructor's name as a parameter, and if the harness is not on loan sets the instructor member variable to the given parameter value (assuming the instructor's name is not null/empty). It also resets the number of times the harness was used.
Comment:my method takes a string as a parameter and uses an ifstatemnet to check that the harness i not on loan. Inside the if statement the harness' instructor is set to the strng passed as a parameter and the huse count is reset.

Harness Class: isHarnessOnLoan method (2 marks)2
My method has no parameters and returns the value of the loan status variable.
Comment:a simple if statemnet checks the onLoan value of the harness and returns true or false

Harness Class: canHarnessBeLoaned method (4 marks)4
My method has no parameters and returns true if the harness is not on loan and if the number of times it was used is less than the maximum allowed number of times.
Comment:an if statement checks if either the harness cant be loaned because it is on loan or if it needs to be safety checked fisrt. if neither of these are true then false is returned.

Harness Class: loanHarness method (6 marks)6
My method has a member name as a parameter and it checks if harness can be loaned by using the canHarnessBeLoaned method. If true, it sets the club member value to the parameter value, sets the on loan status to true and increments the number of times used variable.
Comment:takes a string as parameter, makes use of the canHarnessBeloaned method and sets the currentuser to the string passed and sets onLoan to be true.

 
Harness Class: returnHarness method (5 marks)5
My method has no parameters, checks if the harness is on loan, and if so, changes its on-loan status to false, and resets the club member value.
Comment:checks if the harness is actually on loan and resets currentuser to null as well as incrementing useCount. if its not on loan no action is taken

Harness Class: toString method (3 marks)3
My method returns a String representation of all the member variables.
Comment:my method returns a formatted string that can be printed to theconsole or to JOptionPane

HarnessRecords Class: member variables (3 marks)3
I declare the member variable as a private collection of Harnesses 
Comment:the array list of harnesses and the harness stock int variable are private and getters and setters are generated to access them from other classes

HarnessRecords Class: HarnessRecords constructor 1 & 2 (9 marks)9
In the first constructor, I set the member variable to null [1 mark]. In the second constructor, I use the Java I/O to read data from a text file I created containing sets of Harness characteristics. I use these set of characteristics to create Harness objects and add them to the collection. 
Comment:The first contructor creates an empty arraylist and sets harness stock to 0. The sceond constructor takes an input stream as a parameter and uses a buffered reader to read in each line aqnd convert it to a harness object which gets added to the harness records array list. when the next line is null the end of the fil is found and the buffeered reader finishes

HarnessRecords Class: isEmpty method (1 marks)1
I return true if the collection is null/empty and, false otherwise.
Comment:if the array list is null true is returned els false is returned

HarnessRecords Class: addHarness method (5 marks)5
My method takes a Harness object as a parameter and adds the harness to the collection.
Comment:my method adds the harness to the array list

HarnessRecords Class: findHarness method (6 marks)6
My method takes a make and model number as parameters. It checks if a harness with such properties exists and if it does it returns harness object, otherwise returns null.
Comment:a while loop i used to loop through the records array list and if the string make equals the make passed and the model number equals then th eloop is exited and the harness is found. If no harness is found null is returned

HarnessRecords Class: checkHarness method (6 marks)6
must take instructor name, make and model number as parameters and return a Harness. If a harness with the make and model number exists by using the findHarness method and is not on loan, the Harness method checkHarness is called with the instructor name as a parameter and the updated Harness object is returned. If the harness is not available returns null.
Comment: i call the find method and if a harness is found the check harness method from the harness class is called passing the instructor name as a parameter. if no harness is found null is returned

HarnessRecords Class: loanHarness method (7 marks)7
My method takes a club member name as a parameter and looks for an available harness by calling the method canHarnessBeLoaned be loaned. If an available harness is found it is loaned by using the Harness method loanHarness with the club member as a parameter, returning the harness. If there's no available harness null is returned.
Comment:a while loop loops through the records array list and uses the canBeLoaned method to check if each one is available. if on eis found the loanHarness method is called and that harness is returned. If no harness is found then null is returned

HarnessRecords Class: returnHarness method (7 marks)7
My method takes a make and model number as parameters. It checks if a harness with those properties exists by using the findHarness method. If the found harness is not null, it returns the harness object by using Harness method returnHarness, otherwise returns null.
Comment:my method checks that the harness is found and is actually on loan before calling the rteurn harness method and returnign that harness. if the harness isnt found or is not on loan a null value is returned

HarnessRecords Class: removeHarness method (8 marks)8
My method takes a make and model number as parameters and check the collection for a harness with those properties and removes it. It returns the harness object if it is found, otherwise returns null.
Comment:i find the harness and if it is found then the remove method is called and the harness stock is decremented. if theharness is succesfully removed the harness is returned otherwise null is returned.

GUI (Java main line) (5 marks)5
My test class has a menu which implements at least the five points specified using the HarnessRecords class methods.
Comment: I make use of JOptionPane that offers ten options for a user. the ten options make use of the functions written in harness and harnessrecords.

Total: 100/100 */


public class ClimbingClubManager {

	public static void main(String[] args) throws FileNotFoundException {
		FileInputStream fileInput = new FileInputStream("HarnessList.txt");
		HarnessRecords managerRecords = new HarnessRecords(fileInput); // text file
		// managerRecords.printOutRecords();

		boolean finished = false;
		int runProgram = JOptionPane.showConfirmDialog(null, "Welcome! Do you wish to continue?", null,
				JOptionPane.YES_NO_OPTION);
		if (runProgram == JOptionPane.YES_OPTION)
			finished = false;
		else if (runProgram == JOptionPane.NO_OPTION) {
			finished = true;
			JOptionPane.showMessageDialog(null, "Goodbye!");
		}

		while (!finished) {
			int chosenAction = 0;
			String managerInput = JOptionPane.showInputDialog(null,
					"Please enter a number according to the list below to carry out an action. \n"
							+ "1. Add a new harness to the records \n" + "2. Remove a harness from the club \n"
							+ "3. Record a safety check \n" + "4. Check Harness records for safety checks. \n"
							+ "5. Loan a harness to a member \n" + "6. Return a harness from Loan.\n"
							+ "7. See List Of Harnesses Available for Loan. \n" + "8. Find a Harnesss. \n"
							+ "9. See all Harness Records. \n" + "10. Quit the program. \n");
			if (managerInput == null)
				managerInput = "10";

			try {
				chosenAction = Integer.parseInt(managerInput);
			} catch (NumberFormatException e) {
				chosenAction = 11;

			}

			switch (chosenAction) {
			case 1: // add new harness
				managerInput = JOptionPane.showInputDialog(null, "Please enter the make of the harness.");
				if (managerInput == null)
					break;
				String make1 = managerInput;
				managerInput = JOptionPane.showInputDialog(null, "Please enter the model number.");
				if (managerInput == null)
					break;
				int modelNumber1 = Integer.parseInt(managerInput);
				managerInput = JOptionPane.showInputDialog(null,
						"Please enter the instructor's name who carried out the safety check.");
				if (managerInput == null)
					break;
				String instructor1 = managerInput;
				Harness addedHarness = new Harness(make1, modelNumber1, instructor1);
				if (addedHarness != null) {
					managerRecords.addHarness(addedHarness);
					JOptionPane.showMessageDialog(null,
							" Harness Added Succesfully! \n " + addedHarness.harnessDescription());
				} else {
					JOptionPane.showMessageDialog(null, "Harness not created.", null, JOptionPane.ERROR_MESSAGE);
				}

				break;

			case 2:// remove harness from club
				managerInput = JOptionPane.showInputDialog(null, "Please enter the make of the harness.");
				if (managerInput == null)
					break;
				String make2 = managerInput;
				managerInput = JOptionPane.showInputDialog(null, "Please enter the model number.");
				if (managerInput == null)
					break;
				int modelNumber2 = Integer.parseInt(managerInput);
				Harness removed = managerRecords.removeHarness(make2, modelNumber2);
				if (removed != null) {

					JOptionPane.showMessageDialog(null,
							" Harness Removed Succesfully! \n " + removed.harnessDescription());
				} else {
					JOptionPane.showMessageDialog(null, "Harness not found.", null, JOptionPane.ERROR_MESSAGE);
				}
				break;

			case 3: // record a safety check
				managerInput = JOptionPane.showInputDialog(null, "Please enter the make of the harness.");
				if (managerInput == null)
					break;
				String make3 = managerInput;
				managerInput = JOptionPane.showInputDialog(null, "Please enter the model number.");
				if (managerInput == null)
					break;
				int modelNumber3 = Integer.parseInt(managerInput);
				managerInput = JOptionPane.showInputDialog(null,
						"Please enter the name of the instructor who carried out the check");
				if (managerInput == null)
					break;
				String instructorName = managerInput;
				Harness check = managerRecords.checkHarness(instructorName, make3, modelNumber3);
				if (check != null) {
					JOptionPane.showMessageDialog(null,
							" Harness check recorded succesfully! \n " + check.harnessDescription());
				} else {
					JOptionPane.showMessageDialog(null, "Harness not found.", null, JOptionPane.ERROR_MESSAGE);
				}
				break;

			case 4:// list of harnesses that need check
				String listForCheck = "The following harnesses need safety checks. \n";
				int needChecks = 0;
				for (int i = 0; i < managerRecords.getHarnessRecords().size(); i++) {
					Harness tempHarness = managerRecords.getHarnessRecords().get(i);
					if (tempHarness.getUseCount()>= 25) {
						listForCheck += tempHarness.harnessDescription() + "\n";
						needChecks++;
					}
				}
				if (needChecks > 0) {
					JOptionPane.showMessageDialog(null, listForCheck);
				} else {
					JOptionPane.showMessageDialog(null, " No checks needed");
				}
				break;

			case 5:// Loan a harness to a club member
				managerInput = JOptionPane.showInputDialog(null, "Please enter the name of the member.");
				if (managerInput == null)
					break;
				String memberLoan = managerInput;
				Harness availableHarness = managerRecords.loanHarness(memberLoan);
				if (availableHarness != null) {
					JOptionPane.showMessageDialog(null, " Harness loaned  to " + memberLoan + " succesfully! \n "
							+ availableHarness.harnessDescription());
				} else {
					JOptionPane.showMessageDialog(null, "No harness available.", null, JOptionPane.ERROR_MESSAGE);
				}
				break;

			case 6:// Return harness from loan
				managerInput = JOptionPane.showInputDialog(null, "Please enter the make of the harness.");
				if (managerInput == null)
					break;
				String make5 = managerInput;
				managerInput = JOptionPane.showInputDialog(null, "Please enter the model number.");
				if (managerInput == null)
					break;
				int modelNumber5 = Integer.parseInt(managerInput);
				Harness returned = managerRecords.returnHarness(make5, modelNumber5);
				if (returned != null) {
					JOptionPane.showMessageDialog(null,
							" Harness returned succesfully! \n " + returned.harnessDescription());
				} else {
					JOptionPane.showMessageDialog(null, "Harness not found.", null, JOptionPane.ERROR_MESSAGE);
				}
				break;

			case 7:
				// see list of harness available for loan
				String listAvailable = "The following harnesses are availble. \n";
				int available = 0;
				for (int i = 0; i < managerRecords.getHarnessRecords().size(); i++) {
					Harness tempHarness = managerRecords.getHarnessRecords().get(i);
					if (tempHarness.canHarnessBeLoaned()) {
						listAvailable += tempHarness.harnessDescription() + "\n";
						available++;
					}
				}
				if (available > 0) {
					JOptionPane.showMessageDialog(null, listAvailable);
				} else {
					JOptionPane.showMessageDialog(null, " No Harness' available");
				}
				break;

			case 8: // find a harness see details for particular Harness
				managerInput = JOptionPane.showInputDialog(null, "Please enter the make of the harness.");
				if (managerInput == null)
					break;
				String make6 = managerInput;
				System.out.println(make6);
				managerInput = JOptionPane.showInputDialog(null, "Please enter the model number.");
				if (managerInput == null)
					break;
				int modelNumber6 = Integer.parseInt(managerInput);
				System.out.println(modelNumber6);
				Harness found = managerRecords.findHarness(make6, modelNumber6);
				if (found != null) {
					JOptionPane.showMessageDialog(null, " Harness Found! \n " + found.harnessDescription());
				} else {
					JOptionPane.showMessageDialog(null, "Harness not found.", null, JOptionPane.ERROR_MESSAGE);
				}
				break;
				
			case 9://print out all harnesses
				String printHarness = "The club has the following harnesses. \n";
				for (int i = 0; i < managerRecords.getHarnessRecords().size(); i++) {
					Harness tempHarness = managerRecords.getHarnessRecords().get(i);
					printHarness += "\n" +tempHarness.harnessDescription() + "\n";	
				}
				JOptionPane.showMessageDialog(null, printHarness);
				break;

			case 10: // quit the program
				finished = true;
				JOptionPane.showMessageDialog(null, "Goodbye!");
				break;

			default:
				JOptionPane.showMessageDialog(null, "Please enter a number from the list", null,
						JOptionPane.ERROR_MESSAGE);
			}
		}

	}
}
