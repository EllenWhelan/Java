import java.util.Scanner;

import javax.swing.JOptionPane;
/* SELF ASSESSMENT 
1. clearBoard:
Did I use the correct method definition?
Mark out of 5:5
Comment:I used the correct return type of void to initialise the array without creating an uneccessary array.
Did I use loops to set each position to the BLANK character?
Mark out of 5:5
Comment: I used two for loops to set each position in the 2D array to a blank character which i set up a a constant.
2. printBoard
Did I use the correct method definition?
Mark out of 5:5
Comment:I used a void return type and took in the board array.
Did I loop through the array and prints out the board in a way that it looked like a board?
Mark out of 5:5
Comment:I used the '|' character and the '_' character to create the borders of the board and then used two for 
loops to loop through the rows and columns of the 3x3 array.
3. canMakeMove
Did I have the correct function definition and returned the correct item?
Mark out of 5:5
Comment:I correctly set the return type as a boolean and returned a boolean to the mainline. 
I also passed the board, currentPlayer piece and the row and column position as parameteres.
Did I check if a specified location was BLANK?
Mark out of 5:3
Comment:No instead i checked if a particular location had an 'x' or an 'o' and if it did I returned a false boolean
4. makeMove
Did I have the correct function definition?
Mark out of 5:5
Comment:I set a void return type and passed the board, currentPlayerPiece and the position defined by the user as parameters.
Did I set the  currentPlayerPiece in the specified location?
Mark out of 5:5
Comment:    I set the currentPlayerPiece into the correct location in the array.
5. isBoardFull
Did I have the correct function definition and returned the correct item?
Mark out of 5:5
Comment:i correctly returned a boolean to the mainline and passed the board as a parameter.       
Did I loop through the board to check if there are any BLANK characters?
Mark out of 5:5
Comment:I set up a boolean to true to say board is full and then looped through the array if any array space had a blank the boolean was
 set to false and that was returned. Else the boolean was kept true and that was returned to the main once all the array had been looped thriugh
6. winner
Did I have the correct function definition and returned the winning character
Mark out of 5:5
Comment: I returned the winning char to the main and passed the board, current player piece as parameters.
Did I identify all possible horizontal, vertical and diagonal winners  
Mark out of 15:15
Comment:I set up a large if statement to check all the possible combinations were equal to each other and that they equalled either an X or an O.
7.main

Did I create a board of size 3 by 3 and use the clearBoard method to set all the positions to the BLANK character ('  ')?
Mark out of 3:3
Comments:I created an array of 3x3 and correctly initialised all the spaces to the blank char.
Did I loop asking the user for a location until wither the board was full or there was a winner?
Mark out of 5:5
Comments:The loop loops until either Player x or o has won of if the board is full.
Did I call all of the methods above?
Mark out of 5:5
Comments:All methods created are called from the mainline.
Did I handle incorrect locations provided by the user (either occupied or invalid locations)?
Mark out of 3:3
Comments:If the space is occupied the user is told so and if its an invalid the user is told so and the loops begins again
Did I switch the current player piece from cross to nought and vice versa after every valid move?
Mark out of 3:3
Comments:At the end of the loop the player piece is switched
Did I display the winning player piece or a draw at the end of the game?
Mark out of 3:2
Comments:if there is a winner that is displayed if the board is full that is displayed as a draw

8. Overall
Is my code indented correctly?
Mark out of 3:3
Comments:The code is indented as per the standard
Do my variable names and Constants (at least four of them) make sense?
Mark out of 3:3
Comments:all my variable and constant names make sense
Do my variable names, method names and class name follow the Java coding standard
Mark out of 2:2
Comments:they all follow the standard
   Total Mark out of 100 (Add all the previous marks): 97
*/		
	

public class NoughtsAndCrosses {
	
	
	public static final char X = 'X';
	public static final char O = 'O';
	public static final char BLANK = ' ';
	
	
	
