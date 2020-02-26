import java.util.Random;
import java.util.Scanner;

/* SELF ASSESSMENT 
1. Did I use appropriate CONSTANTS instead of numbers within the code? 
    Mark out of 5:5 
    Comment: I set constants for the picture cards, and set constants for the three possible 
    		answers to ensure the strings for the user answer and the correct answer would match
2. Did I use easy-to-understand, meaningful CONSTANT names formatted correctly in UPPERCASE? 
    Mark out of 5:5
    Comment: I used the names of the cards and the three possible user answers for the constant names, 
    		and the constant names are formatted in upper case.
3. Did I use easy-to-understand meaningful variable names? 
    Mark out of 10:10
    Comment:  All variable names are self explanatory.
4. Did I format the variable names properly (in lowerCamelCase)? 
    Mark out of 5:5
    Comment:  All variable names are properly formatted in lowerCamelCase.
5. Did I indent the code appropriately? 
    Mark out of 10:10
    Comment:  The code is indented correctly to show the structure of the code.
6. Did I use an appropriate loop to allow the user to enter their guesses until they win or lose? 
    Mark out of 20: 20
    Comment:  The loop allows the user to keep guessing provided they have inputed one of three answers,
     		and that their correct guesses does not exceed 4 and that they have not incorrectly guessed.
7. Did I check the input to ensure that invalid input was handled appropriately? 
    Mark out of 10: 8
    Comment:  If anything other than higher, lower or equal is inputed an error message is shown and the program restarts.
8. Did I generate the cards properly using random number generation (assuming all cards are equally likely each time)? 
    Mark out of 10: 10
    Comment:  I used a random number generator to generate a random number between 0 and 12 and then added 1 to ensure 
    		the numbers generated were between 1 and 13, i.e. the number of cards in a suit
9. Did I output the cards correctly as 2, 3, 4, ... 9, 10, Jack, Queen, King? 
    Mark out of 10: 10
    Comment:  all cards outputted had the correct name.
10. Did I report whether the user won or lost the game before the program finished? 
    Mark out of 10:10
    Comment:  The user was told if they won or lost once they had either 4 correct guesses or an incorrect guess.
11. How well did I complete this self-assessment? 
    Mark out of 5:4
    Comment:  I am perhaps a bit generous with the marks.
Total Mark out of 100 (Add all the previous marks): 97
*/
public class HiLoGame {
	
	public static final int KING = 13;
	public static final int QUEEN = 12;
	public static final int JACK = 11;
	public static final int ACE =1;
	public static final String LOWER = "lower";
	public static final String HIGHER ="higher";
	public static final String EQUAL ="equal";

	public static void main(String[] args) {
		
		int correctGuesses = 0;
		int incorrectGuesses =0;
		String correctAnswer = "higher";
		String userAnswer = "lower";
		
		Random cardGenerator = new Random();
		int oldCard = ((cardGenerator.nextInt(13)) + 1);
		if (oldCard == ACE) 
			System.out.println("The card is an ace.");
		if (oldCard==JACK)
			System.out.println("The card is a jack.");
		if (oldCard == QUEEN) 
			System.out.println ("The card is a queen.");
		if (oldCard ==KING) 
			System.out.println ("The card is a king.");
		else if (oldCard >= 2 && oldCard <= 10)
			System.out.println("The card is a " + oldCard +".");

		System.out.println("Do you think the next card will be higher, lower or equal?");
		Scanner input = new Scanner (System.in);
		if (input.hasNext("lower") || input.hasNext("higher") || input.hasNext("equal"))
		{
			if (input.hasNext("lower"))
				userAnswer = LOWER;
			if (input.hasNext("higher"))
				userAnswer = HIGHER;
			if (input.hasNext("equal"))
				userAnswer = EQUAL;
		}
		else 
		{ 
			System.out.println("Error: Invalid Input entered. Please enter either higher, lower or equal.");
			main (null);
		}
		
		
		
		while (correctGuesses <= 3  && incorrectGuesses < 1)
		{ 
			cardGenerator = new Random ();
			int newCard = ((cardGenerator.nextInt(13)) + 1);
			if (oldCard> newCard) 
			{
				correctAnswer = LOWER;
			}
			else if (oldCard == newCard) 
			{
				correctAnswer = EQUAL;
			}
			else if (oldCard < newCard)
			{
				correctAnswer = HIGHER;
			}
			
			
			if(userAnswer == correctAnswer)
			{
				correctGuesses ++;
				oldCard=newCard;
				if (newCard ==KING) 
					System.out.println ("The card is a king.");
				if (newCard == QUEEN)
					System.out.println("The card is a queen.");
				if (newCard ==JACK)
					System.out.println("The card is a jack.");
				if (newCard == ACE )
					System.out.println("The card is an ace.");
				else if (newCard >= 2 && newCard <= 10)
					System.out.println("The card is a " + newCard);
				
				
				System.out.println("Do you think the next card will be higher, lower or equal?");
				input = new Scanner (System.in);
				if (input.hasNext("lower") || input.hasNext("higher") || input.hasNext("equal"))
				{
					if (input.hasNext("lower"))
					{
						userAnswer = LOWER;
						System.out.println ("answer =" + userAnswer);
					}
					if (input.hasNext("higher"))
					{
						userAnswer = HIGHER;
						System.out.println ("answer =" + userAnswer);
					}
					if (input.hasNext("equal"))
					{
						userAnswer = EQUAL;
						System.out.println ("answer =" + userAnswer);
					}
				}
				else 
				{ 
					System.out.println("Error: Invalid Input entered. Please enter either higher, lower or equal.");
					main (null);
				}			
				
			}
			else if (userAnswer != correctAnswer) 
			{ 
				incorrectGuesses ++;
				if (newCard ==KING) 
					System.out.println ("Hard Luck. The card is a king.");
				if (newCard == QUEEN)
					System.out.println("Hard Luck. The card is a queen.");
				if (newCard ==JACK)
					System.out.println("Hard Luck. The card is a jack.");
				if (newCard == ACE )
					System.out.println("Hard Luck. The card is an ace.");
				else if (newCard >=2 && newCard <= 10)
					System.out.println("Hard Luck. The card is " + newCard);
				incorrectGuesses ++;
			}
			
			
		}
		if (correctGuesses == 4)
			System.out.println("Congratulations, you got them all correct!");
		else if (incorrectGuesses >= 1)
			System.out.println ("You lost the game.");
			

	}
	
}


