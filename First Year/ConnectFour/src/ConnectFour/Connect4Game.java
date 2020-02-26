package ConnectFour;

import javax.swing.JOptionPane;
/* SELF ASSESSMENT

Connect4Game class (35 marks)35
My class creates references to the Connect 4 Grid and two Connect 4 Players. It asks the user whether he/she would like to play/quit inside a loop. If the user decides to play then: 1. Connect4Grid2DArray is created using the Connect4Grid interface, 2. the two players are initialised - must specify the type to be ConnectPlayer, and 3. the game starts. In the game, I ask the user where he/she would like to drop the piece. I perform checks by calling methods in the Connect4Grid interface. Finally a check is performed to determine a win. 
Comment:I create references to the players as human players or one human one AI depending on the option chosen bythe user from the joption pane option dialog.there is a loop that runs until the user decides to quit the program. Inside that loop there is a main if and else if that decides whther the user is playing single or two player mode. Inside each of these is a while loop that operates until the game is over ie when the board isnt full and four hasnt been connected. I ask the user to play a piece and check if it is valid by using theinterface method implemented in the 2d array class.

Connect4Grid interface (10 marks)10
I define all 7 methods within this interface.
Comment:I define all 7 abstract methods in the interface as per the assignment specifications.

Connect4Grid2DArray class (25 marks) 25
My class implements the Connect4Grid interface. It creates a grid using a 2D array Implementation of the method to check whether the column to drop the piece is valid. It provides as implementation of the method to check whether the column to drop the piece is full. It provides as implementation of the method to drop the piece.  It provides as implementation of the method to check whether there is a win.
Comment:My class implements all the methods of the interface and also has a constructor to create an empty 2d array of 6 rows and 7 columns

ConnectPlayer abstract class (10 marks)10
My class provides at lest one non-abstract method and at least one abstract method. 
Comment:I have an abstarct method for a player to drop a piece and i have a concrete methid to allow a player to restart the game by cleariing the board. There is also a public int of player piece attacthe to this class so all player types will have a player piece associated wih them

C4HumanPlayer class (10 marks)10
My class extends the ConnectPlayer claas and overrides the abstract method(s). It provides the Human player functionality.
Comment:the human player class overrides the abstract class and has aconstructor to create a new human player with their chosen player puiece

C4RandomAIPlayer class (10 marks)10
My class extends the ConnectPlayer claas and overrides the abstract method(s). It provides AI player functionality. 
Comment:the AI player class overrides the abstract method to drop  a piece by choosing a column that has empty space in it and also has a contructor that takes the chosen player piece as a parameter

Total Marks out of 100:100

*/

public class Connect4Game {

