package ConnectFour;

public abstract class ConnectPlayer {

	public int playerNumber;

	public abstract void playPiece(Connect42DArray grid, int column);
	
	public void restartGame(Connect42DArray grid) {
		grid.emptyGrid();
	}
}
