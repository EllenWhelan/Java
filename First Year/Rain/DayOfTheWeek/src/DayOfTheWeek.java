import java.util.Scanner;
import javax.swing.JOptionPane;
/* SELF ASSESSMENT
1. Did I use appropriate, easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE?
       Mark out of 5:  4 
       Perhaps the names for the superscript are a bit long winded.
2. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)?
       Mark out of 5:  4
       The names used are easy to understand apart from the ones in the formula for the week day name where I
        used the names given in the formula though they do not explain what exactly they are.
3. Did I indent the code appropriately?
       Mark out of 5: 5
       The code is indented clearly to show the structure of the main line and the functions.
4. Did I define the required function correctly (names, parameters & return type) and invoke them correctly?
      Mark out of 20:  20
      The functions created are all correctly invoked and defined.
5. Did I implement the dayOfTheWeek function correctly and in a manner that can be understood?
      Mark out of 20:  18
      the variable names like y, w etc do not state clearly what they are/do but I chose to keep the 
      names as given in the formula to avoid confusion.
6. Did I implement the other functions correctly, giving credit for any code that you take from elsewhere?
      Mark out of 20:  20
      All the functions are functions I wrote and all are implemented correctly.
7. Did I obtain (and process) the input from the user in the correct format (dd/mm/yyyy), and deal with any invalid input properly?
       Mark out of 10: 8
        If they input an invalid date the program will tell them it is an invalid date
8. Does the program produce the output in the correct format (e.g. Monday, 25th December 2017)?
      Mark out of 10:  10
      The output is formatted as shown.
9. How well did I complete this self-assessment?
       Mark out of 5: 4
       Probably too generous.
Total Mark out of 100 (Add all the previous marks):93
*/ 
public class DayOfTheWeek {
	
	public static final int DAYS_IN_FEB_LEAP_YEAR = 29;
	public static final int DAYS_IN_FEB_NORMAL_YEAR = 28;
	public static final int DAYS_IN_APRIL_JUNE_SEP_NOV = 30;
	public static final int DAYS_IN_MOST_MONTHS = 31;
	
	public static final String NUMBER_ENDING_FOR_NUMBERS_ENDING_WITH_ONE_EXCEPT_11 = "st";
	public static final String NUMBER_ENDING_FOR_NUMBERS_ENDING_WITH_TWO_EXCEPT_12 = "nd";
	public static final String NUMBER_ENDING_FOR_NUMBERS_ENDING_WITH_THREE_EXCEPT_13 = "rd";
	public static final String NUMBER_ENDING_FOR_MOST_NUMBERS = "th";
	
	public static final String JANUARY = "January";
	public static final String FEBRUARY = "February";
	public static final String MARCH = "March";
	public static final String APRIL = "April";
	public static final String MAY = "May";
	public static final String JUNE = "June";
	public static final String JULY = "July";
	public static final String AUGUST = "August";
	public static final String SEPTEMBER = "September";
	public static final String OCTOBER = "October";
	public static final String NOVEMBER = "November";
	public static final String DECEMBER = "December";
	
	public static final String MONDAY = "Monday";
	public static final String TUESDAY = "Tuesday";
	public static final String WEDNESDAY = "Wednesday";
	public static final String THURSDAY = "Thursday";
	public static final String FRIDAY = "Friday";
	public static final String SATURDAY = "Saturday";
	public static final String SUNDAY = "Sunday";
	
	
	
	
	
	public static void main(String[] args) {
		try
		{
			String input = JOptionPane.showInputDialog ("Enter a date in the form dd/mm/yyyy.");
			Scanner inputScanner = new Scanner(input);
			inputScanner.useDelimiter("/");
			int day = inputScanner.nextInt();
			int month = inputScanner.nextInt();
			int year = inputScanner.nextInt();
			
	
			
	
			
			if (validDate (year, month, day))
			{
				JOptionPane.showMessageDialog (null, dayOfTheWeek(day, month, year) + ", " + day + numberEnding(day) + " " +monthName(month) + " " + year + ".");
			}
			else 
			{ 
				JOptionPane.showMessageDialog(null, "This is not a valid date");
			}
			inputScanner.close();
		}
		catch (NullPointerException exception)
		{
		}
		catch (java.util.NoSuchElementException exception)
		{
			JOptionPane.showMessageDialog(null, "No number entered.",
					"Error", JOptionPane.ERROR_MESSAGE);
		}
		// TODO Auto-generated method stub

	}
	