	public static void main(String[] args) {

		boolean playing = false;
		boolean gameFinished;
		int play = JOptionPane.showConfirmDialog(null, "Welcome to Connect Four! Do you wish to play?", null,
				JOptionPane.YES_NO_OPTION);
		if (play == JOptionPane.YES_OPTION)
			playing = true;
		else if (play == JOptionPane.CLOSED_OPTION || play == JOptionPane.NO_OPTION)
			playing = false;

		while (playing) {
			gameFinished = false;
			String[] options = { "Single", "Two Player" };
			int playerMode = JOptionPane.showOptionDialog(null, "Do you wish to play single or multiplayer?",
					"Choose an option", JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, options,
					"Single");

			if (playerMode == 0) { // single mode chosen
				Connect42DArray grid = new Connect42DArray();
				grid.emptyGrid();
				C4HumanPlayer player1 = new C4HumanPlayer(1);
				C4RandomAIPlayer computerPlayer = new C4RandomAIPlayer(3);
				JOptionPane.showMessageDialog(null,
						"You play with a 1 and the computer plays with a 3. \n Player 1 goes first. \n Good luck!");

				while (!gameFinished) {
					String userInput = JOptionPane.showInputDialog(null,
							grid.toString() + " \n Please enter the column number wher you want to place your piece.");
					if (userInput == null)
						gameFinished = true;
					else {
						int col = Integer.parseInt(userInput);
						if (grid.isValidColumn(col)) {
							grid.dropPiece(player1, col);

							if (!grid.didLastPieceConnect4() && !grid.isGridFull()) {
								// computer plays
								boolean played = false;
								while (!played) {
									int colum = (int) Math.floor(Math.random() * 10);
									if (colum < 7 && colum > 0 && grid.isValidColumn(colum)) {
										computerPlayer.playPiece(grid, colum);
										played = true;
									}
								}

							}
							JOptionPane.showMessageDialog(null, grid.toString() + "Computer has played");

							if (grid.didLastPieceConnect4())
								gameFinished = true;
							if (grid.isGridFull())
								gameFinished = true;
							else {
								gameFinished = true;
							}
						}

						else {
							JOptionPane.showMessageDialog(null, "Error. Not a valid Column.");
						}
					}

					if (grid.didLastPieceConnect4()) {
						String winner = null;
						if (grid.grid[grid.lastRow][grid.lastColumn] == 1) {
							winner += "Player 1 has won the game. Congrats!";

						} else {
							winner += "Player 1 has lost the game!";
						}
						JOptionPane.showMessageDialog(null, winner);
					} else if (grid.isGridFull()) {
						String result = "The board is full. Game Over!";
						JOptionPane.showMessageDialog(null, result);
					}
				}
			}
			//TWO PLAYER MODE
			else if (playerMode == 1) {
				Connect42DArray grid = new Connect42DArray();
				grid.emptyGrid();
				C4HumanPlayer player1 = new C4HumanPlayer(1);
				C4HumanPlayer player2 = new C4HumanPlayer(2);
				int currentPlayer = 1;
				JOptionPane.showMessageDialog(null,
						"Player 1 plays with a 1 and player 2 plays with a 2. \n Player 1 goes first. \n Good luck!");

				while (!gameFinished) {
					currentPlayer = 1;
					String userInput = JOptionPane.showInputDialog(null, grid.toString() + " \n Player" + currentPlayer
							+ ", Please enter the column number wher you want to place your piece.");
					if (userInput == null)
						gameFinished = true;
					else {
						int col = Integer.parseInt(userInput);
						grid.dropPiece(player1, col);
					}
					if (!grid.didLastPieceConnect4() && !grid.isGridFull()) {
						currentPlayer = 2;
						String userInput2 = JOptionPane.showInputDialog(null,
								grid.toString() + "\n Player" + currentPlayer
										+ " \n, Please enter the column number wher you want to place your piece.");
						if (userInput2 == null)
							gameFinished = true;
						else {
							int col2 = Integer.parseInt(userInput);
							grid.dropPiece(player2, col2);
						}
						// gameFinished = (grid.didLastPieceConnect4() || grid.isGridFull());
						if (grid.didLastPieceConnect4())
							gameFinished = true;
						if (grid.isGridFull())
							gameFinished = true;
					} else {
						gameFinished = true;
					}

				}
				if (grid.didLastPieceConnect4()) {
					String winner = null;
					if (grid.grid[grid.lastRow][grid.lastColumn] == 1) {
						winner += "Player 1 has won the game. Congrats!";

					} else {
						winner += "Player 2 has won the game!";
					}
					JOptionPane.showMessageDialog(null, winner);
				} else if (grid.isGridFull()) {
					String result = "The board is full. Game Over!";
					JOptionPane.showMessageDialog(null, result);
				}
			}

			String[] endOptions = { "Play Again", "Quit" };
			int endOpt = JOptionPane.showOptionDialog(null, "Do you wish to play again?", null,
					JOptionPane.YES_NO_OPTION, JOptionPane.INFORMATION_MESSAGE, null, endOptions, "Play Again");
			if (endOpt == 0)
				playing = true;
			else
				playing = false;

		}
	}
}
