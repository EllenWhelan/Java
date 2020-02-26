
/* SELF ASSESSMENT 
   1. Did I use appropriate CONSTANTS instead of numbers within the code? 
       Mark out of 5: 4
       I only used one constant in the code for the number of verses but perhaps there are 
       more constants I could have used instead of numbers.
   2. Did I use easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE? 
       Mark out of 5: 5
       the constant is correctly formatted in upper case and has an easy to understand name.
   3. Did I use easy-to-understand meaningful variable names formatted properly (in lowerCamelCase)? 
       Mark out of 10: 10
       The variable names used are easy to understand and are all formatted correctly in lowerCamelCase.
   4. Did I indent the code appropriately? 
       Mark out of 10: 10
       The code is indented correctly to show the structure of the code clearly.
   5. Did I use an appropriate loop (or loops) to produce the different verses? 
       Mark out of 20:  20
       I used one for loop to build up the verses as I knew that the loop would only run
        twelve times for the twelve verses.
   6. Did I use a switch to build up the verses?
       Mark out of 25:  23
       I used a switch statement to correctly select the 'day of Christmas' for each verse based on the verse number.
        I then used a second switch statement to build up the lyrics to each verse. It may have been more efficient 
        to try and do one switch statement and build up the verses and the day in the same one.
   7. Did I avoid duplication of code and of the lines which make up the verses (each line should be referred to in the code only once (or twice))? 
       Mark out of 10:10
       Each line of the song is only referred to once in the code.  
   8. Does the program produce the correct output? 
       Mark out of 10:  10
       The program produces the verses of the song with the correct lyrics and in the right order.
   9. How well did I complete this self-assessment? 
       Mark out of 5: 4
       I was probably too nice to myself.
   Total Mark out of 100 (Add all the previous marks): 96
*/
public class TwelveDaysOfChristmas {
	
	public static final int VERSE_NUMBER = 12;

	public static void main(String[] args) {
		
		for( int verse= 1 ; (verse <= VERSE_NUMBER); verse++)
		{
			String output = ("");
			String day = ("");
			switch(verse)
			{
			case 1: 
					day= "first";
					break;
			case 2:
					day = "second";
					break;
			case 3 :
					day = "third";
					break;
			case 4 : 
					day = "fourth";
					break;
			case 5 :
					day= "fifth";
					break;
			case 6 :
					day = "sixth";
					break;
			case 7 :
					day = "seventh";
					break;
			case 8 :
					day = "eighth";
					break;
			case 9 :
					day = "ninth";
					break;
			case 10 : 
					day = "tenth ";
					break;
			case 11: 
					day = "eleventh";
					break;
			case 12:
					day= "twelfth";
					break;
			default:
					break;
			}
			output = ("On the " + day + " day of christmas, my true love gave to me ");
			
			switch (verse)
			{
			case 12: 
					output += "\n twelve drummers drumming, ";
			case 11:
					output+= "\n eleven pipers piping, ";
			case 10 :
					output+="\n ten lords a leaping, ";
			case 9: 
					output+= "\n nine ladies dancing, ";
			case 8 :
					output+="\n eight maids a milking, ";
			case 7 :
					output+="\n seven swans a swimming, ";
			case 6 :
					output+="\n six geese a laying, ";
			case 5 :
					output+="\n five gold rings, ";
			case 4 :
					output+="\n four calling birds, ";
			case 3 : 
					output+= "\n three french hens, ";
			case 2: 
					output+="\n two turtle doves, ";
			case 1:
					if (verse >1)
					output+=" and";
					output += "\n a partridge in a pear tree.";
				
			default:
					break;
			}
			
			System.out.println(output);	
		}
		

		// TODO Auto-generated method stub

	}

}