	public static boolean isLeapYear (int year)
	{ 
		return ((year %4 ==0) && (year %100!=0) || (year%400==0))? true : false;
	}
	
	 public static int daysInMonth (int month, int year)
	 { 
		 int numberOfDaysInMonth =DAYS_IN_MOST_MONTHS;
		 switch(month)
		 {
		 case 2: 
			 numberOfDaysInMonth = (isLeapYear(year))? DAYS_IN_FEB_LEAP_YEAR : DAYS_IN_FEB_NORMAL_YEAR;	 
			 break;
		 case 4:
		 case 6:
		 case 9:
		 case 11:
			 numberOfDaysInMonth = DAYS_IN_APRIL_JUNE_SEP_NOV ;
			 break;
		 default: 
			 numberOfDaysInMonth = DAYS_IN_MOST_MONTHS;		
			 break;
		 }
		 return numberOfDaysInMonth;
	 }
	 
	 public static boolean validDate (int year, int month, int day)
	 {
		 boolean validYear = true;
		 boolean validMonth = true;
		 boolean validDay = true;
		 
		 if (year >0 ) validYear = true;
		 else validYear = false;
		 if (month >= 1 && month <=12) validMonth = true;
		 else validMonth = false;
		 if (day >= 1 && day <= daysInMonth(month, year)) validDay = true;
		 else validDay = false;
		 
		 return (validYear && validMonth && validDay)? true: false;
	 }
	 
	 public static String numberEnding (int day)
	 {
		 String numberSuperscript = "th";
		 switch (day)
		 { 
		 case 1: 
		 case 21:
		 case 31:
			 numberSuperscript= NUMBER_ENDING_FOR_NUMBERS_ENDING_WITH_ONE_EXCEPT_11 ;
			 break;
		 case 2 : 
		 case 22:
			 numberSuperscript= NUMBER_ENDING_FOR_NUMBERS_ENDING_WITH_TWO_EXCEPT_12;
			 break;
		 case 3: 
		 case 23:
			 numberSuperscript= NUMBER_ENDING_FOR_NUMBERS_ENDING_WITH_THREE_EXCEPT_13;
			 break;
		 default: 
			 numberSuperscript= NUMBER_ENDING_FOR_MOST_NUMBERS; 
			 break;
		 }
		 return numberSuperscript;
	 }
	 
	 public static String monthName (int month)
	 {
		 String nameToReturn = "January";
		 switch (month)
		 { 
		 case 1 :
			 nameToReturn = JANUARY;
			 break;
		 case 2 : 
			 nameToReturn = FEBRUARY;
			 break;
		 case 3 :
			 nameToReturn = MARCH ; 
			 break;
		 case 4 : 
			 nameToReturn = APRIL;
			 break;
		 case 5 :
			 nameToReturn = MAY;
			 break;
		 case 6:
			 nameToReturn = JUNE;
			 break;
		 case 7:
			 nameToReturn = JULY;
			 break;
		 case 8: 
			 nameToReturn = AUGUST;
			 break;
		 case 9: 
			 nameToReturn = SEPTEMBER;
			 break;
		 case 10:
			 nameToReturn = OCTOBER;
			 break;
		 case 11: 
			 nameToReturn = NOVEMBER;
			 break;
		 case 12:
			 nameToReturn = DECEMBER;
			 break;
		 default:
			 nameToReturn = "Error";
			 break;
		 }
		 return nameToReturn;
	 }
	 
	 public static String dayOfTheWeek (int day, int month, int year)
	 {
		 int Y = (month ==1 || month ==2)? year -1 : year;
		 int y = Y % 100;
		 int c = Y / 100 ;
		 int w  = (int) Math.abs((day + Math.floor(2.6 * ((( month + 9) % 12 )+1)- 0.2) + y + Math.floor(y / 4 ) + Math.floor(c/4) -(2 * c) ) % 7);
		 String dayName = SUNDAY;
		 switch (w)
		 {
		 case 0:
			 dayName = SUNDAY;
			 break;
		 case 1:
			 dayName = MONDAY;
			 break;
		 case 2: 
			 dayName = TUESDAY;
			 break;
		 case 3: 
			 dayName = WEDNESDAY;
			 break;
		 case 4:
			 dayName = THURSDAY;
			 break;
		 case 5: 
			 dayName = FRIDAY;
			 break;
		 case 6: 
			 dayName = SATURDAY;
			 break;
		 }
		 return dayName;
	 }

	

}