	public static void main(String[] args) {
		boolean winner = false;
		boolean fullBoard = false;
		boolean possibleMove=true;
		char winnerChar;
		int row;
		int column;
		char currentPlayerPiece = X;
		char[][] board = new char [3][3];
		
		clearBoard(board);
		printBoard(board);
		System.out.println ("Welcome! PlayerX is plaOing with 'X' and PlayerO is playing with 'O'. ");
		
		
		while (!fullBoard && !winner)
		{
			System.out.println("Player " + currentPlayerPiece + " Please enter a coordinate"
					+ " seperated bO a space according to the board displayed to place " + currentPlayerPiece + " somewhere on the board.");
			Scanner input = new Scanner(System.in);
			if(input.hasNextInt())
			{
			
				row = input.nextInt();
				column = input.nextInt();
				System.out.println(row + "," + column );
				possibleMove = canMakeMove(board, row, column);
				if (possibleMove)makeMove(board, currentPlayerPiece, row, column);
				else System.out.println("The space is occupied please try again.");
				fullBoard = isBoardFull(board);
				if (fullBoard)System.out.println("The board is full. It's a draw!.");
				winnerChar = winner(board, currentPlayerPiece);
				if (winnerChar == BLANK)winner = false;
				else if(winnerChar == X || winnerChar == O) 
					{
						winner = true;
						
						System.out.println("The winner is Player " + currentPlayerPiece);
					}
				printBoard(board);
				if (currentPlayerPiece == X && possibleMove)currentPlayerPiece = O;
				else if (currentPlayerPiece == O && possibleMove)currentPlayerPiece = X;
				
			}
			else System.out.println("Error: Enter a number 0,1 or 2 for the row and do the same for column.");
		
		}
		System.out.println("Thanks for playing!");
				
	}
	
	
	public static void clearBoard (char[][] board)
	{
		for (int row = 0; row < 3 ; row++)
		{
			for (int column = 0; column < 3; column++)
			{
				board[row][column] = BLANK;
			}
		}
			
	}
	
	public static void printBoard (char[][] board)
	{
		System.out.println( "     0  1  2");
		System.out.println("   ____________");
		System.out.println( " 0| " + board[0][0] + " | " + board [0][1] + " | " + board[0][2] + " | ");
		System.out.println("   ____________");
		System.out.println( " 1| " + board[1][0] + " | " + board [1][1] + " | " + board[1][2] + " | ");
		System.out.println("  _____________");
		System.out.println( " 2| " + board[2][0] + " | " + board [2][1] + " | " + board[2][2] + " | ");
		System.out.println("   ____________");
	}
	
	public static boolean canMakeMove (char[][] board, int row, int column)
	{
		if (board[row][column] == X || board[row][column] == O ) return false;
		else	return true;
	}
	
	public static void makeMove (char[][] board, char currentPlayerPiece, int row, int column)
	{
		board[row][column] = currentPlayerPiece;
		
	}
	
	public static boolean isBoardFull (char[][] board)
	{
		
		boolean fullBoard = true;
		for (int row = 0; row < 3 && fullBoard ; row++)
		{
			for (int column = 0; column < 3 && fullBoard; column++)
			{
				if (board[row][column] == BLANK) fullBoard = false;
			}
		}
		return fullBoard;
	}
	
	public static char winner (char[][] board,char currentPlayerPiece)
	{
		boolean winner = false;
		if (   ( (board[0][0] == board[0][1] && board [0][0] == board [0][2]) && (board[0][0] == X || board[0][0] == O)) || //first row
	           ( (board[1][0] == board[1][1] && board [1][0] == board [1][2]) && (board[1][0] == X || board[1][0] == O)) || //second row
	           ( (board[2][0] == board[2][1] && board [2][0] == board [2][2]) && (board[2][0] == X || board[2][0] == O)) || //third row
	           ( (board[0][0] == board[1][1] && board [0][0] == board [2][2]) && (board[0][0] == X || board[0][0] == O))|| //left diagonal
	           ( (board[0][2] == board[1][1] && board [0][2] == board [2][0]) && (board[0][2] == X || board[0][2] == O)) || //right diagonal
	           ( (board[0][0] == board[1][0] && board [0][0] == board [2][0]) && (board[0][0] == X || board[0][0] == O)) || //left column
	           ( (board[0][1] == board[1][1] && board [0][1] == board [2][1]) && (board[0][1] == X || board[0][0] == O)) || // middle column
	           ( (board[0][2] == board[1][2] && board [0][2] == board [2][2]) && (board[0][2] == X || board[0][2] == O)))   //right column
				{
				 winner = true;	
				}
		
		if (winner) return currentPlayerPiece;
		else return BLANK;
		
	}
	
	
	

}
