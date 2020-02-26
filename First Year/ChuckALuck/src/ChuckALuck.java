
import java.util.Scanner;
/* SELF ASSESSMENT 

1. ResolveBet

I have correctly defined ResolveBet which takes the bet type (String) and the Wallet object, and a void return type [Mark out of 7: 7].
Comment:the function header defines a void return type and takes in the bet type as a string and the users wallet
My program presents the amount of cash in the wallet and asks the user how much he/she would like to bet [Mark out of 8: 8].
Comment:i use the check() method from the wallet class to display the current cash in the wallet and ask the user to determine a bet amount
My program ensures the bet amount is not greater than the cash in the wallet [Mark out of 5:5 ].
Comment:I use the wallet get() method in an if statement to update the wallet contents and also return if it is possible to make the bet
My program creates three Dice objects, rolls them and creates a total variable with a summation of the roll values returned [Mark out of 15:15 ]..
Comment:I empoly the dice roll  methods which return the top face to the main. I then create an int total
My program determines the winnings by comparing the bet type with the total and comparing the bet type with the dice faces for the triple bet [Mark out of 20:20 ].
Comment:I call a method for each of the bet types to determine of you've won the bet and then call a winnings function to calculate the winnings and update the wallet
My program outputs the results (win or loss) and adds the winnings to the wallet if user wins or removes the bet amount from the wallet if the user loses [Mark out of 10: ].
Comment:I print to the console if youv'e won or lost and update the wallet with winnings from the winnings method. If the player loses i deduct the bet amount from the wallet contents

2. Main

I ask the user for the amount of cash he/she has, create a Wallet object and put this cash into it [Mark out of 15: 15]
Comment:I print to the console to ask for cash and use a scanner to take it in. I use the unparameterised wallet constructor to create a wallet object and then use the put() method to put the money into it
My program loops continuously until the user either enters quit or the cash in the wallet is 0 [Mark out of 5:5 ]
Comment:A boolean playing is set to false if the wallet goes to zero or if the user enters exit as the while loop condition is this boolean.
I ask the user to enter any of the four bet types or quit [Mark out of 5:5 ].
Comment:the console is used to ask the user for a bet type and they are told the bet types and to enter exit to quit. again the scanner is used to take in this bet type as a string
My program calls resolveBet for each bet type entered [Mark out of 5:5 ].
Comment:the bet type strings are passed as parameters to the resolve bet function
At the end of the game my program presents a summary message regarding winnings and losses [Mark out of 5: 5]
Comment:my main calls a function overallSummary which prints the overall loss or win of the player to the console directly 

 Total Mark out of 100 (Add all the previous marks):100
*/

public class ChuckALuck {

	public static void main(String[] args) {
		boolean playing = true;
		boolean playedOnce = false;
		String betType = null;
		double userInitialCash = 0;
		Wallet userWallet = new Wallet();

		System.out.println("Welcome to Chuck a Luck! How much money do you have today?");
		Scanner input = new Scanner(System.in);

		userInitialCash = input.nextDouble();
		userWallet.put(userInitialCash);

		if (userWallet.check() > 0) {
			System.out.println(
					"The four bet types are triple, field, low or high.Please enter a bet type to play or type 'exit' to quit.");
			betType = input.next();
			if (betType.equals("exit"))
				playing = false;
			else if (!betType.equals("triple") && !betType.equals("field") && !betType.equals("low")
					&& !betType.equals("high")) {
				System.out.println("Error: Invalid bet type");
				System.out.println("Please enter a bet type to play or type 'exit' to quit.");
				betType = input.next();
			}

		} else
			playing = false;

		while (playing) {
			if (userWallet.check() > 0) {
				resolveBet(betType, userWallet);
				playedOnce = true;
				System.out.println("Please enter a bet type to play again or type 'exit' to quit.");
				betType = input.next();
				if (betType.equals("exit"))
					playing = false;
				else if (!betType.equals("triple") && !betType.equals("field") && !betType.equals("low")
						&& !betType.equals("high")) {
					System.out.println("Error: Invalid bet type");
					System.out.println("Please enter a bet type to play or type 'exit' to quit.");
					betType = input.next();
				}
			} else
				playing = false;

		}

		if (userWallet.check() <= 0) {
			System.out.println("You have no money left in your wallet!");
			overallSummary(userInitialCash, userWallet);

		} else {
			if (playedOnce)
				overallSummary(userInitialCash, userWallet);
			System.out.println("Goodbye!");

		}
	}

	// TODO Auto-generated method stub

	public static void resolveBet(String betType, Wallet userWallet) {
		double currentCash = userWallet.check();
		System.out.println("You curently have " + currentCash + " cash dollaz in your wallet. How much would you like to bet?");
		Scanner betChecker = new Scanner(System.in);
		Double betAmount = betChecker.nextDouble();
		boolean win = false;
		if (userWallet.get(betAmount)) // if (betAmount<= currentCash)
		{
			// create and roll dice
			Dice dice1 = new Dice();
			Dice dice2 = new Dice();
			Dice dice3 = new Dice();
			int dice1Result = dice1.roll();
			int dice2Result = dice2.roll();
			int dice3Result = dice3.roll();
			int total = dice1Result + dice2Result + dice3Result;
			// check if won
			if (betType.equals("triple")) {
				win = triple(dice1Result, dice2Result, dice3Result);
			} else if (betType.equals("field")) {
				win = field(total);
			} else if (betType.equals("high")) {
				win = high(dice1Result, dice2Result, dice3Result);
			} else if (betType.equals("low")) {
				win = low(dice1Result, dice2Result, dice3Result);
			}
			// calculate winnings and update wallet
			if (win) {
				System.out.println("You win!");
				double userWinnings = winnings(betType, betAmount);
				userWallet.put(userWinnings);
			}
			// calculate loss and update wallet
			else if (!win) {
				System.out.println("You lost!");

			}
		}
		else System.out.println ("You don't have that much!");

	}

	public static double winnings(String betType, double betAmount) {
		double winnings;
		if (betType.equals("triple")) {
			winnings = betAmount + (betAmount * 30);
		} else
			winnings = betAmount;
		return winnings;
	}

	public static boolean field(int total) {
		if (total < 8 || total > 12) {
			return true;
		} else
			return false;
	}

	public static boolean low(int dice1, int dice2, int dice3) {
		if (dice1 + dice2 + dice3 < 11 && (dice1 != dice2 || dice1 != dice3 || dice2 != dice3)) {
			return true;
		} else
			return false;
	}

	public static boolean high(int dice1, int dice2, int dice3) {
		if (dice1 + dice2 + dice3 > 10 && (dice1 != dice2 || dice1 != dice3 || dice2 != dice3)) {
			return true;
		} else
			return false;
	}

	public static boolean triple(int dice1, int dice2, int dice3) {
		if (dice1 == dice2 && dice1 == dice3 && dice1 != 1 && dice1 != 6) {
			return true;
		} else
			return false;
	}

	public static void overallSummary(double userInitialCash, Wallet userWallet) {
		double currentCash = userWallet.check();
		System.out.println("The game has ended!");
		if (userInitialCash > currentCash) {
			System.out.println("Overall you lost as you went from " + userInitialCash + " to " + currentCash);
		} else if (userInitialCash == currentCash) {
			System.out.println("You leave the game with the same amount of cash as you entered");
		} else {
			System.out.println("You have left the game with more money than when you entered");
		}
		System.out.println("Thank you for playing!");
	}

}
