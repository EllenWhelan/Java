package ConnectFour;

public class Connect42DArray implements Connect4Grid {

	public int[][] grid;
	public int lastColumn;
	public int lastRow;

	public Connect42DArray() {
		grid = new int[6][7];
		lastColumn = 10;
		lastRow = 10;
	}

	public void emptyGrid() {
		for (int row = 0; row < 6; row++) {
			for (int column = 0; column < 7; column++) {
				grid[row][column] = 0;
			}
		}

	}

	public boolean isValidColumn(int column) {
		boolean validSpaceFound = false;
		int row = 5;
		while (!validSpaceFound) {
			if (grid[row][column] == 0) {
				validSpaceFound = true;
				return true;
			} else {
				row--;
			}
		}
		return false;

	}

	public void dropPiece(ConnectPlayer player, int column) {
		if(column!=0) column--; // array stuff
		if (isValidColumn(column)) {
			int row = 5;
			boolean dropped = false;
			while (!dropped) {
				if (grid[row][column] == 0) {
					grid[row][column] = player.playerNumber;
					dropped = true;
					lastRow = row;
					lastColumn = column;
				} else {
					row--;
				}

			}

		}
	}

	public boolean didLastPieceConnect4() {
		int playerNum = grid[lastRow][lastColumn];
		int winningChain = 0;
		// check row
		for (int column = 0; column < 7; column++) {
			if (grid[lastRow][column] == playerNum) {
				winningChain++;
				if (winningChain == 4) {
					return true;
				}
			}
		}
		winningChain = 0;
		// check column
		for (int row = 0; row < 6; row++) {
			if (grid[row][lastColumn] == playerNum) {
				winningChain++;
				if (winningChain == 4) {
					return true;
				}
			}
		}
		winningChain = 0;
		// check diagonal bottom right
		boolean chainFound = false;
		boolean exit = false;
		int row = lastRow;
		int column = lastColumn;

		while (row != 0 && column != 0) {
			row--;
			column--;
		}
		while (!chainFound && !exit) {
			if (grid[row][column] == playerNum && row < 6 && column < 7) {
				winningChain++;

				if (winningChain >= 4) {
					return true;
				} else if (row == 5 || column == 6) {
					exit = true;
				}
				if (row < 5 && row < 6) {
					row++;
					column++;
				}
			} else {
				if (winningChain > 0) {
					winningChain = 0;
					if (row < 5 && column < 6) {
						row++;
						column++;
					}
				} else {
					if (row < 5 && column < 6) {
						row++;
						column++;
					}
				}
				if (row == 5 && column == 6)
					exit = true;
			}
		}

		winningChain = 0;
		// check diagonal bottom left
		chainFound = false;
		exit = false;
		row = lastRow;
		column = lastColumn;

		while (row != 0 && column != 6) {
			row--;
			column++;
		}
		while (!chainFound && !exit) {
			if (grid[row][column] == playerNum && row < 6 && column >= 0) {
				winningChain++;
				
				if (winningChain >= 4) {
					return true;
				} else if (row == 5 || column < 0) {
					exit = true;
				}
				if(row<5 && column>0) {
					row++;
					column--;
				}

			} else {
				if (winningChain > 0) {
					winningChain = 0;
					if (row < 5 && column > 0) {
						row++;
						column--;
					}
				} else {
					if (row < 5 && column > 0) {
						row++;
						column--;
					}
				}
			}
		}

		return false;

	}

	public boolean isGridFull() {
		boolean isFull = true;
		int row = 0;
		while (row < 6 && isFull) {
			int column = 0;
			while (column < 7 && isFull) {
				if (grid[row][column] == 0) {
					isFull = false;
				}
				column++;
			}
			row++;

		}
		return isFull;
	}

	public String toString() {
		String gridDisplay = "Connect Four Grid";
		for (int row = 0; row < 6; row++) {
			gridDisplay += "\n";
			for (int col = 0; col < 7; col++) {
				gridDisplay += "[" + grid[row][col] + "]";
			}
		}
		return gridDisplay;
	}

}
